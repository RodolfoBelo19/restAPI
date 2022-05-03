package com.restApi.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restApi.study.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
