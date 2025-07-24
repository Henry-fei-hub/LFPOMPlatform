package pomplatform.account.business;

import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.dao.PlateIntegralSend;
import com.pomplatform.db.handler.PlateIntegralSendHandler;

public class CustomPlateIntegralSendHandler extends PlateIntegralSendHandler {

	@Override
	public String saveOrUpdate(String json) throws Exception {
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(json);
		PlateIntegralSend dao = new PlateIntegralSend();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if (dao.isPrimaryKeyNull()) {
			dao.setDataFromBase(bean);
			ret = dao.save();
			bean = dao.generateBase();
		} else if (dao.load()) {
			dao.setDataFromBase(bean);
			ret = dao.update();
			bean = dao.generateBase();
			//插入统计公司补贴数据
			AccountManageProcess.onSavePlateAccount(dao.getPlateId(), dao.getPlateIntegralSendId(), AccountManageProcess.PLATE_BT_COMPANY_SUBSIDY, dao.getSendIntegral(), dao.getSendDate(), dao.getRemark(), dao.getEmployeeId());
		}
		return bean.toOneLineJSON(ret, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIntegralSend bean = new BasePlateIntegralSend();
		bean.setDataFromJSON(json);
		PlateIntegralSend dao = new PlateIntegralSend();
		setDeleteConditions(bean, dao);
		dao.executeQueryOneRow();
		AccountManageProcess.onDeletePalteAccount(dao.getPlateIntegralSendId(), AccountManageProcess.PLATE_BT_COMPANY_SUBSIDY);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}
	
}
