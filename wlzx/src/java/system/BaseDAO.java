package system;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.type.Type;




public interface BaseDAO<T> {
	
	/**
	 * Save or Update the object in database
	 * @param domain Object to be saved of updated
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a>
	 */
	void saveOrUpdate(T domain) throws DAOException;
	
	/**
	 * Save or Update the object only if update is true
	 * @param domain
	 * @param update
	 * @throws DAOException
	 */
	void saveOrUpdate(T domain, boolean update) throws DAOException;
	/**
	 * Save or Update the object only if update is true
	 * @param domain
	 * @param update
	 * @throws DAOException
	 */
	void saveOrUpdate(PaginationSupport<T> domain, boolean update) throws DAOException;
	/**
	 * Save or Update the object only if update is true
	 * @param domain
	 * @param update
	 * @throws DAOException
	 */
	void saveOrUpdate(List<T> domain, boolean update) throws DAOException;
	
	/**
	 * 
	 * @param domain
	 */
	void merge(T domain) throws DAOException;
	
	/**
	 * 
	 * @param domain
	 * @param update
	 */
	void merge(T domain, boolean update) throws DAOException;
	
	/**
	 * Remove the object from database
	 * @param domain Object to be deleted
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a>
	 */
	void remove(T domain) throws DAOException;
	
	/**
	 * remove Object without cascade delete
	 * @param id
	 * @param clazz
	 * @throws DAOException
	 */
	void remove(String id, Class clazz)throws DAOException;
	
	/**
	 * Get object by it's identity
	 * @param id Identity of object
	 * @return Object
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a>
	 */
	T get(Serializable id) throws DAOException;
	
	/**
	 * 
	 * @param nativeSql
	 * @param claz
	 * @param scalars
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	List findList2PojoByNativeSQL(String nativeSql,Class claz, Map<String, Type> scalars) throws DAOException;
	
	/**
	 * 
	 * @param nativeSql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List findListByNativeSQL(String nativeSql) throws DAOException;
	
	/**
	 * 
	 * @param nativeSql
	 * @param claz
	 * @return
	 * @author Zhao.Xiang
	 */
	@SuppressWarnings("unchecked")
	List findListByNativeSQL(String nativeSql,Class claz) throws DAOException;
	
	/**
	 * 
	 * @param nativeSql
	 * @param masterEntity
	 * @param masterEntityClass
	 * @param joinEntities
	 * @return
	 * @author Zhao.Xiang
	 */
	@SuppressWarnings("unchecked")
	List findListByNativeSQL(String nativeSql,Map<String, Class> entities) throws DAOException;
	
	/**
	 * Get object list by hsql query
	 * @param hsql
	 * @return
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a>
	 */
	List<T> findListByHSQL(String hsql) throws DAOException;
	
	/**
	 * Find object list by named query in mapping file
	 * @param query
	 * @return
	 */
	List<T> findListByNamedQuery(String query) throws DAOException;
	
	/**
	 * 
	 * @param nativeSql
	 * @return
	 * @author Zhao.Xiang
	 */
	int execUpdateByNativeSQL(String nativeSql) throws DAOException;
	
	/**
	 * 
	 * @param nativeSql
	 * @return
	 * @throws DAOException
	 */
	int execUpdateByHSQL(String nativeSql) throws DAOException;
	
	/**
	 * Get object list by query criteria
	 * @param criteria Query criteria,including condition and the orders
	 * @return
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a>
	 */
	@SuppressWarnings("unchecked")
	List getListByCriteria(DetachedCriteria criteria) throws DAOException;
	
	/**
	 * Get object list by query criteria
	 * @param criteria Query criteria,including condition and the orders
	 * @param offset
	 * @param size
	 * @return
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a>
	 */
	@SuppressWarnings("unchecked")
	List getListByCriteria(
			DetachedCriteria criteria,int firstResult,int maxResult) throws DAOException;
	
	/**
	 * Find object by pagination support
	 * @param criteria Query criteria,including condition and the orders
	 * @param pageSize Size of page to show
	 * @param startIndex Start index to search
	 * @return
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a>
	 */
	PaginationSupport<T> findPageByCriteria(
			DetachedCriteria criteria,int pageSize,int startIndex) throws DAOException;
	
	/**
	 * 
	 * @param models
	 * @author <a href="mailto:z405656232x@163.com">JeccyZhao</a> 
	 */
	void batchSaveOrUpdate(List<T> models) throws DAOException ;
	
	/**
	 * 
	 * @param col
	 * @throws DAOException
	 */
	void saveOrUpdateAll(List<T> models) throws DAOException;
	
	/**
	 * 
	 * 根据hql语句进行分页
	 * 
	 * @param start
	 *            �?��
	 * @param pageSize
	 *            每页对应的条�?
	 * @param hql
	 *            查询条件
	 * @param orderBy
	 *            排序字段
	 * @param orderType
	 *            排序方法，升序�?降序
	 * @return
	 * @author <a href="mailto:zwqjsj0404@gmail.com">zwq</a>
	 */
	List<T> findByPage(int start, int pageSize, String hql,
			String orderBy, String orderType);

	/**
	 * 
	 * @param hql 查询条件
	 * @return
	 * @author <a href="mailto:zwqjsj0404@gmail.com">zwq</a>
	 */
	int getCount(String hql);
	
	/**
	 * 直接根据hql进行查找
	 * @param hql
	 * @return
	 * @author <a href="mailto:zwqjsj0404@gmail.com">zwq</a>
	 */
	List<T> findByHQL(String hql);
	
	/**
	 * 根据hql得到唯一�?��对象
	 * @param hql
	 * @return
	 * @author <a href="mailto:zwqjsj0404@gmail.com">zwq</a>
	 */
	T uniqueResult(String hql);
	
	@SuppressWarnings("unchecked")
	List findListByHQL(String hql)throws DAOException;

}

