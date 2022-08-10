package com.example.demo.impl;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.UploadService;

@Service
public class UploadFileImpl implements UploadService {
    @Autowired
    ServletContext  app;

	@Override
	public File save(MultipartFile file, String folder )  {
		File  dir  = new File(app.getRealPath("/asserts/"+folder));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String  s =  file.getOriginalFilename();
//		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File savefile = new File(dir,s);
			
				file.transferTo(savefile);
				System.out.println(savefile.getAbsolutePath());
			    return savefile;
			  
			    
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
   
    
}
