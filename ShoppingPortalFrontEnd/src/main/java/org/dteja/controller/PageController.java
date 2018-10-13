package org.dteja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class PageController {

	@RequestMapping(value = { "/","/index"} )
	public String showIndexpage() {

		return "index";
	}

}
