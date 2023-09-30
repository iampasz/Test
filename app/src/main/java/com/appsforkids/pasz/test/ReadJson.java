package com.appsforkids.pasz.test;


import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadJson extends AsyncTask<String, String, String> {

    GetJson getJson;
    boolean answer = false;

    public ReadJson(GetJson getJson){
        this.getJson = getJson;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(String... params) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                //Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

            }

            //Log.i("TAG_RESALT", buffer.toString()+"");

            return buffer.toString();


        } catch (MalformedURLException e) {
            //Log.i("TAG_RESALT", e+"");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            //Log.i("TAG_RESALT", e+"");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                //Log.i("TAG_RESALT", e+"");
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        //Log.i("TAG_RESALT", result+"");
        if(result==null){
            getJson.noAnswer(false);
        }else{
            getJson.noAnswer(true);
            getJson.getJson(result);

            answer = true;
        }

    }
}
