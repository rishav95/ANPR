package com.example.lazy.myapplication;

/**
 * Created by Lazy on 8/26/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

public class TessAsyncEngine extends AsyncTask<Object, Void, String> {

    static final String TAG = "DBG_" + TessAsyncEngine.class.getName();

    public Bitmap bmp;
    private Activity context;


    @Override
    protected String doInBackground(Object... params) {

        try {

            if(params.length < 2) {
                Log.e(TAG, "Error passing parameter to execute - missing params");
                return null;
            }

            if(!(params[0] instanceof Activity) || !(params[1] instanceof Bitmap)) {
                Log.e(TAG, "Error passing parameter to execute(context, bitmap)");
                return null;
            }

            context = (Activity)params[0];

            bmp = (Bitmap)params[1];

            if(context == null || bmp == null) {
                Log.e(TAG, "Error passed null parameter to execute(context, bitmap)");
                return null;
            }

            int rotate = 0;

            if(params.length == 3 && params[2]!= null && params[2] instanceof Integer){
                rotate = (Integer) params[2];
            }

            if(rotate >= -180 && rotate <= 180 && rotate != 0)
            {
                bmp = Tools.preRotateBitmap(bmp, rotate);
                Log.d(TAG, "Rotated OCR bitmap " + rotate + " degrees");
            }

            TessEngine tessEngine =  TessEngine.Generate(context);

            bmp = bmp.copy(Bitmap.Config.ARGB_8888, true);

            String result = tessEngine.detectText(bmp);

            Log.d(TAG, result);

            return result;

        } catch (Exception ex) {
            Log.d(TAG, "Error: " + ex + "\n" + ex.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {

        if(s == null || bmp == null || context == null)
            return;

        Intent i = new Intent(context, EntryActivity.class);
        i.putExtra("Bitmap",bmp);
        i.putExtra("Result",s);
        context.startActivity(i);
    }
}
