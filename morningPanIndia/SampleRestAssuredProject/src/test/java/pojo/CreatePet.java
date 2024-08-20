package pojo;

import java.util.ArrayList;

public class CreatePet {

	long id;
	Category category;
	ArrayList<Tags> tags;
	String name;
	String status;
	
	
	public CreatePet(long id, Category category, String name, ArrayList<Tags> tags,
			String status) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.tags = tags;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ArrayList<Tags> getTags() {
		return tags;
	}
	public void setTags(ArrayList<Tags> tags) {
		this.tags = tags;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
