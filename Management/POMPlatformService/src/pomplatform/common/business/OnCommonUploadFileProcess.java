package pomplatform.common.business;

import java.io.File;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericUploadProcessor;
import delicacy.connection.ThreadUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 
 * @author 
 */
public class OnCommonUploadFileProcess implements GenericUploadProcessor {
    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //
    private static final String ON_UPLOAD_ONBOARD_ATTACHMENTS = "onUploadOnboardAttachments";
    
    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_UPLOAD_ONBOARD_ATTACHMENTS.equals(optType)){
        	return onUploadOnboardAttachments(param,items);
        }
        return null;
    }

	private String onUploadOnboardAttachments(Map<String, Object> param, List<FileItem> items) throws Exception {
		String path = BaseHelpUtils.getStringValue(param,"path");
		String basePath = ThreadUtil.getRealPath();
        if (basePath == null) {
            basePath = "/temp";
        }
        basePath = basePath + path;
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
            fileUrl = fileUrl.substring(fileUrl.lastIndexOf(path));
            fileItem.write(fullName);
        }
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        Map<String,Object> backResult = new HashMap<>();
        backResult.put("fileUrl",fileUrl);
        bc.setUserData(backResult);
        return bc.toJSON(0,"操作失败");
	}

    
    

}
