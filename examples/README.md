1. Setup basic project structure with Gradle. Run command:

        gradle init

Choose Application when asked for project type to generate. Everything else is ok to be default.

This will generate following folder structure:

            .
        ├── app
        │   ├── build.gradle
        │   └── src
        │       ├── main
        │       │   ├── java
        │       │   │   └── ExJava
        │       │   │       └── App.java
        │       │   └── resources
        │       └── test
        │           ├── java
        │           │   └── ExJava
        │           │       └── AppTest.java
        │           └── resources
        ├── gradle
        │   └── wrapper
        │       ├── gradle-wrapper.jar
        │       └── gradle-wrapper.properties
        ├── gradlew
        ├── gradlew.bat
        └── settings.gradle


Edit `build.gradle` file. Add 

        maven { url "https://jitpack.io" }

to the repositories section.

Add 

    implementation 'com.github.xdbfoundation:java-digitalbits-sdk:0.27.0'

to the dependencies section.



## TestnetCreateAccount

This sample application generates random keypair and fund that account on the testnet with friendbot.

From directory `TestnetCreateAccount` execute command:

    ./gradlew run

Keypair and network response will be printed to the output.