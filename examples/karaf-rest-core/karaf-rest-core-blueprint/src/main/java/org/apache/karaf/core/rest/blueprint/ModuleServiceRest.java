package org.apache.karaf.core.rest.blueprint;
//import com.google.common.collect.ImmutableSet;

import com.google.common.collect.ImmutableSet;
import org.apache.karaf.core.rest.api.Module;
import org.apache.karaf.core.rest.api.ModuleService;
//import org.junit.Assert;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Path("/")
public class ModuleServiceRest implements ModuleService {

    public final static List<Module> DEFAULT_CRITERIA_LIST = List.of(
            new Module(1L, "Core", "0.0.1", Module.State.ACTIVE),
            new Module(2L, "CohortBuilder", "0.0.1", Module.State.ACTIVE),
            new Module(3L, "CriteriaList", "0.0.1", Module.State.ACTIVE)
    );

    private final Map<Long, Module> modules = DEFAULT_CRITERIA_LIST.stream()
            .collect(Collectors.toMap(Module::getId, Function.identity()));

    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Module> list() {
        System.out.println("test");
        return ImmutableSet.copyOf(modules.values());
//        return modules.values();

    }

    @Override
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Module get(@PathParam("id") Long id) {
        return modules.get(id);
    }

}
