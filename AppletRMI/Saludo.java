
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Saludo extends Remote
{
	public String saludar() throws RemoteException;
}
