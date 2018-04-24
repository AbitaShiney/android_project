package com.example.admin.parkingticket.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.parkingticket.R;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {


    List<Ticket> reports;

    public ReportAdapter(List<Ticket> reports) {
        this.reports = reports;
    }

    @NonNull
    @Override
    public ReportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.ViewHolder holder, int position) {
    holder.vehicleColor.setText(reports.get(position).getVehicleNumber());
    holder.brand.setText(reports.get(position).getCarbrand());
    holder.vehicleColor.setText(reports.get(position).getCarColor());
    holder.position.setText(reports.get(position).getSpot());
    holder.lane.setText(reports.get(position).getLane());
    holder.time.setText(reports.get(position).getTiming());
    holder.paymentMethod.setText(reports.get(position).getPayment());
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView vehicleNumber;
        public TextView brand;
        public TextView vehicleColor;
        public TextView position;
        public TextView lane;
        public TextView time;
        public TextView paymentMethod;

        public ViewHolder(View itemView) {
            super(itemView);

            vehicleNumber = itemView.findViewById(R.id.vvnumber);
            brand = itemView.findViewById(R.id.vbrand);
            vehicleColor = itemView.findViewById(R.id.vcolor);
            position = itemView.findViewById(R.id.position);
            lane = itemView.findViewById(R.id.lane);
            time = itemView.findViewById(R.id.time);
            paymentMethod = itemView.findViewById(R.id.paymethod);
        }
    }
}
