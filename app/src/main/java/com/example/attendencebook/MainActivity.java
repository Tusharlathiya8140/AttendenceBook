package com.example.attendencebook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AttendanceAdapter adapter;
    private ArrayList<Student> studentList;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        submitBtn = findViewById(R.id.submitBtn);

        studentList = new ArrayList<>();
        studentList.add(new Student("Tushar Lathiya", false));
        studentList.add(new Student("Kenil Kukadiya", false));
        studentList.add(new Student("Heet Balar", false));
        studentList.add(new Student("Yash Shutariya", false));
        studentList.add(new Student("Kishan Sapariya", false));
        studentList.add(new Student("Neel Khanpara", false));

        adapter = new AttendanceAdapter(studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Student> presentStudents = new ArrayList<>();
                for (Student student : studentList) {
                    if (student.isPresent()) {
                        presentStudents.add(student);
                    }
                }
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("presentList", presentStudents);
                startActivity(intent);
            }
        });
    }
}