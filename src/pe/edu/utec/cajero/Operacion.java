package pe.edu.utec.cajero;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Operacion implements Serializable {
    LocalDateTime fechaOperacion;
    float monto;
    Moneda moneda;
    Cuenta cuenta;

    public Operacion(float monto, Moneda moneda, Cuenta cuenta) {
        this.monto = monto;
        this.moneda = moneda;
        this.cuenta = cuenta;
        fechaOperacion = LocalDateTime.now();
        cuenta.operaciones.add(this);
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "fechaOperacion=" + fechaOperacion +
                ", monto=" + monto +
                ", moneda=" + moneda +
                '}';
    }
}
