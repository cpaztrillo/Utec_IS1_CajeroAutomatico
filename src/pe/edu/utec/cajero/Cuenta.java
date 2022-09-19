package pe.edu.utec.cajero;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cuenta  implements Serializable {
    Moneda moneda;
    BigDecimal saldo;
    String numeroCuenta;
    private static final long serialVersionUID = 1L;

    public Cuenta(Moneda moneda, BigDecimal saldo, String numeroCuenta) {
        this.moneda = moneda;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String toString() {
        return "Cuenta: "+numeroCuenta+" - "+(moneda==Moneda.DOLARES?"Dólares":"Soles");
    }
}
