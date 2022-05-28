package ar.com.educacionit.services.files;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private String texto;
	private List<Menu> subMenu = new ArrayList<>();
	private boolean isRoot;
	
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
	
}
