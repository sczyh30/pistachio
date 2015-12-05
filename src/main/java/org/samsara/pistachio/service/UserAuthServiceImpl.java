package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.User;
import org.samsara.pistachio.entity.UserAuth;
import org.samsara.pistachio.mapper.UserAuthMapper;
import org.samsara.pistachio.security.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Samsara Pistachio Service
 * User auth service implementation
 * @author sczyh30
 */
@Service("userAuthService")
@Transactional
public class UserAuthServiceImpl implements IUserAuthService {

    @Autowired
    private UserAuthMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public boolean login(String username, String password) {
        UserAuth user = mapper.getByName(username);
        try {
            return EncryptUtil.encrypt(password).equals(user.getPassword());
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

}
