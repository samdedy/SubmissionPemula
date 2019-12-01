package com.sam.alatmusiktradisional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // find textview id
        ImageView imageView = (ImageView)findViewById(R.id.detail_photo);
        TextView textView = (TextView)findViewById(R.id.detail_name);
        TextView textView1 = (TextView)findViewById(R.id.detail_description);
        // set to textview id detail
        imageView.setImageResource(getIntent().getIntExtra("dataDetailPhoto",0));
        textView.setText(getIntent().getStringExtra("dataName"));
        textView1.setText(getIntent().getStringExtra("dataDescription"));

    }
}
