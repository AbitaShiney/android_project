package com.example.admin.parkingticket.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.admin.parkingticket.model.Ticket;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TicketDao {

    @Query("Select * from Ticket")
    public List<Ticket> getAllTicket();

    @Query("Select COUNT(*) from Ticket")
    int getNumberOfRows();

    @Delete
    void deleteTicket(Ticket ticket);


    @Insert(onConflict = REPLACE)
    void insertNewTicket(Ticket... ticket);
}
