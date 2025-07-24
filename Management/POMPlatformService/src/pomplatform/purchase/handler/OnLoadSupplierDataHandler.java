package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseOnLoadSupplierData;
import pomplatform.purchase.bean.ConditionOnLoadSupplierData;
import pomplatform.purchase.query.QueryOnLoadSupplierData;
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

public class OnLoadSupplierDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadSupplierDataHandler.class);

	public static BaseCollection<BaseOnLoadSupplierData> executeQueryOnLoadSupplierData(ConditionOnLoadSupplierData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadSupplierData dao = new QueryOnLoadSupplierData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadSupplierData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadSupplierData c = new ConditionOnLoadSupplierData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadSupplierData> result = executeQueryOnLoadSupplierData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadSupplierData> result;
		ConditionOnLoadSupplierData c = new ConditionOnLoadSupplierData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadSupplierData dao = new QueryOnLoadSupplierData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadSupplierData.ALL_CAPTIONS);
			for(BaseOnLoadSupplierData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


