package com.example.lazy.myapplication;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String> {
    Context ctx;
    String JSON_String;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        final  String REG_URL = "http://192.168.43.203/anpr/police/register.php";
        final  String LOG_URL = "http://192.168.43.203/anpr/police/login.php";
        final  String CHK_URL = "http://192.168.43.203/anpr/vehicle/check.php";
        final  String INS_URL = "http://192.168.43.203/anpr/vehicle/comreg.php";
        final  String JSON_URL = "http://192.168.43.203/anpr/vehicle/json_get_data.php";
        String method = params[0];
        if(method.equals("Register")){
            String name = params[1];
            String PoliceID = params[2];
            String email = params[3];
            String password = params[4];
            String phone = params[5];
            String age = params[6];

            // int roll_number = Integer.parseInt(rollnumber);

            try {
                URL url = new URL(REG_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("PoliceID","UTF-8")+"="+URLEncoder.encode(PoliceID,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine())!=null){
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (method.equals("Login")){

            String username = params[1];
            String password = params[2];

            try {
                URL url = new URL(LOG_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data =
                        URLEncoder.encode("PoliceID","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                                URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine())!=null){
                    response+= line;
                }
                bufferedReader.close();

                inputStream.close();
                httpURLConnection.disconnect();

                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("Check")) {
            String Number = params[1];

            try {
                URL url = new URL(CHK_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data =
                                URLEncoder.encode("Number","UTF-8")+"="+URLEncoder.encode(Number,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine())!=null){
                    response+= line;
                }
                bufferedReader.close();

                inputStream.close();
                httpURLConnection.disconnect();

                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("InsReg")) {
            String NumberPlate = params[1];
            String DriverLicense = params[2];
            String Location = params[3];
            String Bluebook = params[4];
            String Comm = params[5];
            String Model = params[6];
            String MaPaSe = params[7];

            try {
                URL url = new URL(INS_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data =
                        URLEncoder.encode("NumberPlate","UTF-8")+"="+URLEncoder.encode(NumberPlate,"UTF-8")+"&"+
                                URLEncoder.encode("DriverLicense","UTF-8")+"="+URLEncoder.encode(DriverLicense,"UTF-8")+"&"+
                                URLEncoder.encode("Location","UTF-8")+"="+URLEncoder.encode(Location,"UTF-8")+"&"+
                                URLEncoder.encode("Bluebook","UTF-8")+"="+URLEncoder.encode(Bluebook,"UTF-8")+"&"+
                                URLEncoder.encode("Comm","UTF-8")+"="+URLEncoder.encode(Comm,"UTF-8")+"&"+
                                URLEncoder.encode("Model","UTF-8")+"="+URLEncoder.encode(Model,"UTF-8")+"&"+
                                URLEncoder.encode("MaPaSe","UTF-8")+"="+URLEncoder.encode(MaPaSe,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";

                while ((line = bufferedReader.readLine())!=null){
                    response+= line;
                }
                bufferedReader.close();

                inputStream.close();
                httpURLConnection.disconnect();

                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("JSON")){
            try {
                String NumberPlate = params[1];
                URL url = new URL(JSON_URL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data =
                        URLEncoder.encode("NumberPlate","UTF-8")+"="+URLEncoder.encode(NumberPlate,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                while ((JSON_String = bufferedReader.readLine())!=null){
                    stringBuilder.append(JSON_String+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {

        //Toast.makeText(ctx,s,Toast.LENGTH_SHORT).show();
    }
}
