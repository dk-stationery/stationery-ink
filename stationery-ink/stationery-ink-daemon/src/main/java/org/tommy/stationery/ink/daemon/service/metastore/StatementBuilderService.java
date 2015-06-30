package org.tommy.stationery.ink.daemon.service.metastore;

import org.antlr.runtime.RecognitionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.engine.build.IStatementBuilder;
import org.tommy.stationery.ink.core.engine.build.SimpleStatementBuilderFactory;
import org.tommy.stationery.ink.core.parser.InkSqlParser;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.daemon.util.SqlResultsGenerator;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.SqlResults;
import org.tommy.stationery.ink.domain.meta.Auth;

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

    private Auth auth;
    private IStatementBuilder statementsBuilder;

    public List<BaseStatement> prepare(Auth auth, String sql) throws RecognitionException {
        this.auth = auth;
        return new InkSqlParser().prepare(sql);
    }

    public List<ResultStatement> run(String sql, List<BaseStatement> statements) throws Exception {
        statementsBuilder = SimpleStatementBuilderFactory.getInstance(configProperties, statements);
        statementsBuilder.init(configProperties, simpleMetaStoreProvider, auth);
        statementsBuilder.build(statements, sql);
        return statementsBuilder.getResultStatements();
    }

    public String toAST() {
        return statementsBuilder.toAST();
    }

    public SqlResults FromResultStatements(List<ResultStatement> resultStatements) throws Exception {
        SqlResults sqlResults = SqlResultsGenerator.FromResultStatements(resultStatements);
        return sqlResults;
    }
}
