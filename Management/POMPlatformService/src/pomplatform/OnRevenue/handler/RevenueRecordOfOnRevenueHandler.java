package pomplatform.OnRevenue.handler;

import org.apache.log4j.Logger;
import pomplatform.OnRevenue.bean.BaseRevenueRecordOfOnRevenue;
import pomplatform.OnRevenue.bean.ConditionRevenueRecordOfOnRevenue;
import pomplatform.OnRevenue.query.QueryRevenueRecordOfOnRevenue;
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

public class RevenueRecordOfOnRevenueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RevenueRecordOfOnRevenueHandler.class);

	public static BaseCollection<BaseRevenueRecordOfOnRevenue> executeQueryRevenueRecordOfOnRevenue(ConditionRevenueRecordOfOnRevenue c, KeyValuePair[] replacements ) throws Exception {
		QueryRevenueRecordOfOnRevenue dao = new QueryRevenueRecordOfOnRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRevenueRecordOfOnRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRevenueRecordOfOnRevenue c = new ConditionRevenueRecordOfOnRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRevenueRecordOfOnRevenue> result = executeQueryRevenueRecordOfOnRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRevenueRecordOfOnRevenue> result;
		ConditionRevenueRecordOfOnRevenue c = new ConditionRevenueRecordOfOnRevenue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRevenueRecordOfOnRevenue dao = new QueryRevenueRecordOfOnRevenue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRevenueRecordOfOnRevenue.ALL_CAPTIONS);
			for(BaseRevenueRecordOfOnRevenue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


