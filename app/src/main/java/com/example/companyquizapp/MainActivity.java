package com.example.companyquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

   private ConstraintLayout ParentLayout;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      final TextView SplashText;

      SplashText = findViewById(R.id.splash_text);
      ParentLayout = findViewById(R.id.parent_layout);

      SplashText.animate().alpha(1).setDuration(500);


      Fade fade = new Fade();
      View decor = getWindow().getDecorView();
      fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
      fade.excludeTarget(android.R.id.statusBarBackground, true);
      fade.excludeTarget(android.R.id.navigationBarBackground, true);
      getWindow().setEnterTransition(fade);
      getWindow().setExitTransition(fade);
      new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    MainActivity.this, SplashText, Objects.requireNonNull(ViewCompat.getTransitionName(SplashText)));
            startActivity(intent, options.toBundle());
            finish();
         }
      },1500);

   }

}