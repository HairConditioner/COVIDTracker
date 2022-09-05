package com.github.conditioner.covidtracker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationModel {
    private String state, country;
    private int latestTotalCases, diffFromPreviousDay;
}
