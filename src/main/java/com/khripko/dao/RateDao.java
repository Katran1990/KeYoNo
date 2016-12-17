package com.khripko.dao;

import com.khripko.model.Rate;

public interface RateDao {

    void create(Rate entity);
    Rate read(Long id);
    Rate update(Rate entity);
    void delete(Rate entity);

}
