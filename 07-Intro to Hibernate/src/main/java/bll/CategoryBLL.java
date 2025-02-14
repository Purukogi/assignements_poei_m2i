package bll;

import java.util.List;

import bo.Category;
import dal.CategoryDAO;
import exceptions.CategoryException;

public class CategoryBLL {
	
	private CategoryDAO dao;
	
	public CategoryBLL() {
		dao = new CategoryDAO();
	}
	
	public List<Category> select(){
		return dao.select();
	}
	
	public Category selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Category category) throws CategoryException {		
		checkCategory(category);
		dao.insert(category);
	}
	
	public void update(Category category) throws CategoryException {		
		checkCategory(category);
		dao.update(category);
	}
	
	public void delete(Category category) {
		dao.delete(category);
	}
	
	public void checkCategory(Category category) throws CategoryException {
		
		if(category.getCategoryName() == null || category.getCategoryName().isBlank()) {
			throw new CategoryException("The category name must be filled in");
		}
		
	}

}
