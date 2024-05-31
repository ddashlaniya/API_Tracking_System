package com.apicheck.Apicheker.service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.apicheck.Apicheker.bean.ApiBean;

public class RestTempleteClass {

	@Autowired
	private ApiService apiService;
	@Autowired
	private RestTemplate restTemplate;

	public String connectionedApi(int serverId) {
		
		ApiBean apis = apiService.fetchRecord(serverId);


		System.out.println("object of api " + apis);
		if (apis != null) {
			String destinationIp = apis.getApiSource();
			int destinationPort = apis.getDestinationPort();
			System.out.println(destinationIp);
			System.out.println(destinationPort);

			String url = "http://" + destinationIp + ":" + destinationPort;


			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
	
			
			HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

			try {
				
				ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
						String.class);
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
					return "Connection established successfully.";
				} else {
					SendMail.checkDuplicationApi();
					return "Failed to establish connection. Email sent.";
				}
			} catch (ResourceAccessException e) {
				SendMail.checkDuplicationApi();
				return "Failed to establish connection. Email sent.";
			}
		} else {
			return "Server not found";
		}
	}
}
