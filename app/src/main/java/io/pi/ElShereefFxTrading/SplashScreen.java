package io.pi.ElShereefFxTrading;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.pi.ElShereefFxTrading.Models.SplashPrefrences;

public class SplashScreen extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

    TextView welcomeText;
    ImageView background;

    int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        welcomeText = (TextView) findViewById(R.id.splash_text);
        background = (ImageView) findViewById(R.id.splash_bg);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("splash_prefs");

        Query query = reference.limitToLast(1);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SplashPrefrences splashPrefrences = dataSnapshot.getValue(SplashPrefrences.class);

                welcomeText.setText(splashPrefrences.getMessage());

                Picasso.get().load(splashPrefrences.getBgURL())
                        .placeholder(R.mipmap.splash_screen_bg)
                        .into(background);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
