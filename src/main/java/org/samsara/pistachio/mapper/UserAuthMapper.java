package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.UserAuth;

/**
 * Samsara Pistachio
 * User auth dao interface
 * @author sczyh30
 */
public interface UserAuthMapper {

    int remove(Integer uid);

    int insert(UserAuth user);

    int insertSelective(UserAuth user);

    UserAuth get(Integer uid);

    /**
     * Get user auth info by username
     * @param username username
     * @return user auth entity
     */
    UserAuth getByName(String username);

    int updateByPrimaryKeySelective(UserAuth record);

    int update(UserAuth record);

    /**
     * Get password by username
     * @param username username
     * @return encrypted password (String)
     */
    String getPassword(String username);
}