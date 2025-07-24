package pomplatform.workinghour.handler;

import java.util.Date;

import com.pomplatform.db.bean.BaseWorkingHour;
import com.pomplatform.db.bean.BaseWorkingHourLinkPersonnelBusines;
import com.pomplatform.db.dao.WorkingHour;
import com.pomplatform.db.dao.WorkingHourLinkPersonnelBusines;
import com.pomplatform.db.handler.WorkingHourHandler;

import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;

public class CustomWorkingHourHandler extends WorkingHourHandler{

	@Override
	public String save(String json) throws Exception {
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
		if(!checkDate(bean)) {
			throw new Exception("工时记录需在7天内录入系统");
		}

		WorkingHour dao = new WorkingHour();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}
	
	@Override
	public String saveOrUpdate(String json) throws Exception {
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
		if(!checkDate(bean)) {
			throw new Exception("工时记录需在7天内录入系统");
		}
		WorkingHour dao = new WorkingHour();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}
	
	@Override
	public String update(String json) throws Exception {
		BaseWorkingHour bean = new BaseWorkingHour();
		bean.setDataFromJSON(json);
//		if(!checkDate(bean)) {
//			throw new Exception("工时记录需在7天内录入系统");
//		}
		WorkingHour dao = new WorkingHour();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){
			WorkingHourLinkPersonnelBusines base = new WorkingHourLinkPersonnelBusines();
			base.setConditionPersonnelBusinessId("=",dao.getPersonnelBusinessId());
			if(!BaseHelpUtils.isNullOrEmpty(dao.getProjectId())){
				base.setConditionProjectId("=",dao.getProjectId());
			}
			base.setConditionWorkHour("=",dao.getWorkHour());
			BaseWorkingHourLinkPersonnelBusines bases = base.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(bases)){
				base.clear();
				base.setDataFromBase(bases);
				base.setProjectId(bean.getProjectId());
				base.setWorkHour(bean.getWorkHour());
				base.update();
			}
			dao.setDataFromBase(bean); num = dao.update();



		}
		return bean.toOneLineJSON(num, null);
	}
	
	public boolean checkDate(BaseWorkingHour bean) throws Exception{
		if(null == bean || null == bean.getWorkDate()) {
			return false;
		}
		Date date = DateUtil.getNextDayOfDay(new Date(), -7);
		if(bean.getWorkDate().before(date)) {
			return false;
		}
		return true;
	}
}
