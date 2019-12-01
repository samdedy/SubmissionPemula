package com.sam.alatmusiktradisional;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sam on 16/06/2019.
 */

public class AlatMusikAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<AlatMusik> alatMusiks;

    void setAlatMusiks(ArrayList<AlatMusik> alatMusiks) { this.alatMusiks = alatMusiks; }

    public AlatMusikAdapter(Context context) {
        this.context = context;
        alatMusiks = new ArrayList<>();
    }

    @Override
    public int getCount() { return alatMusiks.size(); }

    @Override
    public Object getItem(int i) { return alatMusiks.get(i); }

    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            // Menghubungkan ViewHolder dengan View
            view = LayoutInflater.from(context).inflate(R.layout.item_alat_musik, viewGroup,false);
        }
        ViewHolder viewHolder = new ViewHolder(view);

        // Mengubah nilai pahlawan sesuai dari posisinya
        AlatMusik alatMusik = (AlatMusik) getItem(i);
        viewHolder.bind(alatMusik);
        return view;
    }

    private class ViewHolder{
        private TextView txtName;
        private TextView txtDaerahAsal;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDaerahAsal = view.findViewById(R.id.txt_daerah_asal);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(AlatMusik alatMusik){
            txtName.setText(alatMusik.getName());
            txtDaerahAsal.setText(alatMusik.getAlamatAsal());
            imgPhoto.setImageResource(alatMusik.getPhoto());
        }
    }
}
