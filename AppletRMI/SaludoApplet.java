
import java.awt.Graphics;
import java.rmi.Naming;
import java.applet.*;

public class SaludoApplet extends Applet
{
	String message = "blank";
	
	Saludo saludo = null;
	
	@Override
	public void init()
	{
		try
		{
			saludo = (Saludo) Naming.lookup( "rmi://" + getCodeBase().getHost() + "/ServidorSaludo" );
			message = saludo.saludar();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint( Graphics g )
	{
		g.drawString( message , 25 , 50 );
	}
}