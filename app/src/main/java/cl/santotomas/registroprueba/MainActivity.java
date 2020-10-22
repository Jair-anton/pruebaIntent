package cl.santotomas.registroprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.santotomas.registroprueba.modelo.Empleado;

public class MainActivity extends AppCompatActivity {

    final Empleado e1 = new Empleado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_registrar = (Button)findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               /** Prueba de Sqlite */
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "administrador", null, 1);
                SQLiteDatabase  baseDeDatos = admin.getWritableDatabase();



                EditText txt_nombre = (EditText)findViewById(R.id.name_edit);
                EditText txt_apellido = (EditText)findViewById(R.id.last_name_edit);
                EditText txt_edad = (EditText)findViewById(R.id.age_edit);

                e1.setNombre(txt_nombre.getText().toString());
                e1.setApellidos(txt_apellido.getText().toString());
                e1.setEdad(txt_edad.getText().toString());



               // Toast.makeText(MainActivity.this, e1.getNombre(), Toast.LENGTH_LONG).show();

                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);

                detailIntent.putExtra("el_nombre", e1.getNombre());
                detailIntent.putExtra("el_apellido", e1.getApellidos());
                detailIntent.putExtra("la_edad", e1.getEdad());

                startActivity(detailIntent);
            }
        });

    }
}