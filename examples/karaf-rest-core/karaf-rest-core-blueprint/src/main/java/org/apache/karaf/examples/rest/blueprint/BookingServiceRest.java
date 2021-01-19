package org.apache.karaf.examples.rest.blueprint;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.karaf.examples.rest.api.Booking;
import org.apache.karaf.examples.rest.api.BookingService;

@Path("/")
public class BookingServiceRest implements BookingService {

    private BookingRepService bookingRepService;

    private final Map<Long, Booking> bookings = new HashMap<>();

    public BookingServiceRest(BookingRepService bookingRepService) {
        this.bookingRepService = bookingRepService;
    }

    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Booking> list() {
        return this.bookingRepService.list();
//        return bookings.values();
    }

    @Override
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Booking get(@PathParam("id") Long id) {
        return bookings.get(id);
    }
    
    @Override
    @Path("/")
    @Consumes("application/json")
    @POST
    public void add(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @PUT
    public void update(Booking booking) {
        bookings.remove(booking.getId());
        bookings.put(booking.getId(), booking);
    }

    @Override
    @Path("/{id}")
    @DELETE
    public void remove(@PathParam("id") Long id) {
        bookings.remove(id);
    }
}
