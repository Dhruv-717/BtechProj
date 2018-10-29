package com.mindorks.tensorflowexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
        Bundle b = getIntent().getBundleExtra("bundle");
        ArrayList<Classifier.Recognition> list = (ArrayList<Classifier.Recognition>) b.getSerializable("result");
        ListView listView = findViewById(R.id.list_result);
        ResultAdapter resultAdapter = new ResultAdapter(this,list);
        listView.setAdapter(resultAdapter);
    }
}
