package pomplatform.ht.handler;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericUploadProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.connection.ThreadUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.File;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import com.pomplatform.db.dao.Contract;
public class UploadServiceFiles implements GenericUploadProcessor {
    private static final Logger __logger = Logger.getLogger(UploadServiceFiles.class);

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        ThreadConnection.beginTransaction();
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        
        int contractId = BaseHelpUtils.getIntValue(param, "contractId");
        String contractName = BaseHelpUtils.getStringValue(param, "contractName");
        
        String pathName = ThreadUtil.getFilePath();
        File path = new File(pathName);
        if (!path.exists()) {
            path.mkdirs();
        }
        String fileUrl = "";
        for (FileItem fileItem : items) {
        	
        	String fileItemName = fileItem.getName();
            String fileext = fileItemName.substring(fileItemName.lastIndexOf(".") + 1);
            //文件名
            String fileName = ThreadUtil.getFormalContractFile(fileext);
            
            String url = path.getAbsolutePath() + "/" + fileName;
            //创建文件
            File fullName = new File(url);
            //文件的路劲
            String filePath = ThreadUtil.getFormalContractFilePath();
            fileUrl = filePath + "/" + fileName;
            fileItem.write(fullName);
        }
        
        //上传文件
        Contract fc=new Contract();
        fc.setContractId(contractId);
        if(fc.load()){
        	fc.setServiceSuggestBook(fileUrl);
        	fc.update();
        }
         
        BaseCollection bc = new BaseCollection();
        ThreadConnection.commit();
        return bc.toJSON(0, null);
    }
    
}
