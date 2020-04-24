package com.example.finalproject

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

//import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentMaps : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    //private lateinit var database: DatabaseReference



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_maps, container, false)

        //val mapFragment = supportFragmentManager?.findFragmentById(R.id.map) as SupportMapFragment?
        //mapFragment?.getMapAsync(this)

        //database = FirebaseDatabase.getInstance().reference

        //fusedLocationClient =  LocationServices.getFusedLocationProviderClient(this)

        return rootView


    }

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



    private fun setUpMap() {

       map.isMyLocationEnabled = true
        map.mapType = GoogleMap.MAP_TYPE_NORMAL
        fusedLocationClient.lastLocation.addOnSuccessListener(){location ->
            if (location != null) {
                lastLocation = location
                var currentLatLong = LatLng(location.altitude, location.latitude)
                placeMarker(currentLatLong)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 16f))


            }
        }
        val puntos = mapOf(
            Pair(20.6648231, -101.3462155),
            Pair(20.663135, -101.343133),
            Pair(20.6634541, -101.342023)
        )

        for ((lati, long) in puntos) {
            val upv = LatLng(lati, long)
            placeMarker(upv)

        }
    }



}

