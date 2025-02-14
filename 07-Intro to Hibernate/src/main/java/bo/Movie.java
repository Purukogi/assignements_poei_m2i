package bo;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private int releaseDate;
	
	@ManyToOne
	private Category category;
	
	private boolean seen;	
	private LocalTime duration;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Director director;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(
			name = "asso_movies_actors",
			joinColumns = {@JoinColumn(name = "id_movie")},
			inverseJoinColumns = {@JoinColumn(name = "id_actor")}
	)
	private List<Actor> actors;
	private String synopsis;
	
	public Movie() {}	

	public Movie(int id, String title, int releaseDate, Category category, boolean seen, LocalTime duration,
			Director director, List<Actor> actors, String synopsis) {
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.category = category;
		this.seen = seen;
		this.duration = duration;
		this.director = director;
		this.actors = actors;
		this.synopsis = synopsis;
	}	

	public Movie(String title, int releaseDate, Category category, boolean seen, LocalTime duration, Director director,
			List<Actor> actors, String synopsis) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.category = category;
		this.seen = seen;
		this.duration = duration;
		this.director = director;
		this.actors = actors;
		this.synopsis = synopsis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}	

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	
	
}
