package entity;

import java.util.Date;

public class Travels {
	private int trId;
	private String name;
	private float price;
	private int days;
	private int catId;
	private Date startDate;
	
	public Travels() {
		super();
	}

	public Travels(int trId, String name, float price, int days, int catId, Date startDate) {
		super();
		this.trId = trId;
		this.name = name;
		this.price = price;
		this.days = days;
		this.catId = catId;
		this.startDate = startDate;
	}

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
