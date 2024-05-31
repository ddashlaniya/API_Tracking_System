package com.apicheck.Apicheker.bean;
import org.springframework.web.client.RestTemplate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Api_Details")
public class ApiBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String apiSource;
	private String apiDestination;
	private int sourcePort;
	private int destinationPort;
	public ApiBean() {
		super();
		
	}
	public ApiBean(int id, String apiSource, String apiDestination, int sourcePort, int destinationPort) {
		super();
		this.id = id;
		this.apiSource = apiSource;
		this.apiDestination = apiDestination;
		this.sourcePort = sourcePort;
		this.destinationPort = destinationPort;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApiSource() {
		System.out.println(apiSource);
		return apiSource;
	}
	public void setApiSource(String apiSource) {
		this.apiSource = apiSource;
	}
	public String getApiDestination() {
		System.out.println(apiDestination);
		return apiDestination;
	}
	public void setApiDestination(String apiDestination) {
		this.apiDestination = apiDestination;
	}
	public int getSourcePort() {
		return sourcePort;
	}
	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}
	public int getDestinationPort() {
		return destinationPort;
	}
	public void setDestinationPort(int destinationPort) {
		this.destinationPort = destinationPort;
	}
	@Override
	public String toString() {
		return "ApiBean [id=" + id + ", apiSource=" + apiSource + ", apiDestination=" + apiDestination + ", sourcePort="
				+ sourcePort + ", destinationPort=" + destinationPort + "]";
	}
	
	
}
