package org.apache.karaf.cohortbuilder.rest.blueprint;

import org.apache.karaf.cohortbuilder.rest.api.CohortBuilderService;
import org.apache.karaf.cohortbuilder.rest.api.Cohort;

import javax.ws.rs.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Path("/")
public class CohortBuilderServiceRest implements CohortBuilderService {

    public final static List<Cohort> DEFAULT_COHORT_LIST = List.of(
            new Cohort(1L, "test cohort", null, null)
    );

    private final Map<Long, Cohort> cohorts = DEFAULT_COHORT_LIST.stream()
            .collect(Collectors.toMap(Cohort::getId, Function.identity()));


    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Cohort> list() {
        return cohorts.values();
    }

    @Override
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Cohort get(@PathParam("id") Long id) {
        return cohorts.get(id);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @POST
    public void add(Cohort cohortbuilder) {
        cohorts.put(cohortbuilder.getId(), cohortbuilder);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @PUT
    public void update(Cohort cohortbuilder) {
        cohorts.remove(cohortbuilder.getId());
        cohorts.put(cohortbuilder.getId(), cohortbuilder);
    }

    @Override
    @Path("/{id}")
    @DELETE
    public void remove(@PathParam("id") Long id) {
        cohorts.remove(id);
    }
}
