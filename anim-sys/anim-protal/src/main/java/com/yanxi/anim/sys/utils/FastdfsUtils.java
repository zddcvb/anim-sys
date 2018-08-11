package com.yanxi.anim.sys.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastdfsUtils {
	private static String config = "client.conf";
	private static Logger logger = Logger.getLogger(FastdfsUtils.class);

	public static StorageClient1 getStorageClient() {
		logger.info("=====FastdfsUtils getStorageClient=========");
		URL url = FastdfsUtils.class.getClassLoader().getResource(config);
		String conf = url.toString();
		conf = conf.substring(conf.indexOf("/") + 1);
		logger.info("fastdfs client config:" + conf);
		StorageClient1 storageClient1 = null;
		try {
			ClientGlobal.init(conf);
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
			storageClient1 = new StorageClient1(trackerServer, storageServer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return storageClient1;
	}

	/**
	 * 下载文件，传递数据
	 * 
	 * @param file
	 * @return
	 */
	public static String uploadFile(File file) {
		logger.info("=====FastdfsUtils uploadFile=========");
		Map<String, String> map = new HashMap<String, String>();
		String fileName = file.getName();
		map.put("fileName", fileName.substring(0, fileName.lastIndexOf(".")));
		map.put("size", file.getFreeSpace() + "");
		return uploadFile(file, map);
	}

	/**
	 * 上传文件，获取上传文件的id
	 * 
	 * @param file
	 * @return
	 */
	public static String uploadFile(File file, Map<String, String> map) {
		logger.info("=====FastdfsUtils uploadFile  map=========");
		StorageClient1 storageClient = getStorageClient();
		byte[] file_buff;
		String file_ext_name = file.getName().substring(file.getName().lastIndexOf(".") + 1);
		try {
			file_buff = IOUtils.toByteArray(new FileInputStream(file));
			NameValuePair[] meta_list = new NameValuePair[map.size()];
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Entry<String, String> next = iterator.next();
				NameValuePair nameValuePair = new NameValuePair();
				String key = next.getKey();
				String value = next.getValue();
				nameValuePair.setName(key);
				nameValuePair.setValue(value);
				meta_list[i] = nameValuePair;
				i++;
			}
			logger.info("file_ext_name:" + file_ext_name);
			String fileId = storageClient.upload_file1(file_buff, file_ext_name, meta_list);

			return fileId;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 下载文件，根据fileId
	 * 
	 * @param fileId
	 * @return
	 */
	public static void downLoadFile(String fileId, File baseFile) {
		logger.info("=====FastdfsUtils downLoadFile=========");
		StorageClient1 storageClient = getStorageClient();
		String local_filename = null;
		try {
			byte[] buffer = storageClient.download_file1(fileId);
			logger.info(buffer != null);
			if (buffer != null) {
				local_filename = getFileNameFromFDFS(fileId, storageClient, local_filename);
			}
			if (!baseFile.exists()) {
				baseFile = new File("d:/load");
				baseFile.mkdir();
			}
			File filePath = new File(baseFile, "/" + local_filename + ".fla");
			logger.info("filePath:" + filePath.getAbsolutePath());
			IOUtils.write(buffer, new FileOutputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public static void downLoadFileForBrown(String fileId, HttpServletResponse response) {
		logger.info("=====FastdfsUtils downLoadFile=========");
		StorageClient1 storageClient = getStorageClient();
		String local_filename = null;
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			byte[] buffer = storageClient.download_file1(fileId);
			logger.info(buffer != null);
			if (buffer != null) {
				local_filename = getFileNameFromFDFS(fileId, storageClient, local_filename);
			}
			// 下载
			// response.reset();
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String((local_filename + ".fla").getBytes(), "iso8859-1"));
			ServletOutputStream out = response.getOutputStream();
			bos = new BufferedOutputStream(out);
			bis = new BufferedInputStream(new ByteArrayInputStream(buffer));
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = bis.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String getFileNameFromFDFS(String fileId, StorageClient1 storageClient, String local_filename)
			throws IOException, MyException {
		NameValuePair[] nameValuePairs = storageClient.get_metadata1(fileId);
		logger.info(nameValuePairs.length);
		for (NameValuePair nameValuePair : nameValuePairs) {
			String name = nameValuePair.getName();
			logger.info("name:" + name);
			if ("fileName".equals(name)) {
				local_filename = nameValuePair.getValue();
				break;
			}
		}
		return local_filename;
	}

	/**
	 * 删除数据
	 * 
	 * @param fileId
	 */
	public static void delete(String fileId) {
		logger.info("=====FastdfsUtils delete=========");
		StorageClient1 storageClient = getStorageClient();
		try {
			storageClient.delete_file1(fileId);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
	}

}
