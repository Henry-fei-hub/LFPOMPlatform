package pomplatform.attachmentManageMeeting.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.bean.BaseAttachmentManageMeeting;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseK3Voucher;
import com.pomplatform.db.bean.BaseProjectPerformance;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.bean.BaseSystemInitLog;
import com.pomplatform.db.dao.AttachmentManage;
import com.pomplatform.db.dao.AttachmentManageMeeting;
import com.pomplatform.db.dao.K3Voucher;
import com.pomplatform.db.dao.ReceiveUnitManage;
import com.pomplatform.db.dao.SystemInitLog;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class UpdateAttachmentProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		bean.setDataFromJSON(creteria);
		
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());

		return null;

	}

}
