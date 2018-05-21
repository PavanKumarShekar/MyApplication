package com.kumar.pavan.myapplication.moo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.kumar.pavan.myapplication.R;

/**
 * Created by amrut on 3/29/2018.
 */

public class SosReportActivity extends Activity {
    private ImageView ivcapturedimage;
    private String photo;
    private TextView text_image,tvlocation;
    private Button btsubmit;
    private Uri final_imageUri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos_result);
        ivcapturedimage=(ImageView)findViewById(R.id.ivcapturedimage);
        tvlocation=(TextView)findViewById(R.id.tvlocation);
        btsubmit=(Button)findViewById(R.id.btsubmit);
        text_image=(TextView)findViewById(R.id.text_image);
        Intent intent = getIntent();
        tvlocation.setText(intent.getStringExtra("addressLocation"));
        if(intent.getParcelableExtra("photo")==null){
            ivcapturedimage.setVisibility(View.GONE);
            text_image.setVisibility(View.GONE);
        }else{
            Bitmap bitmap = (Bitmap) intent.getParcelableExtra("photo");
            ivcapturedimage.setVisibility(View.VISIBLE);
            text_image.setVisibility(View.VISIBLE);

            ivcapturedimage.setImageBitmap(bitmap);
        }

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(SosReportActivity.this,HomeScreenActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
