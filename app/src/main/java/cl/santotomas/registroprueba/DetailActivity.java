package cl.santotomas.registroprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("el_nombre");
        String apellido = datos.getString("el_apellido");
        String edad = datos.getString("la_edad");

        TextView resultado = (TextView) findViewById(R.id.et_resultado);
        resultado.setText("El nombre del empleado es: "+nombre+" "+apellido+" tiene la edad de :"+edad);
    }
}