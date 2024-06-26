package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		LocalDate checkout;
		LocalDate checkin;
		Reservation reservation = new Reservation();
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		do {
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkout = LocalDate.parse(sc.next(), fmt1);

			if (!checkin.isAfter(checkout)) {
				reservation = new Reservation(roomNumber, checkin, checkout);
				System.out.println(reservation + " \n");
			} else {
				System.out.println("Error in reservation: check out date must be after check-in date. \n");
			}
		} while (checkin.isAfter(checkout));

		System.out.println("Enther the data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyy): ");
		checkin = LocalDate.parse(sc.next(), fmt1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkout = LocalDate.parse(sc.next(), fmt1);

		String error = reservation.updateDates(checkin, checkout);
		if (error != null) {
			System.out.println("Error in reservation:" + error);
		} else {
			System.out.println(reservation);
		}

		sc.close();

	}

}
