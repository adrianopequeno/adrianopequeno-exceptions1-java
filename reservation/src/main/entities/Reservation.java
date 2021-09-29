package main.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long durarion() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now))
			return "Error na reserva: As datas de atualiza�ao das reservas nao pode ser no passado!";
		if (!checkOut.after(checkIn))
			return "Error na reserva: A data de sa�da tem que ser superior a data de entrada";

		this.checkIn = checkIn;
		this.checkOut = checkOut;

		return null;
	}

	@Override
	public String toString() {
		return "Quanto " + roomNumber + ", entrada: " + sdf.format(checkIn) + ", sa�da: " + sdf.format(checkOut) + ", "
				+ durarion() + " nights";
	}
}
