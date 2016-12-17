package com.khripko.dao;

import com.khripko.model.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl extends AbstractDao<UserDetails> {

    public UserDetailsDaoImpl(Class<UserDetails> userDetailsClass) {
        super(userDetailsClass);
    }
}
