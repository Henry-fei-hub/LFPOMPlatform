package pomplatform.capitaldistribution.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import pomplatform.capitaldistribution.bean.BaseCapitalDistributionOfProject;
import pomplatform.capitaldistribution.bean.ConditionCapitalDistributionOfProject;
import pomplatform.capitaldistribution.query.QueryCapitalDistributionOfProject;
import pomplatform.common.utils.StaticUtils;
import pomplatform.funciton.bean.BaseGetPlateIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.bean.ConditionGetPlateIdByEmployeeIdAndFunctionCode;
import pomplatform.funciton.query.QueryGetPlateIdByEmployeeIdAndFunctionCode;

public class CapitalDistributionOfProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionOfProjectHandler.class);

	public static BaseCollection<BaseCapitalDistributionOfProject> executeQueryCapitalDistributionOfProject(ConditionCapitalDistributionOfProject c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalDistributionOfProject dao = new QueryCapitalDistributionOfProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalDistributionOfProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalDistributionOfProject c = new ConditionCapitalDistributionOfProject();
		c.setDataFromJSON(creteria);
		//找该员工拥有权限的业务部门
		if(null != c.getFunctionCode()) {
			ConditionGetPlateIdByEmployeeIdAndFunctionCode condition1 = new ConditionGetPlateIdByEmployeeIdAndFunctionCode();
			condition1.setEmployeeId(c.getLoginUser());
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
			if(sb1.length() > 0){
				KeyValuePair[] originalKeyValues = c.getKeyValues();
				int size;
				if(null == originalKeyValues) {
					size = 1;
				}else {
					size = originalKeyValues.length + 1;
				}
				KeyValuePair[] arr = new KeyValuePair[size];
				KeyValuePair keyValue = new KeyValuePair();
				keyValue.setKey("WHERE b.contract_code like ? and b.contract_name like ?");
				keyValue.setValue("WHERE b.contract_code like ? and b.contract_name like ? and a.plate_id in (" + sb1.toString() + ")");
				arr[0] = keyValue;
				if(size > 1) {
					for (int i = 1; i < size; i++) {
						arr[i] = originalKeyValues[i - 1];
					}
				}
				c.setKeyValues(arr);
			}
		}
		if(null != c.getStartDate()){
			c.setStartDate(DateUtil.getNextDayOfDay(c.getStartDate(), 0));
		}
		if(null != c.getEndDate()){
			c.setEndDate(DateUtil.getNextDayOfDay(c.getEndDate(), 1));
		}
		BaseCollection<BaseCapitalDistributionOfProject> result = executeQueryCapitalDistributionOfProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalDistributionOfProject> result;
		ConditionCapitalDistributionOfProject c = new ConditionCapitalDistributionOfProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		//找该员工拥有权限的业务部门
				if(null != c.getFunctionCode()) {
					ConditionGetPlateIdByEmployeeIdAndFunctionCode condition1 = new ConditionGetPlateIdByEmployeeIdAndFunctionCode();
					condition1.setEmployeeId(c.getLoginUser());
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
					if(sb1.length() > 0){
						KeyValuePair[] originalKeyValues = c.getKeyValues();
						int size;
						if(null == originalKeyValues) {
							size = 1;
						}else {
							size = originalKeyValues.length + 1;
						}
						KeyValuePair[] arr = new KeyValuePair[size];
						KeyValuePair keyValue = new KeyValuePair();
						keyValue.setKey("WHERE b.contract_code like ? and b.contract_name like ?");
						keyValue.setValue("WHERE b.contract_code like ? and b.contract_name like ? and a.plate_id in (" + sb1.toString() + ")");
						arr[0] = keyValue;
						if(size > 1) {
							for (int i = 1; i < size; i++) {
								arr[i] = originalKeyValues[i - 1];
							}
						}
						c.setKeyValues(arr);
					}
				}
		if(null != c.getStartDate()){
			c.setStartDate(DateUtil.getNextDayOfDay(c.getStartDate(), 0));
		}
		if(null != c.getEndDate()){
			c.setEndDate(DateUtil.getNextDayOfDay(c.getEndDate(), 1));
		}
		QueryCapitalDistributionOfProject dao = new QueryCapitalDistributionOfProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalDistributionOfProject.ALL_CAPTIONS);
			for(BaseCapitalDistributionOfProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


