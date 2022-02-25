package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;
public class Weapon {

	
	private String name;
	private List<Item> items = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
