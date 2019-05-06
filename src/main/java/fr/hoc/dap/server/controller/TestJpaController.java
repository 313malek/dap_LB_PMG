package fr.hoc.dap.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hoc.dap.server.data.DapUser;
import fr.hoc.dap.server.data.DapUserRepository;

/**
 * Permet de faire des tests des entités JPA
 * @author house
 *
 */
@RestController
public class TestJpaController {

    @Autowired
    private DapUserRepository dapUserRepo;

    /**
     * Crée un nouvel utilisateur DaP avec un UserKey
     * Exemple d'appel : test
     * @param loginName
     * @param userkey
     */
    @RequestMapping("/test/createDapUser")
    public DapUser createDapUser(@RequestParam String loginName, @RequestParam String userkey) {
        DapUser monUser = new DapUser();
        monUser.setLoginName(loginName);
        monUser.setUserkey(userkey);

        //TODO save user !
        DapUser savedUser = dapUserRepo.save(monUser);

        return savedUser;
    }

    /**
     * Crée un nouvel utilisateur DaP avec un UserKey
     * Exemple d'appel : test
     * @param loginName
     * @param userkey
     */
    @RequestMapping("/test/loadDapUser")
    public DapUser loadDapUser(@RequestParam String userkey) {

        DapUser loadedUser = dapUserRepo.findByUserkey(userkey);

        return loadedUser;
    }

}
