package pomplatform.cwd.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCompanyWorkplace;
import com.pomplatform.db.bean.BaseCompanyWorkplaceFile;
import com.pomplatform.db.bean.BaseCompanyWorkplacePendingDownloadFile;
import com.pomplatform.db.bean.BaseCwdFile;
import com.pomplatform.db.dao.CompanyWorkplace;
import com.pomplatform.db.dao.CompanyWorkplaceFile;
import com.pomplatform.db.dao.CompanyWorkplacePendingDownloadFile;
import com.pomplatform.db.dao.CwdFile;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;

public class CompanyWorkplaceProcessor implements GenericProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    //初始化服务器
    private static final String INIT_SERVER = "initServer";
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params,OPT_TYPE);
        if(INIT_SERVER.equals(optType)){
        	return initServer(params);
        }
        return null;
    }
    
    /**
     * 初始化服务器
     * @param params
     * @return
     * @throws Exception
     */
	public String initServer(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	String idStr = BaseHelpUtils.getString(params.get("workplaceIds"));
    	if(BaseHelpUtils.isNullOrEmpty(idStr)) {
    		return bc.toJSON(-1, "请选择需要初始化的服务器");
    	}
    	int companyNo = BaseHelpUtils.getIntValue(params.get("companyNo"));
    	if(companyNo <= 0) {
    		return bc.toJSON(-1, "服务器的归属公司为空，无法初始化");
    	}
    	CwdFile fileDao = new CwdFile();
    	fileDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
    	fileDao.setConditionCompanyNo("=", companyNo + "");
    	List<BaseCwdFile> list = fileDao.conditionalLoad();
    	if(list.isEmpty()) {
    		return bc.toJSON(0, "没有文件需要同步");
    	}
    	String[] idStrArr = idStr.split(",");
    	int length = idStrArr.length;
    	Integer[] idArr = new Integer[length];
    	for(int i = 0; i < length; i++) {
    		idArr[i] = BaseHelpUtils.getIntValue(idStrArr[i]);
    	}
    	List<BaseCompanyWorkplacePendingDownloadFile> downloadList = new ArrayList<>();
    	CompanyWorkplaceFile cwfDao = new CompanyWorkplaceFile();
    	cwfDao.unsetSelectFlags();
    	cwfDao.setSelectWorkplaceId(true);
    	BaseCompanyWorkplacePendingDownloadFile bean = new BaseCompanyWorkplacePendingDownloadFile();
    	bean.setDeleteFlag(StaticUtils.NO_DELETE);
    	bean.setCreateTime(new Date());
    	bean.setStatus(1);//刚创建
    	for(BaseCwdFile file : list) {
    		cwfDao.clearConditions();
    		cwfDao.setConditionCwdFileId("=", file.getCwdFileId());
    		cwfDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
    		BaseCompanyWorkplaceFile cwfBean = cwfDao.executeQueryOneRow();
    		if(null == cwfBean || null == cwfBean.getWorkplaceId()) {
    			continue;
    		}
    		bean.setSrcWorkplaceId(cwfBean.getWorkplaceId());
    		bean.setCwdFileId(file.getCwdFileId());
    		for(Integer id : idArr) {
    			BaseCompanyWorkplacePendingDownloadFile tempBean = new BaseCompanyWorkplacePendingDownloadFile();
    			bean.cloneCopy(tempBean);
    			tempBean.setWorkplaceId(id);
    			downloadList.add(tempBean);
        	}
    	}
    	if(downloadList.isEmpty()) {
    		return bc.toJSON(0, "没有文件需要同步");
    	}
    	ThreadConnection.beginTransaction();
    	CompanyWorkplacePendingDownloadFile cwpdfDao = new CompanyWorkplacePendingDownloadFile();
    	cwpdfDao.save(downloadList);
    	CompanyWorkplace cwDao = new CompanyWorkplace();
    	cwDao.addCondition(BaseCompanyWorkplace.CS_COMPANY_WORKPLACE_ID, "in", (Object[]) idArr);
    	cwDao.setHasInit(true);
    	cwDao.conditionalUpdate();
    	ThreadConnection.commit();
    	return bc.toJSON(0, null);
	}
}
