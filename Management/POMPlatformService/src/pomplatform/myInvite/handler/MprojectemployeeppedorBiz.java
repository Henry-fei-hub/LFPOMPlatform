package pomplatform.myInvite.handler;

import delicacy.common.BaseCollection;
import delicacy.common.GenericQuery;
import pomplatform.myInvite.bean.BaseMprojectemployeeppedor;
import pomplatform.myInvite.bean.ConditionMprojectemployeeppedor;
import static pomplatform.myInvite.handler.MprojectemployeeppedorHandler.executeQueryMprojectemployeeppedor;

/**
 *
 * @author guangxun
 */
public class MprojectemployeeppedorBiz implements GenericQuery {

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojectemployeeppedor c = new ConditionMprojectemployeeppedor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojectemployeeppedor> result = executeQueryMprojectemployeeppedor(c, c.getKeyValues());
		result.getCollections().stream().forEach((BaseMprojectemployeeppedor bmp) -> {
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
