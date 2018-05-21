package com.kumar.pavan.myapplication.moo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.kumar.pavan.myapplication.R;


/**
 * Created by amrut on 3/28/2018.
 */

public class ReportActivity extends Activity implements CompoundButton.OnCheckedChangeListener{
    private RadioButton rbone,rbtwo,rbthree,rbfour,rbfive;
    private String type;
    private Button btnext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_screen);
        initviews();
    }

    private void initviews() {
        rbone=(RadioButton)findViewById(R.id.rbone) ;
        rbtwo=(RadioButton)findViewById(R.id.rbtwo) ;
        rbthree=(RadioButton)findViewById(R.id.rbthree) ;
        rbfour=(RadioButton)findViewById(R.id.rbfour) ;
        rbfive=(RadioButton)findViewById(R.id.rbfive) ;
        btnext=(Button)findViewById(R.id.btnext);
        rbone.setOnCheckedChangeListener(this);
        rbtwo.setOnCheckedChangeListener(this);
        rbthree.setOnCheckedChangeListener(this);
        rbfour.setOnCheckedChangeListener(this);
        rbfive.setOnCheckedChangeListener(this);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setdata();

            }
        });

    }

    private void setvalues() {

        if(type.contentEquals("one")){
            Intent intent= new Intent(ReportActivity.this,ElevatorMalfunctionActivity.class);
            startActivity(intent);
        }else if(type.contentEquals("two")){
            Intent intent= new Intent(ReportActivity.this,FireHazardActivity.class);
            startActivity(intent);
        }else if(type.contentEquals("three")){
            Intent intent= new Intent(ReportActivity.this,RobberyActivity.class);
            startActivity(intent);
        }else if(type.contentEquals("four")){
            Intent intent= new Intent(ReportActivity.this,SexualAssaultActivity.class);
            startActivity(intent);
        }else{
            Intent intent= new Intent(ReportActivity.this,OtherActivity.class);
            startActivity(intent);
        }

    }

    private void setdata() {

        if (!rbone.isChecked() && !rbtwo.isChecked() && !rbthree.isChecked() && !rbfour.isChecked()  && !rbfive.isChecked()) {
            Toast.makeText(this, "Please select one of the above",
                    Toast.LENGTH_LONG).show();
            return;
        } else {
            if (rbone.isChecked()) {
                type = "one";
            }

            if (rbtwo.isChecked()) {
                type = "two";
            }

            if (rbthree.isChecked()) {
                type = "three";
            }
            if (rbfour.isChecked()) {
                type = "four";
            }
            if (rbfive.isChecked()) {
                type = "other";
            }
        }

        setvalues();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            if (buttonView.getId() == R.id.rbone) {

                rbtwo.setChecked(false);
                rbthree.setChecked(false);
                rbfour.setChecked(false);
                rbfive.setChecked(false);
            }

            if (buttonView.getId() == R.id.rbtwo) {

                rbone.setChecked(false);
                rbthree.setChecked(false);
                rbfour.setChecked(false);
                rbfive.setChecked(false);
            }

            if (buttonView.getId() == R.id.rbthree) {

                rbone.setChecked(false);
                rbtwo.setChecked(false);
                rbfour.setChecked(false);
                rbfive.setChecked(false);
            }
            if (buttonView.getId() == R.id.rbfour) {

                rbone.setChecked(false);
                rbtwo.setChecked(false);
                rbthree.setChecked(false);
                rbfive.setChecked(false);
            }
            if (buttonView.getId() == R.id.rbfive) {

                rbone.setChecked(false);
                rbtwo.setChecked(false);
                rbthree.setChecked(false);
                rbfour.setChecked(false);
            }
        }
    }
}
