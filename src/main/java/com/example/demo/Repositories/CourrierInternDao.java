package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.CourrierIntern;

@Repository
public interface CourrierInternDao extends CrudRepository<CourrierIntern,Long> {
}
