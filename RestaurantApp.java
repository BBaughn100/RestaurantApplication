/*
 * Restaurant app that allows you to add, remove, or find customers
 * as well as quit the program
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RestaurantApp {

	public static Restaurant addCustomer(String fname, String lname, int num) {

		Restaurant rest = new Restaurant(fname, lname, num);

		return rest;
	}
	
	public static int addSeats(List<Restaurant> list, String fname) {
		int tables = 0;
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getFirstName().equals(fname)) {
				tables = list.get(i).getTables();
			}
		}
		return tables;
	}
	
	public static void removeCustomer(List<Restaurant> list, String fname) {
		
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getFirstName().equals(fname)) {
				list.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Restaurant> customerList = new ArrayList<Restaurant>();
		int totalSeats = 50;
		String msg = "Would you like to [A]dd, [R]emove or [F]ind a customer, or [Q]uit?: ";

		System.out.println("Total Number Of Seats Available: " + totalSeats);
		System.out.print(msg);
		String input = in.nextLine().toUpperCase().substring(0, 1);
		while (input.trim().isEmpty() || !(input.equals("A") || input.equals("R")
				|| input.equals("Q") || input.equals("F"))) {
			System.out.println("Error! Must Enter a Valid Value!");
			System.out.print(msg);
			input = in.nextLine().toUpperCase().substring(0, 1);

		}
		while (!input.equals("Q")) {
			String fname = "";
			String lname = "";
			int numSeats = 0;
			Restaurant rest = new Restaurant(fname, lname, numSeats);
			if (input.equals("A")) {
				System.out.println();
				System.out.print("First Name: ");
				fname = in.nextLine();

				System.out.print("Last Name: ");
				lname = in.nextLine();

				System.out.print("Number of seats: ");
				numSeats = Integer.parseInt(in.nextLine());
				totalSeats = totalSeats - numSeats;
				while (totalSeats < 0) {
					System.out.println("Invalid Number of Seats");
					totalSeats = totalSeats + numSeats;
					System.out.print("Number of seats: ");
					numSeats = Integer.parseInt(in.nextLine());
				}
				System.out.println();

				rest = addCustomer(fname, lname, numSeats);
				customerList.add(rest);
			} else if (input.equals("R")) {
				System.out.println();
				System.out.println("List of Customers: ");
				for (int i = 0; i < customerList.size(); ++i) {
					System.out.println(customerList.get(i).toString());
				}
				System.out.println();
				System.out.print("First Name: ");
				fname = in.nextLine();
				System.out.print("Last Name: ");
				lname = in.nextLine();
				System.out.println();
				
				totalSeats = totalSeats + addSeats(customerList, fname);
				rest.remove(fname, lname);
				removeCustomer(customerList, fname);
				System.out.println(fname + " " + lname + " has been removed.");
			} else if (input.equals("F")) {
				System.out.println();
				System.out.println("List of Customers Recorded: ");
				if (customerList.size() == 0) {
					System.out.println("No Customers Recorded.");
				} else {
					for (int i = 0; i < customerList.size(); ++i) {
						System.out.println(customerList.get(i).toString());
					}
				}
				System.out.println();
			}
			System.out.println("Total Number Of Seats Available: " + totalSeats);
			System.out.print(msg);
			input = in.nextLine().toUpperCase().substring(0, 1);
			while (input.trim().isEmpty() || !(input.equals("A") || input.equals("R")
					|| input.equals("Q") || input.equals("F"))) {
				System.out.println("Error! Must Enter a Valid Value!");
				System.out.print(msg);
				input = in.nextLine().toUpperCase().substring(0, 1);
			}
		}
		System.out.println();
		System.out.println("Goodbye!");

		in.close();
	}

}
