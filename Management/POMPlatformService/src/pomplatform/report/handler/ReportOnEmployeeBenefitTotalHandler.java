package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeBenefitTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeBenefitTotal;
import pomplatform.report.query.QueryReportOnEmployeeBenefitTotal;
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

public class ReportOnEmployeeBenefitTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeBenefitTotalHandler.class);

	public static BaseCollection<BaseReportOnEmployeeBenefitTotal> executeQueryReportOnEmployeeBenefitTotal(ConditionReportOnEmployeeBenefitTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeBenefitTotal dao = new QueryReportOnEmployeeBenefitTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeBenefitTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeBenefitTotal c = new ConditionReportOnEmployeeBenefitTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeBenefitTotal> result = executeQueryReportOnEmployeeBenefitTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeBenefitTotal> result;
		ConditionReportOnEmployeeBenefitTotal c = new ConditionReportOnEmployeeBenefitTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeBenefitTotal dao = new QueryReportOnEmployeeBenefitTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeBenefitTotal.ALL_CAPTIONS);
			for(BaseReportOnEmployeeBenefitTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


