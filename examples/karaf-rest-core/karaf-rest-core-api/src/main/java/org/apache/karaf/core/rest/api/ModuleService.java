package org.apache.karaf.core.rest.api;

import java.util.Collection;

public interface ModuleService {

    Collection<Module> list();

    Module get(Long id);

}
