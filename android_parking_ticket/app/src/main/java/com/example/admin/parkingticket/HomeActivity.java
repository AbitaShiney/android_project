package com.example.admin.parkingticket;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.parkingticket.db.AppDatabase;
import com.example.admin.parkingticket.model.Ticket;

import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        total = findViewById(R.id.myTotal);


        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"parkingTicket")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        List<Ticket> ticket = db.ticketDao().getAllTicket();
        total.setText(String.valueOf(ticket.size()));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            startActivity(new Intent(HomeActivity.this, HomeActivity.class));

        } else if (id == R.id.nav_ticket) {

            startActivity(new Intent(HomeActivity.this, AddTicketActivity.class));

        } else if (id == R.id.nav_location) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:0.0?q=43.6497688,-79.3895("+getString(R.string.app_name)+ ")"));
            if(intent.resolveActivity(getPackageManager())!=null)
            {
                startActivity(intent);
            }

        } else if (id == R.id.nav_report) {

            startActivity(new Intent(HomeActivity.this, ReportActivity.class));

        } else if (id == R.id.nav_profile) {

            startActivity(new Intent(HomeActivity.this, HomeActivity.class));

        } else if (id == R.id.nav_instructions) {

            startActivity(new Intent(HomeActivity.this, InstructionActivity.class));

        } else if (id == R.id.nav_contact) {

            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);

            builder.setTitle("Need Help?");
            builder.setMessage("Call or sms us at +1 1234567890                                                     9:00 A.M - 8:00 P.M ET M-F  ");
            ;

            builder.setCancelable(false);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }});

            builder.setNeutralButton("Call", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+1 1234567890"));
                    startActivity(intent);
                }});

            builder.setNegativeButton("sms", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    String message = "";
                    String PHONENO = "+1 1234567890";
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + PHONENO));
                    smsIntent.putExtra("sms_body", message);
                    startActivity(smsIntent);
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
            alert.getWindow().setBackgroundDrawableResource(android.R.color.holo_red_light);

            Button btnneg = alert.getButton(DialogInterface.BUTTON_NEGATIVE);

            btnneg.setTextColor(Color.BLACK);

            Button btnpos= alert.getButton(DialogInterface.BUTTON_POSITIVE);
            Button btnneu= alert.getButton(DialogInterface.BUTTON_NEUTRAL);
            btnpos.setBackgroundColor(Color.WHITE);
            btnpos.setTextColor(Color.BLACK);
            btnneu.setBackgroundColor(Color.WHITE);
            btnneu.setTextColor(Color.BLACK);
            btnneg.setBackgroundColor(Color.WHITE);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(570,0,0,0);
            btnpos.setLayoutParams(params);

        } else if (id == R.id.nav_logout) {

            startActivity(new Intent(HomeActivity.this, MainActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
