package pomplatform.ht2.dao;

import java.util.*;
import pomplatform.ht2.bean.BaseFormalContractWithO;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.dao.FormalContract;
import com.pomplatform.db.dao.OutDesignConsideration;

public class FormalContractWithO extends FormalContract
{


	public FormalContractWithO() throws java.sql.SQLException { initColumnNames(); }

	public List<BaseOutDesignConsideration> getDetailOutDesignConsideration() {
		return this.__detail_outdesignconsideration;
	}

	public void setDetailOutDesignConsideration( List<BaseOutDesignConsideration> value ) {
		this.__detail_outdesignconsideration = value;
	}

	private void deleteAndSaveDetailTables() throws java.sql.SQLException {
		// 实例化 报价单子项表 DAO
		OutDesignConsideration outdesignconsideration = new OutDesignConsideration();
		// 装入数据库中原来明细数据
		outdesignconsideration.setConditionInfoCode("=", getInfoCode());
		List<BaseOutDesignConsideration> originaloutdesignconsideration = outdesignconsideration.conditionalLoad(null);
		// 如果当前明细不为空
		if(getDetailOutDesignConsideration() != null) {
			// 需要删除的明细数据
			List<BaseOutDesignConsideration> needToDeleteOutDesignConsideration = new ArrayList<>();
			// 需要增加的明细数据
			List<BaseOutDesignConsideration> needToAddOutDesignConsideration = new ArrayList<>();
			// 找到在原明细中存在的数据并修改该数据，如果在原数据中没有则加到需要添加的列表中
			for(BaseOutDesignConsideration __outdesignconsideration : getDetailOutDesignConsideration() ) {
				// 赋值关联字段
				__outdesignconsideration.setInfoCode( getInfoCode());
				// 设置找到标志
				boolean foundOutDesignConsideration = false;
				// 在原明细中找
				for(BaseOutDesignConsideration __originaloutdesignconsideration : originaloutdesignconsideration) {
					// 如果两个对象主键相同
					if(__outdesignconsideration.compareTo(__originaloutdesignconsideration) == 0) {
						// 设置找到标志
						foundOutDesignConsideration = true;
						// 修改该条数据
						// 清空DAO中当前数据
						outdesignconsideration.clearCurrentData();
						// 把原明细数据装入DAO
						outdesignconsideration.setDataFromBase(__originaloutdesignconsideration);
						// 清空DAO数据修改标志, 就像数据刚从数据库中装入一样
						outdesignconsideration.clearModifiedFlags();
						// 把新的数据装入
						outdesignconsideration.setDataFromBase(__outdesignconsideration);
						// 执行修改
						outdesignconsideration.update();
						break;
					}
				}
				// 如果没找到，则加入需要增加的列表中
				if(!foundOutDesignConsideration) needToAddOutDesignConsideration.add(__outdesignconsideration);
			}
			// 找到那些在原明细中有，但当前明细中没有的条目
			for(BaseOutDesignConsideration __originaloutdesignconsideration : originaloutdesignconsideration) {
				boolean foundOutDesignConsideration = false;
				for(BaseOutDesignConsideration __outdesignconsideration : getDetailOutDesignConsideration() ) {
					if(__outdesignconsideration.compareTo(__originaloutdesignconsideration) == 0) {
						foundOutDesignConsideration = true;
						break;
				}
				}
				if(!foundOutDesignConsideration) needToDeleteOutDesignConsideration.add(__originaloutdesignconsideration);
			}
			// 处理需要增加的明细数据
			for(BaseOutDesignConsideration __outdesignconsideration : needToAddOutDesignConsideration ) {
				outdesignconsideration.setPrimaryKeyFromBase(__outdesignconsideration);
				// 如果该条数据主键为空，则插入数据, 注意这种处理方式只对子表主键为自增的有效
				// 如果子表的主键不是自增类型，则需要考虑如何生成主键, 并修改下面的代码
				if(outdesignconsideration.isPrimaryKeyNull()) { outdesignconsideration.clearCurrentData(); outdesignconsideration.setDataFromBase(__outdesignconsideration); outdesignconsideration.save(); }
				// 否则从数据中查询该数据，找到就修改，否则插入
				else { if(outdesignconsideration.load()) { outdesignconsideration.setDataFromBase(__outdesignconsideration); outdesignconsideration.update(); } else { outdesignconsideration.clearCurrentData(); outdesignconsideration.setDataFromBase(__outdesignconsideration); outdesignconsideration.save(); } }
			}
			// 处理需要删除的明细数据
			for(BaseOutDesignConsideration __outdesignconsideration : needToDeleteOutDesignConsideration ) {
				deleteFromOutDesignConsideration(__outdesignconsideration, outdesignconsideration);
			}
		} else {
			// 如果当前明细为空，说明所有原有的明细都需要删除
			for(BaseOutDesignConsideration __outdesignconsideration : originaloutdesignconsideration ) {
				deleteFromOutDesignConsideration(__outdesignconsideration, outdesignconsideration);
			}
		}
	}

