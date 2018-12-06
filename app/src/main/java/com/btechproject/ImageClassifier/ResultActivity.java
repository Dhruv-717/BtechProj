package com.btechproject.ImageClassifier;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.URLEncoder;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ArrayList<Classifier.Recognition> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
        Bundle b = getIntent().getBundleExtra("bundle");
          list = (ArrayList<Classifier.Recognition>) b.getSerializable("result");
        ListView listView = findViewById(R.id.list_result);
        ResultAdapter resultAdapter = new ResultAdapter(this,list);
        listView.setAdapter(resultAdapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
            Classifier.Recognition recognition = list.get(pos);
            String searchQuery = recognition.getTitle();
            Uri uri = Uri.parse("http://www.google.com/#q=" + searchQuery);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    });
    }
}
