package com.example.lenovo.githubnetworkingproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class followersView extends RecyclerView.ViewHolder {
    View itemView;
    TextView followersName;
    public followersView(@NonNull View itemView) {
        super(itemView);
        this.itemView=itemView;
        followersName=itemView.findViewById(R.id.FollowersNameTextView);
    }
}
