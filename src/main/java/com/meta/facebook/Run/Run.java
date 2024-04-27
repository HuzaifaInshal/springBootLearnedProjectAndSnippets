package com.meta.facebook.Run;

//import java.lang.reflect.AccessFlag.Location;
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//public class Run {
//	private Integer id;
//	private String title;
//	private LocalDateTime startedOn;
//	private LocalDateTime completedOn;
//	private Integer miles;
//	private Location location;
//	
//	//	CONSTRUCTOR
//	public Run(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles, Location location) {
//		this.id = id;
//		this.title = title;
//		this.startedOn = startedOn;
//		this.completedOn = completedOn;
//		this.miles = miles;
//		this.location = location;
//		if(!completedOn.isAfter(startedOn)) {
//			throw new IllegalArgumentException("COmpleted On must be after Started On");
//		}
//	}
//
//	// GETTERS AND SETTERS
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public LocalDateTime getStartedOn() {
//		return startedOn;
//	}
//
//	public void setStartedOn(LocalDateTime startedOn) {
//		this.startedOn = startedOn;
//	}
//
//	public LocalDateTime getCompletedOn() {
//		return completedOn;
//	}
//
//	public void setCompletedOn(LocalDateTime completedOn) {
//		this.completedOn = completedOn;
//	}
//
//	public Integer getMiles() {
//		return miles;
//	}
//
//	public void setMiles(Integer miles) {
//		this.miles = miles;
//	}
//
//	public Location getLocation() {
//		return location;
//	}
//
//	public void setLocation(Location location) {
//		this.location = location;
//	}
//
//	//	EQUALS AND HASHCODE
//	@Override
//	public int hashCode() {
//		return Objects.hash(completedOn, id, location, miles, startedOn, title);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Run other = (Run) obj;
//		return Objects.equals(completedOn, other.completedOn) && Objects.equals(id, other.id)
//				&& location == other.location && Objects.equals(miles, other.miles)
//				&& Objects.equals(startedOn, other.startedOn) && Objects.equals(title, other.title);
//	}
//
//	// TO STRING	
//	@Override
//	public String toString() {
//		return "Run [id=" + id + ", title=" + title + ", startedOn=" + startedOn + ", completedOn=" + completedOn
//				+ ", miles=" + miles + ", location=" + location + "]";
//	}
//	
//}
//BUT ALL THIS ABOVE CODE IS BASIC BUILDING BLOCK IN JAVA BUT NOT NEEDS TO BE DONE IN SPRING

// Run is the model in MVC
import java.time.LocalDateTime;
//records are immutable they dont have setters we cant change them
public record Run(
		 Integer id,
		 String title,
		 LocalDateTime startedOn,
		 LocalDateTime completedOn,
		 Integer miles,
		 Location location
		) {

}

