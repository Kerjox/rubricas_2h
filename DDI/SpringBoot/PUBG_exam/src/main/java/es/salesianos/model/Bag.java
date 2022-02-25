package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;

public interface Bag {

	public boolean isFull();
	public void addItem(Item item);
	public int spaceAvalaible();
}
