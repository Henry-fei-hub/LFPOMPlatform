package pomplatform.common.business;

import java.io.File;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.connection.ThreadUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 *
 * @author Administrator
 */
public class OnUploadPersonnelBusinessAttachments implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadPersonnelBusinessAttachments.class);
    private static final String IMAGE_PATH = "/files/personnelBusiness/";

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String basePath = ThreadUtil.getRealPath();
        if (basePath == null) {
            basePath = "/temp";
        }
        basePath = basePath + IMAGE_PATH;
        if(!BaseHelpUtils.isNullOrZero(param.get("employeeId"))){
        	basePath = basePath + param.get("employeeId") + ("/");
        }
        File baseFile = new File(basePath);
        if (!baseFile.exists()) {
            baseFile.mkdirs();
        }
        String fileUrl = "";
        for (FileItem fileItem : items) {
            String fileName = fileItem.getName();
            String fileext = fileName.substring(fileName.lastIndexOf(".") + 1);
            File fullName = new File(basePath + UUID.randomUUID().toString().replaceAll("-", "")+ "." + fileext);
            fileUrl = fullName.getAbsolutePath().replaceAll("\\\\", "/");
            fileUrl = fileUrl.substring(fileUrl.lastIndexOf(IMAGE_PATH));
            fileItem.write(fullName);
        }
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(0, fileUrl);
    }
}
