package pomplatform.common.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployeeAdvanceRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;

public class OnGetProjectEmployeeAdvanceRecord implements GenericProcessor {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取补贴项目ID
        int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
        //获取该项目下的成员数据集
        ProjectEmployee projectEmployeeDao = new ProjectEmployee();
        projectEmployeeDao.setConditionProjectId("=",projectId);
        List<BaseProjectEmployee> projectEmployeeList = projectEmployeeDao.conditionalLoad();
        //定义一个map，用于存放该项目下的所有成员已经补贴的积分
        Map<Integer,BigDecimal> map = new HashMap<>();
        if(!BaseHelpUtils.isNullOrEmpty(projectEmployeeList) && !projectEmployeeList.isEmpty()){
        	for(BaseProjectEmployee e : projectEmployeeList){
        		//获取人员ID
        		int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
        		map.put(employeeId,BigDecimal.ZERO);
        	}
        }
        List<BaseProjectEmployeeAdvanceRecord> resultList = new ArrayList<>();
        BaseProjectEmployeeAdvanceRecord bean ;
        //检索项目成员已经补贴的积分
        if(!map.isEmpty()){
        	ProjectEmployeeAdvanceRecord projectEmployeeAdvanceDao = new ProjectEmployeeAdvanceRecord();
        	projectEmployeeAdvanceDao.setConditionProjectId("=",projectId);
        	List<BaseProjectEmployeeAdvanceRecord> projectEmployeeAdvanceList = projectEmployeeAdvanceDao.conditionalLoad();
        	if(!BaseHelpUtils.isNullOrEmpty(projectEmployeeAdvanceList) && !projectEmployeeAdvanceList.isEmpty()){
        		for(BaseProjectEmployeeAdvanceRecord e : projectEmployeeAdvanceList){
        			//获取人员ID
        			int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
        			//获取已经补贴的积分
        			BigDecimal advancedIntegral = e.getAdvancedIntegral()==null?BigDecimal.ZERO:e.getAdvancedIntegral();
        			//获取map中保存的值
        			BigDecimal advancedIntegralMap = null != map.get(employeeId) ? map.get(employeeId) : BigDecimal.ZERO;
        			//重新更新map的值
        			map.put(employeeId,advancedIntegralMap.add(advancedIntegral));
        		}
        	}
        	Employee employeeDao = new Employee();
        	//遍历map值
        	for(Integer employeeId : map.keySet()){
        		//先加载这个人员是否离职，如果离职，则不加载其数据
        		employeeDao.clear();
        		employeeDao.setEmployeeId(employeeId);
        		employeeDao.load();
        		//获取在职离职状态
        		int status = BaseHelpUtils.getIntValue(employeeDao.getStatus());
        		if(status == 0){//表示在职
        			bean = new BaseProjectEmployeeAdvanceRecord();
        			//获取人员已经补贴的积分
        			BigDecimal advancedIntegral = map.get(employeeId);
        			bean.setEmployeeId(employeeId);
        			bean.setAdvanceIntegral(BigDecimal.ZERO);
        			bean.setAdvancedIntegral(advancedIntegral);
        			resultList.add(bean);
        		}
        	}
        }
        BaseCollection<BaseProjectEmployeeAdvanceRecord> bc = new BaseCollection<>();
        bc.setCollections(resultList);
        return bc.toJSON();
    }

    public static void main(String[] args) {
    	OnGetProjectEmployeeAdvanceRecord a = new OnGetProjectEmployeeAdvanceRecord();
    	try{
    	a.execute("{\"projectId\":252}", null);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
}