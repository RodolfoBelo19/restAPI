package com.restApi.study.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.study.model.Client;
import com.restApi.study.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> listar() {
		return clientRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client createClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	@GetMapping("/{id}")
	public Optional<Client> getClient(@PathVariable Long id) {
		return clientRepository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public Client deleteClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return null;
	}
	
	
}