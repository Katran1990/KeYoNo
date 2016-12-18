package com.khripko.dao;

import com.khripko.model.Rate;
import org.springframework.stereotype.Repository;

@Repository
public class RateDaoImpl extends GenericDaoImpl<Rate, Long> implements RateDao {
}
