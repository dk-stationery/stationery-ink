package org.tommy.stationery.ink.core.provider;

import net.hydromatic.linq4j.Linq4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.core.linq.LinqQuery;
import org.tommy.stationery.ink.core.provider.action.IMetaStoreAction;
import org.tommy.stationery.ink.core.util.NimbusParser;
import org.tommy.stationery.ink.core.util.StormManager;
import org.tommy.stationery.ink.dao.metastore.InkJobDao;
import org.tommy.stationery.ink.dao.metastore.InkSourceDao;
import org.tommy.stationery.ink.dao.metastore.InkStreamDao;
import org.tommy.stationery.ink.domain.BaseMetaDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.meta.Job;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.enums.SourceCatalogEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.util.DumpUtil;
import org.tommy.stationery.ink.util.domain.Dump;

import java.io.IOException;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Component
public class SimpleMetaStoreProviderImp extends AbstractSimpleMetaStoreProvider implements IMetaStoreAction {

    private static int ZERO_SIZE = 0;
    private static int ONLY_ONE = 1;

    @Autowired
    InkJobDao inkJobDao;

    @Autowired
    InkSourceDao inkSourceDao;

    @Autowired
    InkStreamDao inkStreamDao;

    public boolean isOnlyOneInkSourceByName(Source inkSource) throws InkException {
        inkSourceDao.getOnlyInkSourceByName(inkSource);
        return true;
    }

    public boolean isOnlyOneInkStreamByName(Stream inkStream) throws InkException {
        inkStreamDao.getOnlyInkStreamByName(inkStream);
        return true;
    }


    public Source getOnlyInkSourceByName(Source inkSource) throws InkException, IOException {
        return inkSourceDao.getOnlyInkSourceByName(inkSource);
    }

    public Stream getOnlyInkStreamByName(Stream inkStream) throws InkException, IOException {
        return inkStreamDao.getOnlyInkStreamByName(inkStream);
    }

    public ResultStatement execute(InkConfig inkConfig, BaseStatement statement) throws Exception {

        ResultStatement resultStatement = new ResultStatement();

        if (StatementTypeEnum.SNAPSHOT_JOB.equals(statement.getType())) {
            resultStatement = doSnapshotJobAction(inkConfig, statement);
        } else if (StatementTypeEnum.KILL_JOB.equals(statement.getType())) {
            resultStatement = doKillJobAction(inkConfig, statement);
        } else if (StatementTypeEnum.CREATE_STREAM.equals(statement.getType())) {
            resultStatement = doCreateStreamAction(inkConfig, statement);
        } else if (StatementTypeEnum.CREATE_SOURCE.equals(statement.getType())) {
            resultStatement = doCreateSourceAction(inkConfig, statement);
        } else if (StatementTypeEnum.DROP_JOB.equals(statement.getType())) {
            resultStatement = doDropJobAction(inkConfig, statement);
        } else if (StatementTypeEnum.DROP_STREAM.equals(statement.getType())) {
            resultStatement = doDropStreamAction(inkConfig, statement);
        } else if (StatementTypeEnum.DROP_SOURCE.equals(statement.getType())) {
            resultStatement = doDropSourceAction(inkConfig, statement);
        } else if (StatementTypeEnum.SHOW_STREAM.equals(statement.getType())) {
            resultStatement = doShowStreamAction(inkConfig, statement);
        } else if (StatementTypeEnum.SHOW_STREAMS.equals(statement.getType())) {
            resultStatement = doShowStreamsAction(inkConfig, statement);
        } else if (StatementTypeEnum.SHOW_SOURCE.equals(statement.getType())) {
            resultStatement = doShowSourceAction(inkConfig, statement);
        } else if (StatementTypeEnum.SHOW_SOURCES.equals(statement.getType())) {
            resultStatement = doShowSourcesAction(inkConfig, statement);
        } else if (StatementTypeEnum.SHOW_JOB.equals(statement.getType())) {
            resultStatement = doShowJobAction(inkConfig, statement);
        } else if (StatementTypeEnum.SHOW_JOBS.equals(statement.getType())) {
            resultStatement = doShowJobsAction(inkConfig, statement);
        } else if (StatementTypeEnum.SHOW_CLUSTER.equals(statement.getType())) {
            resultStatement = doShowClusterAction(inkConfig, statement);
        } else {
            throw new InkException(MessageEnum.NO_SUPPORT_STATEMENT_GROUP);
        }

        return resultStatement;
    }

    //SNAPSHOT_JOB
    public ResultStatement doSnapshotJobAction(InkConfig inkConfig, BaseStatement statement) throws Exception {
        DumpUtil dumpUtil = new DumpUtil();
        List<Dump> info = dumpUtil.dump(statement.getTable().getName(), inkConfig.getString(SettingEnum.DUMP_API_URL));
        return generateResultStatement(info);
    }

    //DROP_JOB
    public ResultStatement doDropJobAction(InkConfig inkConfig, BaseStatement statement) throws Exception {
        Job job = new Job();
        job.setName(statement.getTable().getName());
        inkJobDao.removeInkJob(job);
        return generateResultStatement(statement);
    }

