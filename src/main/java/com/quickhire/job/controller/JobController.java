package com.quickhire.job.controller;

import com.quickhire.job.dto.JobRequestDTO;
import com.quickhire.job.dto.JobResponseDTO;
import com.quickhire.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobResponseDTO> createJob(@RequestBody JobRequestDTO dto) {
        return ResponseEntity.ok(jobService.createJob(dto));
    }

    @GetMapping
    public ResponseEntity<List<JobResponseDTO>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJobById(@PathVariable String id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @GetMapping("/user/{postedBy}")
    public ResponseEntity<List<JobResponseDTO>> getJobsByUser(@PathVariable String postedBy) {
        return ResponseEntity.ok(jobService.getJobsByPostedBy(postedBy));
    }
}