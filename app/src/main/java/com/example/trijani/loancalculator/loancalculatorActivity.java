//KANKIPATI LAXMI TRIJANI
//A03960666
//MOBILE PROGRAMMING
//ASSIGNMENT 1
package com.example.trijani.loancalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


    public class loancalculatorActivity extends Activity {
    private EditText loan_amount;
    private EditText loan_interest;
    private TextView year5, year10, year15, year20, year25, year30;
    public double la=0.00,li=0.00;
    private  double years5,years10,years15,years20,years25,years30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loancalculator);

        // ESTABLISH THE REFERENCES TO INPUT ELEMENTs
        loan_amount = (EditText) findViewById(R.id.editText2);
        loan_interest = (EditText) findViewById(R.id.editText3);

        //ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        year5 = (TextView) findViewById(R.id.textView10);
        year10 = (TextView) findViewById(R.id.textView11);
        year15 = (TextView) findViewById(R.id.textView12);
        year20 = (TextView) findViewById(R.id.textView13);
        year25 = (TextView) findViewById(R.id.textView14);
        year30 = (TextView) findViewById(R.id.textView15);



        loan_amount.addTextChangedListener(amountTextWatcher);
        loan_interest.addTextChangedListener(interestTextWatcher);

    }

    private TextWatcher amountTextWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s,
                                  int start, int before, int count) {

           try {
                displayresult((double) Double.parseDouble(s.toString()));
            } catch (NumberFormatException e) {
                displayresult(0);
            }


        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };
    private TextWatcher interestTextWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {

                displayinterest((double) Double.parseDouble(s.toString()));
            } catch (NumberFormatException e) {
                displayinterest(0);
            }


        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

    public void displayresult(double a) {
        la = a;
        calculate();
    }
    public void displayinterest(double i){
        li = i;
        if(li==0){
            year5.setText("$"+ la/60);
            year10.setText("$"+ la/120);
            year15.setText("$"+la/180);
            year20.setText("$"+ la/240);
            year25.setText("$"+ la/300);
            year30.setText("$"+la/360);
        }
        else
        calculate();
    }
    public void calculate() {
       if(li==0){}
        else{
        double r = li / 1200.0;
        double r1 = Math.pow(r + 1, 60.0);
        years5 = (double) ((r + (r / (r1 - 1))) * la);
        year5.setText("$" + new DecimalFormat("##.##").format(years5));
        double r2 = Math.pow(r + 1, 120.0);
        years10 = ((r + (r / (r2 - 1))) * la);
        year10.setText("$" + new DecimalFormat("##.##").format(years10));
        double r3 = Math.pow(r + 1, 180.0);
        years15 = ((r + (r / (r3 - 1))) * la);
        year15.setText("$" + new DecimalFormat("##.##").format(years15));
        double r4 = Math.pow(r + 1, 240.0);
        years20 = (double) ((r + (r / (r4 - 1))) * la);
        year20.setText("$" + new DecimalFormat("##.##").format(years20));
        double r5 = Math.pow(r + 1, 300.0);
        years25 = ((r + (r / (r5 - 1))) * la);
        year25.setText("$" + new DecimalFormat("##.##").format(years25));
        double r6 = Math.pow(r + 1, 360.0);
        years30 = ((r + (r / (r6 - 1))) * la);
        year30.setText("$" + new DecimalFormat("##.##").format(years30));
    }
    }

}
