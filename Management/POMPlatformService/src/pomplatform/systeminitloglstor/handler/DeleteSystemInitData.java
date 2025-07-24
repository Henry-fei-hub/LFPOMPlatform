package pomplatform.systeminitloglstor.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.bean.BaseSystemInitLog;
import com.pomplatform.db.dao.Area;
import com.pomplatform.db.dao.SystemInitLog;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class DeleteSystemInitData implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseSystemInitLog bean = new BaseSystemInitLog();
		SystemInitLog dao=new SystemInitLog();
		
		bean.setDataFromJSON(creteria);
		dao.setDataFromBase(bean);
		//List<BaseSystemInitLog> list = dao.conditionalLoad();
		dao.delete();
		dao.clear();
		List<BaseSystemInitLog> list = dao.conditionalLoad();
		//dao.setPrimaryKeyFromBase(b);
		BaseCollection<BaseSystemInitLog> bc = new BaseCollection<>();
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			bc.setCollections(list);
		}
		return bc.toJSON(0, null);
    }
	public static void main(String[] args) throws SQLException {
		BaseSystemInitLog bean = new BaseSystemInitLog();
		SystemInitLog aDao=new SystemInitLog();
		bean.setSystemInitLogId(4);
		aDao.setDataFromBase(bean);
		System.out.println(aDao.executeQueryOneRow().toJSONString());
	}

}
