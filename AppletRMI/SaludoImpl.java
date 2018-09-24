
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SaludoImpl extends UnicastRemoteObject implements Saludo
{
	public SaludoImpl() throws RemoteException
	{
		super();
	}
	
	@Override
	public String saludar()
	{
		return "Hello World!";
	}
	
	public static void main(String args[])
	{
		/*
		if( System.getSecurityManager() == null )
		{
			System.setSecurityManager( new RMISecurityManager() );
		}
		*/
		
		try
		{
			LocateRegistry.createRegistry(1099);
			SaludoImpl saludar = new SaludoImpl();
			//Enlaza este objeto instancia
			//bajo el nombre "ServidorSaludo"
			Naming.rebind( "ServidorSaludo" , saludar );
			System.out.println( "SaludoServer bound in registry" );
		}
		catch( Exception e )
		{
			System.out.println( "SaludoImpl err: " + e.getMessage() );
			//e.printStackTrace();
		}
	}
}