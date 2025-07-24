package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOfGenderPlateMonth;
import pomplatform.report.bean.ConditionReportOfGenderPlateMonth;
import pomplatform.report.query.QueryReportOfGenderPlateMonth;
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

public class ReportOfGenderPlateMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOfGenderPlateMonthHandler.class);

	public static BaseCollection<BaseReportOfGenderPlateMonth> executeQueryReportOfGenderPlateMonth(ConditionReportOfGenderPlateMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOfGenderPlateMonth dao = new QueryReportOfGenderPlateMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOfGenderPlateMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOfGenderPlateMonth c = new ConditionReportOfGenderPlateMonth();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOfGenderPlateMonth> result = executeQueryReportOfGenderPlateMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOfGenderPlateMonth> result;
		ConditionReportOfGenderPlateMonth c = new ConditionReportOfGenderPlateMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOfGenderPlateMonth dao = new QueryReportOfGenderPlateMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOfGenderPlateMonth.ALL_CAPTIONS);
			for(BaseReportOfGenderPlateMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


