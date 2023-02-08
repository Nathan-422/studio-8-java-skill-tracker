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
                "<option value='Java'>" + JAVA + "</option>" +
                "<option value='JavaScript'>" + JAVASCRIPT + "</option>" +
                "<option value='Rust'>" + RUST + "</option>" +
                "</select>" +
                "<br>";

        return "<html>" +
                "<body>" +
                "<form action='results' method='get'>" +
                "<label for='name'>Name:</label>" +
                "<input type='text' name='name'>" +
                "<label for='firstPreference'>My favorite language:</label>" +
                "<select name='firstPreference'>" +
                formOptions +

                "<label for='secondPreference'>My favorite language:</label>" +
                "<select name='secondPreference'>" +
                formOptions +

                "<label for='thirdPreference'>My favorite language:</label>" +
                "<select name='thirdPreference'>" +
                formOptions +

                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
