// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/core/TOMMY_SQL.g 2015-07-22 14:28:07

    package org.tommy.stationery.ink.core;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.tommy.stationery.ink.core.parser.QueryParser;
import org.tommy.stationery.ink.domain.*;
import org.tommy.stationery.ink.enums.ColumnDataTypeEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class TOMMY_SQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SYSTEM", "DELETE", "SELECT", "FROM", "WHERE", "LOOKUP", "INSERT", "UPSERT", "CREATE", "STREAM", "STREAMS", "BSTREAM", "BUCKET", "SOURCE", "SOURCES", "DROP", "SHOW", "JOB", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURLY", "RCURLY", "LBLE", "RBLE", "QUESTION", "EXCLAMATION", "SINGLE_QUOTE", "DOUBLE_QUOTE", "UNDERLINE", "SEMICOLON", "COMMA", "COMM", "COLON", "META", "AND", "OR", "PLUS", "MINUS", "MULTI", "DIV", "MOD", "ANDMARK", "EQUAL", "INCREASE", "VALUES", "INTO", "UPDATE", "SET", "CLUSTER", "JOBS", "KILL", "SNAPSHOT", "USE", "COMMIT", "NAME", "WHITESPACE", "WS", "UNICODE_LETTER", "UNICODE_DIGIT", "LETTER", "DIGIT", "'\\r'", "'\\n'", "'PARTITION_KEY'", "'STRING'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'TOPIC'", "'COMMENT'", "'CATALOG'", "'URL'", "'DRIVER'", "'ID'", "'PW'", "'VHOST'", "'PORT'", "'CLUSTER'", "'INITIALPOOLSIZE'", "'MAXPOOLSIZE'", "'MINPOOLSIZE'"
    };
    public static final int EOF=-1;
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
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int SYSTEM=4;
    public static final int DELETE=5;
    public static final int SELECT=6;
    public static final int FROM=7;
    public static final int WHERE=8;
    public static final int LOOKUP=9;
    public static final int INSERT=10;
    public static final int UPSERT=11;
    public static final int CREATE=12;
    public static final int STREAM=13;
    public static final int STREAMS=14;
    public static final int BSTREAM=15;
    public static final int BUCKET=16;
    public static final int SOURCE=17;
    public static final int SOURCES=18;
    public static final int DROP=19;
    public static final int SHOW=20;
    public static final int JOB=21;
    public static final int LPAREN=22;
    public static final int RPAREN=23;
    public static final int LSQUARE=24;
    public static final int RSQUARE=25;
    public static final int LCURLY=26;
    public static final int RCURLY=27;
    public static final int LBLE=28;
    public static final int RBLE=29;
    public static final int QUESTION=30;
    public static final int EXCLAMATION=31;
    public static final int SINGLE_QUOTE=32;
    public static final int DOUBLE_QUOTE=33;
    public static final int UNDERLINE=34;
    public static final int SEMICOLON=35;
    public static final int COMMA=36;
    public static final int COMM=37;
    public static final int COLON=38;
    public static final int META=39;
    public static final int AND=40;
    public static final int OR=41;
    public static final int PLUS=42;
    public static final int MINUS=43;
    public static final int MULTI=44;
    public static final int DIV=45;
    public static final int MOD=46;
    public static final int ANDMARK=47;
    public static final int EQUAL=48;
    public static final int INCREASE=49;
    public static final int VALUES=50;
    public static final int INTO=51;
    public static final int UPDATE=52;
    public static final int SET=53;
    public static final int CLUSTER=54;
    public static final int JOBS=55;
    public static final int KILL=56;
    public static final int SNAPSHOT=57;
    public static final int USE=58;
    public static final int COMMIT=59;
    public static final int NAME=60;
    public static final int WHITESPACE=61;
    public static final int WS=62;
    public static final int UNICODE_LETTER=63;
    public static final int UNICODE_DIGIT=64;
    public static final int LETTER=65;
    public static final int DIGIT=66;

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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:1: create_statement : ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ ;
    public final create_statement_return create_statement() throws RecognitionException {
        create_statement_return retval = new create_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        show_system_statement_return show_system_statement1 = null;

        commit_statement_return commit_statement2 = null;

        use_statement_return use_statement3 = null;

        snapshot_job_statement_return snapshot_job_statement4 = null;

        kill_job_statement_return kill_job_statement5 = null;

        set_statement_return set_statement6 = null;

        show_sources_statement_return show_sources_statement7 = null;

        show_streams_statement_return show_streams_statement8 = null;

        show_cluster_statement_return show_cluster_statement9 = null;

        show_jobs_statement_return show_jobs_statement10 = null;

        insert_statement_return insert_statement11 = null;

        update_statement_return update_statement12 = null;

        upsert_statement_return upsert_statement13 = null;

        lookup_statement_return lookup_statement14 = null;

        select_statement_return select_statement15 = null;

        create_stream_statement_return create_stream_statement16 = null;

        create_source_statement_return create_source_statement17 = null;

        show_stream_statement_return show_stream_statement18 = null;

        show_source_statement_return show_source_statement19 = null;

        drop_stream_statement_return drop_stream_statement20 = null;

        drop_source_statement_return drop_source_statement21 = null;

        drop_job_statement_return drop_job_statement22 = null;

        show_job_statement_return show_job_statement23 = null;

        delete_statement_return delete_statement24 = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:5: ( ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:7: ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:7: ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=25;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:8: show_system_statement
            	    {
            	    pushFollow(FOLLOW_show_system_statement_in_create_statement597);
            	    show_system_statement1=show_system_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_system_statement1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:30: commit_statement
            	    {
            	    pushFollow(FOLLOW_commit_statement_in_create_statement599);
            	    commit_statement2=commit_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, commit_statement2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:47: use_statement
            	    {
            	    pushFollow(FOLLOW_use_statement_in_create_statement601);
            	    use_statement3=use_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, use_statement3.getTree());

            	    }
            	    break;
            	case 4 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:61: snapshot_job_statement
            	    {
            	    pushFollow(FOLLOW_snapshot_job_statement_in_create_statement603);
            	    snapshot_job_statement4=snapshot_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, snapshot_job_statement4.getTree());

            	    }
            	    break;
            	case 5 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:84: kill_job_statement
            	    {
            	    pushFollow(FOLLOW_kill_job_statement_in_create_statement605);
            	    kill_job_statement5=kill_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, kill_job_statement5.getTree());

            	    }
            	    break;
            	case 6 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:103: set_statement
            	    {
            	    pushFollow(FOLLOW_set_statement_in_create_statement607);
            	    set_statement6=set_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, set_statement6.getTree());

            	    }
            	    break;
            	case 7 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:117: show_sources_statement
            	    {
            	    pushFollow(FOLLOW_show_sources_statement_in_create_statement609);
            	    show_sources_statement7=show_sources_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_sources_statement7.getTree());

            	    }
            	    break;
            	case 8 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:140: show_streams_statement
            	    {
            	    pushFollow(FOLLOW_show_streams_statement_in_create_statement611);
            	    show_streams_statement8=show_streams_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_streams_statement8.getTree());

            	    }
            	    break;
            	case 9 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:163: show_cluster_statement
            	    {
            	    pushFollow(FOLLOW_show_cluster_statement_in_create_statement613);
            	    show_cluster_statement9=show_cluster_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_cluster_statement9.getTree());

            	    }
            	    break;
            	case 10 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:186: show_jobs_statement
            	    {
            	    pushFollow(FOLLOW_show_jobs_statement_in_create_statement615);
            	    show_jobs_statement10=show_jobs_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_jobs_statement10.getTree());

            	    }
            	    break;
            	case 11 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:206: insert_statement
            	    {
            	    pushFollow(FOLLOW_insert_statement_in_create_statement617);
            	    insert_statement11=insert_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, insert_statement11.getTree());

            	    }
            	    break;
            	case 12 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:223: update_statement
            	    {
            	    pushFollow(FOLLOW_update_statement_in_create_statement619);
            	    update_statement12=update_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, update_statement12.getTree());

            	    }
            	    break;
            	case 13 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:240: upsert_statement
            	    {
            	    pushFollow(FOLLOW_upsert_statement_in_create_statement621);
            	    upsert_statement13=upsert_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, upsert_statement13.getTree());

            	    }
            	    break;
            	case 14 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:257: lookup_statement
            	    {
            	    pushFollow(FOLLOW_lookup_statement_in_create_statement623);
            	    lookup_statement14=lookup_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lookup_statement14.getTree());

            	    }
            	    break;
            	case 15 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:274: select_statement
            	    {
            	    pushFollow(FOLLOW_select_statement_in_create_statement625);
            	    select_statement15=select_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement15.getTree());

            	    }
            	    break;
            	case 16 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:291: create_stream_statement
            	    {
            	    pushFollow(FOLLOW_create_stream_statement_in_create_statement627);
            	    create_stream_statement16=create_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_stream_statement16.getTree());

            	    }
            	    break;
            	case 17 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:315: create_source_statement
            	    {
            	    pushFollow(FOLLOW_create_source_statement_in_create_statement629);
            	    create_source_statement17=create_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_source_statement17.getTree());

            	    }
            	    break;
            	case 18 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:339: show_stream_statement
            	    {
            	    pushFollow(FOLLOW_show_stream_statement_in_create_statement631);
            	    show_stream_statement18=show_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_stream_statement18.getTree());

            	    }
            	    break;
            	case 19 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:361: show_source_statement
            	    {
            	    pushFollow(FOLLOW_show_source_statement_in_create_statement633);
            	    show_source_statement19=show_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_source_statement19.getTree());

            	    }
            	    break;
            	case 20 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:383: drop_stream_statement
            	    {
            	    pushFollow(FOLLOW_drop_stream_statement_in_create_statement635);
            	    drop_stream_statement20=drop_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_stream_statement20.getTree());

            	    }
            	    break;
            	case 21 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:405: drop_source_statement
            	    {
            	    pushFollow(FOLLOW_drop_source_statement_in_create_statement637);
            	    drop_source_statement21=drop_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_source_statement21.getTree());

            	    }
            	    break;
            	case 22 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:427: drop_job_statement
            	    {
            	    pushFollow(FOLLOW_drop_job_statement_in_create_statement639);
            	    drop_job_statement22=drop_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_job_statement22.getTree());

            	    }
            	    break;
            	case 23 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:446: show_job_statement
            	    {
            	    pushFollow(FOLLOW_show_job_statement_in_create_statement641);
            	    show_job_statement23=show_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_job_statement23.getTree());

            	    }
            	    break;
            	case 24 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:465: delete_statement
            	    {
            	    pushFollow(FOLLOW_delete_statement_in_create_statement643);
            	    delete_statement24=delete_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, delete_statement24.getTree());

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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:110:1: use_name_def returns [String ret] : n= NAME ;
    public final use_name_def_return use_name_def() throws RecognitionException {
        use_name_def_return retval = new use_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:111:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:111:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_use_name_def677); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:114:1: use_statement : USE column= set_name_def SEMICOLON ;
    public final use_statement_return use_statement() throws RecognitionException {
        use_statement_return retval = new use_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token USE25=null;
        Token SEMICOLON26=null;
        set_name_def_return column = null;


        Object USE25_tree=null;
        Object SEMICOLON26_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:115:5: ( USE column= set_name_def SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:115:7: USE column= set_name_def SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            USE25=(Token)match(input,USE,FOLLOW_USE_in_use_statement696); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USE25_tree = (Object)adaptor.create(USE25);
            adaptor.addChild(root_0, USE25_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_use_statement700);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            SEMICOLON26=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_use_statement702); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON26_tree = (Object)adaptor.create(SEMICOLON26);
            adaptor.addChild(root_0, SEMICOLON26_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:128:1: set_name_def returns [String ret] : n= NAME ;
    public final set_name_def_return set_name_def() throws RecognitionException {
        set_name_def_return retval = new set_name_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:129:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:129:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_name_def734); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:132:1: set_value_def returns [String ret] : n= NAME ;
    public final set_value_def_return set_value_def() throws RecognitionException {
        set_value_def_return retval = new set_value_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:133:6: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:133:10: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_value_def762); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:136:1: set_statement : SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON ;
    public final set_statement_return set_statement() throws RecognitionException {
        set_statement_return retval = new set_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SET27=null;
        Token EQUAL28=null;
        Token SINGLE_QUOTE29=null;
        Token SINGLE_QUOTE30=null;
        Token SEMICOLON31=null;
        set_name_def_return column = null;

        set_value_def_return value = null;


        Object SET27_tree=null;
        Object EQUAL28_tree=null;
        Object SINGLE_QUOTE29_tree=null;
        Object SINGLE_QUOTE30_tree=null;
        Object SEMICOLON31_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:137:5: ( SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:137:7: SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SET27=(Token)match(input,SET,FOLLOW_SET_in_set_statement782); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SET27_tree = (Object)adaptor.create(SET27);
            adaptor.addChild(root_0, SET27_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_set_statement786);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            EQUAL28=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_set_statement788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQUAL28_tree = (Object)adaptor.create(EQUAL28);
            adaptor.addChild(root_0, EQUAL28_tree);
            }
            SINGLE_QUOTE29=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement790); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE29_tree = (Object)adaptor.create(SINGLE_QUOTE29);
            adaptor.addChild(root_0, SINGLE_QUOTE29_tree);
            }
            pushFollow(FOLLOW_set_value_def_in_set_statement794);
            value=set_value_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, value.getTree());
            SINGLE_QUOTE30=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement796); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE30_tree = (Object)adaptor.create(SINGLE_QUOTE30);
            adaptor.addChild(root_0, SINGLE_QUOTE30_tree);
            }
            SEMICOLON31=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_set_statement798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON31_tree = (Object)adaptor.create(SEMICOLON31);
            adaptor.addChild(root_0, SEMICOLON31_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:151:1: dml_table_name returns [BaseTableDef ret] : LSQUARE n= NAME COLON b= NAME RSQUARE ;
    public final dml_table_name_return dml_table_name() throws RecognitionException {
        dml_table_name_return retval = new dml_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token b=null;
        Token LSQUARE32=null;
        Token COLON33=null;
        Token RSQUARE34=null;

        Object n_tree=null;
        Object b_tree=null;
        Object LSQUARE32_tree=null;
        Object COLON33_tree=null;
        Object RSQUARE34_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:152:5: ( LSQUARE n= NAME COLON b= NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:152:9: LSQUARE n= NAME COLON b= NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            LSQUARE32=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_table_name828); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LSQUARE32_tree = (Object)adaptor.create(LSQUARE32);
            adaptor.addChild(root_0, LSQUARE32_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name832); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON33=(Token)match(input,COLON,FOLLOW_COLON_in_dml_table_name834); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON33_tree = (Object)adaptor.create(COLON33);
            adaptor.addChild(root_0, COLON33_tree);
            }
            b=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name838); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (Object)adaptor.create(b);
            adaptor.addChild(root_0, b_tree);
            }
            RSQUARE34=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_table_name840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE34_tree = (Object)adaptor.create(RSQUARE34);
            adaptor.addChild(root_0, RSQUARE34_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:160:1: dml_bind_column_name returns [String ret] : n= LSQUARE COLON NAME RSQUARE ;
    public final dml_bind_column_name_return dml_bind_column_name() throws RecognitionException {
        dml_bind_column_name_return retval = new dml_bind_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token COLON35=null;
        Token NAME36=null;
        Token RSQUARE37=null;

        Object n_tree=null;
        Object COLON35_tree=null;
        Object NAME36_tree=null;
        Object RSQUARE37_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:161:5: (n= LSQUARE COLON NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:161:9: n= LSQUARE COLON NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_bind_column_name867); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON35=(Token)match(input,COLON,FOLLOW_COLON_in_dml_bind_column_name869); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON35_tree = (Object)adaptor.create(COLON35);
            adaptor.addChild(root_0, COLON35_tree);
            }
            NAME36=(Token)match(input,NAME,FOLLOW_NAME_in_dml_bind_column_name871); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME36_tree = (Object)adaptor.create(NAME36);
            adaptor.addChild(root_0, NAME36_tree);
            }
            RSQUARE37=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_bind_column_name873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE37_tree = (Object)adaptor.create(RSQUARE37);
            adaptor.addChild(root_0, RSQUARE37_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:165:1: dml_lookup_where returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final dml_lookup_where_return dml_lookup_where() throws RecognitionException {
        dml_lookup_where_return retval = new dml_lookup_where_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME38=null;
        Token NAME39=null;

        Object n_tree=null;
        Object NAME38_tree=null;
        Object NAME39_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:11: NAME ( NAME )*
            {
            NAME38=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where900); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME38_tree = (Object)adaptor.create(NAME38);
            adaptor.addChild(root_0, NAME38_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:16: ( NAME )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:17: NAME
            	    {
            	    NAME39=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where903); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME39_tree = (Object)adaptor.create(NAME39);
            	    adaptor.addChild(root_0, NAME39_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:169:1: dml_select_body returns [String ret] : n= ( NAME ( NAME )* ) ;
    public final dml_select_body_return dml_select_body() throws RecognitionException {
        dml_select_body_return retval = new dml_select_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token NAME40=null;
        Token NAME41=null;

        Object n_tree=null;
        Object NAME40_tree=null;
        Object NAME41_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:11: NAME ( NAME )*
            {
            NAME40=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body933); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME40_tree = (Object)adaptor.create(NAME40);
            adaptor.addChild(root_0, NAME40_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:16: ( NAME )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:17: NAME
            	    {
            	    NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body936); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME41_tree = (Object)adaptor.create(NAME41);
            	    adaptor.addChild(root_0, NAME41_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:173:1: dml_lookup_select_where_body returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ ;
    public final dml_lookup_select_where_body_return dml_lookup_select_where_body() throws RecognitionException {
        dml_lookup_select_where_body_return retval = new dml_lookup_select_where_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:174:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:174:8: (n=~ ( '\\r' | '\\n' | ';' ) )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:174:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
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
            	    if ( (input.LA(1)>=SYSTEM && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=69 && input.LA(1)<=86) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:177:1: dml_lookup_select_where_body2 returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON ;
    public final dml_lookup_select_where_body2_return dml_lookup_select_where_body2() throws RecognitionException {
        dml_lookup_select_where_body2_return retval = new dml_lookup_select_where_body2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SEMICOLON42=null;

        Object n_tree=null;
        Object SEMICOLON42_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:178:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:178:8: (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:178:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
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
                case 83:
                case 84:
                case 85:
                case 86:
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
            	    if ( (input.LA(1)>=SYSTEM && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=69 && input.LA(1)<=86) ) {
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

            SEMICOLON42=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21013); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON42_tree = (Object)adaptor.create(SEMICOLON42);
            adaptor.addChild(root_0, SEMICOLON42_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:181:1: lookup_statement : LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final lookup_statement_return lookup_statement() throws RecognitionException {
        lookup_statement_return retval = new lookup_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOOKUP43=null;
        Token WHERE44=null;
        Token SEMICOLON45=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object LOOKUP43_tree=null;
        Object WHERE44_tree=null;
        Object SEMICOLON45_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:5: ( LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:7: LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            LOOKUP43=(Token)match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup_statement1032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOOKUP43_tree = (Object)adaptor.create(LOOKUP43);
            adaptor.addChild(root_0, LOOKUP43_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_lookup_statement1038);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE44=(Token)match(input,WHERE,FOLLOW_WHERE_in_lookup_statement1041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE44_tree = (Object)adaptor.create(WHERE44);
                    adaptor.addChild(root_0, WHERE44_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1047);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:96: SEMICOLON
                    {
                    SEMICOLON45=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lookup_statement1049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON45_tree = (Object)adaptor.create(SEMICOLON45);
                    adaptor.addChild(root_0, SEMICOLON45_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:194:1: select_statement : SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final select_statement_return select_statement() throws RecognitionException {
        select_statement_return retval = new select_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SELECT46=null;
        Token WHERE47=null;
        Token SEMICOLON48=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object SELECT46_tree=null;
        Object WHERE47_tree=null;
        Object SEMICOLON48_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:5: ( SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:7: SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            SELECT46=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_statement1073); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SELECT46_tree = (Object)adaptor.create(SELECT46);
            adaptor.addChild(root_0, SELECT46_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_select_statement1079);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:52: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE47=(Token)match(input,WHERE,FOLLOW_WHERE_in_select_statement1082); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE47_tree = (Object)adaptor.create(WHERE47);
                    adaptor.addChild(root_0, WHERE47_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_select_statement1088);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:96: SEMICOLON
                    {
                    SEMICOLON48=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_select_statement1090); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON48_tree = (Object)adaptor.create(SEMICOLON48);
                    adaptor.addChild(root_0, SEMICOLON48_tree);
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

    public static class insert_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "insert_statement"
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:207:1: insert_statement : INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final insert_statement_return insert_statement() throws RecognitionException {
        insert_statement_return retval = new insert_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INSERT49=null;
        Token INTO50=null;
        Token VALUES51=null;
        Token INCREASE52=null;
        Token VALUES53=null;
        Token SEMICOLON54=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object INSERT49_tree=null;
        Object INTO50_tree=null;
        Object VALUES51_tree=null;
        Object INCREASE52_tree=null;
        Object VALUES53_tree=null;
        Object SEMICOLON54_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:5: ( INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:7: INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            INSERT49=(Token)match(input,INSERT,FOLLOW_INSERT_in_insert_statement1113); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INSERT49_tree = (Object)adaptor.create(INSERT49);
            adaptor.addChild(root_0, INSERT49_tree);
            }
            INTO50=(Token)match(input,INTO,FOLLOW_INTO_in_insert_statement1115); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO50_tree = (Object)adaptor.create(INTO50);
            adaptor.addChild(root_0, INTO50_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_insert_statement1121);
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
                    VALUES51=(Token)match(input,VALUES,FOLLOW_VALUES_in_insert_statement1124); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES51_tree = (Object)adaptor.create(VALUES51);
                    adaptor.addChild(root_0, VALUES51_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_insert_statement1130);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:102: INCREASE VALUES body2= dml_lookup_select_where_body2
                    {
                    INCREASE52=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_insert_statement1132); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INCREASE52_tree = (Object)adaptor.create(INCREASE52);
                    adaptor.addChild(root_0, INCREASE52_tree);
                    }
                    VALUES53=(Token)match(input,VALUES,FOLLOW_VALUES_in_insert_statement1134); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES53_tree = (Object)adaptor.create(VALUES53);
                    adaptor.addChild(root_0, VALUES53_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_insert_statement1140);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:156: SEMICOLON
                    {
                    SEMICOLON54=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_insert_statement1142); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON54_tree = (Object)adaptor.create(SEMICOLON54);
                    adaptor.addChild(root_0, SEMICOLON54_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:222:1: upsert_statement : UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final upsert_statement_return upsert_statement() throws RecognitionException {
        upsert_statement_return retval = new upsert_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPSERT55=null;
        Token INTO56=null;
        Token VALUES57=null;
        Token INCREASE58=null;
        Token VALUES59=null;
        Token SEMICOLON60=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object UPSERT55_tree=null;
        Object INTO56_tree=null;
        Object VALUES57_tree=null;
        Object INCREASE58_tree=null;
        Object VALUES59_tree=null;
        Object SEMICOLON60_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:5: ( UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:7: UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPSERT55=(Token)match(input,UPSERT,FOLLOW_UPSERT_in_upsert_statement1166); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPSERT55_tree = (Object)adaptor.create(UPSERT55);
            adaptor.addChild(root_0, UPSERT55_tree);
            }
            INTO56=(Token)match(input,INTO,FOLLOW_INTO_in_upsert_statement1168); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO56_tree = (Object)adaptor.create(INTO56);
            adaptor.addChild(root_0, INTO56_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_upsert_statement1174);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            int alt9=3;
            switch ( input.LA(1) ) {
            case VALUES:
                {
                alt9=1;
                }
                break;
            case INCREASE:
                {
                alt9=2;
                }
                break;
            case SEMICOLON:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:57: VALUES body2= dml_lookup_select_where_body2
                    {
                    VALUES57=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES57_tree = (Object)adaptor.create(VALUES57);
                    adaptor.addChild(root_0, VALUES57_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1183);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:102: INCREASE VALUES body2= dml_lookup_select_where_body2
                    {
                    INCREASE58=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_upsert_statement1185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INCREASE58_tree = (Object)adaptor.create(INCREASE58);
                    adaptor.addChild(root_0, INCREASE58_tree);
                    }
                    VALUES59=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES59_tree = (Object)adaptor.create(VALUES59);
                    adaptor.addChild(root_0, VALUES59_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1193);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:156: SEMICOLON
                    {
                    SEMICOLON60=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_upsert_statement1195); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:237:1: update_statement : UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final update_statement_return update_statement() throws RecognitionException {
        update_statement_return retval = new update_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPDATE61=null;
        Token SET62=null;
        Token SET63=null;
        Token WHERE64=null;
        Token SEMICOLON65=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;

        dml_lookup_select_where_body_return body3 = null;

        dml_lookup_select_where_body2_return body4 = null;


        Object UPDATE61_tree=null;
        Object SET62_tree=null;
        Object SET63_tree=null;
        Object WHERE64_tree=null;
        Object SEMICOLON65_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:5: ( UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:7: UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPDATE61=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_update_statement1219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPDATE61_tree = (Object)adaptor.create(UPDATE61);
            adaptor.addChild(root_0, UPDATE61_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1225);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:52: SET body2= dml_lookup_select_where_body2
                    {
                    SET62=(Token)match(input,SET,FOLLOW_SET_in_update_statement1228); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET62_tree = (Object)adaptor.create(SET62);
                    adaptor.addChild(root_0, SET62_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1234);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
                    {
                    SET63=(Token)match(input,SET,FOLLOW_SET_in_update_statement1238); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET63_tree = (Object)adaptor.create(SET63);
                    adaptor.addChild(root_0, SET63_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1244);
                    body3=dml_lookup_select_where_body();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());
                    WHERE64=(Token)match(input,WHERE,FOLLOW_WHERE_in_update_statement1246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE64_tree = (Object)adaptor.create(WHERE64);
                    adaptor.addChild(root_0, WHERE64_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1250);
                    body4=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body4.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:179: SEMICOLON
                    {
                    SEMICOLON65=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_update_statement1252); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON65_tree = (Object)adaptor.create(SEMICOLON65);
                    adaptor.addChild(root_0, SEMICOLON65_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:252:1: delete_statement : DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final delete_statement_return delete_statement() throws RecognitionException {
        delete_statement_return retval = new delete_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DELETE66=null;
        Token FROM67=null;
        Token WHERE68=null;
        Token SEMICOLON69=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object DELETE66_tree=null;
        Object FROM67_tree=null;
        Object WHERE68_tree=null;
        Object SEMICOLON69_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:253:5: ( DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:253:7: DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            DELETE66=(Token)match(input,DELETE,FOLLOW_DELETE_in_delete_statement1276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DELETE66_tree = (Object)adaptor.create(DELETE66);
            adaptor.addChild(root_0, DELETE66_tree);
            }
            FROM67=(Token)match(input,FROM,FOLLOW_FROM_in_delete_statement1278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FROM67_tree = (Object)adaptor.create(FROM67);
            adaptor.addChild(root_0, FROM67_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_delete_statement1284);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:253:56: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            int alt11=2;
            switch ( input.LA(1) ) {
            case WHERE:
                {
                alt11=1;
                }
                break;
            case SEMICOLON:
                {
                alt11=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:253:57: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE68=(Token)match(input,WHERE,FOLLOW_WHERE_in_delete_statement1287); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE68_tree = (Object)adaptor.create(WHERE68);
                    adaptor.addChild(root_0, WHERE68_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1293);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:253:101: SEMICOLON
                    {
                    SEMICOLON69=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_delete_statement1295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON69_tree = (Object)adaptor.create(SEMICOLON69);
                    adaptor.addChild(root_0, SEMICOLON69_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:266:1: ddl_table_name returns [BaseTableDef ret] : n= NAME ;
    public final ddl_table_name_return ddl_table_name() throws RecognitionException {
        ddl_table_name_return retval = new ddl_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:267:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:267:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_table_name1327); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:274:1: ddl_column_pk returns [boolean ret] : n= 'PARTITION_KEY' ;
    public final ddl_column_pk_return ddl_column_pk() throws RecognitionException {
        ddl_column_pk_return retval = new ddl_column_pk_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:275:5: (n= 'PARTITION_KEY' )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:276:9: n= 'PARTITION_KEY'
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,69,FOLLOW_69_in_ddl_column_pk1360); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:279:1: ddl_column_comment returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final ddl_column_comment_return ddl_column_comment() throws RecognitionException {
        ddl_column_comment_return retval = new ddl_column_comment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE70=null;
        Token SINGLE_QUOTE71=null;

        Object n_tree=null;
        Object SINGLE_QUOTE70_tree=null;
        Object SINGLE_QUOTE71_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:280:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:280:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE70=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1385); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE70_tree = (Object)adaptor.create(SINGLE_QUOTE70);
            adaptor.addChild(root_0, SINGLE_QUOTE70_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_comment1389); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE71=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE71_tree = (Object)adaptor.create(SINGLE_QUOTE71);
            adaptor.addChild(root_0, SINGLE_QUOTE71_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:283:1: ddl_column_name returns [String ret] : n= NAME ;
    public final ddl_column_name_return ddl_column_name() throws RecognitionException {
        ddl_column_name_return retval = new ddl_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:284:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:284:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_name1418); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:287:1: ddl_column_type returns [ColumnDataTypeEnum ret] : n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) ;
    public final ddl_column_type_return ddl_column_type() throws RecognitionException {
        ddl_column_type_return retval = new ddl_column_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:288:5: (n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:288:9: n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=70 && input.LA(1)<=73) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:292:1: ddl_column_defs returns [List<BaseColumnDef> ret] : v= column_def ( COMMA v= column_def )* ;
    public final ddl_column_defs_return ddl_column_defs() throws RecognitionException {
        ddl_column_defs_return retval = new ddl_column_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA72=null;
        column_def_return v = null;


        Object COMMA72_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:293:5: (v= column_def ( COMMA v= column_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:294:9: v= column_def ( COMMA v= column_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_column_def_in_ddl_column_defs1488);
            v=column_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                          retval.ret = new ArrayList<BaseColumnDef>();
                          retval.ret.add(v.ret);

            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:297:11: ( COMMA v= column_def )*
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:297:12: COMMA v= column_def
            	    {
            	    COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_column_defs1493); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA72_tree = (Object)adaptor.create(COMMA72);
            	    adaptor.addChild(root_0, COMMA72_tree);
            	    }
            	    pushFollow(FOLLOW_column_def_in_ddl_column_defs1499);
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
            	    break loop12;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:300:1: column_def returns [BaseColumnDef ret] : c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* ;
    public final column_def_return column_def() throws RecognitionException {
        column_def_return retval = new column_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ddl_column_name_return c = null;

        ddl_column_type_return dt = null;

        ddl_column_pk_return pk = null;

        ddl_column_comment_return cmt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:5: (c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:9: c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ddl_column_name_in_column_def1529);
            c=ddl_column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_ddl_column_type_in_column_def1533);
            dt=ddl_column_type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:46: (pk= ddl_column_pk )*
            loop13:
            do {
                int alt13=2;
                switch ( input.LA(1) ) {
                case 69:
                    {
                    alt13=1;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:47: pk= ddl_column_pk
            	    {
            	    pushFollow(FOLLOW_ddl_column_pk_in_column_def1538);
            	    pk=ddl_column_pk();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pk.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:66: (cmt= ddl_column_comment )*
            loop14:
            do {
                int alt14=2;
                switch ( input.LA(1) ) {
                case SINGLE_QUOTE:
                    {
                    alt14=1;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:301:67: cmt= ddl_column_comment
            	    {
            	    pushFollow(FOLLOW_ddl_column_comment_in_column_def1545);
            	    cmt=ddl_column_comment();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, cmt.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:308:1: stream_meta_name returns [String ret] : n= ( 'TOPIC' | 'COMMENT' ) ;
    public final stream_meta_name_return stream_meta_name() throws RecognitionException {
        stream_meta_name_return retval = new stream_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:309:5: (n= ( 'TOPIC' | 'COMMENT' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:309:9: n= ( 'TOPIC' | 'COMMENT' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( (input.LA(1)>=74 && input.LA(1)<=75) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:312:1: stream_meta_value returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final stream_meta_value_return stream_meta_value() throws RecognitionException {
        stream_meta_value_return retval = new stream_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE73=null;
        Token SINGLE_QUOTE74=null;

        Object n_tree=null;
        Object SINGLE_QUOTE73_tree=null;
        Object SINGLE_QUOTE74_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:313:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:313:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE73=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE73_tree = (Object)adaptor.create(SINGLE_QUOTE73);
            adaptor.addChild(root_0, SINGLE_QUOTE73_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_stream_meta_value1616); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE74=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1618); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE74_tree = (Object)adaptor.create(SINGLE_QUOTE74);
            adaptor.addChild(root_0, SINGLE_QUOTE74_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:316:1: stream_meta_def returns [BaseMetaDef ret] : c= stream_meta_name dt= stream_meta_value ;
    public final stream_meta_def_return stream_meta_def() throws RecognitionException {
        stream_meta_def_return retval = new stream_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        stream_meta_name_return c = null;

        stream_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:317:5: (c= stream_meta_name dt= stream_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:317:9: c= stream_meta_name dt= stream_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_name_in_stream_meta_def1645);
            c=stream_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_stream_meta_value_in_stream_meta_def1649);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:321:1: ddl_stream_meta_defs returns [List<BaseMetaDef> ret] : v= stream_meta_def ( COMMA v= stream_meta_def )* ;
    public final ddl_stream_meta_defs_return ddl_stream_meta_defs() throws RecognitionException {
        ddl_stream_meta_defs_return retval = new ddl_stream_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA75=null;
        stream_meta_def_return v = null;


        Object COMMA75_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:322:10: (v= stream_meta_def ( COMMA v= stream_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:323:14: v= stream_meta_def ( COMMA v= stream_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1702);
            v=stream_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);

            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:326:16: ( COMMA v= stream_meta_def )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:326:17: COMMA v= stream_meta_def
            	    {
            	    COMMA75=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_stream_meta_defs1707); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA75_tree = (Object)adaptor.create(COMMA75);
            	    adaptor.addChild(root_0, COMMA75_tree);
            	    }
            	    pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1713);
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
            	    break loop15;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:329:1: create_stream_statement : CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON ;
    public final create_stream_statement_return create_stream_statement() throws RecognitionException {
        create_stream_statement_return retval = new create_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE76=null;
        Token STREAM77=null;
        Token LPAREN78=null;
        Token RPAREN79=null;
        Token META80=null;
        Token LPAREN81=null;
        Token RPAREN82=null;
        Token SEMICOLON83=null;
        ddl_table_name_return table_name = null;

        ddl_column_defs_return columns = null;

        ddl_stream_meta_defs_return metas = null;


        Object CREATE76_tree=null;
        Object STREAM77_tree=null;
        Object LPAREN78_tree=null;
        Object RPAREN79_tree=null;
        Object META80_tree=null;
        Object LPAREN81_tree=null;
        Object RPAREN82_tree=null;
        Object SEMICOLON83_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:330:5: ( CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:330:7: CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE76=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_stream_statement1740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE76_tree = (Object)adaptor.create(CREATE76);
            adaptor.addChild(root_0, CREATE76_tree);
            }
            STREAM77=(Token)match(input,STREAM,FOLLOW_STREAM_in_create_stream_statement1742); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM77_tree = (Object)adaptor.create(STREAM77);
            adaptor.addChild(root_0, STREAM77_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_stream_statement1746);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            LPAREN78=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1756); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN78_tree = (Object)adaptor.create(LPAREN78);
            adaptor.addChild(root_0, LPAREN78_tree);
            }
            pushFollow(FOLLOW_ddl_column_defs_in_create_stream_statement1760);
            columns=ddl_column_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, columns.getTree());
            RPAREN79=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN79_tree = (Object)adaptor.create(RPAREN79);
            adaptor.addChild(root_0, RPAREN79_tree);
            }
            META80=(Token)match(input,META,FOLLOW_META_in_create_stream_statement1764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META80_tree = (Object)adaptor.create(META80);
            adaptor.addChild(root_0, META80_tree);
            }
            LPAREN81=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN81_tree = (Object)adaptor.create(LPAREN81);
            adaptor.addChild(root_0, LPAREN81_tree);
            }
            pushFollow(FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1770);
            metas=ddl_stream_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN82=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN82_tree = (Object)adaptor.create(RPAREN82);
            adaptor.addChild(root_0, RPAREN82_tree);
            }
            SEMICOLON83=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_stream_statement1774); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON83_tree = (Object)adaptor.create(SEMICOLON83);
            adaptor.addChild(root_0, SEMICOLON83_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:344:1: drop_stream_statement : DROP STREAM table_name= ddl_table_name SEMICOLON ;
    public final drop_stream_statement_return drop_stream_statement() throws RecognitionException {
        drop_stream_statement_return retval = new drop_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP84=null;
        Token STREAM85=null;
        Token SEMICOLON86=null;
        ddl_table_name_return table_name = null;


        Object DROP84_tree=null;
        Object STREAM85_tree=null;
        Object SEMICOLON86_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:345:5: ( DROP STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:345:7: DROP STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP84=(Token)match(input,DROP,FOLLOW_DROP_in_drop_stream_statement1797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP84_tree = (Object)adaptor.create(DROP84);
            adaptor.addChild(root_0, DROP84_tree);
            }
            STREAM85=(Token)match(input,STREAM,FOLLOW_STREAM_in_drop_stream_statement1799); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM85_tree = (Object)adaptor.create(STREAM85);
            adaptor.addChild(root_0, STREAM85_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_stream_statement1803);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON86=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_stream_statement1805); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON86_tree = (Object)adaptor.create(SEMICOLON86);
            adaptor.addChild(root_0, SEMICOLON86_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:356:1: show_stream_statement : SHOW STREAM table_name= ddl_table_name SEMICOLON ;
    public final show_stream_statement_return show_stream_statement() throws RecognitionException {
        show_stream_statement_return retval = new show_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW87=null;
        Token STREAM88=null;
        Token SEMICOLON89=null;
        ddl_table_name_return table_name = null;


        Object SHOW87_tree=null;
        Object STREAM88_tree=null;
        Object SEMICOLON89_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:357:5: ( SHOW STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:357:7: SHOW STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW87=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_stream_statement1828); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW87_tree = (Object)adaptor.create(SHOW87);
            adaptor.addChild(root_0, SHOW87_tree);
            }
            STREAM88=(Token)match(input,STREAM,FOLLOW_STREAM_in_show_stream_statement1830); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM88_tree = (Object)adaptor.create(STREAM88);
            adaptor.addChild(root_0, STREAM88_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_stream_statement1834);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON89=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_stream_statement1836); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON89_tree = (Object)adaptor.create(SEMICOLON89);
            adaptor.addChild(root_0, SEMICOLON89_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:368:1: show_streams_statement : SHOW STREAMS SEMICOLON ;
    public final show_streams_statement_return show_streams_statement() throws RecognitionException {
        show_streams_statement_return retval = new show_streams_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW90=null;
        Token STREAMS91=null;
        Token SEMICOLON92=null;

        Object SHOW90_tree=null;
        Object STREAMS91_tree=null;
        Object SEMICOLON92_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:369:5: ( SHOW STREAMS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:369:7: SHOW STREAMS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW90=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_streams_statement1859); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW90_tree = (Object)adaptor.create(SHOW90);
            adaptor.addChild(root_0, SHOW90_tree);
            }
            STREAMS91=(Token)match(input,STREAMS,FOLLOW_STREAMS_in_show_streams_statement1861); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAMS91_tree = (Object)adaptor.create(STREAMS91);
            adaptor.addChild(root_0, STREAMS91_tree);
            }
            SEMICOLON92=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_streams_statement1863); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON92_tree = (Object)adaptor.create(SEMICOLON92);
            adaptor.addChild(root_0, SEMICOLON92_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:379:1: kill_job_statement : KILL JOB table_name= ddl_table_name SEMICOLON ;
    public final kill_job_statement_return kill_job_statement() throws RecognitionException {
        kill_job_statement_return retval = new kill_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KILL93=null;
        Token JOB94=null;
        Token SEMICOLON95=null;
        ddl_table_name_return table_name = null;


        Object KILL93_tree=null;
        Object JOB94_tree=null;
        Object SEMICOLON95_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:380:5: ( KILL JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:380:7: KILL JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            KILL93=(Token)match(input,KILL,FOLLOW_KILL_in_kill_job_statement1886); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KILL93_tree = (Object)adaptor.create(KILL93);
            adaptor.addChild(root_0, KILL93_tree);
            }
            JOB94=(Token)match(input,JOB,FOLLOW_JOB_in_kill_job_statement1888); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB94_tree = (Object)adaptor.create(JOB94);
            adaptor.addChild(root_0, JOB94_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_kill_job_statement1892);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON95=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_kill_job_statement1894); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON95_tree = (Object)adaptor.create(SEMICOLON95);
            adaptor.addChild(root_0, SEMICOLON95_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:391:1: commit_statement : COMMIT SEMICOLON ;
    public final commit_statement_return commit_statement() throws RecognitionException {
        commit_statement_return retval = new commit_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMIT96=null;
        Token SEMICOLON97=null;

        Object COMMIT96_tree=null;
        Object SEMICOLON97_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:392:5: ( COMMIT SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:392:7: COMMIT SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            COMMIT96=(Token)match(input,COMMIT,FOLLOW_COMMIT_in_commit_statement1917); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COMMIT96_tree = (Object)adaptor.create(COMMIT96);
            adaptor.addChild(root_0, COMMIT96_tree);
            }
            SEMICOLON97=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_commit_statement1919); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON97_tree = (Object)adaptor.create(SEMICOLON97);
            adaptor.addChild(root_0, SEMICOLON97_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:398:1: source_meta_name returns [String ret] : n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) ;
    public final source_meta_name_return source_meta_name() throws RecognitionException {
        source_meta_name_return retval = new source_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:399:5: (n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:399:9: n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' )
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)input.LT(1);
            if ( input.LA(1)==74||(input.LA(1)>=76 && input.LA(1)<=86) ) {
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:402:1: source_meta_value returns [String ret] : SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE ;
    public final source_meta_value_return source_meta_value() throws RecognitionException {
        source_meta_value_return retval = new source_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE98=null;
        Token set99=null;
        Token SINGLE_QUOTE100=null;

        Object n_tree=null;
        Object SINGLE_QUOTE98_tree=null;
        Object set99_tree=null;
        Object SINGLE_QUOTE100_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:403:5: ( SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:403:9: SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE98=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value1996); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE98_tree = (Object)adaptor.create(SINGLE_QUOTE98);
            adaptor.addChild(root_0, SINGLE_QUOTE98_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_source_meta_value2000); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:403:29: ( NAME | COMMA )*
            loop16:
            do {
                int alt16=2;
                switch ( input.LA(1) ) {
                case COMMA:
                case NAME:
                    {
                    alt16=1;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:
            	    {
            	    set99=(Token)input.LT(1);
            	    if ( input.LA(1)==COMMA||input.LA(1)==NAME ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set99));
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
            	    break loop16;
                }
            } while (true);

            SINGLE_QUOTE100=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value2009); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE100_tree = (Object)adaptor.create(SINGLE_QUOTE100);
            adaptor.addChild(root_0, SINGLE_QUOTE100_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:406:1: source_meta_def returns [BaseMetaDef ret] : c= source_meta_name dt= source_meta_value ;
    public final source_meta_def_return source_meta_def() throws RecognitionException {
        source_meta_def_return retval = new source_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        source_meta_name_return c = null;

        source_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:407:5: (c= source_meta_name dt= source_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:407:9: c= source_meta_name dt= source_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_name_in_source_meta_def2036);
            c=source_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_source_meta_value_in_source_meta_def2040);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:411:1: ddl_source_meta_defs returns [List<BaseMetaDef> ret] : v= source_meta_def ( COMMA v= source_meta_def )* ;
    public final ddl_source_meta_defs_return ddl_source_meta_defs() throws RecognitionException {
        ddl_source_meta_defs_return retval = new ddl_source_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA101=null;
        source_meta_def_return v = null;


        Object COMMA101_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:412:10: (v= source_meta_def ( COMMA v= source_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:413:14: v= source_meta_def ( COMMA v= source_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2093);
            v=source_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);

            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:416:16: ( COMMA v= source_meta_def )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case COMMA:
                    {
                    alt17=1;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:416:17: COMMA v= source_meta_def
            	    {
            	    COMMA101=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_source_meta_defs2098); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA101_tree = (Object)adaptor.create(COMMA101);
            	    adaptor.addChild(root_0, COMMA101_tree);
            	    }
            	    pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2104);
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
            	    break loop17;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:419:1: create_source_statement : CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON ;
    public final create_source_statement_return create_source_statement() throws RecognitionException {
        create_source_statement_return retval = new create_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE102=null;
        Token SOURCE103=null;
        Token META104=null;
        Token LPAREN105=null;
        Token RPAREN106=null;
        Token SEMICOLON107=null;
        ddl_table_name_return table_name = null;

        ddl_source_meta_defs_return metas = null;


        Object CREATE102_tree=null;
        Object SOURCE103_tree=null;
        Object META104_tree=null;
        Object LPAREN105_tree=null;
        Object RPAREN106_tree=null;
        Object SEMICOLON107_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:420:5: ( CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:420:7: CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE102=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_source_statement2131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE102_tree = (Object)adaptor.create(CREATE102);
            adaptor.addChild(root_0, CREATE102_tree);
            }
            SOURCE103=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_create_source_statement2133); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE103_tree = (Object)adaptor.create(SOURCE103);
            adaptor.addChild(root_0, SOURCE103_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_source_statement2137);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            META104=(Token)match(input,META,FOLLOW_META_in_create_source_statement2139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META104_tree = (Object)adaptor.create(META104);
            adaptor.addChild(root_0, META104_tree);
            }
            LPAREN105=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_source_statement2141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN105_tree = (Object)adaptor.create(LPAREN105);
            adaptor.addChild(root_0, LPAREN105_tree);
            }
            pushFollow(FOLLOW_ddl_source_meta_defs_in_create_source_statement2145);
            metas=ddl_source_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN106=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_source_statement2147); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN106_tree = (Object)adaptor.create(RPAREN106);
            adaptor.addChild(root_0, RPAREN106_tree);
            }
            SEMICOLON107=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_source_statement2149); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON107_tree = (Object)adaptor.create(SEMICOLON107);
            adaptor.addChild(root_0, SEMICOLON107_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:433:1: drop_source_statement : DROP SOURCE table_name= ddl_table_name SEMICOLON ;
    public final drop_source_statement_return drop_source_statement() throws RecognitionException {
        drop_source_statement_return retval = new drop_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP108=null;
        Token SOURCE109=null;
        Token SEMICOLON110=null;
        ddl_table_name_return table_name = null;


        Object DROP108_tree=null;
        Object SOURCE109_tree=null;
        Object SEMICOLON110_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:434:5: ( DROP SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:434:7: DROP SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP108=(Token)match(input,DROP,FOLLOW_DROP_in_drop_source_statement2172); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP108_tree = (Object)adaptor.create(DROP108);
            adaptor.addChild(root_0, DROP108_tree);
            }
            SOURCE109=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_drop_source_statement2174); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE109_tree = (Object)adaptor.create(SOURCE109);
            adaptor.addChild(root_0, SOURCE109_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_source_statement2178);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON110=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_source_statement2180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON110_tree = (Object)adaptor.create(SEMICOLON110);
            adaptor.addChild(root_0, SEMICOLON110_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:445:1: show_source_statement : SHOW SOURCE table_name= ddl_table_name SEMICOLON ;
    public final show_source_statement_return show_source_statement() throws RecognitionException {
        show_source_statement_return retval = new show_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW111=null;
        Token SOURCE112=null;
        Token SEMICOLON113=null;
        ddl_table_name_return table_name = null;


        Object SHOW111_tree=null;
        Object SOURCE112_tree=null;
        Object SEMICOLON113_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:446:5: ( SHOW SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:446:7: SHOW SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW111=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_source_statement2203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW111_tree = (Object)adaptor.create(SHOW111);
            adaptor.addChild(root_0, SHOW111_tree);
            }
            SOURCE112=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_show_source_statement2205); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE112_tree = (Object)adaptor.create(SOURCE112);
            adaptor.addChild(root_0, SOURCE112_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_source_statement2209);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON113=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_source_statement2211); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON113_tree = (Object)adaptor.create(SEMICOLON113);
            adaptor.addChild(root_0, SEMICOLON113_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:457:1: show_sources_statement : SHOW SOURCES SEMICOLON ;
    public final show_sources_statement_return show_sources_statement() throws RecognitionException {
        show_sources_statement_return retval = new show_sources_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW114=null;
        Token SOURCES115=null;
        Token SEMICOLON116=null;

        Object SHOW114_tree=null;
        Object SOURCES115_tree=null;
        Object SEMICOLON116_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:458:5: ( SHOW SOURCES SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:458:7: SHOW SOURCES SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW114=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_sources_statement2234); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW114_tree = (Object)adaptor.create(SHOW114);
            adaptor.addChild(root_0, SHOW114_tree);
            }
            SOURCES115=(Token)match(input,SOURCES,FOLLOW_SOURCES_in_show_sources_statement2236); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCES115_tree = (Object)adaptor.create(SOURCES115);
            adaptor.addChild(root_0, SOURCES115_tree);
            }
            SEMICOLON116=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_sources_statement2238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON116_tree = (Object)adaptor.create(SEMICOLON116);
            adaptor.addChild(root_0, SEMICOLON116_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:468:1: drop_job_statement : DROP JOB table_name= ddl_table_name SEMICOLON ;
    public final drop_job_statement_return drop_job_statement() throws RecognitionException {
        drop_job_statement_return retval = new drop_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP117=null;
        Token JOB118=null;
        Token SEMICOLON119=null;
        ddl_table_name_return table_name = null;


        Object DROP117_tree=null;
        Object JOB118_tree=null;
        Object SEMICOLON119_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:469:5: ( DROP JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:469:7: DROP JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP117=(Token)match(input,DROP,FOLLOW_DROP_in_drop_job_statement2261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP117_tree = (Object)adaptor.create(DROP117);
            adaptor.addChild(root_0, DROP117_tree);
            }
            JOB118=(Token)match(input,JOB,FOLLOW_JOB_in_drop_job_statement2263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB118_tree = (Object)adaptor.create(JOB118);
            adaptor.addChild(root_0, JOB118_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_job_statement2267);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON119=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_job_statement2269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON119_tree = (Object)adaptor.create(SEMICOLON119);
            adaptor.addChild(root_0, SEMICOLON119_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:480:1: show_job_statement : SHOW JOB table_name= ddl_table_name SEMICOLON ;
    public final show_job_statement_return show_job_statement() throws RecognitionException {
        show_job_statement_return retval = new show_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW120=null;
        Token JOB121=null;
        Token SEMICOLON122=null;
        ddl_table_name_return table_name = null;


        Object SHOW120_tree=null;
        Object JOB121_tree=null;
        Object SEMICOLON122_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:481:5: ( SHOW JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:481:7: SHOW JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW120=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_job_statement2292); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW120_tree = (Object)adaptor.create(SHOW120);
            adaptor.addChild(root_0, SHOW120_tree);
            }
            JOB121=(Token)match(input,JOB,FOLLOW_JOB_in_show_job_statement2294); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB121_tree = (Object)adaptor.create(JOB121);
            adaptor.addChild(root_0, JOB121_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_job_statement2298);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON122=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_job_statement2300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON122_tree = (Object)adaptor.create(SEMICOLON122);
            adaptor.addChild(root_0, SEMICOLON122_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:492:1: show_jobs_statement : SHOW JOBS SEMICOLON ;
    public final show_jobs_statement_return show_jobs_statement() throws RecognitionException {
        show_jobs_statement_return retval = new show_jobs_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW123=null;
        Token JOBS124=null;
        Token SEMICOLON125=null;

        Object SHOW123_tree=null;
        Object JOBS124_tree=null;
        Object SEMICOLON125_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:493:5: ( SHOW JOBS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:493:7: SHOW JOBS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW123=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_jobs_statement2323); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW123_tree = (Object)adaptor.create(SHOW123);
            adaptor.addChild(root_0, SHOW123_tree);
            }
            JOBS124=(Token)match(input,JOBS,FOLLOW_JOBS_in_show_jobs_statement2325); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOBS124_tree = (Object)adaptor.create(JOBS124);
            adaptor.addChild(root_0, JOBS124_tree);
            }
            SEMICOLON125=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_jobs_statement2327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON125_tree = (Object)adaptor.create(SEMICOLON125);
            adaptor.addChild(root_0, SEMICOLON125_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:503:1: show_cluster_statement : SHOW CLUSTER SEMICOLON ;
    public final show_cluster_statement_return show_cluster_statement() throws RecognitionException {
        show_cluster_statement_return retval = new show_cluster_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW126=null;
        Token CLUSTER127=null;
        Token SEMICOLON128=null;

        Object SHOW126_tree=null;
        Object CLUSTER127_tree=null;
        Object SEMICOLON128_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:504:5: ( SHOW CLUSTER SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:504:7: SHOW CLUSTER SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW126=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_cluster_statement2350); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW126_tree = (Object)adaptor.create(SHOW126);
            adaptor.addChild(root_0, SHOW126_tree);
            }
            CLUSTER127=(Token)match(input,CLUSTER,FOLLOW_CLUSTER_in_show_cluster_statement2352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CLUSTER127_tree = (Object)adaptor.create(CLUSTER127);
            adaptor.addChild(root_0, CLUSTER127_tree);
            }
            SEMICOLON128=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_cluster_statement2354); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON128_tree = (Object)adaptor.create(SEMICOLON128);
            adaptor.addChild(root_0, SEMICOLON128_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:514:1: show_system_statement : SHOW SYSTEM SEMICOLON ;
    public final show_system_statement_return show_system_statement() throws RecognitionException {
        show_system_statement_return retval = new show_system_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW129=null;
        Token SYSTEM130=null;
        Token SEMICOLON131=null;

        Object SHOW129_tree=null;
        Object SYSTEM130_tree=null;
        Object SEMICOLON131_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:515:5: ( SHOW SYSTEM SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:515:7: SHOW SYSTEM SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW129=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_system_statement2377); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW129_tree = (Object)adaptor.create(SHOW129);
            adaptor.addChild(root_0, SHOW129_tree);
            }
            SYSTEM130=(Token)match(input,SYSTEM,FOLLOW_SYSTEM_in_show_system_statement2379); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SYSTEM130_tree = (Object)adaptor.create(SYSTEM130);
            adaptor.addChild(root_0, SYSTEM130_tree);
            }
            SEMICOLON131=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_system_statement2381); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON131_tree = (Object)adaptor.create(SEMICOLON131);
            adaptor.addChild(root_0, SEMICOLON131_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:525:1: snapshot_job_statement : SNAPSHOT JOB table_name= ddl_table_name SEMICOLON ;
    public final snapshot_job_statement_return snapshot_job_statement() throws RecognitionException {
        snapshot_job_statement_return retval = new snapshot_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SNAPSHOT132=null;
        Token JOB133=null;
        Token SEMICOLON134=null;
        ddl_table_name_return table_name = null;


        Object SNAPSHOT132_tree=null;
        Object JOB133_tree=null;
        Object SEMICOLON134_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:526:5: ( SNAPSHOT JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:526:7: SNAPSHOT JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SNAPSHOT132=(Token)match(input,SNAPSHOT,FOLLOW_SNAPSHOT_in_snapshot_job_statement2404); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SNAPSHOT132_tree = (Object)adaptor.create(SNAPSHOT132);
            adaptor.addChild(root_0, SNAPSHOT132_tree);
            }
            JOB133=(Token)match(input,JOB,FOLLOW_JOB_in_snapshot_job_statement2406); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB133_tree = (Object)adaptor.create(JOB133);
            adaptor.addChild(root_0, JOB133_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_snapshot_job_statement2410);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON134=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_snapshot_job_statement2412); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON134_tree = (Object)adaptor.create(SEMICOLON134);
            adaptor.addChild(root_0, SEMICOLON134_tree);
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

    // $ANTLR start synpred30_TOMMY_SQL
    public final void synpred30_TOMMY_SQL_fragment() throws RecognitionException {
        Token n=null;

        // org/tommy/stationery/ink/core/TOMMY_SQL.g:174:9: (n=~ ( '\\r' | '\\n' | ';' ) )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:174:9: n=~ ( '\\r' | '\\n' | ';' )
        {
        n=(Token)input.LT(1);
        if ( (input.LA(1)>=SYSTEM && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=69 && input.LA(1)<=86) ) {
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
    // $ANTLR end synpred30_TOMMY_SQL

    // $ANTLR start synpred41_TOMMY_SQL
    public final void synpred41_TOMMY_SQL_fragment() throws RecognitionException {
        dml_lookup_select_where_body2_return body2 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:52: ( SET body2= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:52: SET body2= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred41_TOMMY_SQL1228); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred41_TOMMY_SQL1234);
        body2=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_TOMMY_SQL

    // $ANTLR start synpred42_TOMMY_SQL
    public final void synpred42_TOMMY_SQL_fragment() throws RecognitionException {
        dml_lookup_select_where_body_return body3 = null;

        dml_lookup_select_where_body2_return body4 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:96: ( SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred42_TOMMY_SQL1238); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body_in_synpred42_TOMMY_SQL1244);
        body3=dml_lookup_select_where_body();

        state._fsp--;
        if (state.failed) return ;
        match(input,WHERE,FOLLOW_WHERE_in_synpred42_TOMMY_SQL1246); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred42_TOMMY_SQL1250);
        body4=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_TOMMY_SQL

    // Delegated rules

    public final boolean synpred41_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_TOMMY_SQL_fragment(); // can never throw exception
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
    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA1_eotS =
        "\35\uffff";
    static final String DFA1_eofS =
        "\1\1\34\uffff";
    static final String DFA1_minS =
        "\1\5\1\uffff\1\4\12\uffff\2\15\16\uffff";
    static final String DFA1_maxS =
        "\1\73\1\uffff\1\67\12\uffff\1\21\1\25\16\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\31\1\uffff\1\2\1\3\1\4\1\5\1\6\1\13\1\14\1\15\1\16\1"+
        "\17\2\uffff\1\30\1\1\1\7\1\10\1\11\1\12\1\22\1\23\1\27\1\20\1\21"+
        "\1\24\1\25\1\26";
    static final String DFA1_specialS =
        "\35\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\17\1\14\2\uffff\1\13\1\10\1\12\1\15\6\uffff\1\16\1\2\37\uffff"+
            "\1\11\1\7\2\uffff\1\6\1\5\1\4\1\3",
            "",
            "\1\20\10\uffff\1\25\1\22\2\uffff\1\26\1\21\2\uffff\1\27\40"+
            "\uffff\1\23\1\24",
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
            "\1\30\3\uffff\1\31",
            "\1\32\3\uffff\1\33\3\uffff\1\34",
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
            return "()+ loopback of 103:7: ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+";
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
        "\2\126\1\uffff\2\126\1\0\1\uffff\1\0\5\126\1\0\4\126\2\0\5\126\1"+
        "\0\4\126\1\0\1\126\1\0\3\126\1\0\1\126\1\0\10\126\1\0\1\126\1\0"+
        "\4\126\1\0\4\126\1\0\1\126\2\0\1\126\1\0\3\126\3\0\5\126\1\0\5\126"+
        "\1\0\1\126\1\0\1\126\1\0\4\126\4\0\5\126\3\0\1\126\2\0";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\143\uffff";
    static final String DFA4_specialS =
        "\5\uffff\1\36\1\uffff\1\30\5\uffff\1\37\4\uffff\1\20\1\34\5\uffff"+
        "\1\23\4\uffff\1\13\1\uffff\1\17\3\uffff\1\24\1\uffff\1\27\10\uffff"+
        "\1\10\1\uffff\1\26\4\uffff\1\3\4\uffff\1\21\1\uffff\1\0\1\2\1\uffff"+
        "\1\11\3\uffff\1\15\1\22\1\4\5\uffff\1\35\5\uffff\1\14\1\uffff\1"+
        "\1\1\uffff\1\33\4\uffff\1\5\1\31\1\32\1\16\5\uffff\1\12\1\25\1\6"+
        "\1\uffff\1\40\1\7}>";
    static final String[] DFA4_transitionS = {
            "\4\6\1\1\32\6\1\2\15\6\1\4\1\3\2\6\1\5\15\6\2\uffff\22\6",
            "\4\13\1\7\32\13\1\6\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
            "\22\13",
            "",
            "\4\20\1\14\32\20\1\6\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
            "\22\20",
            "\56\6\1\21\20\6\2\uffff\22\6",
            "\1\uffff",
            "",
            "\1\uffff",
            "\4\27\1\23\32\27\1\22\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
            "\22\27",
            "\4\13\1\7\32\13\1\22\15\13\1\11\1\30\2\13\1\12\15\13\2\uffff"+
            "\22\13",
            "\4\35\1\31\32\35\1\22\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
            "\22\35",
            "\4\13\1\7\32\13\1\22\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
            "\22\13",
            "\4\43\1\37\32\43\1\36\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
            "\22\43",
            "\1\uffff",
            "\4\20\1\14\32\20\1\36\15\20\1\16\1\44\2\20\1\17\15\20\2\uffff"+
            "\22\20",
            "\4\51\1\45\32\51\1\36\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
            "\22\51",
            "\4\20\1\14\32\20\1\36\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
            "\22\20",
            "\4\56\1\52\32\56\1\6\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\22\56",
            "\1\uffff",
            "\1\uffff",
            "\4\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
            "\22\27",
            "\4\27\1\23\32\27\1\57\15\27\1\25\1\60\2\27\1\26\15\27\2\uffff"+
            "\22\27",
            "\4\65\1\61\32\65\1\57\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\22\65",
            "\4\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
            "\22\27",
            "\4\72\1\66\32\72\1\22\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\22\72",
            "\1\uffff",
            "\4\65\1\61\32\65\1\73\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\22\65",
            "\4\35\1\31\32\35\1\73\15\35\1\33\1\74\2\35\1\34\15\35\2\uffff"+
            "\22\35",
            "\4\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
            "\22\35",
            "\4\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
            "\22\35",
            "\1\uffff",
            "\4\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
            "\22\43",
            "\1\uffff",
            "\4\43\1\37\32\43\1\75\15\43\1\41\1\76\2\43\1\42\15\43\2\uffff"+
            "\22\43",
            "\4\103\1\77\32\103\1\75\15\103\1\101\1\100\2\103\1\102\15\103"+
            "\2\uffff\22\103",
            "\4\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
            "\22\43",
            "\1\uffff",
            "\4\103\1\77\32\103\1\104\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\22\103",
            "\1\uffff",
            "\4\51\1\45\32\51\1\104\15\51\1\47\1\105\2\51\1\50\15\51\2\uffff"+
            "\22\51",
            "\4\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
            "\22\51",
            "\4\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
            "\22\51",
            "\4\113\1\107\32\113\1\106\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\22\113",
            "\4\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\22\56",
            "\4\56\1\52\32\56\1\106\15\56\1\54\1\114\2\56\1\55\15\56\2\uffff"+
            "\22\56",
            "\4\121\1\115\32\121\1\106\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\22\121",
            "\4\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
            "\22\56",
            "\1\uffff",
            "\4\72\1\66\32\72\1\57\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\22\72",
            "\1\uffff",
            "\4\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\22\65",
            "\4\65\1\61\32\65\1\122\15\65\1\63\1\123\2\65\1\64\15\65\2\uffff"+
            "\22\65",
            "\4\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\22\65",
            "\4\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
            "\22\65",
            "\1\uffff",
            "\4\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\22\72",
            "\4\72\1\66\32\72\1\124\15\72\1\70\1\125\2\72\1\71\15\72\2\uffff"+
            "\22\72",
            "\4\132\1\126\32\132\1\124\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\22\132",
            "\4\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\22\72",
            "\1\uffff",
            "\4\132\1\126\32\132\1\73\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\22\132",
            "\1\uffff",
            "\1\uffff",
            "\4\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\22\103",
            "\1\uffff",
            "\4\103\1\77\32\103\1\133\15\103\1\101\1\134\2\103\1\102\15"+
            "\103\2\uffff\22\103",
            "\4\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\22\103",
            "\4\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
            "\103\2\uffff\22\103",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\4\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\22\113",
            "\4\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\22\113",
            "\4\113\1\107\32\113\1\135\15\113\1\111\1\136\2\113\1\112\15"+
            "\113\2\uffff\22\113",
            "\4\143\1\137\32\143\1\135\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\22\143",
            "\4\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
            "\113\2\uffff\22\113",
            "\1\uffff",
            "\4\143\1\137\32\143\1\144\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\22\143",
            "\4\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\22\121",
            "\4\121\1\115\32\121\1\144\15\121\1\117\1\145\2\121\1\120\15"+
            "\121\2\uffff\22\121",
            "\4\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\22\121",
            "\4\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
            "\121\2\uffff\22\121",
            "\1\uffff",
            "\4\132\1\126\32\132\1\122\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\22\132",
            "\1\uffff",
            "\4\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
            "\22\72",
            "\1\uffff",
            "\4\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\22\132",
            "\4\132\1\126\32\132\1\146\15\132\1\130\1\147\2\132\1\131\15"+
            "\132\2\uffff\22\132",
            "\4\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\22\132",
            "\4\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\22\132",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\4\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\22\143",
            "\4\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\22\143",
            "\4\143\1\137\32\143\1\150\15\143\1\141\1\151\2\143\1\142\15"+
            "\143\2\uffff\22\143",
            "\4\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\22\143",
            "\4\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
            "\143\2\uffff\22\143",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\4\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
            "\132\2\uffff\22\132",
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
            return "()+ loopback of 174:9: (n=~ ( '\\r' | '\\n' | ';' ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_61 = input.LA(1);

                         
                        int index4_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_61);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_84 = input.LA(1);

                         
                        int index4_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_84);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_62 = input.LA(1);

                         
                        int index4_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_62);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_54 = input.LA(1);

                         
                        int index4_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_54);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_70 = input.LA(1);

                         
                        int index4_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_70);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_91 = input.LA(1);

                         
                        int index4_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_91);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_102 = input.LA(1);

                         
                        int index4_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_102);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_105 = input.LA(1);

                         
                        int index4_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_105);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_47 = input.LA(1);

                         
                        int index4_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_47);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_64 = input.LA(1);

                         
                        int index4_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_64);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_100 = input.LA(1);

                         
                        int index4_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_100);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_30 = input.LA(1);

                         
                        int index4_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_30);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_82 = input.LA(1);

                         
                        int index4_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_82);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_68 = input.LA(1);

                         
                        int index4_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_68);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_94 = input.LA(1);

                         
                        int index4_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_94);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_32 = input.LA(1);

                         
                        int index4_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_32);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA4_18 = input.LA(1);

                         
                        int index4_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_18);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA4_59 = input.LA(1);

                         
                        int index4_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_59);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA4_69 = input.LA(1);

                         
                        int index4_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_69);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA4_25 = input.LA(1);

                         
                        int index4_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_25);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA4_36 = input.LA(1);

                         
                        int index4_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_36);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA4_101 = input.LA(1);

                         
                        int index4_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_101);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA4_49 = input.LA(1);

                         
                        int index4_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_49);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA4_38 = input.LA(1);

                         
                        int index4_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_38);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA4_92 = input.LA(1);

                         
                        int index4_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_92);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA4_93 = input.LA(1);

                         
                        int index4_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_93);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA4_86 = input.LA(1);

                         
                        int index4_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_86);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA4_19 = input.LA(1);

                         
                        int index4_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_19);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA4_76 = input.LA(1);

                         
                        int index4_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_76);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA4_104 = input.LA(1);

                         
                        int index4_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_104);
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
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\12\uffff";
    static final String DFA10_minS =
        "\1\43\1\4\1\uffff\1\4\1\uffff\3\4\1\0\1\uffff";
    static final String DFA10_maxS =
        "\1\65\1\126\1\uffff\1\126\1\uffff\3\126\1\0\1\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\3\1\uffff\1\1\4\uffff\1\2";
    static final String DFA10_specialS =
        "\10\uffff\1\0\1\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\21\uffff\1\1",
            "\37\3\1\uffff\37\3\2\uffff\22\3",
            "",
            "\4\3\1\5\32\3\1\4\37\3\2\uffff\22\3",
            "",
            "\4\7\1\6\32\7\1\4\37\7\2\uffff\22\7",
            "\4\7\1\6\32\7\1\10\37\7\2\uffff\22\7",
            "\4\7\1\6\32\7\1\10\37\7\2\uffff\22\7",
            "\1\uffff",
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
            return "238:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred41_TOMMY_SQL()) ) {s = 4;}

                        else if ( (synpred42_TOMMY_SQL()) ) {s = 9;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_show_system_statement_in_create_statement597 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_commit_statement_in_create_statement599 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_use_statement_in_create_statement601 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_snapshot_job_statement_in_create_statement603 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_kill_job_statement_in_create_statement605 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_set_statement_in_create_statement607 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_show_sources_statement_in_create_statement609 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_show_streams_statement_in_create_statement611 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_show_cluster_statement_in_create_statement613 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_show_jobs_statement_in_create_statement615 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_insert_statement_in_create_statement617 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_update_statement_in_create_statement619 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_upsert_statement_in_create_statement621 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_lookup_statement_in_create_statement623 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_select_statement_in_create_statement625 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_create_stream_statement_in_create_statement627 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_create_source_statement_in_create_statement629 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_show_stream_statement_in_create_statement631 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_show_source_statement_in_create_statement633 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_drop_stream_statement_in_create_statement635 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_drop_source_statement_in_create_statement637 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_drop_job_statement_in_create_statement639 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_show_job_statement_in_create_statement641 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_delete_statement_in_create_statement643 = new BitSet(new long[]{0x0F30000000181E62L});
    public static final BitSet FOLLOW_NAME_in_use_name_def677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_use_statement696 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_use_statement700 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_use_statement702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_name_def734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_value_def762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_set_statement782 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_set_statement786 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_EQUAL_in_set_statement788 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement790 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_set_value_def_in_set_statement794 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement796 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_set_statement798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_table_name828 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name832 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_table_name834 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name838 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_table_name840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_bind_column_name867 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_bind_column_name869 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_bind_column_name871 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_bind_column_name873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where900 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where903 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body933 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body936 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body965 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF2L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body21001 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup_statement1032 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_lookup_statement1038 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_WHERE_in_lookup_statement1041 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_lookup_statement1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement1073 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_select_statement1079 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_WHERE_in_select_statement1082 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_select_statement1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_select_statement1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INSERT_in_insert_statement1113 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_INTO_in_insert_statement1115 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_insert_statement1121 = new BitSet(new long[]{0x0006000800000000L});
    public static final BitSet FOLLOW_VALUES_in_insert_statement1124 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_insert_statement1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCREASE_in_insert_statement1132 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_VALUES_in_insert_statement1134 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_insert_statement1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_insert_statement1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPSERT_in_upsert_statement1166 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_INTO_in_upsert_statement1168 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_upsert_statement1174 = new BitSet(new long[]{0x0006000800000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1177 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCREASE_in_upsert_statement1185 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1187 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_upsert_statement1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_update_statement1219 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1225 = new BitSet(new long[]{0x0020000800000000L});
    public static final BitSet FOLLOW_SET_in_update_statement1228 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_update_statement1238 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1244 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_WHERE_in_update_statement1246 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_update_statement1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_delete_statement1276 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FROM_in_delete_statement1278 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_delete_statement1284 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_WHERE_in_delete_statement1287 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_delete_statement1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_table_name1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ddl_column_pk1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1385 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_comment1389 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_name1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ddl_column_type1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1488 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_column_defs1493 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1499 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ddl_column_name_in_column_def1529 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ddl_column_type_in_column_def1533 = new BitSet(new long[]{0x0000000100000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_ddl_column_pk_in_column_def1538 = new BitSet(new long[]{0x0000000100000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_ddl_column_comment_in_column_def1545 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_set_in_stream_meta_name1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1612 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_stream_meta_value1616 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_name_in_stream_meta_def1645 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_stream_meta_value_in_stream_meta_def1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1702 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_stream_meta_defs1707 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1713 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_stream_statement1740 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAM_in_create_stream_statement1742 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_stream_statement1746 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1756 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_column_defs_in_create_stream_statement1760 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1762 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_META_in_create_stream_statement1764 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1766 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1770 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1772 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_stream_statement1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_stream_statement1797 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAM_in_drop_stream_statement1799 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_stream_statement1803 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_stream_statement1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_stream_statement1828 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAM_in_show_stream_statement1830 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_stream_statement1834 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_stream_statement1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_streams_statement1859 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STREAMS_in_show_streams_statement1861 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_streams_statement1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KILL_in_kill_job_statement1886 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_kill_job_statement1888 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_kill_job_statement1892 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_kill_job_statement1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMIT_in_commit_statement1917 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_commit_statement1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_source_meta_name1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value1996 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_source_meta_value2000 = new BitSet(new long[]{0x1000001100000000L});
    public static final BitSet FOLLOW_set_in_source_meta_value2002 = new BitSet(new long[]{0x1000001100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_name_in_source_meta_def2036 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_source_meta_value_in_source_meta_def2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2093 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_source_meta_defs2098 = new BitSet(new long[]{0x0000000000000000L,0x00000000007FF400L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2104 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_source_statement2131 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCE_in_create_source_statement2133 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_source_statement2137 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_META_in_create_source_statement2139 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_create_source_statement2141 = new BitSet(new long[]{0x0000000000000000L,0x00000000007FF400L});
    public static final BitSet FOLLOW_ddl_source_meta_defs_in_create_source_statement2145 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_create_source_statement2147 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_source_statement2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_source_statement2172 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCE_in_drop_source_statement2174 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_source_statement2178 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_source_statement2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_source_statement2203 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCE_in_show_source_statement2205 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_source_statement2209 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_source_statement2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_sources_statement2234 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_SOURCES_in_show_sources_statement2236 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_sources_statement2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_job_statement2261 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_drop_job_statement2263 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_job_statement2267 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_job_statement2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_job_statement2292 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_show_job_statement2294 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_job_statement2298 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_job_statement2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_jobs_statement2323 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_JOBS_in_show_jobs_statement2325 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_jobs_statement2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_cluster_statement2350 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_CLUSTER_in_show_cluster_statement2352 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_cluster_statement2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_system_statement2377 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SYSTEM_in_show_system_statement2379 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_system_statement2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SNAPSHOT_in_snapshot_job_statement2404 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_snapshot_job_statement2406 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_snapshot_job_statement2410 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_snapshot_job_statement2412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred30_TOMMY_SQL965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred41_TOMMY_SQL1228 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred41_TOMMY_SQL1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred42_TOMMY_SQL1238 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_synpred42_TOMMY_SQL1244 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_WHERE_in_synpred42_TOMMY_SQL1246 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred42_TOMMY_SQL1250 = new BitSet(new long[]{0x0000000000000002L});

}