package com.example.genericmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.genericmed.activities.Medicine1Activity;
import com.example.genericmed.activities.Medicine2Activity;
import com.example.genericmed.activities.Medicine3Activity;
import com.example.genericmed.activities.Medicine4Activity;
import com.example.genericmed.activities.Medicine5Activity;
import com.example.genericmed.activities.Medicine6Activity;
import com.example.genericmed.activities.Medicine7Activity;
import com.example.genericmed.activities.Medicine8Activity;
import com.example.genericmed.activities.MedicineActivity;

public class DiseaseActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.array_disease);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(position == 0){
                    Intent intent = new Intent(DiseaseActivity.this, MedicineActivity.class);
                    startActivity(intent);
                }

                if(position == 1){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine1Activity.class);
                    startActivity(intent);
                }

                if(position == 2){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine2Activity.class);
                    startActivity(intent);
                }

                if(position == 3){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine3Activity.class);
                    startActivity(intent);
                }

                if(position == 4){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine4Activity.class);
                    startActivity(intent);
                }

                if(position == 5){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine5Activity.class);
                    startActivity(intent);
                }

                if(position == 6){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine6Activity.class);
                    startActivity(intent);
                }

                if(position == 7){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine7Activity.class);
                    startActivity(intent);
                }

                if(position == 8){
                    Intent intent = new Intent(DiseaseActivity.this, Medicine8Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}