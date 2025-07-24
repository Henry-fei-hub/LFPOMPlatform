package pomplatform.k3code.handler;

import java.util.Date;

import com.pomplatform.db.bean.BaseK3Code;
import com.pomplatform.db.dao.K3Code;
import com.pomplatform.db.handler.K3CodeHandler;

public class K3CodeAutoUpdateTimeHandler extends K3CodeHandler{
	
	@Override
	public String update(String json) throws Exception {
		BaseK3Code bean = new BaseK3Code();
		bean.setDataFromJSON(json);
		bean.setUpdateTime(new Date());
		K3Code dao = new K3Code();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}
}
