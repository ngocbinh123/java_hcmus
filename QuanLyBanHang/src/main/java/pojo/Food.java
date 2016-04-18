package pojo;

public class Food extends PojoBase{
	private String image;
	private int id_foodType;  
	private int number;
	private float price;
	private Boolean status;
	private String note;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId_foodType() {
		return id_foodType;
	}
	public void setId_foodType(int id_foodType) {
		this.id_foodType = id_foodType;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * @param image
	 * @param id_foodType
	 * @param number
	 * @param price
	 * @param status
	 * @param note
	 */
	public Food(String image, int id_foodType, int number, float price, Boolean status, String note) {
		super();
		this.image = image;
		this.id_foodType = id_foodType;
		this.number = number;
		this.price = price;
		this.status = status;
		this.note = note;
	}
	/**
	 * 
	 */
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
