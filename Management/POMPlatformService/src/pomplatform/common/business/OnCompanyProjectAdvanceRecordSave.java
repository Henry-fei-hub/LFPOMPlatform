package pomplatform.common.business;

import java.io.StringReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAdvanceRecord;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 保存公司对项目的补贴积分
 * @author 
 */
public class OnCompanyProjectAdvanceRecordSave implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	ThreadConnection.beginTransaction();
    	JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
    	//获取项目关联的业务部门
    	Project pdao = new Project();
    	int projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
    	pdao.setProjectId(projectId);
    	if(pdao.load()){
    		int plateId = pdao.getPlateId();
    		//保存项目补贴记录表的数据
    		BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
    		bean.setDataFromJSON(creteria);
    		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
    		bean.setAdvanceDate(new Date());
    		bean.setPlateId(plateId);
    		dao.setDataFromBase(bean);
    		dao.save();
    		ThreadConnection.commit();
    		return dao.generateBase().toOneLineJSON(0, null);
    	}
    	return null;
    }

}
