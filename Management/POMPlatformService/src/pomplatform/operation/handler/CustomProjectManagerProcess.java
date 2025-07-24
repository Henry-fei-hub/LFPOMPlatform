package pomplatform.operation.handler;

import java.io.File;
import java.io.StringReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;

/**
 * 
 * @Title: CustomProjectManagerProcess.java 
 * @Package pomplatform.operation.handler 
 * @Description: 项目立项自定义控制
 * @author CL  
 * @date 2017年3月29日
 */
public class CustomProjectManagerProcess implements GenericProcessor, GenericDownloadProcessor {

	@SuppressWarnings("unused")
	private static final Logger __logger = Logger.getLogger(CustomSprocessbilllistppporProcess.class);

	private final static String CHECK_CODE_EXIST = "checkCodeExist";//检测编号是否已经存在

	
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
				case CHECK_CODE_EXIST:
					return checkCodeExist(result);
			}
		}
		return null;
	}
	

	/**
	 * 
	 * @Title: checkCodeExist 
	 * @Description: 检测订单编号是否存在
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String checkCodeExist(Map<String, Object> params) throws Exception {
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		int status = 1;
		String errorMessage = null;
		String contractCode = BaseHelpUtils.getStringValue(params, "contractCode");
		Project dao = new Project();
		dao.setConditionContractCode("=", contractCode);
		if (dao.countRows() > 0) {
			status = -1;
			errorMessage = "该订单编号已经存在";
		}
		return bc.toJSON(status, errorMessage);

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
