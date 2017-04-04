package com.example.prajan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UnitConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
    }
    public  void onClicker(View v){
        EditText ed = (EditText) findViewById(R.id.editText);
        TextView tv = (TextView) findViewById(R.id.convOutput);
        Button b = (Button) v;
        float i = Float.parseFloat(ed.getText().toString());

        String str = b.getText().toString();
        if (str.equals("km-m")){
            float ii = i*1000;
            tv.setText(Float.toString(i)+" Km = "+Float.toString(ii)+" m");
        }
        if (str.equals("m-cm")){
            float ii = i*100;
            tv.setText(Float.toString(i)+" m = "+Float.toString(ii)+" cm");
        }
        if (str.equals("kg-lbs")){
            float ii = i*2.20462f;
            tv.setText(Float.toString(i)+" Kg = "+Float.toString(ii)+" lbs");
        }
        if (str.equals("lbs-kg")){
            float ii = i*0.453592f;
            tv.setText(Float.toString(i)+" lbs = "+Float.toString(ii)+" kg");
        }
        if (str.equals("ft-m")){
            float ii = i*0.3048f;
            tv.setText(Float.toString(i)+" ft = "+Float.toString(ii)+" m");
        }
        if (str.equals("m-ft")){
            float ii = i*3.28084f;
            tv.setText(Float.toString(i)+" m = "+Float.toString(ii)+" ft");
        }
        if (str.equals("°F-°C")){
            float ii = (i-32)*0.56f;
            tv.setText(Float.toString(i)+" °F = "+Float.toString(ii)+" °C");
        }
        if (str.equals("°C-°F")){
            float ii = (i*1.8f)+32;
            tv.setText(Float.toString(i)+" °C = "+Float.toString(ii)+" °F");
        }
        if (str.equals("gal-ltr")){
            float ii = i*3.78541f;
            tv.setText(Float.toString(i)+" gal = "+Float.toString(ii)+" ltr");
        }
        if (str.equals("ltr-gal")){
            float ii = i*0.264172f;
            tv.setText(Float.toString(i)+" ltr = "+Float.toString(ii)+" gal");
        }
        if (str.equals("oz-ml")){
            float ii = i*29.5735f;
            tv.setText(Float.toString(i)+" oz = "+Float.toString(ii)+" ml");
        }
        if (str.equals("pint-ml")){
            float ii = i*473.176f;
            tv.setText(Float.toString(i)+" pint = "+Float.toString(ii)+" ml");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_unit_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
