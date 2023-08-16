package com.hv.hiskill.repository;

import com.hv.hiskill.model.CourseCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCardRepository extends MongoRepository<CourseCard, String> {

}