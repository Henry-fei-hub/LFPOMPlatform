package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOfGenderAnalysisByDepartment;
import pomplatform.report.bean.ConditionReportOfGenderAnalysisByDepartment;
import pomplatform.report.query.QueryReportOfGenderAnalysisByDepartment;
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

public class ReportOfGenderAnalysisByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOfGenderAnalysisByDepartmentHandler.class);

	public static BaseCollection<BaseReportOfGenderAnalysisByDepartment> executeQueryReportOfGenderAnalysisByDepartment(ConditionReportOfGenderAnalysisByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOfGenderAnalysisByDepartment dao = new QueryReportOfGenderAnalysisByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOfGenderAnalysisByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOfGenderAnalysisByDepartment c = new ConditionReportOfGenderAnalysisByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOfGenderAnalysisByDepartment> result = executeQueryReportOfGenderAnalysisByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOfGenderAnalysisByDepartment> result;
		ConditionReportOfGenderAnalysisByDepartment c = new ConditionReportOfGenderAnalysisByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOfGenderAnalysisByDepartment dao = new QueryReportOfGenderAnalysisByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOfGenderAnalysisByDepartment.ALL_CAPTIONS);
			for(BaseReportOfGenderAnalysisByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


