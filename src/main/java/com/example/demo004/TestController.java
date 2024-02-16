package com.example.demo004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test/path/**")
	public ResponseEntity<?> test(
			@RequestBody(required = false) Map<String, Object> requestBody,
			@RequestHeader(required = false) MultiValueMap<String, String> headers,
			@RequestParam(required = false) Map<String, Object> params) throws InterruptedException {

		HttpHeaders newHeader = new HttpHeaders();

		newHeader.add("Headddddkey", "HeadddddValue");

		Map<String, Object> out = new LinkedHashMap<>();
		out.putAll(requestBody);
		out.put("port", System.getProperty("http.port"));
		out.put("params", params);
		out.put("headers", headers);

		return new ResponseEntity<Map<String, Object>>(out, newHeader, HttpStatus.OK);
	}

	@RequestMapping("/test/sh/**")
	public ResponseEntity<?> testSH(
			@RequestBody(required = false) Map<String, Object> requestBody,
			@RequestHeader(required = false) MultiValueMap<String, String> headers,
			@RequestParam(required = false) Map<String, Object> params) throws InterruptedException {

		HttpHeaders newHeader = new HttpHeaders();

		newHeader.add("Headddddkey", "HeadddddValue");

		Map<String, Object> out = new HashMap<>();
		out.putAll(requestBody);
		out.put("port", System.getProperty("http.port"));
		out.put("params", params);
		out.put("headers", headers);

		return new ResponseEntity<Map<String, Object>>(out, newHeader, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/ione/healthcheck/ping")
	public ResponseEntity<?> ping() {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}