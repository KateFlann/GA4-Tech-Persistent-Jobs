package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    //@NotNull?
    @Size(max = 500, message = "Description too long!")
    private String description;

    public @Size(max = 500, message = "Description too long!") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 500, message = "Description too long!") String description) {
        this.description = description;
    }

    public Skill () {}

}
