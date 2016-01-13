package com.savior.common;

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

    public int insert(BaseEntity entity) {
        return baseSqlSession.insert(namespace + "insert", entity);
    }

    public int batchInsert(List<BaseEntity> entities) {
        return baseSqlSession.insert(namespace + "batchInsert", entities);
    }

    public int deleteById(Long id) {
        return baseSqlSession.delete(namespace + "deleteById", id);
    }
}
