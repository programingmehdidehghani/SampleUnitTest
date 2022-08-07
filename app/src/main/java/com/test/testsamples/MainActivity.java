package com.amnpardaz.testsamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.amnpardaz.testsamples.Adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    Button button;
    EditText editTextTextPersonName;
    ConstraintLayout constraint;
    TextView textView;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rvAnimals);


        List<String> animalNames = new ArrayList<>();
        animalNames.add("Android");
        animalNames.add("Studio");
        animalNames.add("Test");
        animalNames.add("Junit");
        animalNames.add("Espresso");
        animalNames.add("Before");
        animalNames.add("AssertAll");
        animalNames.add("AssertNot");

        if (animalNames.size() != 0) {
            adapter = new MyRecyclerViewAdapter(this, animalNames);
            linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
        }

        button = (Button) findViewById(R.id.button);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        //constraint = (ConstraintLayout) findViewById(R.id.constraint);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editTextTextPersonName.getText());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                // Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        editTextTextPersonName.setFocusable(false);
        editTextTextPersonName.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        super.onResume();
    }
}