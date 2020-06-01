package fed;
//public class Guest 
//{
//	static int guestPresent=1;
//	String name;
//	Scanner sc= new Scanner(System.in);
//	vector<>
//	public String getName()
//	{			
//			System.out.println("Please enter guest name:");
//			name=sc.nextLine();
//			return name;			 
//	}
//	public int getId()
//	{
//		System.out.println("Guest "+name+" has been created with guest ID: "+guestPresent);
//		return guestPresent++;
//	}
//}
public class Guest
{
	String name;
	int guestId;
	Guest(String name,int guestId)
	{
		this.name=name;
		this.guestId=guestId;
	}
}

