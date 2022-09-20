package pe.edu.utec.cajero;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<String, Tarjeta> initDB() {
        Map<String, Tarjeta> baseDeDatos = cargar();
        if(baseDeDatos!=null)
            return baseDeDatos;
        Cuenta c1 = new Cuenta(Moneda.SOLES, 200.0f, "089-298");
        Cuenta c2 = new Cuenta(Moneda.DOLARES, 100.0f, "087-673");
        Cliente cl1 = new Cliente("Christian", "Paz", "40859458");
        cl1.creaCuenta(c1);
        cl1.creaCuenta(c2);
        Tarjeta t1 = new Tarjeta(cl1, "98765432", 1234);
        baseDeDatos = new HashMap<>();
        baseDeDatos.put(t1.numero, t1);
        return baseDeDatos;
    }

    public static void main(String[] args) {
        Map<String, Tarjeta> baseDeDatos = initDB();
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
                System.out.println("Seleccione la cuenta o digite 0 para salir:");
                int idxcuenta;
                do {
                    idxcuenta = input.nextInt();
                    if(idxcuenta>0 && idxcuenta <= t.persona.cuentas.size()) {
                        Cuenta c = t.persona.cuentas.get(idxcuenta - 1);
                        System.out.println("Cuenta: " + c.toString());
                        System.out.println("Digite el monto en soles a retirar");
                        float monto = input.nextFloat();
                        boolean resultado = c.retiro(monto, Moneda.SOLES);
                        if(resultado == false) {
                            System.out.println("Saldo insuficiente");
                        }
                        System.out.println("Cuenta: " + c.toString());
                    } else {
                        System.out.println("Seleccione una cuenta");
                    }
                } while(idxcuenta!=0);
            }
            fin = true;
        }
        System.out.println("Gracias por usar el sistema.");
        grabar(baseDeDatos);

    }

    private static Map<String, Tarjeta> cargar() {
        try {
            FileInputStream fileInputStream
                    = new FileInputStream("yourfile.txt");
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);
            Map<String, Tarjeta> bd = (Map<String, Tarjeta>) objectInputStream.readObject();
            objectInputStream.close();
            return bd;
        } catch (Exception e) {
            return null;
        }
    }
    private static void grabar(Map<String, Tarjeta> db) {
        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream("yourfile.txt");
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(db);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
