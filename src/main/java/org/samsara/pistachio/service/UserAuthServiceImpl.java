package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;
import org.samsara.pistachio.entity.UserAuth;
import org.samsara.pistachio.mapper.UserAuthMapper;
import org.samsara.pistachio.mapper.UserMapper;
import org.samsara.pistachio.security.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * Samsara Pistachio Service
 * User auth service implementation
 * @author sczyh30
 */

@Transactional
@Service("userAuthService")
public class UserAuthServiceImpl implements IUserAuthService {

    @Resource
    private UserAuthMapper mapper;

    @Resource
    private UserMapper userMapper;

    /**
     * Login process
     * @param username the username
     * @param password the initial password hashed by SHA-256
     * @return true if login is OK; else false
     */
    @Override
    @Transactional(readOnly = true)
    public boolean login(String username, String password) {
        String pwd = mapper.getPassword(username);
        try {
            return EncryptUtil.validate(password, pwd);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean register(String username, String password, String tips, String email, String gender, Date birthday) {

        return false;
    }

    private boolean register(User user) {
        return userMapper.insert(user) != 0;
    }



}
