# 📱 TextToWatch

> A modern Android application for sending text messages with Firebase Realtime Database and push notifications support

[![Android](https://img.shields.io/badge/Android-8.0+-green?logo=android)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.8+-purple?logo=kotlin)](https://kotlinlang.org)
[![Firebase](https://img.shields.io/badge/Firebase-Realtime-orange?logo=firebase)](https://firebase.google.com)

## ✨ Features

- 📝 **Send Text Messages** - intuitive interface for writing and sending messages
- 🔥 **Firebase Realtime Database** - cloud storage for real-time message synchronization
- 🔔 **Push Notifications** - instant notifications when messages are sent
- 🌓 **Dark Mode** - automatic adaptation to system theme
- 🎨 **Jetpack Compose UI** - modern and responsive user interface
- 📱 **Material Design 3** - compliance with Google's modern design standards
- 🚀 **Optimized** - minimal resource consumption

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Backend:** Firebase Realtime Database
- **Notifications:** Android NotificationManager
- **Minimum SDK:** Android 8.0 (API 26)
- **Target SDK:** Android 14 (API 34)
- **Build System:** Gradle

## 📋 Requirements

- Android Studio Flamingo or later
- JDK 11 or higher
- Android SDK 26+
- Internet connection
- Firebase account

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Witty-Charm/TextToWatch.git
cd TextToWatch
```

### 2. Open in Android Studio

1. Launch Android Studio
2. Click **File** → **Open**
3. Select the `TextToWatch` folder
4. Wait for Gradle sync to complete

### 3. Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com)
2. Create a new project or use existing one
3. Enable Realtime Database:
   - Click **Build** → **Realtime Database**
   - Create database in your preferred region
4. Download `google-services.json`:
   - Project Settings → Download `google-services.json`
   - Place it in the `app/` folder of your project

### 4. Configure Database URL

Update the database URL in `MainActivity.kt`:

```kotlin
private fun initFirebase() {
    FirebaseDatabase.getInstance("https://YOUR_PROJECT-default-rtdb.REGION.firebasedatabase.app")
}
```

Replace with your actual Firebase database URL from Firebase Console.

### 5. Firebase Security Rules

For development, set these rules in Firebase Console → **Rules**:

```json
{
  "rules": {
    ".read": true,
    ".write": true
  }
}
```

⚠️ **Warning:** These rules are for development only. Never use them in production!

### 6. Run the App

1. Connect an Android device or start an emulator
2. Click **Run** → **Run 'app'** in Android Studio
3. Or use the terminal:

```bash
./gradlew installDebug
```

## 📁 Project Structure

```
TextToWatch/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/texttowatch/
│   │   │   │   └── MainActivity.kt
│   │   │   ├── AndroidManifest.xml
│   │   │   └── res/
│   │   └── test/
│   └── build.gradle
├── build.gradle
├── settings.gradle
├── google-services.json
└── README.md
```

## 🔐 Permissions

The app requires these permissions (already in `AndroidManifest.xml`):

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

- **INTERNET:** For Firebase communication
- **POST_NOTIFICATIONS:** For push notifications (Android 13+)

## 📦 Dependencies

Key dependencies included:

```gradle
// Firebase
implementation 'com.google.firebase:firebase-database-ktx:20.2.4'
implementation 'com.google.firebase:firebase-analytics-ktx'

// Jetpack Compose
implementation 'androidx.compose.ui:ui:1.5.0'
implementation 'androidx.compose.material3:material3:1.1.1'

// Core Android
implementation 'androidx.core:core-ktx:1.12.0'
implementation 'androidx.activity:activity-compose:1.8.1'
```

## 🎯 How to Use

1. **Open the app** on your Android device
2. **Type a message** in the text field "Введи текст" (Enter text)
3. **Tap the button** "Отправить" (Send)
4. **See the notification** appear on your device
5. **Check Firebase Console** to verify the message was stored

## 🐛 Troubleshooting

### Issue: "Database lives in a different region"

**Solution:** Update the Firebase database URL in `MainActivity.kt` to match your region.

### Issue: Notifications not appearing

**Solution:** Check that:
- `POST_NOTIFICATIONS` permission is granted
- Notification channel is created in `createNotificationChannel()`
- Device notifications are enabled in system settings

### Issue: Can't connect to Firebase

**Solution:**
1. Verify internet connection
2. Check `google-services.json` is in `app/` folder
3. Confirm Firebase project is active
4. Check database URL is correct

### Issue: Messages not saving to database

**Solution:**
1. Verify Firebase Rules allow write access
2. Check network connectivity
3. Look at logcat for Firebase error messages
4. Ensure `google-services.json` is properly configured

## 🔄 Git Workflow

```bash
# Create a new feature branch
git checkout -b feature/your-feature

# Make changes and commit
git add .
git commit -m "Add your feature description"

# Push to GitHub
git push origin feature/your-feature

# Create a Pull Request on GitHub
```

## 📚 Documentation

- [Android Developer Documentation](https://developer.android.com)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Jetpack Compose Guide](https://developer.android.com/jetpack/compose)
- [Kotlin Language Reference](https://kotlinlang.org/docs/home.html)

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 👤 Author

**Witty-Charm**

- GitHub: [@Witty-Charm](https://github.com/Witty-Charm)
- Project: [TextToWatch](https://github.com/Witty-Charm/TextToWatch)

## 🎓 Learning Resources

This project demonstrates:
- Firebase Realtime Database integration
- Android Jetpack Compose for UI
- Material Design 3 implementation
- Push notifications in Android
- Kotlin coroutines basics
- State management in Compose

## 💡 Future Enhancements

- [ ] User authentication with Firebase Auth
- [ ] Message history view
- [ ] Image sharing support
- [ ] Message search functionality
- [ ] User profiles
- [ ] Message timestamps
- [ ] Offline message queue
- [ ] Cloud messaging (FCM)

## 📞 Support

If you encounter any issues:

1. Check the [Troubleshooting](#-troubleshooting) section
2. Review Firebase Console for errors
3. Check Android Studio Logcat for debug messages
4. Open an [Issue](https://github.com/Witty-Charm/TextToWatch/issues) on GitHub

## 🙏 Acknowledgments

- Firebase for cloud database and messaging
- Google for Android and Jetpack libraries
- The Kotlin community for excellent language features

---

<div align="center">

Made with ❤️ by Witty-Charm

⭐ If you find this project useful, please consider giving it a star!

</div>
