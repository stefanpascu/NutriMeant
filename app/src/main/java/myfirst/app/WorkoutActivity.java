package myfirst.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import maes.tech.intentanim.CustomIntent;

public class WorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "fadein-to-fadeout");
    }
}
