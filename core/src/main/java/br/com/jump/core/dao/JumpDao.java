package br.com.jump.core.dao;

import in.macor.core.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional("jump")
public class JumpDao<T, PK> extends GenericDao<T, PK> {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Long count() {
        return super.count();
    }

    @Override
    public void save(T entity) {
        super.save(entity);
    }

    @Override
    public void delete(T entity) {
        super.delete(entity);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    public T findById(PK id) {
        return super.findById(id);
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public List<T> findAll(Order order) {
        return super.findAll(order);
    }

    @Override
    public List<T> findForDataTable(String hql,
                                    Map<String, Object> params,
                                    int startRow,
                                    int maxResults,
                                    String sortColumn,
                                    String sortDirection) {
        return super.findForDataTable(hql, params, startRow, maxResults, sortColumn, sortDirection);
    }

    @Override
    public List<Object[]> findForDataTable(String sSearch,
                                           String[] columns,
                                           int startRow,
                                           int maxResults,
                                           Integer sortColumnIndex,
                                           String sortDirection,
                                           boolean virtualDelete) {
        return super.findForDataTable(sSearch, columns, startRow, maxResults, sortColumnIndex, sortDirection, virtualDelete);
    }

    @Override
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
