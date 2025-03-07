package org.apache.karaf.core.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Module {

    @Id
    @GeneratedValue
    private Long id;


    private String name;
    private String version;
    private State state;

    public enum State {
        ACTIVE, STARTING, STOPPING, STARTED, STOPPED
    }

}
