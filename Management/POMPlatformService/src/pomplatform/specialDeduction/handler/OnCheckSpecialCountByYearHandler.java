package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseOnCheckSpecialCountByYear;
import pomplatform.specialDeduction.bean.ConditionOnCheckSpecialCountByYear;
import pomplatform.specialDeduction.query.QueryOnCheckSpecialCountByYear;
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

public class OnCheckSpecialCountByYearHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnCheckSpecialCountByYearHandler.class);

	public static BaseCollection<BaseOnCheckSpecialCountByYear> executeQueryOnCheckSpecialCountByYear(ConditionOnCheckSpecialCountByYear c, KeyValuePair[] replacements ) throws Exception {
		QueryOnCheckSpecialCountByYear dao = new QueryOnCheckSpecialCountByYear();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnCheckSpecialCountByYear> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnCheckSpecialCountByYear c = new ConditionOnCheckSpecialCountByYear();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnCheckSpecialCountByYear> result = executeQueryOnCheckSpecialCountByYear(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnCheckSpecialCountByYear> result;
		ConditionOnCheckSpecialCountByYear c = new ConditionOnCheckSpecialCountByYear();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnCheckSpecialCountByYear dao = new QueryOnCheckSpecialCountByYear();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnCheckSpecialCountByYear.ALL_CAPTIONS);
			for(BaseOnCheckSpecialCountByYear b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


