package servidor;

import intermediaria.ITemperatura;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neudo Paulino
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1102);
            ITemperatura obj = new Temperatura();
            registry.rebind("TemperaturaService", obj);
            System.out.println("Servidor rodando");
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
