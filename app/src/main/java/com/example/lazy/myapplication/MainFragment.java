package com.example.lazy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment{

    ImageButton button;
    Button b;
    ImageView img;
    EditText et_Lot, et_Number;
    String District, Type, Lot, RegNumber, Number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_main,
                container, false);
        button = (ImageButton) rootView.findViewById(R.id.button);

        b = (Button) rootView.findViewById(R.id.button5);
        img = (ImageView) rootView.findViewById(R.id.img);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Lot = et_Lot.getText().toString();
                RegNumber = et_Number.getText().toString();

                if (Lot.equals("") || Lot.length() > 3||RegNumber.equals("") || RegNumber.length() > 4||District.equals("")||Type.equals("")) {
                    if (Lot.equals(""))
                        et_Lot.setError("Lot Number is required !!");
                    else if (Lot.length() > 3)
                        et_Lot.setError("Lot Number should not be greater than 3 digits");
                    else if (RegNumber.equals(""))
                        et_Number.setError("Vehicle Registration Number is required !!");
                    else if (RegNumber.length() > 4)
                        et_Number.setError("Vehicle Registration Number can't be more than 4 digits !!");
                    else if (District.equals(""))
                        Toast.makeText(getActivity(),"Please select a district to continue !!",Toast.LENGTH_SHORT).show();
                    else if (Type.equals(""))
                        Toast.makeText(getActivity(),"Please select a Vehicle Type to continue !!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Number = District + " " + Lot + " " + Type + " " + RegNumber;
                    String login_result;
                    BackgroundTask backgroundTask = new BackgroundTask(getActivity());
                    try {
                        login_result = backgroundTask.execute("Check",Number).get();
                        login_result = login_result.replaceAll("Connected. ","");
                        if ((login_result.equals("Vehicle hasn't been registered yet!!"))||(login_result.equals("Error"))) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setMessage(login_result)
                                    .setCancelable(true)
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        } else {

                            Intent i = new Intent(getActivity(), InspectionActivity.class);

                            i.putExtra("mainMessage",Number);
                            i.putExtra("Model",login_result);

                            startActivity(i);


                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        String str = getActivity().getIntent().getStringExtra("mainMessage");
        final TextView secondText = (TextView) rootView.findViewById(R.id.textView5);
        secondText.setText(str);
        et_Lot = (EditText) rootView.findViewById((R.id.editText));
        et_Number = (EditText) rootView.findViewById((R.id.editText4));

        et_Lot.setText("");
        et_Number.setText("");


        final Spinner dropdown1 = (Spinner) rootView.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.district, android.R.layout.simple_spinner_item);
        dropdown1.setAdapter(adapter1);

        final Spinner dropdown2 = (Spinner) rootView.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.Type, android.R.layout.simple_spinner_item);
        dropdown2.setAdapter(adapter2);

        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                parent.getItemAtPosition(position);
                position = dropdown1.getSelectedItemPosition();
                if (position == 0)
                    District = null;
                else if (position == 1)
                    District = "DHA";
                else if (position == 2)
                    District = "ME";
                else if (position == 3)
                    District = "KO";
                else if (position == 4)
                    District = "SA";
                else if (position == 5)
                    District = "JA";
                else if (position == 6)
                    District = "BA";
                else if (position == 7)
                    District = "NA";
                else if (position == 8)
                    District = "GA";
                else if (position == 9)
                    District = "LU";
                else if (position == 10)
                    District = "RA";
                else if (position == 11)
                    District = "BHE";
                else if (position == 12)
                    District = "KA";
                else if (position == 13)
                    District = "SE";
                else if (position == 14)
                    District = "MA";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                parent.getItemAtPosition(position);
                position = dropdown2.getSelectedItemPosition();
                if (position == 0)
                    Type = null;
                else if (position == 1)
                    Type = "PA";
                else if (position == 2)
                    Type = "CHA";
                else if (position == 3)
                    Type = "KA";
                else if (position == 4)
                    Type = "JA";
                else if (position == 5)
                    Type = "KHA";}

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /*for (String path : paths) {
            File dir = new File(path);
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    Log.v(TAG, "ERROR: Creation of directory " + path + " on sdcard failed");
                    return null;
                } else {
                    Log.v(TAG, "Created directory " + path + " on sdcard");
                }
            }

        }*/

        // lang.traineddata file with the app (in assets folder)
        // You can get them at:
        // http://code.google.com/p/tesseract-ocr/downloads/list
        // This area needs work and optimization
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ImgActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return rootView;

    }
}
