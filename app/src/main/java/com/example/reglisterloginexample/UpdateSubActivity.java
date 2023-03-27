package com.example.reglisterloginexample;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateSubActivity {
    EditText ex1, ex2, ex3, ex4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = Intent.getIntent();
        String ID = intent.getStringExtra("ID");
        String Pass = intent.getStringExtra("Pass");
        String Name = intent.getStringExtra("Name");
        String Age = intent.getStringExtra("Age");

        ex1 = findViewById(R.id.et_id);
        ex1.setText(ID);

        ex2 = findViewById(R.id.et_pass);
        ex2.setText(Pass);

        ex3 = findViewById(R.id.et_name);
        ex3.setText(Name);

        ex4 = findViewById(R.id.et_age);
        ex4.setText(Age);
    }

    public void onButton2Click(View view) {
        Intent data = new Intent();

        String ID = ex1.getText().toString();
        String Pass = ex2.getText().toString();
        String Name = ex3.getText().toString();
        String Age = ex4.getText().toString();

        data.putExtra("ID", ID);
        data.putExtra("Pass", Pass);
        data.putExtra("Name", Name);
        data.putExtra("Age", Age);

        setResult(Activity.RESULT_OK, data);
        finish();
    }

}
