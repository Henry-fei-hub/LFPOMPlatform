package pomplatform.PreProjectReimbursementNumber.handler;

import java.io.File;
import java.io.StringReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePreProjectReimbursementNumber;
import com.pomplatform.db.dao.PreProjectReimbursementNumber;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
public class CustomPreProject implements GenericProcessor, GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomPreProject.class);
	private static final String UPDATE_PRE_PROJECT = "updatePreProject";
	private static final String ADD_PRE_PROJECT = "addPreProject";
	private static final String DEL_PRE_PROJECT = "delPreProject";
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
			case DEL_PRE_PROJECT:
				return delPreProject(result);
			case UPDATE_PRE_PROJECT:
				return updatePreProject(result, creteria);
			case ADD_PRE_PROJECT:
				return addPreProject(result, creteria);
			}
		}
		return null;
	}
	private String addPreProject(Map<String, Object> result,String creteria) throws Exception {
		//创建前期项目编号
		String code=NewPreProjectCode.getPreProjectCode(result);
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		bean.setDataFromJSON(creteria);
		bean.setCustomNumber(code);
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setDataFromBase(bean);
		int num = dao.save();
		return bean.toOneLineJSON(num, null);
	}
	
	private String updatePreProject(Map<String, Object> result,String creteria) throws Exception {
		//创建前期项目编号
		String code=NewPreProjectCode.getPreProjectCode(result);
		int preProjectReimbursementNumberId=BaseHelpUtils.getIntValue(result,"preProjectReimbursementNumberId");
		PreProjectReimbursementNumber ppr=new PreProjectReimbursementNumber();
		ppr.setConditionPreProjectReimbursementNumberId("=", preProjectReimbursementNumberId);
		BasePreProjectReimbursementNumber bean = ppr.executeQueryOneRow();
		if(!CodingIsused.getPreProjectCode(preProjectReimbursementNumberId)){
			bean.setDataFromJSON(creteria);
			bean.setCustomNumber(code);
			PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
			dao.setConditionPreProjectReimbursementNumberId("=", bean.getPreProjectReimbursementNumberId());
			BasePreProjectReimbursementNumber base=dao.executeQueryOneRow();
			int num=0;
			if(!BaseHelpUtils.isNullOrEmpty(base)){dao.setDataFromBase(bean); num = dao.conditionalUpdate(); }
			return bean.toOneLineJSON(num, null);
		}else{
			return bean.toOneLineJSON(-1, "前期项目编号已被使用不能修改");
		}
	}
	private String delPreProject(Map<String, Object> result) throws Exception {
		int res=0;
		String errorMsg="删除失败";
		int preProjectReimbursementNumberId=BaseHelpUtils.getIntValue(result,"preProjectReimbursementNumberId");
		String code=BaseHelpUtils.getStringValue(result, "customNumber");
		BaseCollection<BasePreProjectReimbursementNumber> bc = new BaseCollection<>();
		if(!CodingIsused.getPreProjectCode(preProjectReimbursementNumberId)){
			PreProjectReimbursementNumber pp=new PreProjectReimbursementNumber();
			pp.setConditionPreProjectReimbursementNumberId("=",preProjectReimbursementNumberId);
			res=pp.conditionalDelete();
			return bc.toJSON(res, errorMsg);
		}else{
			errorMsg="前期项目编号已被使用不能删除";
			return bc.toJSON(-1, errorMsg);
		}
		
	}
	 
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
