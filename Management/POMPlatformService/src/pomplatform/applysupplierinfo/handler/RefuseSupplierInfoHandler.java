package pomplatform.applysupplierinfo.handler;

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
import pomplatform.applysupplierinfo.bean.BaseRefuseSupplierInfo;
import pomplatform.applysupplierinfo.bean.ConditionRefuseSupplierInfo;
import pomplatform.applysupplierinfo.query.QueryRefuseSupplierInfo;

public class RefuseSupplierInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RefuseSupplierInfoHandler.class);

	public static BaseCollection<BaseRefuseSupplierInfo> executeQueryRefuseSupplierInfo(ConditionRefuseSupplierInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryRefuseSupplierInfo dao = new QueryRefuseSupplierInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRefuseSupplierInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRefuseSupplierInfo c = new ConditionRefuseSupplierInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRefuseSupplierInfo> result = executeQueryRefuseSupplierInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRefuseSupplierInfo> result;
		ConditionRefuseSupplierInfo c = new ConditionRefuseSupplierInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRefuseSupplierInfo dao = new QueryRefuseSupplierInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRefuseSupplierInfo.ALL_CAPTIONS);
			for(BaseRefuseSupplierInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


