package pomplatform.employee.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employee.bean.BaseEmployeeInfoOfNoSalaryAdjustment;
import pomplatform.employee.bean.ConditionEmployeeInfoOfNoSalaryAdjustment;
import pomplatform.employee.query.QueryEmployeeInfoOfNoSalaryAdjustment;
import pomplatform.funciton.bean.BaseGetDepartmentIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.bean.BaseGetPlateIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.bean.ConditionGetDepartmentIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.bean.ConditionGetPlateIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.query.QueryGetDepartmentIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.query.QueryGetPlateIdByEmployeeIdAndFunctionCode;

public class EmployeeInfoOfNoSalaryAdjustmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeInfoOfNoSalaryAdjustmentHandler.class);

	public static BaseCollection<BaseEmployeeInfoOfNoSalaryAdjustment> executeQueryEmployeeInfoOfNoSalaryAdjustment(ConditionEmployeeInfoOfNoSalaryAdjustment c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeInfoOfNoSalaryAdjustment dao = new QueryEmployeeInfoOfNoSalaryAdjustment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeInfoOfNoSalaryAdjustment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeInfoOfNoSalaryAdjustment c = new ConditionEmployeeInfoOfNoSalaryAdjustment();
		c.setDataFromJSON(creteria);
		Date date = new Date();
		c.setStartTime(DateUtil.getFirstDay(date));
		c.setEndTime(DateUtil.getFirstDayOfNextMonth(date));
		BaseCollection<BaseEmployeeInfoOfNoSalaryAdjustment> result = new BaseCollection<>();
		if(null != c.getFunctionCode() && null != c.getDrafter()){
			//找该员工拥有权限的业务部门
			ConditionGetPlateIdByEmployeeIdAndFunctionCode condition1 = new ConditionGetPlateIdByEmployeeIdAndFunctionCode();
			condition1.setEmployeeId(c.getDrafter());
			condition1.setFunctionCode(c.getFunctionCode());
			condition1.setApplicationId(StaticUtils.ERP_APPLICATION_ID);
			QueryGetPlateIdByEmployeeIdAndFunctionCode query1 = new QueryGetPlateIdByEmployeeIdAndFunctionCode();
			BaseCollection<BaseGetPlateIdByEmployeeIdAndFunctionCode> bc1 = query1.executeQuery(null, condition1);
			List<BaseGetPlateIdByEmployeeIdAndFunctionCode> plateList = bc1.getCollections();
			StringBuilder sb1 = new StringBuilder();
			if(null != plateList && !plateList.isEmpty()){
				for(BaseGetPlateIdByEmployeeIdAndFunctionCode obj : plateList){
					if(sb1.length() > 0){
						sb1.append(",");
					}
					sb1.append(obj.getPlateId());
				}
			}
			//找该员工拥有权限的归属部门
			ConditionGetDepartmentIdByEmployeeIdAndFunctionCode condition2 = new ConditionGetDepartmentIdByEmployeeIdAndFunctionCode();
			condition2.setEmployeeId(c.getDrafter());
			condition2.setFunctionCode(c.getFunctionCode());
			condition2.setApplicationId(StaticUtils.ERP_APPLICATION_ID);
			QueryGetDepartmentIdByEmployeeIdAndFunctionCode query2 = new QueryGetDepartmentIdByEmployeeIdAndFunctionCode();
			BaseCollection<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> bc2 = query2.executeQuery(null, condition2);
			List<BaseGetDepartmentIdByEmployeeIdAndFunctionCode> departmentList = bc2.getCollections();
			StringBuilder sb2 = new StringBuilder();
			if(null != departmentList && !departmentList.isEmpty()){
				for(BaseGetDepartmentIdByEmployeeIdAndFunctionCode obj : departmentList){
					if(sb2.length() > 0){
						sb2.append(",");
					}
					sb2.append(obj.getDepartmentId());
				}
			}
			if(sb1.length() > 0 || sb2.length() > 0){
				StringBuilder sb = new StringBuilder();
				sb.append("WHERE a.status = 0");
				if(sb1.length() > 0){
					sb.append(" and a.plate_id in (").append(sb1.toString()).append(")");
				}
				if(sb2.length() > 0){
					sb.append(" and a.department_id in (").append(sb2.toString()).append(")");
				}
				sb.append(" and a.plate_id");
				KeyValuePair[] arr = new KeyValuePair[1];
				KeyValuePair keyValue = new KeyValuePair();
				keyValue.setKey("WHERE a.status = 0 and a.plate_id");
				keyValue.setValue(sb.toString());
				arr[0] = keyValue;
				c.setKeyValues(arr);
			}else{
				return result.toJSON();
			}
		}
		result = executeQueryEmployeeInfoOfNoSalaryAdjustment(c, c.getKeyValues());
		List<BaseEmployeeInfoOfNoSalaryAdjustment> list = result.getCollections();
		if(null != list && !list.isEmpty()){
			AccountManageProcess accountProcess = new AccountManageProcess();
			for(BaseEmployeeInfoOfNoSalaryAdjustment obj : list){
				obj.setFee(BaseHelpUtils.getBigDecimalValue(accountProcess.getBenefitsOfEmployee(obj.getEmployeeId(), null).get(obj.getEmployeeId())));
			}
			result.setCollections(list);
		}
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeInfoOfNoSalaryAdjustment> result;
		ConditionEmployeeInfoOfNoSalaryAdjustment c = new ConditionEmployeeInfoOfNoSalaryAdjustment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		Date date = new Date();
		c.setStartTime(DateUtil.getFirstDay(date));
		c.setEndTime(DateUtil.getFirstDayOfNextMonth(date));
		QueryEmployeeInfoOfNoSalaryAdjustment dao = new QueryEmployeeInfoOfNoSalaryAdjustment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeInfoOfNoSalaryAdjustment.ALL_CAPTIONS);
			for(BaseEmployeeInfoOfNoSalaryAdjustment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


