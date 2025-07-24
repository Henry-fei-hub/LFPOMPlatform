package pomplatform.k3voucher.handler;

import org.apache.log4j.Logger;
import pomplatform.k3voucher.bean.BaseGenerateCapitalVoucher;
import pomplatform.k3voucher.bean.ConditionGenerateCapitalVoucher;
import pomplatform.k3voucher.query.QueryGenerateCapitalVoucher;
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

public class GenerateCapitalVoucherHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GenerateCapitalVoucherHandler.class);

	public static BaseCollection<BaseGenerateCapitalVoucher> executeQueryGenerateCapitalVoucher(ConditionGenerateCapitalVoucher c, KeyValuePair[] replacements ) throws Exception {
		QueryGenerateCapitalVoucher dao = new QueryGenerateCapitalVoucher();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGenerateCapitalVoucher> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGenerateCapitalVoucher c = new ConditionGenerateCapitalVoucher();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGenerateCapitalVoucher> result = executeQueryGenerateCapitalVoucher(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGenerateCapitalVoucher> result;
		ConditionGenerateCapitalVoucher c = new ConditionGenerateCapitalVoucher();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGenerateCapitalVoucher dao = new QueryGenerateCapitalVoucher();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGenerateCapitalVoucher.ALL_CAPTIONS);
			for(BaseGenerateCapitalVoucher b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


