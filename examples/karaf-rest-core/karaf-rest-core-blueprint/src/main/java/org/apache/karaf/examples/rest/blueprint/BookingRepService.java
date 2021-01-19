package org.apache.karaf.examples.rest.blueprint;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.karaf.examples.rest.api.Booking;
import org.apache.karaf.examples.rest.api.BookingService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation of the booking service using the JPA entity manager service (provided by Karaf).
 */
@Transactional
public class BookingRepService {

    @PersistenceContext(unitName = "booking-hibernate")
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void add(Booking booking) {
        entityManager.persist(booking);
    }


    @Transactional
    public void add(String flight, String customer) {
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setFlight(flight);
        entityManager.persist(booking);
    }

    @Transactional
    public List<Booking> list() {
        System.out.println("test");
        TypedQuery<Booking> query = entityManager.createQuery("SELECT b FROM Booking b", Booking.class);
        return query.getResultList();
    }

    @Transactional
    public Booking get(Long id) {
        TypedQuery<Booking> query = entityManager.createQuery("SELECT b FROM Booking b WHERE b.id=:id", Booking.class);
        query.setParameter("id", id);
        Booking booking = null;
        try {
            booking = query.getSingleResult();
        } catch (NoResultException e) {
            // nothing to do
        }
        return booking;
    }


    public void update(Booking booking) {

    }

    @Transactional
    public void remove(Long id) {
        Booking booking = get(id);
        entityManager.remove(booking);
    }
}
