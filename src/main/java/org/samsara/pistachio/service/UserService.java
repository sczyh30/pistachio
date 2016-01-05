package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;
import org.samsara.pistachio.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Samsara Pistachio
 * User service
 * @author sczyh30
 */
@Transactional
@Service("userService")
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * Get user entity by username
     * @param username username
     * @return user entity
     */
    @Transactional(readOnly = true)
    public User getUser(String username) {
        return userMapper.getByName(username);
    }

    /**
     * Get user entity by user id
     * @param uid user id
     * @return user entity
     */
    public User getUserById(int uid) {
        return userMapper.get(uid);
    }

}
