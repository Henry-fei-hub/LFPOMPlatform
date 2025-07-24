
package pomplatform.workinghour.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseWorkingHour;
import com.pomplatform.db.dao.WorkingHour;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class WorkingHourProcessor implements GenericProcessor {


	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, "optType");
		switch (optType) {
			case "lockOrUnlockWorkingHour":
				return lockOrUnlockWorkingHour(params);
			default:
				return null;
		}
	}

	/**
	 * 工时记录加锁/解锁
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	private String lockOrUnlockWorkingHour(Map<String, Object> params) throws SQLException {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String[] idStr = BaseHelpUtils.getString(params.get("ids")).split(",");
		boolean isLock = BaseHelpUtils.getBoolean(params.get("isLock"));
		if(BaseHelpUtils.isNullOrEmpty(idStr)) {
			String str = null;
			if(isLock) {
				str = "请选择需要加锁的工时记录";
			}else {
				str = "请选择需要解锁的工时记录";
			}
			return bc.toJSON(-1, str);
		}
		int length = idStr.length;
		Integer[] ids = new Integer[length];
		for(int i = 0; i < length; i++) {
			ids[i] = BaseHelpUtils.getIntValue(idStr[i]);
		}
		WorkingHour dao = new WorkingHour();
		dao.setIsLock(isLock);
		dao.addCondition(BaseWorkingHour.CS_WORKING_HOUR_ID, "in", (Object[])ids);
		dao.conditionalUpdate();
		return bc.toJSON();
	}

}
