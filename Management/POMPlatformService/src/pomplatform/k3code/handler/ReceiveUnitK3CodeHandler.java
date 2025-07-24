package pomplatform.k3code.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.k3code.bean.BaseReceiveUnitK3Code;
import pomplatform.k3code.bean.ConditionReceiveUnitK3Code;
import pomplatform.k3code.query.QueryReceiveUnitK3Code;

public class ReceiveUnitK3CodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReceiveUnitK3CodeHandler.class);

	public static BaseCollection<BaseReceiveUnitK3Code> executeQueryReceiveUnitK3Code(ConditionReceiveUnitK3Code c, KeyValuePair[] replacements ) throws Exception {
		QueryReceiveUnitK3Code dao = new QueryReceiveUnitK3Code();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReceiveUnitK3Code> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReceiveUnitK3Code c = new ConditionReceiveUnitK3Code();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReceiveUnitK3Code> result = executeQueryReceiveUnitK3Code(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReceiveUnitK3Code> result;
		ConditionReceiveUnitK3Code c = new ConditionReceiveUnitK3Code();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReceiveUnitK3Code dao = new QueryReceiveUnitK3Code();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReceiveUnitK3Code.ALL_CAPTIONS);
			for(BaseReceiveUnitK3Code b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


