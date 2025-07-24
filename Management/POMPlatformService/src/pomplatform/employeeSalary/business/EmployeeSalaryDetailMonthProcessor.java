package pomplatform.employeeSalary.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
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

public class EmployeeSalaryDetailMonthProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeSalaryDetailMonth> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
			Date startDate = new Date(BaseHelpUtils.getLongValue(params.get("startDate")));
			Date endDate = new Date(BaseHelpUtils.getLongValue(params.get("endDate")));
			//获取开始日期和结束日期相差的月数
	        int months = DateUtil.getCompareMonths(startDate, endDate)+1;
	        SystemConfig systemConfigDao = new SystemConfig();
	        systemConfigDao.setSystemConfigId(2);
	        systemConfigDao.load();
	        DES des = new DES(systemConfigDao.getImagePath());
	        EmployeeSalaryDetail dao;
	        List<BaseEmployeeSalaryDetailMonth> list = new ArrayList<>();
	        BaseEmployeeSalaryDetailMonth bean;
	        //按日期去遍历计算
	        for (int i = 0;i<months;i++) {
	        	//获取当前日期的年份
	        	int year = DateUtil.getYear(startDate);
	        	//获取当前日期的月份
	        	int month = DateUtil.getMonth(startDate);
	        	//获取人员的人工成本
	        	dao = new EmployeeSalaryDetail();
	        	dao.setConditionEmployeeId("=",employeeId);
	        	dao.setConditionSalaryYear("=",year);
	        	dao.setConditionSalaryMonth("=",month);
	        	dao.unsetSelectFlags();
	        	dao.setSelectBasicSalary(true);
	        	BaseEmployeeSalaryDetail base = dao.executeQueryOneRow();
	        	//如果当月的人工成本存在，则将数据解密后，放到实体中，待返回页面
	        	if(!BaseHelpUtils.isNullOrEmpty(base)){
	        		bean = new BaseEmployeeSalaryDetailMonth();
	        		bean.setEmployeeId(employeeId);
	        		bean.setSalaryYear(year);
	        		bean.setSalaryMonth(month);
	        		bean.setBasicSalary(des.DEC(base.getBasicSalary()));
	        		list.add(bean);
	        	}
	        	//每遍历一次，都将当期日期都累加一个月
	        	startDate = DateUtil.getNextMonth(startDate);
	        }
	        bc.setCollections(list);
	        return bc.toJSON();
		}
		return bc.toJSON(-1,"参数不能为空");
	}

}
