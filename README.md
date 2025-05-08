# QR Code Reader & Generator

A modern Android application for scanning and generating QR codes. Built with **Kotlin**, **Jetpack Compose**, **Room**, **Hilt**, **CameraX**, and **ML Kit**, this app offers a clean, modular design and a rich set of features. It is designed to be maintainable and open for contributions.

## Features

- **QR Code Scanning**: Scan QR codes in real-time using the device camera, powered by ML Kit.
- **QR Code Generation**: Generate QR codes from text input using ZXing.
- **History Tracking**: Store scanned and generated QR codes with timestamps in a local Room database.
- **Favorites**: Mark important QR codes for quick access.
- **Settings**: Customize app preferences (e.g., toggle dark mode).
- **Offline Support**: Core functionality works without an internet connection.
- **Modern UI**: Built with Jetpack Compose for a smooth and responsive user experience.

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Dependency Injection**: Hilt
- **Database**: Room
- **QR Code Processing**: ZXing (generation), ML Kit (scanning)
- **Camera**: CameraX

## Project Structure

The project is contained within the `app/` directory and follows a modular architecture for clarity and maintainability:

```
app/
├── MainActivity.kt             # Entry point of the app
├── QRCodeApp.kt                # Hilt-enabled Application class
├── AndroidManifest.xml         # App manifest
├── build.gradle                # Module-level build configuration
├── data/                       # Data models and Room database
│   ├── HistoryItem.kt
│   ├── AppDatabase.kt
│   └── HistoryDao.kt
├── ui/                         # UI components (Compose screens)
│   ├── ScanScreen.kt
│   ├── GenerateScreen.kt
│   ├── HistoryScreen.kt
│   ├── FavoritesScreen.kt
│   └── SettingsScreen.kt
├── util/                       # Utility functions
│   └── QRCodeUtil.kt
├── viewmodel/                  # ViewModels for business logic
│   └── QRViewModel.kt
└── res/                        # Resources (icons, strings, themes)
    ├── drawable/
    │   └── ic_launcher_background.xml
    ├── mipmap/
    │   ├── ic_launcher.png
    │   └── ic_launcher_round.png
    └── values/
        ├── colors.xml
        ├── strings.xml
        └── themes.xml
```

## Prerequisites

To build and run the project, you need:
- **Android Studio** (recommended for managing dependencies and resources)
- **JDK 17** or higher
- **Android SDK** (API 24 or higher, recommended: API 33)
- A physical Android device or emulator for testing

## Installation

Follow these steps to set up and run the project:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/icelaterdc/Android-QR-Code-Reader.git
   cd Android-QR-Code-Reader
   ```

2. **Set up the project in Android Studio**:
   - Open Android Studio and select **Open an existing project**.
   - Navigate to the `qrcodeapp` directory and select the `app/` folder.
   - Android Studio will automatically detect the `build.gradle` file in `app/` and configure the project.

3. **Sync dependencies**:
   - Click **Sync Project with Gradle Files** in Android Studio to download the required dependencies (e.g., Compose, Room, Hilt, CameraX).

4. **Build and run**:
   - Connect an Android device or start an emulator.
   - Click **Run** in Android Studio to build and install the app.
   - Alternatively, use the terminal:
     ```bash
     cd app
     ./gradlew installDebug
     ```
     *Note*: This requires Gradle Wrapper files, which are not included in this repository. See the [Troubleshooting](#troubleshooting) section if you encounter issues.

## Usage

1. **Scan a QR Code**:
   - Open the app and navigate to the **Scan** screen.
   - Point the camera at a QR code to view the result instantly.

2. **Generate a QR Code**:
   - Go to the **Generate** screen.
   - Enter text and click **Generate** to create and display a QR code.
   - Generated codes are saved to the history.

3. **View History and Favorites**:
   - Access the **History** screen to see all scanned and generated QR codes.
   - Mark codes as favorites for quick access in the **Favorites** screen.

4. **Customize Settings**:
   - Use the **Settings** screen to adjust preferences, such as enabling dark mode.

## Troubleshooting

- **Missing Gradle Wrapper files**:
  - This repository only includes the `app/` directory. To build the project, you need Gradle Wrapper files (`gradlew`, `gradlew.bat`, `gradle-wrapper.jar`, `gradle-wrapper.properties`) and a project-level `build.gradle`.
  - To add these:
    1. Create a new Android project in Android Studio to get a template with Gradle files.
    2. Copy `gradlew`, `gradlew.bat`, and `gradle/` to the root of your repository.
    3. Add a `settings.gradle` file with:
       ```gradle
       include ':app'
       ```
    4. Add a project-level `build.gradle` (see the [Tech Stack](#tech-stack) section for dependencies).

- **Resource errors**:
  - Ensure `ic_launcher.png` and `ic_launcher_round.png` exist in `app/res/mipmap/`. Use Android Studioâ€™s **Image Asset** tool to generate them if missing.

- **Dependency errors**:
  - Check `app/build.gradle` for correct dependency versions.
  - Run `Sync Project with Gradle Files` to resolve issues.

## Contributing

We welcome contributions! To contribute:
1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature
   ```
3. Make your changes and commit:
   ```bash
   git commit -m "Add your feature"
   ```
4. Push to your fork:
   ```bash
   git push origin feature/your-feature
   ```
5. Open a pull request on GitHub.

Please adhere to the [Code of Conduct](CODE_OF_CONDUCT.md) and follow the projectâ€™s coding standards.

## License

This project is licensed under the [MIT License](LICENSE). See the [LICENSE](LICENSE) file for details.

## Contact

For questions, suggestions, or feedback:
- Open an issue on GitHub.

---

**Happy coding!**
