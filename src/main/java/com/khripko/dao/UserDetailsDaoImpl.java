package com.khripko.dao;

import com.khripko.model.UserDetails;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailsDaoImpl extends GenericDaoImpl<UserDetails, Long> implements UserDetailsDao {

    public Long getUserIdIfExist(String login){
        List list = currentSession().createQuery("from UserDetails where login like '%"+login+"%'").list();
        if (list.size()!=0){
            return ((UserDetails)list.get(0)).getId();
        } else {
            return -1L;
        }
    }
}
