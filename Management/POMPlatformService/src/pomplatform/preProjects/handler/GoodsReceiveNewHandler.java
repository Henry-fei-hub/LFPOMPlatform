package pomplatform.preProjects.handler;

import com.file.db.dao.FileManage;
import com.pomplatform.db.bean.BaseGoodsReceive;
import com.pomplatform.db.dao.GoodsReceive;
import com.pomplatform.db.handler.GoodsReceiveHandler;

import delicacy.QRcode.QRCodeUtil;
import delicacy.connection.ThreadUtil;

public class GoodsReceiveNewHandler extends GoodsReceiveHandler {

	@Override
	public String save(String json) throws Exception {
		BaseGoodsReceive bean = new BaseGoodsReceive();
		bean.setDataFromJSON(json);
		GoodsReceive dao = new GoodsReceive();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		int GoodsReceiveID = dao.getGoodsReceiveId();
		QRCodeUtil qrCodeUtil = new QRCodeUtil();
		//生成不带LOGO的二维码
		String textt = "http://erp.jaid.cn/minindex.html?state=id_"+GoodsReceiveID+"__msgType_3__type_2"; 
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
