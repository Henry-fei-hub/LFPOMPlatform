package pomplatform.api;

import java.io.StringReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.OutQuotation;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class HasDesignConsiderationHistory  implements GenericProcessor {
	
	
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection bc = new BaseCollection();
		Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String projectCode = BaseHelpUtils.getString(result.get("projectCode"));
        String infoCode = BaseHelpUtils.getString(result.get("infoCode"));
        if(BaseHelpUtils.isNullOrEmpty(projectCode)){
        	return bc.toJSON(-1,"项目编号不能为空");
        }else{
        	DesignConsideration dao = new DesignConsideration();
        	OutQuotation oqDao = new OutQuotation();
        	oqDao.setConditionInfoCode("=", infoCode);
        	oqDao.setConditionQuotationStatus("=", 1);
        	BaseOutQuotation oqBean = oqDao.executeQueryOneRow();
        	if(BaseHelpUtils.isNullOrEmpty(oqBean)){
        		return bc.toJSON(-1,"没有成功的报价单");
        	}else{
        		dao.setConditionOutQuotationId("=", oqBean.getOutQuotationId());
        		dao.setConditionContractId("=", 0);
        		if(dao.countRows()>0){//有产值单
        			return bc.toJSON(0,null);
        		}else{
        			return bc.toJSON(-1,"没有可用拆分价");
        		}
        	}
        }
	}
}
