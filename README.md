# 📱 Material 3 SMS App

A modern Android SMS sending application built using **Jetpack Compose**, **Material 3 (Material You)**, and **MVVM Architecture**.

This project demonstrates clean architecture principles, reactive state management using `StateFlow`, runtime permission handling, and proper separation of concerns.

It is designed as a scalable foundation for production-level SMS-based Android applications.

---

# 📸 App Preview

> Add your screenshots inside a folder named `screenshots/` and reference them below.

## 🏠 Main Screen
![SMS Screen](screenshots/sms_screen.png)

## 🌙 Dark Mode (Optional)
![Dark Mode](screenshots/dark_mode.png)

---

# 🚀 Features

- ✅ Send SMS using `SmsManager`
- ✅ Multipart SMS support for long messages
- ✅ MVVM architecture
- ✅ StateFlow-based reactive UI
- ✅ Material 3 (Material You) UI
- ✅ Dynamic color support (Android 12+)
- ✅ Runtime permission handling
- ✅ Clean and modular project structure
- ✅ Loading state handling
- ✅ Error handling and status feedback

---

# 🏗 Architecture Overview

This project follows **MVVM (Model–View–ViewModel)** architecture.


### 🔹 UI Layer
- Built entirely using Jetpack Compose
- Observes `StateFlow` from ViewModel
- Reacts automatically to state changes

### 🔹 ViewModel Layer
- Holds UI state using `MutableStateFlow`
- Exposes immutable `StateFlow`
- Contains UI-related logic

### 🔹 Repository Layer
- Handles SMS sending logic
- Communicates with `SmsManager`
- Returns success/failure result

---

# 📁 Project Structure


This structure keeps the project scalable and maintainable.

---

# 🧠 Tech Stack

| Technology | Purpose |
|------------|----------|
| Kotlin | Programming Language |
| Jetpack Compose | Modern UI Toolkit |
| Material 3 | UI Components |
| MVVM | Architecture Pattern |
| StateFlow | Reactive State Management |
| SmsManager | SMS Sending API |
| Coroutines | Async & Flow Handling |

---

# ⚙️ Setup & Installation

## 1️⃣ Clone Repository


## 2️⃣ Open in Android Studio

- Open project
- Sync Gradle
- Run on physical device

## 3️⃣ Required Permission

Add to `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.SEND_SMS"/>

1.1.1

send sms perfect

1.1.2

read sms perfect