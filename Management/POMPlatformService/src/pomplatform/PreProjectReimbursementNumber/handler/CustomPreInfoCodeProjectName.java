package pomplatform.PreProjectReimbursementNumber.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import pomplatform.ht.bean.BaseMainProject;
import pomplatform.ht.bean.ConditionMainProject;
import pomplatform.ht.query.QueryMainProject;
/**
 * 查询项目经理
 * @author wull
 *
 */

public class CustomPreInfoCodeProjectName implements GenericProcessor {
	
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		QueryMainProject dao = new QueryMainProject();
		ConditionMainProject c = new ConditionMainProject();
		c.setDataFromJSON(creteria);
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMainProject> result = dao.executeQuery(c.getKeyValues(), c);
		List<BaseMainProject> l=result.getCollections();
		List<BaseMainProject> ds=new ArrayList<>();
		if(l.size()>0){
			for(BaseMainProject base:l){
				StringBuffer tmp=new StringBuffer();
				tmp.append(base.getInfoCode());
				tmp.append("--");
				if(!BaseHelpUtils.isNullOrEmpty(base.getProjectCode())){
					tmp.append("(");
					tmp.append(base.getProjectCode());
					tmp.append(")");
				}
				tmp.append(base.getProjectName());
				base.setProjectName(tmp.toString());
				ds.add(base);
			}
		}
		result.setCollections(ds);
		return result.toJSON(1, "");
	}
}
