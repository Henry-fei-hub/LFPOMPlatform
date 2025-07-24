package pomplatform.selectgrid.handler;

import org.apache.log4j.Logger;
import pomplatform.selectgrid.bean.BaseSelectGridReceiveUnitValue;
import pomplatform.selectgrid.bean.ConditionSelectGridReceiveUnitValue;
import pomplatform.selectgrid.query.QuerySelectGridReceiveUnitValue;
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

public class SelectGridReceiveUnitValueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridReceiveUnitValueHandler.class);

	public static BaseCollection<BaseSelectGridReceiveUnitValue> executeQuerySelectGridReceiveUnitValue(ConditionSelectGridReceiveUnitValue c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridReceiveUnitValue dao = new QuerySelectGridReceiveUnitValue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridReceiveUnitValue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridReceiveUnitValue c = new ConditionSelectGridReceiveUnitValue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectGridReceiveUnitValue> result = executeQuerySelectGridReceiveUnitValue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridReceiveUnitValue> result;
		ConditionSelectGridReceiveUnitValue c = new ConditionSelectGridReceiveUnitValue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridReceiveUnitValue dao = new QuerySelectGridReceiveUnitValue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridReceiveUnitValue.ALL_CAPTIONS);
			for(BaseSelectGridReceiveUnitValue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


