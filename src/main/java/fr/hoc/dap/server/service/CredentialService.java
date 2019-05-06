package fr.hoc.dap.server.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;

/** Service to get the list of users and their connection information. */
@Service
public class CredentialService extends GoogleService {

    /** To get the users list.
     * @return The users list.
     * @throws GeneralSecurityException Security problems handling.
     * @throws IOException IO error handling.*/
    //TODO lbpmg by Djer |POO| "getUsers" serait mieux comme nom.
    public DataStore<StoredCredential> getUser() throws GeneralSecurityException, IOException {
        DataStore<StoredCredential> datas = getFlow().getCredentialDataStore();

        return datas;
    }

}
