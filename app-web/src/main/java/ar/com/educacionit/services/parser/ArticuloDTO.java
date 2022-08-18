package ar.com.educacionit.services.parser;

import java.io.Serializable;

public class ArticuloDTO implements Serializable{

	private Long id;
	private String title;
	private String code;
	private Double price;

	public ArticuloDTO(Long id, String title, String code, Double price) {
		this.id = id;
		this.title = title;
		this.code = code;
		this.price = price;
	}

	public ArticuloDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * return csv row
	 * @return
	 */
	public String toLine() {
		return id +","+ title +","+ code +","+ price;
	}

	@Override
	public String toString() {
		return "ArticuloDTO [id=" + id + ", title=" + title + ", code=" + code + ", price=" + price + "]";
	}

}
