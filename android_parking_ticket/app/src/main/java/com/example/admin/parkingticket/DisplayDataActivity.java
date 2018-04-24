package com.example.admin.parkingticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
/*
import com.example.admin.parkingticket.R;
import com.example.admin.parkingticket.adapter.TicketAdapter;
*/
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DisplayDataActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_display_data );

        TextView txtView = (TextView) findViewById(R.id.text);
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        txtView.setText(currentDateTimeString);


        RecyclerView recyclerView = (RecyclerView) findViewById( R.id.tickets );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( DisplayDataActivity.this );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setHasFixedSize( true );

        /*
        TicketDao ticketDao = (TicketDao) AppDatabase.getInstance( getApplicationContext() ).ticket();
        ticketDao.getAllTicket().observe( this, (List<Ticket> ticket) -> {
            ticketAdapter = new TicketAdapter( DisplayDataActivity.this, ticket );
            recyclerView.setAdapter( ticketAdapter );

        } ); */


    }
 }

