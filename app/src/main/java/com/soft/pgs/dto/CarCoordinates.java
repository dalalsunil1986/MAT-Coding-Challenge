package com.soft.pgs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CarCoordinates {
    private int carIndex;
    private Location location;
}
