package pomplatform.OnRevenue.handler;

import org.apache.log4j.Logger;
import pomplatform.OnRevenue.bean.BaseRevenueYearRecordSubOfRevenue;
import pomplatform.OnRevenue.bean.ConditionRevenueYearRecordSubOfRevenue;
import pomplatform.OnRevenue.query.QueryRevenueYearRecordSubOfRevenue;
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

public class RevenueYearRecordSubOfRevenueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RevenueYearRecordSubOfRevenueHandler.class);

	public static BaseCollection<BaseRevenueYearRecordSubOfRevenue> executeQueryRevenueYearRecordSubOfRevenue(ConditionRevenueYearRecordSubOfRevenue c, KeyValuePair[] replacements ) throws Exception {
		QueryRevenueYearRecordSubOfRevenue dao = new QueryRevenueYearRecordSubOfRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRevenueYearRecordSubOfRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRevenueYearRecordSubOfRevenue c = new ConditionRevenueYearRecordSubOfRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRevenueYearRecordSubOfRevenue> result = executeQueryRevenueYearRecordSubOfRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRevenueYearRecordSubOfRevenue> result;
		ConditionRevenueYearRecordSubOfRevenue c = new ConditionRevenueYearRecordSubOfRevenue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRevenueYearRecordSubOfRevenue dao = new QueryRevenueYearRecordSubOfRevenue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRevenueYearRecordSubOfRevenue.ALL_CAPTIONS);
			for(BaseRevenueYearRecordSubOfRevenue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


