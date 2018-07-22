package com.example.lenovo.githubnetworkingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserDetailActivity extends AppCompatActivity {

    public static String UserName="UserName";
    ImageView imageView;
    TextView nameTextView;
    TextView followers;
    TextView following;
    Button Repos;
    Button Followers;
    Intent intent;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        imageView = findViewById(R.id.imageView);
        //  Picasso.with(this).load(gitHubUser.getAvatarUrl()).into(imageView);
        intent=getIntent();
        name=intent.getStringExtra(UserName);
        nameTextView=findViewById(R.id.name);
        followers=findViewById(R.id.followers);
        following=findViewById(R.id.following);
        Repos=findViewById(R.id.Repository);
        Followers=findViewById(R.id.FollowersButton);
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        UsersActivity usersActivity=retrofit.create(UsersActivity.class);
        Call<User> call=usersActivity.getUser(name);

        call.enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
              User user=response.body();
               if(user != null) {
                   Picasso.with(getApplicationContext()).load(user.getUrl()).into(imageView);
                   nameTextView.setText("Name:"+name);
                   followers.setText("Number of Followers :"+String.valueOf(user.getFollowers()));
                   following.setText("Number of Following :"+String.valueOf(user.getFollowing()));
               }
               else
               {
                   Toast.makeText(getApplicationContext(),"Valid User Not Found",Toast.LENGTH_LONG).show();
               }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


    }
    public void ReposSet(View view)
    {
       Intent intentRepos=new Intent(this,ReposActivity.class);
       intentRepos.putExtra(UserName,name);
       startActivity(intentRepos);
    }
    public void FollowersSet(View view)
    {
      Intent intentFollowers=new Intent(this,FollowersActivity.class);
      intentFollowers.putExtra(UserName,name);
      startActivity(intentFollowers);
    }
}
