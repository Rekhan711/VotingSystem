package com.votingsystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class PollDto {
    private String question;
    private List<String> options; // Text of the options
}