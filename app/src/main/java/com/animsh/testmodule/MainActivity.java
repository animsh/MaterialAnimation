package com.animsh.testmodule;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        // Enable Activity Transitions. Optionally enable Activity transitions in your
        // theme with <item name=”android:windowActivityTransitions”>true</item>.
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        // Attach a callback used to capture the shared elements from this Activity to be used
        // by the container transform transition
        setExitSharedElementCallback(new MaterialContainerTransformSharedElementCallback());
        // Keep system bars (status bar, navigation bar) persistent throughout the transition.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ConstraintLayout constraintLayout = findViewById(R.id.child_layout);

        findViewById(R.id.click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        constraintLayout, "shared_element_container");
                startActivity(intent, options.toBundle());
            }
        });

    }


}