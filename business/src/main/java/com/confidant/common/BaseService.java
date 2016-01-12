package com.confidant.common;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/1/7.
 */
@Service
public abstract class BaseService {

    @Autowired
    @Qualifier("baseSqlSession")
    protected SqlSession baseSqlSession;

    protected String namespace;

    public void insert(BaseEntity entity) {
        baseSqlSession.insert(namespace + "insert", entity);
    }

    public void batchInsert(List<BaseEntity> entities) {
        baseSqlSession.insert(namespace + "batchInsert", entities);
    }

    public void deleteById(Long id) {
        baseSqlSession.delete(namespace + "deleteById", id);
    }
}
