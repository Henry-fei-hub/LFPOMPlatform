package pomplatform.workflow.personnelbusiness.handler;

import java.io.File;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;

public class CustomPersonnelBusinessProcess implements GenericProcessor, GenericDownloadProcessor {

	@SuppressWarnings("unused")
	private static final Logger __logger = Logger.getLogger(CustomSprocessbilllistppporProcess.class);

	private final static String GET_PERSONNEL_BUSINESS_BY_ID = "getPersonnelBusinessById";


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
			case GET_PERSONNEL_BUSINESS_BY_ID:
				return getPersonnelBusinessById(result);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: getPersonnelBusinessById 
	 * @Description: 根据主键查询人资流程主表数据
	 * @param @param data
	 * @param @return
	 * @param @throws SQLException   
	 * @return String   
	 * @throws
	 */
	private String getPersonnelBusinessById(Map<String, Object> data) throws SQLException{
		int status = 1;
		PersonnelBusines dao = new PersonnelBusines();
		int personnelBusinessId = BaseHelpUtils.getIntValue(data, "personnelBusinessId");
		dao.setConditionPersonnelBusinessId("=", personnelBusinessId);
		BaseCollection<BasePersonnelBusines> bc = new BaseCollection<>();
		List<BasePersonnelBusines> list = dao.conditionalLoad();
		if(list.size() > 0){
			bc.setCollections(list);
		} else {
			status = -1;
		}
		return bc.toJSON(status, null);
		
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDownloadFileExtension() {
		// TODO Auto-generated method stub
		return null;
	}

}
