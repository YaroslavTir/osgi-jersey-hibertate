package org.apache.karaf.core.rest.api;

import java.util.Collection;

/**
 * Simple interface describing the booking service.
 */
public interface ModuleService {

    Collection<Module> list();

    Module get(Long id);

}
