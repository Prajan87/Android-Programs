package com.example.prajan.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> calcArray2 = new ArrayList<String>();
    String s;


    public  void onClickBinary(View v)
    {
        TextView Output2 = (TextView)findViewById(R.id.textView6);
        Button b = (Button) v;
        if (s.equals("Decimal")){
             Output2.setText(Integer.toBinaryString(Integer.parseInt(calcArray2.get(0))));

        }
        if (s.equals("Octal")){
            Output2.setText(Integer.toBinaryString(Integer.parseInt(calcArray2.get(0),8)));

        }
        if (s.equals("HexaDecimal")){
            Output2.setText(Integer.toBinaryString(Integer.parseInt(calcArray2.get(0),16)));
        }

    }
    public  void onClickDecimal(View v)
    {
        TextView Output2 = (TextView)findViewById(R.id.textView6);
        Button b = (Button) v;
        if (s.equals("Binary")){
            int i =Integer.parseInt((calcArray2.get(0)), 2);
            Output2.setText(Integer.toString(i));

        }
        if (s.equals("Octal")){
            Output2.setText(Integer.toString(Integer.parseInt(calcArray2.get(0),8)));

        }
        if (s.equals("HexaDecimal")){
            Output2.setText(Integer.toString(Integer.parseInt(calcArray2.get(0),16)));
        }

    }
    public  void onClickOctal(View v)
    {
        TextView Output2 = (TextView)findViewById(R.id.textView6);
        Button b = (Button) v;
        if (s.equals("Decimal")){
            Output2.setText(Integer.toOctalString(Integer.parseInt(calcArray2.get(0))));

        }
        if (s.equals("Binary")){
            Output2.setText(Integer.toOctalString(Integer.parseInt(calcArray2.get(0), 2)));

        }
        if (s.equals("HexaDecimal")){
            Output2.setText(Integer.toOctalString(Integer.parseInt(calcArray2.get(0), 16)));
        }
    }
    public  void onClickHexa(View v)
    {
        TextView Output2 = (TextView)findViewById(R.id.textView6);
        Button b = (Button) v;
        if (s.equals("Decimal")){
            Output2.setText(Integer.toHexString(Integer.parseInt(calcArray2.get(0))));

        }
        if (s.equals("Octal")){
            Output2.setText(Integer.toHexString(Integer.parseInt(calcArray2.get(0),8)));

        }
        if (s.equals("Binary")){
            Output2.setText(Integer.toHexString(Integer.parseInt(calcArray2.get(0),2)));
        }
    }



public void show(int i){
    switch (i){
        case 1:
            s="Binary";
            break;
        case 2:
            s="Octal";
            break;
        case 3:
            s="Decimal";
            break;
        case 4:
            s="HexaDecimal";
            break;
    }

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        calcArray2 = i.getStringArrayListExtra("array");
        TextView output = (TextView)findViewById(R.id.textView3);
        output.setText(TextUtils.join(", ", calcArray2));

        final RadioGroup Rbutton = (RadioGroup) findViewById(R.id.myRadioGroup);
        final RadioButton Binary = (RadioButton) findViewById(R.id.Binary);
        final RadioButton Octal = (RadioButton) findViewById(R.id.Octal);
        final RadioButton Decimal = (RadioButton) findViewById(R.id.Decimal);
        final RadioButton HexaDecimal = (RadioButton) findViewById(R.id.HexaDecimal);
        Button button = (Button)findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedID = Rbutton.getCheckedRadioButtonId();
                if(selectedID==Binary.getId()){
                    show(1);
                }
                if(selectedID==Octal.getId()){
                    show(2);
                }
                if(selectedID==Decimal.getId()){
                    show(3);
                }
                if(selectedID==HexaDecimal.getId()){
                    show(4);
                }

            }
        });


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
