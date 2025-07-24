package pomplatform.OnRevenue.handler;

import org.apache.log4j.Logger;
import pomplatform.OnRevenue.bean.BaseAllSheetDataOfRevenue;
import pomplatform.OnRevenue.bean.ConditionAllSheetDataOfRevenue;
import pomplatform.OnRevenue.query.QueryAllSheetDataOfRevenue;
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

public class AllSheetDataOfRevenueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AllSheetDataOfRevenueHandler.class);

	public static BaseCollection<BaseAllSheetDataOfRevenue> executeQueryAllSheetDataOfRevenue(ConditionAllSheetDataOfRevenue c, KeyValuePair[] replacements ) throws Exception {
		QueryAllSheetDataOfRevenue dao = new QueryAllSheetDataOfRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAllSheetDataOfRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAllSheetDataOfRevenue c = new ConditionAllSheetDataOfRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAllSheetDataOfRevenue> result = executeQueryAllSheetDataOfRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAllSheetDataOfRevenue> result;
		ConditionAllSheetDataOfRevenue c = new ConditionAllSheetDataOfRevenue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAllSheetDataOfRevenue dao = new QueryAllSheetDataOfRevenue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAllSheetDataOfRevenue.ALL_CAPTIONS);
			for(BaseAllSheetDataOfRevenue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


