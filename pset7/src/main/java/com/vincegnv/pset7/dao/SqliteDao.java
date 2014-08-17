package com.vincegnv.pset7.dao;

import com.vincegnv.pset7.models.ArrivalTime;
import com.vincegnv.pset7.MetrolinkDBQuery;
import com.vincegnv.pset7.models.Stop;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vince on 8/17/2014.
 */
@Component
public class SqliteDao implements MetrolinkDBQuery{
    @Autowired
    private SessionFactory sessionFactory;

    public List<String> getStations(){
        List<String> stations;
        sessionFactory.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Stop.class);
        criteria.setProjection(Projections.distinct(Projections.property("stopName")));
        stations = criteria.list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return stations;
    }

    public List<String> getArrivalTimesSorted(String currentStation){
        List<String> arrivalTimes;
        sessionFactory.getCurrentSession().beginTransaction();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArrivalTime.class);
        criteria.setProjection(Projections.distinct(Projections.property("arrivalTime")));
        criteria.add(Restrictions.like("stopName", currentStation)).addOrder(Order.asc("arrivalTime"));
        arrivalTimes = criteria.list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return arrivalTimes;
    }
}
