package com.weather;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Date: 28.05.12
 * Time: 21:02
 */

public class SecondaryView extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary);
    }

    public void fetch(View view)
    {
        String urlString = "http://api.met.no/weatherapi/textforecast/1.5/?forecast=land;language=nb";

        try
        {
            URL url = new URL(urlString);
        }
        catch (MalformedURLException e)
        {
            Log.d("Fetch", "Malformed URL!");
            return;
        }



    }

}