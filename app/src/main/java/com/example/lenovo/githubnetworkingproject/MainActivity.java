package com.example.lenovo.githubnetworkingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.UserName);
    }
    public void UserDetail(View view)
    {
       Intent intent=new Intent(this,UserDetailActivity.class);
       intent.putExtra("UserName",text.getText().toString());
       startActivity(intent);
    }

}
