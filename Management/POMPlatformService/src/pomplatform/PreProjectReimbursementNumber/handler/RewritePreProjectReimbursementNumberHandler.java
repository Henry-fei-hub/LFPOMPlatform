package pomplatform.PreProjectReimbursementNumber.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BasePreProjectReimbursementNumber;
import com.pomplatform.db.dao.PreProjectReimbursementNumber;
import com.pomplatform.db.handler.PreProjectReimbursementNumberHandler;

import delicacy.common.BaseHelpUtils;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
/**
 * 
 * @author wull
 *
 */
public class RewritePreProjectReimbursementNumberHandler extends PreProjectReimbursementNumberHandler  {
	@Override
	public String save(String json) throws Exception{
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(json)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(json));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		//创建前期项目编号
		String code=PreProjectCode.getPreProjectCode(result);
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		bean.setDataFromJSON(json);
		bean.setCustomNumber(code);
		PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(json)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(json));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		//创建前期项目编号
		String code=PreProjectCode.getPreProjectCode(result);
		BasePreProjectReimbursementNumber bean = new BasePreProjectReimbursementNumber();
		if(!CodingIsused.getPreProjectCode(bean.getPreProjectReimbursementNumberId())){
			bean.setDataFromJSON(json);
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
}

