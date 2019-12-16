# Boilerplate
Android boilerplate code using Clean Architecture, MVVM, Retrofit, RxKotlin, Koin, Glide, Mockito, Espresso and Material Design

# Flavors
All the modules have three flavors with flavorDimension `env`
1. Dev
2. Staging
3. Prod

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
1. Install fastlane
2. Install Firebase cli
3. Change Firebase app ids, tester groups and firebase_cli_path in `/fastlane/Fastfile`. 
```
    firebase_app_distribution(
      app: "YourAppIdFromFirebase",
      apk_path: app_apk_path,
      groups: "Group1, Group2, Group3",
      release_notes_file: "fastlane/changelog.txt",
      firebase_cli_path: "/absolute/path/to/firebase/cli/binary"
    )
```