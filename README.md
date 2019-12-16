# Boilerplate
Android boilerplate code using Clean Architecture, MVVM, Retrofit, RxKotlin, Koin, Glide, Mockito, Espresso and Material Design

# Flavors
All the modules have three flavors with flavorDimension `env`.
1. Dev
2. Staging
3. Prod

# BuildTypes
There are two build types. 
1. Debug
    It is used during the development for the authors of the code themselves 
    so that any crashes during development won't go to Crashlytics. 
    Any other configurations intended only for the authors of code should be added in there
2. Release
    It is used to distribute the apps, be it Firebase app distribution, play store or any other distribution media. 
    Crashlytics is enabled for this build type. 
    Any other configurations intended for QA, product managers,product owners or people from similar roles should be added in here

# Sign Keys
Sign keys are stored inside `./keystores` folder and they are loaded from gradle using `keystore.properties`.
`keystore.properties` looks like this
```
dev.keystore.path=../keystores/dev.keystore
dev.keystore.password=YourDevPassword
dev.key.alias=YourDevAlias
dev.key.password=YourDevKeyPassword

staging.keystore.path=../keystores/staging.keystore
staging.keystore.password=YourStagingPassword
staging.key.alias=YourStagingAlias
staging.key.password=YourStaingKeyPassword

prod.keystore.path=../keystores/prod.keystore
prod.keystore.password=YourProdPassword
prod.key.alias=YourProdAlias
prod.key.password=YourProdKeyPassword
```

## Base Urls
Base Urls are defined inside `ApiConfigs.kt`. It's inside `core` module. Each flavor(of flavorDimension `env`) has its own `ApiConfigs.Kt`

## Fastlane

### Setup fastlane

1. Install fastlane
    Be careful with the ruby version. At the time of writing, fastlane requires at least `2.4.0`.    
    If you install fastlane before you have the minimum required ruby version, you can have some errors.
2. Install Firebase cli
3. Change Firebase app ids, tester groups and firebase_cli_path in `/fastlane/Fastfile`.   
    There are two places where you need to modify app ids: One for dev and another one for staging.
    ```
        firebase_app_distribution(
          app: "YourAppIdFromFirebase",
          apk_path: app_apk_path,
          groups: "Group1, Group2, Group3",
          release_notes_file: "fastlane/changelog.txt",
          firebase_cli_path: "/absolute/path/to/firebase/cli/binary"
        )
    ```
4. create `AVD_config.json` inside `/fastlane` folder.    
    Check [automated-test-emulator-run fastlane plugin](https://github.com/AzimoLabs/fastlane-plugin-automated-test-emulator-run) for more details about how to write `AVD_config.json` 