package ar.com.educacionit.web.jerseyclient.themoviedb;

public class MovieReducedDTO {

	private Integer id;
	private String title;
	
	public MovieReducedDTO(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MovieReducedDTO [id=" + id + ", title=" + title + "]";
	}
	
}
