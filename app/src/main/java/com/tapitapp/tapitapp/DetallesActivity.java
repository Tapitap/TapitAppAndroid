package com.tapitapp.tapitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tapitapp.tapitapp.db.conexionSQLiteHelper;
import com.tapitapp.tapitapp.db.utilidades;
import com.tapitapp.tapitapp.model.Productos;
import com.tapitapp.tapitapp.repository.ProductosRepository;

public class DetallesActivity extends AppCompatActivity {

    Button btnMas,btnMenos,btnAñadir,btnVer;
    ImageView img;
    TextView txtCantidad,txtName,txtDescripcion;
    Integer valor=1,id=0;
    CheckBox chTapa,chMedia,chRacion;
    Productos producto;
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


        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarLinea();
                //validar();
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

    }
    private void RegistrarLinea(){
        conexionSQLiteHelper conexionSQLiteHelper = new conexionSQLiteHelper(this,"Tapitapp.db",null,1);
        SQLiteDatabase db= conexionSQLiteHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(utilidades.IDProducto,producto.getId());
        valores.put(utilidades.IDComanda,1);
        valores.put(utilidades.IDPrecio,7.5);
        valores.put(utilidades.Cantidad,txtCantidad.getText().toString());


        Long elemento=db.insert(utilidades.TABLA_LINEA,utilidades.IDLinea,valores);
        Toast.makeText(getApplicationContext(), "Añadido el plato ", Toast.LENGTH_SHORT).show();
    }
    private void validar(){
        String cad="selecccionado: \n";
        if(chTapa.isChecked()==true){
            cad+="Tapa";
        }else if(chMedia.isChecked()==true){
            cad+="Media";
        }else if(chRacion.isChecked()==true){
            cad+="Racion";
        }

        Toast.makeText(getApplicationContext(), cad, Toast.LENGTH_SHORT).show();
    }
}