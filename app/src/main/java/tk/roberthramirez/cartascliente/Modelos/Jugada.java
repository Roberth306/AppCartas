package tk.roberthramirez.cartascliente.Modelos;

public class Jugada {
    private String idSesion;
    private int idGame;
    private int idCarta;
    private String caracteristica;

    public Jugada(String idSesion, int idGame, int idCarta, String caracteristica) {
        this.idSesion = idSesion;
        this.idGame = idGame;
        this.idCarta = idCarta;
        this.caracteristica = caracteristica;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
}
