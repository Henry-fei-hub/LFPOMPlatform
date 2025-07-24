package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOfResignationApplyEmp;
import pomplatform.report.bean.ConditionReportOfResignationApplyEmp;
import pomplatform.report.query.QueryReportOfResignationApplyEmp;
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

public class ReportOfResignationApplyEmpHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOfResignationApplyEmpHandler.class);

	public static BaseCollection<BaseReportOfResignationApplyEmp> executeQueryReportOfResignationApplyEmp(ConditionReportOfResignationApplyEmp c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOfResignationApplyEmp dao = new QueryReportOfResignationApplyEmp();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOfResignationApplyEmp> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOfResignationApplyEmp c = new ConditionReportOfResignationApplyEmp();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOfResignationApplyEmp> result = executeQueryReportOfResignationApplyEmp(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOfResignationApplyEmp> result;
		ConditionReportOfResignationApplyEmp c = new ConditionReportOfResignationApplyEmp();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOfResignationApplyEmp dao = new QueryReportOfResignationApplyEmp();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOfResignationApplyEmp.ALL_CAPTIONS);
			for(BaseReportOfResignationApplyEmp b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


