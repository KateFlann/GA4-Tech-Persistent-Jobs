package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;

    private String skills;

//    @ManyToMany(mappedBy = "jobs")
//    private final List<Skill> skills  = new ArrayList<>();

    public Job() {
    }

    public Job(Employer employer) {
        this.employer = employer;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


    //    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public List<Skill> setSkills() {
//        return skills;
//    }

}
