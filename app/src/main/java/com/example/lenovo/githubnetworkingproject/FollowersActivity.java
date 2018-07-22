package com.example.lenovo.githubnetworkingproject;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FollowersActivity extends Activity {
    final String UserName="UserName";
    RecyclerView followersRecyclerView;
    Intent intent;
    ArrayList<Followers>followers=new ArrayList<>();
    followersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);
        followersRecyclerView=findViewById(R.id.followersRecycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        followersRecyclerView.setLayoutManager(layoutManager);
        adapter=new followersAdapter(this,followers, new onFollowerClicked() {
            @Override
            public void onFollowerClick(View view, int position){
                Followers follower=followers.get(position);
                String name=follower.name;
                Intent intentFollower=new Intent(FollowersActivity.this,UserDetailActivity.class);
                intentFollower.putExtra("UserName",name);
                startActivity(intentFollower);
            }
        });
        followersRecyclerView.setAdapter(adapter);
        followersRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        intent=getIntent();
        final String name=intent.getStringExtra(UserName);
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        UsersActivity usersActivity=retrofit.create(UsersActivity.class);
        Call<ArrayList<Followers>> call=usersActivity.getFollowers(name);


        call.enqueue(new Callback<ArrayList<Followers>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Followers>> call, Response<ArrayList<Followers>> response) {
                ArrayList<Followers> reposList=response.body();
                if(reposList!= null) {
                    followers.addAll(reposList);
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Valid Repository Not Found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Followers>> call, Throwable t) {
                Log.d("ReposActivity",t.getMessage());
            }
        });
    }

}
