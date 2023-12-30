import java.util.Scanner;

public class Hotel_Management_System {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Hotel h=new Hotel();
    Rooms room1=new Rooms(1,"Laxuary Hotel Room",10000.0,3);
    Rooms room2=new Rooms(2,"Garden View Hotel Room",7000.0,3);
    Rooms room3=new Rooms(3,"Ocean View Hotel Room",6000.0,0);
    Rooms room4=new Rooms(4,"Mountain View Hotel Room",4000.0,4);
    Rooms room5=new Rooms(5,"Normal Hotel Room",3000.0,6);
    h.addRoomType(room1);
    h.addRoomType(room2);
    h.addRoomType(room3);
    h.addRoomType(room4);
    h.addRoomType(room5);
    while(true)
    {
        System.out.println("\n\n1: Add Room Types");
        System.out.println("2: Remove Room Types");
        System.out.println("3: Increase/Decrease No. of Available Rooms in a RoomType");
        System.out.println("4: Book Rooms");
        System.out.println("5: Cancel Booking of Rooms");
        System.out.println("6: See All Bookings");
        System.out.println("7: Check-In Customers");
        System.out.println("8: Check-Out Customers");
        System.out.println("9: Display All Customers In Hotel");
        System.out.println("10: See Checkout History.");
        System.out.println("11: Exit");
        System.out.print("Enter: ");
        int choice =sc.nextInt();
        switch (choice)
        {
            case 1:
            {
                int Id= 0;
                while (true) {
                    System.out.print("Enter Room Type Id : ");
                    Id = sc.nextInt();
                    if(Id<0){
                        System.out.println("Invalid Id");
                    }else
                    {
                        break;
                    }
                }
                if(!h.checkRoomIdExist(Id))
                {
                    System.out.print("Enter Room Type : ");
                    String Type=sc.next();
                    double price = 0;
                    while (true) {
                        System.out.print("Enter Room Price : ");
                        sc.nextLine();
                        price = sc.nextDouble();
                        if(price<0){
                            System.out.println("Invalid Value");
                        }else
                        {
                            break;
                        }
                    }
                    int NoofRoom= 0;
                    while (true) {
                        System.out.print("Enter Number of Rooms of That Type");
                        NoofRoom = sc.nextInt();
                        if(NoofRoom<0){
                            System.out.println("Invalid Value");
                        }else
                        {
                            break;
                        }
                    }
                    Rooms obj=new Rooms(Id,Type,price,NoofRoom);
                    h.addRoomType(obj);
                }
                else
                {
                    System.out.print("A Room Type Already Exist of With This Room Id");
                }
                break;
            }
            case 2:
            {
                int Id= 0;
                while (true) {
                    System.out.print("Enter Room Id to Remove Room Type: ");
                    Id = sc.nextInt();
                    if(Id<0){
                        System.out.println("Invalid Id");
                    }else
                    {
                        break;
                    }
                }
                h.removeRoomType(Id);
                break;
            }
            case 3:
            {
                System.out.println("1: Increase Available Rooms");
                System.out.println("2: Decrese Available Rooms");
                System.out.print("Enter: ");
                int choice1=sc.nextInt();
                switch (choice1)
                {
                    case 1:
                    {
                        int id= 0;
                        while (true) {
                            System.out.println("Enter Room id: ");
                            id = sc.nextInt();
                            if(id<0){
                                System.out.println("Invalid Id");
                            }else
                            {
                                break;
                            }
                        }
                        if(!h.checkRoomIdExist(id))
                        {
                            System.out.println("Sorry No Room Type of this Room id");
                            break;
                        }
                        else
                        {
                            int i = 0;
                            while (true) {
                                System.out.print("How Many Rooms you Want to Increase : ");
                                i = sc.nextInt();
                                if(i<0){
                                    System.out.println("Invalid Value");
                                }else
                                {
                                    break;
                                }
                            }
                            h.changeInNoOfRooms(id,i,0);
                        }
                        break;
                    }case 2:
                    {
                        int id1= 0;
                        while (true) {
                            System.out.println("Enter Room id: ");
                            id1 = sc.nextInt();
                            if(id1<0){
                                System.out.println("Invalid Id");
                            }else
                            {
                                break;
                            }
                        }
                        if(!h.checkRoomIdExist(id1))
                        {
                            System.out.println("Sorry No Room Type of this Room id");
                            break;
                        }
                        else
                        {
                            int i = 0;
                            while (true) {
                                System.out.print("How Many Rooms you Want to decrease : ");
                                i = sc.nextInt();
                                if(i<0){
                                    System.out.println("Invalid Value");
                                }else
                                {
                                    break;
                                }
                            }
                            h.changeInNoOfRooms(id1,i,1);
                        }
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid Choice.");
                        break;
                    }
                }
                break;
            }
            case 4:
            {
                h.displayRoomTypes();
                int Id= 0;
                while (true) {
                    System.out.print("\n\nEnter Room Id to Book Room: ");
                    Id = sc.nextInt();
                    if(Id<0){
                        System.out.println("Invalid Id");
                    }else
                    {
                        break;
                    }
                }
                if(!h.checkRoomIdExist(Id))
                {
                    System.out.println("Sorry No Room Type of this Room id");
                    break;
                }
                else
                {
                    if(h.isRoomAvailable(Id))
                    {

                        System.out.print("Enter Guest Name : ");
                        String Name=sc.next();
                        long PhoneNumber= 0;
                        while (true) {
                            System.out.print("Enter Guest Phone Number (Starts with Digit 9/8/7/6 with having 10 Digits): ");
                            PhoneNumber = sc.nextLong();
                            if(PhoneNumber<0){
                                System.out.println("Invalid Phone Number");
                            }else
                            {
                                break;
                            }
                        }
                        if( h.checkPhoneExist(PhoneNumber))
                        {
                            System.out.println("There is Already a Booking on This Phone Number");
                            break;
                        }
                        int BookNoOfRoom;
                        while(true)
                        {
                            while (true) {
                                System.out.print("How Many Number of Rooms You Want to Book ");
                                BookNoOfRoom=sc.nextInt();
                                if(BookNoOfRoom<0){
                                    System.out.println("Invalid Value");
                                }else
                                {
                                    break;
                                }
                            }
                            int a=h.getNoOfRooms(Id);
                            if(BookNoOfRoom>a)
                            {
                                System.out.println("Sorry only "+a+" Rooms Are Available so "+BookNoOfRoom+" Rooms Can't be Booked");
                            }
                            else{
                                break;
                            }
                        }
                        System.out.print("Enter Date to Book Room (DD/MM/YYYY):");
                        String BookedDate=sc.next();
                        int days= 0;
                        while (true) {
                            System.out.print("For How Many Days You want to Book the Room: ");
                            days = sc.nextInt();
                            if(days<0){
                                System.out.println("Invalid Value");
                            }else
                            {
                                break;
                            }
                        }
                        boolean b=h.changeInNoOfRooms(Id,BookNoOfRoom,1);
                        if(b)
                        {
                            double total=h.countTotal(Id,BookNoOfRoom,days);
                            GuestDetails obj=new GuestDetails(Id,Name,PhoneNumber,BookNoOfRoom,BookedDate,total,days);
                            boolean b1=h.bookRooms(obj);
                            if(!b1)
                            {
                                System.out.println("Booking Failed");
                            }
                        }
                    }
                    else{
                        System.out.println("Rooms are not Available");
                    }
                }
                break;
            }
            case 5:
            {
                long PhoneNumber;
                while (true) {
                    System.out.print("Enter Guest Phone Number to Cancel Booking: ");
                    PhoneNumber=sc.nextLong();
                    if(PhoneNumber<0){
                        System.out.println("Invalid Phone Number");
                    }else
                    {
                        break;
                    }
                }
                h.deleteBooking(PhoneNumber);
                break;
            }
            case 6:
            {
                h.displayBookings();
                break;
            }
            case 7:
            {
                System.out.println("1: From Booking");
                System.out.println("2: Without Booking");
                System.out.println("3: Go Back");
                System.out.print("Enter: ");
                int a=sc.nextInt();
                switch(a)
                {
                    case 1:
                    {
                        long PhoneNumber;

                        while (true) {
                            System.out.println("Enter Guest Phone Number : ");
                            PhoneNumber=sc.nextLong();
                            if(PhoneNumber<0){
                                System.out.println("Invalid PhoneNumber");
                            }else
                            {
                                break;
                            }
                        }
                        GuestDetails d=h.deleteBooking(PhoneNumber);
                        h.Check_In(d);
                        break;
                    }
                    case 2:
                    {
                        h.displayRoomTypes();
                        int Id = 0;
                        while (true) {
                            System.out.println("\n\nEnter Room Id to Book Room: ");
                            Id = sc.nextInt();
                            if(Id<0){
                                System.out.println("Invalid Id");
                            }else
                            {
                                break;
                            }
                        }
                        if(!h.checkRoomIdExist(Id))
                        {
                            System.out.println("Sorry No Room Type of this Room id");
                            break;
                        }
                        else
                        {
                            if(h.isRoomAvailable(Id))
                            {

                                System.out.println("Enter Guest Name : ");
                                String Name=sc.next();
                                long PhoneNumber;
                                while (true) {
                                    System.out.println("Enter Guest Phone Number : ");
                                    PhoneNumber=sc.nextLong();
                                    if(PhoneNumber<0){
                                        System.out.println("Invalid PhoneNumber");
                                    }else
                                    {
                                        break;
                                    }
                                }
                                if( h.checkInPhoneExist(PhoneNumber))
                                {
                                    System.out.println("Phone Number Already Exist in Hotel");
                                    break;
                                }
                                int BookNoOfRoom;
                                while (true) {
                                    System.out.println("How Many Rooms You Want to Book ");
                                    BookNoOfRoom=sc.nextInt();
                                    if(BookNoOfRoom<0){
                                        System.out.println("Invalid value");
                                    }else
                                    {
                                        break;
                                    }
                                }
                                int a1=h.getNoOfRooms(Id);
                                if(BookNoOfRoom>a1)
                                {
                                    System.out.println("Sorry only "+a1+" Rooms Are Available so "+BookNoOfRoom+" Rooms Can't be Booked");
                                }
                                else{
                                    break;
                                }
                                System.out.println("Enter Date to Book Room:");
                                String BookedDate=sc.next();
                                int days = 0;
                                while (true) {
                                    System.out.println("For How Many Days You want to Book the Room");
                                    days = sc.nextInt();
                                    if(days<0){
                                        System.out.println("Invalid value");
                                    }else
                                    {
                                        break;
                                    }
                                }

                                boolean b=h.changeInNoOfRooms(Id,BookNoOfRoom,1);
                                if(b)
                                {
                                    double total=h.countTotal(Id,BookNoOfRoom,days);
                                    GuestDetails obj=new GuestDetails(Id,Name,PhoneNumber,BookNoOfRoom,BookedDate,total,days);
                                    h.Check_In(obj);
                                }
                            }
                            else{
                                System.out.println("Room is not Available");
                            }
                        }
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Going Back..");
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid Choice.");
                        break;
                    }
                }
                break;
            }
            case 8:
            {
                long PhoneNumber;
                while (true) {
                    System.out.println("Enter Guest Phone Number : ");
                    PhoneNumber=sc.nextLong();
                    if(PhoneNumber<0){
                        System.out.println("Invalid PhoneNumber");
                    }else
                    {
                        break;
                    }
                }
                h.checkOut(PhoneNumber);
                break;
            }
            case 9:
            {
                h.displayCustomers();
                break;
            }
            case 10:
            {

                h.displayCheckedOutCustomers();
                break;
            }
            case 11:
            {
                System.exit(0);
                break;
            }
            default:
            {
                System.out.println("Invalid Choice");
                break;
            }

        }
    }
    }
}
class Hotel
{
    Scanner sc=new Scanner(System.in);
    class RoomNode
    {
        Rooms obj;
        RoomNode next;
        RoomNode(Rooms obj) {
            this.obj = obj;
            this.next=null;
        }
    }

