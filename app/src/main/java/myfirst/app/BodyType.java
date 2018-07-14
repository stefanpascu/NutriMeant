package myfirst.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;

public class BodyType extends AppCompatActivity {
    TextView message;
    ImageView bodytype1;
    int age, height, weight;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_type);
        Intent intent = getIntent();


        age = intent.getIntExtra("agetext", -1);
        height = intent.getIntExtra("heighttext", -1);
        weight = intent.getIntExtra("weighttext", -1);
        message = (TextView) findViewById(R.id.message);
        bodytype1 = findViewById(R.id.imageView3);
        next = (ImageButton) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2Activity();
            }
        });

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(BodyType.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.bodytypes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    ((ImageView) findViewById(R.id.imageView3)).setVisibility(View.VISIBLE);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void openMain2Activity() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(intent, 0);
        overridePendingTransition(0, 0);
        //startActivity(intent);
    }
}

