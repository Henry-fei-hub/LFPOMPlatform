package pomplatform.report.business;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.report.bean.BaseReportOnEmployeeNumTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeNumTotal;
import pomplatform.report.query.QueryReportOnEmployeeNumTotal;

public class OnDownloadReportOnEmployeeNumTotal implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnDownloadReportOnEmployeeNumTotal.class);

	public static BaseCollection<BaseReportOnEmployeeNumTotal> executeQueryInsurance(ConditionReportOnEmployeeNumTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeNumTotal dao = new QueryReportOnEmployeeNumTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeNumTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeNumTotal c = new ConditionReportOnEmployeeNumTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeNumTotal> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeNumTotal> result;
		ConditionReportOnEmployeeNumTotal c = new ConditionReportOnEmployeeNumTotal();
		c.setDataFromJSON(creteria);
		QueryReportOnEmployeeNumTotal dao = new QueryReportOnEmployeeNumTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(DOWNLOAD_CAPTIONS);
			for(BaseReportOnEmployeeNumTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	public final static java.lang.String DOWNLOAD_CAPTIONS = "业务部门,1月初人数,1月末人数,1月平均人数,2月初人数,2月末人数,2月平均人数,3月初人数,3月末人数,3月平均人数,4月初人数,4月末人数,4月平均人数,5月初人数,5月末人数,5月平均人数,6月初人数,6月末人数,6月平均人数,7月初人数,7月末人数,7月平均人数,8月初人数,8月末人数,8月平均人数,9月初人数,9月末人数,9月平均人数,10月初人数,10月末人数,10月平均人数,11月初人数,11月末人数,11月平均人数,12月初人数,12月末人数,12月平均人数";


}


