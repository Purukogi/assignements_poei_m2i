package bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "act")
public class Actor extends Person {
	
	public Actor() {}
	
	public Actor(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
}
