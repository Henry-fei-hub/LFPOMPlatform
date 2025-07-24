package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseSspecialdeductionsepor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductionsepor;
import pomplatform.specialDeduction.query.QuerySspecialdeductionsepor;
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

public class SspecialdeductionseporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SspecialdeductionseporHandler.class);

	public static BaseCollection<BaseSspecialdeductionsepor> executeQuerySspecialdeductionsepor(ConditionSspecialdeductionsepor c, KeyValuePair[] replacements ) throws Exception {
		QuerySspecialdeductionsepor dao = new QuerySspecialdeductionsepor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSspecialdeductionsepor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSspecialdeductionsepor c = new ConditionSspecialdeductionsepor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSspecialdeductionsepor> result = executeQuerySspecialdeductionsepor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSspecialdeductionsepor> result;
		ConditionSspecialdeductionsepor c = new ConditionSspecialdeductionsepor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySspecialdeductionsepor dao = new QuerySspecialdeductionsepor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSspecialdeductionsepor.ALL_CAPTIONS);
			for(BaseSspecialdeductionsepor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


