import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SpiceJetServer {

	public static void main(String[] args) {
		
		try {
			
			
			
			airlineRemote stub1  = new airlineRemoteImplement();
			
			LocateRegistry.createRegistry(1300);
			Naming.rebind("rmi://localhost:1300/abcd", stub1);
			
				}catch(Exception e) {
			e.printStackTrace();
		}
	}
 

}


