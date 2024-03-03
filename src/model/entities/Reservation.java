package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	//static para não ser instanciado várias vezes na memória
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public int getRoomNumber() {
		return this.roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation date for updates must be futures";
		}
		if (!checkOut.after(checkIn)) {
			return "Check-out must be after Check-in date";
		} 
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		
		return null;

		
		
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	@Override
	public String toString() {
		return "Room: "+roomNumber
				+ " - check-in: "+sdf.format(checkIn)
				+ " - check-out: " + sdf.format(checkOut)
				+ " - duration: " + duration() 
				+ "nights";
				
	}
	

}
