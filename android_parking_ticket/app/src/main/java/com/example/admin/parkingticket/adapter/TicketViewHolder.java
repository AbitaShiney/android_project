package com.example.admin.parkingticket.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.parkingticket.R;


/**
 * Created by macstudent on 2018-04-18.
 */

public class TicketViewHolder extends RecyclerView.ViewHolder{
    public TextView content;

    public  TicketViewHolder(View itemView){
        super(itemView);

        //content = (TextView) itemView.findViewById(R.id.content);
    }
}
