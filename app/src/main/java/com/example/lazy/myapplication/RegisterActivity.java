package com.example.lazy.myapplication;

/**
 * Created by Lazy on 8/3/2016.
 */

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


public class RegisterActivity extends AppCompatActivity {

    EditText et_name,et_PoliceID,et_email,et_password,et_phone,et_age;
    String name,PoliceID,email,password,phone,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_name = (EditText)findViewById(R.id.editName);
        et_PoliceID = (EditText)findViewById(R.id.editPoliceID);
        et_email = (EditText)findViewById(R.id.editTextEmail);
        et_password = (EditText)findViewById(R.id.editTextPassword);
        et_phone = (EditText)findViewById(R.id.editPhone);
        et_age = (EditText)findViewById(R.id.editAge);
    }


    public void onClick(View view){
        name = et_name.getText().toString();
        PoliceID = et_PoliceID.getText().toString();
        email = et_email.getText().toString();
        password = et_password.getText().toString();
        age = et_age.getText().toString();
        phone = et_phone.getText().toString();

        if(name.equals("")|| PoliceID.equals("")|| email.equals("")|| password.length()<6 || age.equals("") || phone.equals("")) {
            if (name.length()==0) {
                et_name.setError("Name is required !!");
                // et_name.setText("");
                // et_name.setHint("Name must be filled!");
                //et_name.setHintTextColor(Color.RED);
            }

            if (PoliceID.equals("")||!(PoliceID.matches("[a-zA-Z0-9._-]+"))) {
                et_PoliceID.setError("PoliceID is required and Only a-z A-Z 0-9 . _ - allowed !!");

            }

            if (email.equals("")||!(email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {
                et_email.setError(" Valid Email is required !!");


            }

            if (password.length()<6 || !(password.matches("[a-zA-Z0-9]+"))) {
                et_password.setError("Password must be at least 6 characters and Only a-z A-Z 0-9 allowed !!");

            }

            if (age.equals("") || (Integer.parseInt(age)<21 || Integer.parseInt(age) >70 )){
                et_age.setError("Valid Age is required !!");


            }
            if(phone.equals("")){
                et_phone.setError("Valid Phone Number must be entered !!");
            }

        }
        else if (!(Integer.parseInt(age)<21 || Integer.parseInt(age)>70) && (email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") && (PoliceID.matches("[a-zA-Z0-9._-]+")) && (password.matches("[a-zA-Z0-9]+"))))
        {
            String register_result;
            BackgroundTask backgroundTask = new BackgroundTask(this);
            try {
                register_result = backgroundTask.execute("Register", name, PoliceID, email, password, phone, age).get();
                register_result = register_result.replaceAll("Connected. ","");
                if (register_result.equals("Registration Successful!!")) {
                    Toast.makeText(this, register_result, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(register_result)
                            .setCancelable(false)
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        else
        {
            if (!(email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {
                et_email.setError("Valid email is required !!");


            }
            if (Integer.parseInt(age)<21 || Integer.parseInt(age)>70) {
                et_age.setError("Valid Roll number is required !!");


            }
            if(!(PoliceID.matches("[a-zA-Z0-9._-]+"))){
                et_PoliceID.setError("Only a-z A-Z 0-9 . _ - allowed !!");


            }
            if(!(password.matches("[a-zA-Z0-9]+"))){
                et_password.setError("Password must be at least 6 characters and Only a-z A-Z 0-9 allowed !!");


            }
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
