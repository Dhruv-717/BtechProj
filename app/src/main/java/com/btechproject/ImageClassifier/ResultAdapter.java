package com.btechproject.ImageClassifier;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ResultAdapter extends ArrayAdapter<Classifier.Recognition> {
    Context activityContext;
    List<Classifier.Recognition> result;
    public ResultAdapter(@NonNull Context context, @NonNull List<Classifier.Recognition> objects) {
        super(context, 0, objects);
        activityContext = context;
        result = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View resultListItem = convertView;
        if(resultListItem == null){
            resultListItem = LayoutInflater.from(activityContext).inflate(R.layout.list_item,parent,false);
        }
    Classifier.Recognition recognition = getItem(position);
        TextView textView = resultListItem.findViewById(R.id.item_text);
        textView.setText(recognition.getTitle());
        TextView confidenceView = resultListItem.findViewById(R.id.item_confidence);
        confidenceView.setText((recognition.getConfidence()*100)+"%");
        return resultListItem;
    }
}
