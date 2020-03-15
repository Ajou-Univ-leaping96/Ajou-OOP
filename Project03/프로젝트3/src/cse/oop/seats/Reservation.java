package cse.oop.seats;

public class Reservation {
	public Seat position;
	public Time Start;
	public Time Finish;

	public Reservation(Seat position, Time Start, Time Finish) {
		this.position = position;
		this.Start = Start;
		this.Finish = Finish;
	}

	public String toString() {
		return (position.toString()+ "\n" + "��¥				���۽ð�				����ð�\n"
				+ Start.toDate() + "				" + Start.toTime() + "				" + Finish.toTime());
	}

	public void setNull() {
		this.position = null;
		this.Start = null;
		this.Finish = null;
		return;
	}

	public boolean isNull() {
		if (this.position == null && this.Start == null && this.Start == null && this.Finish == null)
			return true;
		else 
			return false;
	}

}
