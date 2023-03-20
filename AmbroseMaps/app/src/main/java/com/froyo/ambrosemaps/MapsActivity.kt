package com.froyo.ambrosemaps

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileObserver.ACCESS
import android.provider.CallLog
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.froyo.ambrosemaps.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    // we are going to use fused location client - gets current location
    private lateinit var fusedLocation: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        // load map in the background
        mapFragment.getMapAsync(this)
        // Start by initializing the fused location  - this helps you get where you are

        fusedLocation = LocationServices.getFusedLocationProviderClient(this)



    } // end oncreate

    // get current location
    fun setup(){
        // check if uses allowed GPS, if not ask them to allow
            if(ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
                return // will show a dialog to the user

            }// END IF

        mMap.isMyLocationEnabled = true // places a location button at top right
        fusedLocation.lastLocation.addOnSuccessListener(this) {
            location ->
            if (location!=null){
                val current = LatLng(location.latitude, location.longitude)
                mMap.addMarker(MarkerOptions()
                    .position(current)
                    .title("you are here!")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 14f))


            }// end if

            else {
                Toast.makeText(applicationContext, "No location Found",
                Toast.LENGTH_SHORT).show()
            } // end else



        } //





    } // end set up





    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val loc1 = LatLng(-1.262389, 36.814695)
        mMap.addMarker(MarkerOptions()
            .position(loc1)
            .title("Mp Shah,Parklands")
            .snippet("Good Health care Hotlines 076736xxxx")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon1)))

        val loc2 = LatLng(-1.250032, 36.813193)
        mMap.addMarker(MarkerOptions()
            .position(loc2)
            .title("Gerturudes children hospital,Parklands")
            .snippet("Good Health care Hotlines 076736xxxx")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon1)))

        val loc3 = LatLng(-1.219655, 36.923056)
        mMap.addMarker(MarkerOptions()
            .position(loc3)
            .title("St. francis,kasarani")
            .snippet("Good Health care Hotlines 076736xxxx")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon1)))

        val loc4 = LatLng(-1.273373, 36.985026)
        mMap.addMarker(MarkerOptions()
            .position(loc4)
            .title("ruai family,kayole")
            .snippet("Good Health care Hotlines 076736xxxx")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon1)))

        val loc5 = LatLng(-1.268739, 36.906920)
        mMap.addMarker(MarkerOptions()
            .position(loc5)
            .title("mama lucy kibaki,umoja")
            .snippet("Good Health care Hotlines 076736xxxx")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon1)))






        // Todo GPS getting current location
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc1,12f))

        setup()


    }
}