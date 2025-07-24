package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnGetBenefitsOfEmployee;
import pomplatform.account.bean.ConditionOnGetBenefitsOfEmployee;
import pomplatform.account.query.QueryOnGetBenefitsOfEmployee;
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

public class OnGetBenefitsOfEmployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnGetBenefitsOfEmployeeHandler.class);

	public static BaseCollection<BaseOnGetBenefitsOfEmployee> executeQueryOnGetBenefitsOfEmployee(ConditionOnGetBenefitsOfEmployee c, KeyValuePair[] replacements ) throws Exception {
		QueryOnGetBenefitsOfEmployee dao = new QueryOnGetBenefitsOfEmployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnGetBenefitsOfEmployee> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnGetBenefitsOfEmployee c = new ConditionOnGetBenefitsOfEmployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnGetBenefitsOfEmployee> result = executeQueryOnGetBenefitsOfEmployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnGetBenefitsOfEmployee> result;
		ConditionOnGetBenefitsOfEmployee c = new ConditionOnGetBenefitsOfEmployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnGetBenefitsOfEmployee dao = new QueryOnGetBenefitsOfEmployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnGetBenefitsOfEmployee.ALL_CAPTIONS);
			for(BaseOnGetBenefitsOfEmployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


