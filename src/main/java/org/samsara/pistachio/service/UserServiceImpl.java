package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;
import org.samsara.pistachio.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Transactional(readOnly = true)
    public User testGetUser(int id) {
        return mapper.get(10);
    }
}
