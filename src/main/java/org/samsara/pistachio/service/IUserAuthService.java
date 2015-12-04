package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;

/**
 * Samsara Pistachio Service
 * User auth service interface
 * @author sczyh30
 */
public interface IUserAuthService {

    boolean login(String username, String password);

    boolean register(User user);
}
