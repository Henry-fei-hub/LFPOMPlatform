package pomplatform.ht.handler;

import java.io.StringReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.OutDesignConsideration;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CheckDesignConsideration  implements GenericProcessor {
	
	
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection bc = new BaseCollection();
		Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String projectCode = BaseHelpUtils.getString(result.get("projectCode"));
        OutDesignConsideration dao = new OutDesignConsideration();
		dao.setConditionProjectCode("=", projectCode);
		if(dao.countRows()>0){//有报价单
			return bc.toJSON(0,null);
		}
		return bc.toJSON(-1,"没找到报价单");
	}
	
}
