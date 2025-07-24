package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryEmpBonusByDepartment;
import pomplatform.payment.bean.ConditionOnSalaryEmpBonusByDepartment;
import pomplatform.payment.query.QueryOnSalaryEmpBonusByDepartment;
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

public class OnSalaryEmpBonusByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryEmpBonusByDepartmentHandler.class);

	public static BaseCollection<BaseOnSalaryEmpBonusByDepartment> executeQueryOnSalaryEmpBonusByDepartment(ConditionOnSalaryEmpBonusByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryEmpBonusByDepartment dao = new QueryOnSalaryEmpBonusByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryEmpBonusByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryEmpBonusByDepartment c = new ConditionOnSalaryEmpBonusByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryEmpBonusByDepartment> result = executeQueryOnSalaryEmpBonusByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryEmpBonusByDepartment> result;
		ConditionOnSalaryEmpBonusByDepartment c = new ConditionOnSalaryEmpBonusByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryEmpBonusByDepartment dao = new QueryOnSalaryEmpBonusByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryEmpBonusByDepartment.ALL_CAPTIONS);
			for(BaseOnSalaryEmpBonusByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


