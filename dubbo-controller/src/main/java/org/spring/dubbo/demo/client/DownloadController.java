/**
 * 
 */
package org.spring.dubbo.demo.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于资源下载的Controller
 * 
 * @author LiuJian
 *
 */
@Controller
public class DownloadController {
	private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);

	public DownloadController() {
		logger.info("DownloadController is init.");
	}

	/**
	 * 解决PathVariable 遇到.隔断的方案: 1. 在后面加反斜线/ 证明可以解决问题 2. {filename:.+}使用正则表达式
	 */
	@RequestMapping("/download/{filename:[^/]+}")
	public void download(@PathVariable("filename") String fileName, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info(fileName);
		File file = getFile(fileName, request);
		if (file != null) {
			doOutput(file, fileName, response);
		} else {
			response.setStatus(404);
		}
	}

	/**
	 * 输出文件
	 * 
	 * @param file
	 * @param fileName
	 * @param response
	 */
	private void doOutput(File file, String fileName, HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		String value = "attachment;filename=" + fileName + "\"";
		logger.info(value);
		response.addHeader("Content-Disposition", value);

		try (OutputStream output = response.getOutputStream();
				InputStream input = new BufferedInputStream(FileUtils.openInputStream(file));) {
			IOUtils.copy(input, output);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取资源指定位置的File
	 * 
	 * @param fileName
	 *            文件名称
	 * @return 文件
	 */
	private File getFile(String fileName, HttpServletRequest request) {
		String dir = request.getServletContext().getRealPath("/resources/");
		File file = new File(dir, fileName);
		if (file.exists() && file.isFile()) {
			return file;
		} else {
			return null;
		}
	}

}
