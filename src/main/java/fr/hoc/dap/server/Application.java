package fr.hoc.dap.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la classe) : la première ligne de la JavaDoc
/**
 * @author house
 */
@SpringBootApplication
public class Application {
    /** Logger.*/
    private static final Logger LOG = LogManager.getLogger();

    //TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la méthode) : la première ligne de la JavaDoc
    /**
     *
     * @param args connection parameters.
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Create a customised config.
     * @return the customised config.
     */
    @Bean
    public Config createConf() {
        Config configuration = new Config();
        configuration.setApplicationName("Bob");

        return configuration;
    }

    //TODO lbpmg by Djer |Spring| le "@Bean" est une annotation (de methode ou de classe) il sera ignora par Srping s'il est dans une JavaDoc 
    /**
     *
     * @param ctx application context.
     * @return args.
      * @Bean
      */
    //TODO lbpmg by Djer |Spring| Cette méthode n'est pas requsie, si tu n'a pas besoin de faire faire un Spring une action une fois qu'il est initialisé, tu peux supprimer cette méthode
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {
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

        };
    }
}
