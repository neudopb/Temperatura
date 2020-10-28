package conversorTemperatura;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Neudo Paulino
 */
public interface ITemperatura extends Remote {
    
    public String calcularTemp(String escala, float temp) throws RemoteException;
}
