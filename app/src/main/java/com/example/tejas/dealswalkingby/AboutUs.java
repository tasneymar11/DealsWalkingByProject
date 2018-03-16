package com.example.tejas.dealswalkingby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AboutUs extends AppCompatActivity {
//
//    private EditText editMessage;
//    private DatabaseReference mDatabaseReference;
//
//    FirebaseDatabase mFirebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);


//
//        editMessage = (EditText) findViewById(R.id.edit_message);
//
//        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mDatabaseReference = mFirebaseDatabase.getReference().child("Messages");
//
//    }
//
//    public void sendButtonClicked(View view) {
//        final String messageValue = editMessage.getText().toString().trim();
//        if (!TextUtils.isEmpty(messageValue)) {
//            final DatabaseReference newPost = mDatabaseReference.push();
//            newPost.child("content").setValue(messageValue);
//
//        }
//    }

    }
}
