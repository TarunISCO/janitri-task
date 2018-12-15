package com.example.tarun.sample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.ViewHolder> {

    private ArrayList<Integer> treeList;

    TreeAdapter() {
        this.treeList = Trees.getTrees();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tree_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int currentAge = treeList.get(position);
        holder.treeAgetextView.setText(String.valueOf(currentAge));
    }

    @Override
    public int getItemCount() {
        return treeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView treeAgetextView;
        ViewHolder(View itemView) {
            super(itemView);
            treeAgetextView = itemView.findViewById(R.id.tree_age);
        }
    }
}
