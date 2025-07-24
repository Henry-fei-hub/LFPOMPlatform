package pomplatform.k3voucher.handler;

import org.apache.log4j.Logger;
import pomplatform.k3voucher.bean.BaseBankTransVoucherInfo;
import pomplatform.k3voucher.bean.ConditionBankTransVoucherInfo;
import pomplatform.k3voucher.query.QueryBankTransVoucherInfo;
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

public class BankTransVoucherInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BankTransVoucherInfoHandler.class);

	public static BaseCollection<BaseBankTransVoucherInfo> executeQueryBankTransVoucherInfo(ConditionBankTransVoucherInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryBankTransVoucherInfo dao = new QueryBankTransVoucherInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBankTransVoucherInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBankTransVoucherInfo c = new ConditionBankTransVoucherInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBankTransVoucherInfo> result = executeQueryBankTransVoucherInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBankTransVoucherInfo> result;
		ConditionBankTransVoucherInfo c = new ConditionBankTransVoucherInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBankTransVoucherInfo dao = new QueryBankTransVoucherInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBankTransVoucherInfo.ALL_CAPTIONS);
			for(BaseBankTransVoucherInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


