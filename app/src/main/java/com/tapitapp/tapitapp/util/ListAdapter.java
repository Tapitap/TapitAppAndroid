package com.tapitapp.tapitapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tapitapp.tapitapp.R;
import com.tapitapp.tapitapp.model.Productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
                          implements View.OnClickListener {
    private List<String> nombres;
    private List<Productos> productos;
    private LayoutInflater inflater;
    private Context context;
    private View.OnClickListener listener;

    public ListAdapter(List<String> nombres, List<Productos> productos, Context context) {
        this.inflater = LayoutInflater.from(context);
        this.nombres = nombres;
        this.productos = productos;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_elementos, null);
        view.setOnClickListener(this);
        return new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(nombres.get(position));
    }

    public void setItems(List<String> items) {
        nombres = items;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nombre, descripcion, precio;

        ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgElemento);
            nombre = itemView.findViewById(R.id.txtTituloPlato);
            descripcion=itemView.findViewById(R.id.txtDescripcion);
            precio = itemView.findViewById(R.id.txtPrecio);
        }

        void bindData(final String item) {
            List<Productos> prod = new ArrayList<>(productos.stream().filter(x -> x.getNombre().equals(item)).collect(Collectors.toList()));
            nombre.setText(item);
            if (prod.get(0).getTipo().equals("comida")) {
                String descrip = "";
                for (Productos p : prod) {
                    descrip += p.getTipoPlato() + ": " + p.getPrecio() + "€ ";
                }
                descripcion.setText(descrip);
            } else {
                precio.setVisibility(View.VISIBLE);
                precio.setText(prod.get(0).getPrecio().toString() + "€");
                descripcion.setVisibility(View.INVISIBLE);
            }
        }
    }
}
