// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/core/TOMMY_SQL.g 2015-07-27 13:31:50

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
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "REST", "SYSTEM", "DELETE", "SELECT", "FROM", "WHERE", "LOOKUP", "INSERT", "UPSERT", "CREATE", "STREAM", "STREAMS", "BSTREAM", "BUCKET", "SOURCE", "SOURCES", "DROP", "SHOW", "JOB", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURLY", "RCURLY", "LBLE", "RBLE", "QUESTION", "EXCLAMATION", "SINGLE_QUOTE", "DOUBLE_QUOTE", "UNDERLINE", "SEMICOLON", "COMMA", "COMM", "COLON", "META", "AND", "OR", "PLUS", "MINUS", "MULTI", "DIV", "MOD", "ANDMARK", "EQUAL", "INCREASE", "VALUES", "INTO", "UPDATE", "SET", "CLUSTER", "JOBS", "KILL", "SNAPSHOT", "USE", "COMMIT", "NAME", "WHITESPACE", "WS", "UNICODE_LETTER", "UNICODE_DIGIT", "LETTER", "DIGIT", "'\\r'", "'\\n'", "'PARTITION_KEY'", "'STRING'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'TOPIC'", "'COMMENT'", "'CATALOG'", "'URL'", "'DRIVER'", "'ID'", "'PW'", "'VHOST'", "'PORT'", "'CLUSTER'", "'INITIALPOOLSIZE'", "'MAXPOOLSIZE'", "'MINPOOLSIZE'"
	};
	public static final int EOF=-1;
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
	public static final int T__87=87;
	public static final int REST=4;
	public static final int SYSTEM=5;
	public static final int DELETE=6;
	public static final int SELECT=7;
	public static final int FROM=8;
	public static final int WHERE=9;
	public static final int LOOKUP=10;
	public static final int INSERT=11;
	public static final int UPSERT=12;
	public static final int CREATE=13;
	public static final int STREAM=14;
	public static final int STREAMS=15;
	public static final int BSTREAM=16;
	public static final int BUCKET=17;
	public static final int SOURCE=18;
	public static final int SOURCES=19;
	public static final int DROP=20;
	public static final int SHOW=21;
	public static final int JOB=22;
	public static final int LPAREN=23;
	public static final int RPAREN=24;
	public static final int LSQUARE=25;
	public static final int RSQUARE=26;
	public static final int LCURLY=27;
	public static final int RCURLY=28;
	public static final int LBLE=29;
	public static final int RBLE=30;
	public static final int QUESTION=31;
	public static final int EXCLAMATION=32;
	public static final int SINGLE_QUOTE=33;
	public static final int DOUBLE_QUOTE=34;
	public static final int UNDERLINE=35;
	public static final int SEMICOLON=36;
	public static final int COMMA=37;
	public static final int COMM=38;
	public static final int COLON=39;
	public static final int META=40;
	public static final int AND=41;
	public static final int OR=42;
	public static final int PLUS=43;
	public static final int MINUS=44;
	public static final int MULTI=45;
	public static final int DIV=46;
	public static final int MOD=47;
	public static final int ANDMARK=48;
	public static final int EQUAL=49;
	public static final int INCREASE=50;
	public static final int VALUES=51;
	public static final int INTO=52;
	public static final int UPDATE=53;
	public static final int SET=54;
	public static final int CLUSTER=55;
	public static final int JOBS=56;
	public static final int KILL=57;
	public static final int SNAPSHOT=58;
	public static final int USE=59;
	public static final int COMMIT=60;
	public static final int NAME=61;
	public static final int WHITESPACE=62;
	public static final int WS=63;
	public static final int UNICODE_LETTER=64;
	public static final int UNICODE_DIGIT=65;
	public static final int LETTER=66;
	public static final int DIGIT=67;

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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:103:1: create_statement : ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:5: ( ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+ )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:7: ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
			{
				root_0 = (Object)adaptor.nil();

				// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:7: ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+
				int cnt1=0;
				loop1:
				do {
					int alt1=26;
					alt1 = dfa1.predict(input);
					switch (alt1) {
						case 1 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:8: rest_statement
						{
							pushFollow(FOLLOW_rest_statement_in_create_statement606);
							rest_statement1=rest_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, rest_statement1.getTree());

						}
						break;
						case 2 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:23: show_system_statement
						{
							pushFollow(FOLLOW_show_system_statement_in_create_statement608);
							show_system_statement2=show_system_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_system_statement2.getTree());

						}
						break;
						case 3 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:45: commit_statement
						{
							pushFollow(FOLLOW_commit_statement_in_create_statement610);
							commit_statement3=commit_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, commit_statement3.getTree());

						}
						break;
						case 4 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:62: use_statement
						{
							pushFollow(FOLLOW_use_statement_in_create_statement612);
							use_statement4=use_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, use_statement4.getTree());

						}
						break;
						case 5 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:76: snapshot_job_statement
						{
							pushFollow(FOLLOW_snapshot_job_statement_in_create_statement614);
							snapshot_job_statement5=snapshot_job_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, snapshot_job_statement5.getTree());

						}
						break;
						case 6 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:99: kill_job_statement
						{
							pushFollow(FOLLOW_kill_job_statement_in_create_statement616);
							kill_job_statement6=kill_job_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, kill_job_statement6.getTree());

						}
						break;
						case 7 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:118: set_statement
						{
							pushFollow(FOLLOW_set_statement_in_create_statement618);
							set_statement7=set_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, set_statement7.getTree());

						}
						break;
						case 8 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:132: show_sources_statement
						{
							pushFollow(FOLLOW_show_sources_statement_in_create_statement620);
							show_sources_statement8=show_sources_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_sources_statement8.getTree());

						}
						break;
						case 9 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:155: show_streams_statement
						{
							pushFollow(FOLLOW_show_streams_statement_in_create_statement622);
							show_streams_statement9=show_streams_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_streams_statement9.getTree());

						}
						break;
						case 10 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:178: show_cluster_statement
						{
							pushFollow(FOLLOW_show_cluster_statement_in_create_statement624);
							show_cluster_statement10=show_cluster_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_cluster_statement10.getTree());

						}
						break;
						case 11 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:201: show_jobs_statement
						{
							pushFollow(FOLLOW_show_jobs_statement_in_create_statement626);
							show_jobs_statement11=show_jobs_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_jobs_statement11.getTree());

						}
						break;
						case 12 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:221: insert_statement
						{
							pushFollow(FOLLOW_insert_statement_in_create_statement628);
							insert_statement12=insert_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, insert_statement12.getTree());

						}
						break;
						case 13 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:238: update_statement
						{
							pushFollow(FOLLOW_update_statement_in_create_statement630);
							update_statement13=update_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, update_statement13.getTree());

						}
						break;
						case 14 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:255: upsert_statement
						{
							pushFollow(FOLLOW_upsert_statement_in_create_statement632);
							upsert_statement14=upsert_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, upsert_statement14.getTree());

						}
						break;
						case 15 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:272: lookup_statement
						{
							pushFollow(FOLLOW_lookup_statement_in_create_statement634);
							lookup_statement15=lookup_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, lookup_statement15.getTree());

						}
						break;
						case 16 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:289: select_statement
						{
							pushFollow(FOLLOW_select_statement_in_create_statement636);
							select_statement16=select_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, select_statement16.getTree());

						}
						break;
						case 17 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:306: create_stream_statement
						{
							pushFollow(FOLLOW_create_stream_statement_in_create_statement638);
							create_stream_statement17=create_stream_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, create_stream_statement17.getTree());

						}
						break;
						case 18 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:330: create_source_statement
						{
							pushFollow(FOLLOW_create_source_statement_in_create_statement640);
							create_source_statement18=create_source_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, create_source_statement18.getTree());

						}
						break;
						case 19 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:354: show_stream_statement
						{
							pushFollow(FOLLOW_show_stream_statement_in_create_statement642);
							show_stream_statement19=show_stream_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_stream_statement19.getTree());

						}
						break;
						case 20 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:376: show_source_statement
						{
							pushFollow(FOLLOW_show_source_statement_in_create_statement644);
							show_source_statement20=show_source_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_source_statement20.getTree());

						}
						break;
						case 21 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:398: drop_stream_statement
						{
							pushFollow(FOLLOW_drop_stream_statement_in_create_statement646);
							drop_stream_statement21=drop_stream_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_stream_statement21.getTree());

						}
						break;
						case 22 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:420: drop_source_statement
						{
							pushFollow(FOLLOW_drop_source_statement_in_create_statement648);
							drop_source_statement22=drop_source_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_source_statement22.getTree());

						}
						break;
						case 23 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:442: drop_job_statement
						{
							pushFollow(FOLLOW_drop_job_statement_in_create_statement650);
							drop_job_statement23=drop_job_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, drop_job_statement23.getTree());

						}
						break;
						case 24 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:461: show_job_statement
						{
							pushFollow(FOLLOW_show_job_statement_in_create_statement652);
							show_job_statement24=show_job_statement();

							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, show_job_statement24.getTree());

						}
						break;
						case 25 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:104:480: delete_statement
						{
							pushFollow(FOLLOW_delete_statement_in_create_statement654);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:111:1: use_name_def returns [String ret] : n= NAME ;
	public final TOMMY_SQLParser.use_name_def_return use_name_def() throws RecognitionException {
		TOMMY_SQLParser.use_name_def_return retval = new TOMMY_SQLParser.use_name_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:112:5: (n= NAME )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:112:9: n= NAME
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)match(input,NAME,FOLLOW_NAME_in_use_name_def688); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:115:1: use_statement : USE column= set_name_def SEMICOLON ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:116:5: ( USE column= set_name_def SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:116:7: USE column= set_name_def SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				USE26=(Token)match(input,USE,FOLLOW_USE_in_use_statement707); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					USE26_tree = (Object)adaptor.create(USE26);
					adaptor.addChild(root_0, USE26_tree);
				}
				pushFollow(FOLLOW_set_name_def_in_use_statement711);
				column=set_name_def();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
				SEMICOLON27=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_use_statement713); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:129:1: set_name_def returns [String ret] : n= NAME ;
	public final TOMMY_SQLParser.set_name_def_return set_name_def() throws RecognitionException {
		TOMMY_SQLParser.set_name_def_return retval = new TOMMY_SQLParser.set_name_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:130:5: (n= NAME )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:130:9: n= NAME
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)match(input,NAME,FOLLOW_NAME_in_set_name_def745); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:133:1: set_value_def returns [String ret] : n= NAME ;
	public final TOMMY_SQLParser.set_value_def_return set_value_def() throws RecognitionException {
		TOMMY_SQLParser.set_value_def_return retval = new TOMMY_SQLParser.set_value_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:134:6: (n= NAME )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:134:10: n= NAME
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)match(input,NAME,FOLLOW_NAME_in_set_value_def773); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:137:1: set_statement : SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:138:5: ( SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:138:7: SET column= set_name_def EQUAL SINGLE_QUOTE value= set_value_def SINGLE_QUOTE SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SET28=(Token)match(input,SET,FOLLOW_SET_in_set_statement793); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SET28_tree = (Object)adaptor.create(SET28);
					adaptor.addChild(root_0, SET28_tree);
				}
				pushFollow(FOLLOW_set_name_def_in_set_statement797);
				column=set_name_def();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, column.getTree());
				EQUAL29=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_set_statement799); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					EQUAL29_tree = (Object)adaptor.create(EQUAL29);
					adaptor.addChild(root_0, EQUAL29_tree);
				}
				SINGLE_QUOTE30=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement801); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE30_tree = (Object)adaptor.create(SINGLE_QUOTE30);
					adaptor.addChild(root_0, SINGLE_QUOTE30_tree);
				}
				pushFollow(FOLLOW_set_value_def_in_set_statement805);
				value=set_value_def();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, value.getTree());
				SINGLE_QUOTE31=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_set_statement807); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE31_tree = (Object)adaptor.create(SINGLE_QUOTE31);
					adaptor.addChild(root_0, SINGLE_QUOTE31_tree);
				}
				SEMICOLON32=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_set_statement809); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:152:1: dml_table_name returns [BaseTableDef ret] : LSQUARE n= NAME COLON b= NAME RSQUARE ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:153:5: ( LSQUARE n= NAME COLON b= NAME RSQUARE )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:153:9: LSQUARE n= NAME COLON b= NAME RSQUARE
			{
				root_0 = (Object)adaptor.nil();

				LSQUARE33=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_table_name839); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					LSQUARE33_tree = (Object)adaptor.create(LSQUARE33);
					adaptor.addChild(root_0, LSQUARE33_tree);
				}
				n=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name843); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					n_tree = (Object)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);
				}
				COLON34=(Token)match(input,COLON,FOLLOW_COLON_in_dml_table_name845); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					COLON34_tree = (Object)adaptor.create(COLON34);
					adaptor.addChild(root_0, COLON34_tree);
				}
				b=(Token)match(input,NAME,FOLLOW_NAME_in_dml_table_name849); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					b_tree = (Object)adaptor.create(b);
					adaptor.addChild(root_0, b_tree);
				}
				RSQUARE35=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_table_name851); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:161:1: dml_bind_column_name returns [String ret] : n= LSQUARE COLON NAME RSQUARE ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:162:5: (n= LSQUARE COLON NAME RSQUARE )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:162:9: n= LSQUARE COLON NAME RSQUARE
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dml_bind_column_name878); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					n_tree = (Object)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);
				}
				COLON36=(Token)match(input,COLON,FOLLOW_COLON_in_dml_bind_column_name880); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					COLON36_tree = (Object)adaptor.create(COLON36);
					adaptor.addChild(root_0, COLON36_tree);
				}
				NAME37=(Token)match(input,NAME,FOLLOW_NAME_in_dml_bind_column_name882); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					NAME37_tree = (Object)adaptor.create(NAME37);
					adaptor.addChild(root_0, NAME37_tree);
				}
				RSQUARE38=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_dml_bind_column_name884); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:166:1: dml_lookup_where returns [String ret] : n= ( NAME ( NAME )* ) ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:167:5: (n= ( NAME ( NAME )* ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:167:8: n= ( NAME ( NAME )* )
			{
				root_0 = (Object)adaptor.nil();

				// org/tommy/stationery/ink/core/TOMMY_SQL.g:167:10: ( NAME ( NAME )* )
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:167:11: NAME ( NAME )*
				{
					NAME39=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where911); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
						NAME39_tree = (Object)adaptor.create(NAME39);
						adaptor.addChild(root_0, NAME39_tree);
					}
					// org/tommy/stationery/ink/core/TOMMY_SQL.g:167:16: ( NAME )*
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
								// org/tommy/stationery/ink/core/TOMMY_SQL.g:167:17: NAME
							{
								NAME40=(Token)match(input,NAME,FOLLOW_NAME_in_dml_lookup_where914); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:170:1: dml_select_body returns [String ret] : n= ( NAME ( NAME )* ) ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:171:5: (n= ( NAME ( NAME )* ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:171:8: n= ( NAME ( NAME )* )
			{
				root_0 = (Object)adaptor.nil();

				// org/tommy/stationery/ink/core/TOMMY_SQL.g:171:10: ( NAME ( NAME )* )
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:171:11: NAME ( NAME )*
				{
					NAME41=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body944); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
						NAME41_tree = (Object)adaptor.create(NAME41);
						adaptor.addChild(root_0, NAME41_tree);
					}
					// org/tommy/stationery/ink/core/TOMMY_SQL.g:171:16: ( NAME )*
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
								// org/tommy/stationery/ink/core/TOMMY_SQL.g:171:17: NAME
							{
								NAME42=(Token)match(input,NAME,FOLLOW_NAME_in_dml_select_body947); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:174:1: dml_lookup_select_where_body returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ ;
	public final TOMMY_SQLParser.dml_lookup_select_where_body_return dml_lookup_select_where_body() throws RecognitionException {
		TOMMY_SQLParser.dml_lookup_select_where_body_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:175:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:175:8: (n=~ ( '\\r' | '\\n' | ';' ) )+
			{
				root_0 = (Object)adaptor.nil();

				// org/tommy/stationery/ink/core/TOMMY_SQL.g:175:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
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
							if ( (input.LA(1)>=REST && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=70 && input.LA(1)<=87) ) {
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:178:1: dml_lookup_select_where_body2 returns [String ret] : (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON ;
	public final TOMMY_SQLParser.dml_lookup_select_where_body2_return dml_lookup_select_where_body2() throws RecognitionException {
		TOMMY_SQLParser.dml_lookup_select_where_body2_return retval = new TOMMY_SQLParser.dml_lookup_select_where_body2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token SEMICOLON43=null;

		Object n_tree=null;
		Object SEMICOLON43_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:179:5: ( (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:179:8: (n=~ ( '\\r' | '\\n' | ';' ) )+ SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				// org/tommy/stationery/ink/core/TOMMY_SQL.g:179:9: (n=~ ( '\\r' | '\\n' | ';' ) )+
				int cnt5=0;
				loop5:
				do {
					int alt5=2;
					switch ( input.LA(1) ) {
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
						case 87:
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
							if ( (input.LA(1)>=REST && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=70 && input.LA(1)<=87) ) {
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

				SEMICOLON43=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21024); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:182:1: lookup_statement : LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:183:5: ( LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:183:7: LOOKUP body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
			{
				root_0 = (Object)adaptor.nil();

				LOOKUP44=(Token)match(input,LOOKUP,FOLLOW_LOOKUP_in_lookup_statement1043); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					LOOKUP44_tree = (Object)adaptor.create(LOOKUP44);
					adaptor.addChild(root_0, LOOKUP44_tree);
				}
				pushFollow(FOLLOW_dml_lookup_select_where_body_in_lookup_statement1049);
				body1=dml_lookup_select_where_body();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:183:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:183:52: WHERE body2= dml_lookup_select_where_body2
					{
						WHERE45=(Token)match(input,WHERE,FOLLOW_WHERE_in_lookup_statement1052); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							WHERE45_tree = (Object)adaptor.create(WHERE45);
							adaptor.addChild(root_0, WHERE45_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1058);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 2 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:183:96: SEMICOLON
					{
						SEMICOLON46=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lookup_statement1060); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:195:1: select_statement : SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:196:5: ( SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:196:7: SELECT body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
			{
				root_0 = (Object)adaptor.nil();

				SELECT47=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_statement1084); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SELECT47_tree = (Object)adaptor.create(SELECT47);
					adaptor.addChild(root_0, SELECT47_tree);
				}
				pushFollow(FOLLOW_dml_lookup_select_where_body_in_select_statement1090);
				body1=dml_lookup_select_where_body();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:196:51: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
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
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:196:52: WHERE body2= dml_lookup_select_where_body2
					{
						WHERE48=(Token)match(input,WHERE,FOLLOW_WHERE_in_select_statement1093); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							WHERE48_tree = (Object)adaptor.create(WHERE48);
							adaptor.addChild(root_0, WHERE48_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_select_statement1099);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 2 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:196:96: SEMICOLON
					{
						SEMICOLON49=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_select_statement1101); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:209:1: rest_statement : REST INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
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
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:210:5: ( REST INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:210:7: REST INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
			{
				root_0 = (Object)adaptor.nil();

				REST50=(Token)match(input,REST,FOLLOW_REST_in_rest_statement1125); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					REST50_tree = (Object)adaptor.create(REST50);
					adaptor.addChild(root_0, REST50_tree);
				}
				INTO51=(Token)match(input,INTO,FOLLOW_INTO_in_rest_statement1127); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					INTO51_tree = (Object)adaptor.create(INTO51);
					adaptor.addChild(root_0, INTO51_tree);
				}
				pushFollow(FOLLOW_dml_lookup_select_where_body_in_rest_statement1133);
				body1=dml_lookup_select_where_body();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:210:54: ( VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
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
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:210:55: VALUES body2= dml_lookup_select_where_body2
					{
						VALUES52=(Token)match(input,VALUES,FOLLOW_VALUES_in_rest_statement1136); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							VALUES52_tree = (Object)adaptor.create(VALUES52);
							adaptor.addChild(root_0, VALUES52_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_rest_statement1142);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 2 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:210:100: SEMICOLON
					{
						SEMICOLON53=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_rest_statement1144); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:224:1: insert_statement : INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
	public final TOMMY_SQLParser.insert_statement_return insert_statement() throws RecognitionException {
		TOMMY_SQLParser.insert_statement_return retval = new TOMMY_SQLParser.insert_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INSERT54=null;
		Token INTO55=null;
		Token VALUES56=null;
		Token INCREASE57=null;
		Token VALUES58=null;
		Token SEMICOLON59=null;
		TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

		TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


		Object INSERT54_tree=null;
		Object INTO55_tree=null;
		Object VALUES56_tree=null;
		Object INCREASE57_tree=null;
		Object VALUES58_tree=null;
		Object SEMICOLON59_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:225:5: ( INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:225:7: INSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
			{
				root_0 = (Object)adaptor.nil();

				INSERT54=(Token)match(input,INSERT,FOLLOW_INSERT_in_insert_statement1168); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					INSERT54_tree = (Object)adaptor.create(INSERT54);
					adaptor.addChild(root_0, INSERT54_tree);
				}
				INTO55=(Token)match(input,INTO,FOLLOW_INTO_in_insert_statement1170); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					INTO55_tree = (Object)adaptor.create(INTO55);
					adaptor.addChild(root_0, INTO55_tree);
				}
				pushFollow(FOLLOW_dml_lookup_select_where_body_in_insert_statement1176);
				body1=dml_lookup_select_where_body();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:225:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
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
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:225:57: VALUES body2= dml_lookup_select_where_body2
					{
						VALUES56=(Token)match(input,VALUES,FOLLOW_VALUES_in_insert_statement1179); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							VALUES56_tree = (Object)adaptor.create(VALUES56);
							adaptor.addChild(root_0, VALUES56_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_insert_statement1185);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 2 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:225:102: INCREASE VALUES body2= dml_lookup_select_where_body2
					{
						INCREASE57=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_insert_statement1187); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							INCREASE57_tree = (Object)adaptor.create(INCREASE57);
							adaptor.addChild(root_0, INCREASE57_tree);
						}
						VALUES58=(Token)match(input,VALUES,FOLLOW_VALUES_in_insert_statement1189); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							VALUES58_tree = (Object)adaptor.create(VALUES58);
							adaptor.addChild(root_0, VALUES58_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_insert_statement1195);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 3 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:225:156: SEMICOLON
					{
						SEMICOLON59=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_insert_statement1197); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:239:1: upsert_statement : UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
	public final TOMMY_SQLParser.upsert_statement_return upsert_statement() throws RecognitionException {
		TOMMY_SQLParser.upsert_statement_return retval = new TOMMY_SQLParser.upsert_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token UPSERT60=null;
		Token INTO61=null;
		Token VALUES62=null;
		Token INCREASE63=null;
		Token VALUES64=null;
		Token SEMICOLON65=null;
		TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

		TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


		Object UPSERT60_tree=null;
		Object INTO61_tree=null;
		Object VALUES62_tree=null;
		Object INCREASE63_tree=null;
		Object VALUES64_tree=null;
		Object SEMICOLON65_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:240:5: ( UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:240:7: UPSERT INTO body1= dml_lookup_select_where_body ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
			{
				root_0 = (Object)adaptor.nil();

				UPSERT60=(Token)match(input,UPSERT,FOLLOW_UPSERT_in_upsert_statement1221); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					UPSERT60_tree = (Object)adaptor.create(UPSERT60);
					adaptor.addChild(root_0, UPSERT60_tree);
				}
				INTO61=(Token)match(input,INTO,FOLLOW_INTO_in_upsert_statement1223); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					INTO61_tree = (Object)adaptor.create(INTO61);
					adaptor.addChild(root_0, INTO61_tree);
				}
				pushFollow(FOLLOW_dml_lookup_select_where_body_in_upsert_statement1229);
				body1=dml_lookup_select_where_body();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:240:56: ( VALUES body2= dml_lookup_select_where_body2 | INCREASE VALUES body2= dml_lookup_select_where_body2 | SEMICOLON )
				int alt10=3;
				switch ( input.LA(1) ) {
					case VALUES:
					{
						alt10=1;
					}
					break;
					case INCREASE:
					{
						alt10=2;
					}
					break;
					case SEMICOLON:
					{
						alt10=3;
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
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:240:57: VALUES body2= dml_lookup_select_where_body2
					{
						VALUES62=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1232); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							VALUES62_tree = (Object)adaptor.create(VALUES62);
							adaptor.addChild(root_0, VALUES62_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1238);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 2 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:240:102: INCREASE VALUES body2= dml_lookup_select_where_body2
					{
						INCREASE63=(Token)match(input,INCREASE,FOLLOW_INCREASE_in_upsert_statement1240); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							INCREASE63_tree = (Object)adaptor.create(INCREASE63);
							adaptor.addChild(root_0, INCREASE63_tree);
						}
						VALUES64=(Token)match(input,VALUES,FOLLOW_VALUES_in_upsert_statement1242); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							VALUES64_tree = (Object)adaptor.create(VALUES64);
							adaptor.addChild(root_0, VALUES64_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1248);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 3 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:240:156: SEMICOLON
					{
						SEMICOLON65=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_upsert_statement1250); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:254:1: update_statement : UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) ;
	public final TOMMY_SQLParser.update_statement_return update_statement() throws RecognitionException {
		TOMMY_SQLParser.update_statement_return retval = new TOMMY_SQLParser.update_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token UPDATE66=null;
		Token SET67=null;
		Token SET68=null;
		Token WHERE69=null;
		Token SEMICOLON70=null;
		TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

		TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;

		TOMMY_SQLParser.dml_lookup_select_where_body_return body3 = null;

		TOMMY_SQLParser.dml_lookup_select_where_body2_return body4 = null;


		Object UPDATE66_tree=null;
		Object SET67_tree=null;
		Object SET68_tree=null;
		Object WHERE69_tree=null;
		Object SEMICOLON70_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:5: ( UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:7: UPDATE body1= dml_lookup_select_where_body ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
			{
				root_0 = (Object)adaptor.nil();

				UPDATE66=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_update_statement1274); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					UPDATE66_tree = (Object)adaptor.create(UPDATE66);
					adaptor.addChild(root_0, UPDATE66_tree);
				}
				pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1280);
				body1=dml_lookup_select_where_body();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )
				int alt11=3;
				alt11 = dfa11.predict(input);
				switch (alt11) {
					case 1 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:52: SET body2= dml_lookup_select_where_body2
					{
						SET67=(Token)match(input,SET,FOLLOW_SET_in_update_statement1283); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							SET67_tree = (Object)adaptor.create(SET67);
							adaptor.addChild(root_0, SET67_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1289);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 2 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
					{
						SET68=(Token)match(input,SET,FOLLOW_SET_in_update_statement1293); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							SET68_tree = (Object)adaptor.create(SET68);
							adaptor.addChild(root_0, SET68_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body_in_update_statement1299);
						body3=dml_lookup_select_where_body();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body3.getTree());
						WHERE69=(Token)match(input,WHERE,FOLLOW_WHERE_in_update_statement1301); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							WHERE69_tree = (Object)adaptor.create(WHERE69);
							adaptor.addChild(root_0, WHERE69_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_update_statement1305);
						body4=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body4.getTree());

					}
					break;
					case 3 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:179: SEMICOLON
					{
						SEMICOLON70=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_update_statement1307); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							SEMICOLON70_tree = (Object)adaptor.create(SEMICOLON70);
							adaptor.addChild(root_0, SEMICOLON70_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:269:1: delete_statement : DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) ;
	public final TOMMY_SQLParser.delete_statement_return delete_statement() throws RecognitionException {
		TOMMY_SQLParser.delete_statement_return retval = new TOMMY_SQLParser.delete_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DELETE71=null;
		Token FROM72=null;
		Token WHERE73=null;
		Token SEMICOLON74=null;
		TOMMY_SQLParser.dml_lookup_select_where_body_return body1 = null;

		TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


		Object DELETE71_tree=null;
		Object FROM72_tree=null;
		Object WHERE73_tree=null;
		Object SEMICOLON74_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:270:5: ( DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:270:7: DELETE FROM body1= dml_lookup_select_where_body ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
			{
				root_0 = (Object)adaptor.nil();

				DELETE71=(Token)match(input,DELETE,FOLLOW_DELETE_in_delete_statement1331); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					DELETE71_tree = (Object)adaptor.create(DELETE71);
					adaptor.addChild(root_0, DELETE71_tree);
				}
				FROM72=(Token)match(input,FROM,FOLLOW_FROM_in_delete_statement1333); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					FROM72_tree = (Object)adaptor.create(FROM72);
					adaptor.addChild(root_0, FROM72_tree);
				}
				pushFollow(FOLLOW_dml_lookup_select_where_body_in_delete_statement1339);
				body1=dml_lookup_select_where_body();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, body1.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:270:56: ( WHERE body2= dml_lookup_select_where_body2 | SEMICOLON )
				int alt12=2;
				switch ( input.LA(1) ) {
					case WHERE:
					{
						alt12=1;
					}
					break;
					case SEMICOLON:
					{
						alt12=2;
					}
					break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
								new NoViableAltException("", 12, 0, input);

						throw nvae;
				}

				switch (alt12) {
					case 1 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:270:57: WHERE body2= dml_lookup_select_where_body2
					{
						WHERE73=(Token)match(input,WHERE,FOLLOW_WHERE_in_delete_statement1342); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							WHERE73_tree = (Object)adaptor.create(WHERE73);
							adaptor.addChild(root_0, WHERE73_tree);
						}
						pushFollow(FOLLOW_dml_lookup_select_where_body2_in_delete_statement1348);
						body2=dml_lookup_select_where_body2();

						state._fsp--;
						if (state.failed) return retval;
						if ( state.backtracking==0 ) adaptor.addChild(root_0, body2.getTree());

					}
					break;
					case 2 :
						// org/tommy/stationery/ink/core/TOMMY_SQL.g:270:101: SEMICOLON
					{
						SEMICOLON74=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_delete_statement1350); if (state.failed) return retval;
						if ( state.backtracking==0 ) {
							SEMICOLON74_tree = (Object)adaptor.create(SEMICOLON74);
							adaptor.addChild(root_0, SEMICOLON74_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:283:1: ddl_table_name returns [BaseTableDef ret] : n= NAME ;
	public final TOMMY_SQLParser.ddl_table_name_return ddl_table_name() throws RecognitionException {
		TOMMY_SQLParser.ddl_table_name_return retval = new TOMMY_SQLParser.ddl_table_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:284:5: (n= NAME )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:284:9: n= NAME
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_table_name1382); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:291:1: ddl_column_pk returns [boolean ret] : n= 'PARTITION_KEY' ;
	public final TOMMY_SQLParser.ddl_column_pk_return ddl_column_pk() throws RecognitionException {
		TOMMY_SQLParser.ddl_column_pk_return retval = new TOMMY_SQLParser.ddl_column_pk_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:292:5: (n= 'PARTITION_KEY' )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:293:9: n= 'PARTITION_KEY'
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)match(input,70,FOLLOW_70_in_ddl_column_pk1415); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:296:1: ddl_column_comment returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
	public final TOMMY_SQLParser.ddl_column_comment_return ddl_column_comment() throws RecognitionException {
		TOMMY_SQLParser.ddl_column_comment_return retval = new TOMMY_SQLParser.ddl_column_comment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token SINGLE_QUOTE75=null;
		Token SINGLE_QUOTE76=null;

		Object n_tree=null;
		Object SINGLE_QUOTE75_tree=null;
		Object SINGLE_QUOTE76_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:297:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:297:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
			{
				root_0 = (Object)adaptor.nil();

				SINGLE_QUOTE75=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1440); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE75_tree = (Object)adaptor.create(SINGLE_QUOTE75);
					adaptor.addChild(root_0, SINGLE_QUOTE75_tree);
				}
				n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_comment1444); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					n_tree = (Object)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);
				}
				SINGLE_QUOTE76=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1446); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE76_tree = (Object)adaptor.create(SINGLE_QUOTE76);
					adaptor.addChild(root_0, SINGLE_QUOTE76_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:300:1: ddl_column_name returns [String ret] : n= NAME ;
	public final TOMMY_SQLParser.ddl_column_name_return ddl_column_name() throws RecognitionException {
		TOMMY_SQLParser.ddl_column_name_return retval = new TOMMY_SQLParser.ddl_column_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:301:5: (n= NAME )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:301:9: n= NAME
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)match(input,NAME,FOLLOW_NAME_in_ddl_column_name1473); if (state.failed) return retval;
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:304:1: ddl_column_type returns [ColumnDataTypeEnum ret] : n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) ;
	public final TOMMY_SQLParser.ddl_column_type_return ddl_column_type() throws RecognitionException {
		TOMMY_SQLParser.ddl_column_type_return retval = new TOMMY_SQLParser.ddl_column_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:305:5: (n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:305:9: n= ( 'STRING' | 'INTEGER' | 'FLOAT' | 'DOUBLE' )
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)input.LT(1);
				if ( (input.LA(1)>=71 && input.LA(1)<=74) ) {
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:309:1: ddl_column_defs returns [List<BaseColumnDef> ret] : v= column_def ( COMMA v= column_def )* ;
	public final TOMMY_SQLParser.ddl_column_defs_return ddl_column_defs() throws RecognitionException {
		TOMMY_SQLParser.ddl_column_defs_return retval = new TOMMY_SQLParser.ddl_column_defs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA77=null;
		TOMMY_SQLParser.column_def_return v = null;


		Object COMMA77_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:310:5: (v= column_def ( COMMA v= column_def )* )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:311:9: v= column_def ( COMMA v= column_def )*
			{
				root_0 = (Object)adaptor.nil();

				pushFollow(FOLLOW_column_def_in_ddl_column_defs1543);
				v=column_def();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
				if ( state.backtracking==0 ) {

					retval.ret = new ArrayList<BaseColumnDef>();
					retval.ret.add(v.ret);

				}
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:314:11: ( COMMA v= column_def )*
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
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:314:12: COMMA v= column_def
						{
							COMMA77=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_column_defs1548); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
								COMMA77_tree = (Object)adaptor.create(COMMA77);
								adaptor.addChild(root_0, COMMA77_tree);
							}
							pushFollow(FOLLOW_column_def_in_ddl_column_defs1554);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:317:1: column_def returns [BaseColumnDef ret] : c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* ;
	public final TOMMY_SQLParser.column_def_return column_def() throws RecognitionException {
		TOMMY_SQLParser.column_def_return retval = new TOMMY_SQLParser.column_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		TOMMY_SQLParser.ddl_column_name_return c = null;

		TOMMY_SQLParser.ddl_column_type_return dt = null;

		TOMMY_SQLParser.ddl_column_pk_return pk = null;

		TOMMY_SQLParser.ddl_column_comment_return cmt = null;



		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:318:5: (c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )* )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:318:9: c= ddl_column_name dt= ddl_column_type (pk= ddl_column_pk )* (cmt= ddl_column_comment )*
			{
				root_0 = (Object)adaptor.nil();

				pushFollow(FOLLOW_ddl_column_name_in_column_def1584);
				c=ddl_column_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
				pushFollow(FOLLOW_ddl_column_type_in_column_def1588);
				dt=ddl_column_type();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, dt.getTree());
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:318:46: (pk= ddl_column_pk )*
				loop14:
				do {
					int alt14=2;
					switch ( input.LA(1) ) {
						case 70:
						{
							alt14=1;
						}
						break;

					}

					switch (alt14) {
						case 1 :
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:318:47: pk= ddl_column_pk
						{
							pushFollow(FOLLOW_ddl_column_pk_in_column_def1593);
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

				// org/tommy/stationery/ink/core/TOMMY_SQL.g:318:66: (cmt= ddl_column_comment )*
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
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:318:67: cmt= ddl_column_comment
						{
							pushFollow(FOLLOW_ddl_column_comment_in_column_def1600);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:325:1: stream_meta_name returns [String ret] : n= ( 'TOPIC' | 'COMMENT' ) ;
	public final TOMMY_SQLParser.stream_meta_name_return stream_meta_name() throws RecognitionException {
		TOMMY_SQLParser.stream_meta_name_return retval = new TOMMY_SQLParser.stream_meta_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:326:5: (n= ( 'TOPIC' | 'COMMENT' ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:326:9: n= ( 'TOPIC' | 'COMMENT' )
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)input.LT(1);
				if ( (input.LA(1)>=75 && input.LA(1)<=76) ) {
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:329:1: stream_meta_value returns [String ret] : SINGLE_QUOTE n= NAME SINGLE_QUOTE ;
	public final TOMMY_SQLParser.stream_meta_value_return stream_meta_value() throws RecognitionException {
		TOMMY_SQLParser.stream_meta_value_return retval = new TOMMY_SQLParser.stream_meta_value_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token SINGLE_QUOTE78=null;
		Token SINGLE_QUOTE79=null;

		Object n_tree=null;
		Object SINGLE_QUOTE78_tree=null;
		Object SINGLE_QUOTE79_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:330:5: ( SINGLE_QUOTE n= NAME SINGLE_QUOTE )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:330:9: SINGLE_QUOTE n= NAME SINGLE_QUOTE
			{
				root_0 = (Object)adaptor.nil();

				SINGLE_QUOTE78=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1667); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE78_tree = (Object)adaptor.create(SINGLE_QUOTE78);
					adaptor.addChild(root_0, SINGLE_QUOTE78_tree);
				}
				n=(Token)match(input,NAME,FOLLOW_NAME_in_stream_meta_value1671); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					n_tree = (Object)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);
				}
				SINGLE_QUOTE79=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_stream_meta_value1673); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE79_tree = (Object)adaptor.create(SINGLE_QUOTE79);
					adaptor.addChild(root_0, SINGLE_QUOTE79_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:333:1: stream_meta_def returns [BaseMetaDef ret] : c= stream_meta_name dt= stream_meta_value ;
	public final TOMMY_SQLParser.stream_meta_def_return stream_meta_def() throws RecognitionException {
		TOMMY_SQLParser.stream_meta_def_return retval = new TOMMY_SQLParser.stream_meta_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		TOMMY_SQLParser.stream_meta_name_return c = null;

		TOMMY_SQLParser.stream_meta_value_return dt = null;



		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:334:5: (c= stream_meta_name dt= stream_meta_value )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:334:9: c= stream_meta_name dt= stream_meta_value
			{
				root_0 = (Object)adaptor.nil();

				pushFollow(FOLLOW_stream_meta_name_in_stream_meta_def1700);
				c=stream_meta_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
				pushFollow(FOLLOW_stream_meta_value_in_stream_meta_def1704);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:338:1: ddl_stream_meta_defs returns [List<BaseMetaDef> ret] : v= stream_meta_def ( COMMA v= stream_meta_def )* ;
	public final TOMMY_SQLParser.ddl_stream_meta_defs_return ddl_stream_meta_defs() throws RecognitionException {
		TOMMY_SQLParser.ddl_stream_meta_defs_return retval = new TOMMY_SQLParser.ddl_stream_meta_defs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA80=null;
		TOMMY_SQLParser.stream_meta_def_return v = null;


		Object COMMA80_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:339:10: (v= stream_meta_def ( COMMA v= stream_meta_def )* )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:340:14: v= stream_meta_def ( COMMA v= stream_meta_def )*
			{
				root_0 = (Object)adaptor.nil();

				pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1757);
				v=stream_meta_def();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
				if ( state.backtracking==0 ) {

					retval.ret = new ArrayList<BaseMetaDef>();
					retval.ret.add(v.ret);

				}
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:343:16: ( COMMA v= stream_meta_def )*
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
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:343:17: COMMA v= stream_meta_def
						{
							COMMA80=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_stream_meta_defs1762); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
								COMMA80_tree = (Object)adaptor.create(COMMA80);
								adaptor.addChild(root_0, COMMA80_tree);
							}
							pushFollow(FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1768);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:346:1: create_stream_statement : CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON ;
	public final TOMMY_SQLParser.create_stream_statement_return create_stream_statement() throws RecognitionException {
		TOMMY_SQLParser.create_stream_statement_return retval = new TOMMY_SQLParser.create_stream_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CREATE81=null;
		Token STREAM82=null;
		Token LPAREN83=null;
		Token RPAREN84=null;
		Token META85=null;
		Token LPAREN86=null;
		Token RPAREN87=null;
		Token SEMICOLON88=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;

		TOMMY_SQLParser.ddl_column_defs_return columns = null;

		TOMMY_SQLParser.ddl_stream_meta_defs_return metas = null;


		Object CREATE81_tree=null;
		Object STREAM82_tree=null;
		Object LPAREN83_tree=null;
		Object RPAREN84_tree=null;
		Object META85_tree=null;
		Object LPAREN86_tree=null;
		Object RPAREN87_tree=null;
		Object SEMICOLON88_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:347:5: ( CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:347:7: CREATE STREAM table_name= ddl_table_name LPAREN columns= ddl_column_defs RPAREN META LPAREN metas= ddl_stream_meta_defs RPAREN SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				CREATE81=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_stream_statement1795); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					CREATE81_tree = (Object)adaptor.create(CREATE81);
					adaptor.addChild(root_0, CREATE81_tree);
				}
				STREAM82=(Token)match(input,STREAM,FOLLOW_STREAM_in_create_stream_statement1797); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					STREAM82_tree = (Object)adaptor.create(STREAM82);
					adaptor.addChild(root_0, STREAM82_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_create_stream_statement1801);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				LPAREN83=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1811); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					LPAREN83_tree = (Object)adaptor.create(LPAREN83);
					adaptor.addChild(root_0, LPAREN83_tree);
				}
				pushFollow(FOLLOW_ddl_column_defs_in_create_stream_statement1815);
				columns=ddl_column_defs();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, columns.getTree());
				RPAREN84=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1817); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					RPAREN84_tree = (Object)adaptor.create(RPAREN84);
					adaptor.addChild(root_0, RPAREN84_tree);
				}
				META85=(Token)match(input,META,FOLLOW_META_in_create_stream_statement1819); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					META85_tree = (Object)adaptor.create(META85);
					adaptor.addChild(root_0, META85_tree);
				}
				LPAREN86=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_stream_statement1821); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					LPAREN86_tree = (Object)adaptor.create(LPAREN86);
					adaptor.addChild(root_0, LPAREN86_tree);
				}
				pushFollow(FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1825);
				metas=ddl_stream_meta_defs();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
				RPAREN87=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_stream_statement1827); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					RPAREN87_tree = (Object)adaptor.create(RPAREN87);
					adaptor.addChild(root_0, RPAREN87_tree);
				}
				SEMICOLON88=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_stream_statement1829); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON88_tree = (Object)adaptor.create(SEMICOLON88);
					adaptor.addChild(root_0, SEMICOLON88_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:361:1: drop_stream_statement : DROP STREAM table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.drop_stream_statement_return drop_stream_statement() throws RecognitionException {
		TOMMY_SQLParser.drop_stream_statement_return retval = new TOMMY_SQLParser.drop_stream_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DROP89=null;
		Token STREAM90=null;
		Token SEMICOLON91=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object DROP89_tree=null;
		Object STREAM90_tree=null;
		Object SEMICOLON91_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:362:5: ( DROP STREAM table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:362:7: DROP STREAM table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				DROP89=(Token)match(input,DROP,FOLLOW_DROP_in_drop_stream_statement1852); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					DROP89_tree = (Object)adaptor.create(DROP89);
					adaptor.addChild(root_0, DROP89_tree);
				}
				STREAM90=(Token)match(input,STREAM,FOLLOW_STREAM_in_drop_stream_statement1854); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					STREAM90_tree = (Object)adaptor.create(STREAM90);
					adaptor.addChild(root_0, STREAM90_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_drop_stream_statement1858);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON91=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_stream_statement1860); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON91_tree = (Object)adaptor.create(SEMICOLON91);
					adaptor.addChild(root_0, SEMICOLON91_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:373:1: show_stream_statement : SHOW STREAM table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.show_stream_statement_return show_stream_statement() throws RecognitionException {
		TOMMY_SQLParser.show_stream_statement_return retval = new TOMMY_SQLParser.show_stream_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW92=null;
		Token STREAM93=null;
		Token SEMICOLON94=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object SHOW92_tree=null;
		Object STREAM93_tree=null;
		Object SEMICOLON94_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:374:5: ( SHOW STREAM table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:374:7: SHOW STREAM table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW92=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_stream_statement1883); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW92_tree = (Object)adaptor.create(SHOW92);
					adaptor.addChild(root_0, SHOW92_tree);
				}
				STREAM93=(Token)match(input,STREAM,FOLLOW_STREAM_in_show_stream_statement1885); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					STREAM93_tree = (Object)adaptor.create(STREAM93);
					adaptor.addChild(root_0, STREAM93_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_show_stream_statement1889);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON94=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_stream_statement1891); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON94_tree = (Object)adaptor.create(SEMICOLON94);
					adaptor.addChild(root_0, SEMICOLON94_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:385:1: show_streams_statement : SHOW STREAMS SEMICOLON ;
	public final TOMMY_SQLParser.show_streams_statement_return show_streams_statement() throws RecognitionException {
		TOMMY_SQLParser.show_streams_statement_return retval = new TOMMY_SQLParser.show_streams_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW95=null;
		Token STREAMS96=null;
		Token SEMICOLON97=null;

		Object SHOW95_tree=null;
		Object STREAMS96_tree=null;
		Object SEMICOLON97_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:386:5: ( SHOW STREAMS SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:386:7: SHOW STREAMS SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW95=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_streams_statement1914); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW95_tree = (Object)adaptor.create(SHOW95);
					adaptor.addChild(root_0, SHOW95_tree);
				}
				STREAMS96=(Token)match(input,STREAMS,FOLLOW_STREAMS_in_show_streams_statement1916); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					STREAMS96_tree = (Object)adaptor.create(STREAMS96);
					adaptor.addChild(root_0, STREAMS96_tree);
				}
				SEMICOLON97=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_streams_statement1918); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON97_tree = (Object)adaptor.create(SEMICOLON97);
					adaptor.addChild(root_0, SEMICOLON97_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:396:1: kill_job_statement : KILL JOB table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.kill_job_statement_return kill_job_statement() throws RecognitionException {
		TOMMY_SQLParser.kill_job_statement_return retval = new TOMMY_SQLParser.kill_job_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token KILL98=null;
		Token JOB99=null;
		Token SEMICOLON100=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object KILL98_tree=null;
		Object JOB99_tree=null;
		Object SEMICOLON100_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:397:5: ( KILL JOB table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:397:7: KILL JOB table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				KILL98=(Token)match(input,KILL,FOLLOW_KILL_in_kill_job_statement1941); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					KILL98_tree = (Object)adaptor.create(KILL98);
					adaptor.addChild(root_0, KILL98_tree);
				}
				JOB99=(Token)match(input,JOB,FOLLOW_JOB_in_kill_job_statement1943); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					JOB99_tree = (Object)adaptor.create(JOB99);
					adaptor.addChild(root_0, JOB99_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_kill_job_statement1947);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON100=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_kill_job_statement1949); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON100_tree = (Object)adaptor.create(SEMICOLON100);
					adaptor.addChild(root_0, SEMICOLON100_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:408:1: commit_statement : COMMIT SEMICOLON ;
	public final TOMMY_SQLParser.commit_statement_return commit_statement() throws RecognitionException {
		TOMMY_SQLParser.commit_statement_return retval = new TOMMY_SQLParser.commit_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMIT101=null;
		Token SEMICOLON102=null;

		Object COMMIT101_tree=null;
		Object SEMICOLON102_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:409:5: ( COMMIT SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:409:7: COMMIT SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				COMMIT101=(Token)match(input,COMMIT,FOLLOW_COMMIT_in_commit_statement1972); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					COMMIT101_tree = (Object)adaptor.create(COMMIT101);
					adaptor.addChild(root_0, COMMIT101_tree);
				}
				SEMICOLON102=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_commit_statement1974); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON102_tree = (Object)adaptor.create(SEMICOLON102);
					adaptor.addChild(root_0, SEMICOLON102_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:415:1: source_meta_name returns [String ret] : n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) ;
	public final TOMMY_SQLParser.source_meta_name_return source_meta_name() throws RecognitionException {
		TOMMY_SQLParser.source_meta_name_return retval = new TOMMY_SQLParser.source_meta_name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;

		Object n_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:416:5: (n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' ) )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:416:9: n= ( 'CATALOG' | 'URL' | 'DRIVER' | 'ID' | 'PW' | 'VHOST' | 'PORT' | 'TOPIC' | 'CLUSTER' | 'INITIALPOOLSIZE' | 'MAXPOOLSIZE' | 'MINPOOLSIZE' )
			{
				root_0 = (Object)adaptor.nil();

				n=(Token)input.LT(1);
				if ( input.LA(1)==75||(input.LA(1)>=77 && input.LA(1)<=87) ) {
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:419:1: source_meta_value returns [String ret] : SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE ;
	public final TOMMY_SQLParser.source_meta_value_return source_meta_value() throws RecognitionException {
		TOMMY_SQLParser.source_meta_value_return retval = new TOMMY_SQLParser.source_meta_value_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token n=null;
		Token SINGLE_QUOTE103=null;
		Token set104=null;
		Token SINGLE_QUOTE105=null;

		Object n_tree=null;
		Object SINGLE_QUOTE103_tree=null;
		Object set104_tree=null;
		Object SINGLE_QUOTE105_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:420:5: ( SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:420:9: SINGLE_QUOTE n= NAME ( NAME | COMMA )* SINGLE_QUOTE
			{
				root_0 = (Object)adaptor.nil();

				SINGLE_QUOTE103=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value2051); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE103_tree = (Object)adaptor.create(SINGLE_QUOTE103);
					adaptor.addChild(root_0, SINGLE_QUOTE103_tree);
				}
				n=(Token)match(input,NAME,FOLLOW_NAME_in_source_meta_value2055); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					n_tree = (Object)adaptor.create(n);
					adaptor.addChild(root_0, n_tree);
				}
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:420:29: ( NAME | COMMA )*
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
							set104=(Token)input.LT(1);
							if ( input.LA(1)==COMMA||input.LA(1)==NAME ) {
								input.consume();
								if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set104));
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

				SINGLE_QUOTE105=(Token)match(input,SINGLE_QUOTE,FOLLOW_SINGLE_QUOTE_in_source_meta_value2064); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SINGLE_QUOTE105_tree = (Object)adaptor.create(SINGLE_QUOTE105);
					adaptor.addChild(root_0, SINGLE_QUOTE105_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:423:1: source_meta_def returns [BaseMetaDef ret] : c= source_meta_name dt= source_meta_value ;
	public final TOMMY_SQLParser.source_meta_def_return source_meta_def() throws RecognitionException {
		TOMMY_SQLParser.source_meta_def_return retval = new TOMMY_SQLParser.source_meta_def_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		TOMMY_SQLParser.source_meta_name_return c = null;

		TOMMY_SQLParser.source_meta_value_return dt = null;



		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:424:5: (c= source_meta_name dt= source_meta_value )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:424:9: c= source_meta_name dt= source_meta_value
			{
				root_0 = (Object)adaptor.nil();

				pushFollow(FOLLOW_source_meta_name_in_source_meta_def2091);
				c=source_meta_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
				pushFollow(FOLLOW_source_meta_value_in_source_meta_def2095);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:428:1: ddl_source_meta_defs returns [List<BaseMetaDef> ret] : v= source_meta_def ( COMMA v= source_meta_def )* ;
	public final TOMMY_SQLParser.ddl_source_meta_defs_return ddl_source_meta_defs() throws RecognitionException {
		TOMMY_SQLParser.ddl_source_meta_defs_return retval = new TOMMY_SQLParser.ddl_source_meta_defs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA106=null;
		TOMMY_SQLParser.source_meta_def_return v = null;


		Object COMMA106_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:429:10: (v= source_meta_def ( COMMA v= source_meta_def )* )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:430:14: v= source_meta_def ( COMMA v= source_meta_def )*
			{
				root_0 = (Object)adaptor.nil();

				pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2148);
				v=source_meta_def();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
				if ( state.backtracking==0 ) {

					retval.ret = new ArrayList<BaseMetaDef>();
					retval.ret.add(v.ret);

				}
				// org/tommy/stationery/ink/core/TOMMY_SQL.g:433:16: ( COMMA v= source_meta_def )*
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
							// org/tommy/stationery/ink/core/TOMMY_SQL.g:433:17: COMMA v= source_meta_def
						{
							COMMA106=(Token)match(input,COMMA,FOLLOW_COMMA_in_ddl_source_meta_defs2153); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
								COMMA106_tree = (Object)adaptor.create(COMMA106);
								adaptor.addChild(root_0, COMMA106_tree);
							}
							pushFollow(FOLLOW_source_meta_def_in_ddl_source_meta_defs2159);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:436:1: create_source_statement : CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON ;
	public final TOMMY_SQLParser.create_source_statement_return create_source_statement() throws RecognitionException {
		TOMMY_SQLParser.create_source_statement_return retval = new TOMMY_SQLParser.create_source_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CREATE107=null;
		Token SOURCE108=null;
		Token META109=null;
		Token LPAREN110=null;
		Token RPAREN111=null;
		Token SEMICOLON112=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;

		TOMMY_SQLParser.ddl_source_meta_defs_return metas = null;


		Object CREATE107_tree=null;
		Object SOURCE108_tree=null;
		Object META109_tree=null;
		Object LPAREN110_tree=null;
		Object RPAREN111_tree=null;
		Object SEMICOLON112_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:437:5: ( CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:437:7: CREATE SOURCE table_name= ddl_table_name META LPAREN metas= ddl_source_meta_defs RPAREN SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				CREATE107=(Token)match(input,CREATE,FOLLOW_CREATE_in_create_source_statement2186); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					CREATE107_tree = (Object)adaptor.create(CREATE107);
					adaptor.addChild(root_0, CREATE107_tree);
				}
				SOURCE108=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_create_source_statement2188); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SOURCE108_tree = (Object)adaptor.create(SOURCE108);
					adaptor.addChild(root_0, SOURCE108_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_create_source_statement2192);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				META109=(Token)match(input,META,FOLLOW_META_in_create_source_statement2194); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					META109_tree = (Object)adaptor.create(META109);
					adaptor.addChild(root_0, META109_tree);
				}
				LPAREN110=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create_source_statement2196); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					LPAREN110_tree = (Object)adaptor.create(LPAREN110);
					adaptor.addChild(root_0, LPAREN110_tree);
				}
				pushFollow(FOLLOW_ddl_source_meta_defs_in_create_source_statement2200);
				metas=ddl_source_meta_defs();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, metas.getTree());
				RPAREN111=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create_source_statement2202); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					RPAREN111_tree = (Object)adaptor.create(RPAREN111);
					adaptor.addChild(root_0, RPAREN111_tree);
				}
				SEMICOLON112=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_create_source_statement2204); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON112_tree = (Object)adaptor.create(SEMICOLON112);
					adaptor.addChild(root_0, SEMICOLON112_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:450:1: drop_source_statement : DROP SOURCE table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.drop_source_statement_return drop_source_statement() throws RecognitionException {
		TOMMY_SQLParser.drop_source_statement_return retval = new TOMMY_SQLParser.drop_source_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DROP113=null;
		Token SOURCE114=null;
		Token SEMICOLON115=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object DROP113_tree=null;
		Object SOURCE114_tree=null;
		Object SEMICOLON115_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:451:5: ( DROP SOURCE table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:451:7: DROP SOURCE table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				DROP113=(Token)match(input,DROP,FOLLOW_DROP_in_drop_source_statement2227); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					DROP113_tree = (Object)adaptor.create(DROP113);
					adaptor.addChild(root_0, DROP113_tree);
				}
				SOURCE114=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_drop_source_statement2229); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SOURCE114_tree = (Object)adaptor.create(SOURCE114);
					adaptor.addChild(root_0, SOURCE114_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_drop_source_statement2233);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON115=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_source_statement2235); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON115_tree = (Object)adaptor.create(SEMICOLON115);
					adaptor.addChild(root_0, SEMICOLON115_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:462:1: show_source_statement : SHOW SOURCE table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.show_source_statement_return show_source_statement() throws RecognitionException {
		TOMMY_SQLParser.show_source_statement_return retval = new TOMMY_SQLParser.show_source_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW116=null;
		Token SOURCE117=null;
		Token SEMICOLON118=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object SHOW116_tree=null;
		Object SOURCE117_tree=null;
		Object SEMICOLON118_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:463:5: ( SHOW SOURCE table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:463:7: SHOW SOURCE table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW116=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_source_statement2258); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW116_tree = (Object)adaptor.create(SHOW116);
					adaptor.addChild(root_0, SHOW116_tree);
				}
				SOURCE117=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_show_source_statement2260); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SOURCE117_tree = (Object)adaptor.create(SOURCE117);
					adaptor.addChild(root_0, SOURCE117_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_show_source_statement2264);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON118=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_source_statement2266); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON118_tree = (Object)adaptor.create(SEMICOLON118);
					adaptor.addChild(root_0, SEMICOLON118_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:474:1: show_sources_statement : SHOW SOURCES SEMICOLON ;
	public final TOMMY_SQLParser.show_sources_statement_return show_sources_statement() throws RecognitionException {
		TOMMY_SQLParser.show_sources_statement_return retval = new TOMMY_SQLParser.show_sources_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW119=null;
		Token SOURCES120=null;
		Token SEMICOLON121=null;

		Object SHOW119_tree=null;
		Object SOURCES120_tree=null;
		Object SEMICOLON121_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:475:5: ( SHOW SOURCES SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:475:7: SHOW SOURCES SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW119=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_sources_statement2289); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW119_tree = (Object)adaptor.create(SHOW119);
					adaptor.addChild(root_0, SHOW119_tree);
				}
				SOURCES120=(Token)match(input,SOURCES,FOLLOW_SOURCES_in_show_sources_statement2291); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SOURCES120_tree = (Object)adaptor.create(SOURCES120);
					adaptor.addChild(root_0, SOURCES120_tree);
				}
				SEMICOLON121=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_sources_statement2293); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON121_tree = (Object)adaptor.create(SEMICOLON121);
					adaptor.addChild(root_0, SEMICOLON121_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:485:1: drop_job_statement : DROP JOB table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.drop_job_statement_return drop_job_statement() throws RecognitionException {
		TOMMY_SQLParser.drop_job_statement_return retval = new TOMMY_SQLParser.drop_job_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token DROP122=null;
		Token JOB123=null;
		Token SEMICOLON124=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object DROP122_tree=null;
		Object JOB123_tree=null;
		Object SEMICOLON124_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:486:5: ( DROP JOB table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:486:7: DROP JOB table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				DROP122=(Token)match(input,DROP,FOLLOW_DROP_in_drop_job_statement2316); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					DROP122_tree = (Object)adaptor.create(DROP122);
					adaptor.addChild(root_0, DROP122_tree);
				}
				JOB123=(Token)match(input,JOB,FOLLOW_JOB_in_drop_job_statement2318); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					JOB123_tree = (Object)adaptor.create(JOB123);
					adaptor.addChild(root_0, JOB123_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_drop_job_statement2322);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON124=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_drop_job_statement2324); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON124_tree = (Object)adaptor.create(SEMICOLON124);
					adaptor.addChild(root_0, SEMICOLON124_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:497:1: show_job_statement : SHOW JOB table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.show_job_statement_return show_job_statement() throws RecognitionException {
		TOMMY_SQLParser.show_job_statement_return retval = new TOMMY_SQLParser.show_job_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW125=null;
		Token JOB126=null;
		Token SEMICOLON127=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object SHOW125_tree=null;
		Object JOB126_tree=null;
		Object SEMICOLON127_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:498:5: ( SHOW JOB table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:498:7: SHOW JOB table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW125=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_job_statement2347); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW125_tree = (Object)adaptor.create(SHOW125);
					adaptor.addChild(root_0, SHOW125_tree);
				}
				JOB126=(Token)match(input,JOB,FOLLOW_JOB_in_show_job_statement2349); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					JOB126_tree = (Object)adaptor.create(JOB126);
					adaptor.addChild(root_0, JOB126_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_show_job_statement2353);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON127=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_job_statement2355); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON127_tree = (Object)adaptor.create(SEMICOLON127);
					adaptor.addChild(root_0, SEMICOLON127_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:509:1: show_jobs_statement : SHOW JOBS SEMICOLON ;
	public final TOMMY_SQLParser.show_jobs_statement_return show_jobs_statement() throws RecognitionException {
		TOMMY_SQLParser.show_jobs_statement_return retval = new TOMMY_SQLParser.show_jobs_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW128=null;
		Token JOBS129=null;
		Token SEMICOLON130=null;

		Object SHOW128_tree=null;
		Object JOBS129_tree=null;
		Object SEMICOLON130_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:510:5: ( SHOW JOBS SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:510:7: SHOW JOBS SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW128=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_jobs_statement2378); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW128_tree = (Object)adaptor.create(SHOW128);
					adaptor.addChild(root_0, SHOW128_tree);
				}
				JOBS129=(Token)match(input,JOBS,FOLLOW_JOBS_in_show_jobs_statement2380); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					JOBS129_tree = (Object)adaptor.create(JOBS129);
					adaptor.addChild(root_0, JOBS129_tree);
				}
				SEMICOLON130=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_jobs_statement2382); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON130_tree = (Object)adaptor.create(SEMICOLON130);
					adaptor.addChild(root_0, SEMICOLON130_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:520:1: show_cluster_statement : SHOW CLUSTER SEMICOLON ;
	public final TOMMY_SQLParser.show_cluster_statement_return show_cluster_statement() throws RecognitionException {
		TOMMY_SQLParser.show_cluster_statement_return retval = new TOMMY_SQLParser.show_cluster_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW131=null;
		Token CLUSTER132=null;
		Token SEMICOLON133=null;

		Object SHOW131_tree=null;
		Object CLUSTER132_tree=null;
		Object SEMICOLON133_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:521:5: ( SHOW CLUSTER SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:521:7: SHOW CLUSTER SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW131=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_cluster_statement2405); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW131_tree = (Object)adaptor.create(SHOW131);
					adaptor.addChild(root_0, SHOW131_tree);
				}
				CLUSTER132=(Token)match(input,CLUSTER,FOLLOW_CLUSTER_in_show_cluster_statement2407); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					CLUSTER132_tree = (Object)adaptor.create(CLUSTER132);
					adaptor.addChild(root_0, CLUSTER132_tree);
				}
				SEMICOLON133=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_cluster_statement2409); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON133_tree = (Object)adaptor.create(SEMICOLON133);
					adaptor.addChild(root_0, SEMICOLON133_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:531:1: show_system_statement : SHOW SYSTEM SEMICOLON ;
	public final TOMMY_SQLParser.show_system_statement_return show_system_statement() throws RecognitionException {
		TOMMY_SQLParser.show_system_statement_return retval = new TOMMY_SQLParser.show_system_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SHOW134=null;
		Token SYSTEM135=null;
		Token SEMICOLON136=null;

		Object SHOW134_tree=null;
		Object SYSTEM135_tree=null;
		Object SEMICOLON136_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:532:5: ( SHOW SYSTEM SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:532:7: SHOW SYSTEM SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SHOW134=(Token)match(input,SHOW,FOLLOW_SHOW_in_show_system_statement2432); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SHOW134_tree = (Object)adaptor.create(SHOW134);
					adaptor.addChild(root_0, SHOW134_tree);
				}
				SYSTEM135=(Token)match(input,SYSTEM,FOLLOW_SYSTEM_in_show_system_statement2434); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SYSTEM135_tree = (Object)adaptor.create(SYSTEM135);
					adaptor.addChild(root_0, SYSTEM135_tree);
				}
				SEMICOLON136=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_show_system_statement2436); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON136_tree = (Object)adaptor.create(SEMICOLON136);
					adaptor.addChild(root_0, SEMICOLON136_tree);
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
	// org/tommy/stationery/ink/core/TOMMY_SQL.g:542:1: snapshot_job_statement : SNAPSHOT JOB table_name= ddl_table_name SEMICOLON ;
	public final TOMMY_SQLParser.snapshot_job_statement_return snapshot_job_statement() throws RecognitionException {
		TOMMY_SQLParser.snapshot_job_statement_return retval = new TOMMY_SQLParser.snapshot_job_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SNAPSHOT137=null;
		Token JOB138=null;
		Token SEMICOLON139=null;
		TOMMY_SQLParser.ddl_table_name_return table_name = null;


		Object SNAPSHOT137_tree=null;
		Object JOB138_tree=null;
		Object SEMICOLON139_tree=null;

		try {
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:543:5: ( SNAPSHOT JOB table_name= ddl_table_name SEMICOLON )
			// org/tommy/stationery/ink/core/TOMMY_SQL.g:543:7: SNAPSHOT JOB table_name= ddl_table_name SEMICOLON
			{
				root_0 = (Object)adaptor.nil();

				SNAPSHOT137=(Token)match(input,SNAPSHOT,FOLLOW_SNAPSHOT_in_snapshot_job_statement2459); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SNAPSHOT137_tree = (Object)adaptor.create(SNAPSHOT137);
					adaptor.addChild(root_0, SNAPSHOT137_tree);
				}
				JOB138=(Token)match(input,JOB,FOLLOW_JOB_in_snapshot_job_statement2461); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					JOB138_tree = (Object)adaptor.create(JOB138);
					adaptor.addChild(root_0, JOB138_tree);
				}
				pushFollow(FOLLOW_ddl_table_name_in_snapshot_job_statement2465);
				table_name=ddl_table_name();

				state._fsp--;
				if (state.failed) return retval;
				if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
				SEMICOLON139=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_snapshot_job_statement2467); if (state.failed) return retval;
				if ( state.backtracking==0 ) {
					SEMICOLON139_tree = (Object)adaptor.create(SEMICOLON139);
					adaptor.addChild(root_0, SEMICOLON139_tree);
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

		// org/tommy/stationery/ink/core/TOMMY_SQL.g:175:9: (n=~ ( '\\r' | '\\n' | ';' ) )
		// org/tommy/stationery/ink/core/TOMMY_SQL.g:175:9: n=~ ( '\\r' | '\\n' | ';' )
		{
			n=(Token)input.LT(1);
			if ( (input.LA(1)>=REST && input.LA(1)<=UNDERLINE)||(input.LA(1)>=COMMA && input.LA(1)<=DIGIT)||(input.LA(1)>=70 && input.LA(1)<=87) ) {
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

	// $ANTLR start synpred43_TOMMY_SQL
	public final void synpred43_TOMMY_SQL_fragment() throws RecognitionException {
		TOMMY_SQLParser.dml_lookup_select_where_body2_return body2 = null;


		// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:52: ( SET body2= dml_lookup_select_where_body2 )
		// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:52: SET body2= dml_lookup_select_where_body2
		{
			match(input,SET,FOLLOW_SET_in_synpred43_TOMMY_SQL1283); if (state.failed) return ;
			pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred43_TOMMY_SQL1289);
			body2=dml_lookup_select_where_body2();

			state._fsp--;
			if (state.failed) return ;

		}
	}
	// $ANTLR end synpred43_TOMMY_SQL

	// $ANTLR start synpred44_TOMMY_SQL
	public final void synpred44_TOMMY_SQL_fragment() throws RecognitionException {
		TOMMY_SQLParser.dml_lookup_select_where_body_return body3 = null;

		TOMMY_SQLParser.dml_lookup_select_where_body2_return body4 = null;


		// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:96: ( SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 )
		// org/tommy/stationery/ink/core/TOMMY_SQL.g:255:96: SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2
		{
			match(input,SET,FOLLOW_SET_in_synpred44_TOMMY_SQL1293); if (state.failed) return ;
			pushFollow(FOLLOW_dml_lookup_select_where_body_in_synpred44_TOMMY_SQL1299);
			body3=dml_lookup_select_where_body();

			state._fsp--;
			if (state.failed) return ;
			match(input,WHERE,FOLLOW_WHERE_in_synpred44_TOMMY_SQL1301); if (state.failed) return ;
			pushFollow(FOLLOW_dml_lookup_select_where_body2_in_synpred44_TOMMY_SQL1305);
			body4=dml_lookup_select_where_body2();

			state._fsp--;
			if (state.failed) return ;

		}
	}
	// $ANTLR end synpred44_TOMMY_SQL

	// Delegated rules

	public final boolean synpred44_TOMMY_SQL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred44_TOMMY_SQL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred43_TOMMY_SQL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred43_TOMMY_SQL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
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
	protected DFA11 dfa11 = new DFA11(this);
	static final String DFA1_eotS =
			"\36\uffff";
	static final String DFA1_eofS =
			"\1\1\35\uffff";
	static final String DFA1_minS =
			"\1\4\2\uffff\1\5\12\uffff\2\16\16\uffff";
	static final String DFA1_maxS =
			"\1\74\2\uffff\1\70\12\uffff\1\22\1\26\16\uffff";
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
			return "()+ loopback of 104:7: ( rest_statement | show_system_statement | commit_statement | use_statement | snapshot_job_statement | kill_job_statement | set_statement | show_sources_statement | show_streams_statement | show_cluster_statement | show_jobs_statement | insert_statement | update_statement | upsert_statement | lookup_statement | select_statement | create_stream_statement | create_source_statement | show_stream_statement | show_source_statement | drop_stream_statement | drop_source_statement | drop_job_statement | show_job_statement | delete_statement )+";
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
			"\2\127\1\uffff\2\127\1\0\1\uffff\1\0\5\127\1\0\4\127\2\0\5\127\1"+
					"\0\4\127\1\0\1\127\1\0\3\127\1\0\1\127\1\0\10\127\1\0\1\127\1\0"+
					"\4\127\1\0\4\127\1\0\1\127\2\0\1\127\1\0\3\127\3\0\5\127\1\0\5\127"+
					"\1\0\1\127\1\0\1\127\1\0\4\127\4\0\5\127\3\0\1\127\2\0";
	static final String DFA4_acceptS =
			"\2\uffff\1\2\3\uffff\1\1\143\uffff";
	static final String DFA4_specialS =
			"\5\uffff\1\0\1\uffff\1\17\5\uffff\1\23\4\uffff\1\30\1\14\5\uffff"+
					"\1\7\4\uffff\1\21\1\uffff\1\15\3\uffff\1\11\1\uffff\1\27\10\uffff"+
					"\1\20\1\uffff\1\16\4\uffff\1\35\4\uffff\1\40\1\uffff\1\4\1\25\1"+
					"\uffff\1\36\3\uffff\1\2\1\24\1\1\5\uffff\1\5\5\uffff\1\31\1\uffff"+
					"\1\26\1\uffff\1\3\4\uffff\1\10\1\33\1\6\1\32\5\uffff\1\34\1\22\1"+
					"\12\1\uffff\1\13\1\37}>";
	static final String[] DFA4_transitionS = {
			"\5\6\1\1\32\6\1\2\15\6\1\4\1\3\2\6\1\5\15\6\2\uffff\22\6",
			"\5\13\1\7\32\13\1\6\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
					"\22\13",
			"",
			"\5\20\1\14\32\20\1\6\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
					"\22\20",
			"\57\6\1\21\20\6\2\uffff\22\6",
			"\1\uffff",
			"",
			"\1\uffff",
			"\5\27\1\23\32\27\1\22\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
					"\22\27",
			"\5\13\1\7\32\13\1\22\15\13\1\11\1\30\2\13\1\12\15\13\2\uffff"+
					"\22\13",
			"\5\35\1\31\32\35\1\22\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
					"\22\35",
			"\5\13\1\7\32\13\1\22\15\13\1\11\1\10\2\13\1\12\15\13\2\uffff"+
					"\22\13",
			"\5\43\1\37\32\43\1\36\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
					"\22\43",
			"\1\uffff",
			"\5\20\1\14\32\20\1\36\15\20\1\16\1\44\2\20\1\17\15\20\2\uffff"+
					"\22\20",
			"\5\51\1\45\32\51\1\36\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
					"\22\51",
			"\5\20\1\14\32\20\1\36\15\20\1\16\1\15\2\20\1\17\15\20\2\uffff"+
					"\22\20",
			"\5\56\1\52\32\56\1\6\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
					"\22\56",
			"\1\uffff",
			"\1\uffff",
			"\5\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
					"\22\27",
			"\5\27\1\23\32\27\1\57\15\27\1\25\1\60\2\27\1\26\15\27\2\uffff"+
					"\22\27",
			"\5\65\1\61\32\65\1\57\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
					"\22\65",
			"\5\27\1\23\32\27\1\57\15\27\1\25\1\24\2\27\1\26\15\27\2\uffff"+
					"\22\27",
			"\5\72\1\66\32\72\1\22\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
					"\22\72",
			"\1\uffff",
			"\5\65\1\61\32\65\1\73\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
					"\22\65",
			"\5\35\1\31\32\35\1\73\15\35\1\33\1\74\2\35\1\34\15\35\2\uffff"+
					"\22\35",
			"\5\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
					"\22\35",
			"\5\35\1\31\32\35\1\73\15\35\1\33\1\32\2\35\1\34\15\35\2\uffff"+
					"\22\35",
			"\1\uffff",
			"\5\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
					"\22\43",
			"\1\uffff",
			"\5\43\1\37\32\43\1\75\15\43\1\41\1\76\2\43\1\42\15\43\2\uffff"+
					"\22\43",
			"\5\103\1\77\32\103\1\75\15\103\1\101\1\100\2\103\1\102\15\103"+
					"\2\uffff\22\103",
			"\5\43\1\37\32\43\1\75\15\43\1\41\1\40\2\43\1\42\15\43\2\uffff"+
					"\22\43",
			"\1\uffff",
			"\5\103\1\77\32\103\1\104\15\103\1\101\1\100\2\103\1\102\15"+
					"\103\2\uffff\22\103",
			"\1\uffff",
			"\5\51\1\45\32\51\1\104\15\51\1\47\1\105\2\51\1\50\15\51\2\uffff"+
					"\22\51",
			"\5\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
					"\22\51",
			"\5\51\1\45\32\51\1\104\15\51\1\47\1\46\2\51\1\50\15\51\2\uffff"+
					"\22\51",
			"\5\113\1\107\32\113\1\106\15\113\1\111\1\110\2\113\1\112\15"+
					"\113\2\uffff\22\113",
			"\5\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
					"\22\56",
			"\5\56\1\52\32\56\1\106\15\56\1\54\1\114\2\56\1\55\15\56\2\uffff"+
					"\22\56",
			"\5\121\1\115\32\121\1\106\15\121\1\117\1\116\2\121\1\120\15"+
					"\121\2\uffff\22\121",
			"\5\56\1\52\32\56\1\106\15\56\1\54\1\53\2\56\1\55\15\56\2\uffff"+
					"\22\56",
			"\1\uffff",
			"\5\72\1\66\32\72\1\57\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
					"\22\72",
			"\1\uffff",
			"\5\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
					"\22\65",
			"\5\65\1\61\32\65\1\122\15\65\1\63\1\123\2\65\1\64\15\65\2\uffff"+
					"\22\65",
			"\5\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
					"\22\65",
			"\5\65\1\61\32\65\1\122\15\65\1\63\1\62\2\65\1\64\15\65\2\uffff"+
					"\22\65",
			"\1\uffff",
			"\5\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
					"\22\72",
			"\5\72\1\66\32\72\1\124\15\72\1\70\1\125\2\72\1\71\15\72\2\uffff"+
					"\22\72",
			"\5\132\1\126\32\132\1\124\15\132\1\130\1\127\2\132\1\131\15"+
					"\132\2\uffff\22\132",
			"\5\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
					"\22\72",
			"\1\uffff",
			"\5\132\1\126\32\132\1\73\15\132\1\130\1\127\2\132\1\131\15"+
					"\132\2\uffff\22\132",
			"\1\uffff",
			"\1\uffff",
			"\5\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
					"\103\2\uffff\22\103",
			"\1\uffff",
			"\5\103\1\77\32\103\1\133\15\103\1\101\1\134\2\103\1\102\15"+
					"\103\2\uffff\22\103",
			"\5\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
					"\103\2\uffff\22\103",
			"\5\103\1\77\32\103\1\133\15\103\1\101\1\100\2\103\1\102\15"+
					"\103\2\uffff\22\103",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\5\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
					"\113\2\uffff\22\113",
			"\5\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
					"\113\2\uffff\22\113",
			"\5\113\1\107\32\113\1\135\15\113\1\111\1\136\2\113\1\112\15"+
					"\113\2\uffff\22\113",
			"\5\143\1\137\32\143\1\135\15\143\1\141\1\140\2\143\1\142\15"+
					"\143\2\uffff\22\143",
			"\5\113\1\107\32\113\1\135\15\113\1\111\1\110\2\113\1\112\15"+
					"\113\2\uffff\22\113",
			"\1\uffff",
			"\5\143\1\137\32\143\1\144\15\143\1\141\1\140\2\143\1\142\15"+
					"\143\2\uffff\22\143",
			"\5\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
					"\121\2\uffff\22\121",
			"\5\121\1\115\32\121\1\144\15\121\1\117\1\145\2\121\1\120\15"+
					"\121\2\uffff\22\121",
			"\5\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
					"\121\2\uffff\22\121",
			"\5\121\1\115\32\121\1\144\15\121\1\117\1\116\2\121\1\120\15"+
					"\121\2\uffff\22\121",
			"\1\uffff",
			"\5\132\1\126\32\132\1\122\15\132\1\130\1\127\2\132\1\131\15"+
					"\132\2\uffff\22\132",
			"\1\uffff",
			"\5\72\1\66\32\72\1\124\15\72\1\70\1\67\2\72\1\71\15\72\2\uffff"+
					"\22\72",
			"\1\uffff",
			"\5\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
					"\132\2\uffff\22\132",
			"\5\132\1\126\32\132\1\146\15\132\1\130\1\147\2\132\1\131\15"+
					"\132\2\uffff\22\132",
			"\5\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
					"\132\2\uffff\22\132",
			"\5\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
					"\132\2\uffff\22\132",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\5\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
					"\143\2\uffff\22\143",
			"\5\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
					"\143\2\uffff\22\143",
			"\5\143\1\137\32\143\1\150\15\143\1\141\1\151\2\143\1\142\15"+
					"\143\2\uffff\22\143",
			"\5\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
					"\143\2\uffff\22\143",
			"\5\143\1\137\32\143\1\150\15\143\1\141\1\140\2\143\1\142\15"+
					"\143\2\uffff\22\143",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\5\132\1\126\32\132\1\146\15\132\1\130\1\127\2\132\1\131\15"+
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
			return "()+ loopback of 175:9: (n=~ ( '\\r' | '\\n' | ';' ) )+";
		}
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
				case 0 :
					int LA4_5 = input.LA(1);


					int index4_5 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_5);
					if ( s>=0 ) return s;
					break;
				case 1 :
					int LA4_70 = input.LA(1);


					int index4_70 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_70);
					if ( s>=0 ) return s;
					break;
				case 2 :
					int LA4_68 = input.LA(1);


					int index4_68 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_68);
					if ( s>=0 ) return s;
					break;
				case 3 :
					int LA4_86 = input.LA(1);


					int index4_86 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_86);
					if ( s>=0 ) return s;
					break;
				case 4 :
					int LA4_61 = input.LA(1);


					int index4_61 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_61);
					if ( s>=0 ) return s;
					break;
				case 5 :
					int LA4_76 = input.LA(1);


					int index4_76 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_76);
					if ( s>=0 ) return s;
					break;
				case 6 :
					int LA4_93 = input.LA(1);


					int index4_93 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_93);
					if ( s>=0 ) return s;
					break;
				case 7 :
					int LA4_25 = input.LA(1);


					int index4_25 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_25);
					if ( s>=0 ) return s;
					break;
				case 8 :
					int LA4_91 = input.LA(1);


					int index4_91 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_91);
					if ( s>=0 ) return s;
					break;
				case 9 :
					int LA4_36 = input.LA(1);


					int index4_36 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_36);
					if ( s>=0 ) return s;
					break;
				case 10 :
					int LA4_102 = input.LA(1);


					int index4_102 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_102);
					if ( s>=0 ) return s;
					break;
				case 11 :
					int LA4_104 = input.LA(1);


					int index4_104 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_104);
					if ( s>=0 ) return s;
					break;
				case 12 :
					int LA4_19 = input.LA(1);


					int index4_19 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_19);
					if ( s>=0 ) return s;
					break;
				case 13 :
					int LA4_32 = input.LA(1);


					int index4_32 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_32);
					if ( s>=0 ) return s;
					break;
				case 14 :
					int LA4_49 = input.LA(1);


					int index4_49 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_49);
					if ( s>=0 ) return s;
					break;
				case 15 :
					int LA4_7 = input.LA(1);


					int index4_7 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_7);
					if ( s>=0 ) return s;
					break;
				case 16 :
					int LA4_47 = input.LA(1);


					int index4_47 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_47);
					if ( s>=0 ) return s;
					break;
				case 17 :
					int LA4_30 = input.LA(1);


					int index4_30 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_30);
					if ( s>=0 ) return s;
					break;
				case 18 :
					int LA4_101 = input.LA(1);


					int index4_101 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_101);
					if ( s>=0 ) return s;
					break;
				case 19 :
					int LA4_13 = input.LA(1);


					int index4_13 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_13);
					if ( s>=0 ) return s;
					break;
				case 20 :
					int LA4_69 = input.LA(1);


					int index4_69 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_69);
					if ( s>=0 ) return s;
					break;
				case 21 :
					int LA4_62 = input.LA(1);


					int index4_62 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_62);
					if ( s>=0 ) return s;
					break;
				case 22 :
					int LA4_84 = input.LA(1);


					int index4_84 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_84);
					if ( s>=0 ) return s;
					break;
				case 23 :
					int LA4_38 = input.LA(1);


					int index4_38 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_38);
					if ( s>=0 ) return s;
					break;
				case 24 :
					int LA4_18 = input.LA(1);


					int index4_18 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_18);
					if ( s>=0 ) return s;
					break;
				case 25 :
					int LA4_82 = input.LA(1);


					int index4_82 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_82);
					if ( s>=0 ) return s;
					break;
				case 26 :
					int LA4_94 = input.LA(1);


					int index4_94 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_94);
					if ( s>=0 ) return s;
					break;
				case 27 :
					int LA4_92 = input.LA(1);


					int index4_92 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_92);
					if ( s>=0 ) return s;
					break;
				case 28 :
					int LA4_100 = input.LA(1);


					int index4_100 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_100);
					if ( s>=0 ) return s;
					break;
				case 29 :
					int LA4_54 = input.LA(1);


					int index4_54 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_54);
					if ( s>=0 ) return s;
					break;
				case 30 :
					int LA4_64 = input.LA(1);


					int index4_64 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_64);
					if ( s>=0 ) return s;
					break;
				case 31 :
					int LA4_105 = input.LA(1);


					int index4_105 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_105);
					if ( s>=0 ) return s;
					break;
				case 32 :
					int LA4_59 = input.LA(1);


					int index4_59 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred31_TOMMY_SQL()) ) {s = 6;}

					else if ( (true) ) {s = 2;}


					input.seek(index4_59);
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
	static final String DFA11_eotS =
			"\12\uffff";
	static final String DFA11_eofS =
			"\12\uffff";
	static final String DFA11_minS =
			"\1\44\1\4\1\uffff\1\4\1\uffff\3\4\1\0\1\uffff";
	static final String DFA11_maxS =
			"\1\66\1\127\1\uffff\1\127\1\uffff\3\127\1\0\1\uffff";
	static final String DFA11_acceptS =
			"\2\uffff\1\3\1\uffff\1\1\4\uffff\1\2";
	static final String DFA11_specialS =
			"\10\uffff\1\0\1\uffff}>";
	static final String[] DFA11_transitionS = {
			"\1\2\21\uffff\1\1",
			"\40\3\1\uffff\37\3\2\uffff\22\3",
			"",
			"\5\3\1\5\32\3\1\4\37\3\2\uffff\22\3",
			"",
			"\5\7\1\6\32\7\1\4\37\7\2\uffff\22\7",
			"\5\7\1\6\32\7\1\10\37\7\2\uffff\22\7",
			"\5\7\1\6\32\7\1\10\37\7\2\uffff\22\7",
			"\1\uffff",
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
			return "255:51: ( SET body2= dml_lookup_select_where_body2 | SET body3= dml_lookup_select_where_body WHERE body4= dml_lookup_select_where_body2 | SEMICOLON )";
		}
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
				case 0 :
					int LA11_8 = input.LA(1);


					int index11_8 = input.index();
					input.rewind();
					s = -1;
					if ( (synpred43_TOMMY_SQL()) ) {s = 4;}

					else if ( (synpred44_TOMMY_SQL()) ) {s = 9;}


					input.seek(index11_8);
					if ( s>=0 ) return s;
					break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
					new NoViableAltException(getDescription(), 11, _s, input);
			error(nvae);
			throw nvae;
		}
	}


	public static final BitSet FOLLOW_rest_statement_in_create_statement606 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_system_statement_in_create_statement608 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_commit_statement_in_create_statement610 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_use_statement_in_create_statement612 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_snapshot_job_statement_in_create_statement614 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_kill_job_statement_in_create_statement616 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_set_statement_in_create_statement618 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_sources_statement_in_create_statement620 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_streams_statement_in_create_statement622 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_cluster_statement_in_create_statement624 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_jobs_statement_in_create_statement626 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_insert_statement_in_create_statement628 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_update_statement_in_create_statement630 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_upsert_statement_in_create_statement632 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_lookup_statement_in_create_statement634 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_select_statement_in_create_statement636 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_create_stream_statement_in_create_statement638 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_create_source_statement_in_create_statement640 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_stream_statement_in_create_statement642 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_source_statement_in_create_statement644 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_drop_stream_statement_in_create_statement646 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_drop_source_statement_in_create_statement648 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_drop_job_statement_in_create_statement650 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_show_job_statement_in_create_statement652 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_delete_statement_in_create_statement654 = new BitSet(new long[]{0x1E60000000303CD2L});
	public static final BitSet FOLLOW_NAME_in_use_name_def688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USE_in_use_statement707 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_set_name_def_in_use_statement711 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_use_statement713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_set_name_def745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_set_value_def773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_set_statement793 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_set_name_def_in_set_statement797 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_EQUAL_in_set_statement799 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement801 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_set_value_def_in_set_statement805 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_set_statement807 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_set_statement809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LSQUARE_in_dml_table_name839 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_NAME_in_dml_table_name843 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_COLON_in_dml_table_name845 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_NAME_in_dml_table_name849 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_RSQUARE_in_dml_table_name851 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LSQUARE_in_dml_bind_column_name878 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_COLON_in_dml_bind_column_name880 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_NAME_in_dml_bind_column_name882 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_RSQUARE_in_dml_bind_column_name884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_dml_lookup_where911 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_NAME_in_dml_lookup_where914 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_NAME_in_dml_select_body944 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_NAME_in_dml_select_body947 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body976 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF2L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_set_in_dml_lookup_select_where_body21012 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_SEMICOLON_in_dml_lookup_select_where_body21024 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOOKUP_in_lookup_statement1043 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_lookup_statement1049 = new BitSet(new long[]{0x0000001000000200L});
	public static final BitSet FOLLOW_WHERE_in_lookup_statement1052 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_lookup_statement1058 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_lookup_statement1060 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_select_statement1084 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_select_statement1090 = new BitSet(new long[]{0x0000001000000200L});
	public static final BitSet FOLLOW_WHERE_in_select_statement1093 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_select_statement1099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_select_statement1101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REST_in_rest_statement1125 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_INTO_in_rest_statement1127 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_rest_statement1133 = new BitSet(new long[]{0x0008001000000000L});
	public static final BitSet FOLLOW_VALUES_in_rest_statement1136 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_rest_statement1142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_rest_statement1144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_in_insert_statement1168 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_INTO_in_insert_statement1170 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_insert_statement1176 = new BitSet(new long[]{0x000C001000000000L});
	public static final BitSet FOLLOW_VALUES_in_insert_statement1179 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_insert_statement1185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCREASE_in_insert_statement1187 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_VALUES_in_insert_statement1189 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_insert_statement1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_insert_statement1197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPSERT_in_upsert_statement1221 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_INTO_in_upsert_statement1223 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_upsert_statement1229 = new BitSet(new long[]{0x000C001000000000L});
	public static final BitSet FOLLOW_VALUES_in_upsert_statement1232 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCREASE_in_upsert_statement1240 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_VALUES_in_upsert_statement1242 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_upsert_statement1248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_upsert_statement1250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_update_statement1274 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1280 = new BitSet(new long[]{0x0040001000000000L});
	public static final BitSet FOLLOW_SET_in_update_statement1283 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_update_statement1293 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_update_statement1299 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_WHERE_in_update_statement1301 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_update_statement1305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_update_statement1307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_delete_statement1331 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_FROM_in_delete_statement1333 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_delete_statement1339 = new BitSet(new long[]{0x0000001000000200L});
	public static final BitSet FOLLOW_WHERE_in_delete_statement1342 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_delete_statement1348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_delete_statement1350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_ddl_table_name1382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_ddl_column_pk1415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1440 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_NAME_in_ddl_column_comment1444 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_ddl_column_comment1446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_ddl_column_name1473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_ddl_column_type1500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_def_in_ddl_column_defs1543 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_COMMA_in_ddl_column_defs1548 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_column_def_in_ddl_column_defs1554 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_ddl_column_name_in_column_def1584 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000780L});
	public static final BitSet FOLLOW_ddl_column_type_in_column_def1588 = new BitSet(new long[]{0x0000000200000002L,0x0000000000000040L});
	public static final BitSet FOLLOW_ddl_column_pk_in_column_def1593 = new BitSet(new long[]{0x0000000200000002L,0x0000000000000040L});
	public static final BitSet FOLLOW_ddl_column_comment_in_column_def1600 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_set_in_stream_meta_name1638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1667 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_NAME_in_stream_meta_value1671 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_stream_meta_value1673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stream_meta_name_in_stream_meta_def1700 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_stream_meta_value_in_stream_meta_def1704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1757 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_COMMA_in_ddl_stream_meta_defs1762 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001800L});
	public static final BitSet FOLLOW_stream_meta_def_in_ddl_stream_meta_defs1768 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_stream_statement1795 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_STREAM_in_create_stream_statement1797 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_create_stream_statement1801 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1811 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_column_defs_in_create_stream_statement1815 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1817 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_META_in_create_stream_statement1819 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_create_stream_statement1821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001800L});
	public static final BitSet FOLLOW_ddl_stream_meta_defs_in_create_stream_statement1825 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_create_stream_statement1827 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_create_stream_statement1829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_stream_statement1852 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_STREAM_in_drop_stream_statement1854 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_drop_stream_statement1858 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_drop_stream_statement1860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_stream_statement1883 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_STREAM_in_show_stream_statement1885 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_show_stream_statement1889 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_stream_statement1891 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_streams_statement1914 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_STREAMS_in_show_streams_statement1916 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_streams_statement1918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KILL_in_kill_job_statement1941 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_JOB_in_kill_job_statement1943 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_kill_job_statement1947 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_kill_job_statement1949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMIT_in_commit_statement1972 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_commit_statement1974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_source_meta_name2002 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value2051 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_NAME_in_source_meta_value2055 = new BitSet(new long[]{0x2000002200000000L});
	public static final BitSet FOLLOW_set_in_source_meta_value2057 = new BitSet(new long[]{0x2000002200000000L});
	public static final BitSet FOLLOW_SINGLE_QUOTE_in_source_meta_value2064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_source_meta_name_in_source_meta_def2091 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_source_meta_value_in_source_meta_def2095 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2148 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_COMMA_in_ddl_source_meta_defs2153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000FFE800L});
	public static final BitSet FOLLOW_source_meta_def_in_ddl_source_meta_defs2159 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_source_statement2186 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_SOURCE_in_create_source_statement2188 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_create_source_statement2192 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_META_in_create_source_statement2194 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_LPAREN_in_create_source_statement2196 = new BitSet(new long[]{0x0000000000000000L,0x0000000000FFE800L});
	public static final BitSet FOLLOW_ddl_source_meta_defs_in_create_source_statement2200 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_create_source_statement2202 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_create_source_statement2204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_source_statement2227 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_SOURCE_in_drop_source_statement2229 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_drop_source_statement2233 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_drop_source_statement2235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_source_statement2258 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_SOURCE_in_show_source_statement2260 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_show_source_statement2264 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_source_statement2266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_sources_statement2289 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_SOURCES_in_show_sources_statement2291 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_sources_statement2293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_job_statement2316 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_JOB_in_drop_job_statement2318 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_drop_job_statement2322 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_drop_job_statement2324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_job_statement2347 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_JOB_in_show_job_statement2349 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_show_job_statement2353 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_job_statement2355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_jobs_statement2378 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_JOBS_in_show_jobs_statement2380 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_jobs_statement2382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_cluster_statement2405 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_CLUSTER_in_show_cluster_statement2407 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_cluster_statement2409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SHOW_in_show_system_statement2432 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_SYSTEM_in_show_system_statement2434 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_show_system_statement2436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SNAPSHOT_in_snapshot_job_statement2459 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_JOB_in_snapshot_job_statement2461 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_ddl_table_name_in_snapshot_job_statement2465 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_snapshot_job_statement2467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_synpred31_TOMMY_SQL976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_synpred43_TOMMY_SQL1283 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred43_TOMMY_SQL1289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_synpred44_TOMMY_SQL1293 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body_in_synpred44_TOMMY_SQL1299 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_WHERE_in_synpred44_TOMMY_SQL1301 = new BitSet(new long[]{0xFFFFFFEFFFFFFFF0L,0x0000000000FFFFCFL});
	public static final BitSet FOLLOW_dml_lookup_select_where_body2_in_synpred44_TOMMY_SQL1305 = new BitSet(new long[]{0x0000000000000002L});

}