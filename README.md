# 📱 SMS Architecture Demo App

Jetpack Compose + Material 3 + MVVM

------------------------------------------------------------------------

## 📖 Overview

This project is a modern Android SMS application built using Jetpack
Compose and Material 3.\
It is designed from a **developer architecture perspective**, focusing
on scalability, clean structure, and maintainability.

This app demonstrates:

-   Clean MVVM architecture
-   Repository pattern
-   Model-driven expandable drawer navigation
-   Version-based screen structure (V1, V2)
-   Reading Incoming and Sent SMS
-   Separation of concerns between UI and business logic

This is not just an SMS app --- it is an architecture learning project.

------------------------------------------------------------------------

## 🏗 Architecture

The application follows layered architecture:

MainActivity\
→ AppDrawer (Navigation UI Layer)\
→ AppNavHost (Routing Layer)\
→ Screens (UI Layer)\
→ ViewModel (State Layer)\
→ Repository (Data Layer)\
→ Android SMS Content Provider

Each layer has a single responsibility.

------------------------------------------------------------------------

## 📂 Project Structure

com.example.smsapp

-   AppScreen.kt → Navigation model
-   MainActivity.kt → Entry point

ui/ - navigation/ - AppDrawer.kt - AppNavHost.kt - components/ -
AppTopBar.kt - inbox/ - v1/ - v2/ - incoming/ - v1/ - send/

viewmodel/ - InboxViewModel.kt

data/ - SmsReaderRepository.kt - SmsMessage.kt

------------------------------------------------------------------------

## 🧭 Navigation System

Navigation is model-driven using `AppScreen` and `DrawerSection`.

To add a new drawer section:

1.  Add a new object inside `AppScreen`
2.  Add it to `drawerStructure`
3.  Register route inside `AppNavHost`

No changes are required inside drawer UI logic.

------------------------------------------------------------------------

## ✉ SMS Features

### Send SMS

Uses Android `SmsManager`.

### Read Incoming SMS

Uses: Telephony.Sms.Inbox.CONTENT_URI

### Read Sent SMS

Uses: Telephony.Sms.Sent.CONTENT_URI

### Conversation Grouping (Inbox V2)

Messages grouped by sender using Kotlin `groupBy`.

------------------------------------------------------------------------

## 🧠 ViewModel Strategy

Uses `StateFlow` for reactive UI updates.

-   UI observes state
-   ViewModel loads data
-   Repository handles SMS queries
-   UI contains no business logic

------------------------------------------------------------------------

## 🗄 Repository Layer

All SMS queries are handled using Android `ContentResolver`.

Incoming messages → Inbox URI\
Outgoing messages → Sent URI

Filtering logic belongs strictly in the repository layer.

------------------------------------------------------------------------

## 🔐 Permissions

The app uses:

-   READ_SMS
-   SEND_SMS

Runtime permission handling is implemented.

------------------------------------------------------------------------

## 🚀 Scalability

This architecture allows:

-   Adding new drawer sections without modifying drawer UI
-   Adding new feature versions (V1, V2) safely
-   Extending into conversation screens
-   Adding unread badge counts
-   Supporting future MVI or Paging upgrades

------------------------------------------------------------------------

## 🎯 Purpose

This repository demonstrates how to evolve from:

"Make it work"

to

"Make it scalable and maintainable."

It serves as a structured example of modern Android development using
Jetpack Compose.


Docs added