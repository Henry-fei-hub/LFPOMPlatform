package pomplatform.cmbcinfo.business;

import java.util.Date;
import java.util.TimerTask;

import delicacy.date.util.DateUtil;

public class SyncCmbDataToErpTimer extends TimerTask {

	@Override
	public void run() {
		try {
			//同步账户详细信息数据
			CmbBusinessProcess.syncCmbBankInfoDataToErp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			//同步所有账户交易数据
			//为防止查询出现遗漏  将前后天进行重查
			Date currentDate = new Date();
			Date beginDate = DateUtil.getNextDayOfDay(currentDate, -1);
			Date endDate = DateUtil.getNextDayOfDay(currentDate, 1);
			CmbBusinessProcess.syncAllAccountTransInfoDataToErp(beginDate, endDate, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
