package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.User;

/**
 * Samsara Pistachio
 * User dao interface
 * @author sczyh30
 */
public interface UserMapper {

    /**
     * Remove a user from database by user id
     * @param uid user id
     * @return if the action is successful
     */
    int remove(Integer uid);

    /**
     * Insert a user into database
     * @param user a user entity
     * @return if the action is successful
     */
    int insert(User user);

    int insertSelective(User record);

    /**
     * Get the user entity by user id
     * @param uid user id
     * @return the user entity
     */
    User get(Integer uid);

    /**
     * Get the user entity by username
     * @param username username
     * @return the user entity
     */
    User getByName(String username);

    int updateByPrimaryKeySelective(User record);

    int update(User record);
}