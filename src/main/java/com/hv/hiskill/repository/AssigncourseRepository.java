package com.hv.hiskill.repository;

import com.hv.hiskill.model.Assigncourse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigncourseRepository extends MongoRepository<Assigncourse, String> {

}