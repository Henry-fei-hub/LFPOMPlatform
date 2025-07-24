package pomplatform.supplierworkflow.handler;

import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class GetSupplierInfo implements GenericProcessor{


	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, "optType");
		switch(optType) {
		case "supplieTypeInfo":
			return supplieTypeInfo(params);
		default:
			return null;
		}
	}


	public String supplieTypeInfo(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection<>(); 

		int type=BaseHelpUtils.getIntValue(params.get("params"));


		Map<Integer, String> linkHashMap=new LinkedHashMap<>();
		SystemDictionary  dao=new SystemDictionary();
		dao.setConditionDicTypeId("=", 229);
		if(type>0) {
			dao.setConditionDicTypeValueId("=", type);
		}
		List<BaseSystemDictionary> list=dao.conditionalLoad();
		for (BaseSystemDictionary baseSystemDictionary : list) {
			Integer dicTypeValueId=BaseHelpUtils.getIntValue(baseSystemDictionary.getDicTypeValueId());
			String dicTypeValue=BaseHelpUtils.getString(baseSystemDictionary.getDicTypeValue());
			linkHashMap.put(dicTypeValueId, dicTypeValue);
		}
		bc.setUserData(linkHashMap);

		return bc.toJSON(0,"");
	}

}
