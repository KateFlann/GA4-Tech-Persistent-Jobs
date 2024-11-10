package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
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


//    Similar to what you have done in Part 1, several of the methods in HomeController are missing code
//    because the class has not yet been wired with the data layer yet.
//    A user will select an employer when they create a job.
//    Add the employer data from employerRepository into the form template.
//    The add job form already includes an employer selection option.
//    Be sure your variable name for the employer data matches that already used in templates/add.
//    Checkout templates/add.html. Make a mental note of the name of the variable being used to pass the selected employer id on form submission.



    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");
//        new lines:
        model.addAttribute("employers", employerRepository.findAll());

        return "index";
    }


    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        return "add";
    }

    //    In processAddJobForm, add code inside of this method to select the employer object that has been chosen to be affiliated with the new job.
//    You will need to select the employer using the request parameter you’ve added to the method.  ????


    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, @Valid Employer employer,
                                       Errors errors, Model model, @RequestParam int employerId) {

        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");
            return "add";
        }

//        new lines below. I'm just not sure how or why we are supposed to pass in employerID. Had to add @Valid Employer employer to use.
        employerRepository.save(employer);
//        jobRepository.save(newJob); ???

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

            return "view";
    }

}
