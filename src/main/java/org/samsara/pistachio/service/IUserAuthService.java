package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;

import java.util.Date;

/**
 * Samsara Pistachio Service
 * User auth service interface
 * @author sczyh30
 */
public interface IUserAuthService {

    boolean login(String username, String password);

    boolean register(String username, String password, String tips,
                     String email, String gender, Date birthday);
}
