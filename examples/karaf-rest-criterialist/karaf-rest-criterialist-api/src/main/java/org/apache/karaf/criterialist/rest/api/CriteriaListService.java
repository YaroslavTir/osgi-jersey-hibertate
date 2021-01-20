package org.apache.karaf.criterialist.rest.api;

import java.util.Collection;

/**
 * Simple interface describing the booking service.
 */
public interface CriteriaListService {

    Collection<CriteriaList> list();

    CriteriaList get(Long id);

    void add(CriteriaList criterialist);
    
    void update(CriteriaList criterialist);
    
    void remove(Long id);
}
