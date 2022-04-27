package com.tapitapp.tapitapp.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.tapitapp.tapitapp.R;
import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.model.LineaCuenta;

import java.util.ArrayList;

public class AdapterCuenta extends RecyclerView.Adapter<AdapterCuenta.ViewHoldersCuentas> {
    ArrayList<LineaCuenta> ListCuentas;
    Integer id;
    conexionSQLiteHelper conn;

    public AdapterCuenta(ArrayList<LineaCuenta> listLineaCuentas) {
        ListCuentas=listLineaCuentas;
    }


    @Override
    public AdapterCuenta.ViewHoldersCuentas onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_cuenta,null,false);

        return new ViewHoldersCuentas(view);
    }

    @Override
    public void onBindViewHolder( AdapterCuenta.ViewHoldersCuentas holder, int position) {
        holder.bindata(ListCuentas.get(position));
    }

    @Override
    public int getItemCount() {
        return ListCuentas.size();
    }

    public class ViewHoldersCuentas extends RecyclerView.ViewHolder {

        TextView txtTotalCuenta,txtTotal,txtNombre,txtCantidad;
        public ViewHoldersCuentas( View itemView) {
            super(itemView);
            conn=new conexionSQLiteHelper(itemView.getContext(), "Tapitapp.db",null,2);

            txtTotal=(TextView)itemView.findViewById(R.id.txtTotal2);
            txtNombre=(TextView)itemView.findViewById(R.id.txtNombrePlato2);
            txtCantidad=(TextView) itemView.findViewById(R.id.txtCantidad3);
        }

        public void bindata(LineaCuenta lineaCuenta) {


            txtNombre.setText(lineaCuenta.getNombreLinea());
            txtCantidad.setText(lineaCuenta.getCantidadLinea().toString());
            txtTotal.setText(lineaCuenta.getTotalCuenta().toString());

        }
    }
}
