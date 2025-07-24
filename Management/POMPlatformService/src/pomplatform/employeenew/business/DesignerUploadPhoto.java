package pomplatform.employeenew.business;

import java.io.File;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.connection.ThreadUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 *
 * @author Administrator
 */
public class DesignerUploadPhoto implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(DesignerUploadPhoto.class);
    private static final String IMAGE_PATH = "/images/photos";

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String employeeId = (String) param.get("employeeId");
        String employeeNo = (String) param.get("employeeNo");
        String basePath = ThreadUtil.getRealPath();
        if (basePath == null) {
            basePath = "/temp";
        }
        basePath = basePath + IMAGE_PATH;
        File baseFile = new File(basePath);
        if (!baseFile.exists()) {
            baseFile.mkdirs();
        }
        String photoUrl = "";
        for (FileItem fileItem : items) {
            String fileName = fileItem.getName();
            String fileext = fileName.substring(fileName.lastIndexOf(".") + 1);
            File tempFileName = File.createTempFile(employeeNo + "_photo_", "", baseFile);
            String url = tempFileName.getAbsolutePath() + "." + fileext;
            File fullName = new File(url);
            photoUrl = url.substring(url.lastIndexOf("photos") + 7);
            tempFileName.delete();
            fileItem.write(fullName);
        }
        //更新头像
        Employee dao = new Employee();
        dao.setEmployeeId(BaseHelpUtils.getIntValue(employeeId));
        dao.load();
        dao.setPhoto(photoUrl);
        dao.update();
        BaseEmployee bean = dao.generateBase();
        bean.setPhoto(IMAGE_PATH+"/"+photoUrl);
        return bean.toOneLineJSON(0, null);
    }
}
