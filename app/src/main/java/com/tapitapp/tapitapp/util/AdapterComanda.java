package com.tapitapp.tapitapp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.tapitapp.tapitapp.ComandaActivity;
import com.tapitapp.tapitapp.R;
import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.db.utilidades;
import com.tapitapp.tapitapp.model.Comandas;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterComanda extends RecyclerView.Adapter<AdapterComanda.ViewHolderDatos> {



    ArrayList<Comandas>ListComandas;
    Integer id;
    Context Context;
    conexionSQLiteHelper conn = new conexionSQLiteHelper(Context,"Tapitapp.db",null,utilidades.VERSION);

    public AdapterComanda(ArrayList<Comandas> listComandas, Context context) {
        ListComandas = listComandas;
        Context = context;
    }


    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_comanda,null,false);
        return new ViewHolderDatos(view);
    }
    public void updateRecyclerViewAdapter(ArrayList<Comandas>comandas) {
        this.ListComandas = comandas;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.bindata(ListComandas.get(position));


    }

    @Override
    public int getItemCount() {
        return ListComandas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView txtNombre,txtCantidad,txtTotal;
        ImageButton Borrar;
        ListView lw;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            conn=new conexionSQLiteHelper(itemView.getContext(), "Tapitapp.db",null,1);
            txtNombre=(TextView) itemView.findViewById(R.id.txtNombrePlato);
            txtCantidad=(TextView) itemView.findViewById(R.id.txtCantidad2);
            txtTotal=(TextView) itemView.findViewById(R.id.txtTotal);
            Borrar=(ImageButton) itemView.findViewById(R.id.ButtonDelete);

        }


        public void bindata(Comandas comandas) {
            txtNombre.setText(comandas.getNombre());
            txtCantidad.setText("cantidad: " + comandas.getCantidad().toString());
            txtTotal.setText("Precio: "+ comandas.getTotal().toString());
            Borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase db = conn.getWritableDatabase();


                    db.execSQL("DELETE FROM linea WHERE id="+ comandas.getId_comanda().toString());

                    Toast.makeText(view.getContext(), "borrado", Toast.LENGTH_SHORT).show();
                    ListComandas.remove(comandas);
                    updateRecyclerViewAdapter(ListComandas);

                }


            });


        }

    }

}
