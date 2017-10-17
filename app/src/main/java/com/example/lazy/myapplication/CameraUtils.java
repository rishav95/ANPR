package com.example.lazy.myapplication;

/**
 * Created by Lazy on 8/26/2016.
 */
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;

public class CameraUtils {

    static final String TAG = "DBG_ " + CameraUtils.class.getName();

    public static boolean deviceHasCamera(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    public static Camera getCamera() {
        try {
            return Camera.open();
        } catch (Exception e) {
            Log.e(TAG, "Cannot getCamera()");
            return null;
        }
    }
}
