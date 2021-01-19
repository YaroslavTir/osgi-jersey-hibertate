package org.apache.karaf.examples.rest.api;

import java.util.Collection;

/**
 * Simple interface describing the booking service.
 */
public interface BookingService {

    Collection<Booking> list();

    Booking get(Long id);

    void add(Booking booking);
    
    void update(Booking booking);
    
    void remove(Long id);
}
