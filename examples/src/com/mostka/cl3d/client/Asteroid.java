package com.mostka.cl3d.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.media.client.Audio;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.RootPanel;
import com.mostka.cl3d.wraper.CL3D;
import com.mostka.cl3d.wraper.CopperLicht;
import com.mostka.cl3d.wraper.JsFunction;
import com.mostka.cl3d.wraper.animator.AnimatorRotation;
import com.mostka.cl3d.wraper.scene.CameraSceneNode;
import com.mostka.cl3d.wraper.scene.Scene;
import com.mostka.cl3d.wraper.scene.SceneNodeAbs;
import com.mostka.cl3d.wraper.util.Matrix4;
import com.mostka.cl3d.wraper.util.Vect3d;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Asteroid implements EntryPoint {

    public Audio playingMusic = null;
    public String currentlyPlayingMusicName = null;
    JsFunction onAnimate = new JsFunction() {
        @Override
        public JavaScriptObject execute(JavaScriptObject args) {
            if (GameState == "menu") {
                if (MainMenuCam != null) {
                    long now = new Date().getTime() - AppStartTime;
                    long t = (now + 5000) / 10000;
                    MainMenuCam.setTarget(Vect3d.create(Math.cos(t), 0, Math.sin(t)));
                }
            } else if (GameState == "game") {
                doGameLogic();
            }
            return null;
        }
    };
    // game state
    private long AppStartTime = 0;
    private long LastGameStartTime = 0;
    private long LastGameCalculationTime = 0;
    private String GameState = "menu";
    private Element GameTimeRemainingSpan = null;
    private Element GameScoreSpan = null;
    private int GameScore = 0;
    // 3d objects
    private CameraSceneNode MainMenuCam = null;
    private CameraSceneNode GameCam = null;
    private ArrayList<SceneNodeAbs> AsteroidTemplates = new ArrayList<SceneNodeAbs>();
    private SceneNodeAbs PhotonTemplate = null;
    private SceneNodeAbs SmokeTemplate = null;
    private ArrayList<SceneNodeAbs> Asteroids = new ArrayList<SceneNodeAbs>();
    private CopperLicht TheEngine = null;
    private ArrayList<SceneNodeAbs> MovingPhotons = new ArrayList<SceneNodeAbs>();
    private ArrayList<SceneNodeAbs> MovingAsteroids = new ArrayList<SceneNodeAbs>();
    private ArrayList<SceneNodeAbs> MovingSmokes = new ArrayList<SceneNodeAbs>();
    // keys
    private boolean leftKeyDown = false;
    private boolean rightKeyDown = false;
    private boolean upKeyDown = false;
    private boolean downKeyDown = false;
    private boolean enterKeyDown = false;
    private boolean spaceKeyDown = false;
    private boolean shiftKeyDown = false;
    // movement
    private double GameCamRelativeRotationX = 0;
    private double GameCamRelativeRotationY = 0;
    private double verticalLookMoveSpeed = 0;
    private double horizontalLookMoveSpeed = 0;
    private double movementSpeed = 0;
    // shooting
    private long LastShootTime = 0;
    private Randomizer gameRandomizer = new Randomizer();
    private boolean musicDisabled;
    private ArrayList playingSounds = new ArrayList();
    private RootPanel mainmenupanel;
    private RootPanel gamehud;
    private RootPanel infoplate;
    private RootPanel infoplatetext;
    private RootPanel loadingbutton;
    private RootPanel nowebglmessage;
    private RootPanel loadinglabel;

    public void onModuleLoad() {
        Anchor.wrap(RootPanel.get("startGame").getElement()).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                startGame();
            }
        });

        Anchor.wrap(RootPanel.get("showInfoPlate").getElement()).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                showInfoPlate("This game is just a programming prototype without any advanced graphics, to test out the CopperLicht 3D engine. Also, gameplay is very basic and very limited. This game was created within about 4 hours.");
            }
        });

        Anchor.wrap(RootPanel.get("disableMusic").getElement()).addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                disableMusic(!musicDisabled);
            }
        });

        Anchor a = Anchor.wrap(RootPanel.get("startMapLoading").getElement());
        a.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                startMapLoading();
            }
        });
        mainmenupanel = RootPanel.get("game_mainmenu");
        if (mainmenupanel != null)
            mainmenupanel.setVisible(false);

        GameTimeRemainingSpan = RootPanel.get("gametimeremaining").getElement();
        GameScoreSpan = RootPanel.get("gamescore").getElement();
        gamehud = RootPanel.get("gamehud");
        infoplatetext = RootPanel.get("infoplattext");
        infoplate = RootPanel.get("infoplate");
        loadingbutton = RootPanel.get("cl_loadingbutton");
        nowebglmessage = RootPanel.get("cl_nowebgl");
        loadinglabel = RootPanel.get("cl_loadinglabel");
    }

    // called each frame by the 3d engine
    /*public void onAnimate()
    {
        if (GameState == "menu")
        {
            if (MainMenuCam!=null)
            {
                long now = new Date().getTime() - AppStartTime;
                long  t = (now + 5000) / 10000;
                MainMenuCam.setTarget(Vect3d.create(Math.cos(t), 0, Math.sin(t)));
            }
        }
        else
        if (GameState == "game"){
            doGameLogic();
        }
    }*/
    public void createNewAsteroid(CopperLicht engine, int typenr, double x, double y, double z, double rsx, double rsy, double rsz) {
        Scene scene = engine.getScene();
        if (scene == null)
            return;
        if (AsteroidTemplates.size() == 0)
            return;

        SceneNodeAbs template = AsteroidTemplates.get(typenr);
        if (template != null) {
            SceneNodeAbs clone = template.createClone(scene.getRootSceneNode());
            clone.setPos(x, y, z);
            clone.setVisible(true);

            clone.addAnimator(AnimatorRotation.create(Vect3d.create(rsx, rsy, rsz)));

            MovingAsteroids.add(clone);
        }
    }

    public void createRandomAsteroidField(CopperLicht engine, int level) {
        int asteroidCount = 10 * level;
        double radius = 1000;
        int centerArea = 100;
        Randomizer r = new Randomizer();
        r.setSeed(level);

        for (int i = 0; i < asteroidCount; ++i) {
            double x = r.getRandf() * radius * 2 - radius;
            double y = r.getRandf() * radius * 2 - radius;
            double z = r.getRandf() * radius * 2 - radius;
            double rsx = r.getRandf() * 0.2 - 0.1;
            double rsy = r.getRandf() * 0.2 - 0.1;
            double rsz = r.getRandf() * 0.2 - 0.1;
            int type = (int) r.getRand() % AsteroidTemplates.size();

            createNewAsteroid(engine, type, x, y, z, rsx, rsy, rsz);
        }
    }

    public void collect3dObjectPrototypes(CopperLicht engine) {
        Scene scene = engine.getScene();

        if (scene == null)
            return;

        // collect all 3 asteroids

        for (int i = 0; i < 3; ++i) {
            SceneNodeAbs asteroid = scene.getSceneNodeFromName("asteroid" + (i + 1));
            if (asteroid != null) {
                AsteroidTemplates.add(asteroid);
                asteroid.setVisible(false);
            } else
                AsteroidTemplates.add(null);
        }

        // collect photon

        PhotonTemplate = scene.getSceneNodeFromName("photon");
        if (PhotonTemplate != null) {
            PhotonTemplate.setVisible(false);
        }

        // collect smoke

        SmokeTemplate = scene.getSceneNodeFromName("smoke");
        if (SmokeTemplate != null) {
            SmokeTemplate.setVisible(false);
        }
    }

    public void showInfoPlate(String text) {
        if (gamehud != null)
            gamehud.setVisible(false);

        if (mainmenupanel != null)
            mainmenupanel.setVisible(false);

        if (infoplate != null)
            infoplate.setVisible(true);

        if (infoplatetext != null)
            infoplatetext.getElement().setInnerHTML(text);

    }

    public void backToMainMenu() {
        GameState = "menu";

        showInfoPlate("Game ended. Your score:" + GameScore);

        playmusic("mainmenumusic");
    }

    public void clearScene() {
        // delete smokes

        for (int k = 0; k < MovingSmokes.size(); ) {
            SceneNodeAbs s = MovingSmokes.get(k);
            s.getParent().removeChild(s);
            MovingSmokes.remove(k);
            gameEndLiveTimeSmoke.remove(s);
            gameMoveDirSmoke.remove(s);
        }

        // delete photons

        for (int i = 0; i < MovingPhotons.size(); ) {
            SceneNodeAbs p = MovingPhotons.get(i);
            p.getParent().removeChild(p);
            MovingPhotons.remove(i);
            gameEndLiveTimePhotons.remove(p);
            gameMoveDirPhotons.remove(p);
        }

        // delete asteroids

        for (int j = 0; j < MovingAsteroids.size(); ++j) {
            SceneNodeAbs ast = MovingAsteroids.get(j);
            ast.getParent().removeChild(ast);
            MovingAsteroids.remove(j);
        }
    }

    public void startGame() {
        CopperLicht engine = TheEngine;
        if (gamehud != null)
            gamehud.setVisible(true);

        if (mainmenupanel != null)
            mainmenupanel.setVisible(false);


        GameScore = 0;
        GameCamRelativeRotationX = 0;
        GameCamRelativeRotationY = 0;
        verticalLookMoveSpeed = 0;
        horizontalLookMoveSpeed = 0;
        movementSpeed = 0;
        LastShootTime = 0;

        clearScene();
        createRandomAsteroidField(engine, 11);

        playmusic("gamemusic");

        Scene scene = engine.getScene();

        if (scene == null)
            return;

        // create game camera
        if (GameCam == null) {
            GameCam = CameraSceneNode.create();
            scene.getRootSceneNode().addChild(GameCam);

            // there is no camera, so probably also no keys registered yet

            addKeyHandler(this);
        }

        scene.setActiveCamera(GameCam);
        GameCam.setTarget(Vect3d.create(1, 1, 1));
        GameCam.setPos(0, 0, 0);

        GameState = "game";
        LastGameCalculationTime = new Date().getTime();
        LastGameStartTime = LastGameCalculationTime;
    }

    public void handleKeyDown(int keyCode) {
        setKeyBool(true, keyCode);
    }

    public void handleKeyUp(int keyCode) {
        setKeyBool(false, keyCode);
    }

    public final native void addKeyHandler(Asteroid self) /*-{
        $wnd.document.onkeydown = function (event) {
            self.@com.mostka.cl3d.client.Asteroid::handleKeyDown(I)(event.keyCode);
        }
        $wnd.document.onkeyup = function (event) {
            self.@com.mostka.cl3d.client.Asteroid::handleKeyUp(I)(event.keyCode);
        }
    }-*/;

    public void setKeyBool(boolean down, int code) {
        // 37 = left arrow key
        // 38 = up arrow key
        // 39 = right arrow key
        // 40 = down arrow key
        // 65 = a or A
        // 87 = w or W
        // 68 = d or D
        // 83 = s or S
        switch (code) {
            case 37:
            case 65:
                leftKeyDown = down;
                break;
            case 39:
            case 68:
                rightKeyDown = down;
                break;
            case 38:
            case 87:
                upKeyDown = down;
                break;
            case 40:
            case 83:
                downKeyDown = down;
                break;
            case 13:
                enterKeyDown = down;
                break;
            case 32:
                spaceKeyDown = down;
                break;
            case 18: //alt
            case 17: // ctrl
            case 9: // tab
            case 16:
                shiftKeyDown = down;
                break;
            case 27:
                if (GameState == "game") backToMainMenu();
                break;
        }
    }

    public void startMapLoading() {
        // hide loading button
        if (loadingbutton != null)
            loadingbutton.setVisible(false);

        final CopperLicht engine = CopperLicht.create("3darea", true, 30);
        TheEngine = engine;

        if (!engine.initRenderer()) {Window.alert("cl_nowebgl");
            // no webgl, show warning message
            if (nowebglmessage != null)
                nowebglmessage.setVisible(true);
            return;
        }

        // show loading text
        if (loadinglabel != null)
            loadinglabel.setVisible(true);

        // start loading
        engine.load("/images/copperlichtdata/scene1.ccbjs");

        engine.setOnLoadingComplete(new JsFunction() {
            @Override
            public JavaScriptObject execute(JavaScriptObject args) {
                // record game starting time for deteministic behavior
                AppStartTime = new Date().getTime();

                // hide loading display

                if (loadinglabel != null)
                    loadinglabel.setVisible(false);

                // register animation public void

                engine.setOnAnimate(onAnimate);

                // show main menu, start menu music

                collect3dObjectPrototypes(engine);
                createRandomAsteroidField(engine, 10);

                playmusic("mainmenumusic");
                if (mainmenupanel != null){
                    mainmenupanel.setVisible(true);
                }else{
                    Window.alert("game_mainmenu is null");
                }

                Scene scene = engine.getScene();

                if (scene != null) {
                    // create a camera for the main menu, rotating through the scene
                    MainMenuCam = CameraSceneNode.create();
                    MainMenuCam.setTarget(Vect3d.create(1, 1, 1));
                    scene.getRootSceneNode().addChild(MainMenuCam);
                    scene.setActiveCamera(MainMenuCam);
                    scene.setBackgroundColor(CL3D.createColor(255, 0, 0, 0));
                }else {
                    Window.alert("scene is null");
                }
                return null;
            }
        });
    }

    public double decceleratevalue(long timeDiff, double value, double deceleratefact, int maxspeed) {
        double p = deceleratefact * timeDiff;

        if (value < 0) {
            value += p;
            if (value > 0) value = 0;
        } else if (value > 0) {
            value -= p;
            if (value < 0) value = 0;
        }

        if (value > maxspeed)
            value = maxspeed;
        if (value < -maxspeed)
            value = -maxspeed;

        return value;
    }

    public double normalizeAngle(double angle) {
        if (angle < 0.0)
            angle += 360.0;
        if (angle >= 360.0)
            angle -= 360.0;

        return angle;
    }

    public void doCameraMovement(long timeDiff) {
        if (GameCam == null)
            return;

        double accelspeed = 0.10 * timeDiff;
        if (enterKeyDown || shiftKeyDown)
            movementSpeed += accelspeed;

        movementSpeed = decceleratevalue(timeDiff, movementSpeed, 0.03, 20);

        Vect3d moveDir = GameCam.getTarget().substract(GameCam.getPos()).multiplyWithScal((int) movementSpeed);
        GameCam.setPos(GameCam.getPos().add(moveDir));
        GameCam.setTarget(GameCam.getTarget().add(moveDir));
        GameCam.updateAbsolutePosition();
    }

    public void doCameraLookMovement(long timeDiff) {
        if (GameCam == null)
            return;

        // accelerate/desellerate look movement:
        double accelspeed = 0.10 * timeDiff;
        if (upKeyDown)
            verticalLookMoveSpeed += accelspeed;
        if (downKeyDown)
            verticalLookMoveSpeed -= accelspeed;
        if (leftKeyDown)
            horizontalLookMoveSpeed -= accelspeed;
        if (rightKeyDown)
            horizontalLookMoveSpeed += accelspeed;

        verticalLookMoveSpeed = decceleratevalue(timeDiff, verticalLookMoveSpeed, 0.03, 20);
        horizontalLookMoveSpeed = decceleratevalue(timeDiff, horizontalLookMoveSpeed, 0.03, 20);

        // constants:
        double RotateSpeed = 200.0;
        double MaxVerticalAngle = 88.0;

        // start calculating:
        Vect3d target = Vect3d.create(0, 0, 1);
        Matrix4 mat = Matrix4.create();
        mat.setRotationDegrees(Vect3d.create(GameCamRelativeRotationX, GameCamRelativeRotationY, 0));
        mat.transformVect(target);

        // move lookat target up / down

        double maxdiff = 300; // to limit the maximum diff in pixels
        double ydiff = 0;
        double RotateSpeedFactX = 1 / 50000.0;
        double RotateSpeedFactY = 1 / 50000.0;

        //if (this.ExactRotation)
        //	RotateSpeedFact *= 3.0;

        if (verticalLookMoveSpeed !=0)
            ydiff = verticalLookMoveSpeed;

        if (ydiff > maxdiff) ydiff = maxdiff;
        if (ydiff < -maxdiff) ydiff = -maxdiff;
        GameCamRelativeRotationX += ydiff * (timeDiff * (RotateSpeed * RotateSpeedFactY));

        if (GameCamRelativeRotationX < -MaxVerticalAngle)
            GameCamRelativeRotationX = -MaxVerticalAngle;
        if (GameCamRelativeRotationX > MaxVerticalAngle)
            GameCamRelativeRotationX = MaxVerticalAngle;

        // move lookat target left / right

        double xdiff = 0;

        if (horizontalLookMoveSpeed!=0)
            xdiff = horizontalLookMoveSpeed;

        if (xdiff > maxdiff) xdiff = maxdiff;
        if (xdiff < -maxdiff) xdiff = -maxdiff;
        GameCamRelativeRotationY += xdiff * (timeDiff * (RotateSpeed * RotateSpeedFactX));

        // finally set target

        GameCam.setTarget(GameCam.getPos().add(target));
    }
    HashMap<SceneNodeAbs, Double> gameEndLiveTimeSmoke = new HashMap<SceneNodeAbs, Double>();
    HashMap<SceneNodeAbs,Vect3d> gameMoveDirSmoke = new HashMap<SceneNodeAbs, Vect3d>();
    HashMap<SceneNodeAbs, Long> gameEndLiveTimePhotons = new HashMap<SceneNodeAbs, Long>();
    HashMap<SceneNodeAbs,Vect3d> gameMoveDirPhotons = new HashMap<SceneNodeAbs, Vect3d>();

    public void addSmoke(int count, double radius, Vect3d center, long timeDiff, long now) {
        if (GameCam == null || SmokeTemplate == null)
            return;

        CopperLicht engine = TheEngine;
        Scene scene = engine.getScene();
        if (scene == null)
            return;

        for (int i = 0; i < count; ++i) {
            SceneNodeAbs clone = SmokeTemplate.createClone(scene.getRootSceneNode());
            clone.setPos(
                    center.getX() + (Math.random() * radius * 2) - radius,
                    center.getY() + (Math.random() * radius * 2) - radius,
                    center.getZ() + (Math.random() * radius * 2) - radius
            );
            clone.setVisible(true);

            gameEndLiveTimeSmoke.put(clone, now + (Math.random() * 2000));

            Vect3d moveDir = clone.getPos().substract(center);
            moveDir.normalize();
            gameMoveDirSmoke.put(clone, moveDir);

            MovingSmokes.add(clone);
        }
    }

    public void doShoot(long timeDiff, long now) {
        if (GameCam == null || !spaceKeyDown || PhotonTemplate == null)
            return;

        CopperLicht engine = TheEngine;
        Scene scene = engine.getScene();
        if (scene == null)
            return;

        if (LastShootTime == 0 || now - LastShootTime > 100) {
            LastShootTime = now;

            SceneNodeAbs clone = PhotonTemplate.createClone(scene.getRootSceneNode());
            clone.setPos(
                    GameCam.getPos().getX(),
                    GameCam.getPos().getY(),
                    GameCam.getPos().getZ()
            );
            clone.setVisible(true);

            Vect3d moveDir = GameCam.getTarget().substract(GameCam.getPos());
            moveDir.normalize();
            gameMoveDirPhotons.put(clone, moveDir);
            gameEndLiveTimePhotons.put(clone, now + 1000);

            MovingPhotons.add(clone);

            // play sound
            playsound("shootsound");
        }
    }

    public void doMoveAndCollideObjects(long diff, long now) {
        // move smokes
        for (int k = 0; k < MovingSmokes.size(); ) {
            SceneNodeAbs s = MovingSmokes.get(k);

            if (gameEndLiveTimeSmoke.get(s) < now) {
                s.getParent().removeChild(s);
                MovingSmokes.remove(k);
                gameEndLiveTimeSmoke.remove(s);
                gameMoveDirSmoke.remove(s);
            } else {

                s.getPos().addToThis(gameMoveDirSmoke.get(s).multiplyWithScal(diff * 0.1));
                s.updateAbsolutePosition();

                ++k;
            }
        }

        // move photons and delete them

        for (int i = 0; i < MovingPhotons.size(); ) {
            SceneNodeAbs p = MovingPhotons.get(i);
            boolean deletephoton = false;

            if (gameEndLiveTimePhotons.get(p) < now) {
                deletephoton = true;
            } else {
                // move
                p.getPos().addToThis(gameMoveDirPhotons.get(p).multiplyWithScal(diff * 0.8));
                p.updateAbsolutePosition();

                // collide with all asteroids

                for (int j = 0; j < MovingAsteroids.size(); ++j) {
                    SceneNodeAbs ast = MovingAsteroids.get(j);
                    if (ast.getPos().getDistanceTo(p.getPos()) < 60) {
                        // collision

                        // remove asteroid
                        ast.getParent().removeChild(ast);
                        MovingAsteroids.remove(j);
                        deletephoton = true;
                        playsound("explosion");

                        GameScore += 110;

                        addSmoke(40, 40, ast.getPos(), diff, now);

                        break;
                    }
                }
            }

            if (deletephoton) {
                // delete photon
                p.getParent().removeChild(p);
                MovingPhotons.remove(i);
                gameEndLiveTimePhotons.remove(p);
                gameMoveDirPhotons.remove(p);
            } else {
                // to next photon
                ++i;
            }
        }
    }

    private void playsound(String s) {
        Date thistime = new Date();
        long now = thistime.getTime();
        Audio origaudio = music.get(s);
        if (origaudio==null){
            RootPanel r = RootPanel.get(s);
            if (r == null)
                return;
            origaudio = Audio.createIfSupported();
            RootPanel.get().add(origaudio);
            origaudio.setSrc(r.getElement().getAttribute("src"));
            music.put(s,origaudio);
        }
        // the problem with this is that the audio will be reloaded by chrome, no matter what we do here.
        // seeking and restarting an audio file isn't possible as well.
        // so only play this once and wait for the situation to get better.
        origaudio.play();
    }
    HashMap<String, Audio> music = new HashMap<String, Audio>();
    private void playmusic(String s) {
        currentlyPlayingMusicName = s;
        if (musicDisabled)
            return;

        Audio a = music.get(s);
        if (a==null){
            a = Audio.createIfSupported();
            music.put(s,a);
            RootPanel.get().add(a);
            a.setSrc(RootPanel.get(s).getElement().getAttribute("src"));

        }
        //a.load();
        a.setLoop(true);
        a.play();
        if (playingMusic != null)
            playingMusic.pause();
        playingMusic = a;
    }

    private void disableMusic(boolean disable) {
        musicDisabled = disable;
        if (disable) {
            if (playingMusic != null)
                playingMusic.pause();
            playingMusic = null;
        } else {
            if (playingMusic == null && currentlyPlayingMusicName != null)
                playmusic(currentlyPlayingMusicName);
        }
    }

    public void doGameLogic() {
        long now = new Date().getTime();
        long diff = now - LastGameCalculationTime;
        if (diff > 500)
            diff = 500;

        // animate main camera
        doCameraLookMovement(diff);
        doCameraMovement(diff);
        doShoot(diff, now);
        doMoveAndCollideObjects(diff, now);

        LastGameCalculationTime = now;

        // update hud

        long timeRemaining = 0;
        if (GameTimeRemainingSpan != null) {
            int maxGameTime = 60000;
            timeRemaining = ((LastGameStartTime + maxGameTime) - now) / 1000;
            if (timeRemaining < 0)
                timeRemaining = 0;
            NumberFormat decimalFormat = NumberFormat.getFormat("#.##");
            GameTimeRemainingSpan.setInnerHTML(decimalFormat.format(timeRemaining));
        }

        if (GameScoreSpan != null) {
            GameScoreSpan.setInnerHTML(GameScore + "");
        }

        // back to main menu when time over
        if (timeRemaining <= 0) {
            backToMainMenu();
        }
    }

    class Randomizer {
        private int m = 2147483399;
        private int a = 40692;
        private double q = Math.floor(this.m / this.a);
        private double r = Math.floor(this.m % this.a);
        private double detRandSeed = 0x0f0f0f0f;

        public void setSeed(double s) {
            detRandSeed = s;
        }

        public double getRandf() {
            return (this.getRand() % 100000) / 100000;
        }

        private double getRand() {
            this.detRandSeed = this.a * (this.detRandSeed % this.q) - this.r * (Math.floor(this.detRandSeed / this.q));
            if (this.detRandSeed < 0) this.detRandSeed += this.m;
            return Math.floor(this.detRandSeed);
        }
    }
}
