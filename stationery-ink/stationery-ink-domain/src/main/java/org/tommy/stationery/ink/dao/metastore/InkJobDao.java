package org.tommy.stationery.ink.dao.metastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.domain.meta.Job;
import org.tommy.stationery.ink.mapper.metastore.InkJobMapper;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Component
public class InkJobDao implements InkJobMapper {

    @Autowired
    InkJobMapper mapper;

    @Override
    public void putInkJob(Job inkJob) {
        mapper.putInkJob(inkJob);
    }

    @Override
    public void removeInkJob(Job inkJob) {
        mapper.removeInkJob(inkJob);
    }

    @Override
    public List<Job> getInkJobByName(Job inkJob) {
        return mapper.getInkJobByName(inkJob);
    }

    @Override
    public List<Job> getInkJobs() {
        return mapper.getInkJobs();
    }
}
