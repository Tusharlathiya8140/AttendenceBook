package com.example.attendencebook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display);
        displayTextView = findViewById(R.id.displayTextView);

        ArrayList<Student> presentList = (ArrayList<Student>) getIntent().getSerializableExtra("presentList");

        StringBuilder builder = new StringBuilder();
        for (Student student : presentList) {
            builder.append(student.getName()).append("\n");
        }
        displayTextView.setText(builder.toString());
    }
}