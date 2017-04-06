package com.laoma.base;

import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @Auther: laoma
 * @create: 2017-04-06 上午11:29
 */
public interface BaseMongoDao<T> {
    /**
     * 插入
     */
    public T save(T entity);

    /**
     * 根据ID查询
     */
    public T findById(String id);

    /**
     * 通过ID获取记录,并且指定了集合名(表的意思)
     */
    public T findById(String id, String collectionName);

    /**
     * 获得所有该类型记录
     */
    public List<T> findAll();

    /**
     * 获得所有该类型记录,并且指定了集合名(表的意思)
     */
    public List<T> findAll(String collectionName);

    /**
     * 根据条件查询
     */
    public List<T> find(Query query);

    /**
     * 根据条件查询一个
     */
    public T findOne(Query query);

    /**
     * 分页查询
     */
    public Page<T> findPage(Page<T> page, Query query);

    /**
     * 根据条件 获得总数
     */
    public long count(Query query);

    /**
     * 根据条件 更新
     */
    public WriteResult update(Query query, Update update);

    /**
     * 更新符合条件并sort之后的第一个文档 并返回更新后的文档
     */
    public T updateOne(Query query, Update update);

    /**
     * 根据传入实体ID更新
     */
    public WriteResult update(T entity);

    /**
     * 根据条件 删除
     *
     * @param query
     */
    public void remove(Query query);


}