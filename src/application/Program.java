package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.next(), fmt1);

			System.out.print("Check-out date (dd/MM/yyyy):");
			LocalDate checkout = LocalDate.parse(sc.next(), fmt1);

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation + " \n");

			System.out.println("Enther the data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyy): ");
			checkin = LocalDate.parse(sc.next(), fmt1);

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), fmt1);

			reservation.updateDates(checkin, checkout);
			System.out.println(reservation);

		} catch (DateTimeParseException ex1) {
			System.out.println("Invalid date format !");
		} catch (DomainException ex2) {
			System.out.println("Error in reservation: " + ex2.getMessage());
		} catch (InputMismatchException ex3) {
			System.out.println("invalid digit format");
		} catch (RuntimeException ex4) {
			System.out.println("Unnexpected error!");

		}
		sc.close();

	}

}
