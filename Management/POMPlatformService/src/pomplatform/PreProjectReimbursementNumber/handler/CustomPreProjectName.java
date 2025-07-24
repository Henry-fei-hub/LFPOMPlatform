package pomplatform.PreProjectReimbursementNumber.handler;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.dao.PreProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.ht.bean.BaseMainProject;
import pomplatform.ht.bean.ConditionMainProject;
import pomplatform.ht.query.QueryMainProject;
/**
 * 查询前期项目
 * @author lqw
 *
 */
public class CustomPreProjectName implements GenericProcessor {
	private static Logger __LOGGER = Logger.getLogger("");
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String,Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		
		PreProject dao = new PreProject();
		BasePreProject bean = new BasePreProject();
		
		int preProjectId = BaseHelpUtils.getIntValue(params.get("preProjectId"));
//		dao.setConditionPreProjectId("=", preProjectId);
		List<BasePreProject> result = dao.conditionalLoad();
		List<BasePreProject> ds=new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(result) && result.size()>0){
			for(BasePreProject e : result){
				StringBuffer tmp=new StringBuffer();
				tmp.append(e.getInfoCode());
				tmp.append("--");
				if(!BaseHelpUtils.isNullOrEmpty(e.getProjectCode())){
					tmp.append("(");
					tmp.append(e.getProjectCode());
					tmp.append(")");
				}
				tmp.append(e.getProjectName());
				e.setProjectName(tmp.toString());
				ds.add(e);
			}
		}
		BaseCollection<BasePreProject> bc = new BaseCollection<>();
		bc.setCollections(ds);
		return bc.toJSON(1, "");
	}
}
