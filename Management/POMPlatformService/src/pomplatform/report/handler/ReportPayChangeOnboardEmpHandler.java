package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportPayChangeOnboardEmp;
import pomplatform.report.bean.ConditionReportPayChangeOnboardEmp;
import pomplatform.report.query.QueryReportPayChangeOnboardEmp;
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

public class ReportPayChangeOnboardEmpHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportPayChangeOnboardEmpHandler.class);

	public static BaseCollection<BaseReportPayChangeOnboardEmp> executeQueryReportPayChangeOnboardEmp(ConditionReportPayChangeOnboardEmp c, KeyValuePair[] replacements ) throws Exception {
		QueryReportPayChangeOnboardEmp dao = new QueryReportPayChangeOnboardEmp();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportPayChangeOnboardEmp> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportPayChangeOnboardEmp c = new ConditionReportPayChangeOnboardEmp();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportPayChangeOnboardEmp> result = executeQueryReportPayChangeOnboardEmp(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportPayChangeOnboardEmp> result;
		ConditionReportPayChangeOnboardEmp c = new ConditionReportPayChangeOnboardEmp();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportPayChangeOnboardEmp dao = new QueryReportPayChangeOnboardEmp();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportPayChangeOnboardEmp.ALL_CAPTIONS);
			for(BaseReportPayChangeOnboardEmp b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


