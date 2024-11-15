package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;

//Adding "(mappedBy = "skills")" or (mappedBy = "jobs") actually broke it... hmm. So... how do we readd Skills to jobs...
    @ManyToMany
    private final List<Skill> skills  = new ArrayList<>();

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

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Skill> setSkills() {
        return skills;
    }

}
