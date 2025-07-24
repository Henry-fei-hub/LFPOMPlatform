package pomplatform.operation.handler;

import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import javax.servlet.http.HttpServletRequest;
import pomplatform.operation.bean.BaseMprojectemployeeepor;
import pomplatform.operation.bean.ConditionMprojectemployeeepor;
import static pomplatform.operation.handler.MprojectemployeeeporHandler.executeQueryMprojectemployeeepor;

/**
 *
 * @author guangxun
 */
public class MprojectemployeeeporBiz implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ConditionMprojectemployeeepor c = new ConditionMprojectemployeeepor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectemployeeepor> result = executeQueryMprojectemployeeepor(c, c.getKeyValues());
		result.getCollections().stream().forEach((BaseMprojectemployeeepor bmp) -> {
			int idx = -1;
			if ((idx = bmp.getPhoto().lastIndexOf("/images/photos")) >= 0) {
				bmp.setPhoto(bmp.getPhoto().substring(idx));
			}else{
				bmp.setPhoto("/images/photos/".concat(bmp.getPhoto()));
			}
		});
		return result.toJSON(null);
	}
	
}
