package pomplatform.common.business;

import com.pomplatform.db.bean.BaseProjectAttachment;
import com.pomplatform.db.dao.ProjectAttachment;
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
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class OnUpdateProjectAttachment implements GenericUploadProcessor {

    private static final Logger __logger = Logger.getLogger(OnUpdateProjectAttachment.class);
    private static final String IMAGE_PATH = "/files/projectAttachments/";

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
        int stageId = BaseHelpUtils.getIntValue(param.get("stageId"));
        String remark = BaseHelpUtils.getString(param.get("remark"));
        Long timestamp = BaseHelpUtils.getLongValue(param.get("timestamp"));
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
            File tempFileName = File.createTempFile("projectAttachment_" + projectId + "_" + stageId + "_", "", baseFile);
            String url = tempFileName.getAbsolutePath() + "." + fileext;
            File fullName = new File(url);
            fileUrl = url.substring(url.lastIndexOf("projectAttachments") + 19);
            tempFileName.delete();
            fileItem.write(fullName);
        }
        //向表中插入记录
        ProjectAttachment dao = new ProjectAttachment();
        BaseProjectAttachment bean = new BaseProjectAttachment();
        bean.setProjectId(projectId);
        bean.setStageId(stageId);
        bean.setUploadTime(new Date(timestamp));
        bean.setAttachmentFile(IMAGE_PATH+fileUrl);
        bean.setRemark(remark);
        dao.setDataFromBase(bean);
        dao.save();
        return bean.toOneLineJSON(0, null);
    }
}
