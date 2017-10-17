package com.example.lazy.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * Created by Lazy on 8/26/2016.
 */
public class EntryActivity extends AppCompatActivity {
    ImageButton button;
    EditText num;
    String Number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_entry);

        Intent intent = getIntent();
        Bitmap bitmap = intent.getParcelableExtra("Bitmap");

        button = (ImageButton) findViewById(R.id.button);
        ImageView img = (ImageView) findViewById(R.id.img);
        EditText num = (EditText) findViewById(R.id.editText5);

        String str = getIntent().getStringExtra("Result");

        num.setText(str);
        img.setImageBitmap(bitmap);


    }
    public void onClick(View view) {
                Intent intent = new Intent(this, ImgActivity.class);
                startActivity(intent);
            }

    public void onProcess(View view) {
        Number = num.getText().toString();
        String login_result;
        BackgroundTask backgroundTask = new BackgroundTask(this);
        try {
                login_result = backgroundTask.execute("Check", Number).get();
                login_result = login_result.replaceAll("Connected. ","");
                if (login_result.equals("Vehicle hasn't been registered yet!!")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(login_result)
                            .setCancelable(true)
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                    Toast.makeText(this,login_result,Toast.LENGTH_SHORT).show();

                } else {
                    Intent i = new Intent(this, InspectionActivity.class);

                    i.putExtra("mainMessage",Number);
                    i.putExtra("Model",login_result);

                    startActivity(i);
                    finish();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }