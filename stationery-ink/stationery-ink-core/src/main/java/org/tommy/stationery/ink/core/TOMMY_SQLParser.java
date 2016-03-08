// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/core/TOMMY_SQL.g 2016-03-08 15:31:53

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUGINS", "REST", "SYSTEM", "DELETE", "SELECT", "FROM", "WHERE", "LOOKUP", "INSERT", "UPSERT", "CREATE", "STREAM", "STREAMS", "BSTREAM", "BUCKET", "SOURCE", "SOURCES", "DROP", "SHOW", "JOB", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURLY", "RCURLY", "LBLE", "RBLE", "QUESTION", "EXCLAMATION", "SINGLE_QUOTE", "DOUBLE_QUOTE", "UNDERLINE", "SEMICOLON", "COMMA", "COMM", "COLON", "META", "AND", "OR", "PLUS", "MINUS", "MULTI", "DIV", "MOD", "ANDMARK", "EQUAL", "INCREASE", "VALUES", "INTO", "UPDATE", "SET", "CLUSTER", "JOBS", "KILL", "SNAPSHOT", "USE", "COMMIT", "NAME", "WHITESPACE", "WS", "UNICODE_LETTER", "UNICODE_DIGIT", "LETTER", "DIGIT", "'\\r'", "'\\n'", "'PARTITION_KEY'", "'STRING'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'LONG'", "'TOPIC'", "'COMMENT'", "'TICKSEC'", "'TYPE'", "'TXID'", "'CATALOG'", "'URL'", "'DRIVER'", "'ID'", "'PW'", "'VHOST'", "'PORT'", "'CLUSTER'", "'INITIALPOOLSIZE'", "'MAXPOOLSIZE'", "'MINPOOLSIZE'"
    };
    public static final int EOF=-1;
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
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int PLUGINS=4;
    public static final int REST=5;
    public static final int SYSTEM=6;
    public static final int DELETE=7;
    public static final int SELECT=8;
    public static final int FROM=9;
    public static final int WHERE=10;
    public static final int LOOKUP=11;
    public static final int INSERT=12;
    public static final int UPSERT=13;
    public static final int CREATE=14;
    public static final int STREAM=15;
    public static final int STREAMS=16;
    public static final int BSTREAM=17;
    public static final int BUCKET=18;
    public static final int SOURCE=19;
    public static final int SOURCES=20;
    public static final int DROP=21;
    public static final int SHOW=22;
    public static final int JOB=23;
    public static final int LPAREN=24;
    public static final int RPAREN=25;
    public static final int LSQUARE=26;
    public static final int RSQUARE=27;
    public static final int LCURLY=28;
    public static final int RCURLY=29;
    public static final int LBLE=30;
    public static final int RBLE=31;
    public static final int QUESTION=32;
    public static final int EXCLAMATION=33;
    public static final int SINGLE_QUOTE=34;
    public static final int DOUBLE_QUOTE=35;
    public static final int UNDERLINE=36;
    public static final int SEMICOLON=37;
    public static final int COMMA=38;
    public static final int COMM=39;
    public static final int COLON=40;
    public static final int META=41;
    public static final int AND=42;
    public static final int OR=43;
    public static final int PLUS=44;
    public static final int MINUS=45;
    public static final int MULTI=46;
    public static final int DIV=47;
    public static final int MOD=48;
    public static final int ANDMARK=49;
    public static final int EQUAL=50;
    public static final int INCREASE=51;
    public static final int VALUES=52;
    public static final int INTO=53;
    public static final int UPDATE=54;
    public static final int SET=55;
    public static final int CLUSTER=56;
    public static final int JOBS=57;
    public static final int KILL=58;
    public static final int SNAPSHOT=59;
    public static final int USE=60;
    public static final int COMMIT=61;
    public static final int NAME=62;
    public static final int WHITESPACE=63;
    public static final int WS=64;
    public static final int UNICODE_LETTER=65;
    public static final int UNICODE_DIGIT=66;
    public static final int LETTER=67;
    public static final int DIGIT=68;

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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:104:1: create_statement : ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ ;
    public final TOMMY_SQLParser.create_statement_return create_statement() throws RecognitionException {
        TOMMY_SQLParser.create_statement_return retval = new TOMMY_SQLParser.create_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.rest_statement_return rest_statement1 = null;

        TOMMY_SQLParser.show_system_statement_return show_system_statement2 = null;

        TOMMY_SQLParser.commit_statement_return commit_statement3 = null;

        TOMMY_SQLParser.use_statement_return use_statement4 = null;

        TOMMY_SQLParser.snapshot_job_statement_return snapshot_job_statement5 = null;

        TOMMY_SQLParser.kill_job_statement_return kill_job_statement6 = null;

        TOMMY_SQLParser.set_statement_return set_statement7 = null;

        TOMMY_SQLParser.show_sources_statement_return show_sources_statement8 = null;

        TOMMY_SQLParser.show_streams_statement_return show_streams_statement9 = null;

        TOMMY_SQLParser.show_cluster_statement_return show_cluster_statement10 = null;

        TOMMY_SQLParser.show_jobs_statement_return show_jobs_statement11 = null;

        TOMMY_SQLParser.insert_statement_return insert_statement12 = null;

        TOMMY_SQLParser.update_statement_return update_statement13 = null;

        TOMMY_SQLParser.upsert_statement_return upsert_statement14 = null;

        TOMMY_SQLParser.lookup_statement_return lookup_statement15 = null;

        TOMMY_SQLParser.select_statement_return select_statement16 = null;

        TOMMY_SQLParser.create_stream_statement_return create_stream_statement17 = null;

        TOMMY_SQLParser.create_source_statement_return create_source_statement18 = null;

        TOMMY_SQLParser.show_stream_statement_return show_stream_statement19 = null;

        TOMMY_SQLParser.show_source_statement_return show_source_statement20 = null;

        TOMMY_SQLParser.drop_stream_statement_return drop_stream_statement21 = null;

        TOMMY_SQLParser.drop_source_statement_return drop_source_statement22 = null;

        TOMMY_SQLParser.drop_job_statement_return drop_job_statement23 = null;

        TOMMY_SQLParser.show_job_statement_return show_job_statement24 = null;

        TOMMY_SQLParser.delete_statement_return delete_statement25 = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:5: ( ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:7: ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:7: ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=26;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:8: rest_statement
            	    {
            	    pushFollow(FOLLOW_rest_statement_in_create_statement615);
            	    rest_statement1=rest_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, rest_statement1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:23: show_system_statement
            	    {
            	    pushFollow(FOLLOW_show_system_statement_in_create_statement617);
            	    show_system_statement2=show_system_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_system_statement2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:45: commit_statement
            	    {
            	    pushFollow(FOLLOW_commit_statement_in_create_statement619);
            	    commit_statement3=commit_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, commit_statement3.getTree());

            	    }
            	    break;
            	case 4 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:62: use_statement
            	    {
            	    pushFollow(FOLLOW_use_statement_in_create_statement621);
            	    use_statement4=use_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, use_statement4.getTree());

            	    }
            	    break;
            	case 5 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:76: snapshot_job_statement
            	    {
            	    pushFollow(FOLLOW_snapshot_job_statement_in_create_statement623);
            	    snapshot_job_statement5=snapshot_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, snapshot_job_statement5.getTree());

            	    }
            	    break;
            	case 6 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:99: kill_job_statement
            	    {
            	    pushFollow(FOLLOW_kill_job_statement_in_create_statement625);
            	    kill_job_statement6=kill_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, kill_job_statement6.getTree());

            	    }
            	    break;
            	case 7 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:118: set_statement
            	    {
            	    pushFollow(FOLLOW_set_statement_in_create_statement627);
            	    set_statement7=set_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_statement7.getTree());

            	    }
            	    break;
            	case 8 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:132: show_sources_statement
            	    {
            	    pushFollow(FOLLOW_show_sources_statement_in_create_statement629);
            	    show_sources_statement8=show_sources_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_sources_statement8.getTree());

            	    }
            	    break;
            	case 9 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:155: show_streams_statement
            	    {
            	    pushFollow(FOLLOW_show_streams_statement_in_create_statement631);
            	    show_streams_statement9=show_streams_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_streams_statement9.getTree());

            	    }
            	    break;
            	case 10 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:178: show_cluster_statement
            	    {
            	    pushFollow(FOLLOW_show_cluster_statement_in_create_statement633);
            	    show_cluster_statement10=show_cluster_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_cluster_statement10.getTree());

            	    }
            	    break;
            	case 11 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:201: show_jobs_statement
            	    {
            	    pushFollow(FOLLOW_show_jobs_statement_in_create_statement635);
            	    show_jobs_statement11=show_jobs_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_jobs_statement11.getTree());

            	    }
            	    break;
            	case 12 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:221: insert_statement
            	    {
            	    pushFollow(FOLLOW_insert_statement_in_create_statement637);
            	    insert_statement12=insert_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, insert_statement12.getTree());

            	    }
            	    break;
            	case 13 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:238: update_statement
            	    {
            	    pushFollow(FOLLOW_update_statement_in_create_statement639);
            	    update_statement13=update_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, update_statement13.getTree());

            	    }
            	    break;
            	case 14 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:255: upsert_statement
            	    {
            	    pushFollow(FOLLOW_upsert_statement_in_create_statement641);
            	    upsert_statement14=upsert_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, upsert_statement14.getTree());

            	    }
            	    break;
            	case 15 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:272: lookup_statement
            	    {
            	    pushFollow(FOLLOW_lookup_statement_in_create_statement643);
            	    lookup_statement15=lookup_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lookup_statement15.getTree());

            	    }
            	    break;
            	case 16 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:289: select_statement
            	    {
            	    pushFollow(FOLLOW_select_statement_in_create_statement645);
            	    select_statement16=select_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement16.getTree());

            	    }
            	    break;
            	case 17 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:306: create_stream_statement
            	    {
            	    pushFollow(FOLLOW_create_stream_statement_in_create_statement647);
            	    create_stream_statement17=create_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_stream_statement17.getTree());

            	    }
            	    break;
            	case 18 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:330: create_source_statement
            	    {
            	    pushFollow(FOLLOW_create_source_statement_in_create_statement649);
            	    create_source_statement18=create_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_source_statement18.getTree());

            	    }
            	    break;
            	case 19 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:354: show_stream_statement
            	    {
            	    pushFollow(FOLLOW_show_stream_statement_in_create_statement651);
            	    show_stream_statement19=show_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_stream_statement19.getTree());

            	    }
            	    break;
            	case 20 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:376: show_source_statement
            	    {
            	    pushFollow(FOLLOW_show_source_statement_in_create_statement653);
            	    show_source_statement20=show_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_source_statement20.getTree());

            	    }
            	    break;
            	case 21 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:398: drop_stream_statement
            	    {
            	    pushFollow(FOLLOW_drop_stream_statement_in_create_statement655);
            	    drop_stream_statement21=drop_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_stream_statement21.getTree());

            	    }
            	    break;
            	case 22 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:420: drop_source_statement
            	    {
            	    pushFollow(FOLLOW_drop_source_statement_in_create_statement657);
            	    drop_source_statement22=drop_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_source_statement22.getTree());

            	    }
            	    break;
            	case 23 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:442: drop_job_statement
            	    {
            	    pushFollow(FOLLOW_drop_job_statement_in_create_statement659);
            	    drop_job_statement23=drop_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_job_statement23.getTree());

            	    }
            	    break;
            	case 24 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:461: show_job_statement
            	    {
            	    pushFollow(FOLLOW_show_job_statement_in_create_statement661);
            	    show_job_statement24=show_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_job_statement24.getTree());

            	    }
            	    break;
            	case 25 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:105:480: delete_statement
            	    {
            	    pushFollow(FOLLOW_delete_statement_in_create_statement663);
            	    delete_statement25=delete_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, delete_statement25.getTree());

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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:112:1: use_name_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.use_name_def_return use_name_def() throws RecognitionException {
        TOMMY_SQLParser.use_name_def_return retval = new TOMMY_SQLParser.use_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:113:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:113:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_use_name_def697); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:116:1: use_statement : USE column= set_name_def SEMICOLON ;
    public final TOMMY_SQLParser.use_statement_return use_statement() throws RecognitionException {
        TOMMY_SQLParser.use_statement_return retval = new TOMMY_SQLParser.use_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token USE26=null;
        Token SEMICOLON27=null;
        TOMMY_SQLParser.set_name_def_return column = null;


        Object USE26_tree=null;
        Object SEMICOLON27_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:117:5: ( USE column= set_name_def SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:117:7: USE column= set_name_def SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            USE26=(Token)match(input,USE,FOLLOW_USE_in_use_statement716); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USE26_tree = (Object)adaptor.create(USE26);
            adaptor.addChild(root_0, USE26_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_use_statement720);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            SEMICOLON27=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_use_statement722); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON27_tree = (Object)adaptor.create(SEMICOLON27);
            adaptor.addChild(root_0, SEMICOLON27_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:130:1: set_name_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.set_name_def_return set_name_def() throws RecognitionException {
        TOMMY_SQLParser.set_name_def_return retval = new TOMMY_SQLParser.set_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:131:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:131:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_name_def754); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:134:1: set_value_def returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.set_value_def_return set_value_def() throws RecognitionException {
        TOMMY_SQLParser.set_value_def_return retval = new TOMMY_SQLParser.set_value_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:135:6: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:135:10: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_value_def782); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:138:1: set_statement : SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON ;
    public final TOMMY_SQLParser.set_statement_return set_statement() throws RecognitionException {
        TOMMY_SQLParser.set_statement_return retval = new TOMMY_SQLParser.set_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SET28=null;
        Token EQUAL29=null;
        Token SINGLE_QUOTE30=null;
        Token SINGLE_QUOTE31=null;
        Token SEMICOLON32=null;
        TOMMY_SQLParser.set_name_def_return column = null;

        TOMMY_SQLParser.set_value_def_return value = null;


        Object SET28_tree=null;
        Object EQUAL29_tree=null;
        Object SINGLE_QUOTE30_tree=null;
        Object SINGLE_QUOTE31_tree=null;
        Object SEMICOLON32_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:139:5: ( SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:139:7: SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SET28=(Token)match(input,SET,FOLLOW_SET_in_set_statement802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SET28_tree = (Object)adaptor.create(SET28);
            adaptor.addChild(root_0, SET28_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_set_statement806);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            EQUAL29=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_set_statement808); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQUAL29_tree = (Object)adaptor.create(EQUAL29);
            adaptor.addChild(root_0, EQUAL29_tree);
            }
            SINGLE_QUOTE30=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE30_tree = (Object)adaptor.create(SINGLE_QUOTE30);
            adaptor.addChild(root_0, SINGLE_QUOTE30_tree);
            }
            pushFollow(FOLLOW_set_value_def_in_set_statement814);
            value=set_value_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, value.getTree());
            SINGLE_QUOTE31=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement816); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE31_tree = (Object)adaptor.create(SINGLE_QUOTE31);
            adaptor.addChild(root_0, SINGLE_QUOTE31_tree);
            }
            SEMICOLON32=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_set_statement818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON32_tree = (Object)adaptor.create(SEMICOLON32);
            adaptor.addChild(root_0, SEMICOLON32_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:153:1: dml_table_name returns [BaseTableDef ret] : LSQUARE n= NAME COLON b= NAME RSQUARE ;
    public final TOMMY_SQLParser.dml_table_name_return dml_table_name() throws RecognitionException {
        TOMMY_SQLParser.dml_table_name_return retval = new TOMMY_SQLParser.dml_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token b=null;
        Token LSQUARE33=null;
        Token COLON34=null;
        Token RSQUARE35=null;

        Object n_tree=null;
        Object b_tree=null;
        Object LSQUARE33_tree=null;
        Object COLON34_tree=null;
        Object RSQUARE35_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:154:5: ( LSQUARE n= NAME COLON b= NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:154:9: LSQUARE n= NAME COLON b= NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            LSQUARE33=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_table_name848); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LSQUARE33_tree = (Object)adaptor.create(LSQUARE33);
            adaptor.addChild(root_0, LSQUARE33_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name852); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON34=(Token)match(input,COLON,FOLLOW_COLON_in_dml_table_name854); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON34_tree = (Object)adaptor.create(COLON34);
            adaptor.addChild(root_0, COLON34_tree);
            }
            b=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name858); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (Object)adaptor.create(b);
            adaptor.addChild(root_0, b_tree);
            }
            RSQUARE35=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_table_name860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE35_tree = (Object)adaptor.create(RSQUARE35);
            adaptor.addChild(root_0, RSQUARE35_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:162:1: dml_bind_column_name returns [String ret] : n= LSQUARE COLON NAME RSQUARE ;
    public final TOMMY_SQLParser.dml_bind_column_name_return dml_bind_column_name() throws RecognitionException {
        TOMMY_SQLParser.dml_bind_column_name_return retval = new TOMMY_SQLParser.dml_bind_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token COLON36=null;
        Token NAME37=null;
        Token RSQUARE38=null;

        Object n_tree=null;
        Object COLON36_tree=null;
        Object NAME37_tree=null;
        Object RSQUARE38_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:163:5: (n= LSQUARE COLON NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:163:9: n= LSQUARE COLON NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_bind_column_name887); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON36=(Token)match(input,COLON,FOLLOW_COLON_in_dml_bind_column_name889); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON36_tree = (Object)adaptor.create(COLON36);
            adaptor.addChild(root_0, COLON36_tree);
            }
            NAME37=(Token)match(input,NAME,FOLLOW_NAME_in_dml_bind_column_name891); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME37_tree = (Object)adaptor.create(NAME37);
            adaptor.addChild(root_0, NAME37_tree);
            }
            RSQUARE38=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_bind_column_name893); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE38_tree = (Object)adaptor.create(RSQUARE38);
            adaptor.addChild(root_0, RSQUARE38_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:167:1: dml_lookup_where returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final TOMMY_SQLParser.dml_lookup_where_return dml_lookup_where() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_where_return retval = new TOMMY_SQLParser.dml_lookup_where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME39=null;
        Token NAME40=null;

        Object n_tree=null;
        Object NAME39_tree=null;
        Object NAME40_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:11: NAME ( NAME )*
            {
            NAME39=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME39_tree = (Object)adaptor.create(NAME39);
            adaptor.addChild(root_0, NAME39_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:16: ( NAME )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:168:17: NAME
            	    {
            	    NAME40=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where923); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME40_tree = (Object)adaptor.create(NAME40);
            	    adaptor.addChild(root_0, NAME40_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:171:1: dml_select_body returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final TOMMY_SQLParser.dml_select_body_return dml_select_body() throws RecognitionException {
        TOMMY_SQLParser.dml_select_body_return retval = new TOMMY_SQLParser.dml_select_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME41=null;
        Token NAME42=null;

        Object n_tree=null;
        Object NAME41_tree=null;
        Object NAME42_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:11: NAME ( NAME )*
            {
            NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body953); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME41_tree = (Object)adaptor.create(NAME41);
            adaptor.addChild(root_0, NAME41_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:16: ( NAME )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:172:17: NAME
            	    {
            	    NAME42=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body956); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME42_tree = (Object)adaptor.create(NAME42);
            	    adaptor.addChild(root_0, NAME42_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:175:1: dml_lookup_select_where_body returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ ;
    public final TOMMY_SQLParser.dml_lookup_select_where_body_return dml_lookup_select_where_body() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_select_where_body_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:8: (n=~ ( '\\r' | '\\n' | ';' ) )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
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
            	    if ( (input.LA(1)>=PLUGINS && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=71 && input.LA(1)<=92) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:179:1: dml_lookup_select_where_body2 returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON ;
    public final TOMMY_SQLParser.dml_lookup_select_where_body2_return dml_lookup_select_where_body2() throws RecognitionException {
        TOMMY_SQLParser.dml_lookup_select_where_body2_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SEMICOLON43=null;

        Object n_tree=null;
        Object SEMICOLON43_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:8: (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:180:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case PLUGINS:
                case REST:
                case SYSTEM:
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
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
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
            	    if ( (input.LA(1)>=PLUGINS && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=71 && input.LA(1)<=92) ) {
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

            SEMICOLON43=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21033); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON43_tree = (Object)adaptor.create(SEMICOLON43);
            adaptor.addChild(root_0, SEMICOLON43_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:183:1: lookup_statement : LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.lookup_statement_return lookup_statement() throws RecognitionException {
        TOMMY_SQLParser.lookup_statement_return retval = new TOMMY_SQLParser.lookup_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOOKUP44=null;
        Token WHERE45=null;
        Token SEMICOLON46=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object LOOKUP44_tree=null;
        Object WHERE45_tree=null;
        Object SEMICOLON46_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:184:5: ( LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:184:7: LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            LOOKUP44=(Token)match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup_statement1052); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOOKUP44_tree = (Object)adaptor.create(LOOKUP44);
            adaptor.addChild(root_0, LOOKUP44_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_lookup_statement1058);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:184:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:184:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE45=(Token)match(input,WHERE,FOLLOW_WHERE_in_lookup_statement1061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE45_tree = (Object)adaptor.create(WHERE45);
                    adaptor.addChild(root_0, WHERE45_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1067);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:184:96: SEMICOLON
                    {
                    SEMICOLON46=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lookup_statement1069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON46_tree = (Object)adaptor.create(SEMICOLON46);
                    adaptor.addChild(root_0, SEMICOLON46_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:196:1: select_statement : SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.select_statement_return select_statement() throws RecognitionException {
        TOMMY_SQLParser.select_statement_return retval = new TOMMY_SQLParser.select_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT47=null;
        Token WHERE48=null;
        Token SEMICOLON49=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object SELECT47_tree=null;
        Object WHERE48_tree=null;
        Object SEMICOLON49_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:197:5: ( SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:197:7: SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            SELECT47=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_statement1093); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SELECT47_tree = (Object)adaptor.create(SELECT47);
            adaptor.addChild(root_0, SELECT47_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_select_statement1099);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:197:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:197:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE48=(Token)match(input,WHERE,FOLLOW_WHERE_in_select_statement1102); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE48_tree = (Object)adaptor.create(WHERE48);
                    adaptor.addChild(root_0, WHERE48_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_select_statement1108);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:197:96: SEMICOLON
                    {
                    SEMICOLON49=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_select_statement1110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON49_tree = (Object)adaptor.create(SEMICOLON49);
                    adaptor.addChild(root_0, SEMICOLON49_tree);
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

    public static class rest_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rest_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:210:1: rest_statement : REST INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.rest_statement_return rest_statement() throws RecognitionException {
        TOMMY_SQLParser.rest_statement_return retval = new TOMMY_SQLParser.rest_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token REST50=null;
        Token INTO51=null;
        Token VALUES52=null;
        Token SEMICOLON53=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


        Object REST50_tree=null;
        Object INTO51_tree=null;
        Object VALUES52_tree=null;
        Object SEMICOLON53_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:211:5: ( REST INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:211:7: REST INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            REST50=(Token)match(input,REST,FOLLOW_REST_in_rest_statement1134); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REST50_tree = (Object)adaptor.create(REST50);
            adaptor.addChild(root_0, REST50_tree);
            }
            INTO51=(Token)match(input,INTO,FOLLOW_INTO_in_rest_statement1136); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO51_tree = (Object)adaptor.create(INTO51);
            adaptor.addChild(root_0, INTO51_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_rest_statement1142);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:211:54: ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            int alt8=2;
            switch ( input.LA(1) ) {
            case VALUES:
                {
                alt8=1;
                }
                break;
            case SEMICOLON:
                {
                alt8=2;
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:211:55: VALUES body2= dml_lookup_select_where_body2
                    {
                    VALUES52=(Token)match(input,VALUES,FOLLOW_VALUES_in_rest_statement1145); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES52_tree = (Object)adaptor.create(VALUES52);
                    adaptor.addChild(root_0, VALUES52_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_rest_statement1151);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:211:100: SEMICOLON
                    {
                    SEMICOLON53=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_rest_statement1153); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON53_tree = (Object)adaptor.create(SEMICOLON53);
                    adaptor.addChild(root_0, SEMICOLON53_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      if (body1 != null) {

                          QueryParser esperParser = new QueryParser();
                          BaseStatement statement = esperParser.parseWithoutInsertEPL(input.toString(retval.start,input.LT(-1)));
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("REST"));
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
    // $ANTLR end "rest_statement"

    public static class insert_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:225:1: insert_statement : INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.insert_statement_return insert_statement() throws RecognitionException {
        TOMMY_SQLParser.insert_statement_return retval = new TOMMY_SQLParser.insert_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INSERT54=null;
        Token INTO55=null;
        Token VALUES56=null;
        Token VALUES57=null;
        Token PLUGINS58=null;
        Token SEMICOLON59=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body3 = null;


        Object INSERT54_tree=null;
        Object INTO55_tree=null;
        Object VALUES56_tree=null;
        Object VALUES57_tree=null;
        Object PLUGINS58_tree=null;
        Object SEMICOLON59_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:226:5: ( INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:226:7: INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            INSERT54=(Token)match(input,INSERT,FOLLOW_INSERT_in_insert_statement1177); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INSERT54_tree = (Object)adaptor.create(INSERT54);
            adaptor.addChild(root_0, INSERT54_tree);
            }
            INTO55=(Token)match(input,INTO,FOLLOW_INTO_in_insert_statement1179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO55_tree = (Object)adaptor.create(INTO55);
            adaptor.addChild(root_0, INTO55_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_insert_statement1185);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:226:56: ( VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:226:57: VALUES body2= dml_lookup_select_where_body2
                    {
                    VALUES56=(Token)match(input,VALUES,FOLLOW_VALUES_in_insert_statement1188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES56_tree = (Object)adaptor.create(VALUES56);
                    adaptor.addChild(root_0, VALUES56_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_insert_statement1194);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:226:102: VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2
                    {
                    VALUES57=(Token)match(input,VALUES,FOLLOW_VALUES_in_insert_statement1196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES57_tree = (Object)adaptor.create(VALUES57);
                    adaptor.addChild(root_0, VALUES57_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_insert_statement1202);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());
                    PLUGINS58=(Token)match(input,PLUGINS,FOLLOW_PLUGINS_in_insert_statement1204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUGINS58_tree = (Object)adaptor.create(PLUGINS58);
                    adaptor.addChild(root_0, PLUGINS58_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_insert_statement1210);
                    body3=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:226:193: SEMICOLON
                    {
                    SEMICOLON59=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_insert_statement1212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON59_tree = (Object)adaptor.create(SEMICOLON59);
                    adaptor.addChild(root_0, SEMICOLON59_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      if (body1 != null) {

                          QueryParser esperParser = new QueryParser();
                          BaseStatement statement = esperParser.parseWithoutInsertEPL(input.toString(retval.start,input.LT(-1)));
                          statement.setQuery(input.toString(retval.start,input.LT(-1)));
                          statement.setType(StatementTypeEnum.valueOf("INSERT"));
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
    // $ANTLR end "insert_statement"

    public static class upsert_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "upsert_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:240:1: upsert_statement : UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.upsert_statement_return upsert_statement() throws RecognitionException {
        TOMMY_SQLParser.upsert_statement_return retval = new TOMMY_SQLParser.upsert_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPSERT60=null;
        Token INTO61=null;
        Token VALUES62=null;
        Token INCREASE63=null;
        Token VALUES64=null;
        Token VALUES65=null;
        Token PLUGINS66=null;
        Token SEMICOLON67=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body3 = null;


        Object UPSERT60_tree=null;
        Object INTO61_tree=null;
        Object VALUES62_tree=null;
        Object INCREASE63_tree=null;
        Object VALUES64_tree=null;
        Object VALUES65_tree=null;
        Object PLUGINS66_tree=null;
        Object SEMICOLON67_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:241:5: ( UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:241:7: UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPSERT60=(Token)match(input,UPSERT,FOLLOW_UPSERT_in_upsert_statement1236); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPSERT60_tree = (Object)adaptor.create(UPSERT60);
            adaptor.addChild(root_0, UPSERT60_tree);
            }
            INTO61=(Token)match(input,INTO,FOLLOW_INTO_in_upsert_statement1238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO61_tree = (Object)adaptor.create(INTO61);
            adaptor.addChild(root_0, INTO61_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_upsert_statement1244);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:241:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )
            int alt10=4;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:241:57: VALUES body2= dml_lookup_select_where_body2
                    {
                    VALUES62=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES62_tree = (Object)adaptor.create(VALUES62);
                    adaptor.addChild(root_0, VALUES62_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1253);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:241:102: INCREASE VALUES body2= dml_lookup_select_where_body2
                    {
                    INCREASE63=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_upsert_statement1255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INCREASE63_tree = (Object)adaptor.create(INCREASE63);
                    adaptor.addChild(root_0, INCREASE63_tree);
                    }
                    VALUES64=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1257); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES64_tree = (Object)adaptor.create(VALUES64);
                    adaptor.addChild(root_0, VALUES64_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1263);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:241:156: VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2
                    {
                    VALUES65=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES65_tree = (Object)adaptor.create(VALUES65);
                    adaptor.addChild(root_0, VALUES65_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1271);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());
                    PLUGINS66=(Token)match(input,PLUGINS,FOLLOW_PLUGINS_in_upsert_statement1273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUGINS66_tree = (Object)adaptor.create(PLUGINS66);
                    adaptor.addChild(root_0, PLUGINS66_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1279);
                    body3=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());

                    }
                    break;
                case 4 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:241:247: SEMICOLON
                    {
                    SEMICOLON67=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_upsert_statement1281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON67_tree = (Object)adaptor.create(SEMICOLON67);
                    adaptor.addChild(root_0, SEMICOLON67_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:255:1: update_statement : UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 | SET body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 PLUGINS body5= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.update_statement_return update_statement() throws RecognitionException {
        TOMMY_SQLParser.update_statement_return retval = new TOMMY_SQLParser.update_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPDATE68=null;
        Token SET69=null;
        Token SET70=null;
        Token WHERE71=null;
        Token SET72=null;
        Token PLUGINS73=null;
        Token SET74=null;
        Token WHERE75=null;
        Token PLUGINS76=null;
        Token SEMICOLON77=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body3 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body4 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body5 = null;


        Object UPDATE68_tree=null;
        Object SET69_tree=null;
        Object SET70_tree=null;
        Object WHERE71_tree=null;
        Object SET72_tree=null;
        Object PLUGINS73_tree=null;
        Object SET74_tree=null;
        Object WHERE75_tree=null;
        Object PLUGINS76_tree=null;
        Object SEMICOLON77_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:5: ( UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 | SET body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 PLUGINS body5= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:7: UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 | SET body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 PLUGINS body5= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPDATE68=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_update_statement1305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPDATE68_tree = (Object)adaptor.create(UPDATE68);
            adaptor.addChild(root_0, UPDATE68_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1311);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 | SET body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 PLUGINS body5= dml_lookup_select_where_body2 | SEMICOLON )
            int alt11=5;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:52: SET body2= dml_lookup_select_where_body2
                    {
                    SET69=(Token)match(input,SET,FOLLOW_SET_in_update_statement1314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET69_tree = (Object)adaptor.create(SET69);
                    adaptor.addChild(root_0, SET69_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1320);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:96: SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2
                    {
                    SET70=(Token)match(input,SET,FOLLOW_SET_in_update_statement1324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET70_tree = (Object)adaptor.create(SET70);
                    adaptor.addChild(root_0, SET70_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1330);
                    body3=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());
                    WHERE71=(Token)match(input,WHERE,FOLLOW_WHERE_in_update_statement1332); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE71_tree = (Object)adaptor.create(WHERE71);
                    adaptor.addChild(root_0, WHERE71_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1336);
                    body4=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body4.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:180: SET body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2
                    {
                    SET72=(Token)match(input,SET,FOLLOW_SET_in_update_statement1338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET72_tree = (Object)adaptor.create(SET72);
                    adaptor.addChild(root_0, SET72_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1344);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());
                    PLUGINS73=(Token)match(input,PLUGINS,FOLLOW_PLUGINS_in_update_statement1346); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUGINS73_tree = (Object)adaptor.create(PLUGINS73);
                    adaptor.addChild(root_0, PLUGINS73_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1352);
                    body3=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());

                    }
                    break;
                case 4 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:268: SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 PLUGINS body5= dml_lookup_select_where_body2
                    {
                    SET74=(Token)match(input,SET,FOLLOW_SET_in_update_statement1354); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET74_tree = (Object)adaptor.create(SET74);
                    adaptor.addChild(root_0, SET74_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1360);
                    body3=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());
                    WHERE75=(Token)match(input,WHERE,FOLLOW_WHERE_in_update_statement1362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE75_tree = (Object)adaptor.create(WHERE75);
                    adaptor.addChild(root_0, WHERE75_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1366);
                    body4=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body4.getTree());
                    PLUGINS76=(Token)match(input,PLUGINS,FOLLOW_PLUGINS_in_update_statement1368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUGINS76_tree = (Object)adaptor.create(PLUGINS76);
                    adaptor.addChild(root_0, PLUGINS76_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1374);
                    body5=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body5.getTree());

                    }
                    break;
                case 5 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:256:398: SEMICOLON
                    {
                    SEMICOLON77=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_update_statement1376); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON77_tree = (Object)adaptor.create(SEMICOLON77);
                    adaptor.addChild(root_0, SEMICOLON77_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:270:1: delete_statement : DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | WHERE body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final TOMMY_SQLParser.delete_statement_return delete_statement() throws RecognitionException {
        TOMMY_SQLParser.delete_statement_return retval = new TOMMY_SQLParser.delete_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DELETE78=null;
        Token FROM79=null;
        Token WHERE80=null;
        Token WHERE81=null;
        Token PLUGINS82=null;
        Token SEMICOLON83=null;
        TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;

        TOMMY_SQLParser.dml_lookup_select_where_body2_return body3 = null;


        Object DELETE78_tree=null;
        Object FROM79_tree=null;
        Object WHERE80_tree=null;
        Object WHERE81_tree=null;
        Object PLUGINS82_tree=null;
        Object SEMICOLON83_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:271:5: ( DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | WHERE body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:271:7: DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | WHERE body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            DELETE78=(Token)match(input,DELETE,FOLLOW_DELETE_in_delete_statement1400); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DELETE78_tree = (Object)adaptor.create(DELETE78);
            adaptor.addChild(root_0, DELETE78_tree);
            }
            FROM79=(Token)match(input,FROM,FOLLOW_FROM_in_delete_statement1402); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FROM79_tree = (Object)adaptor.create(FROM79);
            adaptor.addChild(root_0, FROM79_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_delete_statement1408);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:271:56: ( WHERE body2= dml_lookup_select_where_body2 | WHERE body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )
            int alt12=3;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:271:57: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE80=(Token)match(input,WHERE,FOLLOW_WHERE_in_delete_statement1411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE80_tree = (Object)adaptor.create(WHERE80);
                    adaptor.addChild(root_0, WHERE80_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1417);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:271:101: WHERE body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2
                    {
                    WHERE81=(Token)match(input,WHERE,FOLLOW_WHERE_in_delete_statement1419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE81_tree = (Object)adaptor.create(WHERE81);
                    adaptor.addChild(root_0, WHERE81_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1425);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());
                    PLUGINS82=(Token)match(input,PLUGINS,FOLLOW_PLUGINS_in_delete_statement1427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUGINS82_tree = (Object)adaptor.create(PLUGINS82);
                    adaptor.addChild(root_0, PLUGINS82_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1433);
                    body3=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:271:191: SEMICOLON
                    {
                    SEMICOLON83=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_delete_statement1435); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON83_tree = (Object)adaptor.create(SEMICOLON83);
                    adaptor.addChild(root_0, SEMICOLON83_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:284:1: ddl_table_name returns [BaseTableDef ret] : n= NAME ;
    public final TOMMY_SQLParser.ddl_table_name_return ddl_table_name() throws RecognitionException {
        TOMMY_SQLParser.ddl_table_name_return retval = new TOMMY_SQLParser.ddl_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:285:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_table_name1467); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:292:1: ddl_column_pk returns [boolean ret] : n= 'PARTITION_KEY' ;
    public final TOMMY_SQLParser.ddl_column_pk_return ddl_column_pk() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_pk_return retval = new TOMMY_SQLParser.ddl_column_pk_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:293:5: (n= 'PARTITION_KEY' )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:294:9: n= 'PARTITION_KEY'
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,71,FOLLOW_71_in_ddl_column_pk1500); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:297:1: ddl_column_comment returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final TOMMY_SQLParser.ddl_column_comment_return ddl_column_comment() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_comment_return retval = new TOMMY_SQLParser.ddl_column_comment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE84=null;
        Token SINGLE_QUOTE85=null;

        Object n_tree=null;
        Object SINGLE_QUOTE84_tree=null;
        Object SINGLE_QUOTE85_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:298:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:298:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE84=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1525); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE84_tree = (Object)adaptor.create(SINGLE_QUOTE84);
            adaptor.addChild(root_0, SINGLE_QUOTE84_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_comment1529); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE85=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1531); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE85_tree = (Object)adaptor.create(SINGLE_QUOTE85);
            adaptor.addChild(root_0, SINGLE_QUOTE85_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:1: ddl_column_name returns [String ret] : n= NAME ;
    public final TOMMY_SQLParser.ddl_column_name_return ddl_column_name() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_name_return retval = new TOMMY_SQLParser.ddl_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:302:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:302:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_name1558); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:305:1: ddl_column_type returns [ColumnDataTypeEnum ret] : n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' | 'LONG' ) ;
    public final TOMMY_SQLParser.ddl_column_type_return ddl_column_type() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_type_return retval = new TOMMY_SQLParser.ddl_column_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:306:5: (n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' | 'LONG' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:306:9: n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' | 'LONG' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=72 && input.LA(1)<=76) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:310:1: ddl_column_defs returns [List<BaseColumnDef> ret] : v= column_def ( COMMA v= column_def )* ;
    public final TOMMY_SQLParser.ddl_column_defs_return ddl_column_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_column_defs_return retval = new TOMMY_SQLParser.ddl_column_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA86=null;
        TOMMY_SQLParser.column_def_return v = null;


        Object COMMA86_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:311:5: (v= column_def ( COMMA v= column_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:312:9: v= column_def ( COMMA v= column_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_column_def_in_ddl_column_defs1630);
            v=column_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                          retval.ret = new ArrayList<BaseColumnDef>();
                          retval.ret.add(v.ret);
                      
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:315:11: ( COMMA v= column_def )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:315:12: COMMA v= column_def
            	    {
            	    COMMA86=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_column_defs1635); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA86_tree = (Object)adaptor.create(COMMA86);
            	    adaptor.addChild(root_0, COMMA86_tree);
            	    }
            	    pushFollow(FOLLOW_column_def_in_ddl_column_defs1641);
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
            	    break loop13;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:318:1: column_def returns [BaseColumnDef ret] : c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* ;
    public final TOMMY_SQLParser.column_def_return column_def() throws RecognitionException {
        TOMMY_SQLParser.column_def_return retval = new TOMMY_SQLParser.column_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.ddl_column_name_return c = null;

        TOMMY_SQLParser.ddl_column_type_return dt = null;

        TOMMY_SQLParser.ddl_column_pk_return pk = null;

        TOMMY_SQLParser.ddl_column_comment_return cmt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:319:5: (c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:319:9: c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ddl_column_name_in_column_def1671);
            c=ddl_column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_ddl_column_type_in_column_def1675);
            dt=ddl_column_type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:319:46: (pk= ddl_column_pk )*
            loop14:
            do {
                int alt14=2;
                switch ( input.LA(1) ) {
                case 71:
                    {
                    alt14=1;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:319:47: pk= ddl_column_pk
            	    {
            	    pushFollow(FOLLOW_ddl_column_pk_in_column_def1680);
            	    pk=ddl_column_pk();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pk.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:319:66: (cmt= ddl_column_comment )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case SINGLE_QUOTE:
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:319:67: cmt= ddl_column_comment
            	    {
            	    pushFollow(FOLLOW_ddl_column_comment_in_column_def1687);
            	    cmt=ddl_column_comment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cmt.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:326:1: stream_meta_name returns [String ret] : n= ( 'TOPIC' | 'COMMENT' | 'TICKSEC' | 'TYPE' | 'TXID' ) ;
    public final TOMMY_SQLParser.stream_meta_name_return stream_meta_name() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_name_return retval = new TOMMY_SQLParser.stream_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:327:5: (n= ( 'TOPIC' | 'COMMENT' | 'TICKSEC' | 'TYPE' | 'TXID' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:327:9: n= ( 'TOPIC' | 'COMMENT' | 'TICKSEC' | 'TYPE' | 'TXID' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=77 && input.LA(1)<=81) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:330:1: stream_meta_value returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final TOMMY_SQLParser.stream_meta_value_return stream_meta_value() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_value_return retval = new TOMMY_SQLParser.stream_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE87=null;
        Token SINGLE_QUOTE88=null;

        Object n_tree=null;
        Object SINGLE_QUOTE87_tree=null;
        Object SINGLE_QUOTE88_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:331:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:331:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE87=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1760); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE87_tree = (Object)adaptor.create(SINGLE_QUOTE87);
            adaptor.addChild(root_0, SINGLE_QUOTE87_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_stream_meta_value1764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE88=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE88_tree = (Object)adaptor.create(SINGLE_QUOTE88);
            adaptor.addChild(root_0, SINGLE_QUOTE88_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:334:1: stream_meta_def returns [BaseMetaDef ret] : c= stream_meta_name dt= stream_meta_value ;
    public final TOMMY_SQLParser.stream_meta_def_return stream_meta_def() throws RecognitionException {
        TOMMY_SQLParser.stream_meta_def_return retval = new TOMMY_SQLParser.stream_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.stream_meta_name_return c = null;

        TOMMY_SQLParser.stream_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:335:5: (c= stream_meta_name dt= stream_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:335:9: c= stream_meta_name dt= stream_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_name_in_stream_meta_def1793);
            c=stream_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_stream_meta_value_in_stream_meta_def1797);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:339:1: ddl_stream_meta_defs returns [List<BaseMetaDef> ret] : v= stream_meta_def ( COMMA v= stream_meta_def )* ;
    public final TOMMY_SQLParser.ddl_stream_meta_defs_return ddl_stream_meta_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_stream_meta_defs_return retval = new TOMMY_SQLParser.ddl_stream_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA89=null;
        TOMMY_SQLParser.stream_meta_def_return v = null;


        Object COMMA89_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:340:10: (v= stream_meta_def ( COMMA v= stream_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:341:14: v= stream_meta_def ( COMMA v= stream_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1850);
            v=stream_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);
                           
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:344:16: ( COMMA v= stream_meta_def )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:344:17: COMMA v= stream_meta_def
            	    {
            	    COMMA89=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_stream_meta_defs1855); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA89_tree = (Object)adaptor.create(COMMA89);
            	    adaptor.addChild(root_0, COMMA89_tree);
            	    }
            	    pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1861);
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
    // $ANTLR end "ddl_stream_meta_defs"

    public static class create_stream_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "create_stream_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:347:1: create_stream_statement : CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON ;
    public final TOMMY_SQLParser.create_stream_statement_return create_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.create_stream_statement_return retval = new TOMMY_SQLParser.create_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE90=null;
        Token STREAM91=null;
        Token LPAREN92=null;
        Token RPAREN93=null;
        Token META94=null;
        Token LPAREN95=null;
        Token RPAREN96=null;
        Token SEMICOLON97=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;

        TOMMY_SQLParser.ddl_column_defs_return columns = null;

        TOMMY_SQLParser.ddl_stream_meta_defs_return metas = null;


        Object CREATE90_tree=null;
        Object STREAM91_tree=null;
        Object LPAREN92_tree=null;
        Object RPAREN93_tree=null;
        Object META94_tree=null;
        Object LPAREN95_tree=null;
        Object RPAREN96_tree=null;
        Object SEMICOLON97_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:348:5: ( CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:348:7: CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE90=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_stream_statement1888); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE90_tree = (Object)adaptor.create(CREATE90);
            adaptor.addChild(root_0, CREATE90_tree);
            }
            STREAM91=(Token)match(input,STREAM,FOLLOW_STREAM_in_create_stream_statement1890); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM91_tree = (Object)adaptor.create(STREAM91);
            adaptor.addChild(root_0, STREAM91_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_stream_statement1894);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            LPAREN92=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN92_tree = (Object)adaptor.create(LPAREN92);
            adaptor.addChild(root_0, LPAREN92_tree);
            }
            pushFollow(FOLLOW_ddl_column_defs_in_create_stream_statement1908);
            columns=ddl_column_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, columns.getTree());
            RPAREN93=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1910); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN93_tree = (Object)adaptor.create(RPAREN93);
            adaptor.addChild(root_0, RPAREN93_tree);
            }
            META94=(Token)match(input,META,FOLLOW_META_in_create_stream_statement1912); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META94_tree = (Object)adaptor.create(META94);
            adaptor.addChild(root_0, META94_tree);
            }
            LPAREN95=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1914); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN95_tree = (Object)adaptor.create(LPAREN95);
            adaptor.addChild(root_0, LPAREN95_tree);
            }
            pushFollow(FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1918);
            metas=ddl_stream_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN96=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN96_tree = (Object)adaptor.create(RPAREN96);
            adaptor.addChild(root_0, RPAREN96_tree);
            }
            SEMICOLON97=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_stream_statement1922); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON97_tree = (Object)adaptor.create(SEMICOLON97);
            adaptor.addChild(root_0, SEMICOLON97_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:362:1: drop_stream_statement : DROP STREAM table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_stream_statement_return drop_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_stream_statement_return retval = new TOMMY_SQLParser.drop_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP98=null;
        Token STREAM99=null;
        Token SEMICOLON100=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP98_tree=null;
        Object STREAM99_tree=null;
        Object SEMICOLON100_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:363:5: ( DROP STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:363:7: DROP STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP98=(Token)match(input,DROP,FOLLOW_DROP_in_drop_stream_statement1945); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP98_tree = (Object)adaptor.create(DROP98);
            adaptor.addChild(root_0, DROP98_tree);
            }
            STREAM99=(Token)match(input,STREAM,FOLLOW_STREAM_in_drop_stream_statement1947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM99_tree = (Object)adaptor.create(STREAM99);
            adaptor.addChild(root_0, STREAM99_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_stream_statement1951);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON100=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_stream_statement1953); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON100_tree = (Object)adaptor.create(SEMICOLON100);
            adaptor.addChild(root_0, SEMICOLON100_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:374:1: show_stream_statement : SHOW STREAM table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_stream_statement_return show_stream_statement() throws RecognitionException {
        TOMMY_SQLParser.show_stream_statement_return retval = new TOMMY_SQLParser.show_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW101=null;
        Token STREAM102=null;
        Token SEMICOLON103=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW101_tree=null;
        Object STREAM102_tree=null;
        Object SEMICOLON103_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:375:5: ( SHOW STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:375:7: SHOW STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW101=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_stream_statement1976); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW101_tree = (Object)adaptor.create(SHOW101);
            adaptor.addChild(root_0, SHOW101_tree);
            }
            STREAM102=(Token)match(input,STREAM,FOLLOW_STREAM_in_show_stream_statement1978); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM102_tree = (Object)adaptor.create(STREAM102);
            adaptor.addChild(root_0, STREAM102_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_stream_statement1982);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON103=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_stream_statement1984); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON103_tree = (Object)adaptor.create(SEMICOLON103);
            adaptor.addChild(root_0, SEMICOLON103_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:386:1: show_streams_statement : SHOW STREAMS SEMICOLON ;
    public final TOMMY_SQLParser.show_streams_statement_return show_streams_statement() throws RecognitionException {
        TOMMY_SQLParser.show_streams_statement_return retval = new TOMMY_SQLParser.show_streams_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW104=null;
        Token STREAMS105=null;
        Token SEMICOLON106=null;

        Object SHOW104_tree=null;
        Object STREAMS105_tree=null;
        Object SEMICOLON106_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:387:5: ( SHOW STREAMS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:387:7: SHOW STREAMS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW104=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_streams_statement2007); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW104_tree = (Object)adaptor.create(SHOW104);
            adaptor.addChild(root_0, SHOW104_tree);
            }
            STREAMS105=(Token)match(input,STREAMS,FOLLOW_STREAMS_in_show_streams_statement2009); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAMS105_tree = (Object)adaptor.create(STREAMS105);
            adaptor.addChild(root_0, STREAMS105_tree);
            }
            SEMICOLON106=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_streams_statement2011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON106_tree = (Object)adaptor.create(SEMICOLON106);
            adaptor.addChild(root_0, SEMICOLON106_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:397:1: kill_job_statement : KILL JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.kill_job_statement_return kill_job_statement() throws RecognitionException {
        TOMMY_SQLParser.kill_job_statement_return retval = new TOMMY_SQLParser.kill_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KILL107=null;
        Token JOB108=null;
        Token SEMICOLON109=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object KILL107_tree=null;
        Object JOB108_tree=null;
        Object SEMICOLON109_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:398:5: ( KILL JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:398:7: KILL JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            KILL107=(Token)match(input,KILL,FOLLOW_KILL_in_kill_job_statement2034); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KILL107_tree = (Object)adaptor.create(KILL107);
            adaptor.addChild(root_0, KILL107_tree);
            }
            JOB108=(Token)match(input,JOB,FOLLOW_JOB_in_kill_job_statement2036); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB108_tree = (Object)adaptor.create(JOB108);
            adaptor.addChild(root_0, JOB108_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_kill_job_statement2040);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON109=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_kill_job_statement2042); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON109_tree = (Object)adaptor.create(SEMICOLON109);
            adaptor.addChild(root_0, SEMICOLON109_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:409:1: commit_statement : COMMIT SEMICOLON ;
    public final TOMMY_SQLParser.commit_statement_return commit_statement() throws RecognitionException {
        TOMMY_SQLParser.commit_statement_return retval = new TOMMY_SQLParser.commit_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMIT110=null;
        Token SEMICOLON111=null;

        Object COMMIT110_tree=null;
        Object SEMICOLON111_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:410:5: ( COMMIT SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:410:7: COMMIT SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            COMMIT110=(Token)match(input,COMMIT,FOLLOW_COMMIT_in_commit_statement2065); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COMMIT110_tree = (Object)adaptor.create(COMMIT110);
            adaptor.addChild(root_0, COMMIT110_tree);
            }
            SEMICOLON111=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_commit_statement2067); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON111_tree = (Object)adaptor.create(SEMICOLON111);
            adaptor.addChild(root_0, SEMICOLON111_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:416:1: source_meta_name returns [String ret] : n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) ;
    public final TOMMY_SQLParser.source_meta_name_return source_meta_name() throws RecognitionException {
        TOMMY_SQLParser.source_meta_name_return retval = new TOMMY_SQLParser.source_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:417:5: (n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:417:9: n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( input.LA(1)==77||(input.LA(1)>=82 && input.LA(1)<=92) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:420:1: source_meta_value returns [String ret] : SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE ;
    public final TOMMY_SQLParser.source_meta_value_return source_meta_value() throws RecognitionException {
        TOMMY_SQLParser.source_meta_value_return retval = new TOMMY_SQLParser.source_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE112=null;
        Token set113=null;
        Token SINGLE_QUOTE114=null;

        Object n_tree=null;
        Object SINGLE_QUOTE112_tree=null;
        Object set113_tree=null;
        Object SINGLE_QUOTE114_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:421:5: ( SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:421:9: SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE112=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value2144); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE112_tree = (Object)adaptor.create(SINGLE_QUOTE112);
            adaptor.addChild(root_0, SINGLE_QUOTE112_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_source_meta_value2148); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:421:29: ( NAME | COMMA )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case COMMA:
                case NAME:
                    {
                    alt17=1;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:
            	    {
            	    set113=(Token)input.LT(1);
            	    if ( input.LA(1)==COMMA||input.LA(1)==NAME ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set113));
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
            	    break loop17;
                }
            } while (true);

            SINGLE_QUOTE114=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value2157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE114_tree = (Object)adaptor.create(SINGLE_QUOTE114);
            adaptor.addChild(root_0, SINGLE_QUOTE114_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:424:1: source_meta_def returns [BaseMetaDef ret] : c= source_meta_name dt= source_meta_value ;
    public final TOMMY_SQLParser.source_meta_def_return source_meta_def() throws RecognitionException {
        TOMMY_SQLParser.source_meta_def_return retval = new TOMMY_SQLParser.source_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        TOMMY_SQLParser.source_meta_name_return c = null;

        TOMMY_SQLParser.source_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:425:5: (c= source_meta_name dt= source_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:425:9: c= source_meta_name dt= source_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_name_in_source_meta_def2184);
            c=source_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_source_meta_value_in_source_meta_def2188);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:429:1: ddl_source_meta_defs returns [List<BaseMetaDef> ret] : v= source_meta_def ( COMMA v= source_meta_def )* ;
    public final TOMMY_SQLParser.ddl_source_meta_defs_return ddl_source_meta_defs() throws RecognitionException {
        TOMMY_SQLParser.ddl_source_meta_defs_return retval = new TOMMY_SQLParser.ddl_source_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA115=null;
        TOMMY_SQLParser.source_meta_def_return v = null;


        Object COMMA115_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:430:10: (v= source_meta_def ( COMMA v= source_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:431:14: v= source_meta_def ( COMMA v= source_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2241);
            v=source_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);
                           
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:434:16: ( COMMA v= source_meta_def )*
            loop18:
            do {
                int alt18=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt18=1;
                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:434:17: COMMA v= source_meta_def
            	    {
            	    COMMA115=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_source_meta_defs2246); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA115_tree = (Object)adaptor.create(COMMA115);
            	    adaptor.addChild(root_0, COMMA115_tree);
            	    }
            	    pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2252);
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
            	    break loop18;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:437:1: create_source_statement : CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON ;
    public final TOMMY_SQLParser.create_source_statement_return create_source_statement() throws RecognitionException {
        TOMMY_SQLParser.create_source_statement_return retval = new TOMMY_SQLParser.create_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE116=null;
        Token SOURCE117=null;
        Token META118=null;
        Token LPAREN119=null;
        Token RPAREN120=null;
        Token SEMICOLON121=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;

        TOMMY_SQLParser.ddl_source_meta_defs_return metas = null;


        Object CREATE116_tree=null;
        Object SOURCE117_tree=null;
        Object META118_tree=null;
        Object LPAREN119_tree=null;
        Object RPAREN120_tree=null;
        Object SEMICOLON121_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:438:5: ( CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:438:7: CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE116=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_source_statement2279); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE116_tree = (Object)adaptor.create(CREATE116);
            adaptor.addChild(root_0, CREATE116_tree);
            }
            SOURCE117=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_create_source_statement2281); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE117_tree = (Object)adaptor.create(SOURCE117);
            adaptor.addChild(root_0, SOURCE117_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_source_statement2285);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            META118=(Token)match(input,META,FOLLOW_META_in_create_source_statement2287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META118_tree = (Object)adaptor.create(META118);
            adaptor.addChild(root_0, META118_tree);
            }
            LPAREN119=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_source_statement2289); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN119_tree = (Object)adaptor.create(LPAREN119);
            adaptor.addChild(root_0, LPAREN119_tree);
            }
            pushFollow(FOLLOW_ddl_source_meta_defs_in_create_source_statement2293);
            metas=ddl_source_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN120=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_source_statement2295); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN120_tree = (Object)adaptor.create(RPAREN120);
            adaptor.addChild(root_0, RPAREN120_tree);
            }
            SEMICOLON121=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_source_statement2297); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON121_tree = (Object)adaptor.create(SEMICOLON121);
            adaptor.addChild(root_0, SEMICOLON121_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:451:1: drop_source_statement : DROP SOURCE table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_source_statement_return drop_source_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_source_statement_return retval = new TOMMY_SQLParser.drop_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP122=null;
        Token SOURCE123=null;
        Token SEMICOLON124=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP122_tree=null;
        Object SOURCE123_tree=null;
        Object SEMICOLON124_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:452:5: ( DROP SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:452:7: DROP SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP122=(Token)match(input,DROP,FOLLOW_DROP_in_drop_source_statement2320); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP122_tree = (Object)adaptor.create(DROP122);
            adaptor.addChild(root_0, DROP122_tree);
            }
            SOURCE123=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_drop_source_statement2322); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE123_tree = (Object)adaptor.create(SOURCE123);
            adaptor.addChild(root_0, SOURCE123_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_source_statement2326);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON124=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_source_statement2328); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON124_tree = (Object)adaptor.create(SEMICOLON124);
            adaptor.addChild(root_0, SEMICOLON124_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:463:1: show_source_statement : SHOW SOURCE table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_source_statement_return show_source_statement() throws RecognitionException {
        TOMMY_SQLParser.show_source_statement_return retval = new TOMMY_SQLParser.show_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW125=null;
        Token SOURCE126=null;
        Token SEMICOLON127=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW125_tree=null;
        Object SOURCE126_tree=null;
        Object SEMICOLON127_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:464:5: ( SHOW SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:464:7: SHOW SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW125=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_source_statement2351); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW125_tree = (Object)adaptor.create(SHOW125);
            adaptor.addChild(root_0, SHOW125_tree);
            }
            SOURCE126=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_show_source_statement2353); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE126_tree = (Object)adaptor.create(SOURCE126);
            adaptor.addChild(root_0, SOURCE126_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_source_statement2357);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON127=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_source_statement2359); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON127_tree = (Object)adaptor.create(SEMICOLON127);
            adaptor.addChild(root_0, SEMICOLON127_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:475:1: show_sources_statement : SHOW SOURCES SEMICOLON ;
    public final TOMMY_SQLParser.show_sources_statement_return show_sources_statement() throws RecognitionException {
        TOMMY_SQLParser.show_sources_statement_return retval = new TOMMY_SQLParser.show_sources_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW128=null;
        Token SOURCES129=null;
        Token SEMICOLON130=null;

        Object SHOW128_tree=null;
        Object SOURCES129_tree=null;
        Object SEMICOLON130_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:476:5: ( SHOW SOURCES SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:476:7: SHOW SOURCES SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW128=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_sources_statement2382); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW128_tree = (Object)adaptor.create(SHOW128);
            adaptor.addChild(root_0, SHOW128_tree);
            }
            SOURCES129=(Token)match(input,SOURCES,FOLLOW_SOURCES_in_show_sources_statement2384); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCES129_tree = (Object)adaptor.create(SOURCES129);
            adaptor.addChild(root_0, SOURCES129_tree);
            }
            SEMICOLON130=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_sources_statement2386); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON130_tree = (Object)adaptor.create(SEMICOLON130);
            adaptor.addChild(root_0, SEMICOLON130_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:486:1: drop_job_statement : DROP JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.drop_job_statement_return drop_job_statement() throws RecognitionException {
        TOMMY_SQLParser.drop_job_statement_return retval = new TOMMY_SQLParser.drop_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP131=null;
        Token JOB132=null;
        Token SEMICOLON133=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object DROP131_tree=null;
        Object JOB132_tree=null;
        Object SEMICOLON133_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:487:5: ( DROP JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:487:7: DROP JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP131=(Token)match(input,DROP,FOLLOW_DROP_in_drop_job_statement2409); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP131_tree = (Object)adaptor.create(DROP131);
            adaptor.addChild(root_0, DROP131_tree);
            }
            JOB132=(Token)match(input,JOB,FOLLOW_JOB_in_drop_job_statement2411); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB132_tree = (Object)adaptor.create(JOB132);
            adaptor.addChild(root_0, JOB132_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_job_statement2415);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON133=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_job_statement2417); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON133_tree = (Object)adaptor.create(SEMICOLON133);
            adaptor.addChild(root_0, SEMICOLON133_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:498:1: show_job_statement : SHOW JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.show_job_statement_return show_job_statement() throws RecognitionException {
        TOMMY_SQLParser.show_job_statement_return retval = new TOMMY_SQLParser.show_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW134=null;
        Token JOB135=null;
        Token SEMICOLON136=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SHOW134_tree=null;
        Object JOB135_tree=null;
        Object SEMICOLON136_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:499:5: ( SHOW JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:499:7: SHOW JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW134=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_job_statement2440); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW134_tree = (Object)adaptor.create(SHOW134);
            adaptor.addChild(root_0, SHOW134_tree);
            }
            JOB135=(Token)match(input,JOB,FOLLOW_JOB_in_show_job_statement2442); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB135_tree = (Object)adaptor.create(JOB135);
            adaptor.addChild(root_0, JOB135_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_job_statement2446);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON136=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_job_statement2448); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON136_tree = (Object)adaptor.create(SEMICOLON136);
            adaptor.addChild(root_0, SEMICOLON136_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:510:1: show_jobs_statement : SHOW JOBS SEMICOLON ;
    public final TOMMY_SQLParser.show_jobs_statement_return show_jobs_statement() throws RecognitionException {
        TOMMY_SQLParser.show_jobs_statement_return retval = new TOMMY_SQLParser.show_jobs_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW137=null;
        Token JOBS138=null;
        Token SEMICOLON139=null;

        Object SHOW137_tree=null;
        Object JOBS138_tree=null;
        Object SEMICOLON139_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:511:5: ( SHOW JOBS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:511:7: SHOW JOBS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW137=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_jobs_statement2471); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW137_tree = (Object)adaptor.create(SHOW137);
            adaptor.addChild(root_0, SHOW137_tree);
            }
            JOBS138=(Token)match(input,JOBS,FOLLOW_JOBS_in_show_jobs_statement2473); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOBS138_tree = (Object)adaptor.create(JOBS138);
            adaptor.addChild(root_0, JOBS138_tree);
            }
            SEMICOLON139=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_jobs_statement2475); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON139_tree = (Object)adaptor.create(SEMICOLON139);
            adaptor.addChild(root_0, SEMICOLON139_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:521:1: show_cluster_statement : SHOW CLUSTER SEMICOLON ;
    public final TOMMY_SQLParser.show_cluster_statement_return show_cluster_statement() throws RecognitionException {
        TOMMY_SQLParser.show_cluster_statement_return retval = new TOMMY_SQLParser.show_cluster_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW140=null;
        Token CLUSTER141=null;
        Token SEMICOLON142=null;

        Object SHOW140_tree=null;
        Object CLUSTER141_tree=null;
        Object SEMICOLON142_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:522:5: ( SHOW CLUSTER SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:522:7: SHOW CLUSTER SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW140=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_cluster_statement2498); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW140_tree = (Object)adaptor.create(SHOW140);
            adaptor.addChild(root_0, SHOW140_tree);
            }
            CLUSTER141=(Token)match(input,CLUSTER,FOLLOW_CLUSTER_in_show_cluster_statement2500); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CLUSTER141_tree = (Object)adaptor.create(CLUSTER141);
            adaptor.addChild(root_0, CLUSTER141_tree);
            }
            SEMICOLON142=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_cluster_statement2502); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON142_tree = (Object)adaptor.create(SEMICOLON142);
            adaptor.addChild(root_0, SEMICOLON142_tree);
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

    public static class show_system_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "show_system_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:532:1: show_system_statement : SHOW SYSTEM SEMICOLON ;
    public final TOMMY_SQLParser.show_system_statement_return show_system_statement() throws RecognitionException {
        TOMMY_SQLParser.show_system_statement_return retval = new TOMMY_SQLParser.show_system_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW143=null;
        Token SYSTEM144=null;
        Token SEMICOLON145=null;

        Object SHOW143_tree=null;
        Object SYSTEM144_tree=null;
        Object SEMICOLON145_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:533:5: ( SHOW SYSTEM SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:533:7: SHOW SYSTEM SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW143=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_system_statement2525); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW143_tree = (Object)adaptor.create(SHOW143);
            adaptor.addChild(root_0, SHOW143_tree);
            }
            SYSTEM144=(Token)match(input,SYSTEM,FOLLOW_SYSTEM_in_show_system_statement2527); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SYSTEM144_tree = (Object)adaptor.create(SYSTEM144);
            adaptor.addChild(root_0, SYSTEM144_tree);
            }
            SEMICOLON145=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_system_statement2529); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON145_tree = (Object)adaptor.create(SEMICOLON145);
            adaptor.addChild(root_0, SEMICOLON145_tree);
            }
            if ( state.backtracking==0 ) {

                      BaseStatement statement = new BaseStatement();
                      statement.setQuery(input.toString(retval.start,input.LT(-1)));
                      statement.setType(StatementTypeEnum.valueOf("SHOW_SYSTEM"));

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
    // $ANTLR end "show_system_statement"

    public static class snapshot_job_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "snapshot_job_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:543:1: snapshot_job_statement : SNAPSHOT JOB table_name= ddl_table_name SEMICOLON ;
    public final TOMMY_SQLParser.snapshot_job_statement_return snapshot_job_statement() throws RecognitionException {
        TOMMY_SQLParser.snapshot_job_statement_return retval = new TOMMY_SQLParser.snapshot_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SNAPSHOT146=null;
        Token JOB147=null;
        Token SEMICOLON148=null;
        TOMMY_SQLParser.ddl_table_name_return table_name = null;


        Object SNAPSHOT146_tree=null;
        Object JOB147_tree=null;
        Object SEMICOLON148_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:544:5: ( SNAPSHOT JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:544:7: SNAPSHOT JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SNAPSHOT146=(Token)match(input,SNAPSHOT,FOLLOW_SNAPSHOT_in_snapshot_job_statement2552); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SNAPSHOT146_tree = (Object)adaptor.create(SNAPSHOT146);
            adaptor.addChild(root_0, SNAPSHOT146_tree);
            }
            JOB147=(Token)match(input,JOB,FOLLOW_JOB_in_snapshot_job_statement2554); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB147_tree = (Object)adaptor.create(JOB147);
            adaptor.addChild(root_0, JOB147_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_snapshot_job_statement2558);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON148=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_snapshot_job_statement2560); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON148_tree = (Object)adaptor.create(SEMICOLON148);
            adaptor.addChild(root_0, SEMICOLON148_tree);
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

    // $ANTLR start synpred31_TOMMY_SQL
    public final void synpred31_TOMMY_SQL_fragment() throws RecognitionException {   
        Token n=null;

        // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:9: (n=~ ( '\\r' | '\\n' | ';' ) )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:176:9: n=~ ( '\\r' | '\\n' | ';' )
        {
        n=(Token)input.LT(1);
        if ( (input.LA(1)>=PLUGINS && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=71 && input.LA(1)<=92) ) {
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
    // $ANTLR end synpred31_TOMMY_SQL

    // Delegated rules

    public final boolean synpred31_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_TOMMY_SQL_fragment(); // can never throw exception
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
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA1_eotS =
        "\36\uffff";
    static final String DFA1_eofS =
        "\1\1\35\uffff";
    static final String DFA1_minS =
        "\1\5\2\uffff\1\6\12\uffff\2\17\16\uffff";
    static final String DFA1_maxS =
        "\1\75\2\uffff\1\71\12\uffff\1\23\1\27\16\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\32\1\1\1\uffff\1\3\1\4\1\5\1\6\1\7\1\14\1\15\1\16\1\17"+
        "\1\20\2\uffff\1\31\1\2\1\10\1\11\1\12\1\13\1\23\1\24\1\30\1\21\1"+
        "\22\1\25\1\26\1\27";
    static final String DFA1_specialS =
        "\36\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\1\uffff\1\20\1\15\2\uffff\1\14\1\11\1\13\1\16\6\uffff\1"+
            "\17\1\3\37\uffff\1\12\1\10\2\uffff\1\7\1\6\1\5\1\4",
            "",
            "",
            "\1\21\10\uffff\1\26\1\23\2\uffff\1\27\1\22\2\uffff\1\30\40"+
            "\uffff\1\24\1\25",
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
            "\1\31\3\uffff\1\32",
            "\1\33\3\uffff\1\34\3\uffff\1\35",
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
            return "()+ loopback of 105:7: ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+";
        }
    }
    static final String DFA4_eotS =
        "\u0094\uffff";
    static final String DFA4_eofS =
        "\u0094\uffff";
    static final String DFA4_minS =
        "\2\4\1\uffff\3\4\1\uffff\1\0\5\4\1\0\7\4\1\0\1\4\2\0\5\4\1\0\4\4"+
        "\1\0\1\4\1\0\3\4\1\0\1\4\1\0\10\4\1\0\3\4\1\0\4\4\1\0\2\4\1\0\1"+
        "\4\1\0\4\4\1\0\4\4\1\0\1\4\2\0\1\4\1\0\3\4\3\0\5\4\1\0\5\4\1\0\3"+
        "\4\1\0\2\4\1\0\4\4\1\0\1\4\1\0\1\4\1\0\1\4\1\0\4\4\4\0\5\4\3\0\4"+
        "\4\1\0\1\4\1\0\1\4\1\0\1\4\3\0\1\4";
    static final String DFA4_maxS =
        "\2\134\1\uffff\3\134\1\uffff\1\0\5\134\1\0\7\134\1\0\1\134\2\0\5"+
        "\134\1\0\4\134\1\0\1\134\1\0\3\134\1\0\1\134\1\0\10\134\1\0\3\134"+
        "\1\0\4\134\1\0\2\134\1\0\1\134\1\0\4\134\1\0\4\134\1\0\1\134\2\0"+
        "\1\134\1\0\3\134\3\0\5\134\1\0\5\134\1\0\3\134\1\0\2\134\1\0\4\134"+
        "\1\0\1\134\1\0\1\134\1\0\1\134\1\0\4\134\4\0\5\134\3\0\4\134\1\0"+
        "\1\134\1\0\1\134\1\0\1\134\3\0\1\134";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\u008d\uffff";
    static final String DFA4_specialS =
        "\7\uffff\1\20\5\uffff\1\27\7\uffff\1\7\1\uffff\1\46\1\24\5\uffff"+
        "\1\45\4\uffff\1\0\1\uffff\1\52\3\uffff\1\34\1\uffff\1\53\10\uffff"+
        "\1\40\3\uffff\1\31\4\uffff\1\10\2\uffff\1\15\1\uffff\1\47\4\uffff"+
        "\1\1\4\uffff\1\12\1\uffff\1\41\1\4\1\uffff\1\22\3\uffff\1\23\1\5"+
        "\1\36\5\uffff\1\25\5\uffff\1\21\3\uffff\1\33\2\uffff\1\11\4\uffff"+
        "\1\43\1\uffff\1\35\1\uffff\1\37\1\uffff\1\26\4\uffff\1\6\1\30\1"+
        "\17\1\50\5\uffff\1\3\1\51\1\44\4\uffff\1\13\1\uffff\1\32\1\uffff"+
        "\1\2\1\uffff\1\42\1\16\1\14\1\uffff}>";
    static final String[] DFA4_transitionS = {
            "\6\6\1\1\32\6\1\2\15\6\1\4\1\3\2\6\1\5\15\6\2\uffff\26\6",
            "\6\13\1\7\32\13\1\6\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
            "\26\13",
            "",
            "\6\20\1\14\32\20\1\6\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
            "\26\20",
            "\60\6\1\21\20\6\2\uffff\26\6",
            "\6\26\1\22\32\26\1\6\15\26\1\24\1\23\2\26\1\25\15\26\2\uffff"+
            "\26\26",
            "",
            "\1\uffff",
            "\6\34\1\30\32\34\1\27\15\34\1\32\1\31\2\34\1\33\15\34\2\uffff"+
            "\26\34",
            "\6\13\1\7\32\13\1\27\15\13\1\11\1\35\2\13\1\12\15\13\2\uffff"+
            "\26\13",
            "\6\42\1\36\32\42\1\27\15\42\1\40\1\37\2\42\1\41\15\42\2\uffff"+
            "\26\42",
            "\6\13\1\7\32\13\1\27\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
            "\26\13",
            "\6\50\1\44\32\50\1\43\15\50\1\46\1\45\2\50\1\47\15\50\2\uffff"+
            "\26\50",
            "\1\uffff",
            "\6\20\1\14\32\20\1\43\15\20\1\16\1\51\2\20\1\17\15\20\2\uffff"+
            "\26\20",
            "\6\56\1\52\32\56\1\43\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\26\56",
            "\6\20\1\14\32\20\1\43\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
            "\26\20",
            "\6\63\1\57\32\63\1\6\15\63\1\61\1\60\2\63\1\62\15\63\2\uffff"+
            "\26\63",
            "\6\71\1\65\32\71\1\64\15\71\1\67\1\66\2\71\1\70\15\71\2\uffff"+
            "\26\71",
            "\6\76\1\72\32\76\1\64\15\76\1\74\1\73\2\76\1\75\15\76\2\uffff"+
            "\26\76",
            "\6\26\1\22\32\26\1\64\15\26\1\24\1\77\2\26\1\25\15\26\2\uffff"+
            "\26\26",
            "\1\uffff",
            "\6\26\1\22\32\26\1\64\15\26\1\24\1\23\2\26\1\25\15\26\2\uffff"+
            "\26\26",
            "\1\uffff",
            "\1\uffff",
            "\6\34\1\30\32\34\1\100\15\34\1\32\1\31\2\34\1\33\15\34\2\uffff"+
            "\26\34",
            "\6\34\1\30\32\34\1\100\15\34\1\32\1\101\2\34\1\33\15\34\2\uffff"+
            "\26\34",
            "\6\106\1\102\32\106\1\100\15\106\1\104\1\103\2\106\1\105\15"+
            "\106\2\uffff\26\106",
            "\6\34\1\30\32\34\1\100\15\34\1\32\1\31\2\34\1\33\15\34\2\uffff"+
            "\26\34",
            "\6\113\1\107\32\113\1\27\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\26\113",
            "\1\uffff",
            "\6\106\1\102\32\106\1\114\15\106\1\104\1\103\2\106\1\105\15"+
            "\106\2\uffff\26\106",
            "\6\42\1\36\32\42\1\114\15\42\1\40\1\115\2\42\1\41\15\42\2\uffff"+
            "\26\42",
            "\6\42\1\36\32\42\1\114\15\42\1\40\1\37\2\42\1\41\15\42\2\uffff"+
            "\26\42",
            "\6\42\1\36\32\42\1\114\15\42\1\40\1\37\2\42\1\41\15\42\2\uffff"+
            "\26\42",
            "\1\uffff",
            "\6\50\1\44\32\50\1\116\15\50\1\46\1\45\2\50\1\47\15\50\2\uffff"+
            "\26\50",
            "\1\uffff",
            "\6\50\1\44\32\50\1\116\15\50\1\46\1\117\2\50\1\47\15\50\2\uffff"+
            "\26\50",
            "\6\124\1\120\32\124\1\116\15\124\1\122\1\121\2\124\1\123\15"+
            "\124\2\uffff\26\124",
            "\6\50\1\44\32\50\1\116\15\50\1\46\1\45\2\50\1\47\15\50\2\uffff"+
            "\26\50",
            "\1\uffff",
            "\6\124\1\120\32\124\1\125\15\124\1\122\1\121\2\124\1\123\15"+
            "\124\2\uffff\26\124",
            "\1\uffff",
            "\6\56\1\52\32\56\1\125\15\56\1\54\1\126\2\56\1\55\15\56\2\uffff"+
            "\26\56",
            "\6\56\1\52\32\56\1\125\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\26\56",
            "\6\56\1\52\32\56\1\125\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\26\56",
            "\6\134\1\130\32\134\1\127\15\134\1\132\1\131\2\134\1\133\15"+
            "\134\2\uffff\26\134",
            "\6\63\1\57\32\63\1\127\15\63\1\61\1\60\2\63\1\62\15\63\2\uffff"+
            "\26\63",
            "\6\63\1\57\32\63\1\127\15\63\1\61\1\135\2\63\1\62\15\63\2\uffff"+
            "\26\63",
            "\6\142\1\136\32\142\1\127\15\142\1\140\1\137\2\142\1\141\15"+
            "\142\2\uffff\26\142",
            "\6\63\1\57\32\63\1\127\15\63\1\61\1\60\2\63\1\62\15\63\2\uffff"+
            "\26\63",
            "\1\uffff",
            "\6\71\1\65\32\71\1\143\15\71\1\67\1\66\2\71\1\70\15\71\2\uffff"+
            "\26\71",
            "\6\150\1\144\32\150\1\143\15\150\1\146\1\145\2\150\1\147\15"+
            "\150\2\uffff\26\150",
            "\6\71\1\65\32\71\1\143\15\71\1\67\1\151\2\71\1\70\15\71\2\uffff"+
            "\26\71",
            "\1\uffff",
            "\6\71\1\65\32\71\1\143\15\71\1\67\1\66\2\71\1\70\15\71\2\uffff"+
            "\26\71",
            "\6\150\1\144\32\150\1\152\15\150\1\146\1\145\2\150\1\147\15"+
            "\150\2\uffff\26\150",
            "\6\76\1\72\32\76\1\152\15\76\1\74\1\73\2\76\1\75\15\76\2\uffff"+
            "\26\76",
            "\6\76\1\72\32\76\1\152\15\76\1\74\1\153\2\76\1\75\15\76\2\uffff"+
            "\26\76",
            "\1\uffff",
            "\6\76\1\72\32\76\1\152\15\76\1\74\1\73\2\76\1\75\15\76\2\uffff"+
            "\26\76",
            "\6\160\1\154\32\160\1\64\15\160\1\156\1\155\2\160\1\157\15"+
            "\160\2\uffff\26\160",
            "\1\uffff",
            "\6\113\1\107\32\113\1\100\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\26\113",
            "\1\uffff",
            "\6\106\1\102\32\106\1\161\15\106\1\104\1\103\2\106\1\105\15"+
            "\106\2\uffff\26\106",
            "\6\106\1\102\32\106\1\161\15\106\1\104\1\162\2\106\1\105\15"+
            "\106\2\uffff\26\106",
            "\6\106\1\102\32\106\1\161\15\106\1\104\1\103\2\106\1\105\15"+
            "\106\2\uffff\26\106",
            "\6\106\1\102\32\106\1\161\15\106\1\104\1\103\2\106\1\105\15"+
            "\106\2\uffff\26\106",
            "\1\uffff",
            "\6\113\1\107\32\113\1\163\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\26\113",
            "\6\113\1\107\32\113\1\163\15\113\1\111\1\164\2\113\1\112\15"+
            "\113\2\uffff\26\113",
            "\6\171\1\165\32\171\1\163\15\171\1\167\1\166\2\171\1\170\15"+
            "\171\2\uffff\26\171",
            "\6\113\1\107\32\113\1\163\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\26\113",
            "\1\uffff",
            "\6\171\1\165\32\171\1\114\15\171\1\167\1\166\2\171\1\170\15"+
            "\171\2\uffff\26\171",
            "\1\uffff",
            "\1\uffff",
            "\6\124\1\120\32\124\1\172\15\124\1\122\1\121\2\124\1\123\15"+
            "\124\2\uffff\26\124",
            "\1\uffff",
            "\6\124\1\120\32\124\1\172\15\124\1\122\1\173\2\124\1\123\15"+
            "\124\2\uffff\26\124",
            "\6\124\1\120\32\124\1\172\15\124\1\122\1\121\2\124\1\123\15"+
            "\124\2\uffff\26\124",
            "\6\124\1\120\32\124\1\172\15\124\1\122\1\121\2\124\1\123\15"+
            "\124\2\uffff\26\124",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\6\134\1\130\32\134\1\174\15\134\1\132\1\131\2\134\1\133\15"+
            "\134\2\uffff\26\134",
            "\6\134\1\130\32\134\1\174\15\134\1\132\1\131\2\134\1\133\15"+
            "\134\2\uffff\26\134",
            "\6\134\1\130\32\134\1\174\15\134\1\132\1\175\2\134\1\133\15"+
            "\134\2\uffff\26\134",
            "\6\u0082\1\176\32\u0082\1\174\15\u0082\1\u0080\1\177\2\u0082"+
            "\1\u0081\15\u0082\2\uffff\26\u0082",
            "\6\134\1\130\32\134\1\174\15\134\1\132\1\131\2\134\1\133\15"+
            "\134\2\uffff\26\134",
            "\1\uffff",
            "\6\u0082\1\176\32\u0082\1\u0083\15\u0082\1\u0080\1\177\2\u0082"+
            "\1\u0081\15\u0082\2\uffff\26\u0082",
            "\6\142\1\136\32\142\1\u0083\15\142\1\140\1\137\2\142\1\141"+
            "\15\142\2\uffff\26\142",
            "\6\142\1\136\32\142\1\u0083\15\142\1\140\1\u0084\2\142\1\141"+
            "\15\142\2\uffff\26\142",
            "\6\142\1\136\32\142\1\u0083\15\142\1\140\1\137\2\142\1\141"+
            "\15\142\2\uffff\26\142",
            "\6\142\1\136\32\142\1\u0083\15\142\1\140\1\137\2\142\1\141"+
            "\15\142\2\uffff\26\142",
            "\1\uffff",
            "\6\150\1\144\32\150\1\u0085\15\150\1\146\1\145\2\150\1\147"+
            "\15\150\2\uffff\26\150",
            "\6\150\1\144\32\150\1\u0085\15\150\1\146\1\145\2\150\1\147"+
            "\15\150\2\uffff\26\150",
            "\6\150\1\144\32\150\1\u0085\15\150\1\146\1\u0086\2\150\1\147"+
            "\15\150\2\uffff\26\150",
            "\1\uffff",
            "\6\150\1\144\32\150\1\u0085\15\150\1\146\1\145\2\150\1\147"+
            "\15\150\2\uffff\26\150",
            "\6\u008b\1\u0087\32\u008b\1\143\15\u008b\1\u0089\1\u0088\2"+
            "\u008b\1\u008a\15\u008b\2\uffff\26\u008b",
            "\1\uffff",
            "\6\160\1\154\32\160\1\152\15\160\1\156\1\155\2\160\1\157\15"+
            "\160\2\uffff\26\160",
            "\6\u008b\1\u0087\32\u008b\1\u008c\15\u008b\1\u0089\1\u0088"+
            "\2\u008b\1\u008a\15\u008b\2\uffff\26\u008b",
            "\6\160\1\154\32\160\1\u008c\15\160\1\156\1\155\2\160\1\157"+
            "\15\160\2\uffff\26\160",
            "\6\160\1\154\32\160\1\u008c\15\160\1\156\1\u008d\2\160\1\157"+
            "\15\160\2\uffff\26\160",
            "\1\uffff",
            "\6\160\1\154\32\160\1\u008c\15\160\1\156\1\155\2\160\1\157"+
            "\15\160\2\uffff\26\160",
            "\1\uffff",
            "\6\171\1\165\32\171\1\161\15\171\1\167\1\166\2\171\1\170\15"+
            "\171\2\uffff\26\171",
            "\1\uffff",
            "\6\113\1\107\32\113\1\163\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\26\113",
            "\1\uffff",
            "\6\171\1\165\32\171\1\u008e\15\171\1\167\1\166\2\171\1\170"+
            "\15\171\2\uffff\26\171",
            "\6\171\1\165\32\171\1\u008e\15\171\1\167\1\u008f\2\171\1\170"+
            "\15\171\2\uffff\26\171",
            "\6\171\1\165\32\171\1\u008e\15\171\1\167\1\166\2\171\1\170"+
            "\15\171\2\uffff\26\171",
            "\6\171\1\165\32\171\1\u008e\15\171\1\167\1\166\2\171\1\170"+
            "\15\171\2\uffff\26\171",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\6\u0082\1\176\32\u0082\1\u0090\15\u0082\1\u0080\1\177\2\u0082"+
            "\1\u0081\15\u0082\2\uffff\26\u0082",
            "\6\u0082\1\176\32\u0082\1\u0090\15\u0082\1\u0080\1\177\2\u0082"+
            "\1\u0081\15\u0082\2\uffff\26\u0082",
            "\6\u0082\1\176\32\u0082\1\u0090\15\u0082\1\u0080\1\u0091\2"+
            "\u0082\1\u0081\15\u0082\2\uffff\26\u0082",
            "\6\u0082\1\176\32\u0082\1\u0090\15\u0082\1\u0080\1\177\2\u0082"+
            "\1\u0081\15\u0082\2\uffff\26\u0082",
            "\6\u0082\1\176\32\u0082\1\u0090\15\u0082\1\u0080\1\177\2\u0082"+
            "\1\u0081\15\u0082\2\uffff\26\u0082",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\6\u008b\1\u0087\32\u008b\1\u0085\15\u008b\1\u0089\1\u0088"+
            "\2\u008b\1\u008a\15\u008b\2\uffff\26\u008b",
            "\6\u008b\1\u0087\32\u008b\1\u0092\15\u008b\1\u0089\1\u0088"+
            "\2\u008b\1\u008a\15\u008b\2\uffff\26\u008b",
            "\6\u008b\1\u0087\32\u008b\1\u0092\15\u008b\1\u0089\1\u0088"+
            "\2\u008b\1\u008a\15\u008b\2\uffff\26\u008b",
            "\6\u008b\1\u0087\32\u008b\1\u0092\15\u008b\1\u0089\1\u0093"+
            "\2\u008b\1\u008a\15\u008b\2\uffff\26\u008b",
            "\1\uffff",
            "\6\u008b\1\u0087\32\u008b\1\u0092\15\u008b\1\u0089\1\u0088"+
            "\2\u008b\1\u008a\15\u008b\2\uffff\26\u008b",
            "\1\uffff",
            "\6\160\1\154\32\160\1\u008c\15\160\1\156\1\155\2\160\1\157"+
            "\15\160\2\uffff\26\160",
            "\1\uffff",
            "\6\171\1\165\32\171\1\u008e\15\171\1\167\1\166\2\171\1\170"+
            "\15\171\2\uffff\26\171",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\6\u008b\1\u0087\32\u008b\1\u0092\15\u008b\1\u0089\1\u0088"+
            "\2\u008b\1\u008a\15\u008b\2\uffff\26\u008b"
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
            return "()+ loopback of 176:9: (n=~ ( '\\r' | '\\n' | ';' ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_35 = input.LA(1);

                         
                        int index4_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_35);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_71 = input.LA(1);

                         
                        int index4_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_71);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_142 = input.LA(1);

                         
                        int index4_142 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_142);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_131 = input.LA(1);

                         
                        int index4_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_131);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_79 = input.LA(1);

                         
                        int index4_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_79);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_86 = input.LA(1);

                         
                        int index4_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_86);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_122 = input.LA(1);

                         
                        int index4_122 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_122);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_21 = input.LA(1);

                         
                        int index4_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_21);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_61 = input.LA(1);

                         
                        int index4_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_61);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_106 = input.LA(1);

                         
                        int index4_106 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_106);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_76 = input.LA(1);

                         
                        int index4_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_76);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_138 = input.LA(1);

                         
                        int index4_138 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_138);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_146 = input.LA(1);

                         
                        int index4_146 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_146);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_64 = input.LA(1);

                         
                        int index4_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_64);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_145 = input.LA(1);

                         
                        int index4_145 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_145);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_124 = input.LA(1);

                         
                        int index4_124 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_124);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA4_99 = input.LA(1);

                         
                        int index4_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_99);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA4_81 = input.LA(1);

                         
                        int index4_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_81);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA4_85 = input.LA(1);

                         
                        int index4_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_85);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA4_24 = input.LA(1);

                         
                        int index4_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_24);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA4_93 = input.LA(1);

                         
                        int index4_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_93);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA4_117 = input.LA(1);

                         
                        int index4_117 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_117);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA4_123 = input.LA(1);

                         
                        int index4_123 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_123);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA4_56 = input.LA(1);

                         
                        int index4_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_56);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA4_140 = input.LA(1);

                         
                        int index4_140 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_140);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA4_103 = input.LA(1);

                         
                        int index4_103 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_103);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA4_41 = input.LA(1);

                         
                        int index4_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_41);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA4_113 = input.LA(1);

                         
                        int index4_113 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_113);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA4_87 = input.LA(1);

                         
                        int index4_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_87);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA4_115 = input.LA(1);

                         
                        int index4_115 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_115);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA4_52 = input.LA(1);

                         
                        int index4_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_52);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA4_78 = input.LA(1);

                         
                        int index4_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_78);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA4_144 = input.LA(1);

                         
                        int index4_144 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_144);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA4_111 = input.LA(1);

                         
                        int index4_111 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_111);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA4_133 = input.LA(1);

                         
                        int index4_133 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_133);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA4_30 = input.LA(1);

                         
                        int index4_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_30);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA4_23 = input.LA(1);

                         
                        int index4_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_23);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA4_66 = input.LA(1);

                         
                        int index4_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_66);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA4_125 = input.LA(1);

                         
                        int index4_125 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_125);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA4_132 = input.LA(1);

                         
                        int index4_132 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_132);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA4_37 = input.LA(1);

                         
                        int index4_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_37);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA4_43 = input.LA(1);

                         
                        int index4_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_43);
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
        "\7\uffff";
    static final String DFA9_eofS =
        "\4\uffff\1\5\2\uffff";
    static final String DFA9_minS =
        "\1\45\1\4\1\uffff\2\4\2\uffff";
    static final String DFA9_maxS =
        "\1\64\1\134\1\uffff\1\134\1\75\2\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\3\2\uffff\1\1\1\2";
    static final String DFA9_specialS =
        "\7\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\16\uffff\1\1",
            "\41\3\1\uffff\37\3\2\uffff\26\3",
            "",
            "\41\3\1\4\37\3\2\uffff\26\3",
            "\1\6\1\5\1\uffff\2\5\2\uffff\4\5\6\uffff\2\5\37\uffff\2\5\2"+
            "\uffff\4\5",
            "",
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
            return "226:56: ( VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )";
        }
    }
    static final String DFA10_eotS =
        "\10\uffff";
    static final String DFA10_eofS =
        "\5\uffff\1\6\2\uffff";
    static final String DFA10_minS =
        "\1\45\1\4\2\uffff\2\4\2\uffff";
    static final String DFA10_maxS =
        "\1\64\1\134\2\uffff\1\134\1\75\2\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\4\2\uffff\1\1\1\3";
    static final String DFA10_specialS =
        "\10\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\15\uffff\1\2\1\1",
            "\41\4\1\uffff\37\4\2\uffff\26\4",
            "",
            "",
            "\41\4\1\5\37\4\2\uffff\26\4",
            "\1\7\1\6\1\uffff\2\6\2\uffff\4\6\6\uffff\2\6\37\uffff\2\6\2"+
            "\uffff\4\6",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "241:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | VALUES body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )";
        }
    }
    static final String DFA11_eotS =
        "\14\uffff";
    static final String DFA11_eofS =
        "\4\uffff\1\5\4\uffff\1\12\2\uffff";
    static final String DFA11_minS =
        "\1\45\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\2\uffff";
    static final String DFA11_maxS =
        "\1\67\1\134\1\uffff\1\134\1\75\1\uffff\1\134\1\uffff\1\134\1\75"+
        "\2\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\5\2\uffff\1\1\1\uffff\1\3\2\uffff\1\2\1\4";
    static final String DFA11_specialS =
        "\14\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\21\uffff\1\1",
            "\41\3\1\uffff\37\3\2\uffff\26\3",
            "",
            "\41\3\1\4\37\3\2\uffff\26\3",
            "\1\7\1\5\1\uffff\2\5\1\uffff\1\6\4\5\6\uffff\2\5\37\uffff\2"+
            "\5\2\uffff\4\5",
            "",
            "\41\10\1\uffff\37\10\2\uffff\26\10",
            "",
            "\41\10\1\11\37\10\2\uffff\26\10",
            "\1\13\1\12\1\uffff\2\12\2\uffff\4\12\6\uffff\2\12\37\uffff"+
            "\2\12\2\uffff\4\12",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "256:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 | SET body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body2 WHERE body4= dml_lookup_select_where_body2 PLUGINS body5= dml_lookup_select_where_body2 | SEMICOLON )";
        }
    }
    static final String DFA12_eotS =
        "\7\uffff";
    static final String DFA12_eofS =
        "\4\uffff\1\5\2\uffff";
    static final String DFA12_minS =
        "\1\12\1\4\1\uffff\2\4\2\uffff";
    static final String DFA12_maxS =
        "\1\45\1\134\1\uffff\1\134\1\75\2\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\3\2\uffff\1\1\1\2";
    static final String DFA12_specialS =
        "\7\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\32\uffff\1\2",
            "\41\3\1\uffff\37\3\2\uffff\26\3",
            "",
            "\41\3\1\4\37\3\2\uffff\26\3",
            "\1\6\1\5\1\uffff\2\5\2\uffff\4\5\6\uffff\2\5\37\uffff\2\5\2"+
            "\uffff\4\5",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "271:56: ( WHERE body2= dml_lookup_select_where_body2 | WHERE body2= dml_lookup_select_where_body2 PLUGINS body3= dml_lookup_select_where_body2 | SEMICOLON )";
        }
    }
 

    public static final BitSet FOLLOW_rest_statement_in_create_statement615 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_system_statement_in_create_statement617 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_commit_statement_in_create_statement619 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_use_statement_in_create_statement621 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_snapshot_job_statement_in_create_statement623 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_kill_job_statement_in_create_statement625 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_set_statement_in_create_statement627 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_sources_statement_in_create_statement629 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_streams_statement_in_create_statement631 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_cluster_statement_in_create_statement633 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_jobs_statement_in_create_statement635 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_insert_statement_in_create_statement637 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_update_statement_in_create_statement639 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_upsert_statement_in_create_statement641 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_lookup_statement_in_create_statement643 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_select_statement_in_create_statement645 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_create_stream_statement_in_create_statement647 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_create_source_statement_in_create_statement649 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_stream_statement_in_create_statement651 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_source_statement_in_create_statement653 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_drop_stream_statement_in_create_statement655 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_drop_source_statement_in_create_statement657 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_drop_job_statement_in_create_statement659 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_show_job_statement_in_create_statement661 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_delete_statement_in_create_statement663 = new BitSet(new long[]{0x3CC00000006079A2L});
    public static final BitSet FOLLOW_NAME_in_use_name_def697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_use_statement716 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_use_statement720 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_use_statement722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_name_def754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_value_def782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_set_statement802 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_set_statement806 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_EQUAL_in_set_statement808 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement810 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_set_value_def_in_set_statement814 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement816 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_set_statement818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_table_name848 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name852 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_table_name854 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name858 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_table_name860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_bind_column_name887 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_bind_column_name889 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_bind_column_name891 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_bind_column_name893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where920 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where923 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body953 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body956 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body985 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF2L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body21021 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup_statement1052 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_lookup_statement1058 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_WHERE_in_lookup_statement1061 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_lookup_statement1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement1093 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_select_statement1099 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_WHERE_in_select_statement1102 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_select_statement1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_select_statement1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REST_in_rest_statement1134 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_INTO_in_rest_statement1136 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_rest_statement1142 = new BitSet(new long[]{0x0010002000000000L});
    public static final BitSet FOLLOW_VALUES_in_rest_statement1145 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_rest_statement1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_rest_statement1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSERT_in_insert_statement1177 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_INTO_in_insert_statement1179 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_insert_statement1185 = new BitSet(new long[]{0x0010002000000000L});
    public static final BitSet FOLLOW_VALUES_in_insert_statement1188 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_insert_statement1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUES_in_insert_statement1196 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_insert_statement1202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PLUGINS_in_insert_statement1204 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_insert_statement1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_insert_statement1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPSERT_in_upsert_statement1236 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_INTO_in_upsert_statement1238 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_upsert_statement1244 = new BitSet(new long[]{0x0018002000000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1247 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCREASE_in_upsert_statement1255 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1257 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1265 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PLUGINS_in_upsert_statement1273 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_upsert_statement1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_update_statement1305 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1311 = new BitSet(new long[]{0x0080002000000000L});
    public static final BitSet FOLLOW_SET_in_update_statement1314 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_update_statement1324 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1330 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_WHERE_in_update_statement1332 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_update_statement1338 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1344 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PLUGINS_in_update_statement1346 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_update_statement1354 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1360 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_WHERE_in_update_statement1362 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PLUGINS_in_update_statement1368 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_update_statement1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_delete_statement1400 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_FROM_in_delete_statement1402 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_delete_statement1408 = new BitSet(new long[]{0x0000002000000400L});
    public static final BitSet FOLLOW_WHERE_in_delete_statement1411 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_delete_statement1419 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_PLUGINS_in_delete_statement1427 = new BitSet(new long[]{0xFFFFFFDFFFFFFFF0L,0x000000001FFFFF9FL});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_delete_statement1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_table_name1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ddl_column_pk1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1525 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_comment1529 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_name1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ddl_column_type1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1630 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_column_defs1635 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1641 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ddl_column_name_in_column_def1671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001F00L});
    public static final BitSet FOLLOW_ddl_column_type_in_column_def1675 = new BitSet(new long[]{0x0000000400000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_ddl_column_pk_in_column_def1680 = new BitSet(new long[]{0x0000000400000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_ddl_column_comment_in_column_def1687 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_set_in_stream_meta_name1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1760 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_NAME_in_stream_meta_value1764 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_name_in_stream_meta_def1793 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_stream_meta_value_in_stream_meta_def1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1850 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_stream_meta_defs1855 = new BitSet(new long[]{0x0000000000000000L,0x000000000003E000L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1861 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_stream_statement1888 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STREAM_in_create_stream_statement1890 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_stream_statement1894 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1904 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_column_defs_in_create_stream_statement1908 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1910 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_META_in_create_stream_statement1912 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1914 = new BitSet(new long[]{0x0000000000000000L,0x000000000003E000L});
    public static final BitSet FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1918 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1920 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_stream_statement1922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_stream_statement1945 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STREAM_in_drop_stream_statement1947 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_stream_statement1951 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_stream_statement1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_stream_statement1976 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_STREAM_in_show_stream_statement1978 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_stream_statement1982 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_stream_statement1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_streams_statement2007 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STREAMS_in_show_streams_statement2009 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_streams_statement2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KILL_in_kill_job_statement2034 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_JOB_in_kill_job_statement2036 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_kill_job_statement2040 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_kill_job_statement2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMIT_in_commit_statement2065 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_commit_statement2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_source_meta_name2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value2144 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_NAME_in_source_meta_value2148 = new BitSet(new long[]{0x4000004400000000L});
    public static final BitSet FOLLOW_set_in_source_meta_value2150 = new BitSet(new long[]{0x4000004400000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_name_in_source_meta_def2184 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_source_meta_value_in_source_meta_def2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2241 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_source_meta_defs2246 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFC2000L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2252 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_source_statement2279 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_SOURCE_in_create_source_statement2281 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_source_statement2285 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_META_in_create_source_statement2287 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_LPAREN_in_create_source_statement2289 = new BitSet(new long[]{0x0000000000000000L,0x000000001FFC2000L});
    public static final BitSet FOLLOW_ddl_source_meta_defs_in_create_source_statement2293 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_create_source_statement2295 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_source_statement2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_source_statement2320 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_SOURCE_in_drop_source_statement2322 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_source_statement2326 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_source_statement2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_source_statement2351 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_SOURCE_in_show_source_statement2353 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_source_statement2357 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_source_statement2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_sources_statement2382 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SOURCES_in_show_sources_statement2384 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_sources_statement2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_job_statement2409 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_JOB_in_drop_job_statement2411 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_job_statement2415 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_job_statement2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_job_statement2440 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_JOB_in_show_job_statement2442 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_job_statement2446 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_job_statement2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_jobs_statement2471 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_JOBS_in_show_jobs_statement2473 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_jobs_statement2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_cluster_statement2498 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_CLUSTER_in_show_cluster_statement2500 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_cluster_statement2502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_system_statement2525 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_SYSTEM_in_show_system_statement2527 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_system_statement2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SNAPSHOT_in_snapshot_job_statement2552 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_JOB_in_snapshot_job_statement2554 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_snapshot_job_statement2558 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_snapshot_job_statement2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred31_TOMMY_SQL985 = new BitSet(new long[]{0x0000000000000002L});

}