/**
 * 
 */
package system.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.BaseDAOImpl;

import system.entity.OperationModel;
import system.utils.StringUtils;


  
  /**
 *
 * 类名称：OperationDAO
 * 类描述：
 * 创建人：wuyuyue
 * 创建时间：2011-4-14 下午11:18:29
 * 修改人：wuyuyue
 * 修改时间：2011-4-14 下午11:18:29
 * 修改备注：
 * @version
 *
 */

public class OperationDAO extends BaseDAOImpl<OperationModel> {
//	/** 
//     * 获取某操作的数据访问方式
//     * @param operation 
//     * @return DataAccessModeModel 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public DataAccessModeModel getDataAccessMode(OperationModel operation){
//		return null;
//	}
//	/** 
//     * 获取某操作的所属模块
//     * @param operation 
//     * @return ModuleModel 
//     * @创建时间 2011-4-15 上午10:41:15
//     */ 
//	public ModuleModel getBelongModule(OperationModel operation){
//		return null;
//	}
	/** 
	  * 通过唯一性系统标记查询操作实体
	  * @param symbol 
	  * @return T
	  * @创建时间 2011-4-15 上午10:41:15
	  */
	@SuppressWarnings("unchecked")
	public OperationModel getOperationBySymbol(String symbol){
		if (StringUtils.isNotEmpty(symbol)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(OperationModel.class);
			criteria.add(Restrictions.eq("symbol", symbol));
			List<OperationModel> result = this.getListByCriteria(criteria);
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		return null;
	}

	public void removeOperationBySymbol(String symbol) {
		// TODO Auto-generated method stub
		remove(getOperationBySymbol(symbol));
	}
}
