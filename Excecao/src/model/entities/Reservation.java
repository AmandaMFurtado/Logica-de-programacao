package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRommNumber() {
		return roomNumber;
	}

	public void setRommNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getChrckOut() {
		return checkOut;
	}

	// Calcular a duração em dias
	public Long duration() {
		// getTime faz o calculo em milesegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		// Conversão de milesegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date chechIn, Date checkOut) {
		this.checkIn = chechIn;
		this.checkOut = checkOut;
		
	}
	
	@Override
	public String toString() {
		return "Room: "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "				
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ "nigths";
				
		
		
		
	}

}
