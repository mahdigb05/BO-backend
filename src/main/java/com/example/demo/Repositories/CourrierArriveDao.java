package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.CourrierArrive;

@Repository
public interface CourrierArriveDao extends CrudRepository<CourrierArrive,Long> {
}
