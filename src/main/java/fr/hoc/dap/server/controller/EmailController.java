package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.server.service.GmailService;

//TODO lbpmg by Djer |JavaDoc| Il manque la "description" (de la classe) : la première ligne de la JavaDoc
/**
 *
 * @author house.
 */
@RestController

public class EmailController {
    /** A Gmail configured service. */
    @Autowired
    private GmailService service;

    /**
     * Display number of unread email.
     * @param userKey Clé d'utilisateur. //TODO lbpmg by Djer |JavaDoc| "Clé utilisateur DaP" serait mieux
     * @return the number of unread emails.
     * @throws GeneralSecurityException Security problems handling.
     * @throws IOException Google error handling.
     */
    @RequestMapping("/email/nbunread")
    public Integer displayNbEmail(@RequestParam final String userKey) throws GeneralSecurityException, IOException {

        Integer nbEmails = service.getNbEmail(userKey);
        return nbEmails;
    }
}
