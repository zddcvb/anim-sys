package com.yanxi.anim.sys.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.yanxi.anim.sys.pojo.AnimRes;

public interface FastdfsService {
	List<AnimRes> uploadFile(File file);
	
	String uploadFile(MultipartFile multipartFile);

	void downLoadFile(String fileId, File outFile);
	
	void clearCache();

	Map<String, String> getByFileId(String file_id);

	long getSizeByFileId(String uploadFile);
	
	void deleteById(String file_id);


	void updateBatch(File file);
}
