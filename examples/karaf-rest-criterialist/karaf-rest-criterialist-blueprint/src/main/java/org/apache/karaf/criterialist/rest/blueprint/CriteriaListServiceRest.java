package org.apache.karaf.criterialist.rest.blueprint;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.karaf.criterialist.rest.api.CriteriaList;
import org.apache.karaf.criterialist.rest.api.CriteriaListService;

@Path("/")
public class CriteriaListServiceRest implements CriteriaListService {

    public final static List<CriteriaList> DEFAULT_CRITERIA_LIST = List.of(
            new CriteriaList(1L, "Add First Exposure Criteria", "Limit Drug Eras to first exposure in history."),
            new CriteriaList(2L, "Add Age at Era Start Criteria", "Filter Drug Eras by age at era start."),
            new CriteriaList(3L, "Add Age at Era End Criteria", "Filter Drug Eras by age at era end."),
            new CriteriaList(4L, "Add Gender Criteria", "Filter Drug Eras based on Gender."),
            new CriteriaList(5L, "Add Era Start Date Criteria", "Filter Drug Eras by the Era Start Date."),
            new CriteriaList(6L, "Add Era End Date Criteria", "Filter Drug Eras by the Era End Date."),
            new CriteriaList(7L, "Add Era Length Criteria", "Filter Drug Eras by the Era duration."),
            new CriteriaList(8L, "Add Era Exposure Count Criteria", "Filter Drug Eras by the Exposure Count."),
            new CriteriaList(9L, "Add Nested Criteria...", "Apply criteria using the drug era as the index event.")
    );

    private final Map<Long, CriteriaList> bookings = DEFAULT_CRITERIA_LIST.stream()
            .collect(Collectors.toMap(CriteriaList::getId, Function.identity()));


    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<CriteriaList> list() {
        return bookings.values();
    }

    @Override
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public CriteriaList get(@PathParam("id") Long id) {
        return bookings.get(id);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @POST
    public void add(CriteriaList criterialist) {
        bookings.put(criterialist.getId(), criterialist);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @PUT
    public void update(CriteriaList criterialist) {
        bookings.remove(criterialist.getId());
        bookings.put(criterialist.getId(), criterialist);
    }

    @Override
    @Path("/{id}")
    @DELETE
    public void remove(@PathParam("id") Long id) {
        bookings.remove(id);
    }
}
