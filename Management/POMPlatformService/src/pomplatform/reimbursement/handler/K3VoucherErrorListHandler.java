package pomplatform.reimbursement.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseReceiveUnitManage;

import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class K3VoucherErrorListHandler implements GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(K3VoucherErrorListHandler.class);

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSON parser = new JSON(new StringReader(creteria)); 
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		List<BaseReceiveUnitManage> list = GenericBase.__getList(
                params.get("details"), BaseReceiveUnitManage.newInstance());
		if(list.size() > 0){
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println("名称,银行账号,错误");
				for(BaseReceiveUnitManage b : list){
					ps.println(toCSVString(b));
				}
			}
		}
	}

	public String toCSVString(BaseReceiveUnitManage bean) {
		if(null == bean)
			return ",,";
		StringBuilder sb = new StringBuilder();
		sb.append(bean.getReceiveUnit() == null ? "" : bean.getReceiveUnit());
		sb.append(",");
		sb.append(bean.getBankAccount() == null ? "" : bean.getBankAccount());
		sb.append(",");
		sb.append(bean.getReceiveUnitAddress() == null ? "" : bean.getReceiveUnitAddress());
		return sb.toString();
	}
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


