package com.example.admin.parkingticket;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.parkingticket.db.AppDatabase;
import com.example.admin.parkingticket.model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText fullName, password, email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName = findViewById(R.id.edtName);
        password = findViewById(R.id.edtPassword);
        email = findViewById(R.id.edtEmail);

        register = findViewById(R.id.btnSaveUser);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"parkingTicket")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                User user = new User(fullName.getText().toString(), password.getText().toString(), email.getText().toString());
                db.userDao().insertAll(user);
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

    }

}
