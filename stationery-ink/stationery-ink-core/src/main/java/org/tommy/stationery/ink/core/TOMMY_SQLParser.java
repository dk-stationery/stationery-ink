// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/core/TOMMY_SQL.g 2015-06-15 13:21:20

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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:102:1: create_statement : ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ ;
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

        update_statement_return update_statement11 = null;

        upsert_statement_return upsert_statement12 = null;

        lookup_statement_return lookup_statement13 = null;

        select_statement_return select_statement14 = null;

        create_stream_statement_return create_stream_statement15 = null;

        create_source_statement_return create_source_statement16 = null;

        show_stream_statement_return show_stream_statement17 = null;

        show_source_statement_return show_source_statement18 = null;

        drop_stream_statement_return drop_stream_statement19 = null;

        drop_source_statement_return drop_source_statement20 = null;

        drop_job_statement_return drop_job_statement21 = null;

        show_job_statement_return show_job_statement22 = null;

        delete_statement_return delete_statement23 = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:5: ( ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:7: ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:7: ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
            int cnt1=0;
            loop1:
            do {
                int alt1=24;
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:206: update_statement
            	    {
            	    pushFollow(FOLLOW_update_statement_in_create_statement617);
            	    update_statement11=update_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, update_statement11.getTree());

            	    }
            	    break;
            	case 12 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:223: upsert_statement
            	    {
            	    pushFollow(FOLLOW_upsert_statement_in_create_statement619);
            	    upsert_statement12=upsert_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, upsert_statement12.getTree());

            	    }
            	    break;
            	case 13 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:240: lookup_statement
            	    {
            	    pushFollow(FOLLOW_lookup_statement_in_create_statement621);
            	    lookup_statement13=lookup_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, lookup_statement13.getTree());

            	    }
            	    break;
            	case 14 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:257: select_statement
            	    {
            	    pushFollow(FOLLOW_select_statement_in_create_statement623);
            	    select_statement14=select_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement14.getTree());

            	    }
            	    break;
            	case 15 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:274: create_stream_statement
            	    {
            	    pushFollow(FOLLOW_create_stream_statement_in_create_statement625);
            	    create_stream_statement15=create_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_stream_statement15.getTree());

            	    }
            	    break;
            	case 16 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:298: create_source_statement
            	    {
            	    pushFollow(FOLLOW_create_source_statement_in_create_statement627);
            	    create_source_statement16=create_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, create_source_statement16.getTree());

            	    }
            	    break;
            	case 17 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:322: show_stream_statement
            	    {
            	    pushFollow(FOLLOW_show_stream_statement_in_create_statement629);
            	    show_stream_statement17=show_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_stream_statement17.getTree());

            	    }
            	    break;
            	case 18 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:344: show_source_statement
            	    {
            	    pushFollow(FOLLOW_show_source_statement_in_create_statement631);
            	    show_source_statement18=show_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_source_statement18.getTree());

            	    }
            	    break;
            	case 19 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:366: drop_stream_statement
            	    {
            	    pushFollow(FOLLOW_drop_stream_statement_in_create_statement633);
            	    drop_stream_statement19=drop_stream_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_stream_statement19.getTree());

            	    }
            	    break;
            	case 20 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:388: drop_source_statement
            	    {
            	    pushFollow(FOLLOW_drop_source_statement_in_create_statement635);
            	    drop_source_statement20=drop_source_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_source_statement20.getTree());

            	    }
            	    break;
            	case 21 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:410: drop_job_statement
            	    {
            	    pushFollow(FOLLOW_drop_job_statement_in_create_statement637);
            	    drop_job_statement21=drop_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_job_statement21.getTree());

            	    }
            	    break;
            	case 22 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:429: show_job_statement
            	    {
            	    pushFollow(FOLLOW_show_job_statement_in_create_statement639);
            	    show_job_statement22=show_job_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, show_job_statement22.getTree());

            	    }
            	    break;
            	case 23 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:103:448: delete_statement
            	    {
            	    pushFollow(FOLLOW_delete_statement_in_create_statement641);
            	    delete_statement23=delete_statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, delete_statement23.getTree());

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

            n=(Token)match(input,NAME,FOLLOW_NAME_in_use_name_def675); if (state.failed) return retval;
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

        Token USE24=null;
        Token SEMICOLON25=null;
        set_name_def_return column = null;


        Object USE24_tree=null;
        Object SEMICOLON25_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:115:5: ( USE column= set_name_def SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:115:7: USE column= set_name_def SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            USE24=(Token)match(input,USE,FOLLOW_USE_in_use_statement694); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            USE24_tree = (Object)adaptor.create(USE24);
            adaptor.addChild(root_0, USE24_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_use_statement698);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            SEMICOLON25=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_use_statement700); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON25_tree = (Object)adaptor.create(SEMICOLON25);
            adaptor.addChild(root_0, SEMICOLON25_tree);
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

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_name_def732); if (state.failed) return retval;
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

            n=(Token)match(input,NAME,FOLLOW_NAME_in_set_value_def760); if (state.failed) return retval;
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

        Token SET26=null;
        Token EQUAL27=null;
        Token SINGLE_QUOTE28=null;
        Token SINGLE_QUOTE29=null;
        Token SEMICOLON30=null;
        set_name_def_return column = null;

        set_value_def_return value = null;


        Object SET26_tree=null;
        Object EQUAL27_tree=null;
        Object SINGLE_QUOTE28_tree=null;
        Object SINGLE_QUOTE29_tree=null;
        Object SEMICOLON30_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:137:5: ( SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:137:7: SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SET26=(Token)match(input,SET,FOLLOW_SET_in_set_statement780); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SET26_tree = (Object)adaptor.create(SET26);
            adaptor.addChild(root_0, SET26_tree);
            }
            pushFollow(FOLLOW_set_name_def_in_set_statement784);
            column=set_name_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
            EQUAL27=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_set_statement786); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EQUAL27_tree = (Object)adaptor.create(EQUAL27);
            adaptor.addChild(root_0, EQUAL27_tree);
            }
            SINGLE_QUOTE28=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE28_tree = (Object)adaptor.create(SINGLE_QUOTE28);
            adaptor.addChild(root_0, SINGLE_QUOTE28_tree);
            }
            pushFollow(FOLLOW_set_value_def_in_set_statement792);
            value=set_value_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, value.getTree());
            SINGLE_QUOTE29=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement794); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE29_tree = (Object)adaptor.create(SINGLE_QUOTE29);
            adaptor.addChild(root_0, SINGLE_QUOTE29_tree);
            }
            SEMICOLON30=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_set_statement796); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON30_tree = (Object)adaptor.create(SEMICOLON30);
            adaptor.addChild(root_0, SEMICOLON30_tree);
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
        Token LSQUARE31=null;
        Token COLON32=null;
        Token RSQUARE33=null;

        Object n_tree=null;
        Object b_tree=null;
        Object LSQUARE31_tree=null;
        Object COLON32_tree=null;
        Object RSQUARE33_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:152:5: ( LSQUARE n= NAME COLON b= NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:152:9: LSQUARE n= NAME COLON b= NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            LSQUARE31=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_table_name826); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LSQUARE31_tree = (Object)adaptor.create(LSQUARE31);
            adaptor.addChild(root_0, LSQUARE31_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name830); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON32=(Token)match(input,COLON,FOLLOW_COLON_in_dml_table_name832); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON32_tree = (Object)adaptor.create(COLON32);
            adaptor.addChild(root_0, COLON32_tree);
            }
            b=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name836); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            b_tree = (Object)adaptor.create(b);
            adaptor.addChild(root_0, b_tree);
            }
            RSQUARE33=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_table_name838); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE33_tree = (Object)adaptor.create(RSQUARE33);
            adaptor.addChild(root_0, RSQUARE33_tree);
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
        Token COLON34=null;
        Token NAME35=null;
        Token RSQUARE36=null;

        Object n_tree=null;
        Object COLON34_tree=null;
        Object NAME35_tree=null;
        Object RSQUARE36_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:161:5: (n= LSQUARE COLON NAME RSQUARE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:161:9: n= LSQUARE COLON NAME RSQUARE
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_bind_column_name865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            COLON34=(Token)match(input,COLON,FOLLOW_COLON_in_dml_bind_column_name867); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON34_tree = (Object)adaptor.create(COLON34);
            adaptor.addChild(root_0, COLON34_tree);
            }
            NAME35=(Token)match(input,NAME,FOLLOW_NAME_in_dml_bind_column_name869); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME35_tree = (Object)adaptor.create(NAME35);
            adaptor.addChild(root_0, NAME35_tree);
            }
            RSQUARE36=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_bind_column_name871); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RSQUARE36_tree = (Object)adaptor.create(RSQUARE36);
            adaptor.addChild(root_0, RSQUARE36_tree);
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
        Token NAME37=null;
        Token NAME38=null;

        Object n_tree=null;
        Object NAME37_tree=null;
        Object NAME38_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:166:11: NAME ( NAME )*
            {
            NAME37=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where898); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME37_tree = (Object)adaptor.create(NAME37);
            adaptor.addChild(root_0, NAME37_tree);
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
            	    NAME38=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where901); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME38_tree = (Object)adaptor.create(NAME38);
            	    adaptor.addChild(root_0, NAME38_tree);
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
        Token NAME39=null;
        Token NAME40=null;

        Object n_tree=null;
        Object NAME39_tree=null;
        Object NAME40_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:5: (n= ( NAME ( NAME )* ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:8: n= ( NAME ( NAME )* )
            {
            root_0 = (Object)adaptor.nil();

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:10: ( NAME ( NAME )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:170:11: NAME ( NAME )*
            {
            NAME39=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body931); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME39_tree = (Object)adaptor.create(NAME39);
            adaptor.addChild(root_0, NAME39_tree);
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
            	    NAME40=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body934); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NAME40_tree = (Object)adaptor.create(NAME40);
            	    adaptor.addChild(root_0, NAME40_tree);
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
        Token SEMICOLON41=null;

        Object n_tree=null;
        Object SEMICOLON41_tree=null;

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

            SEMICOLON41=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON41_tree = (Object)adaptor.create(SEMICOLON41);
            adaptor.addChild(root_0, SEMICOLON41_tree);
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

        Token LOOKUP42=null;
        Token WHERE43=null;
        Token SEMICOLON44=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object LOOKUP42_tree=null;
        Object WHERE43_tree=null;
        Object SEMICOLON44_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:5: ( LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:7: LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            LOOKUP42=(Token)match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup_statement1030); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOOKUP42_tree = (Object)adaptor.create(LOOKUP42);
            adaptor.addChild(root_0, LOOKUP42_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_lookup_statement1036);
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
                    WHERE43=(Token)match(input,WHERE,FOLLOW_WHERE_in_lookup_statement1039); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE43_tree = (Object)adaptor.create(WHERE43);
                    adaptor.addChild(root_0, WHERE43_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1045);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:182:96: SEMICOLON
                    {
                    SEMICOLON44=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lookup_statement1047); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON44_tree = (Object)adaptor.create(SEMICOLON44);
                    adaptor.addChild(root_0, SEMICOLON44_tree);
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

        Token SELECT45=null;
        Token WHERE46=null;
        Token SEMICOLON47=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object SELECT45_tree=null;
        Object WHERE46_tree=null;
        Object SEMICOLON47_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:5: ( SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:7: SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            SELECT45=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_statement1071); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SELECT45_tree = (Object)adaptor.create(SELECT45);
            adaptor.addChild(root_0, SELECT45_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_select_statement1077);
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
                    WHERE46=(Token)match(input,WHERE,FOLLOW_WHERE_in_select_statement1080); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE46_tree = (Object)adaptor.create(WHERE46);
                    adaptor.addChild(root_0, WHERE46_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_select_statement1086);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:195:96: SEMICOLON
                    {
                    SEMICOLON47=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_select_statement1088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON47_tree = (Object)adaptor.create(SEMICOLON47);
                    adaptor.addChild(root_0, SEMICOLON47_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:208:1: upsert_statement : UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final upsert_statement_return upsert_statement() throws RecognitionException {
        upsert_statement_return retval = new upsert_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPSERT48=null;
        Token INTO49=null;
        Token VALUES50=null;
        Token INCREASE51=null;
        Token VALUES52=null;
        Token SEMICOLON53=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object UPSERT48_tree=null;
        Object INTO49_tree=null;
        Object VALUES50_tree=null;
        Object INCREASE51_tree=null;
        Object VALUES52_tree=null;
        Object SEMICOLON53_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:209:5: ( UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:209:7: UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPSERT48=(Token)match(input,UPSERT,FOLLOW_UPSERT_in_upsert_statement1112); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPSERT48_tree = (Object)adaptor.create(UPSERT48);
            adaptor.addChild(root_0, UPSERT48_tree);
            }
            INTO49=(Token)match(input,INTO,FOLLOW_INTO_in_upsert_statement1114); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTO49_tree = (Object)adaptor.create(INTO49);
            adaptor.addChild(root_0, INTO49_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_upsert_statement1120);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:209:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:209:57: VALUES body2= dml_lookup_select_where_body2
                    {
                    VALUES50=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1123); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES50_tree = (Object)adaptor.create(VALUES50);
                    adaptor.addChild(root_0, VALUES50_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1129);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:209:102: INCREASE VALUES body2= dml_lookup_select_where_body2
                    {
                    INCREASE51=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_upsert_statement1131); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INCREASE51_tree = (Object)adaptor.create(INCREASE51);
                    adaptor.addChild(root_0, INCREASE51_tree);
                    }
                    VALUES52=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1133); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VALUES52_tree = (Object)adaptor.create(VALUES52);
                    adaptor.addChild(root_0, VALUES52_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1139);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:209:156: SEMICOLON
                    {
                    SEMICOLON53=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_upsert_statement1141); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:223:1: update_statement : UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final update_statement_return update_statement() throws RecognitionException {
        update_statement_return retval = new update_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UPDATE54=null;
        Token SET55=null;
        Token SET56=null;
        Token WHERE57=null;
        Token SEMICOLON58=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;

        dml_lookup_select_where_body_return body3 = null;

        dml_lookup_select_where_body2_return body4 = null;


        Object UPDATE54_tree=null;
        Object SET55_tree=null;
        Object SET56_tree=null;
        Object WHERE57_tree=null;
        Object SEMICOLON58_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:5: ( UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:7: UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            UPDATE54=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_update_statement1165); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UPDATE54_tree = (Object)adaptor.create(UPDATE54);
            adaptor.addChild(root_0, UPDATE54_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1171);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:52: SET body2= dml_lookup_select_where_body2
                    {
                    SET55=(Token)match(input,SET,FOLLOW_SET_in_update_statement1174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET55_tree = (Object)adaptor.create(SET55);
                    adaptor.addChild(root_0, SET55_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1180);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
                    {
                    SET56=(Token)match(input,SET,FOLLOW_SET_in_update_statement1184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SET56_tree = (Object)adaptor.create(SET56);
                    adaptor.addChild(root_0, SET56_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1190);
                    body3=dml_lookup_select_where_body();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());
                    WHERE57=(Token)match(input,WHERE,FOLLOW_WHERE_in_update_statement1192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE57_tree = (Object)adaptor.create(WHERE57);
                    adaptor.addChild(root_0, WHERE57_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1196);
                    body4=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body4.getTree());

                    }
                    break;
                case 3 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:179: SEMICOLON
                    {
                    SEMICOLON58=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_update_statement1198); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON58_tree = (Object)adaptor.create(SEMICOLON58);
                    adaptor.addChild(root_0, SEMICOLON58_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:238:1: delete_statement : DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
    public final delete_statement_return delete_statement() throws RecognitionException {
        delete_statement_return retval = new delete_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DELETE59=null;
        Token FROM60=null;
        Token WHERE61=null;
        Token SEMICOLON62=null;
        dml_lookup_select_where_body_return body1 = null;

        dml_lookup_select_where_body2_return body2 = null;


        Object DELETE59_tree=null;
        Object FROM60_tree=null;
        Object WHERE61_tree=null;
        Object SEMICOLON62_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:239:5: ( DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:239:7: DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
            {
            root_0 = (Object)adaptor.nil();

            DELETE59=(Token)match(input,DELETE,FOLLOW_DELETE_in_delete_statement1222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DELETE59_tree = (Object)adaptor.create(DELETE59);
            adaptor.addChild(root_0, DELETE59_tree);
            }
            FROM60=(Token)match(input,FROM,FOLLOW_FROM_in_delete_statement1224); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FROM60_tree = (Object)adaptor.create(FROM60);
            adaptor.addChild(root_0, FROM60_tree);
            }
            pushFollow(FOLLOW_dml_lookup_select_where_body_in_delete_statement1230);
            body1=dml_lookup_select_where_body();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:239:56: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:239:57: WHERE body2= dml_lookup_select_where_body2
                    {
                    WHERE61=(Token)match(input,WHERE,FOLLOW_WHERE_in_delete_statement1233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WHERE61_tree = (Object)adaptor.create(WHERE61);
                    adaptor.addChild(root_0, WHERE61_tree);
                    }
                    pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1239);
                    body2=dml_lookup_select_where_body2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

                    }
                    break;
                case 2 :
                    // org/tommy/stationery/ink/core/TOMMY_SQL.g:239:101: SEMICOLON
                    {
                    SEMICOLON62=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_delete_statement1241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON62_tree = (Object)adaptor.create(SEMICOLON62);
                    adaptor.addChild(root_0, SEMICOLON62_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:252:1: ddl_table_name returns [BaseTableDef ret] : n= NAME ;
    public final ddl_table_name_return ddl_table_name() throws RecognitionException {
        ddl_table_name_return retval = new ddl_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:253:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:253:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_table_name1273); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:260:1: ddl_column_pk returns [boolean ret] : n= 'PARTITION_KEY' ;
    public final ddl_column_pk_return ddl_column_pk() throws RecognitionException {
        ddl_column_pk_return retval = new ddl_column_pk_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:261:5: (n= 'PARTITION_KEY' )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:262:9: n= 'PARTITION_KEY'
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,69,FOLLOW_69_in_ddl_column_pk1306); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:265:1: ddl_column_comment returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final ddl_column_comment_return ddl_column_comment() throws RecognitionException {
        ddl_column_comment_return retval = new ddl_column_comment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE63=null;
        Token SINGLE_QUOTE64=null;

        Object n_tree=null;
        Object SINGLE_QUOTE63_tree=null;
        Object SINGLE_QUOTE64_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:266:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:266:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE63=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1331); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE63_tree = (Object)adaptor.create(SINGLE_QUOTE63);
            adaptor.addChild(root_0, SINGLE_QUOTE63_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_comment1335); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE64=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1337); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE64_tree = (Object)adaptor.create(SINGLE_QUOTE64);
            adaptor.addChild(root_0, SINGLE_QUOTE64_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:269:1: ddl_column_name returns [String ret] : n= NAME ;
    public final ddl_column_name_return ddl_column_name() throws RecognitionException {
        ddl_column_name_return retval = new ddl_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:270:5: (n= NAME )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:270:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_name1364); if (state.failed) return retval;
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:273:1: ddl_column_type returns [ColumnDataTypeEnum ret] : n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) ;
    public final ddl_column_type_return ddl_column_type() throws RecognitionException {
        ddl_column_type_return retval = new ddl_column_type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:274:5: (n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:274:9: n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' )
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:278:1: ddl_column_defs returns [List<BaseColumnDef> ret] : v= column_def ( COMMA v= column_def )* ;
    public final ddl_column_defs_return ddl_column_defs() throws RecognitionException {
        ddl_column_defs_return retval = new ddl_column_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA65=null;
        column_def_return v = null;


        Object COMMA65_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:279:5: (v= column_def ( COMMA v= column_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:280:9: v= column_def ( COMMA v= column_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_column_def_in_ddl_column_defs1434);
            v=column_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                          retval.ret = new ArrayList<BaseColumnDef>();
                          retval.ret.add(v.ret);

            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:283:11: ( COMMA v= column_def )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:283:12: COMMA v= column_def
            	    {
            	    COMMA65=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_column_defs1439); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA65_tree = (Object)adaptor.create(COMMA65);
            	    adaptor.addChild(root_0, COMMA65_tree);
            	    }
            	    pushFollow(FOLLOW_column_def_in_ddl_column_defs1445);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:286:1: column_def returns [BaseColumnDef ret] : c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* ;
    public final column_def_return column_def() throws RecognitionException {
        column_def_return retval = new column_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ddl_column_name_return c = null;

        ddl_column_type_return dt = null;

        ddl_column_pk_return pk = null;

        ddl_column_comment_return cmt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:287:5: (c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:287:9: c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_ddl_column_name_in_column_def1475);
            c=ddl_column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_ddl_column_type_in_column_def1479);
            dt=ddl_column_type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:287:46: (pk= ddl_column_pk )*
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case 69:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:287:47: pk= ddl_column_pk
            	    {
            	    pushFollow(FOLLOW_ddl_column_pk_in_column_def1484);
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

            // org/tommy/stationery/ink/core/TOMMY_SQL.g:287:66: (cmt= ddl_column_comment )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:287:67: cmt= ddl_column_comment
            	    {
            	    pushFollow(FOLLOW_ddl_column_comment_in_column_def1491);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:294:1: stream_meta_name returns [String ret] : n= ( 'TOPIC' | 'COMMENT' ) ;
    public final stream_meta_name_return stream_meta_name() throws RecognitionException {
        stream_meta_name_return retval = new stream_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:295:5: (n= ( 'TOPIC' | 'COMMENT' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:295:9: n= ( 'TOPIC' | 'COMMENT' )
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:298:1: stream_meta_value returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
    public final stream_meta_value_return stream_meta_value() throws RecognitionException {
        stream_meta_value_return retval = new stream_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE66=null;
        Token SINGLE_QUOTE67=null;

        Object n_tree=null;
        Object SINGLE_QUOTE66_tree=null;
        Object SINGLE_QUOTE67_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:299:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:299:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE66=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1558); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE66_tree = (Object)adaptor.create(SINGLE_QUOTE66);
            adaptor.addChild(root_0, SINGLE_QUOTE66_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_stream_meta_value1562); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            SINGLE_QUOTE67=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1564); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE67_tree = (Object)adaptor.create(SINGLE_QUOTE67);
            adaptor.addChild(root_0, SINGLE_QUOTE67_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:302:1: stream_meta_def returns [BaseMetaDef ret] : c= stream_meta_name dt= stream_meta_value ;
    public final stream_meta_def_return stream_meta_def() throws RecognitionException {
        stream_meta_def_return retval = new stream_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        stream_meta_name_return c = null;

        stream_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:303:5: (c= stream_meta_name dt= stream_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:303:9: c= stream_meta_name dt= stream_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_name_in_stream_meta_def1591);
            c=stream_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_stream_meta_value_in_stream_meta_def1595);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:307:1: ddl_stream_meta_defs returns [List<BaseMetaDef> ret] : v= stream_meta_def ( COMMA v= stream_meta_def )* ;
    public final ddl_stream_meta_defs_return ddl_stream_meta_defs() throws RecognitionException {
        ddl_stream_meta_defs_return retval = new ddl_stream_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA68=null;
        stream_meta_def_return v = null;


        Object COMMA68_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:308:10: (v= stream_meta_def ( COMMA v= stream_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:309:14: v= stream_meta_def ( COMMA v= stream_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1648);
            v=stream_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);

            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:312:16: ( COMMA v= stream_meta_def )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:312:17: COMMA v= stream_meta_def
            	    {
            	    COMMA68=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_stream_meta_defs1653); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA68_tree = (Object)adaptor.create(COMMA68);
            	    adaptor.addChild(root_0, COMMA68_tree);
            	    }
            	    pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1659);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:315:1: create_stream_statement : CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON ;
    public final create_stream_statement_return create_stream_statement() throws RecognitionException {
        create_stream_statement_return retval = new create_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE69=null;
        Token STREAM70=null;
        Token LPAREN71=null;
        Token RPAREN72=null;
        Token META73=null;
        Token LPAREN74=null;
        Token RPAREN75=null;
        Token SEMICOLON76=null;
        ddl_table_name_return table_name = null;

        ddl_column_defs_return columns = null;

        ddl_stream_meta_defs_return metas = null;


        Object CREATE69_tree=null;
        Object STREAM70_tree=null;
        Object LPAREN71_tree=null;
        Object RPAREN72_tree=null;
        Object META73_tree=null;
        Object LPAREN74_tree=null;
        Object RPAREN75_tree=null;
        Object SEMICOLON76_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:316:5: ( CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:316:7: CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE69=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_stream_statement1686); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE69_tree = (Object)adaptor.create(CREATE69);
            adaptor.addChild(root_0, CREATE69_tree);
            }
            STREAM70=(Token)match(input,STREAM,FOLLOW_STREAM_in_create_stream_statement1688); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM70_tree = (Object)adaptor.create(STREAM70);
            adaptor.addChild(root_0, STREAM70_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_stream_statement1692);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            LPAREN71=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1702); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN71_tree = (Object)adaptor.create(LPAREN71);
            adaptor.addChild(root_0, LPAREN71_tree);
            }
            pushFollow(FOLLOW_ddl_column_defs_in_create_stream_statement1706);
            columns=ddl_column_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, columns.getTree());
            RPAREN72=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1708); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN72_tree = (Object)adaptor.create(RPAREN72);
            adaptor.addChild(root_0, RPAREN72_tree);
            }
            META73=(Token)match(input,META,FOLLOW_META_in_create_stream_statement1710); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META73_tree = (Object)adaptor.create(META73);
            adaptor.addChild(root_0, META73_tree);
            }
            LPAREN74=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1712); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN74_tree = (Object)adaptor.create(LPAREN74);
            adaptor.addChild(root_0, LPAREN74_tree);
            }
            pushFollow(FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1716);
            metas=ddl_stream_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN75=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1718); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN75_tree = (Object)adaptor.create(RPAREN75);
            adaptor.addChild(root_0, RPAREN75_tree);
            }
            SEMICOLON76=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_stream_statement1720); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON76_tree = (Object)adaptor.create(SEMICOLON76);
            adaptor.addChild(root_0, SEMICOLON76_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:330:1: drop_stream_statement : DROP STREAM table_name= ddl_table_name SEMICOLON ;
    public final drop_stream_statement_return drop_stream_statement() throws RecognitionException {
        drop_stream_statement_return retval = new drop_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP77=null;
        Token STREAM78=null;
        Token SEMICOLON79=null;
        ddl_table_name_return table_name = null;


        Object DROP77_tree=null;
        Object STREAM78_tree=null;
        Object SEMICOLON79_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:331:5: ( DROP STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:331:7: DROP STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP77=(Token)match(input,DROP,FOLLOW_DROP_in_drop_stream_statement1743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP77_tree = (Object)adaptor.create(DROP77);
            adaptor.addChild(root_0, DROP77_tree);
            }
            STREAM78=(Token)match(input,STREAM,FOLLOW_STREAM_in_drop_stream_statement1745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM78_tree = (Object)adaptor.create(STREAM78);
            adaptor.addChild(root_0, STREAM78_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_stream_statement1749);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON79=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_stream_statement1751); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON79_tree = (Object)adaptor.create(SEMICOLON79);
            adaptor.addChild(root_0, SEMICOLON79_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:342:1: show_stream_statement : SHOW STREAM table_name= ddl_table_name SEMICOLON ;
    public final show_stream_statement_return show_stream_statement() throws RecognitionException {
        show_stream_statement_return retval = new show_stream_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW80=null;
        Token STREAM81=null;
        Token SEMICOLON82=null;
        ddl_table_name_return table_name = null;


        Object SHOW80_tree=null;
        Object STREAM81_tree=null;
        Object SEMICOLON82_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:343:5: ( SHOW STREAM table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:343:7: SHOW STREAM table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW80=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_stream_statement1774); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW80_tree = (Object)adaptor.create(SHOW80);
            adaptor.addChild(root_0, SHOW80_tree);
            }
            STREAM81=(Token)match(input,STREAM,FOLLOW_STREAM_in_show_stream_statement1776); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM81_tree = (Object)adaptor.create(STREAM81);
            adaptor.addChild(root_0, STREAM81_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_stream_statement1780);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON82=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_stream_statement1782); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON82_tree = (Object)adaptor.create(SEMICOLON82);
            adaptor.addChild(root_0, SEMICOLON82_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:354:1: show_streams_statement : SHOW STREAMS SEMICOLON ;
    public final show_streams_statement_return show_streams_statement() throws RecognitionException {
        show_streams_statement_return retval = new show_streams_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW83=null;
        Token STREAMS84=null;
        Token SEMICOLON85=null;

        Object SHOW83_tree=null;
        Object STREAMS84_tree=null;
        Object SEMICOLON85_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:355:5: ( SHOW STREAMS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:355:7: SHOW STREAMS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW83=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_streams_statement1805); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW83_tree = (Object)adaptor.create(SHOW83);
            adaptor.addChild(root_0, SHOW83_tree);
            }
            STREAMS84=(Token)match(input,STREAMS,FOLLOW_STREAMS_in_show_streams_statement1807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAMS84_tree = (Object)adaptor.create(STREAMS84);
            adaptor.addChild(root_0, STREAMS84_tree);
            }
            SEMICOLON85=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_streams_statement1809); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON85_tree = (Object)adaptor.create(SEMICOLON85);
            adaptor.addChild(root_0, SEMICOLON85_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:365:1: kill_job_statement : KILL JOB table_name= ddl_table_name SEMICOLON ;
    public final kill_job_statement_return kill_job_statement() throws RecognitionException {
        kill_job_statement_return retval = new kill_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KILL86=null;
        Token JOB87=null;
        Token SEMICOLON88=null;
        ddl_table_name_return table_name = null;


        Object KILL86_tree=null;
        Object JOB87_tree=null;
        Object SEMICOLON88_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:366:5: ( KILL JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:366:7: KILL JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            KILL86=(Token)match(input,KILL,FOLLOW_KILL_in_kill_job_statement1832); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KILL86_tree = (Object)adaptor.create(KILL86);
            adaptor.addChild(root_0, KILL86_tree);
            }
            JOB87=(Token)match(input,JOB,FOLLOW_JOB_in_kill_job_statement1834); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB87_tree = (Object)adaptor.create(JOB87);
            adaptor.addChild(root_0, JOB87_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_kill_job_statement1838);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON88=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_kill_job_statement1840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON88_tree = (Object)adaptor.create(SEMICOLON88);
            adaptor.addChild(root_0, SEMICOLON88_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:377:1: commit_statement : COMMIT SEMICOLON ;
    public final commit_statement_return commit_statement() throws RecognitionException {
        commit_statement_return retval = new commit_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMIT89=null;
        Token SEMICOLON90=null;

        Object COMMIT89_tree=null;
        Object SEMICOLON90_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:378:5: ( COMMIT SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:378:7: COMMIT SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            COMMIT89=(Token)match(input,COMMIT,FOLLOW_COMMIT_in_commit_statement1863); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COMMIT89_tree = (Object)adaptor.create(COMMIT89);
            adaptor.addChild(root_0, COMMIT89_tree);
            }
            SEMICOLON90=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_commit_statement1865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON90_tree = (Object)adaptor.create(SEMICOLON90);
            adaptor.addChild(root_0, SEMICOLON90_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:384:1: source_meta_name returns [String ret] : n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) ;
    public final source_meta_name_return source_meta_name() throws RecognitionException {
        source_meta_name_return retval = new source_meta_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:385:5: (n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:385:9: n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' )
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:388:1: source_meta_value returns [String ret] : SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE ;
    public final source_meta_value_return source_meta_value() throws RecognitionException {
        source_meta_value_return retval = new source_meta_value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token SINGLE_QUOTE91=null;
        Token set92=null;
        Token SINGLE_QUOTE93=null;

        Object n_tree=null;
        Object SINGLE_QUOTE91_tree=null;
        Object set92_tree=null;
        Object SINGLE_QUOTE93_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:389:5: ( SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:389:9: SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE
            {
            root_0 = (Object)adaptor.nil();

            SINGLE_QUOTE91=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value1942); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE91_tree = (Object)adaptor.create(SINGLE_QUOTE91);
            adaptor.addChild(root_0, SINGLE_QUOTE91_tree);
            }
            n=(Token)match(input,NAME,FOLLOW_NAME_in_source_meta_value1946); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:389:29: ( NAME | COMMA )*
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
            	    set92=(Token)input.LT(1);
            	    if ( input.LA(1)==COMMA||input.LA(1)==NAME ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set92));
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

            SINGLE_QUOTE93=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value1955); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SINGLE_QUOTE93_tree = (Object)adaptor.create(SINGLE_QUOTE93);
            adaptor.addChild(root_0, SINGLE_QUOTE93_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:392:1: source_meta_def returns [BaseMetaDef ret] : c= source_meta_name dt= source_meta_value ;
    public final source_meta_def_return source_meta_def() throws RecognitionException {
        source_meta_def_return retval = new source_meta_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        source_meta_name_return c = null;

        source_meta_value_return dt = null;



        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:393:5: (c= source_meta_name dt= source_meta_value )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:393:9: c= source_meta_name dt= source_meta_value
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_name_in_source_meta_def1982);
            c=source_meta_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            pushFollow(FOLLOW_source_meta_value_in_source_meta_def1986);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:397:1: ddl_source_meta_defs returns [List<BaseMetaDef> ret] : v= source_meta_def ( COMMA v= source_meta_def )* ;
    public final ddl_source_meta_defs_return ddl_source_meta_defs() throws RecognitionException {
        ddl_source_meta_defs_return retval = new ddl_source_meta_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA94=null;
        source_meta_def_return v = null;


        Object COMMA94_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:398:10: (v= source_meta_def ( COMMA v= source_meta_def )* )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:399:14: v= source_meta_def ( COMMA v= source_meta_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2039);
            v=source_meta_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                               retval.ret = new ArrayList<BaseMetaDef>();
                               retval.ret.add(v.ret);

            }
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:402:16: ( COMMA v= source_meta_def )*
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
            	    // org/tommy/stationery/ink/core/TOMMY_SQL.g:402:17: COMMA v= source_meta_def
            	    {
            	    COMMA94=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_source_meta_defs2044); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA94_tree = (Object)adaptor.create(COMMA94);
            	    adaptor.addChild(root_0, COMMA94_tree);
            	    }
            	    pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2050);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:405:1: create_source_statement : CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON ;
    public final create_source_statement_return create_source_statement() throws RecognitionException {
        create_source_statement_return retval = new create_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CREATE95=null;
        Token SOURCE96=null;
        Token META97=null;
        Token LPAREN98=null;
        Token RPAREN99=null;
        Token SEMICOLON100=null;
        ddl_table_name_return table_name = null;

        ddl_source_meta_defs_return metas = null;


        Object CREATE95_tree=null;
        Object SOURCE96_tree=null;
        Object META97_tree=null;
        Object LPAREN98_tree=null;
        Object RPAREN99_tree=null;
        Object SEMICOLON100_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:406:5: ( CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:406:7: CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            CREATE95=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_source_statement2077); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CREATE95_tree = (Object)adaptor.create(CREATE95);
            adaptor.addChild(root_0, CREATE95_tree);
            }
            SOURCE96=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_create_source_statement2079); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE96_tree = (Object)adaptor.create(SOURCE96);
            adaptor.addChild(root_0, SOURCE96_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_create_source_statement2083);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            META97=(Token)match(input,META,FOLLOW_META_in_create_source_statement2085); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            META97_tree = (Object)adaptor.create(META97);
            adaptor.addChild(root_0, META97_tree);
            }
            LPAREN98=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_source_statement2087); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN98_tree = (Object)adaptor.create(LPAREN98);
            adaptor.addChild(root_0, LPAREN98_tree);
            }
            pushFollow(FOLLOW_ddl_source_meta_defs_in_create_source_statement2091);
            metas=ddl_source_meta_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
            RPAREN99=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_source_statement2093); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN99_tree = (Object)adaptor.create(RPAREN99);
            adaptor.addChild(root_0, RPAREN99_tree);
            }
            SEMICOLON100=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_source_statement2095); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON100_tree = (Object)adaptor.create(SEMICOLON100);
            adaptor.addChild(root_0, SEMICOLON100_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:419:1: drop_source_statement : DROP SOURCE table_name= ddl_table_name SEMICOLON ;
    public final drop_source_statement_return drop_source_statement() throws RecognitionException {
        drop_source_statement_return retval = new drop_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP101=null;
        Token SOURCE102=null;
        Token SEMICOLON103=null;
        ddl_table_name_return table_name = null;


        Object DROP101_tree=null;
        Object SOURCE102_tree=null;
        Object SEMICOLON103_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:420:5: ( DROP SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:420:7: DROP SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP101=(Token)match(input,DROP,FOLLOW_DROP_in_drop_source_statement2118); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP101_tree = (Object)adaptor.create(DROP101);
            adaptor.addChild(root_0, DROP101_tree);
            }
            SOURCE102=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_drop_source_statement2120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE102_tree = (Object)adaptor.create(SOURCE102);
            adaptor.addChild(root_0, SOURCE102_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_source_statement2124);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON103=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_source_statement2126); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON103_tree = (Object)adaptor.create(SEMICOLON103);
            adaptor.addChild(root_0, SEMICOLON103_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:431:1: show_source_statement : SHOW SOURCE table_name= ddl_table_name SEMICOLON ;
    public final show_source_statement_return show_source_statement() throws RecognitionException {
        show_source_statement_return retval = new show_source_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW104=null;
        Token SOURCE105=null;
        Token SEMICOLON106=null;
        ddl_table_name_return table_name = null;


        Object SHOW104_tree=null;
        Object SOURCE105_tree=null;
        Object SEMICOLON106_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:432:5: ( SHOW SOURCE table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:432:7: SHOW SOURCE table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW104=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_source_statement2149); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW104_tree = (Object)adaptor.create(SHOW104);
            adaptor.addChild(root_0, SHOW104_tree);
            }
            SOURCE105=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_show_source_statement2151); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCE105_tree = (Object)adaptor.create(SOURCE105);
            adaptor.addChild(root_0, SOURCE105_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_source_statement2155);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON106=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_source_statement2157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON106_tree = (Object)adaptor.create(SEMICOLON106);
            adaptor.addChild(root_0, SEMICOLON106_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:443:1: show_sources_statement : SHOW SOURCES SEMICOLON ;
    public final show_sources_statement_return show_sources_statement() throws RecognitionException {
        show_sources_statement_return retval = new show_sources_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW107=null;
        Token SOURCES108=null;
        Token SEMICOLON109=null;

        Object SHOW107_tree=null;
        Object SOURCES108_tree=null;
        Object SEMICOLON109_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:444:5: ( SHOW SOURCES SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:444:7: SHOW SOURCES SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW107=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_sources_statement2180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW107_tree = (Object)adaptor.create(SHOW107);
            adaptor.addChild(root_0, SHOW107_tree);
            }
            SOURCES108=(Token)match(input,SOURCES,FOLLOW_SOURCES_in_show_sources_statement2182); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SOURCES108_tree = (Object)adaptor.create(SOURCES108);
            adaptor.addChild(root_0, SOURCES108_tree);
            }
            SEMICOLON109=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_sources_statement2184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON109_tree = (Object)adaptor.create(SEMICOLON109);
            adaptor.addChild(root_0, SEMICOLON109_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:454:1: drop_job_statement : DROP JOB table_name= ddl_table_name SEMICOLON ;
    public final drop_job_statement_return drop_job_statement() throws RecognitionException {
        drop_job_statement_return retval = new drop_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DROP110=null;
        Token JOB111=null;
        Token SEMICOLON112=null;
        ddl_table_name_return table_name = null;


        Object DROP110_tree=null;
        Object JOB111_tree=null;
        Object SEMICOLON112_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:455:5: ( DROP JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:455:7: DROP JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            DROP110=(Token)match(input,DROP,FOLLOW_DROP_in_drop_job_statement2207); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DROP110_tree = (Object)adaptor.create(DROP110);
            adaptor.addChild(root_0, DROP110_tree);
            }
            JOB111=(Token)match(input,JOB,FOLLOW_JOB_in_drop_job_statement2209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB111_tree = (Object)adaptor.create(JOB111);
            adaptor.addChild(root_0, JOB111_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_drop_job_statement2213);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON112=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_job_statement2215); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON112_tree = (Object)adaptor.create(SEMICOLON112);
            adaptor.addChild(root_0, SEMICOLON112_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:466:1: show_job_statement : SHOW JOB table_name= ddl_table_name SEMICOLON ;
    public final show_job_statement_return show_job_statement() throws RecognitionException {
        show_job_statement_return retval = new show_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW113=null;
        Token JOB114=null;
        Token SEMICOLON115=null;
        ddl_table_name_return table_name = null;


        Object SHOW113_tree=null;
        Object JOB114_tree=null;
        Object SEMICOLON115_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:467:5: ( SHOW JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:467:7: SHOW JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW113=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_job_statement2238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW113_tree = (Object)adaptor.create(SHOW113);
            adaptor.addChild(root_0, SHOW113_tree);
            }
            JOB114=(Token)match(input,JOB,FOLLOW_JOB_in_show_job_statement2240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB114_tree = (Object)adaptor.create(JOB114);
            adaptor.addChild(root_0, JOB114_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_show_job_statement2244);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON115=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_job_statement2246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON115_tree = (Object)adaptor.create(SEMICOLON115);
            adaptor.addChild(root_0, SEMICOLON115_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:478:1: show_jobs_statement : SHOW JOBS SEMICOLON ;
    public final show_jobs_statement_return show_jobs_statement() throws RecognitionException {
        show_jobs_statement_return retval = new show_jobs_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW116=null;
        Token JOBS117=null;
        Token SEMICOLON118=null;

        Object SHOW116_tree=null;
        Object JOBS117_tree=null;
        Object SEMICOLON118_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:479:5: ( SHOW JOBS SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:479:7: SHOW JOBS SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW116=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_jobs_statement2269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW116_tree = (Object)adaptor.create(SHOW116);
            adaptor.addChild(root_0, SHOW116_tree);
            }
            JOBS117=(Token)match(input,JOBS,FOLLOW_JOBS_in_show_jobs_statement2271); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOBS117_tree = (Object)adaptor.create(JOBS117);
            adaptor.addChild(root_0, JOBS117_tree);
            }
            SEMICOLON118=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_jobs_statement2273); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON118_tree = (Object)adaptor.create(SEMICOLON118);
            adaptor.addChild(root_0, SEMICOLON118_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:489:1: show_cluster_statement : SHOW CLUSTER SEMICOLON ;
    public final show_cluster_statement_return show_cluster_statement() throws RecognitionException {
        show_cluster_statement_return retval = new show_cluster_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW119=null;
        Token CLUSTER120=null;
        Token SEMICOLON121=null;

        Object SHOW119_tree=null;
        Object CLUSTER120_tree=null;
        Object SEMICOLON121_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:490:5: ( SHOW CLUSTER SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:490:7: SHOW CLUSTER SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW119=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_cluster_statement2296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW119_tree = (Object)adaptor.create(SHOW119);
            adaptor.addChild(root_0, SHOW119_tree);
            }
            CLUSTER120=(Token)match(input,CLUSTER,FOLLOW_CLUSTER_in_show_cluster_statement2298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CLUSTER120_tree = (Object)adaptor.create(CLUSTER120);
            adaptor.addChild(root_0, CLUSTER120_tree);
            }
            SEMICOLON121=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_cluster_statement2300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON121_tree = (Object)adaptor.create(SEMICOLON121);
            adaptor.addChild(root_0, SEMICOLON121_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:500:1: show_system_statement : SHOW SYSTEM SEMICOLON ;
    public final show_system_statement_return show_system_statement() throws RecognitionException {
        show_system_statement_return retval = new show_system_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SHOW122=null;
        Token SYSTEM123=null;
        Token SEMICOLON124=null;

        Object SHOW122_tree=null;
        Object SYSTEM123_tree=null;
        Object SEMICOLON124_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:501:5: ( SHOW SYSTEM SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:501:7: SHOW SYSTEM SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SHOW122=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_system_statement2323); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHOW122_tree = (Object)adaptor.create(SHOW122);
            adaptor.addChild(root_0, SHOW122_tree);
            }
            SYSTEM123=(Token)match(input,SYSTEM,FOLLOW_SYSTEM_in_show_system_statement2325); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SYSTEM123_tree = (Object)adaptor.create(SYSTEM123);
            adaptor.addChild(root_0, SYSTEM123_tree);
            }
            SEMICOLON124=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_system_statement2327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON124_tree = (Object)adaptor.create(SEMICOLON124);
            adaptor.addChild(root_0, SEMICOLON124_tree);
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
    // org/tommy/stationery/ink/core/TOMMY_SQL.g:511:1: snapshot_job_statement : SNAPSHOT JOB table_name= ddl_table_name SEMICOLON ;
    public final snapshot_job_statement_return snapshot_job_statement() throws RecognitionException {
        snapshot_job_statement_return retval = new snapshot_job_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SNAPSHOT125=null;
        Token JOB126=null;
        Token SEMICOLON127=null;
        ddl_table_name_return table_name = null;


        Object SNAPSHOT125_tree=null;
        Object JOB126_tree=null;
        Object SEMICOLON127_tree=null;

        try {
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:512:5: ( SNAPSHOT JOB table_name= ddl_table_name SEMICOLON )
            // org/tommy/stationery/ink/core/TOMMY_SQL.g:512:7: SNAPSHOT JOB table_name= ddl_table_name SEMICOLON
            {
            root_0 = (Object)adaptor.nil();

            SNAPSHOT125=(Token)match(input,SNAPSHOT,FOLLOW_SNAPSHOT_in_snapshot_job_statement2350); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SNAPSHOT125_tree = (Object)adaptor.create(SNAPSHOT125);
            adaptor.addChild(root_0, SNAPSHOT125_tree);
            }
            JOB126=(Token)match(input,JOB,FOLLOW_JOB_in_snapshot_job_statement2352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOB126_tree = (Object)adaptor.create(JOB126);
            adaptor.addChild(root_0, JOB126_tree);
            }
            pushFollow(FOLLOW_ddl_table_name_in_snapshot_job_statement2356);
            table_name=ddl_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            SEMICOLON127=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_snapshot_job_statement2358); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMICOLON127_tree = (Object)adaptor.create(SEMICOLON127);
            adaptor.addChild(root_0, SEMICOLON127_tree);
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

    // $ANTLR start synpred29_TOMMY_SQL
    public final void synpred29_TOMMY_SQL_fragment() throws RecognitionException {
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
    // $ANTLR end synpred29_TOMMY_SQL

    // $ANTLR start synpred38_TOMMY_SQL
    public final void synpred38_TOMMY_SQL_fragment() throws RecognitionException {
        dml_lookup_select_where_body2_return body2 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:52: ( SET body2= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:52: SET body2= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred38_TOMMY_SQL1174); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred38_TOMMY_SQL1180);
        body2=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_TOMMY_SQL

    // $ANTLR start synpred39_TOMMY_SQL
    public final void synpred39_TOMMY_SQL_fragment() throws RecognitionException {
        dml_lookup_select_where_body_return body3 = null;

        dml_lookup_select_where_body2_return body4 = null;


        // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:96: ( SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 )
        // org/tommy/stationery/ink/core/TOMMY_SQL.g:224:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
        {
        match(input,SET,FOLLOW_SET_in_synpred39_TOMMY_SQL1184); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body_in_synpred39_TOMMY_SQL1190);
        body3=dml_lookup_select_where_body();

        state._fsp--;
        if (state.failed) return ;
        match(input,WHERE,FOLLOW_WHERE_in_synpred39_TOMMY_SQL1192); if (state.failed) return ;
        pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred39_TOMMY_SQL1196);
        body4=dml_lookup_select_where_body2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_TOMMY_SQL

    // Delegated rules

    public final boolean synpred29_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_TOMMY_SQL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_TOMMY_SQL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA1_eotS =
        "\34\uffff";
    static final String DFA1_eofS =
        "\1\1\33\uffff";
    static final String DFA1_minS =
        "\1\5\1\uffff\1\4\11\uffff\2\15\16\uffff";
    static final String DFA1_maxS =
        "\1\73\1\uffff\1\67\11\uffff\1\21\1\25\16\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\30\1\uffff\1\2\1\3\1\4\1\5\1\6\1\13\1\14\1\15\1\16\2"+
        "\uffff\1\27\1\1\1\7\1\10\1\11\1\12\1\21\1\22\1\26\1\17\1\20\1\23"+
        "\1\24\1\25";
    static final String DFA1_specialS =
        "\34\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\16\1\13\2\uffff\1\12\1\uffff\1\11\1\14\6\uffff\1\15\1\2\37"+
            "\uffff\1\10\1\7\2\uffff\1\6\1\5\1\4\1\3",
            "",
            "\1\17\10\uffff\1\24\1\21\2\uffff\1\25\1\20\2\uffff\1\26\40"+
            "\uffff\1\22\1\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\27\3\uffff\1\30",
            "\1\31\3\uffff\1\32\3\uffff\1\33",
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
            return "()+ loopback of 103:7: ( show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+";
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
        "\5\uffff\1\34\1\uffff\1\12\5\uffff\1\26\4\uffff\1\11\1\5\5\uffff"+
        "\1\21\4\uffff\1\10\1\uffff\1\32\3\uffff\1\24\1\uffff\1\36\10\uffff"+
        "\1\37\1\uffff\1\15\4\uffff\1\40\4\uffff\1\4\1\uffff\1\33\1\31\1"+
        "\uffff\1\2\3\uffff\1\3\1\35\1\0\5\uffff\1\7\5\uffff\1\27\1\uffff"+
        "\1\25\1\uffff\1\6\4\uffff\1\23\1\1\1\20\1\14\5\uffff\1\30\1\16\1"+
        "\17\1\uffff\1\13\1\22}>";
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
                        int LA4_70 = input.LA(1);

                         
                        int index4_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_70);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_92 = input.LA(1);

                         
                        int index4_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_92);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_64 = input.LA(1);

                         
                        int index4_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_64);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_68 = input.LA(1);

                         
                        int index4_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_68);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_59 = input.LA(1);

                         
                        int index4_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_59);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_19 = input.LA(1);

                         
                        int index4_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_19);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_86 = input.LA(1);

                         
                        int index4_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_86);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_76 = input.LA(1);

                         
                        int index4_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_76);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_30 = input.LA(1);

                         
                        int index4_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_30);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_18 = input.LA(1);

                         
                        int index4_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_18);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_104 = input.LA(1);

                         
                        int index4_104 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_104);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_94 = input.LA(1);

                         
                        int index4_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_94);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_49 = input.LA(1);

                         
                        int index4_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_49);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_101 = input.LA(1);

                         
                        int index4_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_101);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_102 = input.LA(1);

                         
                        int index4_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_102);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA4_93 = input.LA(1);

                         
                        int index4_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_93);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA4_25 = input.LA(1);

                         
                        int index4_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_25);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA4_105 = input.LA(1);

                         
                        int index4_105 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_105);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA4_91 = input.LA(1);

                         
                        int index4_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_91);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA4_36 = input.LA(1);

                         
                        int index4_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_36);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA4_84 = input.LA(1);

                         
                        int index4_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_84);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA4_82 = input.LA(1);

                         
                        int index4_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_82);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA4_100 = input.LA(1);

                         
                        int index4_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_100);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA4_62 = input.LA(1);

                         
                        int index4_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_62);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA4_32 = input.LA(1);

                         
                        int index4_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_32);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA4_61 = input.LA(1);

                         
                        int index4_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_61);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA4_69 = input.LA(1);

                         
                        int index4_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_69);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA4_38 = input.LA(1);

                         
                        int index4_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_38);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA4_47 = input.LA(1);

                         
                        int index4_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_47);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA4_54 = input.LA(1);

                         
                        int index4_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_TOMMY_SQL()) ) {s = 6;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index4_54);
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
        "\1\43\1\4\1\uffff\1\4\1\uffff\3\4\1\0\1\uffff";
    static final String DFA9_maxS =
        "\1\65\1\126\1\uffff\1\126\1\uffff\3\126\1\0\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\3\1\uffff\1\1\4\uffff\1\2";
    static final String DFA9_specialS =
        "\10\uffff\1\0\1\uffff}>";
    static final String[] DFA9_transitionS = {
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
            return "224:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )";
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
                        if ( (synpred38_TOMMY_SQL()) ) {s = 4;}

                        else if ( (synpred39_TOMMY_SQL()) ) {s = 9;}

                         
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
 

    public static final BitSet FOLLOW_show_system_statement_in_create_statement597 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_commit_statement_in_create_statement599 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_use_statement_in_create_statement601 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_snapshot_job_statement_in_create_statement603 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_kill_job_statement_in_create_statement605 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_set_statement_in_create_statement607 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_show_sources_statement_in_create_statement609 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_show_streams_statement_in_create_statement611 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_show_cluster_statement_in_create_statement613 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_show_jobs_statement_in_create_statement615 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_update_statement_in_create_statement617 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_upsert_statement_in_create_statement619 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_lookup_statement_in_create_statement621 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_select_statement_in_create_statement623 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_create_stream_statement_in_create_statement625 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_create_source_statement_in_create_statement627 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_show_stream_statement_in_create_statement629 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_show_source_statement_in_create_statement631 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_drop_stream_statement_in_create_statement633 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_drop_source_statement_in_create_statement635 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_drop_job_statement_in_create_statement637 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_show_job_statement_in_create_statement639 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_delete_statement_in_create_statement641 = new BitSet(new long[]{0x0F30000000181A62L});
    public static final BitSet FOLLOW_NAME_in_use_name_def675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_use_statement694 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_use_statement698 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_use_statement700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_name_def732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_set_value_def760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_set_statement780 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_set_name_def_in_set_statement784 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_EQUAL_in_set_statement786 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement788 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_set_value_def_in_set_statement792 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement794 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_set_statement796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_table_name826 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name830 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_table_name832 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_table_name836 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_table_name838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_dml_bind_column_name865 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_COLON_in_dml_bind_column_name867 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_dml_bind_column_name869 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RSQUARE_in_dml_bind_column_name871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where898 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_lookup_where901 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body931 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dml_select_body934 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body963 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF2L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body2999 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOOKUP_in_lookup_statement1030 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_lookup_statement1036 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_WHERE_in_lookup_statement1039 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_lookup_statement1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement1071 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_select_statement1077 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_WHERE_in_select_statement1080 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_select_statement1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_select_statement1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPSERT_in_upsert_statement1112 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_INTO_in_upsert_statement1114 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_upsert_statement1120 = new BitSet(new long[]{0x0006000800000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1123 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCREASE_in_upsert_statement1131 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_VALUES_in_upsert_statement1133 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_upsert_statement1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_update_statement1165 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1171 = new BitSet(new long[]{0x0020000800000000L});
    public static final BitSet FOLLOW_SET_in_update_statement1174 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_update_statement1184 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1190 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_WHERE_in_update_statement1192 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_update_statement1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_delete_statement1222 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FROM_in_delete_statement1224 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_delete_statement1230 = new BitSet(new long[]{0x0000000800000100L});
    public static final BitSet FOLLOW_WHERE_in_delete_statement1233 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_delete_statement1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_table_name1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ddl_column_pk1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1331 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_comment1335 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_ddl_column_name1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ddl_column_type1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1434 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_column_defs1439 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_column_def_in_ddl_column_defs1445 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ddl_column_name_in_column_def1475 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ddl_column_type_in_column_def1479 = new BitSet(new long[]{0x0000000100000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_ddl_column_pk_in_column_def1484 = new BitSet(new long[]{0x0000000100000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_ddl_column_comment_in_column_def1491 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_set_in_stream_meta_name1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1558 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_stream_meta_value1562 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_name_in_stream_meta_def1591 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_stream_meta_value_in_stream_meta_def1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1648 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_stream_meta_defs1653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1659 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_stream_statement1686 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAM_in_create_stream_statement1688 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_stream_statement1692 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1702 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_column_defs_in_create_stream_statement1706 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1708 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_META_in_create_stream_statement1710 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1716 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1718 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_stream_statement1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_stream_statement1743 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAM_in_drop_stream_statement1745 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_stream_statement1749 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_stream_statement1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_stream_statement1774 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STREAM_in_show_stream_statement1776 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_stream_statement1780 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_stream_statement1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_streams_statement1805 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STREAMS_in_show_streams_statement1807 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_streams_statement1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KILL_in_kill_job_statement1832 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_kill_job_statement1834 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_kill_job_statement1838 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_kill_job_statement1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMIT_in_commit_statement1863 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_commit_statement1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_source_meta_name1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value1942 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_NAME_in_source_meta_value1946 = new BitSet(new long[]{0x1000001100000000L});
    public static final BitSet FOLLOW_set_in_source_meta_value1948 = new BitSet(new long[]{0x1000001100000000L});
    public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_name_in_source_meta_def1982 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_source_meta_value_in_source_meta_def1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2039 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_COMMA_in_ddl_source_meta_defs2044 = new BitSet(new long[]{0x0000000000000000L,0x00000000007FF400L});
    public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2050 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_CREATE_in_create_source_statement2077 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCE_in_create_source_statement2079 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_create_source_statement2083 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_META_in_create_source_statement2085 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LPAREN_in_create_source_statement2087 = new BitSet(new long[]{0x0000000000000000L,0x00000000007FF400L});
    public static final BitSet FOLLOW_ddl_source_meta_defs_in_create_source_statement2091 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_RPAREN_in_create_source_statement2093 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_create_source_statement2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_source_statement2118 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCE_in_drop_source_statement2120 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_source_statement2124 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_source_statement2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_source_statement2149 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_SOURCE_in_show_source_statement2151 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_source_statement2155 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_source_statement2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_sources_statement2180 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_SOURCES_in_show_sources_statement2182 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_sources_statement2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_drop_job_statement2207 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_drop_job_statement2209 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_drop_job_statement2213 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_drop_job_statement2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_job_statement2238 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_show_job_statement2240 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_show_job_statement2244 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_job_statement2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_jobs_statement2269 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_JOBS_in_show_jobs_statement2271 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_jobs_statement2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_cluster_statement2296 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_CLUSTER_in_show_cluster_statement2298 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_cluster_statement2300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_show_system_statement2323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SYSTEM_in_show_system_statement2325 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_show_system_statement2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SNAPSHOT_in_snapshot_job_statement2350 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JOB_in_snapshot_job_statement2352 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ddl_table_name_in_snapshot_job_statement2356 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_snapshot_job_statement2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred29_TOMMY_SQL963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred38_TOMMY_SQL1174 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred38_TOMMY_SQL1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_synpred39_TOMMY_SQL1184 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body_in_synpred39_TOMMY_SQL1190 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_WHERE_in_synpred39_TOMMY_SQL1192 = new BitSet(new long[]{0xFFFFFFF7FFFFFFF0L,0x00000000007FFFE7L});
    public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred39_TOMMY_SQL1196 = new BitSet(new long[]{0x0000000000000002L});

}