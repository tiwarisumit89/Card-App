package com.sapient.repository;

import com.sapient.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card,String> {

}
