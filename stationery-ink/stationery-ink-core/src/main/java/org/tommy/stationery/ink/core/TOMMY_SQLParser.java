// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/core/TOMMY_SQL.g 2015-04-08 14:11:54

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DELETE", "SELECT", "FROM", "WHERE", "LOOKUP", "INSERT", "UPSERT", "CREATE", "STREAM", "STREAMS", "BSTREAM", "BUCKET", "SOURCE", "SOURCES", "DROP", "SHOW", "JOB", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURLY", "RCURLY", "LBLE", "RBLE", "QUESTION", "EXCLAMATION", "SINGLE_QUOTE", "DOUBLE_QUOTE", "UNDERLINE", "SEMICOLON", "COMMA", "COMM", "COLON", "META", "AND", "OR", "PLUS", "MINUS", "MULTI", "DIV", "MOD", "ANDMARK", "EQUAL", "INCREASE", "VALUES", "INTO", "UPDATE", "SET", "CLUSTER", "JOBS", "KILL", "SNAPSHOT", "USE", "COMMIT", "NAME", "WHITESPACE", "WS", "UNICODE_LETTER", "UNICODE_DIGIT", "LETTER", "DIGIT", "'\\r'", "'\\n'", "'PARTITION_KEY'", "'STRING'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'TOPIC'", "'COMMENT'", "'CATALOG'", "'URL'", "'DRIVER'", "'ID'", "'PW'", "'VHOST'", "'PORT'", "'CLUSTER'"
    };
    public static final int EOF=-1;
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
    public static final int T__81=81;
    public static final int T__82=82;
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
    public static final int COMMIT=58;
    public static final int NAME=59;
    public static final int WHITESPACE=60;
    public static final int WS=61;
    public static final int UNICODE_LETTER=62;
    public static final int UNICODE_DIGIT=63;
    public static final int LETTER=64;
    public static final int DIGIT=65;

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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:101:1: create_statement : ( commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ ;
    public final TOMMY_SQLParser.create_statement_return create_statement() throws RecognitionException {
        TOMMY_SQLParser.create_statement_return retval = new TOMMY_SQLParser.create_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.commit_statement_return commit_statement1 = null;

        TOMMY_SQLParser.use_statement_return use_statement2 = null;

        TOMMY_SQLParser.snapshot_job_statement_return snapshot_job_statement3 = null;

        TOMMY_SQLParser.kill_job_statement_return kill_job_statement4 = null;

        TOMMY_SQLParser.set_statement_return set_statement5 = null;

        TOMMY_SQLParser.show_sources_statement_return show_sources_statement6 = null;

        TOMMY_SQLParser.show_streams_statement_return show_streams_statement7 = null;

        TOMMY_SQLParser.show_cluster_statement_return show_cluster_statement8 = null;

        TOMMY_SQLParser.show_jobs_statement_return show_jobs_statement9 = null;

        TOMMY_SQLParser.update_statement_return update_statement10 = null;

        TOMMY_SQLParser.upsert_statement_return upsert_statement11 = null;

        TOMMY_SQLParser.lookup_statement_return lookup_statement12 = null;

        TOMMY_SQLParser.select_statement_return select_statement13 = null;

        TOMMY_SQLParser.create_stream_statement_return create_stream_statement14 = null;

        TOMMY_SQLParser.create_source_statement_return create_source_statement15 = null;

        TOMMY_SQLParser.show_stream_statement_return show_stream_statement16 = null;

        TOMMY_SQLParser.show_source_statement_return show_source_statement17 = null;

        TOMMY_SQLParser.drop_stream_statement_return drop_stream_statement18 = null;

        TOMMY_SQLParser.drop_source_statement_return drop_source_statement19 = null;

        TOMMY_SQLParser.drop_job_statement_return drop_job_statement20 = null;

        TOMMY_SQLParser.show_job_statement_return show_job_statement21 = null;

        TOMMY_SQLParser.delete_statement_return delete_statement22 = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:5: ( ( commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:7: ( commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:7: ( commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=23;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:8: commit_statement
            	    {
            	    pushFollow(FOLLOW_commit_statement_in_create_statement588);
            	    commit_statement1=commit_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, commit_statement1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:25: use_statement
            	    {
            	    pushFollow(FOLLOW_use_statement_in_create_statement590);
            	    use_statement2=use_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, use_statement2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:39: snapshot_job_statement
            	    {
            	    pushFollow(FOLLOW_snapshot_job_statement_in_create_statement592);
            	    snapshot_job_statement3=snapshot_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, snapshot_job_statement3.getTree());

            	    }
            	    break;
            	case 4 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:62: kill_job_statement
            	    {
            	    pushFollow(FOLLOW_kill_job_statement_in_create_statement594);
            	    kill_job_statement4=kill_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, kill_job_statement4.getTree());

            	    }
            	    break;
            	case 5 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:81: set_statement
            	    {
            	    pushFollow(FOLLOW_set_statement_in_create_statement596);
            	    set_statement5=set_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_statement5.getTree());

            	    }
            	    break;
            	case 6 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:95: show_sources_statement
            	    {
            	    pushFollow(FOLLOW_show_sources_statement_in_create_statement598);
            	    show_sources_statement6=show_sources_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_sources_statement6.getTree());

            	    }
            	    break;
            	case 7 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:118: show_streams_statement
            	    {
            	    pushFollow(FOLLOW_show_streams_statement_in_create_statement600);
            	    show_streams_statement7=show_streams_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_streams_statement7.getTree());

            	    }
            	    break;
            	case 8 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:141: show_cluster_statement
            	    {
            	    pushFollow(FOLLOW_show_cluster_statement_in_create_statement602);
            	    show_cluster_statement8=show_cluster_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_cluster_statement8.getTree());

            	    }
            	    break;
            	case 9 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:164: show_jobs_statement
            	    {
            	    pushFollow(FOLLOW_show_jobs_statement_in_create_statement604);
            	    show_jobs_statement9=show_jobs_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_jobs_statement9.getTree());

            	    }
            	    break;
            	case 10 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:184: update_statement
            	    {
            	    pushFollow(FOLLOW_update_statement_in_create_statement606);
            	    update_statement10=update_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, update_statement10.getTree());

            	    }
            	    break;
            	case 11 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:201: upsert_statement
            	    {
            	    pushFollow(FOLLOW_upsert_statement_in_create_statement608);
            	    upsert_statement11=upsert_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, upsert_statement11.getTree());

            	    }
            	    break;
            	case 12 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:218: lookup_statement
            	    {
            	    pushFollow(FOLLOW_lookup_statement_in_create_statement610);
            	    lookup_statement12=lookup_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lookup_statement12.getTree());

            	    }
            	    break;
            	case 13 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:235: select_statement
            	    {
            	    pushFollow(FOLLOW_select_statement_in_create_statement612);
            	    select_statement13=select_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement13.getTree());

            	    }
            	    break;
            	case 14 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:252: create_stream_statement
            	    {
            	    pushFollow(FOLLOW_create_stream_statement_in_create_statement614);
            	    create_stream_statement14=create_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_stream_statement14.getTree());

            	    }
            	    break;
            	case 15 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:276: create_source_statement
            	    {
            	    pushFollow(FOLLOW_create_source_statement_in_create_statement616);
            	    create_source_statement15=create_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_source_statement15.getTree());

            	    }
            	    break;
            	case 16 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:300: show_stream_statement
            	    {
            	    pushFollow(FOLLOW_show_stream_statement_in_create_statement618);
            	    show_stream_statement16=show_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_stream_statement16.getTree());

            	    }
            	    break;
            	case 17 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:322: show_source_statement
            	    {
            	    pushFollow(FOLLOW_show_source_statement_in_create_statement620);
            	    show_source_statement17=show_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_source_statement17.getTree());

            	    }
            	    break;
            	case 18 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:344: drop_stream_statement
            	    {
            	    pushFollow(FOLLOW_drop_stream_statement_in_create_statement622);
            	    drop_stream_statement18=drop_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_stream_statement18.getTree());

            	    }
            	    break;
            	case 19 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:366: drop_source_statement
            	    {
            	    pushFollow(FOLLOW_drop_source_statement_in_create_statement624);
            	    drop_source_statement19=drop_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_source_statement19.getTree());

            	    }
            	    break;
            	case 20 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:388: drop_job_statement
            	    {
            	    pushFollow(FOLLOW_drop_job_statement_in_create_statement626);
            	    drop_job_statement20=drop_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_job_statement20.getTree());

            	    }
            	    break;
            	case 21 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:407: show_job_statement
            	    {
            	    pushFollow(FOLLOW_show_job_statement_in_create_statement628);
            	    show_job_statement21=show_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_job_statement21.getTree());

            	    }
            	    break;
            	case 22 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:426: delete_statement
            	    {
            	    pushFollow(FOLLOW_delete_statement_in_create_statement630);
            	    delete_statement22=delete_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, delete_statement22.getTree());

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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:109:1: use_name_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.use_name_def_return use_name_def() throws RecognitionException {
        TOMMY_SQLParser.use_name_def_return retval = new TOMMY_SQLParser.use_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:110:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:110:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_use_name_def664); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:113:1: use_statement : USE column= set_name_def SEMICOLON ;
    public final TOMMY_SQLParser.use_statement_return use_statement() throws RecognitionException {
        TOMMY_SQLParser.use_statement_return retval = new TOMMY_SQLParser.use_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token USE23=null;
        Token SEMICOLON24=null;
        TOMMY_SQLParser.set_name_def_return column = null;


        Object USE23_tree=null;
        Object SEMICOLON24_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:114:5: ( USE column= set_name_def SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:114:7: USE column= set_name_def SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            USE23=(Token)match(input,USE,FOLLOW_USE_in_use_statement683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USE23_tree = (Object)adaptor.create(USE23);
            adaptor.addChild(root_0, USE23_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_use_statement687);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            SEMICOLON24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_use_statement689); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON24_tree = (Object)adaptor.create(SEMICOLON24);
            adaptor.addChild(root_0, SEMICOLON24_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:127:1: set_name_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.set_name_def_return set_name_def() throws RecognitionException {
        TOMMY_SQLParser.set_name_def_return retval = new TOMMY_SQLParser.set_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:128:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:128:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_name_def721); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:131:1: set_value_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.set_value_def_return set_value_def() throws RecognitionException {
        TOMMY_SQLParser.set_value_def_return retval = new TOMMY_SQLParser.set_value_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:132:6: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:132:10: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_value_def749); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:135:1: set_statement : SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON ;
    public final TOMMY_SQLParser.set_statement_return set_statement() throws RecognitionException {
        TOMMY_SQLParser.set_statement_return retval = new TOMMY_SQLParser.set_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SET25=null;
        Token EQUAL26=null;
        Token SINGLE_QUOTE27=null;
        Token SINGLE_QUOTE28=null;
        Token SEMICOLON29=null;
        TOMMY_SQLParser.set_name_def_return column = null;

        TOMMY_SQLParser.set_value_def_return value = null;


        Object SET25_tree=null;
        Object EQUAL26_tree=null;
        Object SINGLE_QUOTE27_tree=null;
        Object SINGLE_QUOTE28_tree=null;
        Object SEMICOLON29_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:136:5: ( SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:136:7: SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SET25=(Token)match(input,SET,FOLLOW_SET_in_set_statement769); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SET25_tree = (Object)adaptor.create(SET25);
            adaptor.addChild(root_0, SET25_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_set_statement773);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            EQUAL26=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_set_statement775); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQUAL26_tree = (Object)adaptor.create(EQUAL26);
            adaptor.addChild(root_0, EQUAL26_tree);
            }
            SINGLE_QUOTE27=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement777); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE27_tree = (Object)adaptor.create(SINGLE_QUOTE27);
            adaptor.addChild(root_0, SINGLE_QUOTE27_tree);
            }
            pushFollow(FOLLOW_set_value_def_in_set_statement781);
            value=set_value_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, value.getTree());
            SINGLE_QUOTE28=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement783); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE28_tree = (Object)adaptor.create(SINGLE_QUOTE28);
            adaptor.addChild(root_0, SINGLE_QUOTE28_tree);
            }
            SEMICOLON29=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_set_statement785); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON29_tree = (Object)adaptor.create(SEMICOLON29);
            adaptor.addChild(root_0, SEMICOLON29_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:150:1: dml_table_name returns [BaseTableDef ret] : LSQUARE n= NAME COLON b= NAME RSQUARE ;
    public final TOMMY_SQLParser.dml_table_name_return dml_table_name() throws RecognitionException {
        TOMMY_SQLParser.dml_table_name_return retval = new TOMMY_SQLParser.dml_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token b=null;
        Token LSQUARE30=null;
        Token COLON31=null;
        Token RSQUARE32=null;

        Object n_tree=null;
        Object b_tree=null;
        Object LSQUARE30_tree=null;
        Object COLON31_tree=null;
        Object RSQUARE32_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:151:5: ( LSQUARE n= NAME COLON b= NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:151:9: LSQUARE n= NAME COLON b= NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            LSQUARE30=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_table_name815); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LSQUARE30_tree = (Object)adaptor.create(LSQUARE30);
            adaptor.addChild(root_0, LSQUARE30_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name819); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON31=(Token)match(input,COLON,FOLLOW_COLON_in_dml_table_name821); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON31_tree = (Object)adaptor.create(COLON31);
            adaptor.addChild(root_0, COLON31_tree);
            }
            b=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name825); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (Object)adaptor.create(b);
            adaptor.addChild(root_0, b_tree);
            }
            RSQUARE32=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_table_name827); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE32_tree = (Object)adaptor.create(RSQUARE32);
            adaptor.addChild(root_0, RSQUARE32_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:159:1: dml_bind_column_name returns [String ret] : n= LSQUARE COLON NAME RSQUARE ;
    public final TOMMY_SQLParser.dml_bind_column_name_return dml_bind_column_name() throws RecognitionException {
        TOMMY_SQLParser.dml_bind_column_name_return retval = new TOMMY_SQLParser.dml_bind_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token COLON33=null;
        Token NAME34=null;
        Token RSQUARE35=null;

        Object n_tree=null;
        Object COLON33_tree=null;
        Object NAME34_tree=null;
        Object RSQUARE35_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:160:5: (n= LSQUARE COLON NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:160:9: n= LSQUARE COLON NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_bind_column_name854); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON33=(Token)match(input,COLON,FOLLOW_COLON_in_dml_bind_column_name856); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON33_tree = (Object)adaptor.create(COLON33);
            adaptor.addChild(root_0, COLON33_tree);
            }
            NAME34=(Token)match(input,NAME,FOLLOW_NAME_in_dml_bind_column_name858); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME34_tree = (Object)adaptor.create(NAME34);
            adaptor.addChild(root_0, NAME34_tree);
            }
            RSQUARE35=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_bind_column_name860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE35_tree = (Object)adaptor.create(RSQUARE35);
            adaptor.addChild(root_0, RSQUARE35_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:164:1: dml_lookup_where returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final TOMMY_SQLParser.dml_lookup_where_return dml_lookup_where() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_where_return retval = new TOMMY_SQLParser.dml_lookup_where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME36=null;
        Token NAME37=null;

        Object n_tree=null;
        Object NAME36_tree=null;
        Object NAME37_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:165:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:165:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:165:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:165:11: NAME ( NAME )*
            {
            NAME36=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where887); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME36_tree = (Object)adaptor.create(NAME36);
            adaptor.addChild(root_0, NAME36_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:165:16: ( NAME )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:165:17: NAME
            	    {
            	    NAME37=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where890); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME37_tree = (Object)adaptor.create(NAME37);
            	    adaptor.addChild(root_0, NAME37_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:1: dml_select_body returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final TOMMY_SQLParser.dml_select_body_return dml_select_body() throws RecognitionException {
        TOMMY_SQLParser.dml_select_body_return retval = new TOMMY_SQLParser.dml_select_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME38=null;
        Token NAME39=null;

        Object n_tree=null;
        Object NAME38_tree=null;
        Object NAME39_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:169:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:169:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:169:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:169:11: NAME ( NAME )*
            {
            NAME38=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME38_tree = (Object)adaptor.create(NAME38);
            adaptor.addChild(root_0, NAME38_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:169:16: ( NAME )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:169:17: NAME
            	    {
            	    NAME39=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body923); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME39_tree = (Object)adaptor.create(NAME39);
            	    adaptor.addChild(root_0, NAME39_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:1: dml_lookup_select_where_body returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ ;
    public final TOMMY_SQLParser.dml_lookup_select_where_body_return dml_lookup_select_where_body() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_select_where_body_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:173:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:173:8: (n=~ ( '\\r' | '\\n' | ';' ) )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:173:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
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
            	    if ( (input.LA(1)>=DELETE && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=68 && input.LA(1)<=82) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:1: dml_lookup_select_where_body2 returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON ;
    public final TOMMY_SQLParser.dml_lookup_select_where_body2_return dml_lookup_select_where_body2() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_select_where_body2_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SEMICOLON40=null;

        Object n_tree=null;
        Object SEMICOLON40_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:177:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:177:8: (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:177:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
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
                case COMMIT:
                case NAME:
                case WHITESPACE:
                case WS:
                case UNICODE_LETTER:
                case UNICODE_DIGIT:
                case LETTER:
                case DIGIT:
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
                case 81:
                case 82:
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
            	    if ( (input.LA(1)>=DELETE && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=68 && input.LA(1)<=82) ) {
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

            SEMICOLON40=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21000); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON40_tree = (Object)adaptor.create(SEMICOLON40);
            adaptor.addChild(root_0, SEMICOLON40_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:1: lookup_statement : LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.lookup_statement_return lookup_statement() throws RecognitionException {
        TOMMY_SQLParser.lookup_statement_return retval = new TOMMY_SQLParser.lookup_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOOKUP41=null;
        Token WHERE42=null;
        Token SEMICOLON43=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object LOOKUP41_tree=null;
        Object WHERE42_tree=null;
        Object SEMICOLON43_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:181:5: ( LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:181:7: LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            LOOKUP41=(Token)match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup_statement1019); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOOKUP41_tree = (Object)adaptor.create(LOOKUP41);
            adaptor.addChild(root_0, LOOKUP41_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_lookup_statement1025);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:181:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:181:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE42=(Token)match(input,WHERE,FOLLOW_WHERE_in_lookup_statement1028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE42_tree = (Object)adaptor.create(WHERE42);
                    adaptor.addChild(root_0, WHERE42_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1034);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:181:96: SEMICOLON
                    {
                    SEMICOLON43=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lookup_statement1036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON43_tree = (Object)adaptor.create(SEMICOLON43);
                    adaptor.addChild(root_0, SEMICOLON43_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:193:1: select_statement : SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.select_statement_return select_statement() throws RecognitionException {
        TOMMY_SQLParser.select_statement_return retval = new TOMMY_SQLParser.select_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT44=null;
        Token WHERE45=null;
        Token SEMICOLON46=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object SELECT44_tree=null;
        Object WHERE45_tree=null;
        Object SEMICOLON46_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:194:5: ( SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:194:7: SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            SELECT44=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_statement1060); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SELECT44_tree = (Object)adaptor.create(SELECT44);
            adaptor.addChild(root_0, SELECT44_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_select_statement1066);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:194:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:194:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE45=(Token)match(input,WHERE,FOLLOW_WHERE_in_select_statement1069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE45_tree = (Object)adaptor.create(WHERE45);
                    adaptor.addChild(root_0, WHERE45_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_select_statement1075);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:194:96: SEMICOLON
                    {
                    SEMICOLON46=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_select_statement1077); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON46_tree = (Object)adaptor.create(SEMICOLON46);
                    adaptor.addChild(root_0, SEMICOLON46_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:1: upsert_statement : UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.upsert_statement_return upsert_statement() throws RecognitionException {
        TOMMY_SQLParser.upsert_statement_return retval = new TOMMY_SQLParser.upsert_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPSERT47=null;
        Token INTO48=null;
        Token VALUES49=null;
        Token INCREASE50=null;
        Token VALUES51=null;
        Token SEMICOLON52=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object UPSERT47_tree=null;
        Object INTO48_tree=null;
        Object VALUES49_tree=null;
        Object INCREASE50_tree=null;
        Object VALUES51_tree=null;
        Object SEMICOLON52_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:5: ( UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:7: UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPSERT47=(Token)match(input,UPSERT,FOLLOW_UPSERT_in_upsert_statement1101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPSERT47_tree = (Object)adaptor.create(UPSERT47);
            adaptor.addChild(root_0, UPSERT47_tree);
            }
            INTO48=(Token)match(input,INTO,FOLLOW_INTO_in_upsert_statement1103); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO48_tree = (Object)adaptor.create(INTO48);
            adaptor.addChild(root_0, INTO48_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_upsert_statement1109);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:57: VALUES body2= dml_lookup_select_where_body2
                    {
                    VALUES49=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES49_tree = (Object)adaptor.create(VALUES49);
                    adaptor.addChild(root_0, VALUES49_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1118);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:102: INCREASE VALUES body2= dml_lookup_select_where_body2
                    {
                    INCREASE50=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_upsert_statement1120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INCREASE50_tree = (Object)adaptor.create(INCREASE50);
                    adaptor.addChild(root_0, INCREASE50_tree);
                    }
                    VALUES51=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1122); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES51_tree = (Object)adaptor.create(VALUES51);
                    adaptor.addChild(root_0, VALUES51_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1128);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:156: SEMICOLON
                    {
                    SEMICOLON52=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_upsert_statement1130); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON52_tree = (Object)adaptor.create(SEMICOLON52);
                    adaptor.addChild(root_0, SEMICOLON52_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:1: update_statement : UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.update_statement_return update_statement() throws RecognitionException {
        TOMMY_SQLParser.update_statement_return retval = new TOMMY_SQLParser.update_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPDATE53=null;
        Token SET54=null;
        Token SET55=null;
        Token WHERE56=null;
        Token SEMICOLON57=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body_return body3 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body4 = null;


        Object UPDATE53_tree=null;
        Object SET54_tree=null;
        Object SET55_tree=null;
        Object WHERE56_tree=null;
        Object SEMICOLON57_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:5: ( UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:7: UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPDATE53=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_update_statement1154); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPDATE53_tree = (Object)adaptor.create(UPDATE53);
            adaptor.addChild(root_0, UPDATE53_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1160);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:52: SET body2= dml_lookup_select_where_body2
                    {
                    SET54=(Token)match(input,SET,FOLLOW_SET_in_update_statement1163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET54_tree = (Object)adaptor.create(SET54);
                    adaptor.addChild(root_0, SET54_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1169);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
                    {
                    SET55=(Token)match(input,SET,FOLLOW_SET_in_update_statement1173); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET55_tree = (Object)adaptor.create(SET55);
                    adaptor.addChild(root_0, SET55_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1179);
                    body3=dml_lookup_select_where_body();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());
                    WHERE56=(Token)match(input,WHERE,FOLLOW_WHERE_in_update_statement1181); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE56_tree = (Object)adaptor.create(WHERE56);
                    adaptor.addChild(root_0, WHERE56_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1185);
                    body4=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body4.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:179: SEMICOLON
                    {
                    SEMICOLON57=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_update_statement1187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON57_tree = (Object)adaptor.create(SEMICOLON57);
                    adaptor.addChild(root_0, SEMICOLON57_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:237:1: delete_statement : DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.delete_statement_return delete_statement() throws RecognitionException {
        TOMMY_SQLParser.delete_statement_return retval = new TOMMY_SQLParser.delete_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DELETE58=null;
        Token FROM59=null;
        Token WHERE60=null;
        Token SEMICOLON61=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object DELETE58_tree=null;
        Object FROM59_tree=null;
        Object WHERE60_tree=null;
        Object SEMICOLON61_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:5: ( DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:7: DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            DELETE58=(Token)match(input,DELETE,FOLLOW_DELETE_in_delete_statement1211); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DELETE58_tree = (Object)adaptor.create(DELETE58);
            adaptor.addChild(root_0, DELETE58_tree);
            }
            FROM59=(Token)match(input,FROM,FOLLOW_FROM_in_delete_statement1213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FROM59_tree = (Object)adaptor.create(FROM59);
            adaptor.addChild(root_0, FROM59_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_delete_statement1219);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:56: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:57: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE60=(Token)match(input,WHERE,FOLLOW_WHERE_in_delete_statement1222); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE60_tree = (Object)adaptor.create(WHERE60);
                    adaptor.addChild(root_0, WHERE60_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1228);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:101: SEMICOLON
                    {
                    SEMICOLON61=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_delete_statement1230); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON61_tree = (Object)adaptor.create(SEMICOLON61);
                    adaptor.addChild(root_0, SEMICOLON61_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:251:1: ddl_table_name returns [BaseTableDef ret] : n= NAME ;
    public final TOMMY_SQLParser.ddl_table_name_return ddl_table_name() throws RecognitionException {
        TOMMY_SQLParser.ddl_table_name_return retval = new TOMMY_SQLParser.ddl_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:252:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:252:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_table_name1262); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:259:1: ddl_column_pk returns [boolean ret] : n= 'PARTITION_KEY' ;
    public final TOMMY_SQLParser.ddl_column_pk_return ddl_column_pk() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_pk_return retval = new TOMMY_SQLParser.ddl_column_pk_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:260:5: (n= 'PARTITION_KEY' )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:261:9: n= 'PARTITION_KEY'
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,68,FOLLOW_68_in_ddl_column_pk1295); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:264:1: ddl_column_comment returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final TOMMY_SQLParser.ddl_column_comment_return ddl_column_comment() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_comment_return retval = new TOMMY_SQLParser.ddl_column_comment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE62=null;
        Token SINGLE_QUOTE63=null;

        Object n_tree=null;
        Object SINGLE_QUOTE62_tree=null;
        Object SINGLE_QUOTE63_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:265:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:265:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE62=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE62_tree = (Object)adaptor.create(SINGLE_QUOTE62);
            adaptor.addChild(root_0, SINGLE_QUOTE62_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_comment1324); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE63=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE63_tree = (Object)adaptor.create(SINGLE_QUOTE63);
            adaptor.addChild(root_0, SINGLE_QUOTE63_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:268:1: ddl_column_name returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.ddl_column_name_return ddl_column_name() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_name_return retval = new TOMMY_SQLParser.ddl_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:269:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:269:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_name1353); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:272:1: ddl_column_type returns [ColumnDataTypeEnum ret] : n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) ;
    public final TOMMY_SQLParser.ddl_column_type_return ddl_column_type() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_type_return retval = new TOMMY_SQLParser.ddl_column_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:273:5: (n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:273:9: n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=69 && input.LA(1)<=72) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:277:1: ddl_column_defs returns [List<BaseColumnDef> ret] : v= column_def ( COMMA v= column_def )* ;
    public final TOMMY_SQLParser.ddl_column_defs_return ddl_column_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_defs_return retval = new TOMMY_SQLParser.ddl_column_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA64=null;
        TOMMY_SQLParser.column_def_return v = null;


        Object COMMA64_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:278:5: (v= column_def ( COMMA v= column_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:279:9: v= column_def ( COMMA v= column_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_column_def_in_ddl_column_defs1423);
            v=column_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                          retval.ret = new ArrayList<BaseColumnDef>();
                          retval.ret.add(v.ret);
                      
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:282:11: ( COMMA v= column_def )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:282:12: COMMA v= column_def
            	    {
            	    COMMA64=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_column_defs1428); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA64_tree = (Object)adaptor.create(COMMA64);
            	    adaptor.addChild(root_0, COMMA64_tree);
            	    }
            	    pushFollow(FOLLOW_column_def_in_ddl_column_defs1434);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:1: column_def returns [BaseColumnDef ret] : c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* ;
    public final TOMMY_SQLParser.column_def_return column_def() throws RecognitionException {
        TOMMY_SQLParser.column_def_return retval = new TOMMY_SQLParser.column_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.ddl_column_name_return c = null;

        TOMMY_SQLParser.ddl_column_type_return dt = null;

        TOMMY_SQLParser.ddl_column_pk_return pk = null;

        TOMMY_SQLParser.ddl_column_comment_return cmt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:286:5: (c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:286:9: c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ddl_column_name_in_column_def1464);
            c=ddl_column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_ddl_column_type_in_column_def1468);
            dt=ddl_column_type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:286:46: (pk= ddl_column_pk )*
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case 68:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:286:47: pk= ddl_column_pk
            	    {
            	    pushFollow(FOLLOW_ddl_column_pk_in_column_def1473);
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

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:286:66: (cmt= ddl_column_comment )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:286:67: cmt= ddl_column_comment
            	    {
            	    pushFollow(FOLLOW_ddl_column_comment_in_column_def1480);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:293:1: stream_meta_name returns [String ret] : n= ( 'TOPIC' | 'COMMENT' ) ;
    public final TOMMY_SQLParser.stream_meta_name_return stream_meta_name() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_name_return retval = new TOMMY_SQLParser.stream_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:294:5: (n= ( 'TOPIC' | 'COMMENT' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:294:9: n= ( 'TOPIC' | 'COMMENT' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=73 && input.LA(1)<=74) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:297:1: stream_meta_value returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final TOMMY_SQLParser.stream_meta_value_return stream_meta_value() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_value_return retval = new TOMMY_SQLParser.stream_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE65=null;
        Token SINGLE_QUOTE66=null;

        Object n_tree=null;
        Object SINGLE_QUOTE65_tree=null;
        Object SINGLE_QUOTE66_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:298:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:298:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE65=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1547); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE65_tree = (Object)adaptor.create(SINGLE_QUOTE65);
            adaptor.addChild(root_0, SINGLE_QUOTE65_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_stream_meta_value1551); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE66=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1553); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE66_tree = (Object)adaptor.create(SINGLE_QUOTE66);
            adaptor.addChild(root_0, SINGLE_QUOTE66_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:1: stream_meta_def returns [BaseMetaDef ret] : c= stream_meta_name dt= stream_meta_value ;
    public final TOMMY_SQLParser.stream_meta_def_return stream_meta_def() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_def_return retval = new TOMMY_SQLParser.stream_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.stream_meta_name_return c = null;

        TOMMY_SQLParser.stream_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:302:5: (c= stream_meta_name dt= stream_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:302:9: c= stream_meta_name dt= stream_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_name_in_stream_meta_def1580);
            c=stream_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_stream_meta_value_in_stream_meta_def1584);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:306:1: ddl_stream_meta_defs returns [List<BaseMetaDef> ret] : v= stream_meta_def ( COMMA v= stream_meta_def )* ;
    public final TOMMY_SQLParser.ddl_stream_meta_defs_return ddl_stream_meta_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_stream_meta_defs_return retval = new TOMMY_SQLParser.ddl_stream_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA67=null;
        TOMMY_SQLParser.stream_meta_def_return v = null;


        Object COMMA67_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:307:10: (v= stream_meta_def ( COMMA v= stream_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:308:14: v= stream_meta_def ( COMMA v= stream_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1637);
            v=stream_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);
                           
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:311:16: ( COMMA v= stream_meta_def )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:311:17: COMMA v= stream_meta_def
            	    {
            	    COMMA67=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_stream_meta_defs1642); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA67_tree = (Object)adaptor.create(COMMA67);
            	    adaptor.addChild(root_0, COMMA67_tree);
            	    }
            	    pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1648);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:314:1: create_stream_statement : CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON ;
    public final TOMMY_SQLParser.create_stream_statement_return create_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.create_stream_statement_return retval = new TOMMY_SQLParser.create_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE68=null;
        Token STREAM69=null;
        Token LPAREN70=null;
        Token RPAREN71=null;
        Token META72=null;
        Token LPAREN73=null;
        Token RPAREN74=null;
        Token SEMICOLON75=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;

        TOMMY_SQLParser.ddl_column_defs_return columns = null;

        TOMMY_SQLParser.ddl_stream_meta_defs_return metas = null;


        Object CREATE68_tree=null;
        Object STREAM69_tree=null;
        Object LPAREN70_tree=null;
        Object RPAREN71_tree=null;
        Object META72_tree=null;
        Object LPAREN73_tree=null;
        Object RPAREN74_tree=null;
        Object SEMICOLON75_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:315:5: ( CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:315:7: CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE68=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_stream_statement1675); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE68_tree = (Object)adaptor.create(CREATE68);
            adaptor.addChild(root_0, CREATE68_tree);
            }
            STREAM69=(Token)match(input,STREAM,FOLLOW_STREAM_in_create_stream_statement1677); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM69_tree = (Object)adaptor.create(STREAM69);
            adaptor.addChild(root_0, STREAM69_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_stream_statement1681);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            LPAREN70=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1691); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN70_tree = (Object)adaptor.create(LPAREN70);
            adaptor.addChild(root_0, LPAREN70_tree);
            }
            pushFollow(FOLLOW_ddl_column_defs_in_create_stream_statement1695);
            columns=ddl_column_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, columns.getTree());
            RPAREN71=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1697); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN71_tree = (Object)adaptor.create(RPAREN71);
            adaptor.addChild(root_0, RPAREN71_tree);
            }
            META72=(Token)match(input,META,FOLLOW_META_in_create_stream_statement1699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META72_tree = (Object)adaptor.create(META72);
            adaptor.addChild(root_0, META72_tree);
            }
            LPAREN73=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1701); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN73_tree = (Object)adaptor.create(LPAREN73);
            adaptor.addChild(root_0, LPAREN73_tree);
            }
            pushFollow(FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1705);
            metas=ddl_stream_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN74=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1707); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN74_tree = (Object)adaptor.create(RPAREN74);
            adaptor.addChild(root_0, RPAREN74_tree);
            }
            SEMICOLON75=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_stream_statement1709); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON75_tree = (Object)adaptor.create(SEMICOLON75);
            adaptor.addChild(root_0, SEMICOLON75_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:329:1: drop_stream_statement : DROP STREAM table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_stream_statement_return drop_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_stream_statement_return retval = new TOMMY_SQLParser.drop_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP76=null;
        Token STREAM77=null;
        Token SEMICOLON78=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP76_tree=null;
        Object STREAM77_tree=null;
        Object SEMICOLON78_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:330:5: ( DROP STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:330:7: DROP STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP76=(Token)match(input,DROP,FOLLOW_DROP_in_drop_stream_statement1732); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP76_tree = (Object)adaptor.create(DROP76);
            adaptor.addChild(root_0, DROP76_tree);
            }
            STREAM77=(Token)match(input,STREAM,FOLLOW_STREAM_in_drop_stream_statement1734); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM77_tree = (Object)adaptor.create(STREAM77);
            adaptor.addChild(root_0, STREAM77_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_stream_statement1738);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON78=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_stream_statement1740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON78_tree = (Object)adaptor.create(SEMICOLON78);
            adaptor.addChild(root_0, SEMICOLON78_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:341:1: show_stream_statement : SHOW STREAM table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_stream_statement_return show_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.show_stream_statement_return retval = new TOMMY_SQLParser.show_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW79=null;
        Token STREAM80=null;
        Token SEMICOLON81=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW79_tree=null;
        Object STREAM80_tree=null;
        Object SEMICOLON81_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:342:5: ( SHOW STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:342:7: SHOW STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW79=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_stream_statement1763); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW79_tree = (Object)adaptor.create(SHOW79);
            adaptor.addChild(root_0, SHOW79_tree);
            }
            STREAM80=(Token)match(input,STREAM,FOLLOW_STREAM_in_show_stream_statement1765); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM80_tree = (Object)adaptor.create(STREAM80);
            adaptor.addChild(root_0, STREAM80_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_stream_statement1769);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON81=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_stream_statement1771); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON81_tree = (Object)adaptor.create(SEMICOLON81);
            adaptor.addChild(root_0, SEMICOLON81_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:353:1: show_streams_statement : SHOW STREAMS SEMICOLON ;
    public final TOMMY_SQLParser.show_streams_statement_return show_streams_statement() throws RecognitionException {
        TOMMY_SQLParser.show_streams_statement_return retval = new TOMMY_SQLParser.show_streams_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW82=null;
        Token STREAMS83=null;
        Token SEMICOLON84=null;

        Object SHOW82_tree=null;
        Object STREAMS83_tree=null;
        Object SEMICOLON84_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:354:5: ( SHOW STREAMS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:354:7: SHOW STREAMS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW82=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_streams_statement1794); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW82_tree = (Object)adaptor.create(SHOW82);
            adaptor.addChild(root_0, SHOW82_tree);
            }
            STREAMS83=(Token)match(input,STREAMS,FOLLOW_STREAMS_in_show_streams_statement1796); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAMS83_tree = (Object)adaptor.create(STREAMS83);
            adaptor.addChild(root_0, STREAMS83_tree);
            }
            SEMICOLON84=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_streams_statement1798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON84_tree = (Object)adaptor.create(SEMICOLON84);
            adaptor.addChild(root_0, SEMICOLON84_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:364:1: kill_job_statement : KILL JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.kill_job_statement_return kill_job_statement() throws RecognitionException {
        TOMMY_SQLParser.kill_job_statement_return retval = new TOMMY_SQLParser.kill_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KILL85=null;
        Token JOB86=null;
        Token SEMICOLON87=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object KILL85_tree=null;
        Object JOB86_tree=null;
        Object SEMICOLON87_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:365:5: ( KILL JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:365:7: KILL JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            KILL85=(Token)match(input,KILL,FOLLOW_KILL_in_kill_job_statement1821); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KILL85_tree = (Object)adaptor.create(KILL85);
            adaptor.addChild(root_0, KILL85_tree);
            }
            JOB86=(Token)match(input,JOB,FOLLOW_JOB_in_kill_job_statement1823); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB86_tree = (Object)adaptor.create(JOB86);
            adaptor.addChild(root_0, JOB86_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_kill_job_statement1827);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON87=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_kill_job_statement1829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON87_tree = (Object)adaptor.create(SEMICOLON87);
            adaptor.addChild(root_0, SEMICOLON87_tree);
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

    public static class commit_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commit_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:376:1: commit_statement : COMMIT SEMICOLON ;
    public final TOMMY_SQLParser.commit_statement_return commit_statement() throws RecognitionException {
        TOMMY_SQLParser.commit_statement_return retval = new TOMMY_SQLParser.commit_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMIT88=null;
        Token SEMICOLON89=null;

        Object COMMIT88_tree=null;
        Object SEMICOLON89_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:377:5: ( COMMIT SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:377:7: COMMIT SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            COMMIT88=(Token)match(input,COMMIT,FOLLOW_COMMIT_in_commit_statement1852); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COMMIT88_tree = (Object)adaptor.create(COMMIT88);
            adaptor.addChild(root_0, COMMIT88_tree);
            }
            SEMICOLON89=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_commit_statement1854); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON89_tree = (Object)adaptor.create(SEMICOLON89);
            adaptor.addChild(root_0, SEMICOLON89_tree);
            }
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
    // $ANTLR end "commit_statement"

    public static class source_meta_name_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "source_meta_name"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:382:1: source_meta_name returns [String ret] : n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' ) ;
    public final TOMMY_SQLParser.source_meta_name_return source_meta_name() throws RecognitionException {
        TOMMY_SQLParser.source_meta_name_return retval = new TOMMY_SQLParser.source_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:383:5: (n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:383:9: n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( input.LA(1)==73||(input.LA(1)>=75 && input.LA(1)<=82) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:386:1: source_meta_value returns [String ret] : SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE ;
    public final TOMMY_SQLParser.source_meta_value_return source_meta_value() throws RecognitionException {
        TOMMY_SQLParser.source_meta_value_return retval = new TOMMY_SQLParser.source_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE90=null;
        Token set91=null;
        Token SINGLE_QUOTE92=null;

        Object n_tree=null;
        Object SINGLE_QUOTE90_tree=null;
        Object set91_tree=null;
        Object SINGLE_QUOTE92_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:387:5: ( SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:387:9: SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE90=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value1924); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE90_tree = (Object)adaptor.create(SINGLE_QUOTE90);
            adaptor.addChild(root_0, SINGLE_QUOTE90_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_source_meta_value1928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:387:29: ( NAME | COMMA )*
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
            	    set91=(Token)input.LT(1);
            	    if ( input.LA(1)==COMMA||input.LA(1)==NAME ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set91));
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

            SINGLE_QUOTE92=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value1937); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE92_tree = (Object)adaptor.create(SINGLE_QUOTE92);
            adaptor.addChild(root_0, SINGLE_QUOTE92_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:390:1: source_meta_def returns [BaseMetaDef ret] : c= source_meta_name dt= source_meta_value ;
    public final TOMMY_SQLParser.source_meta_def_return source_meta_def() throws RecognitionException {
        TOMMY_SQLParser.source_meta_def_return retval = new TOMMY_SQLParser.source_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.source_meta_name_return c = null;

        TOMMY_SQLParser.source_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:391:5: (c= source_meta_name dt= source_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:391:9: c= source_meta_name dt= source_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_name_in_source_meta_def1964);
            c=source_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_source_meta_value_in_source_meta_def1968);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:395:1: ddl_source_meta_defs returns [List<BaseMetaDef> ret] : v= source_meta_def ( COMMA v= source_meta_def )* ;
    public final TOMMY_SQLParser.ddl_source_meta_defs_return ddl_source_meta_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_source_meta_defs_return retval = new TOMMY_SQLParser.ddl_source_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA93=null;
        TOMMY_SQLParser.source_meta_def_return v = null;


        Object COMMA93_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:396:10: (v= source_meta_def ( COMMA v= source_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:397:14: v= source_meta_def ( COMMA v= source_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2021);
            v=source_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);
                           
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:400:16: ( COMMA v= source_meta_def )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:400:17: COMMA v= source_meta_def
            	    {
            	    COMMA93=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_source_meta_defs2026); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA93_tree = (Object)adaptor.create(COMMA93);
            	    adaptor.addChild(root_0, COMMA93_tree);
            	    }
            	    pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2032);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:403:1: create_source_statement : CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON ;
    public final TOMMY_SQLParser.create_source_statement_return create_source_statement() throws RecognitionException {
        TOMMY_SQLParser.create_source_statement_return retval = new TOMMY_SQLParser.create_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE94=null;
        Token SOURCE95=null;
        Token META96=null;
        Token LPAREN97=null;
        Token RPAREN98=null;
        Token SEMICOLON99=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;

        TOMMY_SQLParser.ddl_source_meta_defs_return metas = null;


        Object CREATE94_tree=null;
        Object SOURCE95_tree=null;
        Object META96_tree=null;
        Object LPAREN97_tree=null;
        Object RPAREN98_tree=null;
        Object SEMICOLON99_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:404:5: ( CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:404:7: CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE94=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_source_statement2059); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE94_tree = (Object)adaptor.create(CREATE94);
            adaptor.addChild(root_0, CREATE94_tree);
            }
            SOURCE95=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_create_source_statement2061); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE95_tree = (Object)adaptor.create(SOURCE95);
            adaptor.addChild(root_0, SOURCE95_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_source_statement2065);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            META96=(Token)match(input,META,FOLLOW_META_in_create_source_statement2067); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META96_tree = (Object)adaptor.create(META96);
            adaptor.addChild(root_0, META96_tree);
            }
            LPAREN97=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_source_statement2069); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN97_tree = (Object)adaptor.create(LPAREN97);
            adaptor.addChild(root_0, LPAREN97_tree);
            }
            pushFollow(FOLLOW_ddl_source_meta_defs_in_create_source_statement2073);
            metas=ddl_source_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN98=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_source_statement2075); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN98_tree = (Object)adaptor.create(RPAREN98);
            adaptor.addChild(root_0, RPAREN98_tree);
            }
            SEMICOLON99=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_source_statement2077); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON99_tree = (Object)adaptor.create(SEMICOLON99);
            adaptor.addChild(root_0, SEMICOLON99_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:417:1: drop_source_statement : DROP SOURCE table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_source_statement_return drop_source_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_source_statement_return retval = new TOMMY_SQLParser.drop_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP100=null;
        Token SOURCE101=null;
        Token SEMICOLON102=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP100_tree=null;
        Object SOURCE101_tree=null;
        Object SEMICOLON102_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:418:5: ( DROP SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:418:7: DROP SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP100=(Token)match(input,DROP,FOLLOW_DROP_in_drop_source_statement2100); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP100_tree = (Object)adaptor.create(DROP100);
            adaptor.addChild(root_0, DROP100_tree);
            }
            SOURCE101=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_drop_source_statement2102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE101_tree = (Object)adaptor.create(SOURCE101);
            adaptor.addChild(root_0, SOURCE101_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_source_statement2106);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON102=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_source_statement2108); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON102_tree = (Object)adaptor.create(SEMICOLON102);
            adaptor.addChild(root_0, SEMICOLON102_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:429:1: show_source_statement : SHOW SOURCE table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_source_statement_return show_source_statement() throws RecognitionException {
        TOMMY_SQLParser.show_source_statement_return retval = new TOMMY_SQLParser.show_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW103=null;
        Token SOURCE104=null;
        Token SEMICOLON105=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW103_tree=null;
        Object SOURCE104_tree=null;
        Object SEMICOLON105_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:430:5: ( SHOW SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:430:7: SHOW SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW103=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_source_statement2131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW103_tree = (Object)adaptor.create(SHOW103);
            adaptor.addChild(root_0, SHOW103_tree);
            }
            SOURCE104=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_show_source_statement2133); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE104_tree = (Object)adaptor.create(SOURCE104);
            adaptor.addChild(root_0, SOURCE104_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_source_statement2137);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON105=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_source_statement2139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON105_tree = (Object)adaptor.create(SEMICOLON105);
            adaptor.addChild(root_0, SEMICOLON105_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:441:1: show_sources_statement : SHOW SOURCES SEMICOLON ;
    public final TOMMY_SQLParser.show_sources_statement_return show_sources_statement() throws RecognitionException {
        TOMMY_SQLParser.show_sources_statement_return retval = new TOMMY_SQLParser.show_sources_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW106=null;
        Token SOURCES107=null;
        Token SEMICOLON108=null;

        Object SHOW106_tree=null;
        Object SOURCES107_tree=null;
        Object SEMICOLON108_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:442:5: ( SHOW SOURCES SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:442:7: SHOW SOURCES SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW106=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_sources_statement2162); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW106_tree = (Object)adaptor.create(SHOW106);
            adaptor.addChild(root_0, SHOW106_tree);
            }
            SOURCES107=(Token)match(input,SOURCES,FOLLOW_SOURCES_in_show_sources_statement2164); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCES107_tree = (Object)adaptor.create(SOURCES107);
            adaptor.addChild(root_0, SOURCES107_tree);
            }
            SEMICOLON108=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_sources_statement2166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON108_tree = (Object)adaptor.create(SEMICOLON108);
            adaptor.addChild(root_0, SEMICOLON108_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:452:1: drop_job_statement : DROP JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_job_statement_return drop_job_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_job_statement_return retval = new TOMMY_SQLParser.drop_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP109=null;
        Token JOB110=null;
        Token SEMICOLON111=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP109_tree=null;
        Object JOB110_tree=null;
        Object SEMICOLON111_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:453:5: ( DROP JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:453:7: DROP JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP109=(Token)match(input,DROP,FOLLOW_DROP_in_drop_job_statement2189); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP109_tree = (Object)adaptor.create(DROP109);
            adaptor.addChild(root_0, DROP109_tree);
            }
            JOB110=(Token)match(input,JOB,FOLLOW_JOB_in_drop_job_statement2191); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB110_tree = (Object)adaptor.create(JOB110);
            adaptor.addChild(root_0, JOB110_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_job_statement2195);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON111=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_job_statement2197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON111_tree = (Object)adaptor.create(SEMICOLON111);
            adaptor.addChild(root_0, SEMICOLON111_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:464:1: show_job_statement : SHOW JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_job_statement_return show_job_statement() throws RecognitionException {
        TOMMY_SQLParser.show_job_statement_return retval = new TOMMY_SQLParser.show_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW112=null;
        Token JOB113=null;
        Token SEMICOLON114=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW112_tree=null;
        Object JOB113_tree=null;
        Object SEMICOLON114_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:465:5: ( SHOW JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:465:7: SHOW JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW112=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_job_statement2220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW112_tree = (Object)adaptor.create(SHOW112);
            adaptor.addChild(root_0, SHOW112_tree);
            }
            JOB113=(Token)match(input,JOB,FOLLOW_JOB_in_show_job_statement2222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB113_tree = (Object)adaptor.create(JOB113);
            adaptor.addChild(root_0, JOB113_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_job_statement2226);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON114=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_job_statement2228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON114_tree = (Object)adaptor.create(SEMICOLON114);
            adaptor.addChild(root_0, SEMICOLON114_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:476:1: show_jobs_statement : SHOW JOBS SEMICOLON ;
    public final TOMMY_SQLParser.show_jobs_statement_return show_jobs_statement() throws RecognitionException {
        TOMMY_SQLParser.show_jobs_statement_return retval = new TOMMY_SQLParser.show_jobs_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW115=null;
        Token JOBS116=null;
        Token SEMICOLON117=null;

        Object SHOW115_tree=null;
        Object JOBS116_tree=null;
        Object SEMICOLON117_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:477:5: ( SHOW JOBS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:477:7: SHOW JOBS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW115=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_jobs_statement2251); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW115_tree = (Object)adaptor.create(SHOW115);
            adaptor.addChild(root_0, SHOW115_tree);
            }
            JOBS116=(Token)match(input,JOBS,FOLLOW_JOBS_in_show_jobs_statement2253); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOBS116_tree = (Object)adaptor.create(JOBS116);
            adaptor.addChild(root_0, JOBS116_tree);
            }
            SEMICOLON117=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_jobs_statement2255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON117_tree = (Object)adaptor.create(SEMICOLON117);
            adaptor.addChild(root_0, SEMICOLON117_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:487:1: show_cluster_statement : SHOW CLUSTER SEMICOLON ;
    public final TOMMY_SQLParser.show_cluster_statement_return show_cluster_statement() throws RecognitionException {
        TOMMY_SQLParser.show_cluster_statement_return retval = new TOMMY_SQLParser.show_cluster_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW118=null;
        Token CLUSTER119=null;
        Token SEMICOLON120=null;

        Object SHOW118_tree=null;
        Object CLUSTER119_tree=null;
        Object SEMICOLON120_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:488:5: ( SHOW CLUSTER SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:488:7: SHOW CLUSTER SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW118=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_cluster_statement2278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW118_tree = (Object)adaptor.create(SHOW118);
            adaptor.addChild(root_0, SHOW118_tree);
            }
            CLUSTER119=(Token)match(input,CLUSTER,FOLLOW_CLUSTER_in_show_cluster_statement2280); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CLUSTER119_tree = (Object)adaptor.create(CLUSTER119);
            adaptor.addChild(root_0, CLUSTER119_tree);
            }
            SEMICOLON120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_cluster_statement2282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON120_tree = (Object)adaptor.create(SEMICOLON120);
            adaptor.addChild(root_0, SEMICOLON120_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:498:1: snapshot_job_statement : SNAPSHOT JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.snapshot_job_statement_return snapshot_job_statement() throws RecognitionException {
        TOMMY_SQLParser.snapshot_job_statement_return retval = new TOMMY_SQLParser.snapshot_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SNAPSHOT121=null;
        Token JOB122=null;
        Token SEMICOLON123=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SNAPSHOT121_tree=null;
        Object JOB122_tree=null;
        Object SEMICOLON123_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:499:5: ( SNAPSHOT JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:499:7: SNAPSHOT JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SNAPSHOT121=(Token)match(input,SNAPSHOT,FOLLOW_SNAPSHOT_in_snapshot_job_statement2305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SNAPSHOT121_tree = (Object)adaptor.create(SNAPSHOT121);
            adaptor.addChild(root_0, SNAPSHOT121_tree);
            }
            JOB122=(Token)match(input,JOB,FOLLOW_JOB_in_snapshot_job_statement2307); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB122_tree = (Object)adaptor.create(JOB122);
            adaptor.addChild(root_0, JOB122_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_snapshot_job_statement2311);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON123=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_snapshot_job_statement2313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON123_tree = (Object)adaptor.create(SEMICOLON123);
            adaptor.addChild(root_0, SEMICOLON123_tree);
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

    // $ANTLR start synpred28_TOMMY_SQL
    public final void synpred28_TOMMY_SQL_fragment() throws RecognitionException {   
        Token n=null;

        // org/tommy/stationery/ink/core/TOMMY_SQL.g:173:9: (n=~ ( '\\r' | '\\n' | ';' ) )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:173:9: n=~ ( '\\r' | '\\n' | ';' )
        {
        n=(Token)input.LT(1);
        if ( (input.LA(1)>=DELETE && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=68 && input.LA(1)<=82) ) {
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
    // $ANTLR end synpred28_TOMMY_SQL

    // $ANTLR start synpred37_TOMMY_SQL
    public final void synpred37_TOMMY_SQL_fragment() throws RecognitionException {   
        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:52: ( SET body2= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:52: SET body2= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred37_TOMMY_SQL1163); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred37_TOMMY_SQL1169);
        body2=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_TOMMY_SQL

    // $ANTLR start synpred38_TOMMY_SQL
    public final void synpred38_TOMMY_SQL_fragment() throws RecognitionException {   
        TOMMY_SQLParser.dml_lookup_select_where_body_return body3 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body4 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:96: ( SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred38_TOMMY_SQL1173); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body_in_synpred38_TOMMY_SQL1179);
        body3=dml_lookup_select_where_body();

        state._fsp--;
        if (state.failed) return ;
        match(input,WHERE,FOLLOW_WHERE_in_synpred38_TOMMY_SQL1181); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred38_TOMMY_SQL1185);
        body4=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_TOMMY_SQL

    // Delegated rules

    public final boolean synpred38_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_TOMMY_SQL_fragment(); // can never throw exception
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA1_eotS =
        "\33\uffff";
    static final String DFA1_eofS =
        "\1\1\32\uffff";
    static final String DFA1_minS =
        "\1\4\6\uffff\1\14\4\uffff\2\14\15\uffff";
    static final String DFA1_maxS =
        "\1\72\6\uffff\1\66\4\uffff\1\20\1\24\15\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\27\1\1\1\2\1\3\1\4\1\5\1\uffff\1\12\1\13\1\14\1\15\2"+
        "\uffff\1\26\1\6\1\7\1\10\1\11\1\20\1\21\1\25\1\16\1\17\1\22\1\23"+
        "\1\24";
    static final String DFA1_specialS =
        "\33\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\16\1\13\2\uffff\1\12\1\uffff\1\11\1\14\6\uffff\1\15\1\7\37"+
            "\uffff\1\10\1\6\2\uffff\1\5\1\4\1\3\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\23\1\20\2\uffff\1\24\1\17\2\uffff\1\25\40\uffff\1\21\1\22",
            "",
            "",
            "",
            "",
            "\1\26\3\uffff\1\27",
            "\1\30\3\uffff\1\31\3\uffff\1\32",
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
            return "()+ loopback of 102:7: ( commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+";
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
        "\2\122\1\uffff\2\122\1\0\1\uffff\1\0\5\122\1\0\4\122\2\0\5\122\1"+
        "\0\4\122\1\0\1\122\1\0\3\122\1\0\1\122\1\0\10\122\1\0\1\122\1\0"+
        "\4\122\1\0\4\122\1\0\1\122\2\0\1\122\1\0\3\122\3\0\5\122\1\0\5\122"+
        "\1\0\1\122\1\0\1\122\1\0\4\122\4\0\5\122\3\0\1\122\2\0";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\143\uffff";
    static final String DFA4_specialS =
        "\5\uffff\1\15\1\uffff\1\6\5\uffff\1\17\4\uffff\1\40\1\7\5\uffff"+
        "\1\22\4\uffff\1\13\1\uffff\1\34\3\uffff\1\23\1\uffff\1\2\10\uffff"+
        "\1\30\1\uffff\1\36\4\uffff\1\10\4\uffff\1\24\1\uffff\1\20\1\37\1"+
        "\uffff\1\12\3\uffff\1\5\1\0\1\1\5\uffff\1\14\5\uffff\1\27\1\uffff"+
        "\1\33\1\uffff\1\35\4\uffff\1\25\1\16\1\21\1\31\5\uffff\1\3\1\4\1"+
        "\32\1\uffff\1\11\1\26}>";
    static final String[] DFA4_transitionS = {
            "\3\6\1\1\32\6\1\2\15\6\1\4\1\3\2\6\1\5\15\6\2\uffff\17\6",
            "\3\13\1\7\32\13\1\6\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
            "\17\13",
            "",
            "\3\20\1\14\32\20\1\6\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
            "\17\20",
            "\55\6\1\21\20\6\2\uffff\17\6",
            "\1\uffff",
            "",
            "\1\uffff",
            "\3\27\1\23\32\27\1\22\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
            "\17\27",
            "\3\13\1\7\32\13\1\22\15\13\1\11\1\30\2\13\1\12\15\13\2\uffff"+
            "\17\13",
            "\3\35\1\31\32\35\1\22\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
            "\17\35",
            "\3\13\1\7\32\13\1\22\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
            "\17\13",
            "\3\43\1\37\32\43\1\36\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
            "\17\43",
            "\1\uffff",
            "\3\20\1\14\32\20\1\36\15\20\1\16\1\44\2\20\1\17\15\20\2\uffff"+
            "\17\20",
            "\3\51\1\45\32\51\1\36\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
            "\17\51",
            "\3\20\1\14\32\20\1\36\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
            "\17\20",
            "\3\56\1\52\32\56\1\6\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\17\56",
            "\1\uffff",
            "\1\uffff",
            "\3\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
            "\17\27",
            "\3\27\1\23\32\27\1\57\15\27\1\25\1\60\2\27\1\26\15\27\2\uffff"+
            "\17\27",
            "\3\65\1\61\32\65\1\57\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\17\65",
            "\3\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
            "\17\27",
            "\3\72\1\66\32\72\1\22\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\17\72",
            "\1\uffff",
            "\3\65\1\61\32\65\1\73\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\17\65",
            "\3\35\1\31\32\35\1\73\15\35\1\33\1\74\2\35\1\34\15\35\2\uffff"+
            "\17\35",
            "\3\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
            "\17\35",
            "\3\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
            "\17\35",
            "\1\uffff",
            "\3\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
            "\17\43",
            "\1\uffff",
            "\3\43\1\37\32\43\1\75\15\43\1\41\1\76\2\43\1\42\15\43\2\uffff"+
            "\17\43",
            "\3\103\1\77\32\103\1\75\15\103\1\101\1\100\2\103\1\102\15\103"+
            "\2\uffff\17\103",
            "\3\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
            "\17\43",
            "\1\uffff",
            "\3\103\1\77\32\103\1\104\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\17\103",
            "\1\uffff",
            "\3\51\1\45\32\51\1\104\15\51\1\47\1\105\2\51\1\50\15\51\2\uffff"+
            "\17\51",
            "\3\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
            "\17\51",
            "\3\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
            "\17\51",
            "\3\113\1\107\32\113\1\106\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\17\113",
            "\3\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\17\56",
            "\3\56\1\52\32\56\1\106\15\56\1\54\1\114\2\56\1\55\15\56\2\uffff"+
            "\17\56",
            "\3\121\1\115\32\121\1\106\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\17\121",
            "\3\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\17\56",
            "\1\uffff",
            "\3\72\1\66\32\72\1\57\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\17\72",
            "\1\uffff",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\17\65",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\123\2\65\1\64\15\65\2\uffff"+
            "\17\65",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\17\65",
            "\3\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\17\65",
            "\1\uffff",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\17\72",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\125\2\72\1\71\15\72\2\uffff"+
            "\17\72",
            "\3\132\1\126\32\132\1\124\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\17\132",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\17\72",
            "\1\uffff",
            "\3\132\1\126\32\132\1\73\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\17\132",
            "\1\uffff",
            "\1\uffff",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\17\103",
            "\1\uffff",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\134\2\103\1\102\15"+
            "\103\2\uffff\17\103",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\17\103",
            "\3\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\17\103",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\17\113",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\17\113",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\136\2\113\1\112\15"+
            "\113\2\uffff\17\113",
            "\3\143\1\137\32\143\1\135\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\17\143",
            "\3\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\17\113",
            "\1\uffff",
            "\3\143\1\137\32\143\1\144\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\17\143",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\17\121",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\145\2\121\1\120\15"+
            "\121\2\uffff\17\121",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\17\121",
            "\3\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\17\121",
            "\1\uffff",
            "\3\132\1\126\32\132\1\122\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\17\132",
            "\1\uffff",
            "\3\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\17\72",
            "\1\uffff",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\17\132",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\147\2\132\1\131\15"+
            "\132\2\uffff\17\132",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\17\132",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\17\132",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\17\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\17\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\151\2\143\1\142\15"+
            "\143\2\uffff\17\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\17\143",
            "\3\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\17\143",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\3\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\17\132",
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
            return "()+ loopback of 173:9: (n=~ ( '\\r' | '\\n' | ';' ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_69 = input.LA(1);

                         
                        int index4_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_69);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_70 = input.LA(1);

                         
                        int index4_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_70);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_38 = input.LA(1);

                         
                        int index4_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_38);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_100 = input.LA(1);

                         
                        int index4_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_100);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_101 = input.LA(1);

                         
                        int index4_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_101);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_68 = input.LA(1);

                         
                        int index4_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_68);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_19 = input.LA(1);

                         
                        int index4_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_19);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_54 = input.LA(1);

                         
                        int index4_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_54);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_104 = input.LA(1);

                         
                        int index4_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_104);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_64 = input.LA(1);

                         
                        int index4_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_64);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_30 = input.LA(1);

                         
                        int index4_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_76 = input.LA(1);

                         
                        int index4_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_76);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_92 = input.LA(1);

                         
                        int index4_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_92);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA4_61 = input.LA(1);

                         
                        int index4_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_61);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA4_93 = input.LA(1);

                         
                        int index4_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_93);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA4_25 = input.LA(1);

                         
                        int index4_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_25);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA4_36 = input.LA(1);

                         
                        int index4_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_36);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA4_59 = input.LA(1);

                         
                        int index4_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_59);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA4_91 = input.LA(1);

                         
                        int index4_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_91);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA4_105 = input.LA(1);

                         
                        int index4_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_105);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA4_82 = input.LA(1);

                         
                        int index4_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_82);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA4_47 = input.LA(1);

                         
                        int index4_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_47);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA4_94 = input.LA(1);

                         
                        int index4_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_94);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA4_102 = input.LA(1);

                         
                        int index4_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_102);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA4_84 = input.LA(1);

                         
                        int index4_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_84);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA4_32 = input.LA(1);

                         
                        int index4_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_32);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA4_86 = input.LA(1);

                         
                        int index4_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_86);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA4_49 = input.LA(1);

                         
                        int index4_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_49);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA4_62 = input.LA(1);

                         
                        int index4_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_62);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA4_18 = input.LA(1);

                         
                        int index4_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_18);
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
        "\1\64\1\122\1\uffff\1\122\1\uffff\3\122\1\0\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\3\1\uffff\1\1\4\uffff\1\2";
    static final String DFA9_specialS =
        "\10\uffff\1\0\1\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\21\uffff\1\1",
            "\36\3\1\uffff\37\3\2\uffff\17\3",
            "",
            "\3\3\1\5\32\3\1\4\37\3\2\uffff\17\3",
            "",
            "\3\7\1\6\32\7\1\4\37\7\2\uffff\17\7",
            "\3\7\1\6\32\7\1\10\37\7\2\uffff\17\7",
            "\3\7\1\6\32\7\1\10\37\7\2\uffff\17\7",
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
            return "223:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )";
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
                        if ( (synpred37_TOMMY_SQL()) ) {s = 4;}

                        else if ( (synpred38_TOMMY_SQL()) ) {s = 9;}

                         
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
 

    public static final BitSet FOLLOW_commit_statement_in_create_statement588 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_use_statement_in_create_statement590 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_snapshot_job_statement_in_create_statement592 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_kill_job_statement_in_create_statement594 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_set_statement_in_create_statement596 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_show_sources_statement_in_create_statement598 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_show_streams_statement_in_create_statement600 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_show_cluster_statement_in_create_statement602 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_show_jobs_statement_in_create_statement604 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_update_statement_in_create_statement606 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_upsert_statement_in_create_statement608 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_lookup_statement_in_create_statement610 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_select_statement_in_create_statement612 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_create_stream_statement_in_create_statement614 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_create_source_statement_in_create_statement616 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_show_stream_statement_in_create_statement618 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_show_source_statement_in_create_statement620 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_drop_stream_statement_in_create_statement622 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_drop_source_statement_in_create_statement624 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_drop_job_statement_in_create_statement626 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_show_job_statement_in_create_statement628 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_delete_statement_in_create_statement630 = new BitSet(new long[]{0x07980000000C0D32L});
    public static final BitSet FOLLOW_NAME_in_use_name_def664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_use_statement683 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_use_statement687 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_use_statement689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_name_def721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_value_def749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_set_statement769 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_set_statement773 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_EQUAL_in_set_statement775 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement777 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_set_value_def_in_set_statement781 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement783 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_set_statement785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_table_name815 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name819 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_table_name821 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name825 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_table_name827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_bind_column_name854 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_bind_column_name856 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_bind_column_name858 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_bind_column_name860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where887 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where890 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body920 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body923 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body952 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF2L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body2988 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup_statement1019 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_lookup_statement1025 = new BitSet(new long[]{0x0000000400000080L});
    public static final BitSet FOLLOW_WHERE_in_lookup_statement1028 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_lookup_statement1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement1060 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_select_statement1066 = new BitSet(new long[]{0x0000000400000080L});
    public static final BitSet FOLLOW_WHERE_in_select_statement1069 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_select_statement1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_select_statement1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPSERT_in_upsert_statement1101 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_INTO_in_upsert_statement1103 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_upsert_statement1109 = new BitSet(new long[]{0x0003000400000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1112 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCREASE_in_upsert_statement1120 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1122 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_upsert_statement1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_update_statement1154 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1160 = new BitSet(new long[]{0x0010000400000000L});
    public static final BitSet FOLLOW_SET_in_update_statement1163 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_update_statement1173 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1179 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_WHERE_in_update_statement1181 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_update_statement1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_delete_statement1211 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_FROM_in_delete_statement1213 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_delete_statement1219 = new BitSet(new long[]{0x0000000400000080L});
    public static final BitSet FOLLOW_WHERE_in_delete_statement1222 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_delete_statement1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_table_name1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ddl_column_pk1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1320 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_comment1324 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_name1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ddl_column_type1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1423 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_column_defs1428 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1434 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ddl_column_name_in_column_def1464 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ddl_column_type_in_column_def1468 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ddl_column_pk_in_column_def1473 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ddl_column_comment_in_column_def1480 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_set_in_stream_meta_name1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1547 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NAME_in_stream_meta_value1551 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_name_in_stream_meta_def1580 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_stream_meta_value_in_stream_meta_def1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1637 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_stream_meta_defs1642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1648 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_CREATE_in_create_stream_statement1675 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STREAM_in_create_stream_statement1677 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_stream_statement1681 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1691 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_column_defs_in_create_stream_statement1695 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1697 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_META_in_create_stream_statement1699 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1701 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1705 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1707 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_stream_statement1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_stream_statement1732 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STREAM_in_drop_stream_statement1734 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_stream_statement1738 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_stream_statement1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_stream_statement1763 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STREAM_in_show_stream_statement1765 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_stream_statement1769 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_stream_statement1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_streams_statement1794 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAMS_in_show_streams_statement1796 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_streams_statement1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KILL_in_kill_job_statement1821 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_kill_job_statement1823 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_kill_job_statement1827 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_kill_job_statement1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMIT_in_commit_statement1852 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_commit_statement1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_source_meta_name1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value1924 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NAME_in_source_meta_value1928 = new BitSet(new long[]{0x0800000880000000L});
    public static final BitSet FOLLOW_set_in_source_meta_value1930 = new BitSet(new long[]{0x0800000880000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_name_in_source_meta_def1964 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_source_meta_value_in_source_meta_def1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2021 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_source_meta_defs2026 = new BitSet(new long[]{0x0000000000000000L,0x000000000007FA00L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2032 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_CREATE_in_create_source_statement2059 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SOURCE_in_create_source_statement2061 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_source_statement2065 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_META_in_create_source_statement2067 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_LPAREN_in_create_source_statement2069 = new BitSet(new long[]{0x0000000000000000L,0x000000000007FA00L});
    public static final BitSet FOLLOW_ddl_source_meta_defs_in_create_source_statement2073 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RPAREN_in_create_source_statement2075 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_source_statement2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_source_statement2100 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SOURCE_in_drop_source_statement2102 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_source_statement2106 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_source_statement2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_source_statement2131 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_SOURCE_in_show_source_statement2133 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_source_statement2137 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_source_statement2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_sources_statement2162 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCES_in_show_sources_statement2164 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_sources_statement2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_job_statement2189 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_drop_job_statement2191 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_job_statement2195 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_job_statement2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_job_statement2220 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_show_job_statement2222 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_job_statement2226 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_job_statement2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_jobs_statement2251 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_JOBS_in_show_jobs_statement2253 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_jobs_statement2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_cluster_statement2278 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_CLUSTER_in_show_cluster_statement2280 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_cluster_statement2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SNAPSHOT_in_snapshot_job_statement2305 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_JOB_in_snapshot_job_statement2307 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_snapshot_job_statement2311 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_snapshot_job_statement2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred28_TOMMY_SQL952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred37_TOMMY_SQL1163 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred37_TOMMY_SQL1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred38_TOMMY_SQL1173 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_synpred38_TOMMY_SQL1179 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_WHERE_in_synpred38_TOMMY_SQL1181 = new BitSet(new long[]{0xFFFFFFFBFFFFFFF0L,0x000000000007FFF3L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred38_TOMMY_SQL1185 = new BitSet(new long[]{0x0000000000000002L});

}