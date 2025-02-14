package bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "dir")
public class Director extends Person{
	
	public Director() {}
	
	public Director(String firstName, String lastName) {
		super(firstName, lastName);
	}

}
