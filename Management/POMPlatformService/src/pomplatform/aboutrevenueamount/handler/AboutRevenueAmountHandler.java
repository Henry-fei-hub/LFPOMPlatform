package pomplatform.aboutrevenueamount.handler;

import org.apache.log4j.Logger;
import pomplatform.aboutrevenueamount.bean.BaseAboutRevenueAmount;
import pomplatform.aboutrevenueamount.bean.ConditionAboutRevenueAmount;
import pomplatform.aboutrevenueamount.query.QueryAboutRevenueAmount;
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

public class AboutRevenueAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AboutRevenueAmountHandler.class);

	public static BaseCollection<BaseAboutRevenueAmount> executeQueryAboutRevenueAmount(ConditionAboutRevenueAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryAboutRevenueAmount dao = new QueryAboutRevenueAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAboutRevenueAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAboutRevenueAmount c = new ConditionAboutRevenueAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAboutRevenueAmount> result = executeQueryAboutRevenueAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAboutRevenueAmount> result;
		ConditionAboutRevenueAmount c = new ConditionAboutRevenueAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAboutRevenueAmount dao = new QueryAboutRevenueAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAboutRevenueAmount.ALL_CAPTIONS);
			for(BaseAboutRevenueAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


