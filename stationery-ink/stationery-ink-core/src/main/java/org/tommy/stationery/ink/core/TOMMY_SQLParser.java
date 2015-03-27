// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/core/TOMMY_SQL.g 2015-03-27 16:49:32

    package org.tommy.stationery.ink.core;

    import org.tommy.stationery.ink.domain.BaseSetDef;
    import org.tommy.stationery.ink.domain.BaseUseDef;
    import org.tommy.stationery.ink.domain.BaseTableDef;
    import org.tommy.stationery.ink.domain.BaseColumnDef;
    import org.tommy.stationery.ink.domain.BaseMetaDef;
    import org.tommy.stationery.ink.domain.BaseStatement;
    import org.tommy.stationery.ink.enums.ColumnDataTypeEnum;
    import org.tommy.stationery.ink.enums.TableCatalogEnum;
    import org.tommy.stationery.ink.enums.StatementTypeEnum;
    import org.tommy.stationery.ink.enums.SourceCatalogEnum;
    import org.tommy.stationery.ink.core.parser.QueryParser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class TOMMY_SQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DELETE", "SELECT", "FROM", "WHERE", "LOOKUP", "INSERT", "UPSERT", "CREATE", "STREAM", "STREAMS", "BSTREAM", "BUCKET", "SOURCE", "SOURCES", "DROP", "SHOW", "JOB", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURLY", "RCURLY", "LBLE", "RBLE", "QUESTION", "EXCLAMATION", "SINGLE_QUOTE", "DOUBLE_QUOTE", "UNDERLINE", "SEMICOLON", "COMMA", "COMM", "COLON", "META", "AND", "OR", "PLUS", "MINUS", "MULTI", "DIV", "MOD", "ANDMARK", "EQUAL", "INCREASE", "VALUES", "INTO", "UPDATE", "SET", "CLUSTER", "JOBS", "KILL", "SNAPSHOT", "USE", "NAME", "WHITESPACE", "WS", "UNICODE_LETTER", "UNICODE_DIGIT", "LETTER", "DIGIT", "'\\r'", "'\\n'", "'PARTITION_KEY'", "'STRING'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'TOPIC'", "'COMMENT'", "'CATALOG'", "'URL'", "'DRIVER'", "'ID'", "'PW'", "'VHOST'", "'PORT'"
    };
    public static final int EOF=-1;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int DELETE=4;
    public static final int SELECT=5;
    public static final int FROM=6;
    public static final int WHERE=7;
    public static final int LOOKUP=8;
    public static final int INSERT=9;
    public static final int UPSERT=10;
    public static final int CREATE=11;
    public static final int STREAM=12;
    public static final int STREAMS=13;
    public static final int BSTREAM=14;
    public static final int BUCKET=15;
    public static final int SOURCE=16;
    public static final int SOURCES=17;
    public static final int DROP=18;
    public static final int SHOW=19;
    public static final int JOB=20;
    public static final int LPAREN=21;
    public static final int RPAREN=22;
    public static final int LSQUARE=23;
    public static final int RSQUARE=24;
    public static final int LCURLY=25;
    public static final int RCURLY=26;
    public static final int LBLE=27;
    public static final int RBLE=28;
    public static final int QUESTION=29;
    public static final int EXCLAMATION=30;
    public static final int SINGLE_QUOTE=31;
    public static final int DOUBLE_QUOTE=32;
    public static final int UNDERLINE=33;
    public static final int SEMICOLON=34;
    public static final int COMMA=35;
    public static final int COMM=36;
    public static final int COLON=37;
    public static final int META=38;
    public static final int AND=39;
    public static final int OR=40;
    public static final int PLUS=41;
    public static final int MINUS=42;
    public static final int MULTI=43;
    public static final int DIV=44;
    public static final int MOD=45;
    public static final int ANDMARK=46;
    public static final int EQUAL=47;
    public static final int INCREASE=48;
    public static final int VALUES=49;
    public static final int INTO=50;
    public static final int UPDATE=51;
    public static final int SET=52;
    public static final int CLUSTER=53;
    public static final int JOBS=54;
    public static final int KILL=55;
    public static final int SNAPSHOT=56;
    public static final int USE=57;
    public static final int NAME=58;
    public static final int WHITESPACE=59;
    public static final int WS=60;
    public static final int UNICODE_LETTER=61;
    public static final int UNICODE_DIGIT=62;
    public static final int LETTER=63;
    public static final int DIGIT=64;

    // delegates
    // delegators


        public TOMMY_SQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TOMMY_SQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return TOMMY_SQLParser.tokenNames; }
    public String getGrammarFileName() { return "org/tommy/stationery/ink/core/TOMMY_SQL.g"; }


        private List<BaseStatement> statements = new ArrayList<BaseStatement>();

        public List<BaseStatement> getStatements() {
            return this.statements;
        }


    public static class create_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:100:1: create_statement : ( use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ ;
    public final TOMMY_SQLParser.create_statement_return create_statement() throws RecognitionException {
        TOMMY_SQLParser.create_statement_return retval = new TOMMY_SQLParser.create_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.use_statement_return use_statement1 = null;

        TOMMY_SQLParser.snapshot_job_statement_return snapshot_job_statement2 = null;

        TOMMY_SQLParser.kill_job_statement_return kill_job_statement3 = null;

        TOMMY_SQLParser.set_statement_return set_statement4 = null;

        TOMMY_SQLParser.show_sources_statement_return show_sources_statement5 = null;

        TOMMY_SQLParser.show_streams_statement_return show_streams_statement6 = null;

        TOMMY_SQLParser.show_cluster_statement_return show_cluster_statement7 = null;

        TOMMY_SQLParser.show_jobs_statement_return show_jobs_statement8 = null;

        TOMMY_SQLParser.update_statement_return update_statement9 = null;

        TOMMY_SQLParser.upsert_statement_return upsert_statement10 = null;

        TOMMY_SQLParser.lookup_statement_return lookup_statement11 = null;

        TOMMY_SQLParser.select_statement_return select_statement12 = null;

        TOMMY_SQLParser.create_stream_statement_return create_stream_statement13 = null;

        TOMMY_SQLParser.create_source_statement_return create_source_statement14 = null;

        TOMMY_SQLParser.show_stream_statement_return show_stream_statement15 = null;

        TOMMY_SQLParser.show_source_statement_return show_source_statement16 = null;

        TOMMY_SQLParser.drop_stream_statement_return drop_stream_statement17 = null;

        TOMMY_SQLParser.drop_source_statement_return drop_source_statement18 = null;

        TOMMY_SQLParser.drop_job_statement_return drop_job_statement19 = null;

        TOMMY_SQLParser.show_job_statement_return show_job_statement20 = null;

        TOMMY_SQLParser.delete_statement_return delete_statement21 = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:5: ( ( use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:7: ( use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:7: ( use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=22;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:8: use_statement
            	    {
            	    pushFollow(FOLLOW_use_statement_in_create_statement579);
            	    use_statement1=use_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, use_statement1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:22: snapshot_job_statement
            	    {
            	    pushFollow(FOLLOW_snapshot_job_statement_in_create_statement581);
            	    snapshot_job_statement2=snapshot_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, snapshot_job_statement2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:45: kill_job_statement
            	    {
            	    pushFollow(FOLLOW_kill_job_statement_in_create_statement583);
            	    kill_job_statement3=kill_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, kill_job_statement3.getTree());

            	    }
            	    break;
            	case 4 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:64: set_statement
            	    {
            	    pushFollow(FOLLOW_set_statement_in_create_statement585);
            	    set_statement4=set_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_statement4.getTree());

            	    }
            	    break;
            	case 5 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:78: show_sources_statement
            	    {
            	    pushFollow(FOLLOW_show_sources_statement_in_create_statement587);
            	    show_sources_statement5=show_sources_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_sources_statement5.getTree());

            	    }
            	    break;
            	case 6 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:101: show_streams_statement
            	    {
            	    pushFollow(FOLLOW_show_streams_statement_in_create_statement589);
            	    show_streams_statement6=show_streams_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_streams_statement6.getTree());

            	    }
            	    break;
            	case 7 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:124: show_cluster_statement
            	    {
            	    pushFollow(FOLLOW_show_cluster_statement_in_create_statement591);
            	    show_cluster_statement7=show_cluster_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_cluster_statement7.getTree());

            	    }
            	    break;
            	case 8 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:147: show_jobs_statement
            	    {
            	    pushFollow(FOLLOW_show_jobs_statement_in_create_statement593);
            	    show_jobs_statement8=show_jobs_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_jobs_statement8.getTree());

            	    }
            	    break;
            	case 9 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:167: update_statement
            	    {
            	    pushFollow(FOLLOW_update_statement_in_create_statement595);
            	    update_statement9=update_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, update_statement9.getTree());

            	    }
            	    break;
            	case 10 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:184: upsert_statement
            	    {
            	    pushFollow(FOLLOW_upsert_statement_in_create_statement597);
            	    upsert_statement10=upsert_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, upsert_statement10.getTree());

            	    }
            	    break;
            	case 11 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:201: lookup_statement
            	    {
            	    pushFollow(FOLLOW_lookup_statement_in_create_statement599);
            	    lookup_statement11=lookup_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lookup_statement11.getTree());

            	    }
            	    break;
            	case 12 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:218: select_statement
            	    {
            	    pushFollow(FOLLOW_select_statement_in_create_statement601);
            	    select_statement12=select_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement12.getTree());

            	    }
            	    break;
            	case 13 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:235: create_stream_statement
            	    {
            	    pushFollow(FOLLOW_create_stream_statement_in_create_statement603);
            	    create_stream_statement13=create_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_stream_statement13.getTree());

            	    }
            	    break;
            	case 14 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:259: create_source_statement
            	    {
            	    pushFollow(FOLLOW_create_source_statement_in_create_statement605);
            	    create_source_statement14=create_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_source_statement14.getTree());

            	    }
            	    break;
            	case 15 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:283: show_stream_statement
            	    {
            	    pushFollow(FOLLOW_show_stream_statement_in_create_statement607);
            	    show_stream_statement15=show_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_stream_statement15.getTree());

            	    }
            	    break;
            	case 16 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:305: show_source_statement
            	    {
            	    pushFollow(FOLLOW_show_source_statement_in_create_statement609);
            	    show_source_statement16=show_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_source_statement16.getTree());

            	    }
            	    break;
            	case 17 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:327: drop_stream_statement
            	    {
            	    pushFollow(FOLLOW_drop_stream_statement_in_create_statement611);
            	    drop_stream_statement17=drop_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_stream_statement17.getTree());

            	    }
            	    break;
            	case 18 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:349: drop_source_statement
            	    {
            	    pushFollow(FOLLOW_drop_source_statement_in_create_statement613);
            	    drop_source_statement18=drop_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_source_statement18.getTree());

            	    }
            	    break;
            	case 19 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:371: drop_job_statement
            	    {
            	    pushFollow(FOLLOW_drop_job_statement_in_create_statement615);
            	    drop_job_statement19=drop_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_job_statement19.getTree());

            	    }
            	    break;
            	case 20 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:390: show_job_statement
            	    {
            	    pushFollow(FOLLOW_show_job_statement_in_create_statement617);
            	    show_job_statement20=show_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_job_statement20.getTree());

            	    }
            	    break;
            	case 21 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:409: delete_statement
            	    {
            	    pushFollow(FOLLOW_delete_statement_in_create_statement619);
            	    delete_statement21=delete_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, delete_statement21.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            if ( state.backtracking==0 ) {


                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "create_statement"

    public static class use_name_def_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "use_name_def"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:108:1: use_name_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.use_name_def_return use_name_def() throws RecognitionException {
        TOMMY_SQLParser.use_name_def_return retval = new TOMMY_SQLParser.use_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:109:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:109:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_use_name_def653); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "use_name_def"

    public static class use_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "use_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:112:1: use_statement : USE column= set_name_def SEMICOLON ;
    public final TOMMY_SQLParser.use_statement_return use_statement() throws RecognitionException {
        TOMMY_SQLParser.use_statement_return retval = new TOMMY_SQLParser.use_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token USE22=null;
        Token SEMICOLON23=null;
        TOMMY_SQLParser.set_name_def_return column = null;


        Object USE22_tree=null;
        Object SEMICOLON23_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:113:5: ( USE column= set_name_def SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:113:7: USE column= set_name_def SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            USE22=(Token)match(input,USE,FOLLOW_USE_in_use_statement672); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USE22_tree = (Object)adaptor.create(USE22);
            adaptor.addChild(root_0, USE22_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_use_statement676);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            SEMICOLON23=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_use_statement678); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON23_tree = (Object)adaptor.create(SEMICOLON23);
            adaptor.addChild(root_0, SEMICOLON23_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("USE"));
                      BaseUseDef useDef = new BaseUseDef();
                      useDef.setName(column.ret);
                      statement.setUseDef(useDef);
                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "use_statement"

    public static class set_name_def_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "set_name_def"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:126:1: set_name_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.set_name_def_return set_name_def() throws RecognitionException {
        TOMMY_SQLParser.set_name_def_return retval = new TOMMY_SQLParser.set_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:127:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:127:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_name_def710); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "set_name_def"

    public static class set_value_def_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "set_value_def"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:130:1: set_value_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.set_value_def_return set_value_def() throws RecognitionException {
        TOMMY_SQLParser.set_value_def_return retval = new TOMMY_SQLParser.set_value_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:131:6: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:131:10: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_value_def738); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "set_value_def"

    public static class set_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "set_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:134:1: set_statement : SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON ;
    public final TOMMY_SQLParser.set_statement_return set_statement() throws RecognitionException {
        TOMMY_SQLParser.set_statement_return retval = new TOMMY_SQLParser.set_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SET24=null;
        Token EQUAL25=null;
        Token SINGLE_QUOTE26=null;
        Token SINGLE_QUOTE27=null;
        Token SEMICOLON28=null;
        TOMMY_SQLParser.set_name_def_return column = null;

        TOMMY_SQLParser.set_value_def_return value = null;


        Object SET24_tree=null;
        Object EQUAL25_tree=null;
        Object SINGLE_QUOTE26_tree=null;
        Object SINGLE_QUOTE27_tree=null;
        Object SEMICOLON28_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:135:5: ( SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:135:7: SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SET24=(Token)match(input,SET,FOLLOW_SET_in_set_statement758); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SET24_tree = (Object)adaptor.create(SET24);
            adaptor.addChild(root_0, SET24_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_set_statement762);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            EQUAL25=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_set_statement764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQUAL25_tree = (Object)adaptor.create(EQUAL25);
            adaptor.addChild(root_0, EQUAL25_tree);
            }
            SINGLE_QUOTE26=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE26_tree = (Object)adaptor.create(SINGLE_QUOTE26);
            adaptor.addChild(root_0, SINGLE_QUOTE26_tree);
            }
            pushFollow(FOLLOW_set_value_def_in_set_statement770);
            value=set_value_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, value.getTree());
            SINGLE_QUOTE27=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE27_tree = (Object)adaptor.create(SINGLE_QUOTE27);
            adaptor.addChild(root_0, SINGLE_QUOTE27_tree);
            }
            SEMICOLON28=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_set_statement774); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON28_tree = (Object)adaptor.create(SEMICOLON28);
            adaptor.addChild(root_0, SEMICOLON28_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SET"));
                      BaseSetDef settingDef = new BaseSetDef();
                      settingDef.setName(column.ret);
                      settingDef.setValue(value.ret);
                      statement.setSettingDef(settingDef);
                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "set_statement"

    public static class dml_table_name_return extends ParserRuleReturnScope {
        public BaseTableDef ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dml_table_name"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:149:1: dml_table_name returns [BaseTableDef ret] : LSQUARE n= NAME COLON b= NAME RSQUARE ;
    public final TOMMY_SQLParser.dml_table_name_return dml_table_name() throws RecognitionException {
        TOMMY_SQLParser.dml_table_name_return retval = new TOMMY_SQLParser.dml_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token b=null;
        Token LSQUARE29=null;
        Token COLON30=null;
        Token RSQUARE31=null;

        Object n_tree=null;
        Object b_tree=null;
        Object LSQUARE29_tree=null;
        Object COLON30_tree=null;
        Object RSQUARE31_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:150:5: ( LSQUARE n= NAME COLON b= NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:150:9: LSQUARE n= NAME COLON b= NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            LSQUARE29=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_table_name804); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LSQUARE29_tree = (Object)adaptor.create(LSQUARE29);
            adaptor.addChild(root_0, LSQUARE29_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name808); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON30=(Token)match(input,COLON,FOLLOW_COLON_in_dml_table_name810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON30_tree = (Object)adaptor.create(COLON30);
            adaptor.addChild(root_0, COLON30_tree);
            }
            b=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name814); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (Object)adaptor.create(b);
            adaptor.addChild(root_0, b_tree);
            }
            RSQUARE31=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_table_name816); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE31_tree = (Object)adaptor.create(RSQUARE31);
            adaptor.addChild(root_0, RSQUARE31_tree);
            }
            if ( state.backtracking==0 ) {

                              BaseTableDef tableDef = new BaseTableDef();
                              tableDef.setName(n.getText());
                              tableDef.setSource(b.getText());
                              retval.ret = tableDef;
                      
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dml_table_name"

    public static class dml_bind_column_name_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dml_bind_column_name"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:158:1: dml_bind_column_name returns [String ret] : n= LSQUARE COLON NAME RSQUARE ;
    public final TOMMY_SQLParser.dml_bind_column_name_return dml_bind_column_name() throws RecognitionException {
        TOMMY_SQLParser.dml_bind_column_name_return retval = new TOMMY_SQLParser.dml_bind_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token COLON32=null;
        Token NAME33=null;
        Token RSQUARE34=null;

        Object n_tree=null;
        Object COLON32_tree=null;
        Object NAME33_tree=null;
        Object RSQUARE34_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:159:5: (n= LSQUARE COLON NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:159:9: n= LSQUARE COLON NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_bind_column_name843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON32=(Token)match(input,COLON,FOLLOW_COLON_in_dml_bind_column_name845); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON32_tree = (Object)adaptor.create(COLON32);
            adaptor.addChild(root_0, COLON32_tree);
            }
            NAME33=(Token)match(input,NAME,FOLLOW_NAME_in_dml_bind_column_name847); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME33_tree = (Object)adaptor.create(NAME33);
            adaptor.addChild(root_0, NAME33_tree);
            }
            RSQUARE34=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_bind_column_name849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE34_tree = (Object)adaptor.create(RSQUARE34);
            adaptor.addChild(root_0, RSQUARE34_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dml_bind_column_name"

    public static class dml_lookup_where_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dml_lookup_where"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:163:1: dml_lookup_where returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final TOMMY_SQLParser.dml_lookup_where_return dml_lookup_where() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_where_return retval = new TOMMY_SQLParser.dml_lookup_where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME35=null;
        Token NAME36=null;

        Object n_tree=null;
        Object NAME35_tree=null;
        Object NAME36_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:164:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:164:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:164:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:164:11: NAME ( NAME )*
            {
            NAME35=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where876); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME35_tree = (Object)adaptor.create(NAME35);
            adaptor.addChild(root_0, NAME35_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:164:16: ( NAME )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case NAME:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:164:17: NAME
            	    {
            	    NAME36=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where879); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME36_tree = (Object)adaptor.create(NAME36);
            	    adaptor.addChild(root_0, NAME36_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              retval.ret = input.toString(retval.start,input.LT(-1));
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dml_lookup_where"

    public static class dml_select_body_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dml_select_body"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:167:1: dml_select_body returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final TOMMY_SQLParser.dml_select_body_return dml_select_body() throws RecognitionException {
        TOMMY_SQLParser.dml_select_body_return retval = new TOMMY_SQLParser.dml_select_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME37=null;
        Token NAME38=null;

        Object n_tree=null;
        Object NAME37_tree=null;
        Object NAME38_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:11: NAME ( NAME )*
            {
            NAME37=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME37_tree = (Object)adaptor.create(NAME37);
            adaptor.addChild(root_0, NAME37_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:16: ( NAME )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case NAME:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:17: NAME
            	    {
            	    NAME38=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body912); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME38_tree = (Object)adaptor.create(NAME38);
            	    adaptor.addChild(root_0, NAME38_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              retval.ret = input.toString(retval.start,input.LT(-1));
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dml_select_body"

    public static class dml_lookup_select_where_body_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dml_lookup_select_where_body"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:171:1: dml_lookup_select_where_body returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ ;
    public final TOMMY_SQLParser.dml_lookup_select_where_body_return dml_lookup_select_where_body() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_select_where_body_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:8: (n=~ ( '\\r' | '\\n' | ';' ) )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:0:0: n=~ ( '\\r' | '\\n' | ';' )
            	    {
            	    n=(Token)input.LT(1);
            	    if ( (input.LA(1)>=DELETE && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=67 && input.LA(1)<=80) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(n));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            if ( state.backtracking==0 ) {
              retval.ret = input.toString(retval.start,input.LT(-1));
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dml_lookup_select_where_body"

    public static class dml_lookup_select_where_body2_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dml_lookup_select_where_body2"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:175:1: dml_lookup_select_where_body2 returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON ;
    public final TOMMY_SQLParser.dml_lookup_select_where_body2_return dml_lookup_select_where_body2() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_select_where_body2_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SEMICOLON39=null;

        Object n_tree=null;
        Object SEMICOLON39_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:8: (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case DELETE:
                case SELECT:
                case FROM:
                case WHERE:
                case LOOKUP:
                case INSERT:
                case UPSERT:
                case CREATE:
                case STREAM:
                case STREAMS:
                case BSTREAM:
                case BUCKET:
                case SOURCE:
                case SOURCES:
                case DROP:
                case SHOW:
                case JOB:
                case LPAREN:
                case RPAREN:
                case LSQUARE:
                case RSQUARE:
                case LCURLY:
                case RCURLY:
                case LBLE:
                case RBLE:
                case QUESTION:
                case EXCLAMATION:
                case SINGLE_QUOTE:
                case DOUBLE_QUOTE:
                case UNDERLINE:
                case COMMA:
                case COMM:
                case COLON:
                case META:
                case AND:
                case OR:
                case PLUS:
                case MINUS:
                case MULTI:
                case DIV:
                case MOD:
                case ANDMARK:
                case EQUAL:
                case INCREASE:
                case VALUES:
                case INTO:
                case UPDATE:
                case SET:
                case CLUSTER:
                case JOBS:
                case KILL:
                case SNAPSHOT:
                case USE:
                case NAME:
                case WHITESPACE:
                case WS:
                case UNICODE_LETTER:
                case UNICODE_DIGIT:
                case LETTER:
                case DIGIT:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:0:0: n=~ ( '\\r' | '\\n' | ';' )
            	    {
            	    n=(Token)input.LT(1);
            	    if ( (input.LA(1)>=DELETE && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=67 && input.LA(1)<=80) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(n));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            SEMICOLON39=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_dml_lookup_select_where_body2989); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON39_tree = (Object)adaptor.create(SEMICOLON39);
            adaptor.addChild(root_0, SEMICOLON39_tree);
            }
            if ( state.backtracking==0 ) {
              retval.ret = input.toString(retval.start,input.LT(-1));
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dml_lookup_select_where_body2"

    public static class lookup_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lookup_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:179:1: lookup_statement : LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.lookup_statement_return lookup_statement() throws RecognitionException {
        TOMMY_SQLParser.lookup_statement_return retval = new TOMMY_SQLParser.lookup_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOOKUP40=null;
        Token WHERE41=null;
        Token SEMICOLON42=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object LOOKUP40_tree=null;
        Object WHERE41_tree=null;
        Object SEMICOLON42_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:5: ( LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:7: LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            LOOKUP40=(Token)match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup_statement1008); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOOKUP40_tree = (Object)adaptor.create(LOOKUP40);
            adaptor.addChild(root_0, LOOKUP40_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_lookup_statement1014);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            int alt6=2;
            switch ( input.LA(1) ) {
            case WHERE:
                {
                alt6=1;
                }
                break;
            case SEMICOLON:
                {
                alt6=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE41=(Token)match(input,WHERE,FOLLOW_WHERE_in_lookup_statement1017); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE41_tree = (Object)adaptor.create(WHERE41);
                    adaptor.addChild(root_0, WHERE41_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1023);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:96: SEMICOLON
                    {
                    SEMICOLON42=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lookup_statement1025); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON42_tree = (Object)adaptor.create(SEMICOLON42);
                    adaptor.addChild(root_0, SEMICOLON42_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      if (body1 != null) {
                          QueryParser lookupParser = new QueryParser();
                          BaseStatement statement = lookupParser.parseWithoutEPL(input.toString(retval.start,input.LT(-1)));
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("LOOKUP"));
                          statements.add(statement);
                      }
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lookup_statement"

    public static class select_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:192:1: select_statement : SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.select_statement_return select_statement() throws RecognitionException {
        TOMMY_SQLParser.select_statement_return retval = new TOMMY_SQLParser.select_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT43=null;
        Token WHERE44=null;
        Token SEMICOLON45=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object SELECT43_tree=null;
        Object WHERE44_tree=null;
        Object SEMICOLON45_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:193:5: ( SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:193:7: SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            SELECT43=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_statement1049); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SELECT43_tree = (Object)adaptor.create(SELECT43);
            adaptor.addChild(root_0, SELECT43_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_select_statement1055);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:193:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            int alt7=2;
            switch ( input.LA(1) ) {
            case WHERE:
                {
                alt7=1;
                }
                break;
            case SEMICOLON:
                {
                alt7=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:193:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE44=(Token)match(input,WHERE,FOLLOW_WHERE_in_select_statement1058); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE44_tree = (Object)adaptor.create(WHERE44);
                    adaptor.addChild(root_0, WHERE44_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_select_statement1064);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:193:96: SEMICOLON
                    {
                    SEMICOLON45=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_select_statement1066); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON45_tree = (Object)adaptor.create(SEMICOLON45);
                    adaptor.addChild(root_0, SEMICOLON45_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      if (body1 != null) {
                          QueryParser esperParser = new QueryParser();
                          BaseStatement statement = esperParser.parse(input.toString(retval.start,input.LT(-1)));
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("SELECT"));
                          statements.add(statement);
                      }

                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "select_statement"

    public static class upsert_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "upsert_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:206:1: upsert_statement : UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.upsert_statement_return upsert_statement() throws RecognitionException {
        TOMMY_SQLParser.upsert_statement_return retval = new TOMMY_SQLParser.upsert_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPSERT46=null;
        Token INTO47=null;
        Token VALUES48=null;
        Token INCREASE49=null;
        Token VALUES50=null;
        Token SEMICOLON51=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object UPSERT46_tree=null;
        Object INTO47_tree=null;
        Object VALUES48_tree=null;
        Object INCREASE49_tree=null;
        Object VALUES50_tree=null;
        Object SEMICOLON51_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:5: ( UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:7: UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPSERT46=(Token)match(input,UPSERT,FOLLOW_UPSERT_in_upsert_statement1090); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPSERT46_tree = (Object)adaptor.create(UPSERT46);
            adaptor.addChild(root_0, UPSERT46_tree);
            }
            INTO47=(Token)match(input,INTO,FOLLOW_INTO_in_upsert_statement1092); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO47_tree = (Object)adaptor.create(INTO47);
            adaptor.addChild(root_0, INTO47_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_upsert_statement1098);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            int alt8=3;
            switch ( input.LA(1) ) {
            case VALUES:
                {
                alt8=1;
                }
                break;
            case INCREASE:
                {
                alt8=2;
                }
                break;
            case SEMICOLON:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:57: VALUES body2= dml_lookup_select_where_body2
                    {
                    VALUES48=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES48_tree = (Object)adaptor.create(VALUES48);
                    adaptor.addChild(root_0, VALUES48_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1107);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:102: INCREASE VALUES body2= dml_lookup_select_where_body2
                    {
                    INCREASE49=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_upsert_statement1109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INCREASE49_tree = (Object)adaptor.create(INCREASE49);
                    adaptor.addChild(root_0, INCREASE49_tree);
                    }
                    VALUES50=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1111); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES50_tree = (Object)adaptor.create(VALUES50);
                    adaptor.addChild(root_0, VALUES50_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1117);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:156: SEMICOLON
                    {
                    SEMICOLON51=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_upsert_statement1119); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON51_tree = (Object)adaptor.create(SEMICOLON51);
                    adaptor.addChild(root_0, SEMICOLON51_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      if (body1 != null) {

                          QueryParser esperParser = new QueryParser();
                          BaseStatement statement = esperParser.parseWithoutInsertEPL(input.toString(retval.start,input.LT(-1)));
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("UPSERT"));
                          statements.add(statement);
                      }

                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "upsert_statement"

    public static class update_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "update_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:221:1: update_statement : UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.update_statement_return update_statement() throws RecognitionException {
        TOMMY_SQLParser.update_statement_return retval = new TOMMY_SQLParser.update_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPDATE52=null;
        Token SET53=null;
        Token SET54=null;
        Token WHERE55=null;
        Token SEMICOLON56=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body_return body3 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body4 = null;


        Object UPDATE52_tree=null;
        Object SET53_tree=null;
        Object SET54_tree=null;
        Object WHERE55_tree=null;
        Object SEMICOLON56_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:5: ( UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:7: UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPDATE52=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_update_statement1143); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPDATE52_tree = (Object)adaptor.create(UPDATE52);
            adaptor.addChild(root_0, UPDATE52_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1149);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:52: SET body2= dml_lookup_select_where_body2
                    {
                    SET53=(Token)match(input,SET,FOLLOW_SET_in_update_statement1152); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET53_tree = (Object)adaptor.create(SET53);
                    adaptor.addChild(root_0, SET53_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1158);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
                    {
                    SET54=(Token)match(input,SET,FOLLOW_SET_in_update_statement1162); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET54_tree = (Object)adaptor.create(SET54);
                    adaptor.addChild(root_0, SET54_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1168);
                    body3=dml_lookup_select_where_body();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());
                    WHERE55=(Token)match(input,WHERE,FOLLOW_WHERE_in_update_statement1170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE55_tree = (Object)adaptor.create(WHERE55);
                    adaptor.addChild(root_0, WHERE55_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1174);
                    body4=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body4.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:179: SEMICOLON
                    {
                    SEMICOLON56=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_update_statement1176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON56_tree = (Object)adaptor.create(SEMICOLON56);
                    adaptor.addChild(root_0, SEMICOLON56_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      if (body1 != null) {

                          QueryParser esperParser = new QueryParser();
                          BaseStatement statement = esperParser.parseWithoutEPL(input.toString(retval.start,input.LT(-1)));
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("UPDATE"));
                          statements.add(statement);
                      }

                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "update_statement"

    public static class delete_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delete_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:236:1: delete_statement : DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.delete_statement_return delete_statement() throws RecognitionException {
        TOMMY_SQLParser.delete_statement_return retval = new TOMMY_SQLParser.delete_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DELETE57=null;
        Token FROM58=null;
        Token WHERE59=null;
        Token SEMICOLON60=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object DELETE57_tree=null;
        Object FROM58_tree=null;
        Object WHERE59_tree=null;
        Object SEMICOLON60_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:237:5: ( DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:237:7: DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            DELETE57=(Token)match(input,DELETE,FOLLOW_DELETE_in_delete_statement1200); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DELETE57_tree = (Object)adaptor.create(DELETE57);
            adaptor.addChild(root_0, DELETE57_tree);
            }
            FROM58=(Token)match(input,FROM,FOLLOW_FROM_in_delete_statement1202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FROM58_tree = (Object)adaptor.create(FROM58);
            adaptor.addChild(root_0, FROM58_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_delete_statement1208);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:237:56: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            int alt10=2;
            switch ( input.LA(1) ) {
            case WHERE:
                {
                alt10=1;
                }
                break;
            case SEMICOLON:
                {
                alt10=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:237:57: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE59=(Token)match(input,WHERE,FOLLOW_WHERE_in_delete_statement1211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE59_tree = (Object)adaptor.create(WHERE59);
                    adaptor.addChild(root_0, WHERE59_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1217);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:237:101: SEMICOLON
                    {
                    SEMICOLON60=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_delete_statement1219); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON60_tree = (Object)adaptor.create(SEMICOLON60);
                    adaptor.addChild(root_0, SEMICOLON60_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      if (body1 != null) {
                          QueryParser esperParser = new QueryParser();
                          BaseStatement statement = esperParser.parseWithoutEPL(input.toString(retval.start,input.LT(-1)));
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("DELETE"));
                          statements.add(statement);
                      }

                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delete_statement"

    public static class ddl_table_name_return extends ParserRuleReturnScope {
        public BaseTableDef ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_table_name"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:250:1: ddl_table_name returns [BaseTableDef ret] : n= NAME ;
    public final TOMMY_SQLParser.ddl_table_name_return ddl_table_name() throws RecognitionException {
        TOMMY_SQLParser.ddl_table_name_return retval = new TOMMY_SQLParser.ddl_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:251:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:251:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_table_name1251); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {

                          BaseTableDef tableDef = new BaseTableDef();
                          tableDef.setName(n.getText());
                          retval.ret = tableDef;
                      
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_table_name"

    public static class ddl_column_pk_return extends ParserRuleReturnScope {
        public boolean ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_column_pk"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:258:1: ddl_column_pk returns [boolean ret] : n= 'PARTITION_KEY' ;
    public final TOMMY_SQLParser.ddl_column_pk_return ddl_column_pk() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_pk_return retval = new TOMMY_SQLParser.ddl_column_pk_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:259:5: (n= 'PARTITION_KEY' )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:260:9: n= 'PARTITION_KEY'
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,67,FOLLOW_67_in_ddl_column_pk1284); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
              retval.ret = true;
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_column_pk"

    public static class ddl_column_comment_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_column_comment"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:263:1: ddl_column_comment returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final TOMMY_SQLParser.ddl_column_comment_return ddl_column_comment() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_comment_return retval = new TOMMY_SQLParser.ddl_column_comment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE61=null;
        Token SINGLE_QUOTE62=null;

        Object n_tree=null;
        Object SINGLE_QUOTE61_tree=null;
        Object SINGLE_QUOTE62_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:264:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:264:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE61=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE61_tree = (Object)adaptor.create(SINGLE_QUOTE61);
            adaptor.addChild(root_0, SINGLE_QUOTE61_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_comment1313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE62=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1315); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE62_tree = (Object)adaptor.create(SINGLE_QUOTE62);
            adaptor.addChild(root_0, SINGLE_QUOTE62_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText();
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_column_comment"

    public static class ddl_column_name_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_column_name"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:267:1: ddl_column_name returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.ddl_column_name_return ddl_column_name() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_name_return retval = new TOMMY_SQLParser.ddl_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:268:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:268:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_name1342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_column_name"

    public static class ddl_column_type_return extends ParserRuleReturnScope {
        public ColumnDataTypeEnum ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_column_type"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:271:1: ddl_column_type returns [ColumnDataTypeEnum ret] : n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) ;
    public final TOMMY_SQLParser.ddl_column_type_return ddl_column_type() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_type_return retval = new TOMMY_SQLParser.ddl_column_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:272:5: (n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:272:9: n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=68 && input.LA(1)<=71) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(n));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {

                      retval.ret = ColumnDataTypeEnum.valueOf(n.getText()); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_column_type"

    public static class ddl_column_defs_return extends ParserRuleReturnScope {
        public List<BaseColumnDef> ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_column_defs"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:276:1: ddl_column_defs returns [List<BaseColumnDef> ret] : v= column_def ( COMMA v= column_def )* ;
    public final TOMMY_SQLParser.ddl_column_defs_return ddl_column_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_defs_return retval = new TOMMY_SQLParser.ddl_column_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA63=null;
        TOMMY_SQLParser.column_def_return v = null;


        Object COMMA63_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:277:5: (v= column_def ( COMMA v= column_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:278:9: v= column_def ( COMMA v= column_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_column_def_in_ddl_column_defs1412);
            v=column_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                          retval.ret = new ArrayList<BaseColumnDef>();
                          retval.ret.add(v.ret);
                      
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:281:11: ( COMMA v= column_def )*
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt11=1;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:281:12: COMMA v= column_def
            	    {
            	    COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_column_defs1417); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA63_tree = (Object)adaptor.create(COMMA63);
            	    adaptor.addChild(root_0, COMMA63_tree);
            	    }
            	    pushFollow(FOLLOW_column_def_in_ddl_column_defs1423);
            	    v=column_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.ret.add(v.ret);
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_column_defs"

    public static class column_def_return extends ParserRuleReturnScope {
        public BaseColumnDef ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column_def"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:284:1: column_def returns [BaseColumnDef ret] : c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* ;
    public final TOMMY_SQLParser.column_def_return column_def() throws RecognitionException {
        TOMMY_SQLParser.column_def_return retval = new TOMMY_SQLParser.column_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.ddl_column_name_return c = null;

        TOMMY_SQLParser.ddl_column_type_return dt = null;

        TOMMY_SQLParser.ddl_column_pk_return pk = null;

        TOMMY_SQLParser.ddl_column_comment_return cmt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:5: (c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:9: c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ddl_column_name_in_column_def1453);
            c=ddl_column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_ddl_column_type_in_column_def1457);
            dt=ddl_column_type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:46: (pk= ddl_column_pk )*
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case 67:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:47: pk= ddl_column_pk
            	    {
            	    pushFollow(FOLLOW_ddl_column_pk_in_column_def1462);
            	    pk=ddl_column_pk();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pk.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:66: (cmt= ddl_column_comment )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case SINGLE_QUOTE:
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:67: cmt= ddl_column_comment
            	    {
            	    pushFollow(FOLLOW_ddl_column_comment_in_column_def1469);
            	    cmt=ddl_column_comment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cmt.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {

                          retval.ret = new BaseColumnDef(c.ret.toString(), dt.ret, (pk == null ? false : pk.ret), (cmt == null ? "" : cmt.ret.toString()));
                      
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "column_def"

    public static class stream_meta_name_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stream_meta_name"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:292:1: stream_meta_name returns [String ret] : n= ( 'TOPIC' | 'COMMENT' ) ;
    public final TOMMY_SQLParser.stream_meta_name_return stream_meta_name() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_name_return retval = new TOMMY_SQLParser.stream_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:293:5: (n= ( 'TOPIC' | 'COMMENT' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:293:9: n= ( 'TOPIC' | 'COMMENT' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=72 && input.LA(1)<=73) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(n));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stream_meta_name"

    public static class stream_meta_value_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stream_meta_value"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:296:1: stream_meta_value returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final TOMMY_SQLParser.stream_meta_value_return stream_meta_value() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_value_return retval = new TOMMY_SQLParser.stream_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE64=null;
        Token SINGLE_QUOTE65=null;

        Object n_tree=null;
        Object SINGLE_QUOTE64_tree=null;
        Object SINGLE_QUOTE65_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:297:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:297:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE64=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1536); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE64_tree = (Object)adaptor.create(SINGLE_QUOTE64);
            adaptor.addChild(root_0, SINGLE_QUOTE64_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_stream_meta_value1540); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE65=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1542); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE65_tree = (Object)adaptor.create(SINGLE_QUOTE65);
            adaptor.addChild(root_0, SINGLE_QUOTE65_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stream_meta_value"

    public static class stream_meta_def_return extends ParserRuleReturnScope {
        public BaseMetaDef ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stream_meta_def"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:300:1: stream_meta_def returns [BaseMetaDef ret] : c= stream_meta_name dt= stream_meta_value ;
    public final TOMMY_SQLParser.stream_meta_def_return stream_meta_def() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_def_return retval = new TOMMY_SQLParser.stream_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.stream_meta_name_return c = null;

        TOMMY_SQLParser.stream_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:5: (c= stream_meta_name dt= stream_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:9: c= stream_meta_name dt= stream_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_name_in_stream_meta_def1569);
            c=stream_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_stream_meta_value_in_stream_meta_def1573);
            dt=stream_meta_value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
            if ( state.backtracking==0 ) {
               retval.ret = new BaseMetaDef(c.ret.toString(), dt.ret.toString()); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stream_meta_def"

    public static class ddl_stream_meta_defs_return extends ParserRuleReturnScope {
        public List<BaseMetaDef> ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_stream_meta_defs"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:305:1: ddl_stream_meta_defs returns [List<BaseMetaDef> ret] : v= stream_meta_def ( COMMA v= stream_meta_def )* ;
    public final TOMMY_SQLParser.ddl_stream_meta_defs_return ddl_stream_meta_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_stream_meta_defs_return retval = new TOMMY_SQLParser.ddl_stream_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA66=null;
        TOMMY_SQLParser.stream_meta_def_return v = null;


        Object COMMA66_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:306:10: (v= stream_meta_def ( COMMA v= stream_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:307:14: v= stream_meta_def ( COMMA v= stream_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1626);
            v=stream_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);
                           
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:310:16: ( COMMA v= stream_meta_def )*
            loop14:
            do {
                int alt14=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt14=1;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:310:17: COMMA v= stream_meta_def
            	    {
            	    COMMA66=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_stream_meta_defs1631); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA66_tree = (Object)adaptor.create(COMMA66);
            	    adaptor.addChild(root_0, COMMA66_tree);
            	    }
            	    pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1637);
            	    v=stream_meta_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.ret.add(v.ret);
            	    }

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_stream_meta_defs"

    public static class create_stream_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_stream_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:313:1: create_stream_statement : CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON ;
    public final TOMMY_SQLParser.create_stream_statement_return create_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.create_stream_statement_return retval = new TOMMY_SQLParser.create_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE67=null;
        Token STREAM68=null;
        Token LPAREN69=null;
        Token RPAREN70=null;
        Token META71=null;
        Token LPAREN72=null;
        Token RPAREN73=null;
        Token SEMICOLON74=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;

        TOMMY_SQLParser.ddl_column_defs_return columns = null;

        TOMMY_SQLParser.ddl_stream_meta_defs_return metas = null;


        Object CREATE67_tree=null;
        Object STREAM68_tree=null;
        Object LPAREN69_tree=null;
        Object RPAREN70_tree=null;
        Object META71_tree=null;
        Object LPAREN72_tree=null;
        Object RPAREN73_tree=null;
        Object SEMICOLON74_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:314:5: ( CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:314:7: CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE67=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_stream_statement1664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE67_tree = (Object)adaptor.create(CREATE67);
            adaptor.addChild(root_0, CREATE67_tree);
            }
            STREAM68=(Token)match(input,STREAM,FOLLOW_STREAM_in_create_stream_statement1666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM68_tree = (Object)adaptor.create(STREAM68);
            adaptor.addChild(root_0, STREAM68_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_stream_statement1670);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            LPAREN69=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1680); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN69_tree = (Object)adaptor.create(LPAREN69);
            adaptor.addChild(root_0, LPAREN69_tree);
            }
            pushFollow(FOLLOW_ddl_column_defs_in_create_stream_statement1684);
            columns=ddl_column_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, columns.getTree());
            RPAREN70=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1686); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN70_tree = (Object)adaptor.create(RPAREN70);
            adaptor.addChild(root_0, RPAREN70_tree);
            }
            META71=(Token)match(input,META,FOLLOW_META_in_create_stream_statement1688); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META71_tree = (Object)adaptor.create(META71);
            adaptor.addChild(root_0, META71_tree);
            }
            LPAREN72=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1690); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN72_tree = (Object)adaptor.create(LPAREN72);
            adaptor.addChild(root_0, LPAREN72_tree);
            }
            pushFollow(FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1694);
            metas=ddl_stream_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN73=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1696); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN73_tree = (Object)adaptor.create(RPAREN73);
            adaptor.addChild(root_0, RPAREN73_tree);
            }
            SEMICOLON74=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_stream_statement1698); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON74_tree = (Object)adaptor.create(SEMICOLON74);
            adaptor.addChild(root_0, SEMICOLON74_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("CREATE_STREAM"));
                      statement.setTable(table_name.ret);
                      statement.setColumns(columns.ret);
                      statement.setMetas(metas.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "create_stream_statement"

    public static class drop_stream_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_stream_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:328:1: drop_stream_statement : DROP STREAM table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_stream_statement_return drop_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_stream_statement_return retval = new TOMMY_SQLParser.drop_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP75=null;
        Token STREAM76=null;
        Token SEMICOLON77=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP75_tree=null;
        Object STREAM76_tree=null;
        Object SEMICOLON77_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:329:5: ( DROP STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:329:7: DROP STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP75=(Token)match(input,DROP,FOLLOW_DROP_in_drop_stream_statement1721); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP75_tree = (Object)adaptor.create(DROP75);
            adaptor.addChild(root_0, DROP75_tree);
            }
            STREAM76=(Token)match(input,STREAM,FOLLOW_STREAM_in_drop_stream_statement1723); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM76_tree = (Object)adaptor.create(STREAM76);
            adaptor.addChild(root_0, STREAM76_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_stream_statement1727);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON77=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_stream_statement1729); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON77_tree = (Object)adaptor.create(SEMICOLON77);
            adaptor.addChild(root_0, SEMICOLON77_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("DROP_STREAM"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "drop_stream_statement"

    public static class show_stream_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_stream_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:340:1: show_stream_statement : SHOW STREAM table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_stream_statement_return show_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.show_stream_statement_return retval = new TOMMY_SQLParser.show_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW78=null;
        Token STREAM79=null;
        Token SEMICOLON80=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW78_tree=null;
        Object STREAM79_tree=null;
        Object SEMICOLON80_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:341:5: ( SHOW STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:341:7: SHOW STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW78=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_stream_statement1752); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW78_tree = (Object)adaptor.create(SHOW78);
            adaptor.addChild(root_0, SHOW78_tree);
            }
            STREAM79=(Token)match(input,STREAM,FOLLOW_STREAM_in_show_stream_statement1754); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM79_tree = (Object)adaptor.create(STREAM79);
            adaptor.addChild(root_0, STREAM79_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_stream_statement1758);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON80=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_stream_statement1760); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON80_tree = (Object)adaptor.create(SEMICOLON80);
            adaptor.addChild(root_0, SEMICOLON80_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_STREAM"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "show_stream_statement"

    public static class show_streams_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_streams_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:352:1: show_streams_statement : SHOW STREAMS SEMICOLON ;
    public final TOMMY_SQLParser.show_streams_statement_return show_streams_statement() throws RecognitionException {
        TOMMY_SQLParser.show_streams_statement_return retval = new TOMMY_SQLParser.show_streams_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW81=null;
        Token STREAMS82=null;
        Token SEMICOLON83=null;

        Object SHOW81_tree=null;
        Object STREAMS82_tree=null;
        Object SEMICOLON83_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:353:5: ( SHOW STREAMS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:353:7: SHOW STREAMS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW81=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_streams_statement1783); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW81_tree = (Object)adaptor.create(SHOW81);
            adaptor.addChild(root_0, SHOW81_tree);
            }
            STREAMS82=(Token)match(input,STREAMS,FOLLOW_STREAMS_in_show_streams_statement1785); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAMS82_tree = (Object)adaptor.create(STREAMS82);
            adaptor.addChild(root_0, STREAMS82_tree);
            }
            SEMICOLON83=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_streams_statement1787); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON83_tree = (Object)adaptor.create(SEMICOLON83);
            adaptor.addChild(root_0, SEMICOLON83_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_STREAMS"));

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "show_streams_statement"

    public static class kill_job_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "kill_job_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:363:1: kill_job_statement : KILL JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.kill_job_statement_return kill_job_statement() throws RecognitionException {
        TOMMY_SQLParser.kill_job_statement_return retval = new TOMMY_SQLParser.kill_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KILL84=null;
        Token JOB85=null;
        Token SEMICOLON86=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object KILL84_tree=null;
        Object JOB85_tree=null;
        Object SEMICOLON86_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:364:5: ( KILL JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:364:7: KILL JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            KILL84=(Token)match(input,KILL,FOLLOW_KILL_in_kill_job_statement1810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KILL84_tree = (Object)adaptor.create(KILL84);
            adaptor.addChild(root_0, KILL84_tree);
            }
            JOB85=(Token)match(input,JOB,FOLLOW_JOB_in_kill_job_statement1812); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB85_tree = (Object)adaptor.create(JOB85);
            adaptor.addChild(root_0, JOB85_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_kill_job_statement1816);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON86=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_kill_job_statement1818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON86_tree = (Object)adaptor.create(SEMICOLON86);
            adaptor.addChild(root_0, SEMICOLON86_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("KILL_JOB"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "kill_job_statement"

    public static class source_meta_name_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "source_meta_name"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:375:1: source_meta_name returns [String ret] : n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' ) ;
    public final TOMMY_SQLParser.source_meta_name_return source_meta_name() throws RecognitionException {
        TOMMY_SQLParser.source_meta_name_return retval = new TOMMY_SQLParser.source_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:376:5: (n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:376:9: n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=74 && input.LA(1)<=80) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(n));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "source_meta_name"

    public static class source_meta_value_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "source_meta_value"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:379:1: source_meta_value returns [String ret] : SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE ;
    public final TOMMY_SQLParser.source_meta_value_return source_meta_value() throws RecognitionException {
        TOMMY_SQLParser.source_meta_value_return retval = new TOMMY_SQLParser.source_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE87=null;
        Token set88=null;
        Token SINGLE_QUOTE89=null;

        Object n_tree=null;
        Object SINGLE_QUOTE87_tree=null;
        Object set88_tree=null;
        Object SINGLE_QUOTE89_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:380:5: ( SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:380:9: SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE87=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value1888); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE87_tree = (Object)adaptor.create(SINGLE_QUOTE87);
            adaptor.addChild(root_0, SINGLE_QUOTE87_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_source_meta_value1892); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:380:29: ( NAME | COMMA )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case COMMA:
                case NAME:
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:
            	    {
            	    set88=(Token)input.LT(1);
            	    if ( input.LA(1)==COMMA||input.LA(1)==NAME ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set88));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            SINGLE_QUOTE89=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value1901); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE89_tree = (Object)adaptor.create(SINGLE_QUOTE89);
            adaptor.addChild(root_0, SINGLE_QUOTE89_tree);
            }
            if ( state.backtracking==0 ) {
               retval.ret = n.getText(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "source_meta_value"

    public static class source_meta_def_return extends ParserRuleReturnScope {
        public BaseMetaDef ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "source_meta_def"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:383:1: source_meta_def returns [BaseMetaDef ret] : c= source_meta_name dt= source_meta_value ;
    public final TOMMY_SQLParser.source_meta_def_return source_meta_def() throws RecognitionException {
        TOMMY_SQLParser.source_meta_def_return retval = new TOMMY_SQLParser.source_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.source_meta_name_return c = null;

        TOMMY_SQLParser.source_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:384:5: (c= source_meta_name dt= source_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:384:9: c= source_meta_name dt= source_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_name_in_source_meta_def1928);
            c=source_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_source_meta_value_in_source_meta_def1932);
            dt=source_meta_value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
            if ( state.backtracking==0 ) {
               retval.ret = new BaseMetaDef(c.ret.toString(), dt.ret.toString()); 
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "source_meta_def"

    public static class ddl_source_meta_defs_return extends ParserRuleReturnScope {
        public List<BaseMetaDef> ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ddl_source_meta_defs"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:388:1: ddl_source_meta_defs returns [List<BaseMetaDef> ret] : v= source_meta_def ( COMMA v= source_meta_def )* ;
    public final TOMMY_SQLParser.ddl_source_meta_defs_return ddl_source_meta_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_source_meta_defs_return retval = new TOMMY_SQLParser.ddl_source_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA90=null;
        TOMMY_SQLParser.source_meta_def_return v = null;


        Object COMMA90_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:389:10: (v= source_meta_def ( COMMA v= source_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:390:14: v= source_meta_def ( COMMA v= source_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs1985);
            v=source_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);
                           
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:393:16: ( COMMA v= source_meta_def )*
            loop16:
            do {
                int alt16=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt16=1;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:393:17: COMMA v= source_meta_def
            	    {
            	    COMMA90=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_source_meta_defs1990); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA90_tree = (Object)adaptor.create(COMMA90);
            	    adaptor.addChild(root_0, COMMA90_tree);
            	    }
            	    pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs1996);
            	    v=source_meta_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.ret.add(v.ret);
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ddl_source_meta_defs"

    public static class create_source_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_source_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:396:1: create_source_statement : CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON ;
    public final TOMMY_SQLParser.create_source_statement_return create_source_statement() throws RecognitionException {
        TOMMY_SQLParser.create_source_statement_return retval = new TOMMY_SQLParser.create_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE91=null;
        Token SOURCE92=null;
        Token META93=null;
        Token LPAREN94=null;
        Token RPAREN95=null;
        Token SEMICOLON96=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;

        TOMMY_SQLParser.ddl_source_meta_defs_return metas = null;


        Object CREATE91_tree=null;
        Object SOURCE92_tree=null;
        Object META93_tree=null;
        Object LPAREN94_tree=null;
        Object RPAREN95_tree=null;
        Object SEMICOLON96_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:397:5: ( CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:397:7: CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE91=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_source_statement2023); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE91_tree = (Object)adaptor.create(CREATE91);
            adaptor.addChild(root_0, CREATE91_tree);
            }
            SOURCE92=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_create_source_statement2025); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE92_tree = (Object)adaptor.create(SOURCE92);
            adaptor.addChild(root_0, SOURCE92_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_source_statement2029);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            META93=(Token)match(input,META,FOLLOW_META_in_create_source_statement2031); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META93_tree = (Object)adaptor.create(META93);
            adaptor.addChild(root_0, META93_tree);
            }
            LPAREN94=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_source_statement2033); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN94_tree = (Object)adaptor.create(LPAREN94);
            adaptor.addChild(root_0, LPAREN94_tree);
            }
            pushFollow(FOLLOW_ddl_source_meta_defs_in_create_source_statement2037);
            metas=ddl_source_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN95=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_source_statement2039); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN95_tree = (Object)adaptor.create(RPAREN95);
            adaptor.addChild(root_0, RPAREN95_tree);
            }
            SEMICOLON96=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_source_statement2041); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON96_tree = (Object)adaptor.create(SEMICOLON96);
            adaptor.addChild(root_0, SEMICOLON96_tree);
            }
            if ( state.backtracking==0 ) {


                          BaseStatement statement = new BaseStatement();
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("CREATE_SOURCE"));
                          statement.setTable(table_name.ret);
                          statement.setMetas(metas.ret);

                          statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "create_source_statement"

    public static class drop_source_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_source_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:410:1: drop_source_statement : DROP SOURCE table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_source_statement_return drop_source_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_source_statement_return retval = new TOMMY_SQLParser.drop_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP97=null;
        Token SOURCE98=null;
        Token SEMICOLON99=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP97_tree=null;
        Object SOURCE98_tree=null;
        Object SEMICOLON99_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:411:5: ( DROP SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:411:7: DROP SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP97=(Token)match(input,DROP,FOLLOW_DROP_in_drop_source_statement2064); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP97_tree = (Object)adaptor.create(DROP97);
            adaptor.addChild(root_0, DROP97_tree);
            }
            SOURCE98=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_drop_source_statement2066); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE98_tree = (Object)adaptor.create(SOURCE98);
            adaptor.addChild(root_0, SOURCE98_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_source_statement2070);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON99=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_source_statement2072); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON99_tree = (Object)adaptor.create(SEMICOLON99);
            adaptor.addChild(root_0, SEMICOLON99_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("DROP_SOURCE"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "drop_source_statement"

    public static class show_source_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_source_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:422:1: show_source_statement : SHOW SOURCE table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_source_statement_return show_source_statement() throws RecognitionException {
        TOMMY_SQLParser.show_source_statement_return retval = new TOMMY_SQLParser.show_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW100=null;
        Token SOURCE101=null;
        Token SEMICOLON102=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW100_tree=null;
        Object SOURCE101_tree=null;
        Object SEMICOLON102_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:423:5: ( SHOW SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:423:7: SHOW SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW100=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_source_statement2095); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW100_tree = (Object)adaptor.create(SHOW100);
            adaptor.addChild(root_0, SHOW100_tree);
            }
            SOURCE101=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_show_source_statement2097); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE101_tree = (Object)adaptor.create(SOURCE101);
            adaptor.addChild(root_0, SOURCE101_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_source_statement2101);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON102=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_source_statement2103); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON102_tree = (Object)adaptor.create(SEMICOLON102);
            adaptor.addChild(root_0, SEMICOLON102_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_SOURCE"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "show_source_statement"

    public static class show_sources_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_sources_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:434:1: show_sources_statement : SHOW SOURCES SEMICOLON ;
    public final TOMMY_SQLParser.show_sources_statement_return show_sources_statement() throws RecognitionException {
        TOMMY_SQLParser.show_sources_statement_return retval = new TOMMY_SQLParser.show_sources_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW103=null;
        Token SOURCES104=null;
        Token SEMICOLON105=null;

        Object SHOW103_tree=null;
        Object SOURCES104_tree=null;
        Object SEMICOLON105_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:435:5: ( SHOW SOURCES SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:435:7: SHOW SOURCES SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW103=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_sources_statement2126); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW103_tree = (Object)adaptor.create(SHOW103);
            adaptor.addChild(root_0, SHOW103_tree);
            }
            SOURCES104=(Token)match(input,SOURCES,FOLLOW_SOURCES_in_show_sources_statement2128); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCES104_tree = (Object)adaptor.create(SOURCES104);
            adaptor.addChild(root_0, SOURCES104_tree);
            }
            SEMICOLON105=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_sources_statement2130); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON105_tree = (Object)adaptor.create(SEMICOLON105);
            adaptor.addChild(root_0, SEMICOLON105_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_SOURCES"));

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "show_sources_statement"

    public static class drop_job_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "drop_job_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:445:1: drop_job_statement : DROP JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_job_statement_return drop_job_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_job_statement_return retval = new TOMMY_SQLParser.drop_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP106=null;
        Token JOB107=null;
        Token SEMICOLON108=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP106_tree=null;
        Object JOB107_tree=null;
        Object SEMICOLON108_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:446:5: ( DROP JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:446:7: DROP JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP106=(Token)match(input,DROP,FOLLOW_DROP_in_drop_job_statement2153); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP106_tree = (Object)adaptor.create(DROP106);
            adaptor.addChild(root_0, DROP106_tree);
            }
            JOB107=(Token)match(input,JOB,FOLLOW_JOB_in_drop_job_statement2155); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB107_tree = (Object)adaptor.create(JOB107);
            adaptor.addChild(root_0, JOB107_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_job_statement2159);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON108=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_job_statement2161); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON108_tree = (Object)adaptor.create(SEMICOLON108);
            adaptor.addChild(root_0, SEMICOLON108_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("DROP_JOB"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "drop_job_statement"

    public static class show_job_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_job_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:457:1: show_job_statement : SHOW JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_job_statement_return show_job_statement() throws RecognitionException {
        TOMMY_SQLParser.show_job_statement_return retval = new TOMMY_SQLParser.show_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW109=null;
        Token JOB110=null;
        Token SEMICOLON111=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW109_tree=null;
        Object JOB110_tree=null;
        Object SEMICOLON111_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:458:5: ( SHOW JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:458:7: SHOW JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW109=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_job_statement2184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW109_tree = (Object)adaptor.create(SHOW109);
            adaptor.addChild(root_0, SHOW109_tree);
            }
            JOB110=(Token)match(input,JOB,FOLLOW_JOB_in_show_job_statement2186); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB110_tree = (Object)adaptor.create(JOB110);
            adaptor.addChild(root_0, JOB110_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_job_statement2190);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON111=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_job_statement2192); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON111_tree = (Object)adaptor.create(SEMICOLON111);
            adaptor.addChild(root_0, SEMICOLON111_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_JOB"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "show_job_statement"

    public static class show_jobs_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_jobs_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:469:1: show_jobs_statement : SHOW JOBS SEMICOLON ;
    public final TOMMY_SQLParser.show_jobs_statement_return show_jobs_statement() throws RecognitionException {
        TOMMY_SQLParser.show_jobs_statement_return retval = new TOMMY_SQLParser.show_jobs_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW112=null;
        Token JOBS113=null;
        Token SEMICOLON114=null;

        Object SHOW112_tree=null;
        Object JOBS113_tree=null;
        Object SEMICOLON114_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:470:5: ( SHOW JOBS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:470:7: SHOW JOBS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW112=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_jobs_statement2215); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW112_tree = (Object)adaptor.create(SHOW112);
            adaptor.addChild(root_0, SHOW112_tree);
            }
            JOBS113=(Token)match(input,JOBS,FOLLOW_JOBS_in_show_jobs_statement2217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOBS113_tree = (Object)adaptor.create(JOBS113);
            adaptor.addChild(root_0, JOBS113_tree);
            }
            SEMICOLON114=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_jobs_statement2219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON114_tree = (Object)adaptor.create(SEMICOLON114);
            adaptor.addChild(root_0, SEMICOLON114_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_JOBS"));

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "show_jobs_statement"

    public static class show_cluster_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_cluster_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:480:1: show_cluster_statement : SHOW CLUSTER SEMICOLON ;
    public final TOMMY_SQLParser.show_cluster_statement_return show_cluster_statement() throws RecognitionException {
        TOMMY_SQLParser.show_cluster_statement_return retval = new TOMMY_SQLParser.show_cluster_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW115=null;
        Token CLUSTER116=null;
        Token SEMICOLON117=null;

        Object SHOW115_tree=null;
        Object CLUSTER116_tree=null;
        Object SEMICOLON117_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:481:5: ( SHOW CLUSTER SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:481:7: SHOW CLUSTER SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW115=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_cluster_statement2242); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW115_tree = (Object)adaptor.create(SHOW115);
            adaptor.addChild(root_0, SHOW115_tree);
            }
            CLUSTER116=(Token)match(input,CLUSTER,FOLLOW_CLUSTER_in_show_cluster_statement2244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CLUSTER116_tree = (Object)adaptor.create(CLUSTER116);
            adaptor.addChild(root_0, CLUSTER116_tree);
            }
            SEMICOLON117=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_cluster_statement2246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON117_tree = (Object)adaptor.create(SEMICOLON117);
            adaptor.addChild(root_0, SEMICOLON117_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_CLUSTER"));

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "show_cluster_statement"

    public static class snapshot_job_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "snapshot_job_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:491:1: snapshot_job_statement : SNAPSHOT JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.snapshot_job_statement_return snapshot_job_statement() throws RecognitionException {
        TOMMY_SQLParser.snapshot_job_statement_return retval = new TOMMY_SQLParser.snapshot_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SNAPSHOT118=null;
        Token JOB119=null;
        Token SEMICOLON120=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SNAPSHOT118_tree=null;
        Object JOB119_tree=null;
        Object SEMICOLON120_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:492:5: ( SNAPSHOT JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:492:7: SNAPSHOT JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SNAPSHOT118=(Token)match(input,SNAPSHOT,FOLLOW_SNAPSHOT_in_snapshot_job_statement2269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SNAPSHOT118_tree = (Object)adaptor.create(SNAPSHOT118);
            adaptor.addChild(root_0, SNAPSHOT118_tree);
            }
            JOB119=(Token)match(input,JOB,FOLLOW_JOB_in_snapshot_job_statement2271); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB119_tree = (Object)adaptor.create(JOB119);
            adaptor.addChild(root_0, JOB119_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_snapshot_job_statement2275);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_snapshot_job_statement2277); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON120_tree = (Object)adaptor.create(SEMICOLON120);
            adaptor.addChild(root_0, SEMICOLON120_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SNAPSHOT_JOB"));
                      statement.setTable(table_name.ret);

                      statements.add(statement);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "snapshot_job_statement"

    // $ANTLR start synpred27_TOMMY_SQL
    public final void synpred27_TOMMY_SQL_fragment() throws RecognitionException {   
        Token n=null;

        // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:9: (n=~ ( '\\r' | '\\n' | ';' ) )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:9: n=~ ( '\\r' | '\\n' | ';' )
        {
        n=(Token)input.LT(1);
        if ( (input.LA(1)>=DELETE && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=67 && input.LA(1)<=80) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred27_TOMMY_SQL

    // $ANTLR start synpred36_TOMMY_SQL
    public final void synpred36_TOMMY_SQL_fragment() throws RecognitionException {   
        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:52: ( SET body2= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:52: SET body2= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred36_TOMMY_SQL1152); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred36_TOMMY_SQL1158);
        body2=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_TOMMY_SQL

    // $ANTLR start synpred37_TOMMY_SQL
    public final void synpred37_TOMMY_SQL_fragment() throws RecognitionException {   
        TOMMY_SQLParser.dml_lookup_select_where_body_return body3 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body4 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:96: ( SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred37_TOMMY_SQL1162); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body_in_synpred37_TOMMY_SQL1168);
        body3=dml_lookup_select_where_body();

        state._fsp--;
        if (state.failed) return ;
        match(input,WHERE,FOLLOW_WHERE_in_synpred37_TOMMY_SQL1170); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred37_TOMMY_SQL1174);
        body4=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_TOMMY_SQL

    // Delegated rules

    public final boolean synpred27_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA1_eotS =
        "\32\uffff";
    static final String DFA1_eofS =
        "\1\1\31\uffff";
    static final String DFA1_minS =
        "\1\4\5\uffff\1\14\4\uffff\2\14\15\uffff";
    static final String DFA1_maxS =
        "\1\71\5\uffff\1\66\4\uffff\1\20\1\24\15\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\26\1\1\1\2\1\3\1\4\1\uffff\1\11\1\12\1\13\1\14\2\uffff"+
        "\1\25\1\5\1\6\1\7\1\10\1\17\1\20\1\24\1\15\1\16\1\21\1\22\1\23";
    static final String DFA1_specialS =
        "\32\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\15\1\12\2\uffff\1\11\1\uffff\1\10\1\13\6\uffff\1\14\1\6\37"+
            "\uffff\1\7\1\5\2\uffff\1\4\1\3\1\2",
            "",
            "",
            "",
            "",
            "",
            "\1\22\1\17\2\uffff\1\23\1\16\2\uffff\1\24\40\uffff\1\20\1\21",
            "",
            "",
            "",
            "",
            "\1\25\3\uffff\1\26",
            "\1\27\3\uffff\1\30\3\uffff\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()+ loopback of 101:7: ( use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+";
        }
    }
    static final String DFA4_eotS =
        "\152\uffff";
    static final String DFA4_eofS =
        "\152\uffff";
    static final String DFA4_minS =
        "\2\4\1\uffff\2\4\1\0\1\uffff\1\0\5\4\1\0\4\4\2\0\5\4\1\0\4\4\1\0"+
        "\1\4\1\0\3\4\1\0\1\4\1\0\10\4\1\0\1\4\1\0\4\4\1\0\4\4\1\0\1\4\2"+
        "\0\1\4\1\0\3\4\3\0\5\4\1\0\5\4\1\0\1\4\1\0\1\4\1\0\4\4\4\0\5\4\3"+
        "\0\1\4\2\0";
    static final String DFA4_maxS =
        "\2\120\1\uffff\2\120\1\0\1\uffff\1\0\5\120\1\0\4\120\2\0\5\120\1"+
        "\0\4\120\1\0\1\120\1\0\3\120\1\0\1\120\1\0\10\120\1\0\1\120\1\0"+
        "\4\120\1\0\4\120\1\0\1\120\2\0\1\120\1\0\3\120\3\0\5\120\1\0\5\120"+
        "\1\0\1\120\1\0\1\120\1\0\4\120\4\0\5\120\3\0\1\120\2\0";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\143\uffff";
    static final String DFA4_specialS =
        "\5\uffff\1\21\1\uffff\1\3\5\uffff\1\16\4\uffff\1\37\1\36\5\uffff"+
        "\1\22\4\uffff\1\13\1\uffff\1\26\3\uffff\1\0\1\uffff\1\31\10\uffff"+
        "\1\32\1\uffff\1\30\4\uffff\1\27\4\uffff\1\35\1\uffff\1\33\1\12\1"+
        "\uffff\1\4\3\uffff\1\5\1\7\1\2\5\uffff\1\10\5\uffff\1\14\1\uffff"+
        "\1\11\1\uffff\1\34\4\uffff\1\17\1\15\1\25\1\23\5\uffff\1\1\1\40"+
        "\1\6\1\uffff\1\24\1\20}>";
    static final String[] DFA4_transitionS = {
            "\3\6\1\1\32\6\1\2\15\6\1\4\1\3\2\6\1\5\14\6\2\uffff\16\6",
            "\3\13\1\7\32\13\1\6\15\13\1\11\1\10\2\13\1\12\14\13\2\uffff"+
            "\16\13",
            "",
            "\3\20\1\14\32\20\1\6\15\20\1\16\1\15\2\20\1\17\14\20\2\uffff"+
            "\16\20",
            "\55\6\1\21\17\6\2\uffff\16\6",
            "\1\uffff",
            "",
            "\1\uffff",
            "\3\27\1\23\32\27\1\22\15\27\1\25\1\24\2\27\1\26\14\27\2\uffff"+
            "\16\27",
            "\3\13\1\7\32\13\1\22\15\13\1\11\1\30\2\13\1\12\14\13\2\uffff"+
            "\16\13",
            "\3\35\1\31\32\35\1\22\15\35\1\33\1\32\2\35\1\34\14\35\2\uffff"+
            "\16\35",
            "\3\13\1\7\32\13\1\22\15\13\1\11\1\10\2\13\1\12\14\13\2\uffff"+
            "\16\13",
            "\3\43\1\37\32\43\1\36\15\43\1\41\1\40\2\43\1\42\14\43\2\uffff"+
            "\16\43",
            "\1\uffff",
            "\3\20\1\14\32\20\1\36\15\20\1\16\1\44\2\20\1\17\14\20\2\uffff"+
            "\16\20",
            "\3\51\1\45\32\51\1\36\15\51\1\47\1\46\2\51\1\50\14\51\2\uffff"+
            "\16\51",
            "\3\20\1\14\32\20\1\36\15\20\1\16\1\15\2\20\1\17\14\20\2\uffff"+
            "\16\20",
            "\3\56\1\52\32\56\1\6\15\56\1\54\1\53\2\56\1\55\14\56\2\uffff"+
            "\16\56",
            "\1\uffff",
            "\1\uffff",
            "\3\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\14\27\2\uffff"+
            "\16\27",
            "\3\27\1\23\32\27\1\57\15\27\1\25\1\60\2\27\1\26\14\27\2\uffff"+
            "\16\27",
            "\3\65\1\61\32\65\1\57\15\65\1\63\1\62\2\65\1\64\14\65\2\uffff"+
            "\16\65",
            "\3\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\14\27\2\uffff"+
            "\16\27",
            "\3\72\1\66\32\72\1\22\15\72\1\70\1\67\2\72\1\71\14\72\2\uffff"+
            "\16\72",
            "\1\uffff",
            "\3\65\1\61\32\65\1\73\15\65\1\63\1\62\2\65\1\64\14\65\2\uffff"+
            "\16\65",
            "\3\35\1\31\32\35\1\73\15\35\1\33\1\74\2\35\1\34\14\35\2\uffff"+
            "\16\35",
            "\3\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\14\35\2\uffff"+
            "\16\35",
            "\3\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\14\35\2\uffff"+
            "\16\35",
            "\1\uffff",
            "\3\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\14\43\2\uffff"+
            "\16\43",
            "\1\uffff",
            "\3\43\1\37\32\43\1\75\15\43\1\41\1\76\2\43\1\42\14\43\2\uffff"+
            "\16\43",
            "\3\103\1\77\32\103\1\75\15\103\1\101\1\100\2\103\1\102\14\103"+
            "\2\uffff\16\103",
            "\3\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\14\43\2\uffff"+
            "\16\43",
            "\1\uffff",
            "\3\103\1\77\32\103\1\104\15\103\1\101\1\100\2\103\1\102\14"+
            "\103\2\uffff\16\103",
            "\1\uffff",
            "\3\51\1\45\32\51\1\104\15\51\1\47\1\105\2\51\1\50\14\51\2\uffff"+
            "\16\51",
            "\3\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\14\51\2\uffff"+
            "\16\51",
            "\3\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\14\51\2\uffff"+
            "\16\51",
            "\3\113\1\107\32\113\1\106\15\113\1\111\1\110\2\113\1\112\14"+
            "\113\2\uffff\16\113",
            "\3\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\14\56\2\uffff"+
            "\16\56",
            "\3\56\1\52\32\56\1\106\15\56\1\54\1\114\2\56\1\55\14\56\2\uffff"+
            "\16\56",
            "\3\121\1\115\32\121\1\106\15\121\1\117\1\116\2\121\1\120\14"+
            "\121\2\uffff\16\121",
            "\3\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\14\56\2\uffff"+
            "\16\56",
            "\1\uffff",
            "\3\72\1\66\32\72\1\57\15\72\1\70\1\67\2\72\1\71\14\72\2\uffff"+
            "\16\72",
            "\1\uffff",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\14\65\2\uffff"+
            "\16\65",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\123\2\65\1\64\14\65\2\uffff"+
            "\16\65",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\14\65\2\uffff"+
            "\16\65",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\14\65\2\uffff"+
            "\16\65",
            "\1\uffff",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\14\72\2\uffff"+
            "\16\72",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\125\2\72\1\71\14\72\2\uffff"+
            "\16\72",
            "\3\132\1\126\32\132\1\124\15\132\1\130\1\127\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\14\72\2\uffff"+
            "\16\72",
            "\1\uffff",
            "\3\132\1\126\32\132\1\73\15\132\1\130\1\127\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\1\uffff",
            "\1\uffff",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\14"+
            "\103\2\uffff\16\103",
            "\1\uffff",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\134\2\103\1\102\14"+
            "\103\2\uffff\16\103",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\14"+
            "\103\2\uffff\16\103",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\14"+
            "\103\2\uffff\16\103",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\14"+
            "\113\2\uffff\16\113",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\14"+
            "\113\2\uffff\16\113",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\136\2\113\1\112\14"+
            "\113\2\uffff\16\113",
            "\3\143\1\137\32\143\1\135\15\143\1\141\1\140\2\143\1\142\14"+
            "\143\2\uffff\16\143",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\14"+
            "\113\2\uffff\16\113",
            "\1\uffff",
            "\3\143\1\137\32\143\1\144\15\143\1\141\1\140\2\143\1\142\14"+
            "\143\2\uffff\16\143",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\14"+
            "\121\2\uffff\16\121",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\145\2\121\1\120\14"+
            "\121\2\uffff\16\121",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\14"+
            "\121\2\uffff\16\121",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\14"+
            "\121\2\uffff\16\121",
            "\1\uffff",
            "\3\132\1\126\32\132\1\122\15\132\1\130\1\127\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\1\uffff",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\14\72\2\uffff"+
            "\16\72",
            "\1\uffff",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\147\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\14"+
            "\143\2\uffff\16\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\14"+
            "\143\2\uffff\16\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\151\2\143\1\142\14"+
            "\143\2\uffff\16\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\14"+
            "\143\2\uffff\16\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\14"+
            "\143\2\uffff\16\143",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\14"+
            "\132\2\uffff\16\132",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()+ loopback of 172:9: (n=~ ( '\\r' | '\\n' | ';' ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_36 = input.LA(1);

                         
                        int index4_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_36);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_100 = input.LA(1);

                         
                        int index4_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_100);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_70 = input.LA(1);

                         
                        int index4_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_70);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_64 = input.LA(1);

                         
                        int index4_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_64);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_68 = input.LA(1);

                         
                        int index4_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_68);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_102 = input.LA(1);

                         
                        int index4_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_102);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_69 = input.LA(1);

                         
                        int index4_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_69);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_76 = input.LA(1);

                         
                        int index4_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_76);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_84 = input.LA(1);

                         
                        int index4_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_84);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_62 = input.LA(1);

                         
                        int index4_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_62);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_30 = input.LA(1);

                         
                        int index4_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_82 = input.LA(1);

                         
                        int index4_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_82);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_92 = input.LA(1);

                         
                        int index4_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_92);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_91 = input.LA(1);

                         
                        int index4_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_91);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA4_105 = input.LA(1);

                         
                        int index4_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_105);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA4_25 = input.LA(1);

                         
                        int index4_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_25);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA4_94 = input.LA(1);

                         
                        int index4_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_94);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA4_104 = input.LA(1);

                         
                        int index4_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_104);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA4_93 = input.LA(1);

                         
                        int index4_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_93);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA4_32 = input.LA(1);

                         
                        int index4_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_32);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA4_54 = input.LA(1);

                         
                        int index4_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_54);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA4_49 = input.LA(1);

                         
                        int index4_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_49);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA4_38 = input.LA(1);

                         
                        int index4_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_38);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA4_47 = input.LA(1);

                         
                        int index4_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_47);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA4_61 = input.LA(1);

                         
                        int index4_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_61);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA4_86 = input.LA(1);

                         
                        int index4_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_86);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA4_59 = input.LA(1);

                         
                        int index4_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_59);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA4_19 = input.LA(1);

                         
                        int index4_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_19);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA4_18 = input.LA(1);

                         
                        int index4_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_18);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA4_101 = input.LA(1);

                         
                        int index4_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_101);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\12\uffff";
    static final String DFA9_minS =
        "\1\42\1\4\1\uffff\1\4\1\uffff\3\4\1\0\1\uffff";
    static final String DFA9_maxS =
        "\1\64\1\120\1\uffff\1\120\1\uffff\3\120\1\0\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\3\1\uffff\1\1\4\uffff\1\2";
    static final String DFA9_specialS =
        "\10\uffff\1\0\1\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\21\uffff\1\1",
            "\36\3\1\uffff\36\3\2\uffff\16\3",
            "",
            "\3\3\1\5\32\3\1\4\36\3\2\uffff\16\3",
            "",
            "\3\7\1\6\32\7\1\4\36\7\2\uffff\16\7",
            "\3\7\1\6\32\7\1\10\36\7\2\uffff\16\7",
            "\3\7\1\6\32\7\1\10\36\7\2\uffff\16\7",
            "\1\uffff",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "222:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_TOMMY_SQL()) ) {s = 4;}

                        else if ( (synpred37_TOMMY_SQL()) ) {s = 9;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_use_statement_in_create_statement579 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_snapshot_job_statement_in_create_statement581 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_kill_job_statement_in_create_statement583 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_set_statement_in_create_statement585 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_show_sources_statement_in_create_statement587 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_show_streams_statement_in_create_statement589 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_show_cluster_statement_in_create_statement591 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_show_jobs_statement_in_create_statement593 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_update_statement_in_create_statement595 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_upsert_statement_in_create_statement597 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_lookup_statement_in_create_statement599 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_select_statement_in_create_statement601 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_create_stream_statement_in_create_statement603 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_create_source_statement_in_create_statement605 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_show_stream_statement_in_create_statement607 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_show_source_statement_in_create_statement609 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_drop_stream_statement_in_create_statement611 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_drop_source_statement_in_create_statement613 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_drop_job_statement_in_create_statement615 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_show_job_statement_in_create_statement617 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_delete_statement_in_create_statement619 = new BitSet(new long[]{0x03980000000C0D32L});
    public static final BitSet FOLLOW_NAME_in_use_name_def653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_use_statement672 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_use_statement676 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_use_statement678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_name_def710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_value_def738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_set_statement758 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_set_statement762 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_EQUAL_in_set_statement764 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement766 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_set_value_def_in_set_statement770 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement772 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_set_statement774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_table_name804 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name808 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_table_name810 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name814 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_table_name816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_bind_column_name843 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_bind_column_name845 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_bind_column_name847 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_bind_column_name849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where876 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where879 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body909 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body912 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body941 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF2L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body2977 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_SEMICOLON_in_dml_lookup_select_where_body2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup_statement1008 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_lookup_statement1014 = new BitSet(new long[]{0x0000000400000080L});
    public static final BitSet FOLLOW_WHERE_in_lookup_statement1017 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_lookup_statement1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement1049 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_select_statement1055 = new BitSet(new long[]{0x0000000400000080L});
    public static final BitSet FOLLOW_WHERE_in_select_statement1058 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_select_statement1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_select_statement1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPSERT_in_upsert_statement1090 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_INTO_in_upsert_statement1092 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_upsert_statement1098 = new BitSet(new long[]{0x0003000400000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1101 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCREASE_in_upsert_statement1109 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1111 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_upsert_statement1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_update_statement1143 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1149 = new BitSet(new long[]{0x0010000400000000L});
    public static final BitSet FOLLOW_SET_in_update_statement1152 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_update_statement1162 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1168 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_WHERE_in_update_statement1170 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_update_statement1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_delete_statement1200 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_FROM_in_delete_statement1202 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_delete_statement1208 = new BitSet(new long[]{0x0000000400000080L});
    public static final BitSet FOLLOW_WHERE_in_delete_statement1211 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_delete_statement1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_table_name1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ddl_column_pk1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1309 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_comment1313 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_name1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ddl_column_type1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1412 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_column_defs1417 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1423 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ddl_column_name_in_column_def1453 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ddl_column_type_in_column_def1457 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_ddl_column_pk_in_column_def1462 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_ddl_column_comment_in_column_def1469 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_set_in_stream_meta_name1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1536 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_NAME_in_stream_meta_value1540 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_name_in_stream_meta_def1569 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_stream_meta_value_in_stream_meta_def1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1626 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_stream_meta_defs1631 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1637 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_CREATE_in_create_stream_statement1664 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STREAM_in_create_stream_statement1666 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_stream_statement1670 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1680 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_column_defs_in_create_stream_statement1684 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1686 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_META_in_create_stream_statement1688 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1694 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1696 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_stream_statement1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_stream_statement1721 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STREAM_in_drop_stream_statement1723 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_stream_statement1727 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_stream_statement1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_stream_statement1752 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STREAM_in_show_stream_statement1754 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_stream_statement1758 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_stream_statement1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_streams_statement1783 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAMS_in_show_streams_statement1785 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_streams_statement1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KILL_in_kill_job_statement1810 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_kill_job_statement1812 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_kill_job_statement1816 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_kill_job_statement1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_source_meta_name1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value1888 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_NAME_in_source_meta_value1892 = new BitSet(new long[]{0x0400000880000000L});
    public static final BitSet FOLLOW_set_in_source_meta_value1894 = new BitSet(new long[]{0x0400000880000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_name_in_source_meta_def1928 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_source_meta_value_in_source_meta_def1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs1985 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_source_meta_defs1990 = new BitSet(new long[]{0x0000000000000000L,0x000000000001FC00L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs1996 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_CREATE_in_create_source_statement2023 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SOURCE_in_create_source_statement2025 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_source_statement2029 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_META_in_create_source_statement2031 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_create_source_statement2033 = new BitSet(new long[]{0x0000000000000000L,0x000000000001FC00L});
    public static final BitSet FOLLOW_ddl_source_meta_defs_in_create_source_statement2037 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_create_source_statement2039 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_source_statement2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_source_statement2064 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SOURCE_in_drop_source_statement2066 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_source_statement2070 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_source_statement2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_source_statement2095 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SOURCE_in_show_source_statement2097 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_source_statement2101 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_source_statement2103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_sources_statement2126 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCES_in_show_sources_statement2128 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_sources_statement2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_job_statement2153 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_drop_job_statement2155 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_job_statement2159 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_job_statement2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_job_statement2184 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_show_job_statement2186 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_job_statement2190 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_job_statement2192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_jobs_statement2215 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_JOBS_in_show_jobs_statement2217 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_jobs_statement2219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_cluster_statement2242 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_CLUSTER_in_show_cluster_statement2244 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_cluster_statement2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SNAPSHOT_in_snapshot_job_statement2269 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_snapshot_job_statement2271 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_snapshot_job_statement2275 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_snapshot_job_statement2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred27_TOMMY_SQL941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred36_TOMMY_SQL1152 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred36_TOMMY_SQL1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred37_TOMMY_SQL1162 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_synpred37_TOMMY_SQL1168 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_WHERE_in_synpred37_TOMMY_SQL1170 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000001FFF9L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred37_TOMMY_SQL1174 = new BitSet(new long[]{0x0000000000000002L});

}