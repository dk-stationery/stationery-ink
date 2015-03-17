// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g 2015-02-13 14:10:37

    package org.tommy.stationery.ink.api.parser;

    import org.tommy.stationery.ink.api.domain.DynamicApiCallInfo;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class DYNAMIC_API_SQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GET", "BY", "AND", "UNDERLINE", "NAME", "WHITESPACE", "WS", "UNICODE_LETTER", "UNICODE_DIGIT", "LETTER", "DIGIT"
    };
    public static final int EOF=-1;
    public static final int GET=4;
    public static final int BY=5;
    public static final int AND=6;
    public static final int UNDERLINE=7;
    public static final int NAME=8;
    public static final int WHITESPACE=9;
    public static final int WS=10;
    public static final int UNICODE_LETTER=11;
    public static final int UNICODE_DIGIT=12;
    public static final int LETTER=13;
    public static final int DIGIT=14;

    // delegates
    // delegators


        public DYNAMIC_API_SQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public DYNAMIC_API_SQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return DYNAMIC_API_SQLParser.tokenNames; }
    public String getGrammarFileName() { return "org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g"; }



        private DynamicApiCallInfo dynamicApiCallInfo = new DynamicApiCallInfo();
        public DynamicApiCallInfo getDynamicApiCallInfo() {
            return this.dynamicApiCallInfo;
        }


    public static class api_table_name_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "api_table_name"
    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:40:1: api_table_name returns [String ret] : n= NAME ;
    public final DYNAMIC_API_SQLParser.api_table_name_return api_table_name() throws RecognitionException {
        DYNAMIC_API_SQLParser.api_table_name_return retval = new DYNAMIC_API_SQLParser.api_table_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:41:5: (n= NAME )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:41:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_api_table_name136); if (state.failed) return retval;
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
    // $ANTLR end "api_table_name"

    public static class api_column_name_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "api_column_name"
    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:46:1: api_column_name returns [String ret] : n= NAME ;
    public final DYNAMIC_API_SQLParser.api_column_name_return api_column_name() throws RecognitionException {
        DYNAMIC_API_SQLParser.api_column_name_return retval = new DYNAMIC_API_SQLParser.api_column_name_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:47:5: (n= NAME )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:47:9: n= NAME
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,NAME,FOLLOW_NAME_in_api_column_name163); if (state.failed) return retval;
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
    // $ANTLR end "api_column_name"

    public static class api_param_defs_return extends ParserRuleReturnScope {
        public List<String> ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "api_param_defs"
    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:50:1: api_param_defs returns [List<String> ret] : v= api_column_def ( AND v= api_column_def )* ;
    public final DYNAMIC_API_SQLParser.api_param_defs_return api_param_defs() throws RecognitionException {
        DYNAMIC_API_SQLParser.api_param_defs_return retval = new DYNAMIC_API_SQLParser.api_param_defs_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND1=null;
        DYNAMIC_API_SQLParser.api_column_def_return v = null;


        Object AND1_tree=null;

        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:51:5: (v= api_column_def ( AND v= api_column_def )* )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:52:9: v= api_column_def ( AND v= api_column_def )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_api_column_def_in_api_param_defs198);
            v=api_column_def();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if ( state.backtracking==0 ) {

                          retval.ret = new ArrayList<String>();
                          retval.ret.add(v.ret);
                      
            }
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:55:11: ( AND v= api_column_def )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case AND:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:55:12: AND v= api_column_def
            	    {
            	    AND1=(Token)match(input,AND,FOLLOW_AND_in_api_param_defs203); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND1_tree = (Object)adaptor.create(AND1);
            	    adaptor.addChild(root_0, AND1_tree);
            	    }
            	    pushFollow(FOLLOW_api_column_def_in_api_param_defs209);
            	    v=api_column_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            	    if ( state.backtracking==0 ) {
            	      retval.ret.add(v.ret);
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "api_param_defs"

    public static class api_column_def_return extends ParserRuleReturnScope {
        public String ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "api_column_def"
    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:58:1: api_column_def returns [String ret] : c= api_column_name ;
    public final DYNAMIC_API_SQLParser.api_column_def_return api_column_def() throws RecognitionException {
        DYNAMIC_API_SQLParser.api_column_def_return retval = new DYNAMIC_API_SQLParser.api_column_def_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        DYNAMIC_API_SQLParser.api_column_name_return c = null;



        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:59:5: (c= api_column_name )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:59:9: c= api_column_name
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_api_column_name_in_api_column_def239);
            c=api_column_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());
            if ( state.backtracking==0 ) {

                          retval.ret = c.ret;
                      
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "api_column_def"

    public static class get_api_statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "get_api_statement"
    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:65:1: get_api_statement : GET table_name= api_table_name BY params= api_param_defs ;
    public final DYNAMIC_API_SQLParser.get_api_statement_return get_api_statement() throws RecognitionException {
        DYNAMIC_API_SQLParser.get_api_statement_return retval = new DYNAMIC_API_SQLParser.get_api_statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token GET2=null;
        Token BY3=null;
        DYNAMIC_API_SQLParser.api_table_name_return table_name = null;

        DYNAMIC_API_SQLParser.api_param_defs_return params = null;


        Object GET2_tree=null;
        Object BY3_tree=null;

        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:66:5: ( GET table_name= api_table_name BY params= api_param_defs )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:66:7: GET table_name= api_table_name BY params= api_param_defs
            {
            root_0 = (Object)adaptor.nil();

            GET2=(Token)match(input,GET,FOLLOW_GET_in_get_api_statement266); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GET2_tree = (Object)adaptor.create(GET2);
            adaptor.addChild(root_0, GET2_tree);
            }
            pushFollow(FOLLOW_api_table_name_in_get_api_statement270);
            table_name=api_table_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, table_name.getTree());
            BY3=(Token)match(input,BY,FOLLOW_BY_in_get_api_statement272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY3_tree = (Object)adaptor.create(BY3);
            adaptor.addChild(root_0, BY3_tree);
            }
            pushFollow(FOLLOW_api_param_defs_in_get_api_statement276);
            params=api_param_defs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, params.getTree());
            if ( state.backtracking==0 ) {

                      dynamicApiCallInfo.setTableName(table_name.ret);
                      dynamicApiCallInfo.setApiName(input.toString(retval.start,input.LT(-1)));
                      dynamicApiCallInfo.setColumns(params.ret);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "get_api_statement"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_api_table_name136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_api_column_name163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_api_column_def_in_api_param_defs198 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AND_in_api_param_defs203 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_api_column_def_in_api_param_defs209 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_api_column_name_in_api_column_def239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_get_api_statement266 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_api_table_name_in_get_api_statement270 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_BY_in_get_api_statement272 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_api_param_defs_in_get_api_statement276 = new BitSet(new long[]{0x0000000000000002L});

}