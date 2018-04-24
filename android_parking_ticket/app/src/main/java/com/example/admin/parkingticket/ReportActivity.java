package com.example.admin.parkingticket;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.parkingticket.db.AppDatabase;
import com.example.admin.parkingticket.model.ReportAdapter;
import com.example.admin.parkingticket.model.Ticket;
import com.example.admin.parkingticket.model.User;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

   //ArrayList<User> reports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        recyclerView = findViewById(R.id.recycler_view);


    /*    reports = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            User reporte = new User("Brian Jones", "admin", "brianjxd@gmail.com");
            reports.add(reporte);

        }*/

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"parkingTicket")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        List<Ticket> reports = db.ticketDao().getAllTicket();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ReportAdapter(reports);
        recyclerView.setAdapter(adapter);

    }
}