    class ArrivedGuestNode
    {
        GuestDetails obj;
        ArrivedGuestNode next;
        ArrivedGuestNode(GuestDetails obj)
        {
            this.obj=obj;
            this.next=null;
        }
    }

    class LeftGuestNode
    {
        GuestDetails obj;
        LeftGuestNode next;
        LeftGuestNode(GuestDetails obj)
        {
            this.obj=obj;
            this.next=null;
        }
    }

    ArrivedGuestNode firstArrivedGuest=null;
    LeftGuestNode firstLeftGuest=null;
    public void Check_In(GuestDetails obj)
    {
        ArrivedGuestNode temp=firstArrivedGuest;
        ArrivedGuestNode newArrivedGuest=new ArrivedGuestNode(obj);
        if(firstArrivedGuest==null)
        {
            firstArrivedGuest=newArrivedGuest;
            System.out.println("Check-In successfully");
        }
        else
        {
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newArrivedGuest;
            System.out.println("Check-In successfully");
        }
    }
    public void checkOut(long PhoneNumber)
    {
        int flag=0;
        ArrivedGuestNode temp=firstArrivedGuest;
        ArrivedGuestNode dummy = firstArrivedGuest;
        ArrivedGuestNode del;
        while(dummy != null)
        {
            if(dummy.obj.GuestPhoneNumber==PhoneNumber)
            {
                flag=1;
                break;
            }
            dummy=dummy.next;
        }
        if (flag==0)
        {
            System.out.println(" No Such Customer with this Phone Number Found");
        }
        else
        {
            if(firstArrivedGuest.obj.GuestPhoneNumber==PhoneNumber && firstArrivedGuest.next==null)
            {
                changeInNoOfRooms(firstArrivedGuest.obj.BookedRoomId,firstArrivedGuest.obj.BookedRooms,0);
                while (true) {
                    System.out.println("Total amount: "+firstArrivedGuest.obj.BookingTotal);
                    System.out.println("Enter Amount to Pay: ");
                    double d=sc.nextDouble();
                    if(d<firstArrivedGuest.obj.BookingTotal)
                    {
                        System.out.println("Balance should be Greater Than "+firstArrivedGuest.obj.BookingTotal);

                    }
                    else{
                        break;
                    }
                }

                checkOutHistory(firstArrivedGuest.obj);
                firstArrivedGuest=null;
                System.out.println("Check-Out Successfully");
            }
            else if (firstArrivedGuest.obj.GuestPhoneNumber==PhoneNumber) {
                changeInNoOfRooms(firstArrivedGuest.obj.BookedRoomId,firstArrivedGuest.obj.BookedRooms,0);
                while (true) {
                    System.out.println("Total amount: "+firstArrivedGuest.obj.BookingTotal);
                    System.out.println("Enter Amount to Pay: ");
                    double d=sc.nextDouble();
                    if(d<firstArrivedGuest.obj.BookingTotal)
                    {
                        System.out.println("Balance should be Greater Than "+firstArrivedGuest.obj.BookingTotal);

                    }
                    else{
                        break;
                    }
                }

                del=firstArrivedGuest;
                firstArrivedGuest=firstArrivedGuest.next;
                del.next=null;
                checkOutHistory(del.obj);
                System.out.println("Check-Out Successfully");
            }
            else
            {
                while(temp.next.obj.GuestPhoneNumber!=PhoneNumber)
                {
                    temp=temp.next;
                }
                changeInNoOfRooms(firstArrivedGuest.obj.BookedRoomId,firstArrivedGuest.obj.BookedRooms,0);
                while (true) {
                    System.out.println("Total amount: "+firstArrivedGuest.obj.BookingTotal);
                    System.out.println("Enter Amount to Pay: ");
                    double d=sc.nextDouble();
                    if(d<firstArrivedGuest.obj.BookingTotal)
                    {
                        System.out.println("Balance should be Greater Than "+firstArrivedGuest.obj.BookingTotal);

                    }
                    else{
                        break;
                    }
                }
                del=temp.next;
                temp.next=del.next;
                del.next=null;
                checkOutHistory(del.obj);
                System.out.println("Check-Out Successfully");
            }
        }
    }
    public void checkOutHistory(GuestDetails obj)
    {
        LeftGuestNode newLeftGuest=new LeftGuestNode(obj);
        if (firstLeftGuest != null) {
            newLeftGuest.next = firstLeftGuest;
        }
        firstLeftGuest=newLeftGuest;
    }
    public void displayCheckedOutCustomers()
    {
        LeftGuestNode temp=firstLeftGuest;
        while(temp!=null)
        {
            System.out.println("\n\nCustomer Name: "+temp.obj.GuestName);
            System.out.println("Customer Room Id: "+temp.obj.BookedRoomId);
            System.out.println("Customer Phone Number: "+temp.obj.GuestPhoneNumber);
            System.out.println("Customer Booked Rooms: "+temp.obj.BookedRooms);
            System.out.println("Customer Booked Date: "+temp.obj.BookedDate);
            temp=temp.next;

        }
    }
    public void displayCustomers()
    {
        ArrivedGuestNode temp=firstArrivedGuest;
        while(temp!=null)
        {
            System.out.println("\n\nCustomer Name: "+temp.obj.GuestName);
            System.out.println("Customer Room Id: "+temp.obj.BookedRoomId);
            System.out.println("Customer Phone Number: "+temp.obj.GuestPhoneNumber);
            System.out.println("Customer Booked Rooms: "+temp.obj.BookedRooms);
            System.out.println("Customer Booked Date: "+temp.obj.BookedDate);
            temp=temp.next;

        }
    }


