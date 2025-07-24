package pomplatform.preProjects.handler;

import com.file.db.dao.FileManage;
import com.pomplatform.db.bean.BaseTrainingManagement;
import com.pomplatform.db.dao.TrainingManagement;
import com.pomplatform.db.handler.TrainingManagementHandler;

import delicacy.QRcode.QRCodeUtil;
import delicacy.connection.ThreadUtil;

public class TrainingManagementNewHandler extends TrainingManagementHandler {
	//重写物品管理的保存的方法
	@Override
	public String save(String json) throws Exception {
		BaseTrainingManagement bean = new BaseTrainingManagement();
		bean.setDataFromJSON(json);
		TrainingManagement dao = new TrainingManagement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		int traningManagementID = dao.getTrainingManagementId();
		QRCodeUtil qrCodeUtil = new QRCodeUtil();
		//生成不带LOGO的二维码
		String textt = "http://47.106.186.143:8888/minindex.html?state=id_"+traningManagementID+"__msgType_3__type_1"; 
		String url = ThreadUtil.getRealPath();
		String imagePath = QRCodeUtil.encode(textt, url, true);
		FileManage fmDao = new FileManage();
		fmDao.setFileUrl(imagePath);
		fmDao.save();
		dao.setFileManageId(fmDao.getFileId());
		dao.update();
		return dao.generateBase().toOneLineJSON(num, null);
	}
	
}
