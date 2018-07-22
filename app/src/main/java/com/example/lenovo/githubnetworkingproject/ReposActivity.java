package com.example.lenovo.githubnetworkingproject;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReposActivity extends AppCompatActivity {

    final String UserName="UserName";
    Intent intent;
    RecyclerView recyclerView;
    ReposAdapter adapter;
    ArrayList<Repository>reposArray=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ReposAdapter(reposArray,this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        intent=getIntent();
        final String name=intent.getStringExtra(UserName);
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        UsersActivity usersActivity=retrofit.create(UsersActivity.class);
        Call<ArrayList<Repository>> call=usersActivity.getRepos(name);


        call.enqueue(new Callback<ArrayList<Repository>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Repository>> call, Response<ArrayList<Repository>> response) {
                ArrayList<Repository> reposList=response.body();
                if(reposList!= null) {
                  reposArray.addAll(reposList);
                  adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Valid Repository Not Found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Repository>> call, Throwable t) {
              Log.d("ReposActivity",t.getMessage());
            }
        });
    }
}
