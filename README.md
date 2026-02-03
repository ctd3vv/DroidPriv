<p align="center">
  <img src="https://raw.githubusercontent.com/ctd3vv/DroidPriv_site/refs/heads/main/logo.png" width="200">
</p>

<h1 align="center">DroidPriv</h1>

<p align="center">
  <img src="https://img.shields.io/github/last-commit/ctd3vv/DroidPriv?style=flat-square&color=green">
  <img src="https://img.shields.io/github/forks/ctd3vv/DroidPriv?style=flat-square&color=blue">
  <img src="https://img.shields.io/github/stars/ctd3vv/DroidPriv?style=flat-square&color=yellow">
  <img src="https://img.shields.io/github/license/ctd3vv/DroidPriv?style=flat-square&color=red">
</p>

---

DroidPriv is a diagnostic utility for the Android operating system, focused on verifying superuser (root) privilege integrity and displaying hardware and kernel metadata.

## Core Features

* **Multiphase Root Detection**: The system validates privileges through runtime command execution, filesystem binary searches, and identification of known managers (Magisk, KernelSU).
* **System Metadata Inspection**: Centralized display of the Linux kernel version, Android API level, and hardware model.
* **Modular Interface**: UI architecture based on Fragments and ViewPager2 for a clear separation between device information and privilege status.

## Technical Details

The project is developed in Java utilizing the following architectural components:
* ViewPager2: For fluid tab navigation.
* Material Design Components: Implementation of modern and responsive interfaces.
* Package Visibility Support: AndroidManifest query configurations for detecting root management apps on API 30 and above.

## System Requirements

* Minimum SDK: 30 (Android 11)
* Target SDK: 36 (Android 16)

## Installation and Build

To compile the project locally:
1. Clone the repository.
2. Import the project into Android Studio.
3. Sync Gradle files.
4. Execute the build using the command `./gradlew assembleDebug` or by pressing **Shift + F10**.

## License

This project is licensed under the GNU General Public License v3.0 (GPLv3). Refer to the LICENSE file for more details regarding the open-source requirements and credit attribution.

