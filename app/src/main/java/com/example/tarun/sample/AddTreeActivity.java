package com.example.tarun.sample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddTreeActivity extends AppCompatActivity {

    EditText newTreeAgeEditText;
    Button addnewTreeButton;
    RecyclerView treesRecyclerView;
    TreeAdapter treeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tree);

        Activity activity = getParent();

        newTreeAgeEditText = findViewById(R.id.new_tree_age);
        addnewTreeButton = findViewById(R.id.add_tree_button);
        treesRecyclerView = findViewById(R.id.trees_recyclerview);

        treeAdapter = new TreeAdapter();
        treesRecyclerView.setAdapter(treeAdapter);
        treesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        addnewTreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newAge = Integer.parseInt(newTreeAgeEditText.getText().toString());
                Trees.addTree(newAge);
                treeAdapter.notifyDataSetChanged();
                newTreeAgeEditText.setText("");
            }
        });
    }
}
