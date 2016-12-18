package com.khripko.service;

import com.khripko.dao.GenericDao;
import com.khripko.dao.RateDao;
import com.khripko.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl extends GenericServiceImpl<Rate, Long> implements RateService {

    private RateDao dao;

    public RateServiceImpl() {
    }

    @Autowired
    public RateServiceImpl(@Qualifier("rateDaoImpl")GenericDao<Rate, Long> genericDao) {
        super(genericDao);
        this.dao = (RateDao) genericDao;
    }
}
