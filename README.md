port [copperlicht](http://www.ambiera.com/copperlicht/) to gwt
WebGL game engine with animation, colision, lighting, sound, worldEditor

demos and main page: http://copperlicht.mostka.com/

gwt source was generated. some part of code is not checked. unknow arguments is set as JavascriptObject, so when you use method, change declaratisons.

dont forget inherit module
```xml
   <inherits name='com.mostka.cl3d.CL3DWraper'/>
```


Example od tutorial 2

```java
public class CL3DTut2 implements EntryPoint {

   private static CopperLicht engine;
   private Scene scene;
   private static CubeSceneNode cubeSceneNode=null;

   public void onModuleLoad() {
      // create the 3d engine
      engine = CopperLicht.startCopperLichtFromFile("3darea","images/index.ccbjs");
      engine.setOnLoadingComplete(new JsFunction() {

         public JavaScriptObject execute(JavaScriptObject args) {
            Scene scene = engine.getScene();
            if (scene!=null){
               // find the cube scene node
               cubeSceneNode = (CubeSceneNode) scene.getSceneNodeFromName("cubeMesh1");

               // also, force the 3d engine to update the scene every frame
               scene.setRedrawMode(Scene.REDRAW_EVERY_FRAME);

               // additional, let the sphere constantly rotate
               MeshSceneNode sphereSceneNode = (MeshSceneNode) scene.getSceneNodeFromName("sphereMesh1");
               if (sphereSceneNode!=null){
                  sphereSceneNode.addAnimator(AnimatorRotation.create(Vect3d.create(0, 1.6, 0.8)));
               }
            }

            return null;
         }
      });
      addKeyHandler() ;

   }

   public static void keyPress(String key, Object event){
      if (key.equals("F") && cubeSceneNode!=null){
         cubeSceneNode.setPosY(cubeSceneNode.getPosY() + 5);
      }
      // when pressed 'G', move the cube scene node a bit down
      if (key.equals("G") && cubeSceneNode!=null){
         cubeSceneNode.setPosY(cubeSceneNode.getPosY() - 5);
      }
      // we need to call the key handler of the 3d engine as well, so that the user is
      // able to move the camera using the keys
      engine.handleKeyDown(event);
   }

   public final native void addKeyHandler() /*-{
      $wnd.document.onkeydown = function(event){
         @com.mostka.cl3d.client.CL3DTut2::keyPress(Ljava/lang/String;Ljava/lang/Object;)(String.fromCharCode(event.keyCode),event);
      }
   }-*/;
}
```
