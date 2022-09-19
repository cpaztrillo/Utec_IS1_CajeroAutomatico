package pe.edu.utec.cajero;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(Moneda.SOLES, new BigDecimal(200), "089-298");
        Cuenta c2 = new Cuenta(Moneda.DOLARES, new BigDecimal(100), "087-673");
        Cliente cl1 = new Cliente("Christian", "Paz", "40859458");
        cl1.creaCuenta(c1);
        cl1.creaCuenta(c2);
        Tarjeta t1 = new Tarjeta(cl1, "98765432", 1234);
        Map<String, Tarjeta> baseDeDatos = new HashMap<>();
        baseDeDatos.put(t1.numero, t1);

        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido a su banco, digite su numero de tarjeta o 0 para terminar");
        boolean fin = false;
        while (!fin) {
            String tarjeta = input.nextLine();
            if("0".equalsIgnoreCase(tarjeta))
                return;

            Tarjeta t = baseDeDatos.get(tarjeta);
            if(t!=null) {
                System.out.println("Gracias "+t.persona.nombres+" confirma tu nro de dni");
                String dni = input.nextLine();
                if(!dni.equalsIgnoreCase(t.persona.dni)) {
                    System.out.println("DNI incorrecto");
                    break;
                }
                System.out.println("Digite su pin:");
                int pin = input.nextInt();
                if(pin!=t.pin){System.out.println("Pin incorrecto");
                    break;
                }
                int i=0;
                for(Cuenta cuenta: t.persona.cuentas) {
                    i++;
                    System.out.println("Para su cuenta: "+ cuenta.toString()+ " digite "+i);
                }
                System.out.println("Seleccione la cuenta para ver el saldo o 0 para salir:");
                int idxcuenta = 0;
                do {
                    idxcuenta = input.nextInt();
                    if(idxcuenta>0 && idxcuenta <= t.persona.cuentas.size()) {
                        Cuenta c = t.persona.cuentas.get(idxcuenta - 1);
                        System.out.println("El saldo de su cuenta es: " + c.saldo + " " + c.moneda);
                    } else {
                        System.out.println("Seleccione una cuenta");
                    }
                } while(idxcuenta!=0);
            }
            fin = true;
        }
        System.out.println("Gracias por usar el sistema.");
    }
}
