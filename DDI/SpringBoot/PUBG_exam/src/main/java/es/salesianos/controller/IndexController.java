package es.salesianos.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Item;
import es.salesianos.model.Person;
import es.salesianos.model.Weapon;

@Controller
public class IndexController {

	private static Logger log = LogManager.getLogger(IndexController.class);

	@Autowired
	private Person person;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("person", this.person);
		return modelAndView;
	}

	
	@PostMapping("insert")
	public ModelAndView personInsert(Person personForm) {
		log.debug("personInsert:" + this.person.toString());		
		ModelAndView modelAndView = new ModelAndView("index");
		// this.person=personForm;
		addPageData(personForm);
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	private void addPageData(Person personForm) {

		if (!StringUtils.hasLength(personForm.getName())) {
			person.setName(personForm.getName());
		}

		if (!StringUtils.hasLength(personForm.getItem())) {
			Item item = new Item();
			if (personForm.getItem().getType().equalsIgnoreCase("weapon")) {

				Weapon weapon = new Weapon();
				weapon.setName(personForm.getItem().getName());
				if (person.getPrimary() == null) {
					person.setPrimary(weapon);
				} else if (person.getSecondary() == null) {
					person.setSecondary(weapon);
				} else {
					person.setPrimary(weapon);
				}

			} else if (personForm.getItem().getType().equalsIgnoreCase("accesory")) {

				List<Item> items = person.getPrimary().getItems();
				items.add(item);
				person.getPrimary().setItems(items);
				System.out.println("accesorios:" + items);

			} else {
				item.setName(personForm.getItem().getName());
				item.setPeso(personForm.getItem().getPeso());
				item.setType(personForm.getItem().getType());
				this.person.getBag().addItem(item);
			}
			this.person.setItem(item);
		}
	}
	
	@PostMapping("switchWeapon")
	public ModelAndView switchWeapon() {

		Weapon tmp;
		tmp = this.person.getPrimary();
		this.person.setPrimary(this.person.getSecondary());
		this.person.setSecondary(tmp);
		if (this.person.getPrimary().getName() != null) {
			System.out.println("El arma activa es " + this.person.getPrimary().getName());
		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("person", this.person);
		return modelAndView;
	}



}
