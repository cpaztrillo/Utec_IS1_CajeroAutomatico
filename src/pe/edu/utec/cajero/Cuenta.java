package pe.edu.utec.cajero;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cuenta  implements Serializable {
    Moneda moneda;
    float saldo;
    String numeroCuenta;
    List<Operacion> operaciones;
    private static final long serialVersionUID = 1L;

    public Cuenta(Moneda moneda, float saldo, String numeroCuenta) {
        this.moneda = moneda;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
        operaciones = new ArrayList<>();
    }

    //public String toString() {
    //    return "Cuenta: "+numeroCuenta+" - "+(moneda==Moneda.DOLARES?"Dólares":"Soles");
    //}

    @Override
    public String toString() {
        return "Cuenta{" +
                "moneda=" + moneda +
                ", saldo=" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", operaciones=" + operaciones +
                '}';
    }

    public boolean retiro(float monto, Moneda moneda) {
        float conversion = 1.0f;
        if(moneda==Moneda.DOLARES && this.moneda==Moneda.SOLES) {
            conversion = 4.0f;
        }
        if(moneda==Moneda.SOLES && this.moneda==Moneda.DOLARES) {
            conversion = 1.0f/4.0f;
        }
        float montoEnMonedaCuenta = monto * conversion;
        if(this.saldo<montoEnMonedaCuenta) {
            return false;
        }
        saldo = saldo - montoEnMonedaCuenta;
        Operacion op = new Operacion(monto, moneda, this);
        return true;
    }
}
