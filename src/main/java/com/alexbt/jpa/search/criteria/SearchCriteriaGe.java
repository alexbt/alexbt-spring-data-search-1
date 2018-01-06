package com.alexbt.jpa.search.criteria;

import com.alexbt.jpa.search.criteria.abst.BasicSearchCriteria;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class SearchCriteriaGe extends BasicSearchCriteria<Number> {
    @Override
    public Predicate toPredicate(CriteriaBuilder builder, Path<Number> path) {
        Assert.notNull(builder, "Cannot be null");
        Assert.notNull(path, "Cannot be null");
        return builder.ge(path, getValue());
    }
}
