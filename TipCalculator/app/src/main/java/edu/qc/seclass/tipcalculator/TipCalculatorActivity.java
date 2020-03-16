package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {


    private EditText checkAmount, partySize;
    //private Button cal;
    private TextView ftPercentTip, twentyPercentTip, twentyfivePercentTip, ftTotalVal, twentyTotalVal, twentyfiveTotalVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cal=findViewById(R.id.buttonCompute);


        checkAmount = (EditText)findViewById(R.id.checkAmountValue);
        partySize = (EditText)findViewById(R.id.partySizeValue);

        ftPercentTip = (TextView)findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTip = (TextView)findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTip = (TextView) findViewById(R.id.twentyfivePercentTipValue);

        ftTotalVal = (TextView) findViewById(R.id.fifteenPercentTotalValue);
        twentyTotalVal = (TextView) findViewById(R.id.twentyPercentTotalValue);
        twentyfiveTotalVal = (TextView) findViewById(R.id.twentyfivePercentTotalValue);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }
    public  void calculate(){
        String cAmount = checkAmount.getText().toString();
        String pSizeString = partySize.getText().toString();

        if((cAmount==null|| cAmount.isEmpty())&&(pSizeString.isEmpty()||pSizeString==null))
            Toast.makeText(this,"ENTER A CHECK AMOUNT\n AND PARTY SIZE",Toast.LENGTH_LONG).show();

        else if(cAmount.isEmpty()||cAmount==null)
            Toast.makeText(this,"ENTER A CHECK NUMBER AMOUNT",Toast.LENGTH_LONG).show();
        else if(pSizeString==null||pSizeString.isEmpty())
            Toast.makeText(this,"ENTER A PARTY SIZE",Toast.LENGTH_LONG).show();


        else if((pSizeString==null|| pSizeString.isEmpty())||(cAmount.isEmpty()||cAmount==null))
            Toast.makeText(this,"ENTER A CHECK AMOUNT\n AND PARTY SIZE",Toast.LENGTH_LONG).show();
        else if (Double.parseDouble(cAmount)<= 0 || Integer.parseInt(pSizeString) <= 0)
            Toast.makeText(this,"Enter a positive Total Amount",Toast.LENGTH_LONG).show();

        else {
            double totalAmount = Double.parseDouble(cAmount);
            int pSizeInt = Integer.parseInt(pSizeString);
            double fifteenTip = ((totalAmount) * .15) / pSizeInt;
            double twentyTip = ((totalAmount) * .20) / pSizeInt;
            double twentyfiveTip = ((totalAmount) * .25) / pSizeInt;

            double fifteenTotal = (totalAmount / pSizeInt) + fifteenTip;
            double twentyTotal = (totalAmount / pSizeInt) + twentyTip;
            double twentyfiveTotal = (totalAmount / pSizeInt) + twentyfiveTip;

            int fifteenPOutput = (int) Math.round(fifteenTip);
            int twentyPOutput = (int) Math.round(twentyTip);
            int twentyfivePOutput = (int) Math.round(twentyfiveTip);

            int fifteenTotalOutput = (int) Math.round(fifteenTotal);
            int twentyTotalOutput = (int) Math.round(twentyTotal);
            int twentyfiveTotalOutput = (int) Math.round(twentyfiveTotal);

            ftPercentTip.setText("$"+String.valueOf(fifteenPOutput));
            twentyPercentTip.setText("$"+String.valueOf(twentyPOutput));
            twentyfivePercentTip.setText("$"+String.valueOf(twentyfivePOutput));
            ftTotalVal.setText("$"+String.valueOf(fifteenTotalOutput));
            twentyTotalVal.setText("$"+String.valueOf(twentyTotalOutput));
            twentyfiveTotalVal.setText("$"+String.valueOf(twentyfiveTotalOutput));


            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();

        }
    }
}