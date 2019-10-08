import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class airlineRemoteImplement extends UnicastRemoteObject implements airlineRemote{
	
	HashMap<String, Integer> flightCostAirIndia = new HashMap<String, Integer>();
	HashMap<String, Integer> flightCostSpiceJet = new HashMap<String, Integer>();
	
	HashMap<String,Integer> userTicket = new HashMap<String,Integer>();
	HashMap<String, String> userFlight = new HashMap<String, String>();
	//TICKET COST HASHMAP TO MAINTAIN FLIGHT COST FOR BOTH CLASSES
	HashMap<String,Integer> ticketPricePerUser = new HashMap<String, Integer>();
	//ArrayList<String> flightClass = new ArrayList<String>();
	
	
	public airlineRemoteImplement()throws RemoteException {
		super();
		flightCostAirIndia.put("Pune-Mumbai", 2500);
		flightCostAirIndia.put("Mumbai-Delhi",4000);
		flightCostSpiceJet.put("Patna-Mumbai",7000);
		flightCostSpiceJet.put("Goa-Pune",4500);
		//flightClass.add("Economy");
		//flightClass.add("Business");
		}
	

	
	public String getAirIndiaPrice()throws RemoteException{
		System.out.println(flightCostAirIndia.toString());
		return flightCostAirIndia.toString(); 
		
	}
	
	public String getSpiceJetPrice()throws RemoteException{
		System.out.println(flightCostSpiceJet.toString());
		return flightCostSpiceJet.toString();
		
	}
	
	public String bookAirIndia(String city, String user, int numberOfTickets)throws RemoteException {
		String str="";
		if(flightCostAirIndia.containsKey(city)) {
			userTicket.put(user,numberOfTickets);
			userFlight.put(user,city);
			ticketPricePerUser.put(user,flightCostAirIndia.get(city));
			str= "Thank you " + user +" for booking "+ numberOfTickets+ " seats with Air India. Flight: "+ city;
		}
		return str;
	}
	
	
	public void bookSpiceJet(String city, String user, int numberOfTickets)throws RemoteException {
		if(flightCostSpiceJet.containsKey(city)) {
			userTicket.put(user,numberOfTickets);
			userFlight.put(user,city);
			ticketPricePerUser.put(user,flightCostSpiceJet.get(city));
			System.out.println("Thank you " + user +" for booking "+ numberOfTickets+ " seats with Spice Jet. Flight: "+ city);
		}
	}
	
	
	 public String bookDetails(String user)throws RemoteException{
		String str2="";
		String str3="";
		 if(userTicket.containsKey(user)&&userFlight.containsKey(user)) {
			str2= user+ " has booked "+userTicket.get(user) + " tickets for: "+ userFlight.get(user);
			str3=" Ticket Price for " +user +" is: "+ ticketPricePerUser.get(user);
			
		 }else {
			 str2= "User not found";
		 }
		 return str2 + str3;
	 }

	 public void upgradeClass(int cl, String user)throws RemoteException {
		 if(cl==1) {
			if(userTicket.containsKey(user)) {
				ticketPricePerUser.put(user, ticketPricePerUser.get(user)+500);
				System.out.println("Successfully upgraded to business class!");
				System.out.println("Updated ticket cost details: ");
				bookDetails(user);
			}
		 }else {
			 System.out.println("By default class booked as Economy");
		 }
	 }
	
	 
}
