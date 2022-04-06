package com.tapitapp.tapitapp.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tapitapp.tapitapp.DetallesActivity;
import com.tapitapp.tapitapp.R;
import com.tapitapp.tapitapp.model.Precios;
import com.tapitapp.tapitapp.model.Productos;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<Productos> productos;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapter(List<Productos> productos, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.productos = productos;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_elementos, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(productos.get(position));
    }

    public void setItems(List<Productos> items) {
        productos = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nombre, descripcion, precio;
        Button btnDetalles;
        ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgElemento);
            nombre = itemView.findViewById(R.id.txtNombrePlato);
            //descripcion=itemView.findViewById(R.id.txtDescripcion);
            precio = itemView.findViewById(R.id.txtCantidad2);
            btnDetalles=itemView.findViewById(R.id.btnBorrar);

        }

        void bindData(final Productos item) {
            nombre.setText(item.getNombre());
            if (item.getIco() == null) {
                img.setImageResource(R.drawable.ico_default);
            } else {
                img.setImageBitmap(item.getIco());
            }
            if (item.getTipo().equals("comida")) {
                String precio2 = "";
                for (Precios p : item.getPrecios()) {
                    precio2 += p.getTipo() + ": " + p.getCuantia() + "€ ";
                }
                precio.setText(precio2);
            } else {
                //precio.setVisibility(View.VISIBLE);
                precio.setText("Precio: "+item.getPrecios().get(0).getCuantia().toString() + "€");
                //descripcion.setVisibility(View.INVISIBLE);
            }

            btnDetalles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context.getApplicationContext(), DetallesActivity.class);

                    intent.putExtra("id",item.getId());

                    context.startActivity(intent);


                }
            });
        }
    }
}
