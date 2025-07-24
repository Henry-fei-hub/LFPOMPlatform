package pomplatform.k3voucher.handler;

import org.apache.log4j.Logger;
import pomplatform.k3voucher.bean.BaseAllVoucherDetail;
import pomplatform.k3voucher.bean.ConditionAllVoucherDetail;
import pomplatform.k3voucher.query.QueryAllVoucherDetail;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class AllVoucherDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AllVoucherDetailHandler.class);

	public static BaseCollection<BaseAllVoucherDetail> executeQueryAllVoucherDetail(ConditionAllVoucherDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryAllVoucherDetail dao = new QueryAllVoucherDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAllVoucherDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAllVoucherDetail c = new ConditionAllVoucherDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAllVoucherDetail> result = executeQueryAllVoucherDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAllVoucherDetail> result;
		ConditionAllVoucherDetail c = new ConditionAllVoucherDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAllVoucherDetail dao = new QueryAllVoucherDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAllVoucherDetail.ALL_CAPTIONS);
			for(BaseAllVoucherDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


