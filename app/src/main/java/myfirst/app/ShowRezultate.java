package myfirst.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import maes.tech.intentanim.CustomIntent;

public class ShowRezultate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rezultate);
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "fadein-to-fadeout");
    }
}
