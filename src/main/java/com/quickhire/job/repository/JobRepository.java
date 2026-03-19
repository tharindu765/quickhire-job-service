package com.quickhire.job.repository;

import com.quickhire.job.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface JobRepository extends MongoRepository<Job, String> {
    List<Job> findByPostedBy(String postedBy);
    List<Job> findByStatus(String status);
}