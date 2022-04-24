//package mag.majid2851.kotlintutorial.location
//
//import android.content.pm.PackageManager
//import android.location.Location
//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Toast
//import androidx.core.app.ActivityCompat
//import com.google.android.gms.common.ConnectionResult
//import com.google.android.gms.common.GooglePlayServicesUtil
//import com.google.android.gms.common.api.GoogleApi
//import com.google.android.gms.common.api.GoogleApiClient
//import com.google.android.gms.location.LocationListener
//import com.google.android.gms.location.LocationRequest
//import com.google.android.gms.location.LocationServices
//import kotlinx.android.synthetic.main.activity_location.*
//import mag.majid2851.kotlintutorial.R
//import java.sql.Connection
//
//class LocationActivity : AppCompatActivity(),GoogleApiClient.ConnectionCallbacks,
//    GoogleApiClient.OnConnectionFailedListener,LocationListener
//{
//    val PermissionRequestCode=1;
//    val PLAY_SERVICE_RESOULOTION_SERVICE=2;
//
//    var googleApiClient:GoogleApiClient ?=null
//    var locationRequest:LocationRequest?=null
//
//
//    override fun onCreate(savedInstanceState: Bundle?)
//    {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_location)
//
//         requestPermission()
//        if (checkPlayService())
//            buildGoogleApiClient()
//
//
//
//
//    }
//
//    private fun requestPermission()
//    {
//        if (ActivityCompat.checkSelfPermission(
//                this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
//        !=PackageManager.PERMISSION_GRANTED
//            &&
//            ActivityCompat.checkSelfPermission(
//                this,android.Manifest.permission.ACCESS_FINE_LOCATION)
//            !=PackageManager.PERMISSION_GRANTED       )
//        {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,
//                    android.Manifest.permission.ACCESS_COARSE_LOCATION),PermissionRequestCode)
//            }
//        }
//
//
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
//        grantResults: IntArray)
//    {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when(requestCode)
//        {
//            PermissionRequestCode ->{
//                if (grantResults.size>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    if (checkPlayService()){
//                        buildGoogleApiClient();
//                    }
//                }
//            }
//
//
//
//        }
//    }
//
//    private fun buildGoogleApiClient()
//    {
//        googleApiClient=GoogleApiClient.Builder(this)
//            .addConnectionCallbacks(this)
//            .addOnConnectionFailedListener(this)
//            .addApi(LocationServices.API).build()
//
//
//    }
//
//    private fun checkPlayService(): Boolean
//    {
//       val resultCode=GooglePlayServicesUtil.isGooglePlayServicesAvailable(this)
//        if (resultCode!=ConnectionResult.SUCCESS)
//        {
//            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode))
//            {
//                GooglePlayServicesUtil.getErrorDialog(resultCode,this,PLAY_SERVICE_RESOULOTION_SERVICE)?.show()
//
//            }else
//            {
//                Toast.makeText(applicationContext,"error happens",Toast.LENGTH_SHORT).show()
//                finish()
//            }
//            return false
//        }
//        return true
//
//    }
//
//    override fun onConnected(b: Bundle?) {
//        createLocationService();
//    }
//
//    private fun createLocationService() {
//        locationRequest= LocationRequest();
//        locationRequest!!.interval=1000;
//        locationRequest!!.fastestInterval=5000;
//        locationRequest!!.priority=LocationRequest.PRIORITY_HIGH_ACCURACY
//
//        if (ActivityCompat.checkSelfPermission(
//                this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
//            !=PackageManager.PERMISSION_GRANTED
//            &&
//            ActivityCompat.checkSelfPermission(
//                this,android.Manifest.permission.ACCESS_FINE_LOCATION)
//            !=PackageManager.PERMISSION_GRANTED       )
//        {
//            return
//        }
//        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient!!,
//            locationRequest!!,this)
//
//    }
//
//    override fun onConnectionSuspended(b: Int) {
//        googleApiClient!!.connect();
//    }
//
//    override fun onConnectionFailed(p0: ConnectionResult) {
//         Log.i("mag2851",":"+p0.errorCode)
//    }
//
//    override fun onLocationChanged(p0: Location) {
//        tv.text="latitude:${p0.latitude}\nlongtitude:${p0.longitude}"
//    }
//
//    override fun onStart() {
//        super.onStart()
//        if (googleApiClient!=null){
//            googleApiClient!!.connect()
//        }
//    }
//
//    override fun onDestroy() {
//        googleApiClient!!.disconnect();
//        super.onDestroy()
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        checkPlayService()
//    }
//
//}