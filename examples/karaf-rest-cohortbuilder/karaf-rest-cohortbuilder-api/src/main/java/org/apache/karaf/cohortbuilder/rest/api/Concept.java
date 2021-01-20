package org.apache.karaf.cohortbuilder.rest.api;

import lombok.Data;

@Data
public class Concept {
    private String conceptClassId;
    private String conceptCode;
    private Long conceptId;
    private String conceptName;
    private String domainId;
}
