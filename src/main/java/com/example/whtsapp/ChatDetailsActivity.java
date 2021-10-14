/*package com.example.whtsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.whtsapp.Adapters.ChatAdapter;
import com.example.whtsapp.Models.MessageModel;
import com.example.whtsapp.databinding.ActivityChatDetailsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatDetailsActivity extends AppCompatActivity {
ActivityChatDetailsBinding binding;
FirebaseDatabase database;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityChatDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database= FirebaseDatabase.getInstance();
        auth= FirebaseAuth.getInstance();
        getSupportActionBar().hide();

      final String senderId= auth.getUid();
        String recieveId= getIntent().getStringExtra("userId");
        String userName= getIntent().getStringExtra("userName");
        String profilePic= getIntent().getStringExtra("profilePic");

        binding.userNameACD.setText(userName);
        Picasso.get().load(profilePic).placeholder(R.drawable.ic_whtsapp).into(binding.profileImage);

        binding.backArraow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ChatDetailsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ArrayList<MessageModel>messageModels= new ArrayList<>();
        final ChatAdapter chatAdapter= new ChatAdapter(messageModels,this);
        binding.chatsRecyclerView.setAdapter(chatAdapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.chatsRecyclerView.setLayoutManager(layoutManager);


    }
}*/
package com.example.whtsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.whtsapp.databinding.ActivityChatDetailsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ChatDetailsActivity extends AppCompatActivity {
    FirebaseAuth auth;
    ActivityChatDetailsBinding binding;
    FirebaseDatabase database;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChatDetailsBinding inflate = ActivityChatDetailsBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        this.database = FirebaseDatabase.getInstance();
        this.auth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();
        String uid = this.auth.getUid();
        String stringExtra = getIntent().getStringExtra("userId");
        String userName = getIntent().getStringExtra("userName");
        String profilePic = getIntent().getStringExtra("profilePic");
        this.binding.userNameACD.setText(userName);
        Picasso.get().load(profilePic).placeholder(R.drawable.ic_whtsapp).into((ImageView) this.binding.profileImage);
        this.binding.backArraow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChatDetailsActivity.this.startActivity(new Intent(ChatDetailsActivity.this, MainActivity.class));
            }
        });
    }
}
