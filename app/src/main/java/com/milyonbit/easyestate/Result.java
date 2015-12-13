package com.milyonbit.easyestate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
        final TextView resultPhone = (TextView) findViewById(R.id.result_phone);
        TextView resultType = (TextView) findViewById(R.id.result_type);
        TextView resultPrice = (TextView) findViewById(R.id.result_price);
        TextView resultSize = (TextView) findViewById(R.id.result_size);
        TextView resultRoomCount = (TextView) findViewById(R.id.result_room_count);
        TextView resultCredit = (TextView) findViewById(R.id.result_credit);
        final TextView resultLink = (TextView) findViewById(R.id.result_link);
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
            Log.e("",e.getMessage());
        }

        resultPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(resultPhone.getText().toString());
            }
        });

        resultLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebURL(resultLink.getText().toString());
            }
        });
    }

    public void call(String number) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + number));
            startActivity(callIntent);
        } catch (SecurityException e) {
            Log.e("HATA", e.toString());
        }
    }

    public void openWebURL( String url ) {

        if(!url.startsWith("http://") || !url.startsWith("https://"))
            url = "http://" + url;
        try{
            Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( url ) );
            startActivity( browse );
        }
        catch (Exception e){
            Log.e("ERROR ON WEB PAGE",e.toString());
        }

    }
}
