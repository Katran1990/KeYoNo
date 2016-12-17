package com.khripko.dao;

import com.khripko.model.Rate;

public interface RateDao {

    void create(Rate entity);
    Rate read(Long id);
    Rate update(Long id);
    void delete(Long id);

}
