package bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "category")
	private String categoryName;
	
	public Category() {}

	public Category(int id, String theme) {
		this.id = id;
		this.categoryName = theme;
	}

	public Category(String theme) {
		this.categoryName = theme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String theme) {
		this.categoryName = theme;
	}	
	
}
