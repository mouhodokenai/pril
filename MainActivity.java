package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Integer countTea = 0;
    private Integer countCoffee = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("countTea")) {
            TextView countView2 = findViewById(R.id.text_tea);
            countTea = savedInstanceState.getInt("countTea");
            countView2.setText(countTea.toString());
        }
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("countCoffee")) {
            TextView countView1 = findViewById(R.id.text_coffee);
            countCoffee = savedInstanceState.getInt("countCoffee");
            countView1.setText(countCoffee.toString());
        }

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedInstanceState.putInt("countTea", countTea);
        savedInstanceState.putInt("countCoffee", countCoffee);
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddTea(View view) {
        countTea++;
        TextView countView2 = findViewById(R.id.text_tea);
        countView2.setText(countTea.toString());

    }
    @SuppressLint("SetTextI18n")
    public void onClickAddCoffee(View view) {
        countCoffee++;
        TextView countView1 = findViewById(R.id.text_coffee);
        countView1.setText(countCoffee.toString());
    }
    @SuppressLint("SetTextI18n")
    public void onClickZero(View view) {
        countCoffee = 0;
        countTea = 0;
        TextView countView1 = findViewById(R.id.text_coffee);
        countView1.setText(countCoffee.toString());
        TextView countView2 = findViewById(R.id.text_tea);
        countView2.setText(countTea.toString());
    }
}
