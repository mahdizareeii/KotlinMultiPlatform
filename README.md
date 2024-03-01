This is a Kotlin Multiplatform project targeting Android, iOS

<img width="300" alt="1" src="https://github.com/mahdizareeii/KotlinMultiPlatform/assets/34120686/56589fcc-93d8-4c5f-91f6-cef8a26bc87e">
<img width="300" alt="2" src="https://github.com/mahdizareeii/KotlinMultiPlatform/assets/34120686/4fc6f30d-1828-4668-b3e0-ad046ddd9bc0">


* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


//notice

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.

if your ios project didn't find the shared module "import shared"
according to this https://blog.jetbrains.com/kotlin/2021/07/multiplatform-gradle-plugin-improved-for-connecting-kmm-modules/

In the Xcode, Run Script build step, change packForXcode to embedAndSignAppleFrameworkForXcode and remove all the passed flags. The task will use the Xcode environment configuration and build only the needed artifact automatically.

this is mine 

    ./gradlew :composeApp:embedAndSignAppleFrameworkForXcode
    
    ./gradlew :shared:embedAndSignAppleFrameworkForXcode
