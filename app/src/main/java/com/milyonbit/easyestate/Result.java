package com.milyonbit.easyestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by FerdiKT on 12/12/15.
 */
public class Result extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView resultOwnerName = (TextView) findViewById(R.id.result_owner_name);
        TextView resultPhone = (TextView) findViewById(R.id.result_phone);
        TextView resultType = (TextView) findViewById(R.id.result_type);
        TextView resultPrice = (TextView) findViewById(R.id.result_price);
        TextView resultSize = (TextView) findViewById(R.id.result_size);
        TextView resultRoomCount = (TextView) findViewById(R.id.result_room_count);
        TextView resultCredit = (TextView) findViewById(R.id.result_credit);
        TextView resultLink = (TextView) findViewById(R.id.result_link);
        TextView resultDesc = (TextView) findViewById(R.id.result_description);



        Intent i = getIntent();
        String result = i.getStringExtra("Scanned");
        try {
            JSONObject jsonObject = new JSONObject(result);
            resultOwnerName.setText(jsonObject.getString("Name"));
            resultPhone.setText(jsonObject.getString("Phone"));
            resultType.setText(jsonObject.getString("Type"));
            resultPrice.setText(jsonObject.getString("Price") + " "+ jsonObject.getString("Money Type"));
            resultSize.setText(jsonObject.getString("Meter"));
            resultRoomCount.setText(jsonObject.getString("Room"));
            resultCredit.setText(jsonObject.getString("Credit"));
            resultLink.setText(jsonObject.getString("Link"));
            resultDesc.setText(jsonObject.getString("Desc"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
