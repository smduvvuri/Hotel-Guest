package dao;

import entities.Guest;
import java.util.Set;

	public interface IGuestDao {
	    void addGuest(Guest g);

	    Guest findGuestById(int id);

	    Set<Guest> allGuests();

		Set<Guest> allGuestsInOrderById(boolean a);
	}
