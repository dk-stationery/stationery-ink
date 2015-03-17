package org.tommy.stationery.ink.core.provider.action;

import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.exception.InkException;

import java.io.IOException;

/**
 * Created by kun7788 on 15. 2. 2..
 */
public interface IMetaStoreAction {

    //SNAPSHOT_JOB
    public ResultStatement doSnapshotJobAction(InkConfig inkConfig, BaseStatement statement) throws Exception;

    //DROP_JOB
    public ResultStatement doDropJobAction(InkConfig inkConfig, BaseStatement statement) throws Exception;

    //REGIST_JOB
    public ResultStatement doRegistJobAction(InkConfig inkConfig, String sql) throws Exception;

    //KILL_JOB
    public ResultStatement doKillJobAction(InkConfig inkConfig, BaseStatement statement) throws Exception;

    //CREATE_STREAM
    public ResultStatement doCreateStreamAction(InkConfig inkConfig, BaseStatement statement) throws Exception;

    //CREATE_SOURCE
    public ResultStatement doCreateSourceAction(InkConfig inkConfig, BaseStatement statement) throws Exception;

    //DROP_STREAM
    public ResultStatement doDropStreamAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;

    //DROP_SOURCE
    public ResultStatement doDropSourceAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;

    //SHOW_STREAM
    public ResultStatement doShowStreamAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;

    //SHOW_SOURCE
    public ResultStatement doShowSourceAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;

    //SHOW_JOB
    public ResultStatement doShowJobAction(InkConfig inkConfig, BaseStatement statement) throws IOException, InkException;

    //SHOW_STREAMS
    public ResultStatement doShowStreamsAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;

    //SHOW_SOURCES
    public ResultStatement doShowSourcesAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;

    //SHOW_JOBS
    public ResultStatement doShowJobsAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;

    //SHOW_CLUSTER
    public ResultStatement doShowClusterAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException;
}