    //REGIST_JOB
    public ResultStatement doRegistJobAction(InkConfig inkConfig, String sql) throws Exception {
        BaseStatement statement = new BaseStatement();
        statement.setType(StatementTypeEnum.SET);
        statement.setQuery("set " + SettingEnum.REGIST_JOB.getName() + " = '" + inkConfig.getString(SettingEnum.JOB_NAME) + "'");

        Job job = new Job();
        job.setName(inkConfig.getString(SettingEnum.JOB_NAME));
        job.setMeta(sql);
        inkJobDao.putInkJob(job);
        return generateResultStatement(statement);
    }

    //KILL_JOB
    public ResultStatement doKillJobAction(InkConfig inkConfig, BaseStatement statement) throws Exception {
        StormManager.kill(inkConfig, statement.getTable().getName());
        return generateResultStatement(statement);
    }

    //CREATE_STREAM
    public ResultStatement doCreateStreamAction(InkConfig inkConfig, BaseStatement statement) throws Exception {
        Stream inkStream = new Stream();
        inkStream.setName(statement.getTable().getName());
        inkStream.setMeta(statementJsonSerde.serialize(statement));

        List<Stream> inkStreams = inkStreamDao.getInkStreamByName(inkStream);
        if (inkStreams.size() > ZERO_SIZE) {
            throw new InkException(MessageEnum.ALREADY_EXIST_STREAM);
        }

        inkStreamDao.putInkStream(inkStream);

        return generateResultStatement(statement);
    }

    //CREATE_SOURCE
    public ResultStatement doCreateSourceAction(InkConfig inkConfig, BaseStatement statement) throws Exception {
        Source inkSource = new Source();
        inkSource.setName(statement.getTable().getName());

        List<BaseMetaDef> metaDefs = Linq4j.asEnumerable(statement.getMetas()).where(LinqQuery.DDL_META_CATALOG_FILTER).toList();
        if (metaDefs == null || metaDefs.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.CATALOG_INVALID);
        }

        SourceCatalogEnum sourceCatalogEnum = SourceCatalogEnum.valueOf(metaDefs.get(0).getValue());
        if (sourceCatalogEnum == null) {
            throw new InkException(MessageEnum.CATALOG_INVALID);
        }

        inkSource.setCatalog(metaDefs.get(0).getValue());
        inkSource.setMeta(statementJsonSerde.serialize(statement));

        List<Source> inkSources = inkSourceDao.getInkSourceByName(inkSource);
        if (inkSources.size() > ZERO_SIZE) {
            throw new InkException(MessageEnum.ALREADY_EXIST_SOURCE);
        }

        inkSourceDao.putInkSource(inkSource);

        return generateResultStatement(statement);
    }

    //DROP_STREAM
    public ResultStatement doDropStreamAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        Stream inkStream = new Stream();
        inkStream.setName(statement.getTable().getName());

        List<Stream> inkStreams = inkStreamDao.getInkStreamByName(inkStream);
        if (inkStreams.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.STREAM_NOT_FOUND);
        }

        inkStreamDao.removeInkStream(inkStream);

        return generateResultStatement(statement);
    }

    //DROP_SOURCE
    public ResultStatement doDropSourceAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        Source inkSource = new Source();
        inkSource.setName(statement.getTable().getName());

        List<Source> inkSources = inkSourceDao.getInkSourceByName(inkSource);
        if (inkSources.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.SOURCE_NOT_FOUND);
        }

        inkSourceDao.removeInkSource(inkSource);

        return generateResultStatement(statement);
    }

    //SHOW_STREAM
    public ResultStatement doShowStreamAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        Stream inkStream = new Stream();
        inkStream.setName(statement.getTable().getName());

        List<Stream> inkStreams = inkStreamDao.getInkStreamByName(inkStream);
        if (inkStreams.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.STREAM_NOT_FOUND);
        }

        return generateResultStatement(inkStreams.get(0).getMeta());
    }

    //SHOW_SOURCE
    public ResultStatement doShowSourceAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        Source inkSource = new Source();
        inkSource.setName(statement.getTable().getName());

        List<Source> inkSources = inkSourceDao.getInkSourceByName(inkSource);
        if (inkSources.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.SOURCE_NOT_FOUND);
        }

        return generateResultStatement(inkSources.get(0).getMeta());
    }

    //SHOW_JOB
    public ResultStatement doShowJobAction(InkConfig inkConfig, BaseStatement statement) throws IOException, InkException {
        Job inkJob = new Job();
        inkJob.setName(statement.getTable().getName());

        List<Job> inkJobs = inkJobDao.getInkJobByName(inkJob);

        if (inkJobs.size() != ONLY_ONE) {
            throw new InkException(MessageEnum.JOB_NOT_FOUND);
        }

        return generateResultStatement(inkJobs.get(0).getMeta());
    }

    //SHOW_STREAMS
    public ResultStatement doShowStreamsAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        List<Stream> inkStreams = inkStreamDao.getInkStreams();

        return generateResultStatement(inkStreams);
    }

    //SHOW_SOURCES
    public ResultStatement doShowSourcesAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        List<Source> inkSources = inkSourceDao.getInkSources();
        return generateResultStatement(inkSources);
    }

    //SHOW_JOBS
    public ResultStatement doShowJobsAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        List<Job> inkJobs = inkJobDao.getInkJobs();
        return generateResultStatement(inkJobs);
    }

    //SHOW_CLUSTER
    public ResultStatement doShowClusterAction(InkConfig inkConfig, BaseStatement statement) throws InkException, IOException {
        List<Object> info = NimbusParser.getInfo("http://" + inkConfig.getString(SettingEnum.STORM_URL));
        return generateResultStatement(info);
    }
}
