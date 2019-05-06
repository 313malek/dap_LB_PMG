package fr.hoc.dap.server.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.gmail.GmailScopes;

import fr.hoc.dap.server.Config;

/**
 * Classe parente de tout le serviceGoogle. Permet de gérer les droits.
 * @author house
 */
@Service
public class GoogleService {
    /**
     *
     */
    @Autowired
    private Config maConf;

    // protected static final String bob = "Google Calendar API Java Quickstart";
    /** . */

    protected static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /** Dossier dans lequel les autorisations accordées par l'utilisateur seront sauvegardées . */
    // protected static final String credentialFolder = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private List<String> scopes;

    /** emplacement du fichier .*/
    // public static final String clientSecretFile = "/credentials.json";
    /** le port local pour la réponse au consentement de l'utilisateur. */
    // private static final Integer PORT = 8888;

    public GoogleService() {
        scopes = new ArrayList<String>();
        scopes.add(CalendarScopes.CALENDAR_READONLY);
        scopes.add(GmailScopes.GMAIL_READONLY);
    }

    /**
     * Creates an authorized Credential object.
     * @param httpTransport The network HTTP Transport.
     * @param userKey userKey de l'utilisateur.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     * @throws GeneralSecurityException .
     */
    protected Credential getCredentials(final NetHttpTransport httpTransport, final String userKey)
            throws IOException, GeneralSecurityException {
        GoogleAuthorizationCodeFlow flow = getFlow();

        // LocalServerReceiver receiver = new LocalServerReceiver.Builder()
        // .setPort(PORT).build();
        // return new AuthorizationCodeInstalledApp(flow, receiver)
        // .authorize("user");

        return flow.loadCredential(userKey);
    }

    /**
     * Load a Google flow.
     * @return A Google Flow
     * @throws GeneralSecurityException .
     * @throws IOException If the credentials.json and tokens files cannot be found..
     */
    public GoogleAuthorizationCodeFlow getFlow() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        // Load client secrets.
        File in = new java.io.File(maConf.getCredentialsFilePath());
        Reader targetReader = new FileReader(in);

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, targetReader);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY,
                clientSecrets, scopes)
                        .setDataStoreFactory(
                                new FileDataStoreFactory(new java.io.File(maConf.getTokensDirectoryPath())))
                        .setAccessType("offline").build();

        return flow;
    }

    /**
     * @return the maConf
     */
    protected Config getConf() {
        return maConf;
    }

    /**
     * Define a new Dap Configuration.
     * @param config the new Config
     */
    public void setConf(final Config config) {
        maConf = config;
    }

}
