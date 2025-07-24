package pomplatform.common.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployee;
import com.pomplatform.db.dao.Employee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 公用的自定义下拉process
 * @author lxf
 */
public class OnCommonCustomSelectProcess implements GenericProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        switch (optType) {
		case "employees":
			return onLoadEmployee(param);
		default:
			return null;
		}
    }

    /**
     * 加载成员下拉
     * @param params
     * @return
     * @throws SQLException
     */
    public String onLoadEmployee(Map params) throws SQLException {
        Map<Integer, String> userData = new HashMap<>();
        Employee dao = new Employee();
        dao.unsetSelectFlags();
        dao.setSelectEmployeeId(true);
        dao.setSelectEmployeeName(true);
        dao.setSelectEmployeeNo(true);
        dao.setConditionEmployeeId(">", 0);
        List<BaseEmployee> list = dao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
        	for(BaseEmployee e : list) {
        		int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
        		String employeeNo = BaseHelpUtils.getString(e.getEmployeeNo());
        		String employeeName = BaseHelpUtils.getString(e.getEmployeeName());
        		String name = String.format("%1$s--%2$s", employeeNo,employeeName);
        		userData.put(empId, name);
        	}
        }
        BaseCollection<GenericBase> result = new BaseCollection<>();
        result.setUserData(userData);
        return result.toJSON();
    }
}
