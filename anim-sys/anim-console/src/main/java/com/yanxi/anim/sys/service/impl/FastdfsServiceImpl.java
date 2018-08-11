package com.yanxi.anim.sys.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.service.AnimResCatagortyService;
import com.yanxi.anim.sys.service.AnimResService;
import com.yanxi.anim.sys.service.FastdfsService;
import com.yanxi.anim.sys.utils.CommonUtil;
import com.yanxi.anim.sys.utils.DateFormate;
import com.yanxi.anim.sys.utils.FastdfsUtils;
import com.yanxi.anim.sys.utils.FastdfsWebUtils;
import com.yanxi.anim.sys.utils.IdGeneratorUtils;

@Service
public class FastdfsServiceImpl implements FastdfsService {
	@Autowired
	private AnimResCatagortyService animResCatagortyService;
	@Autowired
	private AnimResService animResService;
	private List<AnimRes> res = new ArrayList<AnimRes>();

	private static Logger logger = Logger.getLogger(FastdfsServiceImpl.class);
	@Value("${FDFS_URL}")
	public String fdfsUrl;

	/**
	 * 上传文件，并获取相关信息
	 */
	@Override
	public List<AnimRes> uploadFile(File file) {

		logger.info("=========FastdfsServiceImpl uploadFile===========");
		if (file.exists()) {
			File[] listFiles = file.listFiles();
			for (File listFile : listFiles) {
				AnimRes animRes = new AnimRes();
				if (listFile.isFile()) {
					String resName = listFile.getName();
					// String resUpdatetime =
					// CommonUtil.formatTime(listFile.lastModified());
					String resCreatetime = CommonUtil.getCreateTime(listFile);
					String path = listFile.getAbsolutePath();
					// 上传jpg和fla，只判断jpg，然后通过路径后缀替换，动态生成fla地址，同步上传，分别获得两者的url
					if (path.endsWith(".jpg")) {
						String resReviewUrl = FastdfsUtils.uploadFile(listFile);
						String flaUrl = path.replace(".jpg", ".fla");
						File flaFile = new File(flaUrl);
						if (!flaFile.exists()) {
							continue;
						}
						long resSize = flaFile.length();
						animRes.setResSize(CommonUtil.getDataSize(resSize));
						String resUrl = FastdfsUtils.uploadFile(new File(flaUrl));
						logger.info("resReviewUrl:" + resReviewUrl);
						logger.info(flaUrl + ":" + resUrl);
						animRes.setResUrl(resUrl);
						animRes.setResReviewUrl(resReviewUrl);
					} else {
						continue;
					}
					String parentName = listFile.getParentFile().getName();
					// 获取素材分类的id,如果存在，则设置分类的id，如果不存在，则设置为null
					AnimResCatagorty animResCatagorty = animResCatagortyService.findByName(parentName);
					if (animResCatagorty != null) {
						animRes.setResCatagortyId(animResCatagorty.getResCatagortyId());
					} else {
						animRes.setResCatagortyId(null);
					}
					// 判断数据表中是否存在相同的resName，如果存在，则不写入，如果不存在，则写入
					AnimRes oldRes = animResService.findByName(resName);
					if (oldRes != null) {
						continue;
					}
					animRes.setResName(resName.substring(0, resName.lastIndexOf(".")));
					animRes.setIsdeleted(false);
					animRes.setResCreatetime(resCreatetime);
					animRes.setResUpdatetime(DateFormate.formateDateToString(new Date()));

					animRes.setResId(IdGeneratorUtils.generatorUUID());
					res.add(animRes);
				} else {
					File[] listFiles2 = listFile.listFiles();
					if (listFiles2 == null) {
						continue;
					} else {
						uploadFile(listFile);
					}
				}
			}
		}
		return res;
	}

	@Override
	public String uploadFile(MultipartFile multipartFile) {
		String uploadFile = FastdfsWebUtils.uploadFile(multipartFile);
		return uploadFile;
	}

	@Override
	public void downLoadFile(String fileId, File outFile) {
		FastdfsUtils.downLoadFile(fileId, outFile);
		;
	}

	/**
	 * 清理缓存
	 */
	public void clearCache() {
		if (res != null) {
			res.clear();
			res = new ArrayList<>();
		}
	}

	@Override
	public Map<String, String> getByFileId(String file_id) {
		return FastdfsWebUtils.getMeta_list(file_id);
	}

	@Override
	public long getSizeByFileId(String file_id) {
		Map<String, String> meta_list = FastdfsWebUtils.getMeta_list(file_id);
		String size = (String) meta_list.get("size");
		if (size == null) {
			return 0;
		}
		return Long.parseLong(size);
	}

	@Override
	public void deleteById(String file_id) {
		FastdfsUtils.delete(file_id);
	}

	@Override
	public void updateBatch(File file) {
		if (file.exists()) {
			File[] listFiles = file.listFiles();
			if (listFiles != null) {
				for (File listFile : listFiles) {
					if (listFile.isFile() && listFile.getAbsolutePath().endsWith(".jpg")) {
						AnimRes animRes = new AnimRes();
						String name = listFile.getName();
						String parentName = listFile.getParentFile().getName();
						AnimResCatagorty resCatagorty = animResCatagortyService.findByName(parentName);
						if (resCatagorty==null) {
							return;
						}
						name = name.substring(0, name.lastIndexOf("_"));
						animRes.setResName(name);
						String file_id = FastdfsUtils.uploadFile(listFile);
						animRes.setResViewUrl(file_id);
						animResService.updateByName(animRes,resCatagorty.getResCatagortyId());
					} else {
						updateBatch(listFile);
					}
				}
			}
		}
	}

}
