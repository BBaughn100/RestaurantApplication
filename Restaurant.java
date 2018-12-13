
public class Restaurant {
	
	private String firstname;
	private String lastname;
	private int numSeats;
	
	public Restaurant(String fname, String lname, int numSeat) {
		this.firstname = fname;
		this.lastname = lname;
		this.numSeats = numSeat;
	}
	
	public void add(String fname, String lname, int num) {
		fname = this.firstname;
		lname = this.lastname;
		num = this.numSeats;
	}
	
	public String getName() {
		return this.firstname + this.lastname;
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
