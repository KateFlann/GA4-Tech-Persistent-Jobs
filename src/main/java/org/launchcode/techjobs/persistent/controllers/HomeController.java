package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }


    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }


//    added skillID, etc for part 4
    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam Integer employerId, @RequestParam List<Integer> skills) {
        if (errors.hasErrors()) {
            return "add";
        }
        //        Alternative to 'Optional'
        Employer employer = employerRepository.findById(employerId).orElse(new Employer());
        newJob.setEmployer(employer);

        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);

         jobRepository.save(newJob);

        return "redirect:";


    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Job job = jobRepository.findById(jobId).orElse(new Job());
//            Optional job = jobRepository.findById(jobId);
        model.addAttribute("title", "Job: " + job.getName());
        model.addAttribute("job", job);
        model.addAttribute("employers", employerRepository.findAll());
            return "view";
    }

}
