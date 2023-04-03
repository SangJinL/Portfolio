package com.example.reglisterloginexample;

import android.app.Activity;
import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateSubRequest extends StringRequest {
    private static final String UPDATE_SUB_REQUEST_URL = "http://192.168.24.163/connect/update.php";
    private final Map<String, String> params;

    public UpdateSubRequest(String userId, String userPassword, String userName, int userAge,
                            Response.Listener<String> listener) {
        super(Request.Method.POST, UPDATE_SUB_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("userID", userId);
        params.put("userPassword", userPassword);
        params.put("userName", userName);
        params.put("userAge", String.valueOf(userAge));
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }

}
