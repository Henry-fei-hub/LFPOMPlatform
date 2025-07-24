package pomplatform.department.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.dao.Department;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.payment.bean.BaseOnSalaryPlateBonusByCompany;
import pomplatform.payment.bean.BaseOnSalaryReportByPlate;
import pomplatform.payment.bean.ConditionOnSalaryPlateBonusByCompany;
import pomplatform.payment.bean.ConditionOnSalaryReportByPlate;
import pomplatform.payment.query.QueryOnSalaryPlateBonusByCompany;
import pomplatform.payment.query.QueryOnSalaryReportByPlate;

public class CustomDepartmentSelectInfoProcess implements GenericProcessor{
	
	private final static String GET_DEPARTMENT_MONEY = "getDepartmentMoney";//获取薪资发放到部门的金额
	
	private final static String GET_DEPARTMENT_BONUS_MONEY = "getDepartmentBonusMoney";//获取奖金发放到部门的金额

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case GET_DEPARTMENT_MONEY:
				return getDepartmentMoney(result);
			case GET_DEPARTMENT_BONUS_MONEY:
				return getDepartmentBonusMoney(result);
			}
		}
		return null;
	}
	
	public static String getDepartmentBonusMoney(Map<String, Object> params) throws SQLException, ParseException{
		int status = 1;
		String errorMsg = null;
		BaseCollection<BaseOnSalaryPlateBonusByCompany> bc = new BaseCollection<>();
		QueryOnSalaryPlateBonusByCompany dao = new QueryOnSalaryPlateBonusByCompany();
		dao.setCurrentPage(0);
		dao.setPageLines(1);
		ConditionOnSalaryPlateBonusByCompany c = new ConditionOnSalaryPlateBonusByCompany();
		c.setDataFromMap(params);
 		BaseCollection<BaseOnSalaryPlateBonusByCompany> result = dao.executeQuery( c.getKeyValues(), c) ;
 		List<BaseOnSalaryPlateBonusByCompany> list = result.getCollections();
 		Department dDao = new Department();
 		for (BaseOnSalaryPlateBonusByCompany baseOnSalaryReportByPlate : list) {
 			dDao.clear();
 			Integer plateId = baseOnSalaryReportByPlate.getPlateId();
 			dDao.setConditionPlateId("=", plateId);
 			BaseDepartment bean = dDao.executeQueryOneRow(" order by " + BaseDepartment.CS_PARENT_ID);
 			if(null != bean){
 				baseOnSalaryReportByPlate.setPlateId(bean.getDepartmentId());
 			}
		}
		bc.setCollections(list);
		return bc.toJSON(status, errorMsg);
	}
	
	public static String getDepartmentMoney(Map<String, Object> params) throws SQLException, ParseException{
		int status = 1;
		String errorMsg = null;
		BaseCollection<BaseOnSalaryReportByPlate> bc = new BaseCollection<>();
		QueryOnSalaryReportByPlate dao = new QueryOnSalaryReportByPlate();
		dao.setCurrentPage(0);
		dao.setPageLines(1);
		ConditionOnSalaryReportByPlate c = new ConditionOnSalaryReportByPlate();
		c.setDataFromMap(params);
 		BaseCollection<BaseOnSalaryReportByPlate> result = dao.executeQuery( c.getKeyValues(), c) ;
 		List<BaseOnSalaryReportByPlate> list = result.getCollections();
 		Department dDao = new Department();
 		for (BaseOnSalaryReportByPlate baseOnSalaryReportByPlate : list) {
 			dDao.clear();
 			Integer plateId = baseOnSalaryReportByPlate.getPlateId();
 			dDao.setConditionPlateId("=", plateId);
 			BaseDepartment bean = dDao.executeQueryOneRow(" order by " + BaseDepartment.CS_PARENT_ID);
 			if(null != bean){
 				baseOnSalaryReportByPlate.setPlateId(bean.getDepartmentId());
 			}
		}
		bc.setCollections(list);
		return bc.toJSON(status, errorMsg);
	}
	
}
