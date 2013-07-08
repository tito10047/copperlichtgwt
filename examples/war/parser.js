/*function loadScript(url, callback) {
    var script = document.createElement("script")
    script.type = "text/javascript";
    if (script.readyState) {
        script.onreadystatechange = function () {
            if (script.readyState == "loaded" || script.readyState == "complete") {
                script.onreadystatechange = null;
                callback();
            }
        };
    } else {
        script.onload = function () {
            callback();
        };
    }
    script.src = url;
    document.getElementsByTagName("head")[0].appendChild(script);
}

function aaaa() {
    console.log("jquery loaded")
}
loadScript('http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js', aaaa);*/
//void $("#classList").find("a").each(function(){console.log("['"+this.innerHTML+"','"+this.href+"'],")});
var classes = [
    ['CL3D','http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.html'],
    ['AnimatedMeshSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatedMeshSceneNode.html'],
    ['Animator', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Animator.html'],
    ['AnimatorAnimateTexture', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorAnimateTexture.html'],
    ['AnimatorCameraFPS', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorCameraFPS.html'],
    ['AnimatorCameraModelViewer', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorCameraModelViewer.html'],
    ['AnimatorCollisionResponse', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorCollisionResponse.html'],
    ['AnimatorFlyCircle', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorFlyCircle.html'],
    ['AnimatorFlyStraight', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorFlyStraight.html'],
    ['AnimatorFollowPath', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorFollowPath.html'],
    ['AnimatorOnClick', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorOnClick.html'],
    ['AnimatorOnProximity', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorOnProximity.html'],
    ['AnimatorRotation', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.AnimatorRotation.html'],
    ['BillboardSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.BillboardSceneNode.html'],
    ['Box3d', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Box3d.html'],
    ['CameraSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.CameraSceneNode.html'],
    ['ColorF', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.ColorF.html'],
    ['CopperCubeVariable', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.CopperCubeVariable.html'],
    ['CopperLicht', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.CopperLicht.html'],
    ['CubeSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.CubeSceneNode.html'],
    ['HotspotSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.HotspotSceneNode.html'],
    ['Light', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Light.html'],
    ['LightSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.LightSceneNode.html'],
    ['Line3d', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Line3d.html'],
    ['Material', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Material.html'],
    ['Matrix4', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Matrix4.html'],
    ['Mesh', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Mesh.html'],
    ['MeshBuffer', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.MeshBuffer.html'],
    ['MeshSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.MeshSceneNode.html'],
    ['MeshTriangleSelector', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.MeshTriangleSelector.html'],
    ['MetaTriangleSelector', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.MetaTriangleSelector.html'],
    ['Mobile2DInputSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Mobile2DInputSceneNode.html'],
    ['OctTreeTriangleSelector', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.OctTreeTriangleSelector.html'],
    ['Overlay2DSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Overlay2DSceneNode.html'],
    ['ParticleSystemSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.ParticleSystemSceneNode.html'],
    ['PathSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.PathSceneNode.html'],
    ['Plane3d', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Plane3d.html'],
    ['Quaternion', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Quaternion.html'],
    ['Renderer', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Renderer.html'],
    ['Scene', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Scene.html'],
    ['SceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.SceneNode.html'],
    ['SkyBoxSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.SkyBoxSceneNode.html'],
    ['SoundSceneNode', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.SoundSceneNode.html'],
    ['Texture', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Texture.html'],
    ['TextureManager', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.TextureManager.html'],
    ['Triangle3d', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Triangle3d.html'],
    ['TriangleSelector', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.TriangleSelector.html'],
    ['Vect2d', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Vect2d.html'],
    ['Vect3d', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Vect3d.html'],
    ['Vertex3D', 'http://www.ambiera.com/copperlicht/documentation/symbols/CL3D.Vertex3D.html']
];

var preLastNode = null;
var lastNode=null;
function getChildNodes(node){
    if (!node){
        throw "getChildNodes::node is null";
    }
    preLastNode = lastNode;
    lastNode = node;
    if (!node.childNodes){
        console.log(node);
        throw "node has not child elements";
    }

    return node.childNodes;
}
function testComment(nodes,pos,text){
    var ch = getChild(nodes,pos);
    var t = (ch.nodeType==8 && ch.data.replace(/=/g,"") == text );
    if (t==false){
        if (ch.nodeType==8){
            console.log('"' + ch.data + '"!="' );
        }else{
            console.log( ch );
        }
        console.log("noce at possition "+ pos + " is not a commet '" + text + "'");
        throw("noce at possition "+ pos + " is not a commet '" + text + "'");
    }
    return t;
}
function findComment(nodes,comment){
    var s=0;
    for(var i=0;i<nodes.length;i++){
        var ch = nodes[i];
        if (ch.nodeType!=3){
            if (ch.nodeType==8 && ch.data.replace(/=/g,"") == comment ){
                return s;
            }
            s++;
        }
    }
    console.log("cant find comment '"+comment+"'");
    throw ("cant find comment '"+comment+"'");
}

function findById(d,id)
{
    if(!d)
        return;
    if(!d.childNodes)
        return;
    for(var i=0;i<d.childNodes.length;i++){
        var ch = d.childNodes[i];
        if (ch.id && ch.id==id){
            return ch;
        }
        var f = findById(ch,id);
        if (f!=null){
            return f;
        }
    }
    return null;
}
function getChild(childs,pos){
    var s = 0;
    if (childs.length == undefined){
        console.log(childs);
        throw ("lenght is undefined");
    }
    for(var i=0;i<childs.length;i++){
        var ch = childs[i];
        if (ch.nodeType!=3){
            if (s == pos){
                return ch;
            }
            s++;
        }
    }
    console.log(childs);
    throw ("child not find at position "+pos);
    return null;
}
function getChildLength(childs){
    var s = 0;
    for(var i=0;i<childs.length;i++){
        if (childs[i].nodeType!=3){
            s++;
        }
    }
    return s;
}
var classesData=[];
var CLS_NAME = 0,
    CLS_OVERVIEW = 1,
    CLS_METHODS = 2,
    CLS_EXTEND = 3,
    CLS_CONSTRUCT_PRM = 4,
    CLS_PROPERTIES= 5,
    MTD_NAME = 0,
    MTD_OVERVIEW = 1,
    MTD_PARAMS = 2,
    MTD_RETURN = 3,
    MTD_STATIC = 4,
    PRM_NAME = 0,
    PRM_OVERVIEW = 1,
    PRM_CLASS = 2,
    PRM_STATIC = 3,
    RET_OVERVIEW= 0,
    RET_CLASS=1;
var debugNode = null;
function runParser(classPos,onFinish){
    classData = [];
    classData[CLS_NAME] = classes[classPos][0];
    classData[CLS_OVERVIEW] = "";
    classData[CLS_METHODS]=[];
    var win = window.open(classes[classPos][1], '', 'width=200,height=100');
    if (!win){
        alert("popup is blocked");
        throw "popop is blocked";
    }
    win.onload = function(){
        try{
            var pos = 0;
            //var content = $(win.document.body).find("#content");
            var childs = findById(win.document,"content").childNodes;
            //remove new lines elements
            findComment(childs, '  header  ');
            findComment(childs, ' begin static/header.html ');
            findComment(childs, ' end static/header.html ');
            findComment(childs, '  class title  ');
            pos = findComment(childs, '  class summary  ');
            pos++;
            console.log("112");
            classData[CLS_OVERVIEW] = getChildNodes(getChild(childs,pos))[0].data.trim();
            console.log("114");
            var ch = getChild(childs,pos);
            pos = null;
            for(var re=0;re<ch.childNodes.length;re++){
                if (ch.childNodes[re].nodeType == 3 && ch.childNodes[re].nodeName == "#text" && ch.childNodes[re].data.trim()=="Extends"){
                    pos = re+1;
                    break;
                }
            }
            console.log("115");
            if (pos!=null){
                if (ch.childNodes[pos].nodeName!="A"){
                    console.log(ch.childNodes[pos])
                    throw "node is nor anchor";
                }
                classData[CLS_EXTEND] =ch.childNodes[pos].innerHTML;
            }
            console.log("116");
            findComment(childs, '  constructor summary  ');
            pos = findComment(childs, '  constructor details  ');
            pos++;
            ch = getChild(childs,pos).childNodes;
            classData[CLS_CONSTRUCT_PRM]=null;
            for (i=0;i<ch.length;i++){
                if (ch[i].nodeType==1 && ch[i].nodeName=="DL"){
                    if (ch[i].childNodes[1].innerHTML=="Parameters:"){
                        classData[CLS_CONSTRUCT_PRM]=[];
                        console.log("333");
                        var paramCount = (getChildLength(ch[i].childNodes) - 1) / 2;
                        console.log("334");
                        for (prmPos = 0;prmPos<paramCount;prmPos++){
                            classData[CLS_CONSTRUCT_PRM][prmPos]=[];
                            console.log("335");
                            var chl2 = getChild(ch[i].childNodes,prmPos*2+1);
                            classData[CLS_CONSTRUCT_PRM][prmPos][PRM_NAME] = getChild(chl2.childNodes,0).innerHTML;
                            console.log("313");
                            classData[CLS_CONSTRUCT_PRM][prmPos][PRM_OVERVIEW] = "";
                            classData[CLS_CONSTRUCT_PRM][prmPos][PRM_CLASS] = "";
                            console.log("337");
                            if (chl2 = getChild(ch[i].childNodes,prmPos*2+2).childNodes.length>0){
                                console.log("310");
                                var str = chl2 = getChild(ch[i].childNodes,prmPos*2+2).childNodes[0].data;
                                console.log("311");
                                if (str.charAt(0)=="{"){
                                    classData[CLS_CONSTRUCT_PRM][prmPos][PRM_CLASS] = str.split("}")[0].replace("{","");
                                    console.log(str);
                                    console.log("312");
                                    classData[CLS_CONSTRUCT_PRM][prmPos][PRM_OVERVIEW]=str.split("}")[1].trim();
                                    console.log("317");
                                }else{
                                    classData[CLS_CONSTRUCT_PRM][prmPos][PRM_OVERVIEW]=str.trim();
                                }
                            }
                        }
                        console.log("318");
                    }
                    break;
                }
            }
            console.log("319");
            pos = findComment(childs, '  properties summary  ');
            pos++;
            var hasFields=false;
            classData[CLS_PROPERTIES]=[];
            if (getChild(childs,pos).nodeName == "TABLE"){
                hasFields=true;
                var tr = getChildNodes(getChild(childs,pos).tBodies[0]);
                console.log(tr)
                debugNode = tr;
                var propertiesLength = getChildLength(tr);
                for(var i=0;i<propertiesLength;i++){
                    console.log("417-"+i);
                    classData[CLS_PROPERTIES][i]=[];
                    if (getChild(tr,i).cells[0].childNodes[0].data.length == 1){
                        classData[CLS_PROPERTIES][i][PRM_NAME] = getChildNodes(getChildNodes(getChildNodes(getChild(tr,i).cells[1])[1])[1])[0].innerHTML;
                        classData[CLS_PROPERTIES][i][PRM_STATIC] = false;
                    }else{
                        if (getChild(tr,i).cells[0].childNodes[0].data.length != 10){
                            throw ("undefined first cell on pos "+i);
                        }
                        classData[CLS_PROPERTIES][i][PRM_STATIC] = true;
                        classData[CLS_PROPERTIES][i][PRM_NAME] = getChildNodes(getChildNodes(getChild(tr,i).cells[1])[1])[1].childNodes[0].innerHTML;
                    }
                }
            }
            pos = findComment(childs, '  methods summary  ');
            pos++;
            var hasMethods = false;
            if (getChild(childs,pos).nodeName == "TABLE"){
                hasMethods=true;
                var tr = getChildNodes(getChild(childs,pos).tBodies[0]);
                console.log(tr)
                debugNode = tr;
                var methodsLength = getChildLength(tr);
                for(var i=0;i<methodsLength;i++){
                    console.log("117-"+i);
                    classData[CLS_METHODS][i]=[];
                    if (getChild(tr,i).cells[0].childNodes[0].data.length == 1){
                        classData[CLS_METHODS][i][MTD_NAME] = getChildNodes(getChildNodes(getChildNodes(getChild(tr,i).cells[1])[1])[0])[0].innerHTML;
                        classData[CLS_METHODS][i][MTD_STATIC] = false;
                    }else{
                        if (getChild(tr,i).cells[0].childNodes[0].data.length != 10){
                            throw ("undefined first cell on pos "+i);
                        }
                        classData[CLS_METHODS][i][MTD_STATIC] = true;
                        classData[CLS_METHODS][i][MTD_NAME] = getChildNodes(getChildNodes(getChild(tr,i).cells[1])[1])[1].childNodes[0].innerHTML;
                    }
                }
            }
            findComment(childs, '  events summary  ');
            pos = findComment(childs, '  field details  ');
            pos++;
            if (hasFields){
                var childsLength = getChildLength(childs);
                /////////////////
                for(var i=0;i<propertiesLength;i++){
                    console.log("552-"+i);
                    debugNode = childs;
                    while (pos<childsLength){
                        if (classData[CLS_PROPERTIES][i][PRM_STATIC]==false){
                            if (getChild(childs,pos).name ==classData[CLS_PROPERTIES][i][PRM_NAME]){
                                break;
                            }
                        }else{
                            if (getChild(childs,pos).name == "." + classData[CLS_PROPERTIES][i][PRM_NAME]){
                                break;
                            }
                        }
                        pos++;
                    }
                    if (pos>=childsLength){
                        throw "cand find href for method '" + classData[CLS_PROPERTIES][i][PRM_NAME] + "'";
                    }
                    classData[CLS_PROPERTIES][i][PRM_OVERVIEW] = getChild(childs,pos+2).innerHTML.trim();
                    if (getChild(childs,pos+1).childNodes[3]==undefined){
                        classData[CLS_PROPERTIES][i][PRM_CLASS] = null;
                        //classData[CLS_PROPERTIES][i][PRM_NAME] = getChild(childs,pos+1).childNodes[1].innerHTML;
                    }else{
                        classData[CLS_PROPERTIES][i][PRM_CLASS] = getChild(childs,pos+1).childNodes[1].innerHTML.replace("{","").replace("}","");
                        //classData[CLS_PROPERTIES][i][PRM_NAME] = getChild(childs,pos+1).childNodes[3].innerHTML;
                    }
                }
                /////////////////
            }

            pos = findComment(childs, '  method details  ');pos++;
            if (hasMethods){
                var childsLength = getChildLength(childs);
                for(var i=0;i<methodsLength;i++){
                    console.log("452-"+i);
                    debugNode = childs;
                    while (pos<childsLength){
                        if (classData[CLS_METHODS][i][MTD_STATIC]==false){
                            if (getChild(childs,pos).name ==classData[CLS_METHODS][i][MTD_NAME]){
                                break;
                            }
                        }else{
                            if (getChild(childs,pos).name == "." + classData[CLS_METHODS][i][MTD_NAME]){
                                break;
                            }
                        }
                        pos++;
                    }
                    if (pos>=childsLength){
                        throw "cand find href for method '" + classData[CLS_METHODS][i][MTD_NAME] + "'";
                    }
                    classData[CLS_METHODS][i][MTD_OVERVIEW] = getChild(childs,pos+2).innerHTML.trim();
                    classData[CLS_METHODS][i][MTD_PARAMS]=[];
                    classData[CLS_METHODS][i][MTD_RETURN]=null;
                    var dl = getChild(childs,pos+3);

                    if (dl.nodeName == "DL"){
                        if (getChildNodes(dl)[1].innerHTML=="Parameters:"){
                            var paramCount = (getChildLength(getChildNodes(dl)) - 1) / 2;
                            for (prmPos = 0;prmPos<paramCount;prmPos++){
                                classData[CLS_METHODS][i][MTD_PARAMS][prmPos]=[];
                                console.log(getChild(getChildNodes(dl),prmPos*2+1));
                                var chs = getChildNodes(getChild(getChildNodes(dl),prmPos*2+1));
                                if (chs.length==1){
                                    chs=chs[0].data;
                                }else{
                                    chs = getChildNodes(chs[1])[0].data;
                                }
                                classData[CLS_METHODS][i][MTD_PARAMS][prmPos][PRM_NAME] = chs;
                                classData[CLS_METHODS][i][MTD_PARAMS][prmPos][PRM_OVERVIEW] = "";
                                classData[CLS_METHODS][i][MTD_PARAMS][prmPos][PRM_CLASS] = "";;
                                if (getChildNodes(getChild(getChildNodes(dl),prmPos*2+2)).length>0){
                                    var str = getChildNodes(getChild(getChildNodes(dl),prmPos*2+2))[0].data;
                                    if (str.charAt(0)=="{"){
                                        classData[CLS_METHODS][i][MTD_PARAMS][prmPos][PRM_CLASS] = str.split("}")[0].replace("{","");
                                        classData[CLS_METHODS][i][MTD_PARAMS][prmPos][PRM_OVERVIEW]=str.split("}")[1].trim();
                                    }else{
                                        classData[CLS_METHODS][i][MTD_PARAMS][prmPos][PRM_OVERVIEW]=str.trim();
                                    }
                                }
                            }
                        }
                        pos+=3;
                    }
                    console.log("4");
                    try{
                        var dl = getChild(childs,pos+3);
                        if (dl.nodeName == "DL"){
                            classData[CLS_METHODS][i][MTD_RETURN]=[];
                            classData[CLS_METHODS][i][MTD_RETURN][RET_OVERVIEW] = getChildNodes(getChildNodes(dl)[3])[0].innerHTML.replace("{","").replace("}","");
                            classData[CLS_METHODS][i][MTD_RETURN][RET_CLASS] = getChildNodes(getChildNodes(dl)[3])[1].data.trim();
                        }
                    }catch (e){}
                }
            }
            findComment(childs, '  event details  ');

            console.log("58");
            classesData[classPos]=classData;
            classPos++;
            if (classPos<classes.length){
                setTimeout(function(){
                    runParser(classPos,onFinish);
                },10);
            }else{
                onFinish();
            }
            console.clear()
        }catch (err){
            console.log(classes[classPos][0] + " pos" + classPos);
            var txt="There was an error on this page.\n\n"
            if (err.message==undefined){
                console.log(err);
            }else{
                txt+="Error description: " + err.message + "\n\n";
            }
            console.log(txt);
            console.log(er.toSource());
        }finally{
            win.close();
        }
    }
}

String.prototype.firstUp = function () {
    return this.charAt(0).toUpperCase() + this.slice(1);
}

var TAB = "\t\t", END = "\n";
function generate() {
    var script = "";
    for(i in classesData)
    {
        //var i = 0;
        var classData = classesData[i];
        classData[CLS_NAME] = classData[CLS_NAME].firstUp()
        script += "public class " + classData[CLS_NAME] + " extends ";
        if (classData[CLS_EXTEND]) {
            script += classData[CLS_EXTEND].replace("CL3D.","") + " ";
        } else {
            script += "JavaScriptObject";
        }
        script += "{" + END + END;
        script += TAB + "protected " + classData[CLS_NAME] + "(){}" + END + END;

        //constructor javadoc
        if (classData[CLS_CONSTRUCT_PRM] || classData[CLS_OVERVIEW]) {
            script += TAB + "/**" + END;
            if (classData[CLS_OVERVIEW]) {
                script += TAB + " * " + classData[CLS_OVERVIEW].replace(/\n/g,END+TAB+" * ") + END;
            }
            if (classData[CLS_CONSTRUCT_PRM]) {
                for (var pos in classData[CLS_CONSTRUCT_PRM]) {

                    script += TAB + " * @param " + classData[CLS_CONSTRUCT_PRM][pos][PRM_NAME];
                    script += classData[CLS_CONSTRUCT_PRM][pos][PRM_OVERVIEW] + END;
                }
            }
            script += TAB + " */" + END;
        }
        script += END;
        //constructor
        script += TAB + "public static native " + classData[CLS_NAME] + " create(";
        if (classData[CLS_CONSTRUCT_PRM]) {
            for (var pos = 0; pos < classData[CLS_CONSTRUCT_PRM].length; pos++) {
                if (classData[CLS_CONSTRUCT_PRM][pos][PRM_CLASS]) {
                    script += classData[CLS_CONSTRUCT_PRM][pos][PRM_CLASS].firstUp() + " ";
                } else {
                    script += "JavaScriptObject ";
                }
                script += classData[CLS_CONSTRUCT_PRM][pos][PRM_NAME];
                if (pos + 1 < classData[CLS_CONSTRUCT_PRM].length) {
                    script += ", ";
                }
            }
        }
        script += ") /*-{" + END;
        script += TAB + TAB + "return new CL3D." + classData[CLS_NAME] + "("
        if (classData[CLS_CONSTRUCT_PRM]) {
            for (var pos = 0; pos < classData[CLS_CONSTRUCT_PRM].length; pos++) {
                script += classData[CLS_CONSTRUCT_PRM][pos][PRM_NAME];
                if (pos + 1 < classData[CLS_CONSTRUCT_PRM].length) {
                    script += ", ";
                }
            }
        }
        script += ");" + END;
        script += TAB + "}-*/;" + END + END;

        //properties
        if (classData[CLS_PROPERTIES]) {
            for (var p in classData[CLS_PROPERTIES]) {
                var prop = classData[CLS_PROPERTIES][p];

                function makeComm() {
                    if (prop[PRM_OVERVIEW]) {
                        script += TAB + "/**" + END;
                        script += TAB + " * " + prop[PRM_OVERVIEW].replace(/\n/g,END+TAB+" * ") + END;
                        script += TAB + " */" + END;
                    }
                }

                makeComm();
                script += TAB + "public ";
                if (prop[PRM_STATIC]) {
                    script += "static ";
                }
                if (!prop[PRM_CLASS]) { prop[PRM_CLASS] = "JavaScriptObject" }
                prop[PRM_CLASS] = prop[PRM_CLASS].replace(".","");
                script += "native "+prop[PRM_CLASS]+" get" + prop[PRM_NAME].firstUp() + "() /*-{" + END;
                script += TAB + TAB + "return " + (prop[PRM_STATIC] ? classData[CLS_NAME] + "." : "this.") + prop[PRM_NAME] + ";" + END;
                script += TAB + "}-*/;" + END + END;

                if (!prop[PRM_STATIC]) {
                    makeComm();
                    script += TAB + "public native void set" + prop[PRM_NAME].firstUp() + "(";
                    if (prop[PRM_CLASS]) {
                        script += prop[PRM_CLASS].firstUp() + " ";
                    } else {
                        script += "JavaScriptObject ";
                    }
                    script += prop[PRM_NAME] + ") /*-{" + END
                    script += TAB + TAB + "this." + prop[PRM_NAME] + "=" + prop[PRM_NAME] + ";" + END;
                    script += TAB + "}-*/;" + END + END;
                }
            }
        }

        //methods
        if (classData[CLS_METHODS]) {
            for (var p in classData[CLS_METHODS]) {
                var met = classData[CLS_METHODS][p];
                if (met[MTD_PARAMS] || met[MTD_OVERVIEW] || met[MTD_RETURN]) {
                    script += TAB + "/**" + END;
                    if (met[MTD_OVERVIEW]) {
                        script += TAB + " * " + met[MTD_OVERVIEW].replace(/\n/g,END+TAB+" * ") + END;
                    }
                    if (met[MTD_PARAMS]) {
                        for (var p in met[MTD_PARAMS]) {
                            var param = met[MTD_PARAMS][p];
                            script += TAB + " * @param " + param[PRM_NAME] + " " + param[PRM_OVERVIEW] + END;
                        }
                    }
                    if (met[MTD_RETURN]) {
                        script += TAB + " * @return " + met[MTD_RETURN] + RND;
                    }
                    script += TAB + " */" + END;
                }
                script += TAB + "public ";
                if (met[MTD_STATIC]) {
                    script += "static ";
                }else{
                    script += "final ";
                }
                script += "native ";
                if (met[MTD_RETURN]) {
                    script += met[MTD_RETURN].firstUp();
                } else {
                    script += "JavaScriptObject ";
                }
                script += met[MTD_NAME] + "(";
                if (met[MTD_PARAMS]) {
                    var len = met[MTD_PARAMS].length;
                    for (var p = 0; p < len; p++) {
                        var param = met[MTD_PARAMS][p];
                        if (param[PRM_CLASS]) {
                            script += param[PRM_CLASS].firstUp() + " ";
                        } else {
                            script += "JavaScriptObject ";
                        }
                        script += param[PRM_NAME];
                        if (p < len-1) {
                            script += ", ";
                        }
                    }
                }
                script +=  ") /*-{" + END
                script += TAB + TAB + "return "+(met[MTD_STATIC]?classData[CLS_NAME]:"this")+"." + met[MTD_NAME] + "(";
                if (met[MTD_PARAMS]) {
                    for (var p = 0; p < met[MTD_PARAMS].length; p++) {
                        var param = met[MTD_PARAMS][p];
                        script += param[PRM_NAME];
                        if (p < met[MTD_PARAMS].length-1) {
                            script += ", ";
                        }
                    }
                }
                script += ");" + END;
                script += TAB + "}-*/;" + END + END;
            }
        }
        script += "}"+END + END;
    }
    return script;
}

runParser(0,function(){
    var script = generate();
    var win = window.open("", '', 'width=1000,height=900');
    if (!win){
        alert("popup is blocked");
        throw "popop is blocked";
    }
    win.document.write('<div id="content" style="white-space: pre-wrap;">' + script + "</div>");
});