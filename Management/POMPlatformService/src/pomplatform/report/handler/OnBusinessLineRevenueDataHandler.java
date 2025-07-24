package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseOnBusinessLineRevenueData;
import pomplatform.report.bean.ConditionOnBusinessLineRevenueData;
import pomplatform.report.query.QueryOnBusinessLineRevenueData;
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

public class OnBusinessLineRevenueDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnBusinessLineRevenueDataHandler.class);

	public static BaseCollection<BaseOnBusinessLineRevenueData> executeQueryOnBusinessLineRevenueData(ConditionOnBusinessLineRevenueData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnBusinessLineRevenueData dao = new QueryOnBusinessLineRevenueData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnBusinessLineRevenueData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnBusinessLineRevenueData c = new ConditionOnBusinessLineRevenueData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnBusinessLineRevenueData> result = executeQueryOnBusinessLineRevenueData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnBusinessLineRevenueData> result;
		ConditionOnBusinessLineRevenueData c = new ConditionOnBusinessLineRevenueData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnBusinessLineRevenueData dao = new QueryOnBusinessLineRevenueData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnBusinessLineRevenueData.CAPTIONS);
			for(BaseOnBusinessLineRevenueData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


