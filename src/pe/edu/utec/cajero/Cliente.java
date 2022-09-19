package pe.edu.utec.cajero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    String nombres;
    String apellidos;
    String dni;
    List<Cuenta> cuentas;
    private static final long serialVersionUID = 1L;

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
