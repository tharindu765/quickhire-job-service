package com.quickhire.job.service;

import com.quickhire.job.dto.JobRequestDTO;
import com.quickhire.job.dto.JobResponseDTO;
import java.util.List;

public interface JobService {
    JobResponseDTO createJob(JobRequestDTO dto);
    List<JobResponseDTO> getAllJobs();
    JobResponseDTO getJobById(String id);
    List<JobResponseDTO> getJobsByPostedBy(String postedBy);
}