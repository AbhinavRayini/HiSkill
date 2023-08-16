package com.hv.hiskill.repository;

import com.hv.hiskill.model.CustomizeCourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizeCourseRepository extends MongoRepository<CustomizeCourse, String> {

}

