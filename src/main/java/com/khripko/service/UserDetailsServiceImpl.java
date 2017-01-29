package com.khripko.service;

import com.khripko.dao.GenericDao;
import com.khripko.dao.UserDetailsDao;
import com.khripko.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl extends GenericServiceImpl<UserDetails, Long> implements UserDetailsService {

    private UserDetailsDao dao;

    public UserDetailsServiceImpl() {
    }

    @Autowired
    public UserDetailsServiceImpl(@Qualifier("userDetailsDaoImpl")GenericDao<UserDetails, Long> genericDao) {
        super(genericDao);
        this.dao = (UserDetailsDao) genericDao;
    }

    @Override
    @Transactional
    public Long getUserIdIfExist(String login) {
        return dao.getUserIdIfExist(login);
    }
}
