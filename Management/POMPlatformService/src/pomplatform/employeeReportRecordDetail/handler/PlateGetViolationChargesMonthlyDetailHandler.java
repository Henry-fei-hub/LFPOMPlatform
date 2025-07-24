package pomplatform.employeeReportRecordDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.employeeReportRecordDetail.bean.BasePlateGetViolationChargesMonthlyDetail;
import pomplatform.employeeReportRecordDetail.bean.ConditionPlateGetViolationChargesMonthlyDetail;
import pomplatform.employeeReportRecordDetail.query.QueryPlateGetViolationChargesMonthlyDetail;
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

public class PlateGetViolationChargesMonthlyDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateGetViolationChargesMonthlyDetailHandler.class);

	public static BaseCollection<BasePlateGetViolationChargesMonthlyDetail> executeQueryPlateGetViolationChargesMonthlyDetail(ConditionPlateGetViolationChargesMonthlyDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateGetViolationChargesMonthlyDetail dao = new QueryPlateGetViolationChargesMonthlyDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateGetViolationChargesMonthlyDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPlateGetViolationChargesMonthlyDetail c = new ConditionPlateGetViolationChargesMonthlyDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePlateGetViolationChargesMonthlyDetail> result = executeQueryPlateGetViolationChargesMonthlyDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePlateGetViolationChargesMonthlyDetail> result;
		ConditionPlateGetViolationChargesMonthlyDetail c = new ConditionPlateGetViolationChargesMonthlyDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPlateGetViolationChargesMonthlyDetail dao = new QueryPlateGetViolationChargesMonthlyDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateGetViolationChargesMonthlyDetail.ALL_CAPTIONS);
			for(BasePlateGetViolationChargesMonthlyDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


