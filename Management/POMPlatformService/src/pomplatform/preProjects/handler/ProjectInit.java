package pomplatform.preProjects.handler;

import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BasePreProjectRecord;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectInit implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		Date currentDate = new Date();
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		int  preProjectId=BaseHelpUtils.getIntValue(params.get("preProjectId"));
		PreProject dao=new PreProject();
		PreProjectRecord recordDao=new PreProjectRecord();
		dao.setConditionPreProjectId("=", preProjectId);
		List<BasePreProject> list=dao.conditionalLoad();
		//如果前期项目表此数据存在
		if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
			recordDao.setConditionPreProjectId("=", preProjectId);
			List<BasePreProjectRecord> listRecord=recordDao.conditionalLoad(" order by register_date desc");
			//如果前期项目记录表此条数据存在	
			if(!BaseHelpUtils.isNullOrEmpty(listRecord)&&listRecord.size()>0) {
				//把前期项目记录表最近的台账的记录时间设置为当前系统时间
				Date rdate=BaseHelpUtils.getDateValue(listRecord.get(0).getRegisterDate());
				recordDao.setConditionRegisterDate("=", rdate);;
				recordDao.setRegisterDate(currentDate);
				recordDao.conditionalUpdate();
				//把前期项目表的修改时间设置为当前系统时间
				dao.setInfoRegisterTime(currentDate);
				dao.conditionalUpdate();
			}else {//如果前期项目记录表此条数据不存在,则修改前期项目表中该项目的修改时间info_register_time
				dao.setInfoRegisterTime(currentDate);
				dao.conditionalUpdate();
			}
			return bc.toJSON();
		}else {
			
			return bc.toJSON(-1, "前期项目不存在此项目");
		}
	}
}


