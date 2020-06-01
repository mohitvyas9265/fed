package fed;

import java.util.HashMap;
import java.util.Map;

public class Booking 
{
	int guestId;
	int roomNumber;
	int numberOfGuests;
	int startDay;
	int endDay;
	Booking(int guestId,int roomNumber,int numberOfGuests,int startDay,int endDay)
	{
		this.guestId=guestId;
		this.roomNumber=roomNumber;
		this.numberOfGuests=numberOfGuests;
		this.startDay=startDay;
		this.endDay=endDay;
	}
}
