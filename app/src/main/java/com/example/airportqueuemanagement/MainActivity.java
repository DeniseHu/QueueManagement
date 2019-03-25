package com.example.airportqueuemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    Integer[] images = {
            R.drawable.imageleft_1,
            R.drawable.imageright_2,
            R.drawable.imagedown_3,
            R.drawable.imageup_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);

        final Animation fadeout = new AlphaAnimation(1, 0);
        fadeout.setStartOffset(1000);
        fadeout.setDuration(1000);
        imageView = findViewById(R.id.imageView);
        imageView.setAnimation(fadeout);

        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display random image
                Random r;
                r = new Random();
                imageView.setImageResource(images[r.nextInt(images.length)]);
                imageView.startAnimation(fadeout);
            }
        });
    }

}
