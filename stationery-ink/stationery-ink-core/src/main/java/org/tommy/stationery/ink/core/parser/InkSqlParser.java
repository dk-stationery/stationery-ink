package org.tommy.stationery.ink.core.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.tommy.stationery.ink.core.TOMMY_SQLLexer;
import org.tommy.stationery.ink.core.TOMMY_SQLParser;
import org.tommy.stationery.ink.domain.BaseStatement;

import java.util.List;

/**
 * Created by kun7788 on 15. 1. 26..
 */
public class InkSqlParser {

    public List<BaseStatement> prepare(String query) throws RecognitionException {
        query = query.replace("\n", " ");
        ANTLRStringStream in = new ANTLRStringStream(query);
        TOMMY_SQLLexer lexer = new TOMMY_SQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TOMMY_SQLParser parser = new TOMMY_SQLParser(tokens);
        parser.create_statement();
        return parser.getStatements();
    }
}
