package ar.com.educacionit.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Entity{

	private Long id;
	private String texto;
	private List<Menu> subMenu = new ArrayList<>();
	private boolean isRoot;
	private Long idMenuPadre;
	
	public Menu(Long id, String texto, boolean isRoot, Long idMenuPadre) {
		this.id = id;
		this.texto = texto;
		this.isRoot = isRoot;
		this.idMenuPadre = idMenuPadre;
	}

	public Menu(String texto, List<Menu> subMenu, boolean isRoot) {
		this.texto = texto;
		this.subMenu = subMenu;
		this.isRoot = isRoot;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMenuPadre() {
		return idMenuPadre;
	}

	public void setIdMenuPadre(Long idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}
	
	//alt+shif+s
	@Override
	public String toString() {
		return "Menu [id=" + id + ", texto=" + texto + ", subMenu=" + subMenu + ", isRoot=" + isRoot + "]";
	}
	
}
