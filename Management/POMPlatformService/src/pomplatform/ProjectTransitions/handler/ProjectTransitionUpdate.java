package pomplatform.ProjectTransitions.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Connection.Base;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectTransition;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectLog;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectTransition;

import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;

/**
 *
 * @author guanxgun
 */
public class ProjectTransitionUpdate implements GenericProcessor {

	public static void main(String[] args) {
//		try {
//			ProjectTransitionUpdate pu = new ProjectTransitionUpdate();
//			pu.execute(
//					"{\"projectType\":3,\"oldProjectDiscount\":0,\"commonArea\":\"3000\",\"logisticsArea\":0,\"percentage\":\"0\",\"contractCode\":\"J&A/SJ2016006\",\"projectCode\":\"J&A/SJ2016006-O\",\"projectName\":\"《西安高新NEWorld项目室内设计项目》\",\"projectManageId\":14,\"totalAmount\":20000,\"officeType\":6,\"projectId\":123,\"contractName\":\"《西安高新NEWorld项目室内设计合同》\",\"customerName\":\"西安海科重工 投资有限公司\",\"departmentId\":21,\"status\":0,\"projectIntegral\":\"75000\",\"departmentManagerId\":12,\"plateId\":3,\"totalIntegral\":\"75000\",\"reserveIntegral\":\"0\"}",
//					null);
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {

		HttpCookie hc = new HttpCookie(request);
		JSON parser = new JSON(new StringReader(creteria));
	    Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
	    int projectTransitionId = BaseHelpUtils.getIntValue(params.get("projectTransitionId"));
	    int status = BaseHelpUtils.getIntValue(params.get("status"));
	    int projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
	    
	    int oldProjectManageId = BaseHelpUtils.getIntValue(params.get("oldProjectManageId"));
	    int newProjectManageId = BaseHelpUtils.getIntValue(params.get("newProjectManageId"));
	    BigDecimal newPercentage = BaseHelpUtils.getBigDecimalValue(params.get("newPercentage"));
	    BigDecimal oldPercentage = BaseHelpUtils.getBigDecimalValue(params.get("oldPercentage"));
	    
	    
		ThreadConnection.beginTransaction();
	    ProjectTransition ptDao =new ProjectTransition();
        BaseProjectTransition baseProjectTransition =new BaseProjectTransition();
	    ptDao.setConditionProjectTransitionId("=", projectTransitionId);
	    ptDao.setProjectTransitionId( projectTransitionId);
        if (ptDao.load()) {
        	ptDao.setStatus(status);
        	ptDao.update();
        	
        	
        	Project dao =new Project();
        	dao.setConditionProjectId("=", projectId);
        	dao.setProjectId( projectId);
        	if (dao.load()) {
        		BigDecimal totalIntegral = dao.getTotalIntegral();
        		BigDecimal percentage =newPercentage.multiply(new BigDecimal(0.01)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
				//预留积分
				BigDecimal reserveIntegral = totalIntegral.multiply(percentage).setScale(2, BigDecimal.ROUND_HALF_DOWN);
				//项目积分
				BigDecimal projectIntegral = totalIntegral.subtract(reserveIntegral);
    			
    			if(status == 3) {//同意   ,并且吧其他的数据删除掉
    				dao.setReserveIntegral(reserveIntegral);
    				dao.setProjectIntegral(projectIntegral);
    				dao.setProjectManageId(newProjectManageId);
    				if (oldProjectManageId !=newProjectManageId) {
    					ProjectEmployee pe = new ProjectEmployee();
    					//检索当原专业负责人在该项目上已经有了确认积分记录，则不做删除
    					if (oldProjectManageId>0) {
    						ProjectSettlementDetail settDao = new ProjectSettlementDetail();
    						settDao.setConditionProjectId("=", dao.getProjectId());
    						settDao.setConditionEmployeeId("=",oldProjectManageId);
    						if(settDao.countRows() <= 0){
    							pe.setConditionProjectId("=", dao.getProjectId());
    							pe.setConditionEmployeeId("=", oldProjectManageId);
    							pe.conditionalDelete();
    						}
    					}
    					if (newProjectManageId>0) {
    						pe.clear();
    						pe.setConditionProjectId("=", dao.getProjectId());
    						pe.setConditionEmployeeId("=",newProjectManageId);
    						List<BaseProjectEmployee> conditionalLoad = pe.conditionalLoad();
    						if(conditionalLoad.size()>0) {
    							BaseProjectEmployee baseProjectEmployee = conditionalLoad.get(0);
    						} else {
    							pe.setProjectId(dao.getProjectId());
    							pe.setEmployeeId(newProjectManageId);
    							pe.setPlanStartDate(dao.getPlanStartDate());
    							pe.setPlanEndDate(dao.getPlanEndDate());
    							pe.setStatus(2);
    							pe.setAlternateField2("2");// 设置默认值为2，表示已完成。
    							pe.save();
    						}
    					}
    				}
    			}
    			
				//删除其他的中间表信息
				ptDao.clear();
				ptDao.setConditionProjectId("=", projectId);
				ptDao.setConditionStatus("=", StaticUtils.PROJECT_TRANSITIONS_STAUTS_1);
				ptDao.setConditionIsOrNot("=", true);
				ptDao.setConditionProjectTransitionId("!=", projectTransitionId);
				ptDao.conditionalDelete();
    			//更换项目经理
    			dao.update();
    			
    			ProjectLog pl = new ProjectLog();
    			pl.setProjectId(dao.getProjectId());
    			pl.setOperateId(ptDao.getOperator());
    			pl.setOperateTime(new Date());
    			pl.setLogType(0);
    			pl.setDepartmentId(dao.getDepartmentId());
    			pl.setManagerId(ptDao.getOperator());
    			pl.setLogContent(String.format("%1$s修改了%2$s项目", hc.getOperatorName(), dao.getProjectName()));
    			pl.save();
    		}
        	
        	
        	
        }else {
        	throw new SQLException("记录获取失败");
        }
        
		ThreadConnection.commit();
		return baseProjectTransition.toOneLineJSON(0, null);
	}
	
	
	
}
