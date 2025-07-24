package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnSalaryDepartmentBonusByPlate;
import pomplatform.payment.bean.ConditionOnSalaryDepartmentBonusByPlate;
import pomplatform.payment.query.QueryOnSalaryDepartmentBonusByPlate;
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

public class OnSalaryDepartmentBonusByPlateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSalaryDepartmentBonusByPlateHandler.class);

	public static BaseCollection<BaseOnSalaryDepartmentBonusByPlate> executeQueryOnSalaryDepartmentBonusByPlate(ConditionOnSalaryDepartmentBonusByPlate c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSalaryDepartmentBonusByPlate dao = new QueryOnSalaryDepartmentBonusByPlate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSalaryDepartmentBonusByPlate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSalaryDepartmentBonusByPlate c = new ConditionOnSalaryDepartmentBonusByPlate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSalaryDepartmentBonusByPlate> result = executeQueryOnSalaryDepartmentBonusByPlate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSalaryDepartmentBonusByPlate> result;
		ConditionOnSalaryDepartmentBonusByPlate c = new ConditionOnSalaryDepartmentBonusByPlate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSalaryDepartmentBonusByPlate dao = new QueryOnSalaryDepartmentBonusByPlate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSalaryDepartmentBonusByPlate.ALL_CAPTIONS);
			for(BaseOnSalaryDepartmentBonusByPlate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


