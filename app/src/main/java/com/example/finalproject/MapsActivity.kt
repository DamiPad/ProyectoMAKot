package com.example.finalproject
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.BitmapDescriptorFactory


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    //private lateinit var database: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

            //database = FirebaseDatabase.getInstance().reference

        fusedLocationClient =  LocationServices.getFusedLocationProviderClient(this)

    }

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
        map = googleMap

        // Add a marker in Sydney and move the camera


        map.setOnMapClickListener { this }
        map.uiSettings.isZoomControlsEnabled = true


        setUpMap()
    }

    private fun placeMarker(location: LatLng){
        val markerOptions = MarkerOptions().position(location)
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        map.addMarker(markerOptions)






    }

    override fun onMarkerClick(p0: Marker?) = false



    private fun setUpMap(){
        if(ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),LOCATION_PERMISSION_REQUEST_CODE)
            return

        }
        map.isMyLocationEnabled= true
        map.mapType= GoogleMap.MAP_TYPE_NORMAL
        fusedLocationClient.lastLocation.addOnSuccessListener(this) {location ->
            if(location != null){
                lastLocation= location
                var currentLatLong =  LatLng (location.altitude, location.latitude)
                placeMarker(currentLatLong)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 16f))



            }
        }
        val puntos = mapOf(Pair(20.6648231,-101.3462155), Pair(20.663135, -101.343133), Pair(20.6634541,-101.342023))

        for ((lati, long) in puntos) {
            val upv = LatLng(lati,long)
            placeMarker(upv)

        }

        /*   val puntoListener = object : ValueEventListener {

                       override fun onDataChange(dataSnapshot: DataSnapshot) {

                           val puntos = dataSnapshot.getValue(puntos::class.java)
                           var latitud =puntos!!.latitud
                           var altitud = puntos!!.altitud
                           val upv = LatLng(latitud,altitud)
                           placeMarker(upv)


                       }

                       override fun onCancelled(databaseError: DatabaseError) {
                       }
                   }
                    database.addValueEventListener(puntoListener)


                    */






    }

}
