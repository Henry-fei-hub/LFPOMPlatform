package pomplatform.selectgrid.handler;

import org.apache.log4j.Logger;
import pomplatform.selectgrid.bean.BaseSelectGridProjectValue;
import pomplatform.selectgrid.bean.ConditionSelectGridProjectValue;
import pomplatform.selectgrid.query.QuerySelectGridProjectValue;
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

public class SelectGridProjectValueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridProjectValueHandler.class);

	public static BaseCollection<BaseSelectGridProjectValue> executeQuerySelectGridProjectValue(ConditionSelectGridProjectValue c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridProjectValue dao = new QuerySelectGridProjectValue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridProjectValue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridProjectValue c = new ConditionSelectGridProjectValue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectGridProjectValue> result = executeQuerySelectGridProjectValue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridProjectValue> result;
		ConditionSelectGridProjectValue c = new ConditionSelectGridProjectValue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridProjectValue dao = new QuerySelectGridProjectValue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridProjectValue.ALL_CAPTIONS);
			for(BaseSelectGridProjectValue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


