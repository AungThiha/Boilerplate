# boilerplate
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