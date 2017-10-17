package com.example.lazy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * Created by Lazy on 8/27/2016.
 */
public class InspectionActivity extends AppCompatActivity {
    String location, comm, st_bluebook, st_license, st_MaPaSe, model, number;
    TextView t_model, t_number;
    CheckBox license;
    CheckBox Bluebook;
    CheckBox MaPaSe;
    EditText et_location, et_comment, et_license;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inspection);


        license = (CheckBox)findViewById(R.id.checkBox);
        Bluebook = (CheckBox)findViewById(R.id.checkBox2);
        MaPaSe = (CheckBox)findViewById(R.id.checkBox3);
        et_license = (EditText) findViewById(R.id.editText6);
        et_location = (EditText) findViewById(R.id.editText8);
        et_comment = (EditText) findViewById(R.id.editText9);
        model = getIntent().getStringExtra("Model");
        number = getIntent().getStringExtra("mainMessage");
        t_model = (TextView)findViewById(R.id.textView11);
        t_number = (TextView)findViewById(R.id.textView16);
        st_bluebook = "No";
        st_MaPaSe="No";
        st_license = "0";

        t_model.setText(model);
        t_number.setText(number);

        et_license.setVisibility(View.GONE);

        license.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    et_license.setVisibility(View.VISIBLE);
                else
                    et_license.setVisibility(View.GONE);
            }
        });
        Bluebook.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    st_bluebook = "Yes";
                else
                    st_bluebook = "No";
            }
        });
        MaPaSe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    st_MaPaSe="Yes";
                else
                    st_MaPaSe="No";
            }
        });

    }
    public void onRegister(View view){
        location = et_location.getText().toString();
        comm = et_comment.getText().toString();

        if(et_license.isShown())
            st_license = et_license.getText().toString();
        else
            st_license = "0";
        String register_result;
        BackgroundTask backgroundTask = new BackgroundTask(this);
        try {
            register_result = backgroundTask.execute("InsReg", number, st_license, location, st_bluebook, comm, model, st_MaPaSe).get();
            register_result = register_result.replaceAll("Connected. ","");
            if (register_result.equals("Error")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(register_result)
                        .setCancelable(true)
                        .setNegativeButton("Retry", null)
                        .create()
                        .show();
                Toast.makeText(this,register_result,Toast.LENGTH_SHORT).show();
            } else {

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public void getJSON(View view){
        Intent i = new Intent(this, InfoActivity.class);
        i.putExtra("Num",number);
        startActivity(i);
    }
}
