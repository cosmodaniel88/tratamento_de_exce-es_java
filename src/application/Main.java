package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationException;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("*****-Wellcome to the Cosmos Hotel -*****");
			System.out.println("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.println("Check-in date: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date: ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

			System.out.println("Update dates: ");
			System.out.println("Update checkIn: ");
			Date updateCheckIn = sdf.parse(sc.next());

			System.out.println("Update checkOut: ");
			Date updateCheckOut = sdf.parse(sc.next());

			reservation.updateDates(updateCheckIn, updateCheckOut);

		}

		catch (ParseException e) {
			System.out.println("Ivalid date format");
		} catch (ReservationException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Only numbers");
		}

		sc.close();
	}

}
