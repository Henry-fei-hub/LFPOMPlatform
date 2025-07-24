package pomplatform.OnRevenue.handler;

import org.apache.log4j.Logger;
import pomplatform.OnRevenue.bean.BaseOnFinishPercentOfRevenue;
import pomplatform.OnRevenue.bean.ConditionOnFinishPercentOfRevenue;
import pomplatform.OnRevenue.query.QueryOnFinishPercentOfRevenue;
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

public class OnFinishPercentOfRevenueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnFinishPercentOfRevenueHandler.class);

	public static BaseCollection<BaseOnFinishPercentOfRevenue> executeQueryOnFinishPercentOfRevenue(ConditionOnFinishPercentOfRevenue c, KeyValuePair[] replacements ) throws Exception {
		QueryOnFinishPercentOfRevenue dao = new QueryOnFinishPercentOfRevenue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnFinishPercentOfRevenue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnFinishPercentOfRevenue c = new ConditionOnFinishPercentOfRevenue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnFinishPercentOfRevenue> result = executeQueryOnFinishPercentOfRevenue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnFinishPercentOfRevenue> result;
		ConditionOnFinishPercentOfRevenue c = new ConditionOnFinishPercentOfRevenue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnFinishPercentOfRevenue dao = new QueryOnFinishPercentOfRevenue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnFinishPercentOfRevenue.ALL_CAPTIONS);
			for(BaseOnFinishPercentOfRevenue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


