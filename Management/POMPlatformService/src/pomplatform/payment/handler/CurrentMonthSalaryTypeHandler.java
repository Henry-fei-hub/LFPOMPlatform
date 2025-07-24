package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseCurrentMonthSalaryType;
import pomplatform.payment.bean.ConditionCurrentMonthSalaryType;
import pomplatform.payment.query.QueryCurrentMonthSalaryType;
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

public class CurrentMonthSalaryTypeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CurrentMonthSalaryTypeHandler.class);

	public static BaseCollection<BaseCurrentMonthSalaryType> executeQueryCurrentMonthSalaryType(ConditionCurrentMonthSalaryType c, KeyValuePair[] replacements ) throws Exception {
		QueryCurrentMonthSalaryType dao = new QueryCurrentMonthSalaryType();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCurrentMonthSalaryType> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCurrentMonthSalaryType c = new ConditionCurrentMonthSalaryType();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCurrentMonthSalaryType> result = executeQueryCurrentMonthSalaryType(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCurrentMonthSalaryType> result;
		ConditionCurrentMonthSalaryType c = new ConditionCurrentMonthSalaryType();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCurrentMonthSalaryType dao = new QueryCurrentMonthSalaryType();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCurrentMonthSalaryType.ALL_CAPTIONS);
			for(BaseCurrentMonthSalaryType b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


