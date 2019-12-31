package ui;
import dao.GuestDaoImpl;
import entities.Guest;
import service.GuestServiceImpl;
import service.IGuestService;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class GuestUi {
    private IGuestService service = new GuestServiceImpl(new GuestDaoImpl());

    public static void main(String[] args) {
        GuestUi ui = new GuestUi();
        ui.runUi();
    }

    public void runUi() {
        try {
            Guest g1 = new Guest(1, "Shree");
            Guest g2 = new Guest(2, "Ram");
            service.addGuest(g1);
            service.addGuest(g2);
            Guest fetched1 = service.findGuestById(1);
            Guest fetched2 = service.findGuestById(2);
            System.out.println(fetched1.getName());
            System.out.println(fetched2.getName());
            System.out.println("Printing all the guests");
            Set<Guest> guests = service.allGuests();
            print(guests);
            Set<Guest> guest1 = service.allGuestsInOrderById(true);
            print(guest1);
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println("something went wrong");
        }
    }

    void print(Collection<Guest>guests){
        for(Guest g:guests) {
        	 
        	System.out.println(g.getName());
        	System.out.println(g.getId());
        }
    }
    }

