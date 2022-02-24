package com.tapitapp.tapitapp.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tapitapp.tapitapp.R;
import com.tapitapp.tapitapp.model.Productos;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Productos>productos;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapter(List<Productos> productos, Context context) {
        this.inflater=LayoutInflater.from(context);
        this.productos = productos;
        this.context = context;
    }
    @Override
    public int getItemCount(){return productos.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view =inflater.inflate(R.layout.lista_elementos,null);
        return  new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(productos.get(position));
    }

    public void setItems(List<Productos>items){
        productos=items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView nombre,descripcion,tipo;

        ViewHolder(View itemView){
            super(itemView);
           img=itemView.findViewById(R.id.imgElemento);
           nombre=itemView.findViewById(R.id.txtTituloPlato);
           descripcion=itemView.findViewById(R.id.txtDescripcion);
           tipo=itemView.findViewById(R.id.txtTipoPlato);
        }

        void bindData(final Productos item){
            nombre.setText(item.getNombre());
            descripcion.setText(item.getDescripcion());
            tipo.setText(item.getTipoPlato());
        }
    }
}
