package com.quickhire.job.dto;

import lombok.Data;

@Data
public class JobRequestDTO {
    private String title;
    private String description;
    private String budget;
    private String postedBy;
}