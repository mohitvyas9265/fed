package fed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuestList 
{
	List<Guest> guestList=new ArrayList<>();
	int guestPresent;
	public int getSize()
	{
		return guestList.size();
	}
	public void addGuest()
	{
		String name;
		int guestId;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter guest name:");
		name=sc.nextLine();
		guestPresent++;
		guestId=guestPresent;
		Guest g=new Guest(name,guestId);
		System.out.println("Guest "+name+" has been created with guest ID: "+guestId);
		guestList.add(g);		
	}
	public Boolean checkGuestId(int guestI)
	{
		for(int i=0;i<guestList.size();i++)
		{
			if(guestList.get(i).guestId==guestI)
				return true;
		}
		return false;
	}
}
