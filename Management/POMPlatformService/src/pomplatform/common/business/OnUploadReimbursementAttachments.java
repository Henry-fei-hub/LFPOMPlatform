package pomplatform.common.business;

import com.pomplatform.db.bean.BaseProjectAttachment;
import com.pomplatform.db.dao.ProjectAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.connection.ThreadUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.File;
import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class OnUploadReimbursementAttachments implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUploadReimbursementAttachments.class);
    private static final String IMAGE_PATH = "/files/reimbursementAttachments/";

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String basePath = ThreadUtil.getRealPath();
        if (basePath == null) {
            basePath = "/temp";
        }
        basePath = basePath + IMAGE_PATH;
        File baseFile = new File(basePath);
        if (!baseFile.exists()) {
            baseFile.mkdirs();
        }
        String fileUrl = "";
        for (FileItem fileItem : items) {
            String fileName = fileItem.getName();
            String fileext = fileName.substring(fileName.lastIndexOf(".") + 1);
            File tempFileName = File.createTempFile(UUID.randomUUID().toString().replaceAll("-", ""), "", baseFile);
            String url = tempFileName.getAbsolutePath() + "." + fileext;
            File fullName = new File(url);
            fileUrl = url.substring(url.lastIndexOf("reimbursementAttachments") + 25);
            tempFileName.delete();
            fileItem.write(fullName);
        }
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(0, IMAGE_PATH+fileUrl);
    }
}
