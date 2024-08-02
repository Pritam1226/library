package com.example.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanagement.LibraryManagementSystem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Button by its ID
        Button button = findViewById(R.id.btn_go_to_another_activity);

        // Set an OnClickListener on the Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start AnotherActivity
                Intent intent = new Intent(MainActivity.this, LibraryManagementSystem.class);
                startActivity(intent);
            }
        });
    }
}
