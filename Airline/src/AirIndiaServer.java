import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.*;
public class AirIndiaServer {
	
	

	
public static void main(String[] args) {
	
try {
	
	
	
	airlineRemote stub  = new airlineRemoteImplement();
	
	LocateRegistry.createRegistry(1500);
	Naming.rebind("rmi://localhost:1500/abc", stub);
	
}catch(Exception e) {
	e.printStackTrace();
}
}

}