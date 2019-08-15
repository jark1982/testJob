package cl.desafio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeDesafioController.
 */
@Controller
public class HomeDesafioController {

	/** The Constant SWAGGER. */
	private static final String SWAGGER = "redirect:swagger-ui.html";

	/**
	 * Go swagger.
	 *
	 * @return the string
	 */
	@GetMapping(value = "/")
	public String goSwagger() {
		return SWAGGER;
	}
}
