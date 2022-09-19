package pe.edu.utec.cajero;

public class Tarjeta {
    Cliente persona;
    String numero;
    int pin;

    public Tarjeta(Cliente persona, String numero, int pin) {
        this.persona = persona;
        this.numero = numero;
        this.pin = pin;
    }
}
