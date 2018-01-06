package com.alexbt.jpa.search.criteria;

import com.alexbt.jpa.search.criteria.abst.SearchCriteria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SearchCriteriaBetween extends SearchCriteria<Date> {
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @Override
    public Predicate toPredicate(CriteriaBuilder builder, Path<Date> path) {
        Assert.notNull(builder, "Cannot be null");
        Assert.notNull(path, "Cannot be null");
        return builder.between(path, start, end);
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
