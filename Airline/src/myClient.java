
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class myClient extends Frame{
	
	
	myClient(){
//		Frame fr = new Frame();
//		Button b = new Button("Submit");
//		
//		fr.setTitle("Airline Reservation");
//		fr.setSize(500,300);
//		Label l = new Label("Select Airline: 1)Air India 2)Spice Jet");
//		Label l1 = new Label("Enter Choice: ");
//		
//		b.setBounds(50, 50, 50, 50);
//		fr.setLayout(new FlowLayout());
//		Checkbox c = new Checkbox("Air India");
//		Checkbox c1 = new Checkbox("Spice Jet");
//		fr.add(l);
//		fr.add(l1);
//		fr.add(c);
//		fr.add(c1);
//		fr.add(b);
//		fr.setVisible(true);
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		Frame fr = new Frame("Airline Reservation");
		Button b = new Button("Submit");
		
		fr.setTitle("Airline Reservation");
		fr.setSize(1000,1000);
		
		Label l = new Label("Select Airline: 1)Air India 2)Spice Jet");
		Label l1 = new Label("Enter Choice: ");
		
		b.setBounds(50, 50, 50, 50);
		fr.setLayout(new GridLayout(5,1));
		TextField t = new TextField(10);
		Label l2 = new Label();
		Label userL = new Label("Enter username: ");
		TextField userT = new TextField();
		Label city = new Label("Enter City-Destination: ");
		TextField cityT = new TextField();
		Label noOfTicks = new Label("Enter number of tickets to book: ");
		TextField noOfTicksT = new TextField();
		Label finaaal = new Label();
		Label finaaall = new Label();
		Button finalSubmit = new Button("Submit");
		
		fr.add(l);
		fr.add(l1);
		fr.add(t);
		
		fr.add(b);
		fr.add(l2);
		fr.add(userL);
		fr.add(userT);
		fr.add(city);
		fr.add(cityT);
		fr.add(noOfTicks);
		fr.add(noOfTicksT);
		fr.add(finalSubmit);
		fr.add(finaaal);
		fr.add(finaaall);
		
		
		fr.setVisible(true);
		 int c;
		int i;
		
		myClient cli = new myClient();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3= new Scanner(System.in);
		Scanner sc4= new Scanner(System.in);
		try {
			airlineRemote stub =(airlineRemote)Naming.lookup("rmi://localhost:1500/abc");
			airlineRemote stub1 =(airlineRemote)Naming.lookup("rmi://localhost:1300/abcd");
			int STOP;
			
			
//			System.out.println("Select Airline: 1)Air India 2)Spice Jet");
//			System.out.println("Enter Choice: ");
			
			b.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
				  
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
				 String str = t.getText().toString();
					System.out.println(str);
					
					if(str.equals("Air India")) {
						
						
						try {
							//System.out.println(stub.getAirIndiaPrice());
							l2.setText(stub.getAirIndiaPrice());
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						}else if (str.equals("Spice Jet")) {
							try {
								//System.out.println(stub1.getSpiceJetPrice());
								l2.setText(stub.getAirIndiaPrice());
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else {
							System.out.println("WHY");
						}	
				}
			});
			
			
			Label l3 = new Label("Want to book any of these flights? 1)yes 2)no");
			fr.add(l3);
			
			TextField t1 = new TextField();
			fr.add(t1);
			Button b1 = new Button("Submit");
			fr.add(b1);
			b1.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					String str2 =t1.getText().toString();
					if(str2.equals("yes")) {
//						String user="";
//						String city_destination="";
//						String noOfTickss="";
						
						
						finalSubmit.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {
								 
								
							}
							
							@Override
							public void mouseExited(MouseEvent e) {
								 
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								 
								
							}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								
								String user=userT.getText().toString();
								String city_destination=cityT.getText().toString();
								String ticketQ=noOfTicksT.getText().toString();
								int ticketQuantity = Integer.parseInt(ticketQ);
								
								try {
									
									finaaal.setText(stub.bookAirIndia(city_destination, user, ticketQuantity));
									
									//stub1.bookSpiceJet(city_destination, user, ticketQuantity);	
									
									
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									finaaall.setText( stub.bookDetails(user));
									//stub1.bookDetails(user);
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
						//System.out.println("Enter City-Destination: ");
						//city_destination= sc2.nextLine();
						//System.out.println("Enter username: ");
						//user=sc1.nextLine();
						//System.out.println("Enter number of tickets to book: ");
						//int ticketQuantity = sc3.nextInt();		
					
				
					}
				}
			});
			
			
			
			
		
			
		//	i=sc.nextInt();
			
			
//			if(i==1) {
//			
//				
//			System.out.println(stub.getAirIndiaPrice());
//
//			}else if (i==2) {
//				System.out.println(stub1.getSpiceJetPrice());
//			}else {
//				System.out.println("WHY");
//			}
			
			
//			System.out.println("Want to book any of these flights? 1)yes 2)no");
//			int j=sc.nextInt();
//			if(j==1) {
//				String user="";
//				String city_destination="";
//				System.out.println("Enter City-Destination: ");
//				city_destination= sc2.nextLine();
//				System.out.println("Enter username: ");
//				user=sc1.nextLine();
//				System.out.println("Enter number of tickets to book: ");
//				int ticketQuantity = sc3.nextInt();
//				
//				if(i==1) {
//				stub.bookAirIndia(city_destination, user, ticketQuantity);
//				stub.bookDetails(user);
//				System.out.println("Would you like to upgrade to Business Class? 1)yes 2)Stay Economy");
//				int cl= sc.nextInt();
//				stub.upgradeClass(cl, user);
//				}
//				else if(i==2) {
//				stub1.bookSpiceJet(city_destination, user, ticketQuantity);	
//				stub1.bookDetails(user);
//				System.out.println("Would you like to upgrade to Business Class? 1)yes 2)Stay Economy");
//				int cl= sc.nextInt();
//				
//				stub1.upgradeClass(cl, user);
//				
//				}
//			}else if(j==2){
//				System.out.println("Exit");
//			}
//			
			
			
//			System.out.println("wanna stop??? press 1");
//			STOP= sc2.nextInt();
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
}
