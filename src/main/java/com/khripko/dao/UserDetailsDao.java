package com.khripko.dao;

import com.khripko.model.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao {

    void create(UserDetails entity);
    UserDetails read(Long id);
    UserDetails update(UserDetails entity);
    void delete(UserDetails entity);

}
