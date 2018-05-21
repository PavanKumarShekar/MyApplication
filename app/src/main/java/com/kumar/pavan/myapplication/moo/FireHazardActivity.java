package com.kumar.pavan.myapplication.moo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.kumar.pavan.myapplication.R;

/**
 * Created by amrut on 3/28/2018.
 */

public class FireHazardActivity extends Activity implements CompoundButton.OnCheckedChangeListener {
    private EditText ethowmany, ettime, etdescription;
    private Button btsubmit;
    private LinearLayout llyes, llno;
    private RadioButton rbyes, rbno;
    private String radiobuttonvalue, ethowmanyvalue, ettimevalue, etdescriptionvalue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_two);
        ethowmany = (EditText) findViewById(R.id.ethowmany);
        ettime = (EditText) findViewById(R.id.ettime);
        etdescription = (EditText) findViewById(R.id.etdescribe);
        btsubmit = (Button) findViewById(R.id.btsubmit);
        rbyes = (RadioButton) findViewById(R.id.rbyes);
        rbyes.setOnCheckedChangeListener(this);
        rbno = (RadioButton) findViewById(R.id.rbno);
        rbno.setOnCheckedChangeListener(this);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setvalues();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            if (buttonView.getId() == R.id.rbyes) {

                rbno.setChecked(false);

            }

            if (buttonView.getId() == R.id.rbno) {

                rbyes.setChecked(false);

            }


        }


    }

    private void setvalues() {


        ethowmanyvalue = ethowmany.getText().toString();
                ettimevalue = ettime.getText().toString();
                        etdescriptionvalue =  etdescription.getText().toString();
        if (rbyes.isChecked()) {
            radiobuttonvalue = "yes";
        }

        if (rbno.isChecked()) {
            radiobuttonvalue = "no";
        }
        sendvalues();
    }

    private void sendvalues() {
        Log.d("ethowmanyvalue",""+ethowmanyvalue);
        Log.d("ettimevalue",""+ettimevalue);
        Log.d("etdescriptionvalue",""+etdescriptionvalue);
        Log.d("radiobuttonvalue",""+radiobuttonvalue);
        if(ethowmanyvalue.contentEquals("")||ettimevalue.contentEquals("")||etdescriptionvalue.contentEquals("")){
            Toast.makeText(this,"Please fill the missing fields",
                    Toast.LENGTH_SHORT).show();
        }else if (radiobuttonvalue==null){
            Toast.makeText(this,"Please pick yes or no",
                    Toast.LENGTH_SHORT).show();
        } else{
            Intent intent =new Intent(FireHazardActivity.this,ReportLoggerActivity.class);
            intent.putExtra("comingFrom","FireHazardActivity");
            intent.putExtra("ethowmanyvalue",ethowmanyvalue);
            intent.putExtra("ettimevalue",ettimevalue);
            intent.putExtra("etdescriptionvalue",etdescriptionvalue);
            intent.putExtra("radiobuttonvalue",radiobuttonvalue);
            startActivity(intent);
            finish();

        }

    }
}
