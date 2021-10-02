package me.aprizal.githubusers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import de.hdodenhof.circleimageview.CircleImageView;
import me.aprizal.githubusers.main.MainActivity;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        CircleImageView circleImageView = findViewById(R.id.img_icon);
        circleImageView.setImageResource(R.mipmap.ic_launcher);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        });
        thread.start();
    }
}