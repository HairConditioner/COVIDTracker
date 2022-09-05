package com.github.conditioner.covidtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.conditioner.covidtracker.model.LocationModel;
import com.github.conditioner.covidtracker.service.COVIDDataService;

@Controller
public class HomeController {
    @Autowired
    private COVIDDataService service;

    @GetMapping("/")
    public String getHome(Model model) {
        List<LocationModel> parentLocations = service.getParentLocations();
        int totalReportedCases = parentLocations.stream().mapToInt(location -> location.getLatestTotalCases()).sum();
        int totalNewCases = parentLocations.stream().mapToInt(location -> location.getDiffFromPreviousDay()).sum();

        model.addAttribute("locations", parentLocations);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
