package pomplatform.goodsreceive.handler;

import org.apache.log4j.Logger;
import pomplatform.goodsreceive.bean.BaseGoodsreceivedetail;
import pomplatform.goodsreceive.bean.ConditionGoodsreceivedetail;
import pomplatform.goodsreceive.query.QueryGoodsreceivedetail;
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

public class GoodsreceivedetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GoodsreceivedetailHandler.class);

	public static BaseCollection<BaseGoodsreceivedetail> executeQueryGoodsreceivedetail(ConditionGoodsreceivedetail c, KeyValuePair[] replacements ) throws Exception {
		QueryGoodsreceivedetail dao = new QueryGoodsreceivedetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGoodsreceivedetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGoodsreceivedetail c = new ConditionGoodsreceivedetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGoodsreceivedetail> result = executeQueryGoodsreceivedetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGoodsreceivedetail> result;
		ConditionGoodsreceivedetail c = new ConditionGoodsreceivedetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGoodsreceivedetail dao = new QueryGoodsreceivedetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGoodsreceivedetail.ALL_CAPTIONS);
			for(BaseGoodsreceivedetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


