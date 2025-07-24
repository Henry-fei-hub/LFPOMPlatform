package pomplatform.employeeintegralReturn.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.SystemConfig;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.employeeSalary.bean.BaseEmployeeSalaryDetailMonth;

public class EmployeeIntegralReturnProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
			StringBuilder sql = new StringBuilder();
			if(!BaseHelpUtils.isNullOrEmpty(params.get("startDate"))){
				Date startDate = new Date(BaseHelpUtils.getLongValue(params.get("startDate")));
				sql.append(BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE).append(" >= '").append(startDate).append("'");
			}
			if(!BaseHelpUtils.isNullOrEmpty(params.get("endDate"))){
				Date endDate = new Date(BaseHelpUtils.getLongValue(params.get("endDate")));
				if(sql.length()>0){
					sql.append(" and ");
				}
				sql.append(BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE).append(" <= '").append(endDate).append("'");
			}
			sql.append(" order by ").append(BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE);
			EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
			dao.setConditionEmployeeId("=", employeeId);
	        List<BaseEmployeeAchieveIntegralReturnRecord> list = dao.conditionalLoad(sql.toString());
			bc.setCollections(list);
	        return bc.toJSON();
		}
		return bc.toJSON(-1,"参数不能为空");
	}

}
