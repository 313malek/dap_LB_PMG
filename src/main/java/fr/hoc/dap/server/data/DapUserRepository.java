package fr.hoc.dap.server.data;

import org.springframework.data.repository.CrudRepository;

/**
 * Gerer les accès User en BDD
 * @author house
 */
public interface DapUserRepository extends CrudRepository<DapUser, Long> {

    DapUser findByUserkey(String userkey);

    /**
     * Crée un nouvel utilisateur DaP avec un UserKey
     * Exemple d'appel : test
     * @param loginName
     * @param userkey
     */

}
