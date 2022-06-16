package com.tapitapp.tapitapp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.net.URL;

public class ConexionGETimg extends AsyncTask<String, String, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap res = null;
        try {
            URL url = new URL(params[0]);
            res = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
