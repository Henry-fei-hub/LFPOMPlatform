package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryAnnualBonusByDepartment;
import pomplatform.payment.bean.ConditionOnSalaryAnnualBonusByDepartment;
import pomplatform.payment.query.QueryOnSalaryAnnualBonusByDepartment;
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

public class OnSalaryAnnualBonusByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryAnnualBonusByDepartmentHandler.class);

	public static BaseCollection<BaseOnSalaryAnnualBonusByDepartment> executeQueryOnSalaryAnnualBonusByDepartment(ConditionOnSalaryAnnualBonusByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryAnnualBonusByDepartment dao = new QueryOnSalaryAnnualBonusByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryAnnualBonusByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryAnnualBonusByDepartment c = new ConditionOnSalaryAnnualBonusByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryAnnualBonusByDepartment> result = executeQueryOnSalaryAnnualBonusByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryAnnualBonusByDepartment> result;
		ConditionOnSalaryAnnualBonusByDepartment c = new ConditionOnSalaryAnnualBonusByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryAnnualBonusByDepartment dao = new QueryOnSalaryAnnualBonusByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryAnnualBonusByDepartment.ALL_CAPTIONS);
			for(BaseOnSalaryAnnualBonusByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


