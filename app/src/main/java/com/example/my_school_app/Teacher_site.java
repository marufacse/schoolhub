package com.example.my_school_app;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class Teacher_site extends AppCompatActivity {

Button logout;
    private static final int NUM_COLUMNS2 = 2;
    private ArrayList<Integer> nImageUrls = new ArrayList<>();
    private ArrayList<String> nNames = new ArrayList<>();
    private Context nContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_site);
      initImageBitmaps2();
    }
    private void initImageBitmaps2() {
        // Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        nImageUrls.add(R.drawable.principal);
        nNames.add("Principal's Speech");

        nImageUrls.add(R.drawable.notice);
        nNames.add("Notice");

        nImageUrls.add(R.drawable.result);
        nNames.add("Exam Results");

        nImageUrls.add(R.drawable.student_info);
        nNames.add("Student's Information");

        nImageUrls.add(R.drawable.style);
        nNames.add("Teacher's Information");


        nImageUrls.add(R.drawable.daily_activity);
        nNames.add("Daily Activity");

        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView3);

        Teacher_Site_Adapter recyclerView_stag_teacher =
                new Teacher_Site_Adapter(this, nNames, nImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS2, LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(staggeredGridLayoutManager);
        recyclerView2.setAdapter(recyclerView_stag_teacher);
    }
}
