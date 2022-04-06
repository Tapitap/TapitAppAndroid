package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.db.utilidades;
import com.tapitapp.tapitapp.model.Precios;
import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;

public class DetallesActivity extends AppCompatActivity {

    Button btnMas,btnMenos,btnAñadir,btnVer;
    ImageView img;
    TextView txtCantidad,txtName,txtDescripcion;
    Integer valor=1,id=0;
    CheckBox chTapa,chMedia,chRacion;
    Productos producto;
    LinearLayout linear1;
    private ProductosRepository repository = new ProductosRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        btnMas=(Button) findViewById(R.id.btnMas);
        btnMenos=(Button)findViewById(R.id.btnMenos);
        btnVer=(Button) findViewById(R.id.btnComanda);
        btnAñadir=(Button)findViewById(R.id.btnAñadir);

        txtCantidad=(TextView) findViewById(R.id.txtCantidad);
        txtDescripcion=(TextView) findViewById(R.id.txtDescripcion);
        txtName=(TextView)findViewById(R.id.txtName);
        img=(ImageView)findViewById(R.id.imageViewDescricipcion);

        chTapa=(CheckBox)findViewById(R.id.checkBoxTapa);
        chMedia=(CheckBox)findViewById(R.id.checkBoxMedia);
        chRacion=(CheckBox)findViewById(R.id.checkBoxEntera);

        linear1=(LinearLayout)findViewById(R.id.LinearTamaño) ;

        //obtener productos mediante id
        id=getIntent().getIntExtra("id",0);

        //obtener imagenes productos mediante id
        producto=repository.getProductoById(id);
        img.setImageBitmap(repository.getImgById(id));

        txtDescripcion.setText(producto.getDescripcion());
        txtName.setText(producto.getNombre().toString());

        //conexion SQLite
        conexionSQLiteHelper conexionSQLiteHelper = new conexionSQLiteHelper(this,"Tapitapp.db",null,1);
        SQLiteDatabase db = conexionSQLiteHelper.getWritableDatabase();

        validacion();

        //------------------Eventos-------------------

        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ComandaActivity.class);
                startActivity(intent);
            }
        });
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(producto.getTipo().equals("bebida")||producto.getTipo().equals("postre")|| producto.getTipo().equals("combinado")){
                    RegistrarLinea();
                }else if(chTapa.isChecked() || chMedia.isChecked() || chRacion.isChecked()){
                    RegistrarLinea();
                }else{
                    Toast.makeText(getApplicationContext(),"Selecciona un Tamaño de plato", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor++;
                txtCantidad.setText(Integer.toString(valor));
            }
        });
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valor!=0){
                    valor--;
                    txtCantidad.setText(Integer.toString(valor));
                }
            }
        });
        chTapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chMedia.setChecked(false);
                chRacion.setChecked(false);
            }
        });
        chMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chTapa.setChecked(false);
                chRacion.setChecked(false);
            }
        });
        chRacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chMedia.setChecked(false);
                chTapa.setChecked(false);
            }
        });
    }

    private void validacion(){
        if(producto.getTipo().equals("bebida")){
            linear1.setVisibility(LinearLayout.INVISIBLE);
        }else if(producto.getTipo().equals("combinado")){
            linear1.setVisibility(LinearLayout.INVISIBLE);
        }else if(producto.getTipo().equals("postre")){
            linear1.setVisibility(LinearLayout.INVISIBLE);
        }
    }
    private void RegistrarLinea(){
        Double precio=0.0;
        Integer cantidad =  Integer.parseInt(txtCantidad.getText().toString());
        conexionSQLiteHelper conexionSQLiteHelper = new conexionSQLiteHelper(this,"Tapitapp.db",null,1);
        SQLiteDatabase db= conexionSQLiteHelper.getWritableDatabase();



        if(chTapa.isChecked()==true){
            precio= producto.getPrecios().get(0).getCuantia();
        }else if(chMedia.isChecked()==true){
            precio=producto.getPrecios().get(1).getCuantia();
        }else if(chRacion.isChecked()==true){
            precio=producto.getPrecios().get(2).getCuantia();
        }else{
            precio= producto.getPrecios().get(0).getCuantia();
        }

        ContentValues valores = new ContentValues();
        valores.put(utilidades.IDProducto,producto.getId());
        //valores.put(utilidades.IDComanda,1);

        valores.put(utilidades.Precio,precio);
        valores.put(utilidades.Cantidad,txtCantidad.getText().toString());
        valores.put(utilidades.total,precio*cantidad);

        Long elemento=db.insert(utilidades.TABLA_LINEA,utilidades.IDLinea,valores);

        Toast.makeText(getApplicationContext(), "Añadido: "+ producto.getNombre().toString(), Toast.LENGTH_SHORT).show();

    }

}