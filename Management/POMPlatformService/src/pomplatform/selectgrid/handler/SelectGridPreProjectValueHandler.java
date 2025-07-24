package pomplatform.selectgrid.handler;

import org.apache.log4j.Logger;
import pomplatform.selectgrid.bean.BaseSelectGridPreProjectValue;
import pomplatform.selectgrid.bean.ConditionSelectGridPreProjectValue;
import pomplatform.selectgrid.query.QuerySelectGridPreProjectValue;
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

public class SelectGridPreProjectValueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridPreProjectValueHandler.class);

	public static BaseCollection<BaseSelectGridPreProjectValue> executeQuerySelectGridPreProjectValue(ConditionSelectGridPreProjectValue c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridPreProjectValue dao = new QuerySelectGridPreProjectValue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridPreProjectValue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridPreProjectValue c = new ConditionSelectGridPreProjectValue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectGridPreProjectValue> result = executeQuerySelectGridPreProjectValue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridPreProjectValue> result;
		ConditionSelectGridPreProjectValue c = new ConditionSelectGridPreProjectValue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridPreProjectValue dao = new QuerySelectGridPreProjectValue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridPreProjectValue.ALL_CAPTIONS);
			for(BaseSelectGridPreProjectValue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


