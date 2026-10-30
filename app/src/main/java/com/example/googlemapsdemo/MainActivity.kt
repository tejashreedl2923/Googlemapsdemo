package com.example.googlemapsdemo
import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private lateinit var locationManager: LocationManager

    private lateinit var txtLatitude: TextView
    private lateinit var txtLongitude: TextView
    private lateinit var txtAccuracy: TextView
    private lateinit var txtStatus: TextView

    private lateinit var btnGetLocation: Button
    private lateinit var btnLiveUpdates: Button

    private var isTracking = false

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            displayLocation(location)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLatitude = findViewById(R.id.txtLatitude)
        txtLongitude = findViewById(R.id.txtLongitude)
        txtAccuracy = findViewById(R.id.txtAccuracy)
        txtStatus = findViewById(R.id.txtStatus)

        btnGetLocation = findViewById(R.id.btnGetLocation)
        btnLiveUpdates = findViewById(R.id.btnLiveUpdates)

        locationManager =
            getSystemService(LOCATION_SERVICE) as LocationManager

        btnGetLocation.setOnClickListener {
            getCurrentLocation()
        }

        btnLiveUpdates.setOnClickListener {
            toggleLiveUpdates()
        }
    }

    private fun hasLocationPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            100
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )

        if (requestCode == 100) {
            if (grantResults.isNotEmpty() &&
                grantResults.any {
                    it == PackageManager.PERMISSION_GRANTED
                }
            ) {
                getCurrentLocation()
            } else {
                txtStatus.text = "Location permission denied."
                Toast.makeText(
                    this,
                    "Location permission is required.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun getCurrentLocation() {
        if (!hasLocationPermission()) {
            requestLocationPermission()
            return
        }

        try {
            val location = locationManager.getLastKnownLocation(
                LocationManager.GPS_PROVIDER
            )

            if (location != null) {
                displayLocation(location)
            } else {
                txtStatus.text = "Waiting for GPS location..."
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    2000L,
                    1f,
                    locationListener
                )
            }
        } catch (e: SecurityException) {
            txtStatus.text = "Location permission required."
        }
    }

    private fun toggleLiveUpdates() {
        if (!hasLocationPermission()) {
            requestLocationPermission()
            return
        }

        if (!isTracking) {
            try {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    2000L,
                    1f,
                    locationListener
                )

                isTracking = true
                btnLiveUpdates.text = "Stop Live Updates"
                txtStatus.text = "Live location updates started."

            } catch (e: SecurityException) {
                txtStatus.text = "Location permission required."
            }

        } else {
            stopLiveUpdates()
        }
    }

    private fun displayLocation(location: Location) {
        txtLatitude.text = String.format("%.6f", location.latitude)
        txtLongitude.text = String.format("%.6f", location.longitude)
        txtAccuracy.text = "±${location.accuracy.toInt()} m"

        txtStatus.text = "Location updated successfully."
    }

    private fun stopLiveUpdates() {
        locationManager.removeUpdates(locationListener)
        isTracking = false
        btnLiveUpdates.text = "Start Live Updates"
        txtStatus.text = "Live location updates stopped."
    }

    override fun onDestroy() {
        super.onDestroy()

        if (::locationManager.isInitialized) {
            locationManager.removeUpdates(locationListener)
        }
    }
}
