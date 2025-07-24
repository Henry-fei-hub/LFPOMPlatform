package pomplatform.contractppspcccfscsiiicpor.handler;

import java.io.File;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;

public class CustomSprojectpcorProcess implements GenericProcessor, GenericDownloadProcessor {

	@SuppressWarnings("unused")
	private static final Logger __logger = Logger.getLogger(CustomSprocessbilllistppporProcess.class);


	private final static String UNDO_LINK_CONTRACT = "undoLinkContract";// 解除与合同的关联
	
	private final static String DO_LINK_CONTRACT = "doLinkContract";//订单与合同关联
	
//	private final static String GET_UNLINK_CONTRACT_PROJECTS = "getUnlinkContractProjects";//获取没有关联合同的订单

	@SuppressWarnings("unchecked")
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
			case UNDO_LINK_CONTRACT:
				return undoLinkContract(result);
			case DO_LINK_CONTRACT:
				return doLinkContract(result);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: doLinkContract 
	 * @Description: 绑定合同
	 * @param @param result
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	private String doLinkContract(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if(BaseHelpUtils.isNullOrEmpty(ids)){
			status = -1;
		} else {
			String [] idArr = ids.split(",");
			Object [] oArr = new Object[idArr.length];
			for (int i = 0; i < idArr.length; i++) {
				oArr [i] = Integer.parseInt(idArr[i]);
			}
			Project dao =  new Project();
			dao.setConditionContractId("=", 0);
			dao.addCondition("project_id", "in", oArr);
			dao.setContractId(contractId);
			dao.conditionalUpdate();
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: undoLinkContract 
	 * @Description: 解绑合同 
	 * @param @param result
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	private String undoLinkContract(Map<String, Object> result) throws SQLException{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = null;
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if(BaseHelpUtils.isNullOrEmpty(ids)){
			status = -1;
		} else {
			String [] idArr = ids.split(",");
			Object [] oArr = new Object[idArr.length];
			for (int i = 0; i < idArr.length; i++) {
				oArr [i] = Integer.parseInt(idArr[i]);
			}
			Project dao =  new Project();
			dao.setConditionContractId("=", contractId);
			dao.addCondition("project_id", "in", oArr);
			dao.setContractId(0);
			dao.conditionalUpdate();
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	}
	
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}


}


