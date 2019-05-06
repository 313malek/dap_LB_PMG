package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;

import fr.hoc.dap.server.service.CredentialService;

//TODO lbpmg by Djer |JavaDoc| Tous le projet est du JEE, ca n'est pas spécifique à cette classe. "TO Handle Admin Action" serait mieux
/** JEE Service for Web view. */
//TODO lbpmg by Djer |POO| Mettre "Service" dans le nom de la classe est un peu ambigüe : "AdminController" serait mieux
@Controller
public class ServiceController {

    /** users list. */
    @Autowired
    private CredentialService credSrv;

    /** Link with administrator view (Browser).
     * @param model HTML view. //TODO lbpmg by Djer |JavaDoc| NON, le modele n'est PAS la vue. "existing model to add usefull data for view" serait mieux. En général on documente "peu" ce paramètre car c'est un "standard MVC". "MVC Model" serait bien aussi.
     * @throws GeneralSecurityException Security error handling.
     * @throws IOException Google IO error handling.
     * @return view.
     */
    @RequestMapping("/admin")
    public String admin(final ModelMap model) throws GeneralSecurityException, IOException {
      //TODO lbpmg by Djer |MVC| Le paramètre "maVar" n'est pas utile dans la view "admin"
        model.addAttribute("maVar", "Admin");

        DataStore<StoredCredential> userMap;
        userMap = credSrv.getUser();

        Map<String, StoredCredential> mapUsers = new HashMap<>();
        Set<String> keys = userMap.keySet();

        for (String key : keys) {
            StoredCredential value = userMap.get(key);
            mapUsers.put(key, value);

        }
        model.addAttribute("users", mapUsers);

        return "admin";
    }
}

// model.addAttribute("essai", userMap);

// List<String> bestioles = new ArrayList<>();

// bestioles.add("Chien");
// bestioles.add("Zèbre");
// bestioles.add("Suricate");
// bestioles.add("Chat");

// model.addAttribute("bebettes", bestioles);
