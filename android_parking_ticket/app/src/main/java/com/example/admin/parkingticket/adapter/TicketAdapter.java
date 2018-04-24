package com.example.admin.parkingticket.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.parkingticket.R;
import com.example.admin.parkingticket.model.Ticket;

import java.util.ArrayList;
import java.util.List;


public class TicketAdapter extends RecyclerView.Adapter<TicketViewHolder> {
    private List<Ticket> ticketList;
    private Context context;

    public TicketAdapter( Context context,List<Ticket> ticketListjkjhk) {
        this.ticketList = ticketList;
        this.context = context;
    }


    @Override
    public TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_row, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TicketViewHolder holder, int position) {
        Ticket ticket = ticketList.get(position);
        holder.content.setText(ticket.getCarbrand());
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }
}
