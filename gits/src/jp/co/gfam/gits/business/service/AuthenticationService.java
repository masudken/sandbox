package jp.co.gfam.gits.business.service;

/**
 * @author Kenichi Masuda
 */
public interface AuthenticationService {

    public boolean authenticate(String userName, String password);
}
