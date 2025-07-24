package pomplatform.projectEmployee.business;

import java.io.StringReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;

public class ProjectEmployeeProcessor implements GenericProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params,OPT_TYPE);
        switch(optType) {
        case "agreeProjectEmployee":
        	return agreeProjectEmployee(params);
        case "disagreeProjectEmployee":
        	return disagreeProjectEmployee(params);
    	default:
    		return null;
        }
    }
    
    public String agreeProjectEmployee(Map<String, Object> params) throws Exception {
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	String idStr = BaseHelpUtils.getString(params.get("id"));
    	if(BaseHelpUtils.isNullOrEmpty(idStr)) {
    		return bc.toJSON(-1, "请选择需要同意的数据");
    	}
    	String[] idStrArr = idStr.split(",");
    	int length = idStrArr.length;
    	Integer[] idArr = new Integer[length];
    	for(int i = 0; i < length; i++) {
    		idArr[i] = BaseHelpUtils.getIntValue(idStrArr[i]);
    	}
    	ProjectEmployee dao = new ProjectEmployee();
    	dao.addCondition(BaseProjectEmployee.CS_PROJECT_EMPLOYEE_ID, "in", (Object[])idArr);
    	dao.setFlag(StaticUtils.PROJECT_EMPLOYEE_FLAG_2);
    	dao.conditionalUpdate();
    	return bc.toJSON();
    }
    
    public String disagreeProjectEmployee(Map<String, Object> params) throws Exception {
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	String idStr = BaseHelpUtils.getString(params.get("id"));
    	if(BaseHelpUtils.isNullOrEmpty(idStr)) {
    		return bc.toJSON(-1, "请选择需要删除的数据");
    	}
    	String[] idStrArr = idStr.split(",");
    	int length = idStrArr.length;
    	Integer[] idArr = new Integer[length];
    	for(int i = 0; i < length; i++) {
    		idArr[i] = BaseHelpUtils.getIntValue(idStrArr[i]);
    	}
    	ProjectEmployee dao = new ProjectEmployee();
    	dao.addCondition(BaseProjectEmployee.CS_PROJECT_EMPLOYEE_ID, "in", (Object[])idArr);
    	dao.conditionalDelete();
    	return bc.toJSON();
    }
}
