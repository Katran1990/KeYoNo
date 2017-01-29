package com.khripko.dao;

import com.khripko.model.UserDetails;

public interface UserDetailsDao extends GenericDao<UserDetails, Long> {

    Long getUserIdIfExist(String login);

}
