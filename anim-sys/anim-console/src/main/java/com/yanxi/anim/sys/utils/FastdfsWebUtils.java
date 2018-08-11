package com.yanxi.anim.sys.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient1;
import org.springframework.web.multipart.MultipartFile;

public class FastdfsWebUtils {
	private static Logger logger = Logger.getLogger(FastdfsWebUtils.class);

	/**
	 * 上传文件，获取文件id
	 * 
	 * @param multipartFile
	 * @return
	 */
	public static String uploadFile(MultipartFile multipartFile) {
		logger.info("=====FastdfsUtils uploadFile multipartFile=========");
		StorageClient1 storageClient = FastdfsUtils.getStorageClient();
		InputStream inputStream;
		String upload_file1 = null;
		try {
			inputStream = multipartFile.getInputStream();
			byte[] file_buff = IOUtils.toByteArray(inputStream);
			String originalFilename = multipartFile.getOriginalFilename();
			logger.info("originalFilename:" + originalFilename.substring(0, originalFilename.lastIndexOf(".")));
			String file_ext_name = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			logger.info("file_ext_name:" + file_ext_name);
			NameValuePair[] meta_list = createNameValuePairs(multipartFile);
			logger.info(meta_list[0].getValue());
			upload_file1 = storageClient.upload_file1(file_buff, file_ext_name, meta_list);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return upload_file1;
	}

	/**
	 * 获取上传文件的原始数据，并保存到NameValuePair
	 * 
	 * @param file
	 * @return
	 */
	private static NameValuePair[] createNameValuePairs(MultipartFile file) {
		logger.info("=====FastdfsUtils createNameValuePairs=========");
		Map<String, String> metaMaps = new HashMap<>();
		metaMaps.put("fileName", file.getOriginalFilename());
		metaMaps.put("size", "" + file.getSize());
		metaMaps.put("contentType", file.getContentType());
		NameValuePair[] nameValuePairs = new NameValuePair[metaMaps.size()];
		Iterator<Entry<String, String>> iterator = metaMaps.entrySet().iterator();
		int index = 0;
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			NameValuePair nameValuePair = new NameValuePair(entry.getKey(), entry.getValue());
			nameValuePairs[index] = nameValuePair;
			index++;
		}
		return nameValuePairs;
	}

	/**
	 * 根据fileId，获取上传文件的原始数据信息，并保存至map中
	 * 
	 * @param file_id
	 * @return
	 */
	public static Map<String, String> getMeta_list(String file_id) {
		logger.info("=====FastdfsUtils getMeta_list=========");
		Map<String, String> map = new HashMap<>();
		StorageClient1 storageClient = FastdfsUtils.getStorageClient();
		try {
			NameValuePair[] pairs = storageClient.get_metadata1(file_id);
			for (NameValuePair nameValuePair : pairs) {
				map.put(nameValuePair.getName(), nameValuePair.getValue());
			}
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		return map;
	}

}
