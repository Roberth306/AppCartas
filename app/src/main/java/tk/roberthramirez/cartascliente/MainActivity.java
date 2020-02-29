package tk.roberthramirez.cartascliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tk.roberthramirez.cartascliente.Fragments.Login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login login = new Login();

        getSupportFragmentManager().beginTransaction().replace(R.id.flPantalla, login).commit();
    }
}
