package com.meta.facebook.Run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.meta.facebook.FacebookApplication;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Repository
public class RunRepository {

//	FOR IN MEMORY DATA STROAGE
//	private List<Run> runs = new ArrayList<>();
//	
//	List<Run> findAll(){
//		return runs;
//	};
////	Run findById(Integer id) {
////		return runs.stream().filter(run -> run.id() == id).findFirst().get();
////	}
//	
//	Optional<Run> findById(Integer id) {
//		return runs.stream().filter(run -> run.id() == id).findFirst();
//	}
//	
//	void create(Run run) {
//		runs.add(run);
//	}
//	
//	void update(Run run, Integer id) {
//		Optional<Run> existingRun = findById(id);
//		if(existingRun.isPresent()) {
//			runs.set(runs.indexOf(existingRun.get()), run);
//		}
//	}
//	
//	void delete(Integer id) {
//		runs.removeIf(run -> run.id().equals(id));
//	}
//	
//	@PostConstruct
//	private void init() {
//		runs.add(new Run(1,"Monday Morning",LocalDateTime.now(),
//				LocalDateTime.now().plus(30,ChronoUnit.MINUTES),3,Location.INDOOR));
//		
//		runs.add(new Run(2,"Tuesfay Morning",LocalDateTime.now(),
//				LocalDateTime.now().plus(42,ChronoUnit.MINUTES),3,Location.INDOOR));
//	}
	
//	FOR H2 DATABASE JDBC AIP
	private static final Logger log = LoggerFactory.getLogger(FacebookApplication.class);
	private final JdbcClient jdbcClient;
	
	public RunRepository(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	
	public List<Run> findAll(){
		return jdbcClient.sql("select * from run")
//				.query states that the query return type should be Run i.e. return instances of Run class i.e. ORM
//				ORM databases records are mapped to objects
				.query(Run.class).list();
	}
	
	public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT id,title,started_on,completed_on,miles,location FROM Run WHERE id = :id" )
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO Run(id,title,started_on,completed_on,miles,location) values(?,?,?,?,?,?)")
                .params(List.of(run.id(),run.title(),run.startedOn(),run.completedOn(),run.miles(),run.location().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create run " + run.title());
    }

    public void update(Run run, Integer id) {
        var updated = jdbcClient.sql("update run set title = ?, started_on = ?, completed_on = ?, miles = ?, location = ? where id = ?")
                .params(List.of(run.title(),run.startedOn(),run.completedOn(),run.miles(),run.location().toString(), id))
                .update();

        Assert.state(updated == 1, "Failed to update run " + run.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from run where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete run " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from run").query().listOfRows().size();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from run where location = :location")
                .param("location", location)
                .query(Run.class)
                .list();
    }
	
	
	
}










