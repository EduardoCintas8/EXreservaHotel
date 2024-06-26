package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;

	public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void updateDates(LocalDate checkin, LocalDate checkout) {
		this.checkin = checkin;
		this.checkout = checkout;

	}

	public Integer duration() {
		Period diferenca = Period.between(checkin, checkout);
		Integer dias = diferenca.getDays();
		return dias;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Reservation: Room ");
		sb.append(roomNumber + ", ");
		sb.append(" check-in: " + checkin.format(fmt1));
		sb.append(", check-out: " + checkout.format(fmt1));
		sb.append(", " + duration());
		sb.append(" nights");

		return sb.toString();

	}

}
