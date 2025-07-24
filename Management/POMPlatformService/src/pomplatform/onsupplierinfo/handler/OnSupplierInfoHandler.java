package pomplatform.onsupplierinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.onsupplierinfo.bean.BaseOnSupplierInfo;
import pomplatform.onsupplierinfo.bean.ConditionOnSupplierInfo;
import pomplatform.onsupplierinfo.query.QueryOnSupplierInfo;
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

public class OnSupplierInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnSupplierInfoHandler.class);

	public static BaseCollection<BaseOnSupplierInfo> executeQueryOnSupplierInfo(ConditionOnSupplierInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryOnSupplierInfo dao = new QueryOnSupplierInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnSupplierInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnSupplierInfo c = new ConditionOnSupplierInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnSupplierInfo> result = executeQueryOnSupplierInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnSupplierInfo> result;
		ConditionOnSupplierInfo c = new ConditionOnSupplierInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnSupplierInfo dao = new QueryOnSupplierInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnSupplierInfo.ALL_CAPTIONS);
			for(BaseOnSupplierInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


