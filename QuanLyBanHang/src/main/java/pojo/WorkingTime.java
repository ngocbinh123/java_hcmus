package pojo;

public class WorkingTime extends PojoBase {
	private int startHour; 
	/**
	 * @param startHour
	 * @param endHour
	 */
	public WorkingTime(int startHour, int endHour) {
		super();
		this.startHour = startHour;
		this.endHour = endHour;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	private int endHour;
	public WorkingTime() {
		// TODO Auto-generated constructor stub
	}

}
