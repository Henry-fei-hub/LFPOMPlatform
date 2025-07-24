package pomplatform.workflow.handler;

import com.file.db.bean.BaseFileManage;
import com.file.db.dao.FileManage;
import com.pomplatform.db.bean.BaseCwdTaskTemplate;
import com.pomplatform.db.bean.BaseExchangeRate;
import com.pomplatform.db.bean.BaseFileManagesWatermark;
import com.pomplatform.db.dao.FileManagesWatermark;
import delicacy.common.*;
import delicacy.connection.ThreadUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.StringReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import delicacy.common.GenericProcessor;
import delicacy.common.GenericUploadProcessor;

public class FileManagesWatermarkProcess implements GenericProcessor {

	private static final Logger __logger = Logger.getLogger(FileManagesWatermarkProcess.class);

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, "optType");
			switch (optType) {
				case "ST_FileManagesWatermark":
					return find(params);
		}
		return null;
	}

	private String find(Map<String, Object> result) throws Exception{
		int employeeId =  BaseHelpUtils.getIntValue(result, "employeeId");
		int fileType =  BaseHelpUtils.getIntValue(result, "fileType");
		String targetImg = BaseHelpUtils.getStringValue(result,"fileUrl");

		if(!BaseHelpUtils.isNullOrEmpty(employeeId) && !BaseHelpUtils.isNullOrEmpty(fileType) ){
			FileManagesWatermark watermark = new FileManagesWatermark();
			watermark.setConditionEmployeeId("=", employeeId);
			watermark.setConditionFileType("=", fileType);
			BaseFileManagesWatermark baseFileManagesWatermark = watermark.executeQueryOneRow();
			if(null!=baseFileManagesWatermark){
				FileManage fileManage = new FileManage();
				fileManage.setConditionFileId("=",baseFileManagesWatermark.getFileId());
				BaseFileManage baseFileManage = fileManage.executeQueryOneRow();

				BaseCollection<BaseFileManage> bc = new BaseCollection<>();
				List<BaseFileManage> list = new ArrayList<>();
				list.add(baseFileManage);
				bc.setCollections(list);
				return bc.toJSON();
			}else {
				float alpha = 0.2f;
				int x = 0;
				int y = 1;
				String url = ThreadUtil.getRealPath();
				File file = new File(url+targetImg);
				java.awt.Image image = ImageIO.read(file);
				int width = image.getWidth(null);
				int height = image.getHeight(null);
				// 将目标图片加载到内存。
				BufferedImage bufferedImage = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g = bufferedImage.createGraphics();
				g.drawImage(image, 0, 0, width, height, null);
				// 加载水印图片。
				java.awt.Image waterImage = ImageIO.read(new File(url + "/images/companyLogo/JA.png"));
				int width_1 = waterImage.getWidth(null);
				int height_1 = waterImage.getHeight(null);
				// 设置水印图片的透明度。
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
						alpha));

				// 设置水印图片的位置。
				int widthDiff = width - width_1;
				int heightDiff = height - height_1;
				if (x < 0) {
					x = widthDiff / 2;
				} else if (x > widthDiff) {
					x = widthDiff;
				}
				if (y < 0) {
					y = heightDiff / 2;
				} else if (y > heightDiff) {
					y = heightDiff;
				}

				// 将水印图片“画”在内存的图片的制定位置。
				g.drawImage(bufferedImage, x, y, width_1, height_1, null);
				// 关闭画笔。
				g.dispose();
//			File out = new File(file.getPath());
//			//将图片写入ImageIO流
//			try {
//				BufferedImage img = ImageIO.read(out);
//				//将图片写出到指定位置（复制图片）
//				OutputStream ops = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\1.png"));
//				ImageIO.write(img, "jpg", ops);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
				// 保存目标图片。


				String path = "/files/watermark/";
				SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");
				String files = SDF.format(new Date()) + "_" + Math.random() * (9999) + ".pdf";//生成随机文件名

				ImageIO.write(bufferedImage, "JPG",new File(url+path+files));


				FileManage fmDao = new FileManage();
				fmDao.setFileUrl(path+files);
				fmDao.save();

				FileManagesWatermark wfwDao = new FileManagesWatermark();
				wfwDao.setFileId(fmDao.getFileId());
				wfwDao.setEmployeeId(employeeId);
				wfwDao.setFileType(fileType);
				wfwDao.save();

				BaseFileManage baseFileManage = new BaseFileManage();
				baseFileManage.setFileUrl(fmDao.getFileUrl());

				BaseCollection<BaseFileManage> bc = new BaseCollection<>();
				List<BaseFileManage> list = new ArrayList<>();
				list.add(baseFileManage);
				bc.setCollections(list);
				return bc.toJSON();

			}
		}

		return null;
	}


}


