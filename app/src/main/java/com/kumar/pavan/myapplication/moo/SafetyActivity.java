package com.kumar.pavan.myapplication.moo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.kumar.pavan.myapplication.R;

/**
 * Created by amrut on 3/29/2018.
 */

public class SafetyActivity extends Activity {
    private Button btsubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safety_screen);
        btsubmit=(Button)findViewById(R.id.btsubmit);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SafetyActivity.this,HomeScreenActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
