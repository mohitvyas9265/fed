package fed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingList 
{
	List<Booking> bookingList=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	int guestId,guestRoomNumber,guestRoomCapacity,startMonth,startDay,endMonth,endDay;
	public int addGuestId()
	{
		System.out.println("Please enter guest ID:");
		guestId=sc.nextInt();		
		return guestId;
		
	}
	public int addGuestRoomNumber()
	{		
		System.out.println("Please enter room number:");
		guestRoomNumber=sc.nextInt();		
		return guestRoomNumber;		
	}
	public int addGuestRoomCapacity()
	{		
		System.out.println("Please enter number of guests:");
		guestRoomCapacity=sc.nextInt();		
		return guestRoomCapacity;		
	}
	public int addStartMonth()
	{		
		System.out.println("Please enter check-in month:");
		startMonth=sc.nextInt();		
		return startMonth;	
	}
	public int addStartDay()
	{		
		System.out.println("Please enter check-in day:");
		startDay=sc.nextInt();		
		return startDay;	
	}
	public int addEndMonth()
	{		
		System.out.println("Please enter check-out month:");
		endMonth=sc.nextInt();		
		return endMonth;	
	}
	public int addEndDay()
	{		
		System.out.println("Please enter check-out day:");
		endDay=sc.nextInt();		
		return endDay;	
	}
	public int dateToDayNumber(int month, int day) {
		// Catch invalid input and return early
		if (month < 1 || month > 12 || day < 1 || day > 31) return 0;
		if (month == 1 ) return day;
		if (month == 2 ) return 31 + day;
		if (month == 3 ) return 59 + day;
		if (month == 4 ) return 90 + day;
		if (month == 5 ) return 120 + day;
		if (month == 6 ) return 151 + day;
		if (month == 7 ) return 181 + day;
		if (month == 8 ) return 212 + day;
		if (month == 9 ) return 243 + day;
		if (month == 10) return 273 + day;
		if (month == 11) return 304 + day;
		else
			return 334 + day;
		}
		public int dayNumberToMonth(int dayNumber) {
		// Catch invalid input and return early
		if (dayNumber < 1 || dayNumber > 365) return 0;
		if (dayNumber <= 31 ) return 1; // Jan
		if (dayNumber <= 59 ) return 2; // Feb
		if (dayNumber <= 90 ) return 3; // Mar
		if (dayNumber <= 120) return 4; // Apr
		if (dayNumber <= 151) return 5; // May
		if (dayNumber <= 181) return 6; // Jun
		if (dayNumber <= 212) return 7; // Jul
		if (dayNumber <= 243) return 8; // Aug
		if (dayNumber <= 273) return 9; // Sep
		if (dayNumber <= 304) return 10; // Oct
		if (dayNumber <= 334) return 11; // Nov
		else
			return 12; // Dec
		}
		public int dayNumberToDayOfMonth(int dayNumber)
		{
		// Catch invalid input and return early
		if (dayNumber < 1 || dayNumber > 365) return 0;
		if (dayNumber <= 31 ) return dayNumber; // Jan
		if (dayNumber <= 59 ) return dayNumber - 31; // Feb
		if (dayNumber <= 90 ) return dayNumber - 59; // Mar
		if (dayNumber <= 120) return dayNumber - 90; // Apr
		if (dayNumber <= 151) return dayNumber - 120; // May
		if (dayNumber <= 181) return dayNumber - 151; // Jun
		if (dayNumber <= 212) return dayNumber - 181; // Jul
		if (dayNumber <= 243) return dayNumber - 212; // Aug
		if (dayNumber <= 273) return dayNumber - 243; // Sep
		if (dayNumber <= 304) return dayNumber - 273; // Oct
		if (dayNumber <= 334) return dayNumber - 304; // Nov
		else return dayNumber - 334; // Dec
		}
		public void addBooking(int guestId,int roomNumber,int numberOfGuests,int startDa,int endDa)
		{
			Booking book=new Booking(guestId,roomNumber,numberOfGuests,startDa,endDa);
			bookingList.add(book);
			System.out.println("*** Booking successful! ***");
		}
		
		public Boolean setBooked(int roomNumber,int startDate,int endDate)
		{
			for(int i=0;i<bookingList.size();i++)
				if(bookingList.get(i).roomNumber==roomNumber)
					if((bookingList.get(i).startDay<startDate&&bookingList.get(i).endDay>startDate)||(bookingList.get(i).startDay<endDate&&bookingList.get(i).endDay>endDate))
						return false;
			return true;
		}
		public void viewBooking(int id,char ch)
		{
			if(ch=='G')
			{
				for(int i=0;i<bookingList.size();i++)
				{
					if(bookingList.get(i).guestId==id)
					{
						System.out.println("Booking : "+" Room "+bookingList.get(i).roomNumber+","+bookingList.get(i).numberOfGuests+" guest(s) from "+dayNumberToMonth(bookingList.get(i).startDay)+"/"+dayNumberToDayOfMonth(bookingList.get(i).startDay)+" to "+dayNumberToMonth(bookingList.get(i).endDay)+"/"+dayNumberToDayOfMonth(bookingList.get(i).endDay));
					}
				}
			}
			if(ch=='R')
			{
				for(int i=0;i<bookingList.size();i++)
				{
					if(bookingList.get(i).roomNumber==id)
					{
						System.out.println("Room "+id+" Bookings: "+bookingList.get(i).numberOfGuests+" guest(s) from "+dayNumberToMonth(bookingList.get(i).startDay)+"/"+dayNumberToDayOfMonth(bookingList.get(i).startDay)+" to "+dayNumberToMonth(bookingList.get(i).endDay)+"/"+dayNumberToDayOfMonth(bookingList.get(i).endDay));
					}
				}
				
			}
			
		}
	

}
