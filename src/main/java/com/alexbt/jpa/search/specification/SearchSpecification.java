package com.alexbt.jpa.search.specification;

import com.alexbt.jpa.search.criteria.abst.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;

public class SearchSpecification<T> implements Specification<T> {

    private final SearchCriteria searchCriteria;

    public SearchSpecification(SearchCriteria searchCriteria) {
        Assert.notNull(searchCriteria, "Cannot be null");
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        Assert.notNull(root, "Cannot be null");
        Assert.notNull(criteriaQuery, "Cannot be null");
        Assert.notNull(builder, "Cannot be null");

        Path<?> path = getPath(searchCriteria, root);
        return searchCriteria.toPredicate(builder, path);
    }

    private Path<?> getPath(SearchCriteria searchCriteria, Path<?> path) {
        Assert.notNull(searchCriteria, "Cannot be null");
        Assert.notNull(path, "Cannot be null");

        String[] names = searchCriteria.getKey().split("\\.");
        for (String name : names) {
            path = path.get(name);
        }
        return path;
    }
}
