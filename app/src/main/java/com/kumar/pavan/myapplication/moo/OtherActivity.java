package com.kumar.pavan.myapplication.moo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kumar.pavan.myapplication.R;

/**
 * Created by amrut on 3/28/2018.
 */

public class OtherActivity extends Activity {
    private EditText etOther;
    private Button btsubmit;
    private String etvalue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_other);
        initview();

    }

    private void initview() {
        etOther = (EditText) findViewById(R.id.etother);
        btsubmit = (Button) findViewById(R.id.btsubmit);

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etvalue = etOther.getText().toString();
                Log.d("dd", "dd" + etvalue);
                if (etvalue.contentEquals("")) {

                    Toast.makeText(OtherActivity.this, "Please fill the missing fields",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(OtherActivity.this, ReportLoggerActivity.class);
                    intent.putExtra("comingFrom", "OtherActivity");
                    intent.putExtra("etvalue", etvalue);
                    startActivity(intent);
                    finish();

                }

            }
        });

    }
}
