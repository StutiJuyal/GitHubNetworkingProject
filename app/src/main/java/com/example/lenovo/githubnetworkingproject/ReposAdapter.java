package com.example.lenovo.githubnetworkingproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ReposAdapter extends RecyclerView.Adapter<ReposView>{

    ArrayList<Repository>repositories;
    Context context;

    public ReposAdapter(ArrayList<Repository>repositories,Context context)
    {
        this.context=context;
        this.repositories=repositories;
    }

   // public ReposAdapter(ArrayList<Followers> followers, FollowersActivity followersActivity, onFollowerClicked followerClicked) {
   // }


    @NonNull
    @Override
    public ReposView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowLayout=inflater.inflate(R.layout.repos_row,viewGroup,false);
        return new ReposView(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposView viewHolder, int i) {
        Repository repository=repositories.get(i);
        String position=String.valueOf(i+1);
        viewHolder.NumberingTextView.setText(position + " ");
        viewHolder.ReposName.setText(repository.fullName);
    }


    @Override
    public int getItemCount() {
      return repositories.size();
    }
}
