package com.weather.com.weather.rest;

import android.content.AsyncTaskLoader;
import android.content.Context;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Henning
 * Date:01.06. 12
 * Time: 09:31
 * To change this template use File | Settings | File Templates.
 */
public class RestLoader extends AsyncTaskLoader<RestLoader.WebData>
{
    protected String uri;

    public RestLoader(Context context)
    {
        super(context);
    }

    public RestLoader(Context context, String uri)
    {
        this(context);
        this.uri = uri;
    }

    @Override
    public WebData loadInBackground()
    {
        HttpGet request = new HttpGet(uri);
        DefaultHttpClient client = new DefaultHttpClient();
        try
        {
            HttpResponse response = client.execute(request);
            return new WebData(EntityUtils.toString(response.getEntity()));
        }
        catch (IOException e)
        {
            return new WebData();
        }
    }

    public class WebData
    {
        protected String data;

        public WebData()
        {

        }

        public WebData(String response)
        {
            data = response;
        }

        public String getData()
        {
            return data;
        }
    }
}
