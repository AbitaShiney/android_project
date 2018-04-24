package com.example.admin.parkingticket.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.RoomDatabase;

import com.example.admin.parkingticket.model.Ticket;
import com.example.admin.parkingticket.model.User;


@Database(entities = {User.class, Ticket.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract TicketDao ticketDao();
}
