package com.kumar.pavan.myapplication.moo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kumar.pavan.myapplication.R;

/**
 * Created by amrut on 3/28/2018.
 */

public class ReportLoggerActivity extends Activity {
    private TextView tvother,tvquestionone,tvquestiontwo,tvquestionthree,tvquestionfour,tvquestionother;
    private String etvalue, quesone, questwo, questhree, quesfour,questfive;
private Button btsubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_logged);
        Intent intent = getIntent();
        etvalue = intent.getStringExtra("comingFrom");
        tvquestionone=(TextView)findViewById(R.id.tvquestionone);
        tvquestiontwo=(TextView)findViewById(R.id.tvquestiontwo);
        tvquestionthree=(TextView)findViewById(R.id.tvquestionthree);
        tvquestionfour=(TextView)findViewById(R.id.tvquestionfour);
        tvquestionother=(TextView)findViewById(R.id.tvquestionother);
        btsubmit=(Button)findViewById(R.id.btsubmit);

        if (etvalue.contentEquals("ElevatorMalfunctionActivity")) {
            quesone = intent.getStringExtra("queshowmany");
            questwo = intent.getStringExtra("quesblock");
            questhree = intent.getStringExtra("quesyesorno");
            quesfour = intent.getStringExtra("quesincident");

            tvquestionone.setVisibility(View.VISIBLE);
            tvquestiontwo.setVisibility(View.VISIBLE);
            tvquestionthree.setVisibility(View.VISIBLE);
            tvquestionfour.setVisibility(View.VISIBLE);


            tvquestionone.setText("Question 1 : "+quesone);
            tvquestiontwo.setText("Question 2 : "+questwo);
            tvquestionthree.setText("Question 3 : "+questhree);
            tvquestionfour.setText("Question 4 : "+quesfour);
        }else if(etvalue.contentEquals("FireHazardActivity")){
            quesone = intent.getStringExtra("ethowmanyvalue");
            questwo = intent.getStringExtra("radiobuttonvalue");
            questhree = intent.getStringExtra("ettimevalue");
            quesfour = intent.getStringExtra("etdescriptionvalue");

            tvquestionone.setVisibility(View.VISIBLE);
            tvquestiontwo.setVisibility(View.VISIBLE);
            tvquestionthree.setVisibility(View.VISIBLE);
            tvquestionfour.setVisibility(View.VISIBLE);


            tvquestionone.setText("Question 1 : "+quesone);
            tvquestiontwo.setText("Question 2 : "+questwo);
            tvquestionthree.setText("Question 3 : "+questhree);
            tvquestionfour.setText("Question 4 : "+quesfour);
        }else if(etvalue.contentEquals("RobberyActivity")){
            quesone = intent.getStringExtra("quesblock");
            questwo = intent.getStringExtra("quessuspects");
            questhree = intent.getStringExtra("quesyesorno");
            quesfour = intent.getStringExtra("quesincident");

            tvquestionone.setVisibility(View.VISIBLE);
            tvquestiontwo.setVisibility(View.VISIBLE);
            tvquestionthree.setVisibility(View.VISIBLE);
            tvquestionfour.setVisibility(View.VISIBLE);


            tvquestionone.setText("Question 1 : "+quesone);
            tvquestiontwo.setText("Question 2 : "+questwo);
            tvquestionthree.setText("Question 3 : "+questhree);
            tvquestionfour.setText("Question 4 : "+quesfour);
        }else if(etvalue.contentEquals("SexualAssaultActivity")){
            quesone = intent.getStringExtra("quesonevalue");
            questwo = intent.getStringExtra("questwovalue");
            questhree = intent.getStringExtra("questhreevalue");
            quesfour = intent.getStringExtra("questionfourvalue");

            tvquestionone.setVisibility(View.VISIBLE);
            tvquestiontwo.setVisibility(View.VISIBLE);
            tvquestionthree.setVisibility(View.VISIBLE);
            tvquestionfour.setVisibility(View.VISIBLE);


            tvquestionone.setText("Question 1 : "+quesone);
            tvquestiontwo.setText("Question 2 : "+questwo);
            tvquestionthree.setText("Question 3 : "+questhree);
            tvquestionfour.setText("Question 4 : "+quesfour);
        }else if(etvalue.contentEquals("OtherActivity")){
            questfive=intent.getStringExtra("etvalue");
            tvquestionone.setVisibility(View.GONE);
            tvquestiontwo.setVisibility(View.GONE);
            tvquestionthree.setVisibility(View.GONE);
            tvquestionfour.setVisibility(View.GONE);
            tvquestionother.setVisibility(View.VISIBLE);
            tvquestionother.setText("Other : "+questfive);
        }

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ReportLoggerActivity.this,HomeScreenActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        Log.d("etvalue","etvalue"+etvalue);
//        tvother=(TextView)findViewById(R.id.tvother);
//        tvother.setVisibility(View.VISIBLE);
//        tvother.setText(etvalue);
    }
}
