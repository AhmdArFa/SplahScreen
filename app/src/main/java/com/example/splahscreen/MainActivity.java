package com.example.splahscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView name,slogan;
    private ImageView logo;
    private View topView,topView2,topView3;
    private View bottomView,bottomView2,bottomView3;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorview = getWindow().getDecorView();
        decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_FULLSCREEN
        |View.SYSTEM_UI_FLAG_IMMERSIVE);
        //Hide Navigation Bar to make activity appears full screen
        setContentView(R.layout.activity_main);
        init();
        Animation logoanimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_animation);

        Animation nameanimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_animation);

        Animation topViewanimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.top_view_animation);
        Animation topView2animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.top_view_animation);
        Animation topView3animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.top_view_animation);

        Animation bottomViewanimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_view_animation);
        Animation bottomView2animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_view_animation);
        Animation bottomView3animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_view_animation);

        topView.startAnimation(topViewanimation);
        bottomView.startAnimation(bottomViewanimation);

        topViewanimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                topView2.setVisibility(View.VISIBLE);
                bottomView2.setVisibility(View.VISIBLE);

                topView2.startAnimation(topView2animation);
                bottomView2.startAnimation(bottomView2animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

            topView2animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    topView3.setVisibility(View.VISIBLE);
                    bottomView3.setVisibility(View.VISIBLE);

                    topView3.startAnimation(topView3animation);
                    bottomView3.startAnimation(bottomView3animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            topView3animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    logo.setVisibility(View.VISIBLE);
                    logo.startAnimation(logoanimation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            logoanimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    name.setVisibility(View.VISIBLE);
                    name.startAnimation(nameanimation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            nameanimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    slogan.setVisibility(View.VISIBLE);
                    final String animatetxt = slogan.getText().toString();
                    slogan.setText("");
                    count = 0;
                    new CountDownTimer(animatetxt.length() * 100 , 100){

                        @Override
                        public void onTick(long l) {
                            slogan.setText(slogan.getText().toString()+animatetxt.charAt(count));
                            count++;
                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
    }
    private void init(){
        name=findViewById(R.id.name);
        slogan=findViewById(R.id.slogan);
        logo=findViewById(R.id.logo);
        topView=findViewById(R.id.topView);
        topView2=findViewById(R.id.topView2);
        topView3=findViewById(R.id.topView3);
        bottomView=findViewById(R.id.bottomView);
        bottomView2=findViewById(R.id.bottomView2);
        bottomView3=findViewById(R.id.bottomView3);


    }
}