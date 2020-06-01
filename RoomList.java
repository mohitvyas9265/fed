package fed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomList 
{
	List<Room> roomList=new ArrayList<>();
	public void addRoom()
	{
		Scanner sc=new Scanner(System.in);
		int roomNumber;
		int roomCapacity=0;
		System.out.println("Please enter room number:");
		roomNumber=sc.nextInt();
		if(checkRoom(roomNumber))
		{
			System.out.print("Room already exists.");
			addRoom();
		}
		else
		{		
		System.out.println("Please enter room capacity:");
		roomCapacity=sc.nextInt();	
		}
		Room rm=new Room(roomNumber,roomCapacity);
		roomList.add(rm);
	}
	public Boolean checkRoom(int roomNo)
	{
		for(int i=0;i<roomList.size();i++)
		{
			if((roomList.get(i)).roomNumber==roomNo)
				return true;
		}
		return false;
	}
	public int checkRoomCapacity(int roomNo,int roomCapacity)
	{
	
		for(int i=0;i<roomList.size();i++)
		{
			if(roomList.get(i).roomNumber==roomNo)
					return (roomList.get(i).roomCapacity);
		}
		return 0;
		
	}
}
	


