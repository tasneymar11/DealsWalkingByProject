package com.example.tejas.dealswalkingby;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tejas.dealswalkingby.Model.Feedback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class faqActivity extends AppCompatActivity {

    EditText mUserFeedback;
    DatabaseReference mDatabaseReference;
    FloatingActionButton mFloatingActionButton;
    TextView feedbackCompletion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("User Feedbacks");
        mUserFeedback = (EditText) findViewById(R.id.editTextUserFeedback);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.sendFeedbackButton);
        feedbackCompletion = (TextView) findViewById(R.id.textViewFeedbackCompletion);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFeedback();
            }
        });

    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = {"stejas44@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent, "Send E-mail");
        startActivity(chooser);
    }

    private void addFeedback(){

        String feedback = mUserFeedback.getText().toString().trim();

        if(!TextUtils.isEmpty(feedback))
        {
            String id = mDatabaseReference.push().getKey();
            Feedback mFeedback = new Feedback(feedback);
            mDatabaseReference.child(id).setValue(mFeedback);


            mUserFeedback.setVisibility(View.INVISIBLE);
            mFloatingActionButton.setVisibility(View.INVISIBLE);
            feedbackCompletion.setVisibility(View.VISIBLE);

        }
        else
        {
            Toast.makeText(this, "Please make sure that you have entered a feedback", Toast.LENGTH_SHORT).show();
        }

    }
}
