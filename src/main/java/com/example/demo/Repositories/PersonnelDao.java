package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.Personnel;

@Repository
public interface PersonnelDao extends CrudRepository<Personnel,Long> {
}
