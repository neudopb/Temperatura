package servidor;

import intermediaria.ITemperatura;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Neudo Paulino
 */
public class Temperatura extends UnicastRemoteObject implements ITemperatura {
    
    public Temperatura() throws RemoteException {
        super();
    }

    @Override
    public String calcularTemp(String escala, float temp) throws RemoteException {
        float c, f, k;
        
        switch(escala.toUpperCase()) {
            case "C":
                c = temp;
                f = c * 1.8f + 32;
                k = c + 273.15f;
                break;
            case "F":
                f = temp;
                c = (f - 32) / 1.8f;
                k = c + 273.15f;
                break;
            case "K":
                k = temp;
                c = k - 273.15f;
                f = c * 1.8f + 32;
                break;
            default:
                c = 0;
                f = 0;
                k = 0;
        }
        
        return "\n\tTEMPERATURAS" +
                "\nCelsius: " + c +
                "\nFarenheit: " + f +
                "\nKelvin: " + k;
    }
    
}
