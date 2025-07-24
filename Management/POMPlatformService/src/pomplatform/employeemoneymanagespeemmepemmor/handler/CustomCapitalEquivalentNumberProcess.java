package pomplatform.employeemoneymanagespeemmepemmor.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.ProcessBillList;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMemployeemoneymanagespeemmepemmor;

public class CustomCapitalEquivalentNumberProcess implements GenericProcessor{
	
	
	private final static String DO_EQUIVALENT_NUMBER = "doEquivalentNumber";//进行对冲
	
	private final static String UNDO_EQUIVALENT_NUMBER = "undoEquivalentNumber";//取消对冲

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
			case DO_EQUIVALENT_NUMBER:
				return doEquivalentNumber(result);
			case UNDO_EQUIVALENT_NUMBER:
				return undoEquivalentNumber(result);
			}
		}
		return null;
	}
	
	public String doEquivalentNumber(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		List<BaseMemployeemoneymanagespeemmepemmor> list = GenericBase.__getList(params.get("list"), BaseMemployeemoneymanagespeemmepemmor.newInstance());
		int employeeId = 0;
		if(list.size() > 0){
			employeeId = list.get(0).getEmployeeId();
			if(employeeId > 0){
				Date current = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String equivalentNumber = employeeId + "-" + sdf.format(current);
				for (BaseMemployeemoneymanagespeemmepemmor bean : list) {
					switch (bean.getMType()) {
					case 1: //借款
						EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
						emmDao.setConditionEmployeeMoneyManageId("=", bean.getBusinessId());
						emmDao.setEquivalentNumber(equivalentNumber);
						emmDao.conditionalUpdate();
						break;
					case 2: //冲账
						ProcessBillList pblDao = new ProcessBillList();
						pblDao.setConditionProcessType("=", bean.getProcessType());
						pblDao.setConditionBusinessId("=", bean.getBusinessId());
						pblDao.setConditionBalanceAmount("=", bean.getReturnMoney().abs());
						pblDao.setEquivalentNumber(equivalentNumber);
						pblDao.conditionalUpdate();
						break;
					case 3: //还款
						PersonnelBusines pbDao = new PersonnelBusines();
						pbDao.setConditionProjectType("=", bean.getProcessType());
						pbDao.setConditionPersonnelBusinessId("=", bean.getBusinessId());
						pbDao.setEquivalentNumber(equivalentNumber);
						pbDao.conditionalUpdate();
						break;
					default:
						break;
					}
				}
			}
		}
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 清除对冲
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String undoEquivalentNumber(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		String equivalentNumber = BaseHelpUtils.getStringValue(params, "equivalentNumber");
		if(!BaseHelpUtils.isNullOrEmpty(equivalentNumber)){
			EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
			emmDao.setConditionEquivalentNumber("=", equivalentNumber);
			emmDao.setEquivalentNumber("");
			emmDao.conditionalUpdate();
			ProcessBillList pblDao = new ProcessBillList();
			pblDao.setConditionEquivalentNumber("=", equivalentNumber);
			pblDao.setEquivalentNumber("");
			pblDao.conditionalUpdate();
			PersonnelBusines pbDao = new PersonnelBusines();
			pbDao.setConditionEquivalentNumber("=", equivalentNumber);
			pbDao.setEquivalentNumber("");
			pbDao.conditionalUpdate();
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	public static void main(String[] args) throws SQLException {
		PersonnelBusines pbDao = new PersonnelBusines();
		pbDao.setConditionPersonnelBusinessId("=", 1);
		
		pbDao.conditionalLoad();
		pbDao.setEmployeeId(null);
		pbDao.conditionalUpdate();
	}
}
