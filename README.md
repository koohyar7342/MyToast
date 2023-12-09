<h1 align="center">MyToast</h1></br>

<p align="center">
:balloon: A customizable, Changeable color, Changeable position, dismissable Toast
</p>
</br>

<p align="center">
<img src="https://github.com/koohyar7342/MyToast/blob/ee81faf389010ce1f415a7ff062b2a4a18b377ac/myToast.gif" width="250"/>
</p>

## Including in your project
[![JitPack](https://img.shields.io/jitpack/version/com.github.koohyar7342/MyToast)](https://jitpack.io/#koohyar7342/MyToast/Tag)

### Gradle
Step 1. Add the **JitPack** repository to your build file 
```kotlin
dependencyResolutionManagement {
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}
```
Step 2.Add the dependency below to your **module**'s `build.gradle` file:

```kotlin
dependencies {
  implementation 'com.github.koohyar7342:MyToast:1.0.0'
}
```
## How to Use

```kotlin
MyToast.show(
    context = this,
    message = "the toast message",
    type = MyToast.DialogType.ERROR, // DEFAULT,INFO,SUCCESS,COPY
    delayMillis = 2500, // Toast duration in Millisecond
    position = MyToast.DialogPosition.CENTER, // CENTER, BOTTOM, TOP
    lifecycle= lifecycle // for dismissing toast when lifecycleOwner finished
)
```
Declare these colors in your app **colors.xml** for changing MyToast default colors:
```xml
    <color name="mt_copy_background_color">###</color>
    <color name="mt_success_background_color" >###</color>
    <color name="mt_info_background_color" >###</color>
    <color name="mt_error_background_color">###</color>
    <color name="mt_default_background_color">###</color>
    <color name="mt_text_color" >###</color>
    <color name="mt_icon_tint" >###</color>
```


## Find this library useful? :heart:
Support me here __[https://koohyar7342.github.io](https://koohyar7342.github.io)__ <br>
Also, __[follow me](https://github.com/koohyar7342)__ on GitHub for my next creations!

