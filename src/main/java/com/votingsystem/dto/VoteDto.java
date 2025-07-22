package com.votingsystem.dto;

import lombok.Data;

@Data
public class VoteDto {
    private Long pollId;
    private Long optionId;
}