    RoomNode first=null;
    public int getNoOfRooms(int id)
    {
        RoomNode temp=first;
        if (first != null) {
            while (temp != null) {
                if (temp.obj.RoomId == id) {
                    return temp.obj.NoOfRoom;
                }
                temp = temp.next;
            }
        }
        return 0;
    }
    public boolean checkPhoneExist(long num)
    {
        BookingNode temp=firstBooking;
        if (firstBooking != null) {
            while (temp != null) {
                if (temp.obj.GuestPhoneNumber == num) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
    public boolean checkInPhoneExist(long num)
    {
        ArrivedGuestNode temp=firstArrivedGuest;
        if (firstArrivedGuest != null) {
            while (temp != null) {
                if (temp.obj.GuestPhoneNumber == num) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
    public boolean checkRoomIdExist(int id)
    {
        RoomNode temp=first;
        if (first != null) {
            while (temp != null) {
                if (temp.obj.RoomId == id) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public boolean isRoomAvailable(int id)
    {
        RoomNode temp=first;
        if (first != null) {
            while (temp != null) {
                if (temp.obj.RoomId == id) {
                    if (temp.obj.NoOfRoom > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public void addRoomType(Rooms obj)
    {
        RoomNode temp=first;
        RoomNode newRoomType=new RoomNode(obj);
        if(first==null)
        {
            first=newRoomType;
        }
        else
        {
            while (temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newRoomType;
        }
    }
    public void removeRoomType(int Id)
    {
        int flag=0;
        RoomNode temp=first;
        RoomNode dummy =first;
        while(dummy!=null)
        {
            if(dummy.obj.RoomId==Id)
            {
                flag=1;
                break;
            }
            dummy=dummy.next;
        }
        if(flag==0)
        {
            System.out.println("No Rooms Found Of this Room Id ");
        }
        else
        {
            if(first.obj.RoomId==Id && first.next==null)
            {
                first=null;
                System.out.println("Room Type Removed");
            }
            else if(first.obj.RoomId==Id)
            {
                RoomNode delete=first;
                first=first.next;
                delete.next=null;
                System.out.println("Room Type Removed");
            }
            else{
                while (temp.next.obj.RoomId!=Id)
                {
                    temp=temp.next;

                }
                RoomNode delete=temp.next;
                temp.next=delete.next;
                delete.next=null;
                System.out.println("Room Type Removed");
            }
        }
    }
    public void displayRoomTypes()
    {
        RoomNode temp=first;
        if(temp==null)
        {
            System.out.println("No Rooms Types Are Available");
        }
        else
        {
            while(temp!=null)
            {
                System.out.println("\n\nRoom Id: "+temp.obj.RoomId);
                System.out.println("Room Type: "+temp.obj.RoomName);
                System.out.println("Room Price: "+temp.obj.RoomPrice);
                System.out.println("Available Rooms: "+temp.obj.NoOfRoom);
                temp=temp.next;
            }
        }
    }
    class BookingNode
    {
        GuestDetails obj;
        BookingNode next;

        BookingNode(GuestDetails obj) {
            this.obj = obj;
            this.next=null;
        }
    }
    BookingNode firstBooking=null;
    public boolean bookRooms(GuestDetails obj)
    {
        BookingNode temp=firstBooking;
        BookingNode newGuest=new BookingNode(obj);
        if(firstBooking==null)
        {
            firstBooking=newGuest;
            System.out.println("Room Booked Successfully");
            return true;
        }
        else
        {
            while(temp.next!=null)
            {
                if(temp.obj.GuestPhoneNumber==newGuest.obj.GuestPhoneNumber)
                {
                    System.out.println("Phone Number Already Exist");
                    return false;
                }
                temp=temp.next;
            }
            if(temp.obj.GuestPhoneNumber==newGuest.obj.GuestPhoneNumber)
            {
                System.out.println("Phone Number Already Exist");
                return false;
            }
            else
            {
                temp.next=newGuest;
                System.out.println("Room Booked Successfully");
                return true;
            }
        }
    }
    public GuestDetails deleteBooking(long phone_number)
    {
        int flag=0;
        BookingNode temp=firstBooking;
        BookingNode dummy = firstBooking;
        BookingNode del;
        while(dummy != null)
        {
            if(dummy.obj.GuestPhoneNumber==phone_number)
            {
                flag=1;
                break;
            }
            dummy=dummy.next;
        }
        if (flag==0)
        {
            System.out.println(" No Such Customer with this Phone Number Found");
            return null;
        }
        else
        {
            if(firstBooking.obj.GuestPhoneNumber==phone_number && firstBooking.next==null)
            {
                changeInNoOfRooms(firstBooking.obj.BookedRoomId,firstBooking.obj.BookedRooms,0);
                del=firstBooking;
                firstBooking=null;
                System.out.println("Booking Cancelled.");
                return del.obj;
            }
            else if (firstBooking.obj.GuestPhoneNumber==phone_number) {
                changeInNoOfRooms(firstBooking.obj.BookedRoomId,firstBooking.obj.BookedRooms,0);
                del=firstBooking;
                firstBooking=firstBooking.next;
                del.next=null;
                System.out.println("Booking Cancelled.");
                return del.obj;
            }
            else
            {
                while(temp.next.obj.GuestPhoneNumber!=phone_number)
                {
                    temp=temp.next;
                }
                changeInNoOfRooms(firstBooking.obj.BookedRoomId,firstBooking.obj.BookedRooms,0);
                del=temp.next;
                temp.next=del.next;
                del.next=null;
                System.out.println("Booking Cancelled.");
                return del.obj;
            }
        }
    }
    public void displayBookings()
    {
        BookingNode temp=firstBooking;
        while(temp!=null)
        {
            System.out.println("\n\nCustomer Name: "+temp.obj.GuestName);
            System.out.println("Customer Room Id: "+temp.obj.BookedRoomId);
            System.out.println("Customer Phone Number: "+temp.obj.GuestPhoneNumber);
            System.out.println("Customer Booked Rooms: "+temp.obj.BookedRooms);
            System.out.println("Customer Booked Date: "+temp.obj.BookedDate);
            temp=temp.next;
        }
    }
    public boolean changeInNoOfRooms(int id,int booknumbers,int a)
    {
        RoomNode temp=first;
        int flag=0;
        while(temp!=null)
        {

            if(temp.obj.RoomId==id)
            {

                flag=1;
                if(a==1)
                {

                    if(temp.obj.NoOfRoom-booknumbers>=0)
                    {
                        temp.obj.NoOfRoom-=booknumbers;
                        return true;
                    }
                    else
                    {
                        System.out.println("Sorry only "+temp.obj.NoOfRoom+" Rooms Are Available, "+booknumbers+" Rooms can't be Booked/Removed");
                        return false;
                    }
                } else if (a==0) {
                    temp.obj.NoOfRoom+=booknumbers;
                    return true;
                }
            }
            temp=temp.next;
        }
        if(flag==0)
        {
            System.out.println("No Room Type of this Id");
        }
        return false;
    }
    public double countTotal(int id,int booknumbers,int days)
    {
        double total=0.0;
        RoomNode temp=first;
        int flag=0;

        while(temp!=null)
        {
            if(temp.obj.RoomId==id)
            {
                flag=1;
                total=booknumbers*temp.obj.RoomPrice*days;
            }
            temp=temp.next;
        }
        if(flag==0)
        {
            System.out.println("No Room Type of this Id");
        }
        return total;
    }
}
class Rooms
{
    int RoomId;
    String RoomName;
    double RoomPrice;
    int NoOfRoom;
    public Rooms(int roomId, String roomName, Double roomPrice,int Noofroom) {
        RoomId = roomId;
        RoomName = roomName;
        RoomPrice = roomPrice;
        this.NoOfRoom=Noofroom;
    }
}
class GuestDetails
{
    int BookedRoomId;
    String GuestName;
    long GuestPhoneNumber;
    int BookedRooms;
    String BookedDate;
    double BookingTotal;
    int BookingDays;
    public GuestDetails(int bookedRoomId, String guestName, long guestPhoneNumber, int bookedRooms,String bookedDate,double bookTotal,int bookingDays) {
        BookedRoomId = bookedRoomId;
        GuestName = guestName;
        GuestPhoneNumber = guestPhoneNumber;
        BookedRooms = bookedRooms;
        BookedDate=bookedDate;
        BookingDays=bookingDays;
        BookingTotal=bookTotal;
    }
}
