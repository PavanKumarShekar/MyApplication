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
import android.widget.RadioButton;
import android.widget.Toast;

import com.kumar.pavan.myapplication.R;

/**
 * Created by amrut on 3/28/2018.
 */

public class RobberyActivity extends Activity {
    private EditText etincident,etsuspects,etother;
    private RadioButton rbyes,rbno,rbblocka,rbblockb,rbblockc,rbblockd,rbother;
    private String quesblock,quesyesorno,quessuspects,quesincident;
    private Button btsubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_three);
        etincident=(EditText)findViewById(R.id.etincident);
        etsuspects=(EditText)findViewById(R.id.etsuspects);
        etother=(EditText)findViewById(R.id.etother);
        btsubmit=(Button)findViewById(R.id.btsubmit);
        rbother = (RadioButton) findViewById(R.id.rbother);
        rbblockd = (RadioButton) findViewById(R.id.rbblockd);
        rbblockc = (RadioButton) findViewById(R.id.rbblockc);
        rbblocka = (RadioButton) findViewById(R.id.rbblocka);
        rbblockb = (RadioButton) findViewById(R.id.rbblockb);
        rbyes = (RadioButton) findViewById(R.id.rbyes);
        rbno = (RadioButton) findViewById(R.id.rbno);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setdata();
            }
        });
    }

    private void setdata() {

        rbyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbyes) {

                        rbno.setChecked(false);

                    }
                }
            }
        });

        rbno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbno) {

                        rbyes.setChecked(false);

                    }
                }
            }
        });

        rbblocka.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbblocka) {

                        rbblockb.setChecked(false);
                        rbblockc.setChecked(false);
                        rbblockd.setChecked(false);
                        rbother.setChecked(false);
                        etother.setVisibility(View.GONE);

                    }
                }
            }
        });

        rbblockb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbblockb) {

                        rbblocka.setChecked(false);
                        rbblockc.setChecked(false);
                        rbblockd.setChecked(false);
                        rbother.setChecked(false);
                        etother.setVisibility(View.GONE);
                    }
                }
            }
        });

        rbblockc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbblockc) {

                        rbblocka.setChecked(false);
                        rbblockb.setChecked(false);
                        rbblockd.setChecked(false);
                        rbother.setChecked(false);
                        etother.setVisibility(View.GONE);
                    }
                }
            }
        });

        rbblockd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbblockd) {

                        rbblocka.setChecked(false);
                        rbblockb.setChecked(false);
                        rbblockc.setChecked(false);
                        rbother.setChecked(false);
                        etother.setVisibility(View.GONE);
                    }
                }
            }
        });

        rbother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbother) {

                        rbblocka.setChecked(false);
                        rbblockb.setChecked(false);
                        rbblockc.setChecked(false);
                        rbblockd.setChecked(false);
                        etother.setVisibility(View.VISIBLE);

                    }
                }
            }
        });

        setvalues();
    }

    private void setvalues() {
        if (rbblocka.isChecked()) {
            quesblock = "BLOCK A";
        }

        if (rbblockb.isChecked()) {
            quesblock = "BLOCK B";
        }
        if (rbblockc.isChecked()) {
            quesblock = "BLOCK C";
        }
        if (rbblockd.isChecked()) {
            quesblock = "BLOCK D";
        }if (rbother.isChecked()) {
            quesblock = etother.getText().toString();
        }if (rbyes.isChecked()) {
            quesyesorno = "yes";
        }if (rbno.isChecked()) {
            quesyesorno = "no";
        }

        quessuspects=etsuspects.getText().toString();
        quesincident=etincident.getText().toString();

        Log.d("quessuspects",""+quessuspects);
        Log.d("quesincident",""+quesincident);
        Log.d("quesyesorno",""+quesyesorno);
        Log.d("quesblock",""+quesblock);

        if(quessuspects.contentEquals("")||quesincident.contentEquals("")){
            Toast.makeText(this,"Please fill the missing fields",
                    Toast.LENGTH_SHORT).show();
        }else if (quesyesorno==null){
            Toast.makeText(this,"Please pick yes or no",
                    Toast.LENGTH_SHORT).show();
        }else if(quesblock==null) {
            Toast.makeText(this,"Please pick a block",
                    Toast.LENGTH_SHORT).show();
        }else{
            Intent intent =new Intent(RobberyActivity.this,ReportLoggerActivity.class);
            intent.putExtra("comingFrom","RobberyActivity");
            intent.putExtra("quessuspects",quessuspects);
            intent.putExtra("quesyesorno",quesyesorno);
            intent.putExtra("quesblock",quesblock);
            intent.putExtra("quesincident",quesincident);
            startActivity(intent);
            finish();

        }
    }

}
