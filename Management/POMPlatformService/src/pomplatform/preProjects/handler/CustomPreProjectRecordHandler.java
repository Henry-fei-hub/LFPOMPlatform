package pomplatform.preProjects.handler;

import com.pomplatform.db.bean.BasePreProjectRecord;
import com.pomplatform.db.dao.PreProjectRecord;
import com.pomplatform.db.handler.PreProjectRecordHandler;

import delicacy.common.ColumnChangedData;
import pomplatform.filemanage.business.FileManageProcessor;

public class CustomPreProjectRecordHandler extends PreProjectRecordHandler
{
	@Override
	public String delete(String json) throws Exception
	{
		BasePreProjectRecord bean = new BasePreProjectRecord();
		bean.setDataFromJSON(json);
		PreProjectRecord dao = new PreProjectRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception
	{
		BasePreProjectRecord bean = new BasePreProjectRecord();
		bean.setDataFromJSON(json);
		PreProjectRecord dao = new PreProjectRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		if (dao.load())
		{
			dao.setDataFromBase(bean);
			ColumnChangedData columnChangedData = dao.getColumnChangedData(BasePreProjectRecord.CS_ATTACHMENT_ID);
			//	修改附件的引用次数
			FileManageProcessor.upadteTimesByColumnChangedData(columnChangedData);
			num = dao.update();
		}
		return bean.toOneLineJSON(num, null);
	}
}
