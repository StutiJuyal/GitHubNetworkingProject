package com.example.lenovo.githubnetworkingproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class followersAdapter extends RecyclerView.Adapter<followersView> {

    ArrayList<Followers>followersArrayList;
    Context context;
    onFollowerClicked listener;

    public followersAdapter(Context context,ArrayList<Followers>followersArrayList,onFollowerClicked followerClicked)
    {
        this.context=context;
        this.followersArrayList=followersArrayList;
        this.listener=followerClicked;
    }


    @NonNull
    @Override
    public followersView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowLayout=inflater.inflate(R.layout.followers_row,viewGroup,false);
        return new followersView(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull final followersView ViewHolder, int i) {
        Followers followers=followersArrayList.get(i);
        ViewHolder.followersName.setText(followers.name);
        ViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onFollowerClick(view,ViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
       return followersArrayList.size();
    }
}
