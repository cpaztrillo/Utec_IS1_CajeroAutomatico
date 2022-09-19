package pe.edu.utec.cajero;

import java.io.Serializable;

public class Tarjeta  implements Serializable {
    Cliente persona;
    String numero;
    int pin;
    private static final long serialVersionUID = 1L;

    public Tarjeta(Cliente persona, String numero, int pin) {
        this.persona = persona;
        this.numero = numero;
        this.pin = pin;
    }
}
