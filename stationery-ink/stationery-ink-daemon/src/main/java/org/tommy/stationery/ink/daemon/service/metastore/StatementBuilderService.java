package org.tommy.stationery.ink.daemon.service.metastore;

import org.antlr.runtime.RecognitionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.parser.InkSqlParser;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.core.storm.build.AdvancedStatementsBuilder;
import org.tommy.stationery.ink.daemon.util.SqlResultsGenerator;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.SqlResults;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 28..
 */
@Service
public class StatementBuilderService {

    public static Logger logger = LoggerFactory.getLogger(StatementBuilderService.class);

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    SimpleMetaStoreProviderImp simpleMetaStoreProvider;

    private AdvancedStatementsBuilder advancedStatementsBuilder;

    public List<BaseStatement> prepare(String sql) throws RecognitionException {
        return new InkSqlParser().prepare(sql);
    }

    public List<ResultStatement> run(String sql, List<BaseStatement> statements) throws Exception {
        advancedStatementsBuilder = new AdvancedStatementsBuilder();
        advancedStatementsBuilder.init(configProperties, simpleMetaStoreProvider);
        advancedStatementsBuilder.build(statements, sql);
        return advancedStatementsBuilder.getResultStatements();
    }

    public String toAST() {
        return advancedStatementsBuilder.toAST();
    }

    public SqlResults FromResultStatements(List<ResultStatement> resultStatements) throws Exception {
        SqlResults sqlResults = SqlResultsGenerator.FromResultStatements(resultStatements);
        return sqlResults;
    }
}
