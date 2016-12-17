package com.khripko.dao;

import com.khripko.model.UserDetails;

public interface UserDetailsDao {

    void create(UserDetails entity);
    UserDetails read(Long id);
    UserDetails update(Long id);
    void delete(Long id);

}
