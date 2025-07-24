package pomplatform.PreProjectReimbursementNumber.handler;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.system.bean.BaseMemployee;
import delicacy.system.bean.ConditionMemployee;
import delicacy.system.query.QueryMemployee;
/**
 * 查询项目经理
 * @author wull
 *
 */
public class CustomProjectManager implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		QueryMemployee dao = new QueryMemployee();
		ConditionMemployee c = new ConditionMemployee();
		c.setDataFromJSON(creteria);
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		
		KeyValuePair [] kvArra = new KeyValuePair[5];
		KeyValuePair kv = new KeyValuePair();
		kv.setKey("(EXTRACT(YEAR from onboard_date))");
		kv.setValue("1");
		kvArra[0] = kv; 
		
		KeyValuePair kv1 = new KeyValuePair();
		kv1.setKey("(EXTRACT(MONTH from onboard_date))");
		kv1.setValue("1");
		kvArra[1] = kv1; 
		
		KeyValuePair kv2 = new KeyValuePair();
		kv2.setKey("(EXTRACT(YEAR from resignation_date))");
		kv2.setValue("1");
		kvArra[2] = kv2; 
		
		KeyValuePair kv3 = new KeyValuePair();
		kv3.setKey("(EXTRACT(MONTH from resignation_date))");
		kv3.setValue("1");
		kvArra[3] = kv3; 
		c.setKeyValues(kvArra);
		
		KeyValuePair kv4 = new KeyValuePair();
		kv4.setKey("(EXTRACT(MONTH from birth))");
		kv4.setValue("1");
		kvArra[4] = kv4; 
		c.setKeyValues(kvArra);
		
		BaseCollection<BaseMemployee> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result.toJSON(1, "");
	}
}
