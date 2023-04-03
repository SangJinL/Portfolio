package com.example.reglisterloginexample;

import android.app.Activity;
import android.content.Intent;
import android.media.tv.PesRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateActivity extends AppCompatActivity {
    private EditText ex_pass, ex_name, ex_age;
    private Button btn_updateuser;

    String userID;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_update);

        ex_pass = findViewById(R.id.ex_pass);
        ex_name = findViewById(R.id.ex_name);
        ex_age = findViewById(R.id.ex_age);

        Intent intent = getIntent();
        userID = intent.getStringExtra("userId");

        btn_updateuser = findViewById(R.id.btn_updateuser);

        btn_updateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                String userPass = ex_pass.getText().toString();
                String userName = ex_name.getText().toString();
                int userAge = Integer.parseInt(ex_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                finish();
                            } else {

                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                UpdateSubRequest registerRequest = new UpdateSubRequest(userID, userPass,userName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UpdateActivity.this);
                queue.add(registerRequest);


            }
        });
    }


}