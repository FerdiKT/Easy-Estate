package com.milyonbit.easyestate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by FerdiKT on 11/12/15.
 */
public class CreateForm extends AppCompatActivity {

    Button createQR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_form);
        createQR = (Button) findViewById(R.id.createQR);

        EditText price = (EditText) findViewById(R.id.price);
        EditText meters = (EditText) findViewById(R.id.meter);
        EditText roomCount = (EditText) findViewById(R.id.room_count);
        EditText credit = (EditText) findViewById(R.id.credit);
        EditText desc = (EditText) findViewById(R.id.description);

        Spinner houseType = (Spinner) findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> adapterHouse = ArrayAdapter.createFromResource(this,
                R.array.types_array, android.R.layout.simple_spinner_item);
        adapterHouse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        houseType.setAdapter(adapterHouse);

        Spinner moneyType =(Spinner) findViewById(R.id.money_type);
        ArrayAdapter<CharSequence> adapterMoney = ArrayAdapter.createFromResource(this,
                R.array.money_types_array, android.R.layout.simple_spinner_item);
        adapterMoney.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moneyType.setAdapter(adapterMoney);

        final JSONObject jsonObject;

        Data datas = new Data();
        datas.setPrice(price.getText());
        datas.setMeter(meters.getText());
        datas.setRoomCount(roomCount.getText());
        datas.setCredit(credit.getText());
        datas.setDesc(desc.getText());
        datas.setType(houseType.getSelectedItem().toString());
        datas.setMoneyType(moneyType.getSelectedItem().toString());

        try {
            jsonObject = createJSON(datas);
            createQR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent a = new Intent(CreateForm.this, QRCreated.class);
                    a.putExtra("Info",jsonObject.toString());
                    startActivity(a);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    JSONObject createJSON(Data data) throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Price",data.getPrice());
        jsonObject.put("Money Type", data.getMoneyType());
        jsonObject.put("Meter",data.getMeter());
        jsonObject.put("Room",data.getRoomCount());
        jsonObject.put("Credit",data.getCredit());
        jsonObject.put("Desc",data.getDesc());
        jsonObject.put("Type",data.getType());
        return jsonObject;
    }
}
