package org.apache.karaf.cohortbuilder.rest.api;

import java.util.Collection;

/**
 * Simple interface describing the booking service.
 */
public interface CohortBuilderService {

    Collection<Cohort> list();

    Cohort get(Long id);

    void add(Cohort cohortbuilder);
    
    void update(Cohort cohortbuilder);
    
    void remove(Long id);
}
