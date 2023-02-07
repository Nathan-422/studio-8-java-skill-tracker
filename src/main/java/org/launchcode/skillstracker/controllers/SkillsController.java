package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {

    public static final String JAVA = "Java";
    public static final String JAVASCRIPT = "JavaScript";
    public static final String RUST = "Rust";

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String mainDisplay() {
        return "<h1>Skills Tracker</h1>" +
                "<h2>Languages</h2>" +
                "<ol>" +
                "<li>" + JAVA + "</li>" +
                "<li>" + JAVASCRIPT + "</li>" +
                "<li>" + RUST + "</li>" +
                "</ol>";
    }

    @RequestMapping(value="results", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String results(@RequestParam String name,
                          @RequestParam String firstPreference,
                          @RequestParam String secondPreference,
                          @RequestParam String thirdPreference) {
        return "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + firstPreference + "</li>" +
                "<li>" + secondPreference + "</li>" +
                "<li>" + thirdPreference + "</li>" +
                "</ol>";

    }

    @GetMapping(value="form")
    @ResponseBody
    public String skillsForm() {

        String formOptions = "<option value=''>--Please select an option--</value>" +
                "<option value='Java'>" + JAVA + "</value>" +
                "<option value='JavaScript'>" + JAVASCRIPT + "</value>" +
                "<option value='Rust'>" + RUST + "</value>";

        return "<html>" +
                "<body" +
                    "<form action='results' method='GET'>" +
                        "<label>Name:</label><br>" +
                        "<input type='text' name='name'><br>" +
                        "<label>My favorite language:</label><br>" +
                        "<select name='firstPreference'>" +
                            formOptions +
                        "</select><br>" +
                        "<label>My second favorite language:</label><br>" +
                        "<select name='secondPreference'>" +
                            formOptions +
                        "</select><br>" +
                        "<label>My third favorite language:</label><br>" +
                        "<select name='thirdPreference'>" +
                            formOptions +
                        "</select><br>" +
                        "<br>" +
                        "<input type='submit' value='Submit'>" +
                    "</form>" +
                "</body>" +
                "</html>";
    }


}
