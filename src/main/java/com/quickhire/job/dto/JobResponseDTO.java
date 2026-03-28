package com.quickhire.job.dto;

import lombok.Data;

@Data
public class JobResponseDTO {
    private String id;
    private String title;
    private String description;
    private String budget;
    private String postedBy;
    private Long userId;
    private String status;
}