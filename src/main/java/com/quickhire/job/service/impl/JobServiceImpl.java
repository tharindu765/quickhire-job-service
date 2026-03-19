package com.quickhire.job.service.impl;

import com.quickhire.job.dto.JobRequestDTO;
import com.quickhire.job.dto.JobResponseDTO;
import com.quickhire.job.entity.Job;
import com.quickhire.job.repository.JobRepository;
import com.quickhire.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public JobResponseDTO createJob(JobRequestDTO dto) {
        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setBudget(dto.getBudget());
        job.setPostedBy(dto.getPostedBy());
        job.setStatus("OPEN");
        Job saved = jobRepository.save(job);
        return mapToDTO(saved);
    }

    @Override
    public List<JobResponseDTO> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobResponseDTO getJobById(String id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return mapToDTO(job);
    }

    @Override
    public List<JobResponseDTO> getJobsByPostedBy(String postedBy) {
        return jobRepository.findByPostedBy(postedBy)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private JobResponseDTO mapToDTO(Job job) {
        JobResponseDTO dto = new JobResponseDTO();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setDescription(job.getDescription());
        dto.setBudget(job.getBudget());
        dto.setPostedBy(job.getPostedBy());
        dto.setStatus(job.getStatus());
        return dto;
    }
}