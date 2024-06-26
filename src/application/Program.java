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

		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		String Scheckin = sc.next();
		LocalDate checkin = LocalDate.parse(Scheckin, fmt1);
		System.out.print("Check-out date (dd/MM/yyyy):");
		String Scheckout = sc.next();
		LocalDate checkout = LocalDate.parse(Scheckout, fmt1);

		Reservation reservation = new Reservation(roomNumber, checkin, checkout);

		System.out.println(reservation + " \n");

		System.out.println("Enther the data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Scheckin = sc.next();
		checkin = LocalDate.parse(Scheckin, fmt1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Scheckout = sc.next();
		checkout = LocalDate.parse(Scheckout, fmt1);

		reservation.updateDates(checkin, checkout);

		System.out.println(reservation);

		sc.close();

	}

}
