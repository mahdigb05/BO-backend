package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.CourrierDepart;

@Repository
public interface CourrierDepartDao extends CrudRepository<CourrierDepart,Long> {
}
