package cliente;

import intermediaria.ITemperatura;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neudo Paulino
 */
public class Cliente {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.print("Escala(C/F/K): ");
        String escala = tec.next();
        System.out.print("Temperatura: ");
        float temp = tec.nextFloat();
        
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1102);
            ITemperatura obj = (ITemperatura)registry.lookup("TemperaturaService");
            System.out.println(obj.calcularTemp(escala, temp));
        } catch (Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
