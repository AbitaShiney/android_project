package com.example.admin.parkingticket;

import android.app.ActionBar;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.parkingticket.db.AppDatabase;
import com.example.admin.parkingticket.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText edEmail, edPassword;
    private Button register, login;

    private CheckBox myCheckBox;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);

        register = findViewById(R.id.btnRegister);
        login = findViewById(R.id.btnLogin);

        edEmail = findViewById(R.id.edtUser);
        edPassword = findViewById(R.id.edtPassword);

        myCheckBox = findViewById(R.id.checkBoxRememberMe);

        String userid = sharedPreferences.getString("userid", null);
        String password = sharedPreferences.getString("password", null);

        if(userid != null && password != null){
            edEmail.setText(userid);
            edPassword.setText(password);
            myCheckBox.setChecked(true);
        }else {
            myCheckBox.setChecked(false);
        }

        login.setOnClickListener(signUp);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }


    private View.OnClickListener signUp = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"parkingTicket")
                    .allowMainThreadQueries()
                    .build();

            User user = db.userDao().findByEmail(edEmail.getText().toString());

            if(TextUtils.isEmpty(user.getUserEmail()) || user.getUserEmail().length() == 0)
            {
                edEmail.setError("Please Enter User Name");
            }
            else {

                if (edEmail.getText().toString().equals(user.getUserEmail()) && edPassword.getText().toString().equals(user.getUserPassword())) {
                    Toast.makeText(MainActivity.this, "User Successfully logged in ", Toast.LENGTH_LONG).show();

                    //4 - Get editor object
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if(myCheckBox.isChecked())
                    {
                        //5 - Save value to Shared Preferences using editor object
                        editor.putString("userid", edEmail.getText().toString());
                        editor.putString("password", edPassword.getText().toString());
                    }
                    else
                    {
                        //6 - Remove values from shared preferences
                        editor.remove("userid");
                        editor.remove("password");
                    }
                    //7 - Save changes permanently to shared preferences
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "UserID/passwords invalid", Toast.LENGTH_LONG).show();

                }
            }
        }
    };

    @Override
    protected void onResume() {
        sharedPreferences = getSharedPreferences("userDetails",MODE_PRIVATE);
        setSavedDetails();
        super.onResume();

    }

    private void setSavedDetails() {
        String email = sharedPreferences.getString("userEmail", null);
        String pwd = sharedPreferences.getString("userPassword", null);

        if (email != null && pwd != null) {
            edEmail.setText(email);
            edPassword.setText(pwd);
            myCheckBox.setChecked(true);
        }
    }

}
