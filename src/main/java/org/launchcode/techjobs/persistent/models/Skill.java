package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

//    public String skills;

    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs  = new ArrayList<>();

//    @NotNull
//    @Size(max = 500, message = "Description too long!")
    private String description;

//    @Size(max = 500, message = "Description too long!")
        public  String getDescription() {
        return description;
    }
//(@Size(max = 500, message = "Description too long!")
        public void setDescription (String description) {
        this.description = description;
    }

    public Skill () {}

    public List<Job> getJobs() {
        return jobs;
    }

    public List<Job> setJobs() {
        return jobs;
    }


//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }

}
