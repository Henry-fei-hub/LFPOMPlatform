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

import com.pomplatform.db.dao.OutQuotation;
public class UploadImage implements GenericUploadProcessor {
    private static final Logger __logger = Logger.getLogger(UploadImage.class);

    @Override
    public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
        ThreadConnection.beginTransaction();
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String infoCode,quotationNumber,quotationName;
        int outQuotationId=BaseHelpUtils.getIntValue(param, "outQuotationId");
        infoCode= BaseHelpUtils.getStringValue(param, "infoCode");
        quotationNumber = BaseHelpUtils.getStringValue(param, "quotationNumber");
        quotationName = BaseHelpUtils.getStringValue(param, "quotationName");
        
        
        
        String pathName = ThreadUtil.getQuotationNameFilePath(infoCode);
        File path = new File(pathName);
        if (!path.exists()) {
            path.mkdirs();
        }
        String imageUrl = "";
        for (FileItem fileItem : items) {
        	
        	String fileItemName = fileItem.getName();
            String fileext = fileItemName.substring(fileItemName.lastIndexOf(".") + 1);
            //文件名
            String fileName = ThreadUtil.getImageFile(fileext,infoCode);
            
            String url = path.getAbsolutePath() + "/" + fileName;
            //创建文件
            File fullName = new File(url);
            //文件的路劲
            String filePath = ThreadUtil.getInfoCodeFilePath(infoCode);
            imageUrl = filePath + "/" + fileName;
            fileItem.write(fullName);
        }
        
        //上传图片
        OutQuotation outDao=new OutQuotation();
        outDao.setOutQuotationId(outQuotationId);
        if(outDao.load()){
        	outDao.setQuotationFiles(imageUrl);
        	outDao.update();
        }
         
        BaseCollection bc = new BaseCollection();
        ThreadConnection.commit();
        return bc.toJSON(0, null);
    }
    
}
