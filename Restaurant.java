
public class Restaurant {
	
	private String firstname;
	private String lastname;
	private int numSeats;
	
	public Restaurant(String fname, String lname, int numSeat) {
		this.firstname = fname;
		this.lastname = lname;
		this.numSeats = numSeat;
	}
	
	public String getName() {
		return this.firstname + this.lastname;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public int getTables() {
		return this.numSeats;
	}
	
	
	public void addTables(int num) {
		this.numSeats = num;
	}
	
	public void remove(String fname, String lname) {
		this.firstname = "";
		this.lastname = "";
		this.numSeats = 0;
	}
	@Override
	public String toString() {
		return this.firstname + " " + this.lastname;
	}
	
}
