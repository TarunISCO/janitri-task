package com.example.tarun.sample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String str1 = "No. of Trees : ";
    final String str2 = "Average Age : ";
    final String str3 = "Median Age : ";
    TextView treeCountTextView;
    TextView treeAverageAgeTextView;
    TextView treeMedianAgeTextView;
    Button addTreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        treeCountTextView = findViewById(R.id.trees_count_tv);
        treeAverageAgeTextView = findViewById(R.id.trees_average_age_tv);
        treeMedianAgeTextView = findViewById(R.id.trees_median_age_tv);

        updateUI();


        addTreeButton = findViewById(R.id.add_tree);

        addTreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTreeActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void updateUI(){
        treeCountTextView.setText(str1 + String.valueOf(Trees.getTreeCount()));
        treeAverageAgeTextView.setText(str2 + String.valueOf(Trees.getMeanAge()));
        treeMedianAgeTextView.setText(str3 + String.valueOf(Trees.getMedianAge()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateUI();
    }
}
