package com.tapitapp.tapitapp.util;

import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tapitapp.tapitapp.R;
import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.model.Comandas;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterComanda extends RecyclerView.Adapter<AdapterComanda.ViewHolderDatos> {



    ArrayList<Comandas>ListComandas;


    public AdapterComanda(ArrayList<Comandas> listComandas) {
        ListComandas = listComandas;
    }


    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_comanda,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.txtNombre.setText(ListComandas.get(position).getNombre());
        holder.txtCantidad.setText(ListComandas.get(position).getCantidad().toString());
        //holder.txtTotal.setText(ListComandas.get(position).getTotal().toString());
    }

    @Override
    public int getItemCount() {
        return ListComandas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtNombre,txtCantidad,txtTotal;
        Button Borrar;
        public ViewHolderDatos(View itemView) {
            super(itemView);

            txtNombre=(TextView) itemView.findViewById(R.id.txtNombrePlato);
            txtCantidad=(TextView) itemView.findViewById(R.id.txtCantidad2);
            txtTotal=(TextView) itemView.findViewById(R.id.txtTotal);
            //Borrar=(Button) itemView.findViewById(R.id.btnBorrar);


        }
    }
}
