package com.alexbt.jpa.search.criteria;

import com.alexbt.jpa.search.criteria.abst.BasicSearchCriteria;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class SearchCriteriaIn extends BasicSearchCriteria<List<Object>> {
    @Override
    public Predicate toPredicate(CriteriaBuilder builder, Path<List<Object>> path) {
        Assert.notNull(builder, "Cannot be null");
        Assert.notNull(path, "Cannot be null");
        return builder.in(path).value(getValue());
    }
}
