package com.example.admin.parkingticket.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.admin.parkingticket.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insertAll(User... users);

    @Update
    public void update(User... user);

    @Query("SELECT * FROM user WHERE userEmail = :email LIMIT 1")
    public User findByEmail(String email);

}
