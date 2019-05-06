/**
 *
 */
package fr.hoc.dap.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la classe) : la première ligne de la JavaDoc
/**
 *
 * @author house.
 */
@RestController
public class HelloController {
    
  //TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la méthode) : la première ligne de la JavaDoc
    /**
     *
     * @return a "Hello World". //TODO lbpmg by Djer |JavaDoc| "Salutation in English" serait mieux
     */
    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

  //TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la méthode) : la première ligne de la JavaDoc
    /**
     *
     * @param theName .
     * @return a "Hello World" + name. //TODO lbpmg by Djer |JavaDoc| "Saltutation in French" serait mieux
     */
    @RequestMapping("/bonjour")
    public String direBonjour(@RequestParam("name") final String theName) {
        return "Salut!" + theName;
    }
}
