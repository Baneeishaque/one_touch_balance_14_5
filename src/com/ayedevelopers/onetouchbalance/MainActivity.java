package com.ayedevelopers.onetouchbalance;



import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends ActionBarActivity {


    String mCodecb;
    String mCodesb;
    String mCodedb;
    String mCodecc;
    String mCoderc;


    EditText medit1;
    String medit;

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        String ussdCode = mCodecb;
        intent.setData(Uri.parse("tel:" + ussdCode));
        startActivity(intent);
    }

    public void rc(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        medit1=null;
        medit1 = (EditText) findViewById(R.id.editText);
        medit=null;
        medit = medit1.getText().toString();
        //String meditn = null;
        String ussdCode = "*" + mCoderc + "*" + medit + Uri.encode("#");

        if (isNullnum(medit)) {
            medit1.setError("Invalid Number");
        }
        else
        {
            intent.setData(Uri.parse("tel:" + ussdCode));
            startActivity(intent);
        }

    }

    private boolean isNullnum(String num) {
        if (num != null && num.length()==0) {
            return true;

        }

        else {
            String rc_pattern="[0-9]+";
            Pattern pattern=Pattern.compile(rc_pattern);
            Matcher matcher=pattern.matcher(num);
            return !matcher.matches();
           // return false;
        }
    }





    public void sms(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        String ussdCode = mCodesb;
        intent.setData(Uri.parse("tel:" + ussdCode));
        startActivity(intent);

    }

    public void data(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        String ussdCode = mCodedb;
        intent.setData(Uri.parse("tel:" + ussdCode));
        startActivity(intent);
    }

    public void care(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(mCodecc));
        startActivity(callIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = (Spinner) findViewById(R.id.opspinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.networks_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch(position){

                    case 0 : mCodecb = "*" + "121" + Uri.encode("#");
                        mCodesb =  "*" + "167" +"*"+"01"+ Uri.encode("#");
                        mCodedb = "*" + "125" + Uri.encode("#");
                        mCodecc=  "tel:198";
                        mCoderc="457";
                        break;
                    case 1 : mCodecb =   "*" + "123" + Uri.encode("#");
                        mCodesb =  "*" + "123" + "*" + "7" +Uri.encode("#");
                        mCodedb = "*" + "123" + "*" + "10" +Uri.encode("#");
                        mCodecc=  "tel:198";
                        mCoderc="101";
                        break;
                    case 2 : mCodecb =   "*" + "111" + "*" + "2" + Uri.encode("#");
                        mCodesb =  "*" + "142" + Uri.encode("#");
                        mCodedb = "*" + "111" + "*" + "6" + "*" + "2" + Uri.encode("#");
                        mCodecc=  "tel:198";
                        mCoderc="140";
                        break;
                    case 3 : mCodecb = "*" + "123" + Uri.encode("#");
                        mCodesb = "*" + "123" + "*" + "1" +Uri.encode("#");
                        mCodedb = "*" + "124" + "*" + "4" +Uri.encode("#");
                        mCodecc = "tel:198";
                        mCoderc="123";
                        break;
                    case 4 : mCodecb = "*" + "111" + Uri.encode("#");
                        mCodesb = "*" + "111" + "*" + "1" +Uri.encode("#");
                        mCodedb = "*" + "111" + "*" + "1" + Uri.encode("#");
                        mCodecc = "tel:198";
                        mCoderc="135"+"*"+"2";
                        break;
                    case 5 : mCodecb = "*" + "367" + Uri.encode("#");
                        mCodesb = "*" + "367" + "*" + "2" +Uri.encode("#");
                        mCodedb = "*" + "367" + "*" + "3" + Uri.encode("#");
                        mCodecc = "tel:198";
                        mCoderc="368";
                        break;
                    case 6 : mCodecb = "*" + "125" + Uri.encode("#");
                        mCodesb = "*" + "126" + "*" + "2" +Uri.encode("#");
                        mCodedb = "*" + "126" + "*" + "1" + Uri.encode("#");
                        mCodecc = "tel:198";
                        mCoderc="124";
                        break;



                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(MainActivity.this,SecActivity.class));



        }

        return super.onOptionsItemSelected(item);
    }
}
