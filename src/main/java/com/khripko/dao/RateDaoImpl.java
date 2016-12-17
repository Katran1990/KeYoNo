package com.khripko.dao;

import com.khripko.model.Rate;
import org.springframework.stereotype.Repository;

@Repository
public class RateDaoImpl extends AbstractDao<Rate> {

    public RateDaoImpl(Class<Rate> rateClass) {
        super(rateClass);
    }
}
