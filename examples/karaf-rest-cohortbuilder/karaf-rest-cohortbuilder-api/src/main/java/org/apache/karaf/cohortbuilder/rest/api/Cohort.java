package org.apache.karaf.cohortbuilder.rest.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cohort {
    private Long id;
    private String name;

    private List<ConceptSets> conceptSetsList;
    private List<Criteria> primaryCriteria;

}
