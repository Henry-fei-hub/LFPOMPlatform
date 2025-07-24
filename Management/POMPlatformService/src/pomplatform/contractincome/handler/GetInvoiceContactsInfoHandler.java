package pomplatform.contractincome.handler;

import org.apache.log4j.Logger;
import pomplatform.contractincome.bean.BaseGetInvoiceContactsInfo;
import pomplatform.contractincome.bean.ConditionGetInvoiceContactsInfo;
import pomplatform.contractincome.query.QueryGetInvoiceContactsInfo;
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

public class GetInvoiceContactsInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetInvoiceContactsInfoHandler.class);

	public static BaseCollection<BaseGetInvoiceContactsInfo> executeQueryGetInvoiceContactsInfo(ConditionGetInvoiceContactsInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryGetInvoiceContactsInfo dao = new QueryGetInvoiceContactsInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetInvoiceContactsInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetInvoiceContactsInfo c = new ConditionGetInvoiceContactsInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetInvoiceContactsInfo> result = executeQueryGetInvoiceContactsInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetInvoiceContactsInfo> result;
		ConditionGetInvoiceContactsInfo c = new ConditionGetInvoiceContactsInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetInvoiceContactsInfo dao = new QueryGetInvoiceContactsInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetInvoiceContactsInfo.ALL_CAPTIONS);
			for(BaseGetInvoiceContactsInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


