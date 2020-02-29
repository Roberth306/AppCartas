package tk.roberthramirez.cartascliente.IO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import tk.roberthramirez.cartascliente.Modelos.Carta;
import tk.roberthramirez.cartascliente.Modelos.Sesion;

public interface ApiService {
   @POST("login")
   Call<Sesion> postLogin(String jSONJugador);

   @POST("partida")
    Call<ArrayList<Carta>> postPartida(String jSONSesion );

   @PUT("cancelarP")
    Call<String> putCancelarP(String jSONIdGame);

   @PUT("jugarP")
    Call<Boolean> putJugarP(String jSONJugada);

}
