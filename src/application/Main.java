package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn) ) {
			System.out.println("Check-out must be after Check-in date");
		}else if(checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Check in or Check out must be a future date");
		} 
		
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

			System.out.println("Reservation: " + reservation);

			System.out.println();

			System.out.println("Update dates: ");

			

			System.out.println("Update checkIn: ");
			Date updateCheckIn = sdf.parse(sc.next());

			System.out.println("Update checkOut: ");
			Date updateCheckOut = sdf.parse(sc.next());

			if (updateCheckIn.before(now) || updateCheckOut.before(now)) {
				System.out.println("Reservation date for updates must be futures");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Check-out must be after Check-in date");
			} else {
				reservation.updateDates(updateCheckIn, updateCheckOut);

				System.out.println(reservation);
			}

		}

	}

}
