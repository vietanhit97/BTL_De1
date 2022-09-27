package entity;

import java.util.Date;

public class Product {
	private int id;
	private String name;
	private String image;
	private int status;
	private float price;
	private int quantity;
	private float sale_price;
	private String description;
	private Date created_date;
	private int category_id;
	
	public Product() {
		super();
	}
	
	public Product(int id, String name, String image, int status, float price, int quantity, float sale_price,
			String description, Date created_date, int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.status = status;
		this.price = price;
		this.quantity = quantity;
		this.sale_price = sale_price;
		this.description = description;
		this.created_date = created_date;
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
}
