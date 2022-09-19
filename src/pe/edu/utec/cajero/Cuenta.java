package pe.edu.utec.cajero;

import java.math.BigDecimal;

public class Cuenta {
    Moneda moneda;
    BigDecimal saldo;
    String numeroCuenta;

    public Cuenta(Moneda moneda, BigDecimal saldo, String numeroCuenta) {
        this.moneda = moneda;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String toString() {
        return "Cuenta: "+numeroCuenta+" - "+(moneda==Moneda.DOLARES?"Dólares":"Soles");
    }
}
