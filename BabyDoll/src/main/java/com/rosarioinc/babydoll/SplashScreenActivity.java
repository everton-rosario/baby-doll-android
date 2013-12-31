package com.rosarioinc.babydoll;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crashlytics.android.Crashlytics;

public class SplashScreenActivity extends Activity {

    private static final long SPLASH_DISPLAY_TIME = 2000l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);

        setContentView(R.layout.activity_splashscreen);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent();
                intent.setClass(SplashScreenActivity.this, MainActivity.class);

                SplashScreenActivity.this.startActivity(intent);
                SplashScreenActivity.this.finish();

                // transition from splash to main menu
                overridePendingTransition(R.anim.activity_main_fadein,
                        R.anim.activity_splash_fadeout);

            }
        }, SPLASH_DISPLAY_TIME);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_splashscreen, container, false);
            return rootView;
        }
    }

}
