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

public class SexualAssaultActivity extends Activity {
    private RadioButton rbquestioneyes,rbquestioneno,rbquestiontwoyes,rbquestiontwono,rbquestionthreeyes,rbquestionthreeno;
    private Button btsubmit;
    private EditText etdescribe;
    private String quesonevalue,questwovalue,questhreevalue,questionfourvalue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_four);
        btsubmit = (Button) findViewById(R.id.btsubmit);
        rbquestioneyes = (RadioButton) findViewById(R.id.rbquestioneyes);
        rbquestioneno = (RadioButton) findViewById(R.id.rbquestioneno);
        rbquestiontwoyes = (RadioButton) findViewById(R.id.rbquestiontwoyes);
        rbquestiontwono = (RadioButton) findViewById(R.id.rbquestiontwono);
        etdescribe=(EditText)findViewById(R.id.etdescribe);
        rbquestionthreeyes = (RadioButton) findViewById(R.id.rbquestionthreeyes);
        rbquestionthreeno = (RadioButton) findViewById(R.id.rbquestionthreeno);


        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setdata();
            }
        });

    }

    private void setdata() {

        rbquestioneyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbquestioneyes) {

                        rbquestioneno.setChecked(false);

                    }
                }
            }


            //rbyes.setOnCheckedChangeListener(this);

        });

        rbquestioneno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbquestioneno) {

                        rbquestioneyes.setChecked(false);

                    }
                }
            }
        });


        rbquestiontwoyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbquestiontwoyes) {

                        rbquestiontwono.setChecked(false);

                    }

                }
            }
        });
        rbquestiontwono.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbquestiontwono) {

                        rbquestiontwoyes.setChecked(false);

                    }

                }
            }
        });


        rbquestionthreeyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbquestionthreeyes) {

                        rbquestionthreeno.setChecked(false);

                    }

                }
            }
        });

        rbquestionthreeno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView.getId() == R.id.rbquestionthreeno) {

                        rbquestionthreeyes.setChecked(false);

                    }

                }
            }
        });


        setvalues();

    }

    private void setvalues() {
        if (rbquestioneyes.isChecked()) {
            quesonevalue = "yes";
        }

        if (rbquestioneno.isChecked()) {
            quesonevalue = "no";
        }
        if (rbquestiontwoyes.isChecked()) {
            questwovalue = "yes";
        }
        if (rbquestiontwono.isChecked()) {
            questwovalue = "no";
        }
        if (rbquestionthreeyes.isChecked()) {
            questhreevalue = "yes";
        }
        if (rbquestionthreeno.isChecked()) {
            questhreevalue = "no";
        }

        Log.d("quesonevalue",""+quesonevalue);
        Log.d("questwovalue",""+questwovalue);
        Log.d("questhreevalue",""+questhreevalue);
        questionfourvalue = etdescribe.getText().toString();
        if(questionfourvalue.contentEquals("")){
            Toast.makeText(this,"Please fill the missing fields",
                    Toast.LENGTH_SHORT).show();
        }else if (quesonevalue==null||questwovalue==null||questhreevalue==null){
            Toast.makeText(this,"Please pick yes or no",
                    Toast.LENGTH_SHORT).show();
        } else{
            Intent intent =new Intent(SexualAssaultActivity.this,ReportLoggerActivity.class);
            intent.putExtra("comingFrom","SexualAssaultActivity");
            intent.putExtra("quesonevalue",quesonevalue);
            intent.putExtra("questwovalue",questwovalue);
            intent.putExtra("questhreevalue",questhreevalue);
            intent.putExtra("questionfourvalue",questionfourvalue);
            startActivity(intent);
            finish();

        }
    }


}