	private void deleteFromOutDesignConsideration(BaseOutDesignConsideration bean, OutDesignConsideration dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setInfoCode(null);
		if(__detail_delete_outdesignconsideration) dao.delete(); else dao.update();
	}

	// 删除子表方法, 一般不建议使用，最好是修改关联关系，脱离关系就行
	private void deleteDetailTables()  throws java.sql.SQLException {
		OutDesignConsideration outdesignconsideration = new OutDesignConsideration();
		outdesignconsideration.setConditionInfoCode("=", getInfoCode());
		outdesignconsideration.conditionalDelete();
	}

	// 从数据中按主键查询数据，可以包含明细数据
	public boolean load(boolean loadDetail) throws java.sql.SQLException {
		if(!super.load()) return false;
		if(loadDetail){
			OutDesignConsideration outdesignconsideration = new OutDesignConsideration();
			outdesignconsideration.setConditionInfoCode("=", getInfoCode());
			setDetailOutDesignConsideration(outdesignconsideration.conditionalLoad(null));
		}
		return true;
	}

	public List<BaseFormalContractWithO> conditionalLoadExt(String addtional) throws java.sql.SQLException {
		List<BaseFormalContractWithO> result = BaseFormalContractWithO.getBeanList(conditionalLoad(addtional));
		if(result.size() > 0) {
			OutDesignConsideration outdesignconsideration = new OutDesignConsideration();
			int varCount = 0;
			Object[] convars = new Object[result.size()];
			for(BaseFormalContractWithO b : result) convars[varCount++] = b.getInfoCode();
			outdesignconsideration.addCondition(BaseOutDesignConsideration.CS_INFO_CODE, "IN", convars);
			List<BaseOutDesignConsideration> outdesignconsiderations = outdesignconsideration.conditionalLoad(null);
			for(BaseFormalContractWithO ii : result){ ii.setDetailOutDesignConsideration(new ArrayList<BaseOutDesignConsideration>()); }
			for(BaseOutDesignConsideration mm : outdesignconsiderations){
				for(BaseFormalContractWithO nn : result){
					if(mm.getInfoCode().equals(nn.getInfoCode())) { nn.getDetailOutDesignConsideration().add(mm); break; } 
				}
			}
		}
		return result;
	}

	public BaseFormalContractWithO generateBaseExt() {
		BaseFormalContractWithO ____result = new BaseFormalContractWithO();
		setDataToBase(____result);
		return ____result;
	}

	public void setDataFromBase(BaseFormalContractWithO __base) {
		super.setDataFromBase(__base);
		setDetailOutDesignConsideration(__base.getDetailOutDesignConsideration());
	}

	public void setDataToBase(BaseFormalContractWithO __base) {
		super.setDataToBase(__base);
		__base.setDetailOutDesignConsideration(getDetailOutDesignConsideration());
	}

	@Override
	public int save() throws java.sql.SQLException {

		if(super.save() == 0) return 0;
		deleteAndSaveDetailTables();
		return 1;
	}

	@Override
	public int update() throws java.sql.SQLException {

		super.update();
		deleteAndSaveDetailTables();
		return 1;
	}

	@Override
	public int conditionalUpdate() throws java.sql.SQLException {

		super.conditionalUpdate();
		deleteAndSaveDetailTables();
		return 1;
	}

	@Override
	public int delete() throws java.sql.SQLException {
		super.delete();
		deleteDetailTables();
		return 1;
	}

	@Override
	public int conditionalDelete() throws java.sql.SQLException {
		super.conditionalDelete();
		if(getFormalContractId() != null) deleteDetailTables();
		return 1;
	}

	public boolean isDeleteDetailOutDesignConsideration() {
		return this.__detail_delete_outdesignconsideration;
	}

	public void setDeleteDetailOutDesignConsideration( boolean value ) {
		this.__detail_delete_outdesignconsideration = value;
	}

	protected boolean __detail_delete_outdesignconsideration = false; 
	protected List<BaseOutDesignConsideration> __detail_outdesignconsideration ; 
}
