package com.apicheck.Apicheker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicheck.Apicheker.bean.ApiBean;
import com.apicheck.Apicheker.service.ApiService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {
 
	private ApiService apiService;
	
	public ApiController(ApiService apiService) {
		super();
		this.apiService = apiService;
	}
	@PostMapping
	public String addRecords(@RequestBody ApiBean api) {
//		 return this.apiService.insertRecord(api);
		return this.apiService.insertRecord(api);
	}
	@DeleteMapping("{id}")
	public String deleteRecord(@PathVariable("id") int id) {
		return this.apiService.deleteRecord(id);
	}

	@GetMapping
	public List<ApiBean> getAllInfo(){
		return this.apiService.fetchAll();
	}
	@GetMapping("/mail")
	public String mailApi() {
		CheckApiConnected connection = new CheckApiConnected();
		ApiBean apis = apiService.fetchRecord(1);
		System.out.println("Before Exception "+apis.getApiDestination());
		try {
			connection.makeConnection(1);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException is occure");
			e.printStackTrace();

		}
		return "make Connection successfull";
}

}
