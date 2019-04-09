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

/**
 * @author house.
 *
 */
@RestController
public class EventController {
    /**
     * a event configured service.
     */
    @Autowired
    private CalendarService cService;

    /**
     *
     * @param userKey clé utilisateur.
     * @return return the next event.
     * @throws GeneralSecurityException Security problems handling.
     * @throws IOException Google error handling.
     */
    @RequestMapping("/event/next")
    public List<Event> getNextEvents(@RequestParam("userKey") final String userKey)
            throws IOException, GeneralSecurityException {
        List<Event> result = cService.getNextEvents(userKey);

        System.out.println("afficher mon prochain rendez-vous : " + result);
        return result;

    }

    /**
     *
     * @param userKey clé utilisateur.
     * @return return the next event (String version).
     * @throws GeneralSecurityException Security problems handling.
     * @throws IOException Google error handling.
     */
    @RequestMapping("/event/nextString")
    public String getNextEventsString(@RequestParam("userKey") final String userKey)
            throws IOException, GeneralSecurityException {
        String result = cService.getNextEventText(userKey);

        System.out.println("afficher mon prochain rendez-vous : " + result);
        return result;

    }
}
