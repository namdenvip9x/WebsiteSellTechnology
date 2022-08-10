package com.example.demo.restcontrollers;

import java.io.File;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ch.qos.logback.core.pattern.parser.Node;


@RestController
public class UploadFileRestcontroller {
	
	@Autowired
	UploadService uploadService;
	
	@PostMapping("/rest/upload/{img}")
	public JsonNode upload(@PathParam("files")MultipartFile file,@PathVariable("img") String img) {
		File saveFile =uploadService.save(file, img);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name",  saveFile.getName());
		node.put("size", saveFile.length());
		System.out.println(saveFile.getName());
		System.out.println(saveFile.length());
		return node;
	}
	
	
	
	
	
}
