package com.example.admin.parkingticket;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.parkingticket.adapter.TicketAdapter;
import com.example.admin.parkingticket.db.AppDatabase;
import com.example.admin.parkingticket.db.TicketDao;
import com.example.admin.parkingticket.model.Ticket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTicketActivity extends AppCompatActivity {
    Button btnShowAlert;
    Context context;
    AlertDialog alertDialog = null;
    private Button saveButton;
    RadioButton rb1,rb2,rb3,rb4;
    Spinner spinner;
    ImageView imageView;
    private final String TAG = DisplayDataActivity.class.getSimpleName();

    SharedPreferences sharedPreferences;
    private TicketAdapter ticketAdapter;
    EditText VehicleNumber;
    Spinner spinnerBrand;
    Spinner spinnerColor;
    Spinner spinnerLane;
    Spinner spinnerSpot;
    Spinner spinnerPayment;

    RadioGroup timing;

    Button saveTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_ticket );

        TextView txtView = (TextView) findViewById( R.id.txtViewDate );
        SimpleDateFormat DateFormat = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
        String currentDateTimeString = DateFormat.getDateTimeInstance().format( new Date() );
        txtView.setText( currentDateTimeString );

        VehicleNumber = findViewById(R.id.vehicleNumber);
        spinnerBrand = findViewById(R.id.spinner);
        spinnerColor = findViewById(R.id.spinner1);
        spinnerLane = findViewById(R.id.spinner2);
        spinnerSpot = findViewById(R.id.spinner3);
        spinnerPayment = findViewById(R.id.spinner4);

        saveTicket = findViewById(R.id.btnSaveTicket);

        saveTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"parkingTicket")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();

                Ticket ticket = new Ticket(1,
                        VehicleNumber.getText().toString(),
                        spinnerBrand.getSelectedItem().toString(),
                        spinnerColor.getSelectedItem().toString(),
                        "10",
                        spinnerLane.getSelectedItem().toString(),
                        spinnerSpot.getSelectedItem().toString(),
                        spinnerPayment.getSelectedItem().toString());

                db.ticketDao().insertNewTicket(ticket);
                startActivity(new Intent(AddTicketActivity.this, HomeActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
       // inflater.inflate(R.menu.menu, menu);
        return true;

    }

  /*  public boolean onOptionsItemSelected(MenuItem item) {
        VehicleNumber = findViewById( R.id.vehicleNumber );
        switch (item.getItemId()) {
            case R.id.saveKey:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);


                alertDialog.setTitle("SAVE");
                alertDialog.setMessage("Are you sure you want save this?");
                alertDialog.setIcon(R.drawable.ic_menu_save);
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG,"Onclick: Vehicle Num" + VehicleNumber.getText().toString());
                        Intent intent = new Intent(AddTicketActivity.this, DisplayDataActivity.class);
                        startActivity(intent);

                    }
                });

                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(AddTicketActivity.this, AddTicketActivity.class);
                        startActivity(intent);
                        dialog.cancel();
                    }
                });

                alertDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }
    public void getTicket()
    {
        sharedPreferences = getSharedPreferences("userDetails",MODE_PRIVATE);
        // String email = sharedPreferences.getString("Email", null);

        Ticket ticket = new Ticket();
        ticket.setVehicleNumber(VehicleNumber.getText().toString());
        ticket.setCarbrand((String) spinnerBrand.getItemAtPosition(spinnerBrand.getSelectedItemPosition()));
        ticket.setCarColor((String) spinnerColor.getItemAtPosition(spinnerColor.getSelectedItemPosition()));
        ticket.setLane((String) spinnerLane.getItemAtPosition(spinnerLane.getSelectedItemPosition()));
        ticket.setSpot((String)spinnerSpot.getItemAtPosition(spinnerSpot.getSelectedItemPosition()));
        ticket.setPayment((String) spinnerPayment.getItemAtPosition(spinnerPayment.getSelectedItemPosition()));

        if(ticket != null){
            Toast.makeText(this,"value" + ticket, Toast.LENGTH_LONG).show();
        }
        else {

        }
    }*/
}
