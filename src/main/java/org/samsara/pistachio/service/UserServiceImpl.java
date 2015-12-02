package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Samsara Pistachio Service
 * User service implementation
 * @author sczyh30
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(User user) {
        return false;
    }
}
