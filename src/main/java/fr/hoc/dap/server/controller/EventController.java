package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.calendar.model.Event;

import fr.hoc.dap.server.service.CalendarService;

//TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la classe) : la première ligne de la JavaDoc
/**
 *
 * @author house.
 */
@RestController
public class EventController {
    /** A event configured service. */
    @Autowired
    private CalendarService cService;

    //TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la méthode) : la première ligne de la JavaDoc
    /**
     *
     * @param userKey clé utilisateur. //TODO lbpmg by Djer |JavaDoc| Ajouter "DaP" dans la description de cette attribut serait utile
     * @return return the next event.
     * @throws GeneralSecurityException Security problems handling.
     * @throws IOException Google error handling.
     */
    //TODO lbpmg by Djer |POO| Cette méthode ne revnoyant qu'un seul Event elle devrait s'apeller "getNextEvent"
    //TODO lbpmg by Djer |POO| Cette méthode pourrait renvoyer un "Event" au lieux d'une List<Event>" (en extrayant le première élément SI le service en a renvoyé)
    @RequestMapping("/event/next")
    public List<Event> getNextEvents(@RequestParam("userKey") final String userKey)
            throws IOException, GeneralSecurityException {
        List<Event> result = cService.getNextEvents(userKey);

        //TODO lbpmg by Djer |POO| Pas de SysOut sur un serveur ! Tu peux utiliser une LOG à la place (en Info serait bien ici)
        System.out.println("afficher mon prochain rendez-vous : " + result);
        return result;
    }

    //TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la méthode) : la première ligne de la JavaDoc
    /**
     *
     * @param userKey clé utilisateur.
     * @return return the next event (String version).
     * @throws GeneralSecurityException Security problems handling.
     * @throws IOException Google error handling.
     */
  //TODO lbpmg by Djer |POO| Cette méthode ne revnoyant qu'un seul Event elle devrait s'apeller "getNextEventString"
    @RequestMapping("/event/nextString")
    public String getNextEventsString(@RequestParam("userKey") final String userKey)
            throws IOException, GeneralSecurityException {
        String result = cService.getNextEventText(userKey);

        //TODO lbpmg by Djer |POO| Pas de SysOut sur un serveur ! Tu peux utiliser une LOG à la place (en Info serait bien ici)
        System.out.println("afficher mon prochain rendez-vous : " + result);
        return result;
    }
}
