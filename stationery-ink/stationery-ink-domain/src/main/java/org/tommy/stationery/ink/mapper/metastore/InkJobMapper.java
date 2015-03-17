package org.tommy.stationery.ink.mapper.metastore;

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.domain.meta.Job;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Repository(value="inkJobMapper")
public interface InkJobMapper {
    public void putInkJob(Job inkJob);

    public void removeInkJob(Job inkJob);

    public List<Job> getInkJobByName(Job inkJob);

    public List<Job> getInkJobs();
}
