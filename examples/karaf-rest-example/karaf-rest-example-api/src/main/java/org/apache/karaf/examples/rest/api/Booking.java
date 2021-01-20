package org.apache.karaf.examples.rest.api;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * A regular POJO.
 */
@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private String customer;
    private String flight;

}
