package pomplatform.project.business;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseHelpUtils;

public class OnRevenueSureWarnTask extends TimerTask {

	@Override
	public void run() {
		try {
			Calendar ca = Calendar.getInstance();
			int day = ca.get(Calendar.DAY_OF_WEEK);
			if(day==2) {//表示周一
				Project dao = new Project();
				dao.setConditionStatus("=",5);
				List<BaseProject> list = dao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(list)) {
					dao.setStatus(2);
					dao.conditionalUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
