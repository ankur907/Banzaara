package com.example.banzaaraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.banzaaraapp.adapter.RecentsAdapter;
import com.example.banzaaraapp.model.RecentsData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<RecentsData> recentsDataList =new ArrayList<>();
        recentsDataList.add(new RecentsData("Marriott Hotel","India","$300",R.drawable.marroitthotel ));
        recentsDataList.add(new RecentsData("Marriott Hotel","India","$300",R.drawable.marroitthotel ));
        recentsDataList.add(new RecentsData("Marriott Hotel","India","$300",R.drawable.marroitthotel ));
        recentsDataList.add(new RecentsData("Marriott Hotel","India","$300",R.drawable.marroitthotel ));
        recentsDataList.add(new RecentsData("Marriott Hotel","India","$300",R.drawable.marroitthotel ));
        recentsDataList.add(new RecentsData("Marriott Hotel","India","$300",R.drawable.marroitthotel ));

        setRecentRecycler(recentsDataList);
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList){

        recentRecycler=findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter=new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);


    }


}