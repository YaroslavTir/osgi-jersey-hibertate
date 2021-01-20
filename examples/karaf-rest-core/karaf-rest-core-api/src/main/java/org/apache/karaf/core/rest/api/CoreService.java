package org.apache.karaf.core.rest.api;

import java.util.Collection;

/**
 * Simple interface describing the booking service.
 */
public interface CoreService {

    Collection<Core> list();

    Core get(Long id);

    void add(Core core);
    
    void update(Core core);
    
    void remove(Long id);
}
