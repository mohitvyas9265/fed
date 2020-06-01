package fed;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Display
{
	GuestList gs=new GuestList();
	RoomList  rs=new RoomList();
	BookingList bs=new BookingList();
	public void display()
	{
		char ch='A';
		do
		{
			System.out.println("----------------------------------------");
			System.out.println("----Welcome to FedUni Hotel Bookings----");
			System.out.println("----------------------------------------");
			System.out.println("Main Menu - please select an option:");
			System.out.println("1.) Add guest\r\n" + 
				"2.) Add room\r\n" + 
				"3.) Add booking\r\n" + 
				"4.) View bookings\r\n" + 
				"5.) Quit");
			Scanner sc= new Scanner(System.in);
			int option=sc.nextInt();	
			
			switch (option) 
			{
				case 1:
					do
					{
						gs.addGuest();
						ch=menu();						
					}while(ch=='A');				
					break;					
				case 2:
					ch='A';
					do
					{
						rs.addRoom();
						ch=menu();				
					}while(ch=='A');		
					break;
				case 3:	
					ch='A';
					int guestId;
					int guestRoomNumber,numberOfGuests,startDay,startMonth,endDay,endMonth,capacity;
						do
						{					
							guestId= bs.addGuestId();
							if(gs.checkGuestId(guestId)==false)
							{
								System.out.println("Guest does not exist.");
							}	
						}while(gs.checkGuestId(guestId)==false);
						do
						{
							do
							{					
								guestRoomNumber=  bs.addGuestRoomNumber();
								if(!rs.checkRoom(guestRoomNumber))
								{
									System.out.println("Room does not exist.");
								}			
							}while(!rs.checkRoom(guestRoomNumber));
							do 
							{
								numberOfGuests=bs.addGuestRoomCapacity();
								capacity=rs.checkRoomCapacity(guestRoomNumber, numberOfGuests);
								if(numberOfGuests>capacity)
								{
									System.out.println("Guest count exceeds room capacity of:"+capacity);
								}
							}while(numberOfGuests>capacity);
							do 
							{
								startMonth=bs.addStartMonth();
								if(startMonth>12||startMonth<1)
									System.out.print("Invalid month.");
							}while(startMonth>12||startMonth<0);
							do 
							{
								startDay=bs.addStartDay();
								if(startDay>31||startDay<1)
									System.out.print("Invalid Day.");
							}while(startDay>31||startDay<1);
							do 
							{
								do 
								{
									endMonth=bs.addEndMonth();
									if(endMonth>12||endMonth<1)
										System.out.print("Invalid month.");
								}while(endMonth>12||endMonth<0);
								do 
								{
									endDay=bs.addEndDay();
									if(endDay>31||endDay<1)
										System.out.print("Invalid Day.");					
								}while(endDay>31||endDay<1);
								if(endMonth<startMonth||(endMonth==startMonth&&endDay<startDay))
									System.out.println("Invalid check-out date");				
							}while(endMonth<startMonth||(endMonth==startMonth&&endDay<startDay));
							startDay=bs.dateToDayNumber(startMonth, startDay);
							endDay=bs.dateToDayNumber(endMonth, endDay);
							if(bs.setBooked(guestRoomNumber,startDay,endDay))
							{
								bs.addBooking(guestId, guestRoomNumber, numberOfGuests, startDay, endDay);
							}
							else
							{
								System.out.println("Room is not available during that period.");
							}
						}while(!bs.setBooked(guestRoomNumber,startDay,endDay));	
						ch=menu();				
						break;
			case 4:
				ch='A';
				char ch1;
				do 
				{	
				System.out.println("Would you like to view [G]uest bookings, [R]oom booking, or e[X]it?");
				ch1=sc.next().charAt(0);
				int g;
				if(ch1=='G')
				{
					do
					{					
						System.out.println("Please enter guest ID:");
						g=sc.nextInt();
						if(gs.checkGuestId(g)==false)
						{
							System.out.println("Guest does not exist.");
						}	
					}while(gs.checkGuestId(g)==false);
					bs.viewBooking(g,'G');
					
				}
				if(ch1=='R')
				{
					do
					{					
						System.out.println("Please enter room number:");
						g=sc.nextInt();
						if(rs.checkRoom(g)==false)
						{
							System.out.println("Room does not exist.");
						}	
					}while(rs.checkRoom(g)==false);
					bs.viewBooking(g,'R');
				}
				if(ch1=='X')
				{	System.out.println("Thanks for using FedUni Hotel Bookings!"); 
					break;
				}
			
				}while(ch1!='X');					
					
				break;
			case 5:
				System.out.println("Thanks for using FedUni Hotel Bookings!"); break;		

			default:
				System.out.println("Invalid Input");
				break;
		}
		
		
	}while(ch=='R')	;
	}
	public char menu()
	{
		Scanner sc=new Scanner(System.in);
		char ch;
		do 
		{
			System.out.println("Would you like to [A]dd  or [R]eturn to the previous menu?");
			ch=sc.next().charAt(0);
			System.out.println(ch);
			if(ch!='A'&&ch!='R')
			System.out.println("Invalid Input");
		}while(ch!='A'&&ch!='R');
		return ch;
		
	}
	public static void main(String[] args) {
		Display d = new Display();
		d.display();
	}

}
