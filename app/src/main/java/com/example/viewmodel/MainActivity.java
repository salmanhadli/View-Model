package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        // Using Live Data
        LiveData<Integer> count = mainActivityViewModel.getCounter();
        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText("You clicked: " + integer + " times");
            }
        });

//        textView.setText("You clicked: " + count + " times");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.incrementCounter();
//                textView.setText("You clicked: "+ mainActivityViewModel.incrementCounter() + " times");
            }
        });
    }
}