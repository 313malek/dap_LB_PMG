package fr.hoc.dap.server.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Contient tous les attributs pour gerer un utilisateur DaP
 * @author house
 *
 */
@Entity
public class DapUser {
    /** DaP User id. */
    @Id
    @GeneratedValue
    private Long id;
    /** DaP userkey (to store in Google Credentials). */
    @Column(nullable = false, unique = true)
    private String userkey;
    /** DaP User login . */
    private String loginName;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the userkey
     */
    public String getUserkey() {
        return userkey;
    }

    /**
     * @param userkey the userkey to set
     */
    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

}
