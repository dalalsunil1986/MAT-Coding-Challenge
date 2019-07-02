package com.soft.pgs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CarStatus {
    private int timestamp;
    private int carIndex;
    private String type;
    private int value;
}
