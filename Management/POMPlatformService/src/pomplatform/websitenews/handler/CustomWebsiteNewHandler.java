package pomplatform.websitenews.handler;

import com.pomplatform.db.bean.BaseWebsiteNew;
import com.pomplatform.db.dao.WebsiteNew;
import com.pomplatform.db.handler.WebsiteNewHandler;

import delicacy.common.ColumnChangedData;
import pomplatform.filemanage.business.FileManageProcessor;

public class CustomWebsiteNewHandler extends WebsiteNewHandler {

	@Override
	public String save(String json) throws Exception {
		BaseWebsiteNew bean = new BaseWebsiteNew();
		bean.setDataFromJSON(json);
		WebsiteNew dao = new WebsiteNew();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		// 增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());
		return bean.toOneLineJSON(num, null);
	}
	
	@Override
	public String update(String json) throws Exception {
		BaseWebsiteNew bean = new BaseWebsiteNew();
		bean.setDataFromJSON(json);
		WebsiteNew dao = new WebsiteNew();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		if (dao.load()) {
			dao.setDataFromBase(bean);
			//修改附件的引用次数
			ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseWebsiteNew.CS_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
			num = dao.update();
		}
		return bean.toOneLineJSON(num, null);
	}
}
