package pomplatform.attachment.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.attachment.bean.BaseMcontractcacccccaaaraabbifiior;
import pomplatform.attachment.bean.ConditionMcontractcacccccaaaraabbifiior;
import pomplatform.attachment.query.QueryMcontractcacccccaaaraabbifiior;

public class McontractcacccccaaaraabbifiiorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McontractcacccccaaaraabbifiiorHandler.class);

	public static BaseCollection<BaseMcontractcacccccaaaraabbifiior> executeQueryMcontractcacccccaaaraabbifiior(ConditionMcontractcacccccaaaraabbifiior c, KeyValuePair[] replacements ) throws Exception {
		QueryMcontractcacccccaaaraabbifiior dao = new QueryMcontractcacccccaaaraabbifiior();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcontractcacccccaaaraabbifiior> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcontractcacccccaaaraabbifiior c = new ConditionMcontractcacccccaaaraabbifiior();
		c.setDataFromJSON(creteria);
		if(null != c.getMinHappenDate()){
			c.setMinHappenDate(DateUtil.getNextDayOfDay(c.getMinHappenDate(), 0));
		}
		if(null != c.getMaxHappenDate()){
			c.setMaxHappenDate(DateUtil.getNextDayOfDay(c.getMaxHappenDate(), 1));
		}
		if(null == c.getMinHappenDate() && null == c.getMaxHappenDate()) {
			c.setMinHappenDate(DateUtil.getNextDayOfToday());
			c.setMaxHappenDate(new Date());
		}
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		System.out.println("result ======= " + result.toString());
		String reSql = "AND ct.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace0))";
		KeyValuePair kv = new KeyValuePair();
		int type = BaseHelpUtils.getIntValue(result, "type");
		int checkEmployeeId = BaseHelpUtils.getIntValue(result, "checkEmployeeId");
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		if(type == 1){
			if(checkEmployeeId > 0){
				kv.setKey("replace0");
				kv.setValue(checkEmployeeId + "");
			}else{
				kv.setKey(reSql);
				kv.setValue("");
			}
		}else if(type == 2){
			if(checkEmployeeId > 0){
				kv.setKey("replace0");
				kv.setValue(checkEmployeeId + "");
			}else{
				/*List<BaseEmployee> list = new ArrayList<>();
				Employee emDao = new Employee();
				emDao.setEmployeeId(employeeId);
				if(emDao.load()){
					Integer departmentId = emDao.getDepartmentId();
					if(null != departmentId){
						emDao.clear();
						list = emDao.conditionalLoad(" department_id in (SELECT child_id FROM department_ids WHERE department_id = " + departmentId + ")");
						
					}
				}
				String ids = "";
				for (int i = 0; i < list.size(); i++) {
					if(i != 0){
						ids += ",";
					}
					ids += list.get(i).getEmployeeId();
				}*/
				String plateIds = BaseHelpUtils.getStringValue(result, "plateIds");
				String newSql = "AND ct.contract_id IN (SELECT contract_id FROM projects WHERE plate_id in ("+plateIds+"))";
				kv.setKey(reSql);
				kv.setValue(newSql);
			}
		}else if(type == 3){
			kv.setKey("replace0");
			kv.setValue(employeeId + "");
		}
		KeyValuePair[] replacements = new KeyValuePair[4];
		replacements[0] = kv;
		
		KeyValuePair kv1 = new KeyValuePair();
		kv1.setKey("replace1");
		if(null == result.get("checkAmount")){
			kv1.setValue(" 1 = 1 ");
		}else{
			boolean checkAmount = BaseHelpUtils.getBoolean(result.get("checkAmount"));
			if(checkAmount){
				kv1.setValue(" (cp.borrow_money = am1.amount AND cp.borrow_money > 0 ) ");
			}else{
				kv1.setValue(" (cp.borrow_money <> am1.amount  OR cp.borrow_money ISNULL OR am1.amount ISNULL )");
			}
		}
		replacements[1] = kv1;
		
		KeyValuePair kv2 = new KeyValuePair();
		kv2.setKey("replace2");
		if(null == result.get("haveAttachment")){
			kv2.setValue(" 1 = 1 ");
		}else{
			boolean haveAttachment = BaseHelpUtils.getBoolean(result.get("haveAttachment"));
			if(haveAttachment){
				kv2.setValue(" amm.count > 0");
			}else{
				kv2.setValue(" (amm.count = 0 or amm.count isnull )");
			}
		}
		replacements[2] = kv2;
		KeyValuePair kv3 = new KeyValuePair();
		kv3.setKey("ct.contract_status = ?");
		if (null!=result.get("contractStatusM")) {
			
			kv3.setValue(" ct.contract_status = ? and ct.contract_status in "+BaseHelpUtils.getString(result.get("contractStatusM")));
			
		}else{
			kv3.setValue("ct.contract_status = ?");
		}
		
		replacements[3] = kv3;
		c.setKeyValues(replacements);
		BaseCollection<BaseMcontractcacccccaaaraabbifiior> resultData = executeQueryMcontractcacccccaaaraabbifiior(c, c.getKeyValues());
		return resultData.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcontractcacccccaaaraabbifiior> result;
		ConditionMcontractcacccccaaaraabbifiior c = new ConditionMcontractcacccccaaaraabbifiior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(null != c.getMinHappenDate()){
			c.setMinHappenDate(DateUtil.getNextDayOfDay(c.getMinHappenDate(), 0));
		}
		if(null != c.getMaxHappenDate()){
			c.setMaxHappenDate(DateUtil.getNextDayOfDay(c.getMaxHappenDate(), 1));
		}
		Map<String, Object> result1 = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result1 = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String reSql = "AND ct.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace0))";
		KeyValuePair kv = new KeyValuePair();
		int type = BaseHelpUtils.getIntValue(result1, "type");
		int checkEmployeeId = BaseHelpUtils.getIntValue(result1, "checkEmployeeId");
		int employeeId = BaseHelpUtils.getIntValue(result1, "employeeId");
		if(type == 1){
			if(checkEmployeeId > 0){
				kv.setKey("replace0");
				kv.setValue(checkEmployeeId + "");
			}else{
				kv.setKey(reSql);
				kv.setValue("");
			}
		}else if(type == 2){
			if(checkEmployeeId > 0){
				kv.setKey("replace0");
				kv.setValue(checkEmployeeId + "");
			}else{
				List<BaseEmployee> list = new ArrayList<>();
				Employee emDao = new Employee();
				emDao.setEmployeeId(employeeId);
				if(emDao.load()){
					Integer departmentId = emDao.getDepartmentId();
					if(null != departmentId){
						emDao.clear();
						list = emDao.conditionalLoad(" department_id in (SELECT child_id FROM department_ids WHERE department_id = " + departmentId + ")");
						
					}
				}
				String ids = "";
				for (int i = 0; i < list.size(); i++) {
					if(i != 0){
						ids += ",";
					}
					ids += list.get(i).getEmployeeId();
				}
				kv.setKey("replace0");
				kv.setValue(ids);
			}
		}else if(type == 3){
			kv.setKey("replace0");
			kv.setValue(employeeId + "");
		}
		KeyValuePair[] replacements = new KeyValuePair[3];
		replacements[0] = kv;
		
		KeyValuePair kv1 = new KeyValuePair();
		kv1.setKey("replace1");
		if(null == result1.get("checkAmount")){
			kv1.setValue(" 1 = 1 ");
		}else{
			boolean checkAmount = BaseHelpUtils.getBoolean(result1.get("checkAmount"));
			if(checkAmount){
				kv1.setValue(" (cp.borrow_money = am1.amount AND cp.borrow_money > 0 ) ");
			}else{
				kv1.setValue(" (cp.borrow_money <> am1.amount  OR cp.borrow_money ISNULL OR am1.amount ISNULL )");
			}
		}
		replacements[1] = kv1;
		
		KeyValuePair kv2 = new KeyValuePair();
		kv2.setKey("replace2");
		if(null == result1.get("haveAttachment")){
			kv2.setValue(" 1 = 1 ");
		}else{
			boolean haveAttachment = BaseHelpUtils.getBoolean(result1.get("haveAttachment"));
			if(haveAttachment){
				kv2.setValue(" amm.count > 0");
			}else{
				kv2.setValue(" (amm.count = 0 or amm.count isnull )");
			}
		}
		replacements[2] = kv2;
		c.setKeyValues(replacements);
		QueryMcontractcacccccaaaraabbifiior dao = new QueryMcontractcacccccaaaraabbifiior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( replacements, c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( replacements, c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcontractcacccccaaaraabbifiior.EXPORT_CAPTIONS);
			for(BaseMcontractcacccccaaaraabbifiior b : result.getCollections()){
				ps.println(b.toCSVString1());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


