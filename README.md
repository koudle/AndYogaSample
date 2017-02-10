# AndYogaExample
Android YOGA Example 

基于 [YOGA](https://github.com/facebook/yoga)的Android工程

## YOGA
YOGA主要由两个部分组成，so库和java库

* so库

有4个so，分别为
```
libyogacore.so
liblib_fb_fbjni.so
libyoga.so
libgnustl_shared.so
```
* so生成

+ 首先安装buck
+ 在配置好android ndk的环境
+ 使用命令 buck build //java:jni#android-armv7,shared 就可以得到你想要的so了

* java
YOGA的java库

## init

``
SoLoader.init(context,false);
``

##  使用

```
YogaNode root = new YogaNode();
root.setWidth(500);
root.setHeight(300);
root.setAlignItems(YogaAlign.CENTER);
root.setJustifyContent(YogaJustify.CENTER);
root.setPadding(YogaEdge.ALL, 20);

YogaNode text = new YogaNode();
text.setWidth(200);
text.setHeight(25);

YogaNode image = new YogaNode();
image.setWidth(50);
image.setHeight(50);
image.setPositionType(YogaPositionType.ABSOLUTE);
image.setPosition(YogaEdge.END, 20);
image.setPosition(YogaEdge.TOP, 20);

root.addChildAt(text, 0);
root.addChildAt(image, 1);

root.calculateLayout();
```
