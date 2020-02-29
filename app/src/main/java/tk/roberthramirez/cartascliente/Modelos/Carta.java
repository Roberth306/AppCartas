package tk.roberthramirez.cartascliente.Modelos;

public class Carta {

    private Integer idCarta;
    private String marca;
    private String modelo;
    private int motor;
    private int potencia;
    private int velocidad;
    private int cilindros;
    private int revoluciones;
    private int consumo;

    public Carta() {
    }

    public Carta(String marca, String modelo, int motor, int potencia, int velocidad, int cilindros, int revoluciones,
                  int consumo) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.potencia = potencia;
        this.velocidad = velocidad;
        this.cilindros = cilindros;
        this.revoluciones = revoluciones;
        this.consumo = consumo;
    }

    public Integer getIdCarta() {
        return this.idCarta;
    }

    public void setIdCarta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMotor() {
        return this.motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getCilindros() {
        return this.cilindros;
    }

    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    public int getRevoluciones() {
        return this.revoluciones;
    }

    public void setRevoluciones(int revoluciones) {
        this.revoluciones = revoluciones;
    }

    public int getConsumo() {
        return this.consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
}
