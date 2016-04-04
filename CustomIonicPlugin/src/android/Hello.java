package com.example.plugin;

import android.util.Log;
import android.widget.Toast;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class Hello extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("greet")) {
            String name = data.getString(0);
            String message = "Hello, " + name;

            Toast.makeText(this.cordova.getActivity(), message, Toast.LENGTH_LONG).show();
            Log.d("testPlugin", name);
            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
