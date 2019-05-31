package com.marcus.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd;
    Button buttonClear;
    TextView editNewToDo;
    ListView listViewToDo;

    ArrayList<String> taskList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        editNewToDo = findViewById(R.id.editNewToDo);
        listViewToDo = findViewById(R.id.listViewToDo);

        taskList = new ArrayList<>();
        taskList.add("");
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, taskList);

        listViewToDo.setAdapter(adapter);


         buttonAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String taskName = editNewToDo.getText().toString();
                 taskList.add(taskName);
                 adapter.notifyDataSetChanged();
             }
         });

         buttonClear.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 taskList.remove(0);
                 adapter.notifyDataSetChanged();
             }
         });

         listViewToDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                 taskList.remove(i);
                 adapter.notifyDataSetChanged();
             }
         });



    }
};


