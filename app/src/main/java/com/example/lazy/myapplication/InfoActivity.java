package com.example.lazy.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by Lazy on 8/3/2016.
 */
public class InfoActivity extends AppCompatActivity {
    BackgroundTask backgroundTask;
    String abc,Number;
    View view;
    ContactAdaptor contactAdaptor;
    ListView listView;

    JSONObject jsonObject;
    JSONArray jsonArray;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        listView = (ListView)findViewById(R.id.list);
        contactAdaptor = new ContactAdaptor(this, R.layout.activity_info);
        listView.setAdapter(contactAdaptor);
        backgroundTask = new BackgroundTask(this);
        Number = getIntent().getExtras().getString("Num");




        try {
            abc = backgroundTask.execute("JSON",Number).get();
            abc = abc.replaceAll("Connected. ","");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        try {
            int count=0;
            String ID, Num, Lic, Loc, BB, Model, Comm, MaPaSe, Date;
            jsonObject = new JSONObject(abc);
            jsonArray = jsonObject.getJSONArray("server_response");
            while(count<jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                ID = JO.getString("InspectionID");
                Num = JO.getString("NumberPlate");
                Lic = JO.getString("DriverLicense");
                Loc = JO.getString("Location");
                BB = JO.getString("Bluebook");
                Model = JO.getString("Model");
                Comm = JO.getString("Comment");
                MaPaSe = JO.getString("MaPaSe");
                Date = JO.getString("Date");
                Contacts contacts = new Contacts(ID, Num, Lic, Loc, BB, Model, Comm, MaPaSe,Date);
                contactAdaptor.add(contacts);

                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
