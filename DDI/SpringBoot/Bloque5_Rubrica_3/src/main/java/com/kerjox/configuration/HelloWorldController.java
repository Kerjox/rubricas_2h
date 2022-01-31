/**
 * @author : vagrant
 * @created : 2021-02-05
 **/
package com.kerjox.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		return new ModelAndView("hello").addObject("name", "Yashwant");
	}

}
