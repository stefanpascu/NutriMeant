package myfirst.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;

public class FatUp extends AppCompatActivity {
    int age = 0;
    int height = 0;
    int weight = 0;
    int ok1;
    EditText agetext;
    EditText heighttext;
    EditText weighttext;
    private ImageButton imagebutton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_up);
        ok1 = 1;
        agetext = (EditText) findViewById(R.id.age);
        heighttext = (EditText) findViewById(R.id.height);
        weighttext = (EditText) findViewById(R.id.weight);
        imagebutton5 = (ImageButton) findViewById(R.id.imageButton5);

        registerEvents();

    }

    private void registerEvents() {
        ((ImageButton) findViewById(R.id.imageButton5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okButtonClick();
            }
        });
    }

    private void okButtonClick() {
        if (((EditText) findViewById(R.id.age)).getText().toString().isEmpty()
                || ((EditText) findViewById(R.id.height)).getText().toString().isEmpty()
                || ((EditText) findViewById(R.id.weight)).getText().toString().isEmpty()) {
            ((TextView) findViewById(R.id.FillAllFields)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.FillAllFields)).setText("You must fill all the fields.");
            ((TextView) findViewById(R.id.FillAllFields)).refreshDrawableState();
            return;
        }
        openBodyType();
    }

    public void openBodyType() {
        Intent intent = new Intent(this, BodyType.class);
        intent.putExtra("agetext", Integer.valueOf(agetext.getText().toString().trim()));
        intent.putExtra("heighttext", Integer.valueOf(heighttext.getText().toString().trim()));
        intent.putExtra("weighttext", Integer.valueOf(weighttext.getText().toString().trim()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0, 0);
        //startActivity(intent);
    }

    public void ShowToast(String text) {
        Toast.makeText(FatUp.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "fadein-to-fadeout");
    }
}



