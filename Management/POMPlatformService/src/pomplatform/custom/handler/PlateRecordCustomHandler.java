package pomplatform.custom.handler;

import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.handler.PlateRecordHandler;

import delicacy.common.BaseHelpUtils;
import pomplatform.common.utils.AccountUtils;

public class PlateRecordCustomHandler extends PlateRecordHandler {

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateRecord bean = new BasePlateRecord();
		bean.setDataFromJSON(json);
		PlateRecord dao = new PlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) {
			dao.setDataFromBase(bean); 
			ret = dao.save(); 
			int plateId = dao.getPlateRecordId();
			if(BaseHelpUtils.getIntValue(dao.getParentId()) > 0) {
				AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_LEVEL_2, dao.getPlateName(), null, true);
			}else {
				AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_LEVEL_1, dao.getPlateName(), null, true);
			}
			dao.setPlateId(plateId);
			dao.update();
			bean = dao.generateBase(); 
		}
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


