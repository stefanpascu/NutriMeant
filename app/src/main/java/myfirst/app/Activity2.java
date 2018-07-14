package myfirst.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import maes.tech.intentanim.CustomIntent;

public class Activity2 extends AppCompatActivity {
    private ImageButton imagebutton;
    private ImageButton imagebutton2;
    private ImageButton imagebutton3;
    private ImageButton imagebutton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        imagebutton = (ImageButton) findViewById(R.id.imageButton);
        imagebutton2 = (ImageButton) findViewById(R.id.imageButton2);
        imagebutton3 = (ImageButton) findViewById(R.id.imageButton3);
        imagebutton4 = (ImageButton) findViewById(R.id.imageButton4);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFatUp();
            }
        });

        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFatUp();
            }
        });

        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFatUp();
            }
        });

        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFatUp();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void openFatUp() {
        Intent intent = new Intent(this, FatUp.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0, 0);
        //startActivity(intent);
    }
}
