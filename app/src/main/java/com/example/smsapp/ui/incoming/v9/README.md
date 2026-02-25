# Incoming V8 – Conversation List (Name-Aware)

## Purpose

Incoming V8 introduces contact‑aware conversations. Instead of showing only phone numbers, the screen now resolves sender identity using device contacts.

This version focuses on **clarity of conversations** rather than new navigation or UI experimentation.

---

## What is new in V8

* Contacts are read from the device (READ_CONTACTS)
* Phone numbers are normalized before matching
* Conversation sender shows **contact name if available**
* Falls back to number when contact not found
* No visible "contacts feature" for user – seamless integration

---

## User Experience Goal

Users think in people, not numbers.
V8 makes the inbox readable without changing workflow.

Before:

> +91 9876543210

After:

> Ramesh Kumar

---

## Architecture

### Data Flow

1. Load SMS messages
2. Load contacts map (number → name)
3. Normalize numbers
4. Group conversations by normalized sender
5. Replace address with contact name

```
IncomingScreenV8
    ├── loadIncomingSms()
    ├── loadContacts()
    └── groupBySender(messages, contactsMap)
```

---

## Design Principle

Silent enhancement.
No new screens required for basic usage.
Contacts improve SMS automatically.

---

## Not Included Yet

* Contacts browsing UI
* Contact sync settings screen
* Persistent caching (Room DB)
* Avatar photos

---

## Future Direction (Possible V9)

* Avatar initials / photo
* Fast search by name
* Thread screen name header
* Cached contacts repository

---

## Why this version exists

Previous versions (V1–V7) focused on layout and grouping.
V8 focuses on **identity recognition**.

This is the first version where conversations become human‑readable.
