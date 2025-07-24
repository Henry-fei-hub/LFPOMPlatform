package pomplatform.exchangerate.business;

import java.io.StringReader;
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
import pomplatform.common.utils.StaticUtils;

public class ExchangeRateProcessor implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch(optType){
		case "saveCurrencyType":
			return saveCurrencyType(params);
		default:
			return null;
		}
	}
	
	public String saveCurrencyType(Map<String, Object> params) throws Exception{
		BaseCollection bc = new BaseCollection<>();
		String currency = BaseHelpUtils.getString(params.get("currency"));
		if(!BaseHelpUtils.isNullOrEmpty(currency)){
			SystemDictionary dao = new SystemDictionary();
			dao.setConditionDicTypeValue("=", currency);
			dao.setConditionDicTypeId("=", StaticUtils.SYSTEM_DICTIONARY_CURRENCY);
			if(dao.countRows() > 0){
				 return bc.toJSON(-1, "货币种类：" + currency + "已存在，请不要重复添加");
			}
			dao.clearConditions();
			dao.setConditionDicTypeId("=", StaticUtils.SYSTEM_DICTIONARY_CURRENCY);
			List<BaseSystemDictionary> list = dao.conditionalLoad("order by " + BaseSystemDictionary.CS_DIC_TYPE_VALUE_ID + " desc limit 1");
			if(null != list && !list.isEmpty()){
				BaseSystemDictionary bean = list.get(0);
				dao.setDicTypeValueId(bean.getDicTypeValueId() + 1);
			}else{
				dao.setDicTypeValueId(1);
			}
			dao.setDicTypeId(StaticUtils.SYSTEM_DICTIONARY_CURRENCY);
			dao.setDicTypeName(StaticUtils.SYSTEM_DICTIONARY_CURRENCY_STR);
			dao.setDicTypeValue(currency);
			dao.setDicIsEnable(true);
			dao.save();
			return bc.toJSON();
		}else{
			return bc.toJSON(-1, "货币种类不能为空");
		}
	}
	
}
