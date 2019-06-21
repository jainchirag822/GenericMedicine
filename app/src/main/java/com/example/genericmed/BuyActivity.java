package com.example.genericmed;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BuyActivity extends AppCompatActivity {

    public EditText name, add1, add2, city, state, pincode, email, no;
    public Button send;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        name = (EditText) findViewById(R.id.name);
        add1 = (EditText) findViewById(R.id.add1);
        add2 = (EditText) findViewById(R.id.add2);
        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        pincode = (EditText) findViewById(R.id.pincode);
        email = (EditText) findViewById(R.id.email);
        no = (EditText) findViewById(R.id.no);

        send = (Button) findViewById(R.id.send);

        databaseReference = FirebaseDatabase.getInstance().getReference("customer");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(BuyActivity.this);
                builder.setTitle("Confirm Your Order?");
                builder.setMessage("Please, Check Your all Details");
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCustomers();
                    }
                });
                builder.show();
            }
        });
    }

    public void addCustomers() {
        String CustomerName = name.getText().toString();
        String CustomerAdd1 = add1.getText().toString();
        String CustomerAdd2 = add2.getText().toString();
        String CustomerCity = city.getText().toString();
        String CustomerState = state.getText().toString();
        String CustomerPin = pincode.getText().toString();
        String CustomerEmail = email.getText().toString();
        String CustomerNo = no.getText().toString();

        if (!TextUtils.isEmpty(CustomerName) && !TextUtils.isEmpty(CustomerAdd1) && !TextUtils.isEmpty(CustomerAdd2) && !TextUtils.isEmpty(CustomerCity) && !TextUtils.isEmpty(CustomerState) && !TextUtils.isEmpty(CustomerPin) && !TextUtils.isEmpty(CustomerEmail) && !TextUtils.isEmpty(CustomerNo)) {

            String id = databaseReference.push().getKey();

            Customer customer = new Customer(id, CustomerName, CustomerAdd1, CustomerAdd2, CustomerCity, CustomerState, CustomerPin, CustomerEmail, CustomerNo);

            databaseReference.child(id).setValue(customer);

            name.setText("");
            add1.setText("");
            add2.setText("");
            city.setText("");
            state.setText("");
            pincode.setText("");
            email.setText("");
            no.setText("");

            Toast.makeText(BuyActivity.this, "Data Inserted Successfully.", Toast.LENGTH_LONG).show();

            final AlertDialog.Builder builder1 = new AlertDialog.Builder(BuyActivity.this);
            builder1.setTitle("Your Order is Successfully Placed");
            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(BuyActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            builder1.show();
        }
        else {
            Toast.makeText(BuyActivity.this,"Please, Fill Your All Details.", Toast.LENGTH_LONG).show();
        }
    }
}