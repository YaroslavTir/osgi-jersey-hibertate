package org.apache.karaf.cohortbuilder.rest.api;

import lombok.Data;

import java.util.List;

@Data
public class ConceptSets {

    private String id;

    private String name;

    private List<Concept> concepts;

    private List<Criteria> criteria;

}
