package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;

/**
 * Samsara Pistachio Service
 * User service interface
 * @author sczyh30
 */
public interface IUserService {

    boolean login(String username, String password);

    boolean register(User user);
}
