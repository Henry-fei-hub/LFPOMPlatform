package pomplatform.PreProjectReimbursementNumber.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import pomplatform.PreProjectReimbursementNumber.bean.BasePreProjectReimbursementNumbers;
import pomplatform.PreProjectReimbursementNumber.bean.ConditionPreProjectReimbursementNumbers;
import pomplatform.PreProjectReimbursementNumber.query.QueryPreProjectReimbursementNumbers;
/**
 * 查询前期项目列表
 * @author wull
 *
 */
public class CustomPreCodeProjectName implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		QueryPreProjectReimbursementNumbers dao = new QueryPreProjectReimbursementNumbers();
		ConditionPreProjectReimbursementNumbers c = new ConditionPreProjectReimbursementNumbers();
		c.setDataFromJSON(creteria);
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePreProjectReimbursementNumbers> result = dao.executeQuery( c.getKeyValues(), c) ;
		List<BasePreProjectReimbursementNumbers> l=result.getCollections();
		List<BasePreProjectReimbursementNumbers> ds=new ArrayList<>();
		if(l.size()>0){
			for(BasePreProjectReimbursementNumbers base:l){
				StringBuffer tmp=new StringBuffer();
				tmp.append(base.getCustomNumber());
				tmp.append("--");
				tmp.append(base.getProjectName());
				tmp.append("--");
				tmp.append(base.getPlateId());
				base.setProjectName(tmp.toString());
				ds.add(base);
			}
		}
		result.setCollections(ds);
		return result.toJSON(1, "");
	}
}
