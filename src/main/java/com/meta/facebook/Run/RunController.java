package com.meta.facebook.Run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class RunController {
	
//	private List<Run> runs = new ArrayList<>();
	
//	private
	@GetMapping("/hello")
	String home() {
		return "HEllo Runnerz!!";
	};
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	String home2() {
		return "HEllo Runnerz2!!";
	};
}
