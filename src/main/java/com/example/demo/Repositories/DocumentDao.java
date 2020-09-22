package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Beans.Document;
import com.example.demo.Beans.TYPE_COURRIER;

@Repository
public interface DocumentDao extends CrudRepository<Document, Long> {

	@Query("SELECT d from Document d where d.typeCourrierAccosiee=?1 and d.courrier.numeroCourrier=?2")
	List<Document> findByTypeAndForeignKey(TYPE_COURRIER type, Long numeroCourrier);
}
