package dao;
import java.util.*;

import entities.Guest;
import exceptions.GuestNotFoundException;
import util.GuestComparator;

public class GuestDaoImpl implements IGuestDao {
	    private Map<Integer, Guest> store = new HashMap<>();

	    @Override
	    public void addGuest(Guest g) {
	        store.put(g.getId(), g);
	    }

	    @Override
	    public Guest findGuestById(int id) {
	       Guest g = store.get(id);
	        if (g == null) {
	            throw new GuestNotFoundException("guest not found for id=" + id);
	        }
	        return g;
	    }

	    @Override
	    public Set<Guest> allGuests() {
	        Collection<Guest> guests = store.values();
	        Set<Guest> guestSet = new HashSet<>(guests);
	        return guestSet;
	    }
	    @Override
	    public Set<Guest> allGuestsInOrderById(boolean a){
	    	Collection<Guest> guests=store.values();
	    	Comparator<Guest> comparator=new GuestComparator();
	    		Set<Guest> guestSet= new TreeSet<>(comparator);
	    		guestSet.addAll(guests);
	    		return guestSet; 	    
	    		}
}