import java.rmi.Remote;
import java.rmi.RemoteException;


public interface airlineRemote extends Remote{
	//public String getFeed(int u) throws RemoteException;
	
	public String getAirIndiaPrice()throws RemoteException;
	
	public String getSpiceJetPrice()throws RemoteException;
	public String bookAirIndia(String city, String user, int numberOfTickets)throws RemoteException;
	public void bookSpiceJet(String city, String user, int numberOfTickets)throws RemoteException; 
	public String bookDetails(String user)throws RemoteException;
	public void upgradeClass(int cl, String user)throws RemoteException;
	 
	//public String selectFlight()throws RemoteException;

}
