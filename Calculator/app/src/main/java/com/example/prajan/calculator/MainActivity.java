package com.example.prajan.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init();
    }

    ArrayList<String> calcArray= new ArrayList<String>();
    String string="";
    String string1="";
    String click1="not_executed";
    int i=0;//,flag=0;




    public void onClick1(View view){

        TextView Output = (TextView)findViewById(R.id.textView);
        TextView Output2 = (TextView)findViewById(R.id.textView2);
        Button button=(Button) view;
        string=button.getText().toString();

        if (click1.equals("executed"))
        {
            string1="";
            Output.setText("");
            Output2.setText("");
            calcArray.clear();
            click1="not_executed";
        }


            if(!string.contains("+")&&!string.contains("-")&&!string.contains("*")&&!string.contains("/")&&!string.contains("sin")&&!string.contains("cos")&&!string.contains("tan")){

                string1=string1+string;


                if (i==0&&calcArray.size()>0){
                    calcArray.remove(calcArray.size()-1);
                }


                calcArray.add(string1);

            }


            else {

                    calcArray.add(string);
                    calcArray.add(string);
                    string1="";
            }
            Output.setText(Output.getText().toString() + string);
           // Output.setText(calcArray.toString());

            if (i==1){
                i=0;
            }
        }


    public void onClick(View v){

        click1="executed";
        TextView Output = (TextView)findViewById(R.id.textView);
        TextView TotalOutput = (TextView)findViewById(R.id.textView2);
        double calc=0;
        int ind=0,ind1=0,ind2=0;
        int size=calcArray.size();
        ind=calcArray.indexOf("sin");
        ind1=calcArray.indexOf("cos");
        ind2=calcArray.indexOf("tan");
        if (calcArray.contains("sin")){
            double radians = Math.toRadians(Double.parseDouble(calcArray.get(ind+1)));
            double val = Math.sin(radians);
            calcArray.remove(ind);
            calcArray.add(ind,Double.toString(val));
            calc = val;
        }
        else if (calcArray.contains("cos")){
            double radians = Math.toRadians(Double.parseDouble(calcArray.get(1)));
            double val = Math.cos(radians);
            calc = val;
        }
        else if (calcArray.contains("tan")){
            double radians = Math.toRadians(Double.parseDouble(calcArray.get(1)));
            double val = Math.tan(radians);
            calc = val;
        }
        else{
            if (size==1||size==2) {
                if (calcArray.get(0).contains("+") || calcArray.get(0).contains("-") || calcArray.get(0).contains("*") || calcArray.get(0).contains("/") || calcArray.get(0).contains(".")) {
                    calcArray.clear();
                    calc = 0;
                } else {
                    calc = Double.parseDouble(calcArray.get(0));
                }
            }
            else {
                while (size != 1) {
                    if (size > 3) {
                        if (calcArray.get(3).contains("*") || calcArray.get(3).contains("/")) {
                            if (calcArray.get(3).contains("*")) {
                                calc = Double.parseDouble(calcArray.get(2)) * Double.parseDouble(calcArray.get(4));
                            }
                            if (calcArray.get(3).contains("/")) {
                                calc = Double.parseDouble(calcArray.get(2)) / Double.parseDouble(calcArray.get(4));
                            }
                            calcArray.remove(2);
                            calcArray.remove(2);
                            calcArray.remove(2);
                            calcArray.add(2, Double.toString(calc));
                            size = calcArray.size();


                        } else {

                            if (calcArray.get(1).contains("+")) {
                                calc = Double.parseDouble(calcArray.get(0)) + Double.parseDouble(calcArray.get(2));
                            }
                            if (calcArray.get(1).contains("-")) {
                                calc = Double.parseDouble(calcArray.get(0)) - Double.parseDouble(calcArray.get(2));
                            }
                            if (calcArray.get(1).contains("*")) {
                                calc = Double.parseDouble(calcArray.get(0)) * Double.parseDouble(calcArray.get(2));
                            }
                            if (calcArray.get(1).contains("/")) {
                                calc = Double.parseDouble(calcArray.get(0)) / Double.parseDouble(calcArray.get(2));
                            }
                            calcArray.remove(0);
                            calcArray.remove(0);
                            calcArray.remove(0);
                            calcArray.add(0, Double.toString(calc));
                            size = calcArray.size();
                        }

                    } else {
                        if (calcArray.get(1).contains("+")) {
                            calc = Double.parseDouble(calcArray.get(0)) + Double.parseDouble(calcArray.get(2));
                        }
                        if (calcArray.get(1).contains("-")) {
                            calc = Double.parseDouble(calcArray.get(0)) - Double.parseDouble(calcArray.get(2));
                        }
                        if (calcArray.get(1).contains("*")) {
                            calc = Double.parseDouble(calcArray.get(0)) * Double.parseDouble(calcArray.get(2));
                        }
                        if (calcArray.get(1).contains("/")) {
                            calc = Double.parseDouble(calcArray.get(0)) / Double.parseDouble(calcArray.get(2));
                        }
                        calcArray.remove(0);
                        calcArray.remove(0);
                        calcArray.remove(0);
                        calcArray.add(0, Double.toString(calc));
                        size = calcArray.size();
                    }
                }
            }


    }
        TotalOutput.setText(Double.toString(calc));
    }

    public void clear(View v){

        TextView Output = (TextView)findViewById(R.id.textView);
        TextView TotalOutput = (TextView)findViewById(R.id.textView2);
        string1="";
        string="";
        Output.setText("");
        TotalOutput.setText("");
        calcArray.clear();
    }

   public void onClickBack(View v){

       TextView Output = (TextView)findViewById(R.id.textView);
       if (calcArray.size()==0){
           Output.setText("0");
       }

            String a= Output.getText().toString();
            Output.setText(a.substring(0, a.length() - 1));

         if (calcArray.get(calcArray.size()-1).contains("*") && calcArray.get(calcArray.size()-2).contains("*") || calcArray.get(calcArray.size()-1).contains("+") && calcArray.get(calcArray.size()-2).contains("+") ||calcArray.get(calcArray.size()-1).contains("-") && calcArray.get(calcArray.size()-2).contains("-") || calcArray.get(calcArray.size()-1).contains("/") && calcArray.get(calcArray.size()-2).contains("/")) {

                calcArray.remove(calcArray.size()-1);
                calcArray.remove(calcArray.size()-1);
                string1="";
            }

            else {

                    calcArray.remove(calcArray.size() - 1);
                    string1 = "";

            }
            i=1;

   }


    public void onClickConvert(View vc)
    {
        Button convert = (Button) vc;
        Intent i = new Intent(this, Main2Activity.class);
        i.putStringArrayListExtra("array",calcArray);
        startActivity(i);
    }

    public void onClickUnitConvert(View vc)
    {
        Button convert = (Button) vc;
        Intent i = new Intent(this, UnitConverter.class);
        startActivity(i);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
