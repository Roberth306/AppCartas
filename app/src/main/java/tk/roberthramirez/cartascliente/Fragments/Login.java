package tk.roberthramirez.cartascliente.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.roberthramirez.cartascliente.IO.ApiAdapter;
import tk.roberthramirez.cartascliente.IO.ApiService;
import tk.roberthramirez.cartascliente.Modelos.Jugador;
import tk.roberthramirez.cartascliente.Modelos.Sesion;
import tk.roberthramirez.cartascliente.R;

public class Login extends Fragment {

    private EditText etUsuario;
    private EditText etContrasena;
    private Button enviar;
    private ApiService mService;
    private Sesion sesion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_fragment, container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        etUsuario = getActivity().findViewById(R.id.etUsuario);
        etContrasena = getActivity().findViewById(R.id.etContrasena);
        enviar = getActivity().findViewById(R.id.bAcceder);
        mService= ApiAdapter.getApiService();

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postLogin();
            }
        });
    }

    private void postLogin() {
        Jugador j = new Jugador(etUsuario.getText().toString(), etContrasena.getText().toString());
        mService.postLogin(new Gson().toJson(j).toString())
                .enqueue(new Callback<Sesion>() {
                    @Override
                    public void onResponse(Call<Sesion> call, Response<Sesion> response) {
                        if(response.code()==200){
                            sesion = response.body();
                            Toast.makeText(getContext(), sesion.getIdSesion(), Toast.LENGTH_SHORT).show();
                            Game game = new Game();
                            Bundle args = new Bundle();
                            args.putString("sesion", sesion.getIdSesion());
                            game.setArguments(args);

                            getFragmentManager().beginTransaction().replace(R.id.flPantalla, game).commit();
                        }

                    }

                    @Override
                    public void onFailure(Call<Sesion> call, Throwable t) {

                    }
                });
    }
}
