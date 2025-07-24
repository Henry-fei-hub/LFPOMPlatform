package pomplatform.selectGridEmployeeValue.handler;

import org.apache.log4j.Logger;
import pomplatform.selectGridEmployeeValue.bean.BaseSelectGridEmployeeValue;
import pomplatform.selectGridEmployeeValue.bean.ConditionSelectGridEmployeeValue;
import pomplatform.selectGridEmployeeValue.query.QuerySelectGridEmployeeValue;
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

public class SelectGridEmployeeValueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridEmployeeValueHandler.class);

	public static BaseCollection<BaseSelectGridEmployeeValue> executeQuerySelectGridEmployeeValue(ConditionSelectGridEmployeeValue c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridEmployeeValue dao = new QuerySelectGridEmployeeValue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridEmployeeValue> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridEmployeeValue c = new ConditionSelectGridEmployeeValue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectGridEmployeeValue> result = executeQuerySelectGridEmployeeValue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridEmployeeValue> result;
		ConditionSelectGridEmployeeValue c = new ConditionSelectGridEmployeeValue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridEmployeeValue dao = new QuerySelectGridEmployeeValue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridEmployeeValue.ALL_CAPTIONS);
			for(BaseSelectGridEmployeeValue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


