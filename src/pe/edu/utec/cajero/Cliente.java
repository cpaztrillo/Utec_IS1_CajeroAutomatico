package pe.edu.utec.cajero;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nombres;
    String apellidos;
    String dni;
    List<Cuenta> cuentas;

    public Cliente(String nombres, String apellidos, String dni) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        cuentas = new ArrayList<>();
    }

    public void creaCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}
