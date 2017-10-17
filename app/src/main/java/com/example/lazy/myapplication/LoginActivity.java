package com.example.lazy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {



    EditText et_username,et_password;
    String username="",password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_login);
            et_username = (EditText) findViewById(R.id.etUserName);
            et_password = (EditText) findViewById(R.id.etPassword);
            et_username.setText("");
            et_password.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();
        et_username.setText("");
        et_password.setText("");
    }

    public void onClick(View view){

        username = et_username.getText().toString();
        password = et_password.getText().toString();

        if(username.equals("") || password.equals("")) {

            if (username.equals("") || !(username.matches("[a-zA-Z0-9._-]+"))) {
                et_username.setError("Valid PoliceID is required !!");
                // et_username.setText("");
                //et_username.setHint("Username must be filled!");
                // et_username.setHintTextColor(Color.RED);
            }

            if (password.equals("") || !(password.matches("[a-zA-Z0-9]+"))) {
                et_password.setError(" Valid Password is required !!");

                // et_email.setText("");
                // et_email.setHint("Email must be filled!");
                // et_email.setHintTextColor(Color.RED);
            }
          /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("One or more Fields Empty!!")
                    .setCancelable(false)
                    .setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            /*moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);*/
                       /*
                         finish();

                        }
                    })
                    .create()
                    .show();*/


        }else if((username.matches("[a-zA-Z0-9._-]+")) && (password.matches("[a-zA-Z0-9]+"))){

            String login_result;
            BackgroundTask backgroundTask = new BackgroundTask(this);
            try {
                login_result = backgroundTask.execute("Login", username, password).get();
                login_result = login_result.replaceAll("Connected. ","");
                if (login_result.equals("Login success !! Welcome user")) {

                    Toast.makeText(this,login_result,Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, MainActivity.class);

                    final EditText mainUsername= (EditText)findViewById(R.id.etUserName);
                    String mainMessage = mainUsername.getText().toString();
                    i.putExtra("mainMessage",mainMessage);

                    startActivity(i);
                    finish();

                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(login_result)
                            .setCancelable(true)
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                    Toast.makeText(this,login_result,Toast.LENGTH_SHORT).show();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }else {
            if(!(username.matches("[a-zA-Z0-9._-]+"))){
                et_username.setError("Invalid PoliceID !!");
                // et_username.setText("");
                // et_username.setHint("Only a-z A-Z 0-9 . _ - allowed!");
                //et_username.setHintTextColor(Color.RED);

            }
            if(!(password.matches("[a-zA-Z0-9]+"))){
                et_password.setError("Invalid Password !!");
                //et_password.setText("");
                //et_password.setHint("Only a-z A-Z 0-9 allowed!");
                //  et_password.setHintTextColor(Color.RED);

            }

        }

    }




    public void onTap(View view){
        Intent ii=new Intent(this,RegisterActivity.class);
        startActivity(ii);
    }

  /*  public void onBackPressed() {

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setView(R.layout.dialog_view)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })
                .create()
                .show();
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
