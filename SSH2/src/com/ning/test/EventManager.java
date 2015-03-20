package com.ning.test;

import java.util.Date;

import org.hibernate.Session;

import com.ning.model.Event;
import com.ning.util.HibernateUtil;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();

        mgr.createAndStoreEvent("My Event", new Date());
     /*   if (args[0].equals("store")) {
        }*/

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }

}