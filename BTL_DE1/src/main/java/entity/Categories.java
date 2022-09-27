package entity;

public class Categories {
	private int id;
	private String catname;
	private int status;
	private int parentld;
	
	public Categories() {	
	}

	public Categories(int id, String catname,int status,int parentld ) {
		this.id = id;
		this.catname = catname;
		this.status = status;
		this.parentld = parentld;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getParentld() {
		return parentld;
	}

	public void setParentld(int parentld) {
		this.parentld = parentld;
	}


	
}
