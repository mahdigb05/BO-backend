package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.Departement;

@Repository
public interface DepartementDao extends CrudRepository<Departement,Long> {
}
