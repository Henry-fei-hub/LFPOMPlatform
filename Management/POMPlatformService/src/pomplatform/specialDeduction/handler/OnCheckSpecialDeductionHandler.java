package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseOnCheckSpecialDeduction;
import pomplatform.specialDeduction.bean.ConditionOnCheckSpecialDeduction;
import pomplatform.specialDeduction.query.QueryOnCheckSpecialDeduction;
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

public class OnCheckSpecialDeductionHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnCheckSpecialDeductionHandler.class);

	public static BaseCollection<BaseOnCheckSpecialDeduction> executeQueryOnCheckSpecialDeduction(ConditionOnCheckSpecialDeduction c, KeyValuePair[] replacements ) throws Exception {
		QueryOnCheckSpecialDeduction dao = new QueryOnCheckSpecialDeduction();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnCheckSpecialDeduction> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnCheckSpecialDeduction c = new ConditionOnCheckSpecialDeduction();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnCheckSpecialDeduction> result = executeQueryOnCheckSpecialDeduction(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnCheckSpecialDeduction> result;
		ConditionOnCheckSpecialDeduction c = new ConditionOnCheckSpecialDeduction();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnCheckSpecialDeduction dao = new QueryOnCheckSpecialDeduction();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnCheckSpecialDeduction.ALL_CAPTIONS);
			for(BaseOnCheckSpecialDeduction b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


