package com.appsforkids.pasz.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image = (ImageView) findViewById(R.id.image);
        TextView id = (TextView) findViewById(R.id.id);
        TextView name = (TextView) findViewById(R.id.name);
        TextView author = (TextView) findViewById(R.id.author);
        TextView description = (TextView) findViewById(R.id.description);

        getFromJson(new GetJsonAudioList() {
            @Override
            public void getAudioFileArrayList(ArrayList<AudioFile> list) {

                Picasso.get().load(list.get(0).getImage()).into(image);
                id.setText(list.get(0).getId()+"");
                name.setText(list.get(0).getName());
                author.setText(list.get(0).getAuthor());
                description.setText(list.get(0).getDescription());
            }
        });

    }


    public void getFromJson(GetJsonAudioList getJsonAudioList) {

        ArrayList<AudioFile> musicItemArrayList = new ArrayList<>();

        ReadJson readJson = new ReadJson(new GetJson() {
            @Override
            public ArrayList<AudioFile> getJson(String result) {
                try {
                    String jsonText = result;
                    JSONObject jsonRoot = new JSONObject(jsonText);
                    JSONArray jsonArray = jsonRoot.getJSONArray("music");
                    //Toast.makeText(context, jsonArray.length()+" ", Toast.LENGTH_SHORT).show();
                    for (int i = 0; jsonArray.length() > i; i++) {
                        AudioFile audioFile = new AudioFile();
                        audioFile.setId(jsonArray.getJSONObject(i).getLong("id"));
                        audioFile.setFileName(jsonArray.getJSONObject(i).getString("file_name"));
                        audioFile.setName(jsonArray.getJSONObject(i).getString("name"));
                        audioFile.setAuthor(jsonArray.getJSONObject(i).getString("author"));
                        audioFile.setDescription(jsonArray.getJSONObject(i).getString("description"));
                        audioFile.setInternetLink(jsonArray.getJSONObject(i).getString("internet_link"));
                        audioFile.setStatus(jsonArray.getJSONObject(i).getBoolean("status"));
                        audioFile.setImage(jsonArray.getJSONObject(i).getString("image"));
                        audioFile.setType(jsonArray.getJSONObject(i).getString("type"));
                        musicItemArrayList.add(audioFile);
                    }

                    getJsonAudioList.getAudioFileArrayList(musicItemArrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void noAnswer(Boolean answer) {
            }
        });
        readJson.execute("https://koko-oko.com/audio/tales/tales.json");
    }
}