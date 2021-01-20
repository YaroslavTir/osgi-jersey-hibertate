package org.apache.karaf.core.rest.blueprint;

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

import org.apache.karaf.core.rest.api.Core;
import org.apache.karaf.core.rest.api.CoreService;

@Path("/")
public class CoreServiceRest implements CoreService {

    private final Map<Long, Core> bookings = new HashMap<>();

    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Core> list() {
//        return this.bookingRepService.list();
        return bookings.values();
    }

    @Override
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Core get(@PathParam("id") Long id) {
        return bookings.get(id);
    }
    
    @Override
    @Path("/")
    @Consumes("application/json")
    @POST
    public void add(Core core) {
        bookings.put(core.getId(), core);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @PUT
    public void update(Core core) {
        bookings.remove(core.getId());
        bookings.put(core.getId(), core);
    }

    @Override
    @Path("/{id}")
    @DELETE
    public void remove(@PathParam("id") Long id) {
        bookings.remove(id);
    }
}
