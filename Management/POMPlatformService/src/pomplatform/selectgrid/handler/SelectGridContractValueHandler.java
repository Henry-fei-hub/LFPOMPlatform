package pomplatform.selectgrid.handler;

import org.apache.log4j.Logger;
import pomplatform.selectgrid.bean.BaseSelectGridContractValue;
import pomplatform.selectgrid.bean.ConditionSelectGridContractValue;
import pomplatform.selectgrid.query.QuerySelectGridContractValue;
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

public class SelectGridContractValueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridContractValueHandler.class);

	public static BaseCollection<BaseSelectGridContractValue> executeQuerySelectGridContractValue(ConditionSelectGridContractValue c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridContractValue dao = new QuerySelectGridContractValue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridContractValue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridContractValue c = new ConditionSelectGridContractValue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectGridContractValue> result = executeQuerySelectGridContractValue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridContractValue> result;
		ConditionSelectGridContractValue c = new ConditionSelectGridContractValue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridContractValue dao = new QuerySelectGridContractValue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridContractValue.ALL_CAPTIONS);
			for(BaseSelectGridContractValue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


