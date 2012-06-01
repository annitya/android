package com.weather;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.weather.com.weather.rest.RestLoader;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Date: 28.05.12
 * Time: 21:02
 */

public class SecondaryView extends Activity implements LoaderManager.LoaderCallbacks<RestLoader.WebData>
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary);
    }

    public void fetch(View view)
    {
        String urlString = "http://api.met.no/weatherapi/textforecast/1.5/?forecast=land;language=nb";
        Bundle bundle = new Bundle();
        bundle.putString("urlString", urlString);
        getLoaderManager().initLoader(0, bundle, this).forceLoad();
    }

    @Override
    public Loader<RestLoader.WebData> onCreateLoader(int i, Bundle bundle)
    {
        return new RestLoader(this, bundle.getString("urlString"));
    }

    @Override
    public void onLoadFinished(Loader<RestLoader.WebData> webDataLoader, RestLoader.WebData webData)
    {
        TextView resultView = (TextView)findViewById(R.id.WebDataResult);
        resultView.setText(webData.getData());
    }

    @Override
    public void onLoaderReset(Loader<RestLoader.WebData> webDataLoader)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}