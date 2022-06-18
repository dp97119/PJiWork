package tw.com.ourProject.utils;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

@Component
public class UploadFileUtil {
	private final static String FILE_UPLOAD_PATH_FINAL = "/src/main/resources/static/img/userPhoto/";

	public String uploadUserPhoto(MultipartFile multipartFile , String empId) {
		JSONObject obj = new JSONObject();
		if (multipartFile.isEmpty()) {
			return "沒有資料";
		}
		String fileName = empId + ".jpg";
		try {
			File photo = new File(System.getProperty("user.dir") + FILE_UPLOAD_PATH_FINAL + fileName);
			if (!photo.getParentFile().exists()) {
				photo.getParentFile().mkdir();
			}
			multipartFile.transferTo(photo);
			return "/img/userPhoto/"+fileName;
		} catch (Exception e) {
			return e.toString();
		

		}
	}


}
