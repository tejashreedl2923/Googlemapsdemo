# GPS Location Tracker - Android Application

## Overview

GPS Location Tracker is an Android application developed using Kotlin and XML in Android Studio. The Android Studio project is named `GoogleMapsDemo`.

The application demonstrates GPS-based location retrieval using Android's built-in LocationManager service. It retrieves the device's geographical coordinates and displays latitude, longitude, and GPS accuracy in a clean, user-friendly interface.

The application also provides live location updates, allowing users to continuously monitor changes in their geographical coordinates.

## Aim

To develop an Android application that retrieves and displays the device's current geographical location using Android location services and demonstrates GPS tracking with runtime permission handling.

## Objectives

- To understand the working of GPS-based location services in Android.
- To retrieve geographical coordinates using LocationManager.
- To display latitude and longitude values.
- To calculate and display GPS accuracy in metres.
- To implement live location updates using LocationListener.
- To implement runtime permission handling for accessing device location.
- To design a user-friendly interface using XML layouts.

## Technologies Used

- **Programming Language:** Kotlin
- **User Interface:** XML
- **Development Environment:** Android Studio
- **Platform:** Android
- **Location Service:** LocationManager
- **Location Updates:** LocationListener
- **Permissions:** ACCESS_FINE_LOCATION and ACCESS_COARSE_LOCATION
- **UI Components:** TextView, Button, LinearLayout, ScrollView

## Features

### 1. Get Current Location

Retrieves the device's available GPS location and displays the geographical coordinates.

### 2. Latitude Display

Displays the latitude value representing the device's north-south geographical position.

### 3. Longitude Display

Displays the longitude value representing the device's east-west geographical position.

### 4. GPS Accuracy

Displays the estimated accuracy of the retrieved location in metres.

### 5. Live Location Updates

Allows users to continuously retrieve updated GPS coordinates at regular intervals.

### 6. Stop Live Updates

Provides an option to stop continuous location tracking when it is no longer required.

### 7. Runtime Permission Handling

Requests location permission before accessing the device's geographical location. If permission is denied, the application displays an appropriate message.

### 8. Custom User Interface

Provides a dark-themed dashboard with lavender and purple accents for displaying location information.

## Application Workflow

1. Launch the GPS Location Tracker application.
2. The application checks whether location permissions have been granted.
3. If permission has not been granted, Android displays a permission request.
4. The user grants location permission.
5. Tap the Get Location button to retrieve the available GPS coordinates.
6. The application displays latitude, longitude, and accuracy.
7. Tap Start Live Updates to continuously retrieve location information.
8. The coordinates are updated whenever a new GPS location is received.
9. Tap Stop Live Updates to stop continuous tracking.

## Concepts Used

### 1. Location-Based Services

Location-Based Services use geographical information to provide location-related functionality.

Android provides location APIs that allow applications to retrieve the device's geographical position using available location providers.

### 2. LocationManager

LocationManager is an Android system service used to access location information from different providers, such as GPS and network-based location providers.

Example:

```kotlin
locationManager =
    getSystemService(LOCATION_SERVICE) as LocationManager
```

### 3. GPS Provider

The GPS provider retrieves geographical coordinates using satellite-based positioning.

The application uses:

`LocationManager.GPS_PROVIDER`

### 4. LocationListener

LocationListener receives notifications whenever the device's geographical location changes.

Example:

```kotlin
private val locationListener = object : LocationListener {

    override fun onLocationChanged(location: Location) {
        displayLocation(location)
    }
}
```

### 5. Runtime Permissions

Android requires applications to request permission before accessing sensitive device information such as location.

The application uses the following permissions:

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />

<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
```

### 6. Location Coordinates

Geographical coordinates consist of latitude and longitude.

- Latitude represents the north-south position.
- Longitude represents the east-west position.
- Accuracy indicates the estimated uncertainty of the location in metres.

### 7. Live Location Updates

The application uses requestLocationUpdates() to receive location updates at specified time intervals and distance changes.

Example:

```kotlin
locationManager.requestLocationUpdates(
    LocationManager.GPS_PROVIDER,
    2000L,
    1f,
    locationListener
)
```

### 8. Stopping Location Updates

The application uses removeUpdates() to stop receiving location updates when live tracking is disabled or the activity is destroyed.

Example:

```kotlin
locationManager.removeUpdates(locationListener)
```

## Project Structure

```text
GoogleMapsDemo/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/
│           │       └── example/
│           │           └── googlemapsdemo/
│           │               └── MainActivity.kt
│           ├── res/
│           │   └── layout/
│           │       └── activity_main.xml
│           └── AndroidManifest.xml
├── README.md
├── build.gradle.kts
└── settings.gradle.kts
```

## Installation and Execution

1. Install Android Studio.
2. Clone or download the repository.
3. Open the GoogleMapsDemo project in Android Studio.
4. Allow Gradle to sync successfully.
5. Connect an Android device or start an emulator with location services enabled.
6. Run the application.
7. Grant location permission when prompted.
8. Tap Get Location to retrieve the device's coordinates.
9. Tap Start Live Updates to enable continuous location tracking.
10. Tap Stop Live Updates to stop tracking.

## Testing

| Test Case | Expected Result | Status |
|---|---|---|
| Launch the application | GPS Location Tracker screen is displayed | Pass |
| Grant location permission | Application receives location access | Pass |
| Deny location permission | Permission message is displayed | Pass |
| Tap Get Location | Latitude and longitude are displayed | Pass |
| Retrieve GPS accuracy | Accuracy is displayed in metres | Pass |
| Start Live Updates | Location updates are received | Pass |
| Stop Live Updates | Continuous tracking is stopped | Pass |
| Disable location services | Location retrieval may fail or wait for GPS | To Verify |

## Screenshots

Add screenshots of the actual application in the following locations.

### Home Screen

<img width="1366" height="720" alt="Screenshot 2026-10-30 220922" src="https://github.com/user-attachments/assets/982372f8-48ed-49b8-99d6-d9a267865d1f" />


### Location Permission Request

<img width="718" height="1598" alt="image" src="https://github.com/user-attachments/assets/f7d3bad2-9d2e-4e18-a68d-b7619de4985d" />

### GPS Coordinates Display

<img width="718" height="1598" alt="image" src="https://github.com/user-attachments/assets/ad3679b7-80c6-4a52-9c08-a0086956ee99" />



## Learning Outcomes

- Understood Android location-based services.
- Learned to access device location using LocationManager.
- Implemented GPS-based coordinate retrieval.
- Learned to display latitude, longitude, and accuracy.
- Understood runtime permission handling.
- Implemented LocationListener for live updates.
- Learned to start and stop location tracking.
- Designed an Android interface using Kotlin and XML.

## Future Enhancements

- Display the current geographical address using reverse geocoding.
- Add a visual map using a suitable map provider.
- Display the user's current location using a map marker.
- Add location history functionality.
- Improve GPS status and accuracy information.
- Add background location tracking with appropriate permissions.
- Improve the interface with additional location-related features.

## Conclusion

The GPS Location Tracker application successfully demonstrates how to retrieve and display geographical location information using Android's built-in LocationManager service.

The application provides latitude, longitude, GPS accuracy, and live location updates through a simple and user-friendly interface.

This project helps in understanding Android location services, GPS providers, LocationManager, LocationListener, and runtime permission handling.

## Student Details

**Name:** Tejashree DL

**USN:** 25MCAR0124
