package edu.pitt.cs;

public class CatImpl implements Cat {

	// TODO: Fill in with member variables
	private int id;           // Cat's unique identifier
    	private String name;      // Cat's name
    	private boolean rented;   // Rental status (true if rented, false otherwise)


	public CatImpl(int id, String name) {
		// TODO: Fill in
		this.id = id;
        	this.name = name;
        	this.rented = false;  // Default to not rented
	}

	public void rentCat() {
		// TODO: Fill in
		if (!rented) {
            		rented = true; // Mark as rented
        	} 
		else {
            		throw new IllegalStateException("Cat is already rented.");
      		}
	}

	public void returnCat() {
		// TODO: Fill in
		if (rented) {
            		rented = false; // Mark as not rented
        	} 
		else {
            		throw new IllegalStateException("Cat is not currently rented.");
        	}
	}

	public void renameCat(String name) {
		// TODO: Fill in
		if (name == null || name.trim().isEmpty()) {
            		throw new IllegalArgumentException("Name cannot be null or empty.");
        	}
        	this.name = name;
	}

	public String getName() {
		// TODO: Fill in
		return name;
	}

	public int getId() {
		// TODO: Fill in
		return id;
	}

	public boolean getRented() {
		// TODO: Fill in
		return rented;
	}

	public String toString() {
		// TODO: Fill in
		//return "ID " + id + ". " + name + (rented ? " (rented)" : " (available)");
		return "ID " + id + ". " + name;
	}

}
