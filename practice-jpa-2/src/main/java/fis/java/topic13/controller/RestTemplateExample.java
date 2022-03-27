package fis.java.topic13.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fis.java.topic13.dto.AccountDto;

@RestController
public class RestTemplateExample {
	static final String URL_ACCOUTS = "http://localhost:8080/api/v1/accounts";
	
	@GetMapping("/rest-template/example")
	public ResponseEntity<?> call(){
		HttpHeaders httpHeaders = new HttpHeaders();	
		httpHeaders.setAccept(Arrays.asList(new MediaType[] {
			MediaType.APPLICATION_JSON	
		}));
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("my_other_key", "my_other_value");
		
		HttpEntity<AccountDto[]> httpEntity = new HttpEntity<AccountDto[]>(httpHeaders);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AccountDto[]> response = restTemplate.exchange(URL_ACCOUTS, 
				HttpMethod.GET,
				httpEntity,
				AccountDto[].class);
		
		HttpStatus httpStatus = response.getStatusCode();
		if(httpStatus == HttpStatus.OK) {
			return ResponseEntity.ok().body(response.getBody());
		}
		return ResponseEntity.ok().body(response.getStatusCode());	
	}
}
