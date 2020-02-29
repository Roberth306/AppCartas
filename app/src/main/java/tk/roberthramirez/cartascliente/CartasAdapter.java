package tk.roberthramirez.cartascliente;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tk.roberthramirez.cartascliente.Modelos.Carta;

public class CartasAdapter extends RecyclerView.Adapter<CartasAdapter.CartasViewHolder> {

    private ArrayList<Carta> cartas;
    private Context context;
    //private ICartaListener listerner;

    public CartasAdapter(Context context, ArrayList<Carta> cartas /*, ICartaListener listener*/) {
        this.context = context;
        this.cartas = cartas;
    }

    @NonNull
    @Override
    public CartasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        CartasViewHolder viewHolder = new CartasViewHolder(itemView, context/*, listener*/);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartasViewHolder holder, int position) {
        Carta carta = cartas.get(position);
        holder.bindCarta(carta);
    }

    @Override
    public int getItemCount() {
        return cartas.size();
    }

    public static class CartasViewHolder extends RecyclerView.ViewHolder { //Todo clickListener
        private ImageView ivCarta;
        private Context context;


        public CartasViewHolder(@NonNull View itemView, Context context /* todo listener*/) {
            super(itemView);
            this.context = context;

            ivCarta = (ImageView) itemView.findViewById(R.id.ivCarta);
        }

        public void bindCarta(Carta carta){

            try{
                String flagName = "c_"+carta.getIdCarta();

                int resID = context.getResources().getIdentifier(flagName, "drawable", context.getPackageName());

                if(resID!=0){
                    ivCarta.setImageResource(resID);
                }else {
                    flagName = "c_1";
                    resID = context.getResources().getIdentifier(flagName, "drawable", context.getPackageName());
                }
            }catch (Exception e){

            }


        }
    }
}
