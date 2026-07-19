package com.shaik.jobportal.service;

import com.shaik.jobportal.entity.Job;
import com.shaik.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    public Job updateJob(Long id, Job updatedJob) {

        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob != null) {

            existingJob.setTitle(updatedJob.getTitle());
            existingJob.setCompany(updatedJob.getCompany());
            existingJob.setLocation(updatedJob.getLocation());
            existingJob.setSalary(updatedJob.getSalary());
            existingJob.setJobType(updatedJob.getJobType());
            existingJob.setExperience(updatedJob.getExperience());
            existingJob.setDescription(updatedJob.getDescription());
            existingJob.setSkills(updatedJob.getSkills());

            return jobRepository.save(existingJob);
        }

        return null;
    }
    public String deleteJob(Long id) {

        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return "Job deleted successfully!";
        }

        return "Job not found!";
    }




}