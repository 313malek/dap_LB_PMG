package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

//TODO lbpmg by Djer |JavaDoc| le "next Event" est UNE des méthdoe de se service. "Manage Google Calendar" serait mieux
/** Service to get the next event. */
@Service
public final class CalendarService extends GoogleService {
    /**
     *
     */
    private CalendarService() {

    }

    //TODO lbpmg by Djer |Spring| Le Singleton est maintenant géré par Spring, cette attribut (et la méthode getIsntance()) n'est plus utile
    /**
     *
     */
    private static final CalendarService INSTANCE = new CalendarService();

    /**
     *
     * @return instance.
     */
    public static CalendarService getInstance() {
        return INSTANCE;
    }

    //TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la méthode) : la première ligne de la JavaDoc
    /**
     *
     * @return Calendar service.
     * @throws IOException Google IO problems handling.
     * @throws GeneralSecurityException Security problems handling.
     * @param  userKey de l'utilisateur.
     */
    //TODO lbpmg by Djer |JavaDoc| "buildService" serait mieu comme nom de méthode
    private Calendar getService(final String userKey) throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar serviceCalendar = new Calendar.Builder(httpTRANSPORT, JSON_FACTORY,
                getCredentials(httpTRANSPORT, userKey)).setApplicationName(getConf().getApplicationName()).build();
        return serviceCalendar;
    }

    /** To show the next events.
     * @param userKey de l'utilisateur.
     * @param config.
     * @throws IOException Google IO problems handling.
     * @throws GeneralSecurityException Security problems handling.
     * @return The next Event.
     */
    //TODO lbpmg by Djer |JavaDoc| Pourrait attendre un dexuiéme parmaètre "nbToDisplay", cela justifierait de renvoyer une liste (qui ne contiendrait parfois que UN seul élément). Ca sera alors à l'appelant (le controller) de définir le nombre de prochains évènnement à afficher.
    public List<Event> getNextEvents(final String userKey) throws IOException, GeneralSecurityException {
      //TODO lbpmg by Djer |Log4J| une eptite Log en infio ? "Searching for next event for user : " + userKey
        System.out.println(getConf().getApplicationName());
        final Integer top = 1;
        // Calendar service = getService();

        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = getService(userKey).events().list("primary").setMaxResults(top).setTimeMin(now)
                .setOrderBy("startTime").setSingleEvents(true).execute();
        List<Event> items = events.getItems();

        return items;
    }

    /**
     * Next event basic content.
     * @param userKey de l'utilisateur.
     * @return a string representation of next events.
     * @throws GeneralSecurityException Security problems handling.
     * @throws IOException Google error handling.
     */
    public String getNextEventText(final String userKey) throws IOException, GeneralSecurityException {
      
        List<Event> events = getNextEvents(userKey);

        String theNextEvent = "";
        if (events.isEmpty()) {
            theNextEvent = "No upcoming events found.";
            //TODO lbpmg by Djer |POO| Pas de SysOut sur un serveur !
            System.out.println("No upcoming events found.");
        } else {
            theNextEvent = "Upcoming events";
            //TODO lbpmg by Djer |POO| Pas de SysOut sur un serveur !
            System.out.println("Upcoming events ; ");
            for (Event event : events) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                theNextEvent = theNextEvent + event.getSummary() + "(" + start + "), ";
                //TODO lbpmg by Djer |POO| Pas de SysOut sur un serveur !
                System.out.printf("%s (%s)\n", event.getSummary(), start);
            }
        }
        //TODO lbpmg by Djer |Log4J| Tu peux ajouter un message dans la LOG ici (en info) avec le result (et supprimer les 3 "SysOut" au dessus)

        return theNextEvent;
    }

}
