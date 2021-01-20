package org.apache.karaf.criterialist.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A regular POJO.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CriteriaList {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

}
