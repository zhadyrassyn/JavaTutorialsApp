package java.tutorials.zhadyrassyn.com.javatutorials.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.tutorials.zhadyrassyn.com.javatutorials.R;

public class DataTypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_types);

        setTitle("Data types");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
