package com.fo.up.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fo.up.entity.UpLog1;
import com.fo.up.repository.UpLog1Repository;
import com.fo.up.service.UpLog1Service;

@Service
public class UpLog1ServiceImpl implements UpLog1Service {

    @Autowired
    private UpLog1Repository upLog1Repository;

    /**
     * 分页查询
     */
    @Override
    public Page<UpLog1> findLog1ByPage(UpLog1 log1, Pageable pageable) {

      //规格定义
        Specification<UpLog1> specification = new Specification<UpLog1>() {

            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            /**
             * 构造断言
             * @param root 实体对象引用
             * @param query 规则查询对象
             * @param cb 规则构建对象
             * @return 断言
             */
            @Override
            public Predicate toPredicate(Root<UpLog1> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if(StringUtils.isNotBlank(log1.getExecStart())){ //添加断言
                    Predicate greaterThan = cb.greaterThan(root.get("execStart").as(String.class), log1.getExecStart());
                    predicates.add(greaterThan);
                }
                if(StringUtils.isNotBlank(log1.getExecEnd())){ //添加断言
                    Predicate greaterThan = cb.lessThanOrEqualTo(root.get("execStart").as(String.class), log1.getExecEnd());
                    predicates.add(greaterThan);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };

        Example<UpLog1> example = Example.of(log1);
        return upLog1Repository.findAll(specification, pageable);
    }

}
