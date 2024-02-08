BrewDog Android App
==================
A fully functional Android app built entirely with Kotlin and Jetpack Compose using the [Punk API](https://punkapi.com/documentation/v2)

## Architecture
The app follows the [official architecture guidance](https://developer.android.com/topic/architecture) and is modularised using Gradle modules. 
A domain layer has not been implmentented to reduce boilerplate code in the project however could be introduced in the future if circumstances call for it. 

## Screenshots
![Screenshot_20240208_002131](https://github.com/mwttayler/BrewDog/assets/58072430/439739e8-d103-41a0-ae73-37f55d246be5)
![Screenshot_20240208_002258](https://github.com/mwttayler/BrewDog/assets/58072430/92934059-76a2-47ae-9bd4-c6d9a082b952)

## 🚧 TODO
- [ ] Beers list pagination
- [ ] "Fake" repository classes to reduce boilerplate in tests
- [ ] Update versions in `libs.versions.toml`
- [ ] Investigate splitting `PunkApi` into dedicated "feature" Api interfaces, i.e. `BeersApi`, `DetailsApi` ect
