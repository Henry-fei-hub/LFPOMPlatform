package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseBillingInfo;
import pomplatform.report.bean.ConditionBillingInfo;
import pomplatform.report.query.QueryBillingInfo;
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

public class BillingInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BillingInfoHandler.class);

	public static BaseCollection<BaseBillingInfo> executeQueryBillingInfo(ConditionBillingInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryBillingInfo dao = new QueryBillingInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBillingInfo> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBillingInfo c = new ConditionBillingInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBillingInfo> result = executeQueryBillingInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBillingInfo> result;
		ConditionBillingInfo c = new ConditionBillingInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBillingInfo dao = new QueryBillingInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBillingInfo.ALL_CAPTIONS);
			for(BaseBillingInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


