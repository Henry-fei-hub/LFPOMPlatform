package pomplatform.employeenew.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;
import pomplatform.analysisemployee.bean.BaseEmployeeProjectAnalysis;
import pomplatform.analysisemployee.bean.ConditionEmployeeProjectAnalysis;
import pomplatform.analysisemployee.query.QueryEmployeeProjectAnalysis;

/**
 * 获取设计师项目和积分
 *
 * @author lxf
 */
public class DesignerGetMsg implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取当前登录人ID
        int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
        int runProjectNum = 0;//正在运行的项目数
        int finishProjectNum = 0;//已经完成的项目数
        int planIntegral = 0;//预分配获得积分
        int realIntegral = 0;//实际获得积分
        ProjectEmployee dao = new ProjectEmployee();
        dao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(employeeId));
        dao.setConditionStatus("=", 1);//获取正在运行项目
        List<BaseProjectEmployee> runProjects = dao.conditionalLoad();
        if (runProjects != null && runProjects.size() > 0) {
            for (BaseProjectEmployee e : runProjects) {
                runProjectNum++;
                planIntegral += e.getPlanIntegral() == null ? 0 : e.getPlanIntegral().intValue();
            }
        }
        dao.setConditionStatus("=", 2);//获取已完成项目
        List<BaseProjectEmployee> finishProjects = dao.conditionalLoad();
        if (finishProjects != null && finishProjects.size() > 0) {
            for (BaseProjectEmployee e : finishProjects) {
                finishProjectNum++;
                realIntegral += e.getRealIntegral().intValue();
            }
        }
        BaseProjectEmployee bean = new BaseProjectEmployee();
        bean.setPlanWorkHours(runProjectNum);
        bean.setRealWorkHours(finishProjectNum);
        bean.setPlanIntegral(new BigDecimal(planIntegral));
        bean.setRealIntegral(new BigDecimal(realIntegral));
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        Map<String,Object> map = new HashMap<>();
        map.put("planWorkHours",runProjectNum);
        map.put("realWorkHours",finishProjectNum);
        map.put("planIntegral",planIntegral);
        map.put("realIntegral",realIntegral);
        Employee edao = new Employee();
        edao.setEmployeeId(employeeId);
        int status;
        if(edao.load()){
        	status = BaseHelpUtils.getIntValue(edao.getIsbusy());
        	map.put("isBusy", status);
        }
        QueryEmployeeProjectAnalysis query = new QueryEmployeeProjectAnalysis();
        ConditionEmployeeProjectAnalysis condition = new ConditionEmployeeProjectAnalysis();
        condition.setEmployeeId(employeeId);
        BaseCollection<BaseEmployeeProjectAnalysis> integralList = query.executeQuery(null, condition);
        if(!BaseHelpUtils.isNullOrEmpty(integralList)){
        	for(BaseEmployeeProjectAnalysis obj : integralList.getCollections()){
        		map.put("leftIntegral",BaseHelpUtils.getBigDecimalValue(obj.getLeftIntegral()));
        	}
        }
        bc.setUserData(map);
        return bc.toJSON(0, null);
    }

}
