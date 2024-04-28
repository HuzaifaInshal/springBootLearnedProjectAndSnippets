package com.meta.facebook.Run;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;


//rest controller returns response to request
@RestController
@RequestMapping("/api")
public class RunController {
	
	private final RunRepository runRepository;
	
//	wrong way to initialize never instance in spring coz spring is already running an instance of it coz of @repository with postconstruct
//	public RunController() {
//		this.runRepository = new RunRepository();
//	}
	
//	correct way
	public RunController(RunRepository runRepository){
		this.runRepository = runRepository;
	}
	
	@GetMapping("/runs")
	List<Run> findAll(){
		return runRepository.findAll();
	}
	
	@GetMapping("/runs/{id}")
	Run findById(@PathVariable Integer id) {
//		return runRepository.findById(id);
		Optional<Run> rnu = runRepository.findById(id);
		if(rnu.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			throw new RunNotFoundException();
		}
		return rnu.get();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	void create(@Valid @RequestBody Run run) {
		runRepository.create(run);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	void update(@Valid @RequestBody Run run,@PathVariable Integer id) {
		runRepository.update(run, id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void delete(@PathVariable Integer id) {
		runRepository.delete(id);
	}
	
	
	@GetMapping("/hello")
	String home() {
		return "HEllo Runnerz!!";
	};
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	String home2() {
		return "HEllo Runnerz2!!";
	};
}
