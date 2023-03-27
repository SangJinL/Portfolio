package com.example.reglisterloginexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class UpdateActivity extends Activity {
    private static final int CALL_SUBACTIVITY =0;
    EditText ex_id, ex_pass, ex_name, ex_age;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void onButtonClick(View view) {
        ex_id = findViewById(R.id.ex_id);
        String ID = ex_id.getText().toString();

        ex_pass = findViewById(R.id.ex_pass);
        String Pass = ex_pass.getText().toString();

        ex_name = findViewById(R.id.ex_name);
        String Name = ex_name.getText().toString();

        ex_age = findViewById(R.id.ex_age);
        String Age = ex_age.getText().toString();

    Intent intent = new Intent(this.getApplicationContext(), UpdateSubActivity.class);
        intent.putExtra("ID", ID);
        intent.putExtra("Pass", Pass);
        intent.putExtra("Name", Name);
        intent.putExtra("Age", Age);

        startActivityForResult(intent, CALL_SUBACTIVITY);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CALL_SUBACTIVITY:
                if(requestCode == RESULT_OK) {
                    String ID = data.getStringExtra("ID");
                    String Pass = data.getStringExtra("Pass");
                    String Name = data.getStringExtra("Name");
                    String Age = data.getStringExtra("Age");

                    ex_id.setText(ID);
                    ex_pass.setText(Pass);
                    ex_name.setText(Name);
                    ex_age.setText(Age);
                }
                break;
        }


    }
}
