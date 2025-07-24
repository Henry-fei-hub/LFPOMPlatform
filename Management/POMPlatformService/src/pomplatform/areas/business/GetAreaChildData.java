package pomplatform.areas.business;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.dao.Area;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;


public class GetAreaChildData implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		
		int parentId = BaseHelpUtils.getIntValue(params.get("parentId"));
		Area dao = new Area();
		dao.setConditionParentId("=", parentId);
		List<BaseArea> list = dao.conditionalLoad("order by area_id");
		BaseCollection<BaseArea> bc = new BaseCollection<>();
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			bc.setCollections(list);
		}
		return bc.toJSON(0, null);
    }
    
}
