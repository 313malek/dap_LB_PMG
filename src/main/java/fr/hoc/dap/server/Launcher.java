package fr.hoc.dap.server;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TODO lbpmg by Djer |Command Line| Cette classe n'est plus utile, elle est "remplacée" par "Application" depuis qu'on utilise Spring Boot.
/**
 * Entry point.
 * @author house
 *
 */
final class Launcher {

    /**
     * Utility class.
     */
    private Launcher() {
        super();
    }

    /** Logger. */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * @param args to generat arguments.
     * @throws IOException IO exception handling.
     * @throws GeneralSecurityException Security exception handling.
     */
    public static void main(final String... args) throws IOException, GeneralSecurityException {
        // System.out.println("Mon agenda 2019");
        // LOG.info("Salut le monde!");
        // LOG.error("Ceci est une erreur!");
        // LOG.debug("Ceci est un debug");
        //
        // Config configuration = new Config();
        // configuration.setApplicationName("Bob");
        //
        // CalendarService date = CalendarService.getInstance();
        // date.setConfiguration(configuration);
        // date.getNextEvents();
        //
        // GmailService mail = GmailService.getInstance();
        // mail.setConfiguration(configuration);
        // mail.getNbEmail();

    }

}
