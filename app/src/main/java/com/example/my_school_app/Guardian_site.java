package com.example.my_school_app;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class Guardian_site extends AppCompatActivity {

    private static final int NUM_COLUMNS = 2;
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardian_site);

        initImageBitmaps();

    }
   /* public void onCLick(int position){
        if(position==0){
            Intent ii=new Intent(getApplicationContext(),Listview_student_info.class);
        mContext.startActivity(ii);
        }
    }
    */

    private void initImageBitmaps() {
        // Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.principal);
        mNames.add("Principal's Speech");

        mImageUrls.add(R.drawable.notice);
        mNames.add("Notice");

        mImageUrls.add(R.drawable.result);
        mNames.add("Exam Results");

        mImageUrls.add(R.drawable.student_info);
        mNames.add("Student's Information");

        mImageUrls.add(R.drawable.style);
        mNames.add("Teacher's Information");

        mImageUrls.add(R.drawable.daily_activity);
        mNames.add("Daily Activity");
        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);

        Guardian_Site_Adapter guardianSiteAdapter =
                new Guardian_Site_Adapter(this, mNames, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(guardianSiteAdapter);
    }
}
