package tk.roberthramirez.cartascliente.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tk.roberthramirez.cartascliente.CartasAdapter;
import tk.roberthramirez.cartascliente.IO.ApiAdapter;
import tk.roberthramirez.cartascliente.IO.ApiService;
import tk.roberthramirez.cartascliente.Modelos.Carta;
import tk.roberthramirez.cartascliente.R;

public class Game extends Fragment {

    private TextView tvcaracteristica;
    private TextView tvValorPlay;
    private TextView tvValorCPU;
    private Button bJugar;
    private Spinner sCaracteristicas;
    private RecyclerView lista;
    private ArrayList<Carta> cartas;
    private ApiService apiService;
    private Activity context;
    private CartasAdapter cartasAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvcaracteristica = getActivity().findViewById(R.id.tvCaracteristica);
        tvValorPlay = getActivity().findViewById(R.id.tvValorCaracteristicaP);
        tvValorCPU = getActivity().findViewById(R.id.tvValorCaracteristicaCPU);
        bJugar = getActivity().findViewById(R.id.bJugar);
        sCaracteristicas = getActivity().findViewById(R.id.sCaracteristicas);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.array_caracteristica, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCaracteristicas.setAdapter(arrayAdapter);
        apiService = ApiAdapter.getApiService();
        context = getActivity();
        getCartas(savedInstanceState.getString("sesion"));

        lista= getActivity().findViewById(R.id.rvLista);




    }

    private void getCartas(String idSesion) {
        apiService.postPartida(idSesion)
                .enqueue(new Callback<ArrayList<Carta>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Carta>> call, Response<ArrayList<Carta>> response) {
                        if(response.code()==200) {
                            cartas = response.body();
                            cartasAdapter = new CartasAdapter(context, cartas);
                            GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 3);

                            lista.setAdapter(cartasAdapter);
                            lista.setLayoutManager(gridLayout);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Carta>> call, Throwable t) {

                    }
                });
    }
}
