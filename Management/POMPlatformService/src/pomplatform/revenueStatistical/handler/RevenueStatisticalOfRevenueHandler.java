package pomplatform.revenueStatistical.handler;

import org.apache.log4j.Logger;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.query.QueryRevenueStatisticalOfRevenue;
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

public class RevenueStatisticalOfRevenueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RevenueStatisticalOfRevenueHandler.class);

	public static BaseCollection<BaseRevenueStatisticalOfRevenue> executeQueryRevenueStatisticalOfRevenue(ConditionRevenueStatisticalOfRevenue c, KeyValuePair[] replacements ) throws Exception {
		QueryRevenueStatisticalOfRevenue dao = new QueryRevenueStatisticalOfRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRevenueStatisticalOfRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRevenueStatisticalOfRevenue> result = executeQueryRevenueStatisticalOfRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRevenueStatisticalOfRevenue> result;
		ConditionRevenueStatisticalOfRevenue c = new ConditionRevenueStatisticalOfRevenue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRevenueStatisticalOfRevenue dao = new QueryRevenueStatisticalOfRevenue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRevenueStatisticalOfRevenue.ALL_CAPTIONS);
			for(BaseRevenueStatisticalOfRevenue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


