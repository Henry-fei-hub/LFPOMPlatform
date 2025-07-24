package pomplatform.domain.handler;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import pomplatform.Memployeeerpor.bean.BaseMemployeeerpor;
import pomplatform.Memployeeerpor.bean.ConditionMemployeeerpor;
import pomplatform.Memployeeerpor.query.QueryMemployeeerpor;

public class SelectIntegrationManager implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		QueryMemployeeerpor dao = new QueryMemployeeerpor();
		ConditionMemployeeerpor c = new ConditionMemployeeerpor();
		c.setDataFromJSON(creteria);
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeerpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result.toJSON(1, "");
	}
}
