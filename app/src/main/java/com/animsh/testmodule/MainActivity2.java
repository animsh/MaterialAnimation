package com.animsh.testmodule;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.transition.platform.MaterialContainerTransform;
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        // Enable Activity Transitions. Optionally enable Activity transitions in your
        // theme with <item name=”android:windowActivityTransitions”>true</item>.
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        // Set the transition name, which matches Activity A’s start view transition name, on
        // the root view.

        // Attach a callback used to receive the shared elements from Activity A to be
        // used by the container transform transition.
        setEnterSharedElementCallback(new MaterialContainerTransformSharedElementCallback());

        // Set this Activity’s enter and return transition to a MaterialContainerTransform
        window.setSharedElementEnterTransition(new MaterialContainerTransform().setDuration(900L).addTarget(R.id.root_layout));
        window.setSharedElementReturnTransition(new MaterialContainerTransform().setDuration(300L).addTarget(R.id.root_layout));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

}