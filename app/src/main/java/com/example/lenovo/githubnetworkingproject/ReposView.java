package com.example.lenovo.githubnetworkingproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ReposView extends RecyclerView.ViewHolder {

    TextView ReposName;
    TextView NumberingTextView;
    View itemView;
    public ReposView(@NonNull View itemView) {
        super(itemView);
        this.itemView=itemView;
        ReposName=itemView.findViewById(R.id.ReposName);
        NumberingTextView=itemView.findViewById(R.id.NumberingTextView);
    }
}
