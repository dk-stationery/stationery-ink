// $ANTLR 3.3 Nov 30, 2010 12:46:29 org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g 2015-02-13 14:10:37

    package org.tommy.stationery.ink.api.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DYNAMIC_API_SQLLexer extends Lexer {
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

    public DYNAMIC_API_SQLLexer() {;} 
    public DYNAMIC_API_SQLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DYNAMIC_API_SQLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g"; }

    // $ANTLR start "GET"
    public final void mGET() throws RecognitionException {
        try {
            int _type = GET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:14:5: ( 'get' )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:14:7: 'get'
            {
            match("get"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:15:4: ( 'By' )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:15:6: 'By'
            {
            match("By"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:16:5: ( 'And' )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:16:7: 'And'
            {
            match("And"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "UNDERLINE"
    public final void mUNDERLINE() throws RecognitionException {
        try {
            int _type = UNDERLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:17:11: ( '_' )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:17:13: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDERLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:74:4: ( ( WHITESPACE )+ )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:74:6: ( WHITESPACE )+
            {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:74:6: ( WHITESPACE )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:74:6: WHITESPACE
            	    {
            	    mWHITESPACE(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

             _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:75:6: ( ( UNICODE_LETTER | UNICODE_DIGIT | LETTER | DIGIT | UNDERLINE ) ( UNICODE_LETTER | UNICODE_DIGIT | LETTER | DIGIT | UNDERLINE )* )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:75:8: ( UNICODE_LETTER | UNICODE_DIGIT | LETTER | DIGIT | UNDERLINE ) ( UNICODE_LETTER | UNICODE_DIGIT | LETTER | DIGIT | UNDERLINE )*
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u021F')||(input.LA(1)>='\u0222' && input.LA(1)<='\u0233')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02AD')||(input.LA(1)>='\u02B0' && input.LA(1)<='\u02B8')||(input.LA(1)>='\u02BB' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02D0' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03D7')||(input.LA(1)>='\u03DA' && input.LA(1)<='\u03F3')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u048C' && input.LA(1)<='\u04C4')||(input.LA(1)>='\u04C7' && input.LA(1)<='\u04C8')||(input.LA(1)>='\u04CB' && input.LA(1)<='\u04CC')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u064A')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u0671' && input.LA(1)<='\u06D3')||input.LA(1)=='\u06D5'||(input.LA(1)>='\u06E5' && input.LA(1)<='\u06E6')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06FC')||input.LA(1)=='\u0710'||(input.LA(1)>='\u0712' && input.LA(1)<='\u072C')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07A5')||(input.LA(1)>='\u0905' && input.LA(1)<='\u0939')||input.LA(1)=='\u093D'||input.LA(1)=='\u0950'||(input.LA(1)>='\u0958' && input.LA(1)<='\u0961')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E1')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09F1')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0A72' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8B')||input.LA(1)=='\u0A8D'||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||input.LA(1)=='\u0ABD'||input.LA(1)=='\u0AD0'||input.LA(1)=='\u0AE0'||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B36' && input.LA(1)<='\u0B39')||input.LA(1)=='\u0B3D'||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E30')||(input.LA(1)>='\u0E32' && input.LA(1)<='\u0E33')||(input.LA(1)>='\u0E40' && input.LA(1)<='\u0E46')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB0')||(input.LA(1)>='\u0EB2' && input.LA(1)<='\u0EB3')||(input.LA(1)>='\u0EBD' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||(input.LA(1)>='\u0F40' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F88' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1055')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F6')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u1369' && input.LA(1)<='\u1371')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17B3')||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A8')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||input.LA(1)=='\u207F'||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u3029')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303A')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3094')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309E')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FA')||(input.LA(1)>='\u30FC' && input.LA(1)<='\u30FE')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||input.LA(1)=='\u3400'||input.LA(1)=='\u4DB5'||input.LA(1)=='\u4E00'||input.LA(1)=='\u9FA5'||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||input.LA(1)=='\uAC00'||input.LA(1)=='\uD7A3'||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||input.LA(1)=='\uFB1D'||(input.LA(1)>='\uFB1F' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFB')||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE72')||input.LA(1)=='\uFE74'||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF66' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:75:62: ( UNICODE_LETTER | UNICODE_DIGIT | LETTER | DIGIT | UNDERLINE )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')||LA2_0=='\u00AA'||LA2_0=='\u00B5'||LA2_0=='\u00BA'||(LA2_0>='\u00C0' && LA2_0<='\u00D6')||(LA2_0>='\u00D8' && LA2_0<='\u00F6')||(LA2_0>='\u00F8' && LA2_0<='\u021F')||(LA2_0>='\u0222' && LA2_0<='\u0233')||(LA2_0>='\u0250' && LA2_0<='\u02AD')||(LA2_0>='\u02B0' && LA2_0<='\u02B8')||(LA2_0>='\u02BB' && LA2_0<='\u02C1')||(LA2_0>='\u02D0' && LA2_0<='\u02D1')||(LA2_0>='\u02E0' && LA2_0<='\u02E4')||LA2_0=='\u02EE'||LA2_0=='\u037A'||LA2_0=='\u0386'||(LA2_0>='\u0388' && LA2_0<='\u038A')||LA2_0=='\u038C'||(LA2_0>='\u038E' && LA2_0<='\u03A1')||(LA2_0>='\u03A3' && LA2_0<='\u03CE')||(LA2_0>='\u03D0' && LA2_0<='\u03D7')||(LA2_0>='\u03DA' && LA2_0<='\u03F3')||(LA2_0>='\u0400' && LA2_0<='\u0481')||(LA2_0>='\u048C' && LA2_0<='\u04C4')||(LA2_0>='\u04C7' && LA2_0<='\u04C8')||(LA2_0>='\u04CB' && LA2_0<='\u04CC')||(LA2_0>='\u04D0' && LA2_0<='\u04F5')||(LA2_0>='\u04F8' && LA2_0<='\u04F9')||(LA2_0>='\u0531' && LA2_0<='\u0556')||LA2_0=='\u0559'||(LA2_0>='\u0561' && LA2_0<='\u0587')||(LA2_0>='\u05D0' && LA2_0<='\u05EA')||(LA2_0>='\u05F0' && LA2_0<='\u05F2')||(LA2_0>='\u0621' && LA2_0<='\u063A')||(LA2_0>='\u0640' && LA2_0<='\u064A')||(LA2_0>='\u0660' && LA2_0<='\u0669')||(LA2_0>='\u0671' && LA2_0<='\u06D3')||LA2_0=='\u06D5'||(LA2_0>='\u06E5' && LA2_0<='\u06E6')||(LA2_0>='\u06F0' && LA2_0<='\u06FC')||LA2_0=='\u0710'||(LA2_0>='\u0712' && LA2_0<='\u072C')||(LA2_0>='\u0780' && LA2_0<='\u07A5')||(LA2_0>='\u0905' && LA2_0<='\u0939')||LA2_0=='\u093D'||LA2_0=='\u0950'||(LA2_0>='\u0958' && LA2_0<='\u0961')||(LA2_0>='\u0966' && LA2_0<='\u096F')||(LA2_0>='\u0985' && LA2_0<='\u098C')||(LA2_0>='\u098F' && LA2_0<='\u0990')||(LA2_0>='\u0993' && LA2_0<='\u09A8')||(LA2_0>='\u09AA' && LA2_0<='\u09B0')||LA2_0=='\u09B2'||(LA2_0>='\u09B6' && LA2_0<='\u09B9')||(LA2_0>='\u09DC' && LA2_0<='\u09DD')||(LA2_0>='\u09DF' && LA2_0<='\u09E1')||(LA2_0>='\u09E6' && LA2_0<='\u09F1')||(LA2_0>='\u0A05' && LA2_0<='\u0A0A')||(LA2_0>='\u0A0F' && LA2_0<='\u0A10')||(LA2_0>='\u0A13' && LA2_0<='\u0A28')||(LA2_0>='\u0A2A' && LA2_0<='\u0A30')||(LA2_0>='\u0A32' && LA2_0<='\u0A33')||(LA2_0>='\u0A35' && LA2_0<='\u0A36')||(LA2_0>='\u0A38' && LA2_0<='\u0A39')||(LA2_0>='\u0A59' && LA2_0<='\u0A5C')||LA2_0=='\u0A5E'||(LA2_0>='\u0A66' && LA2_0<='\u0A6F')||(LA2_0>='\u0A72' && LA2_0<='\u0A74')||(LA2_0>='\u0A85' && LA2_0<='\u0A8B')||LA2_0=='\u0A8D'||(LA2_0>='\u0A8F' && LA2_0<='\u0A91')||(LA2_0>='\u0A93' && LA2_0<='\u0AA8')||(LA2_0>='\u0AAA' && LA2_0<='\u0AB0')||(LA2_0>='\u0AB2' && LA2_0<='\u0AB3')||(LA2_0>='\u0AB5' && LA2_0<='\u0AB9')||LA2_0=='\u0ABD'||LA2_0=='\u0AD0'||LA2_0=='\u0AE0'||(LA2_0>='\u0AE6' && LA2_0<='\u0AEF')||(LA2_0>='\u0B05' && LA2_0<='\u0B0C')||(LA2_0>='\u0B0F' && LA2_0<='\u0B10')||(LA2_0>='\u0B13' && LA2_0<='\u0B28')||(LA2_0>='\u0B2A' && LA2_0<='\u0B30')||(LA2_0>='\u0B32' && LA2_0<='\u0B33')||(LA2_0>='\u0B36' && LA2_0<='\u0B39')||LA2_0=='\u0B3D'||(LA2_0>='\u0B5C' && LA2_0<='\u0B5D')||(LA2_0>='\u0B5F' && LA2_0<='\u0B61')||(LA2_0>='\u0B66' && LA2_0<='\u0B6F')||(LA2_0>='\u0B85' && LA2_0<='\u0B8A')||(LA2_0>='\u0B8E' && LA2_0<='\u0B90')||(LA2_0>='\u0B92' && LA2_0<='\u0B95')||(LA2_0>='\u0B99' && LA2_0<='\u0B9A')||LA2_0=='\u0B9C'||(LA2_0>='\u0B9E' && LA2_0<='\u0B9F')||(LA2_0>='\u0BA3' && LA2_0<='\u0BA4')||(LA2_0>='\u0BA8' && LA2_0<='\u0BAA')||(LA2_0>='\u0BAE' && LA2_0<='\u0BB5')||(LA2_0>='\u0BB7' && LA2_0<='\u0BB9')||(LA2_0>='\u0BE7' && LA2_0<='\u0BEF')||(LA2_0>='\u0C05' && LA2_0<='\u0C0C')||(LA2_0>='\u0C0E' && LA2_0<='\u0C10')||(LA2_0>='\u0C12' && LA2_0<='\u0C28')||(LA2_0>='\u0C2A' && LA2_0<='\u0C33')||(LA2_0>='\u0C35' && LA2_0<='\u0C39')||(LA2_0>='\u0C60' && LA2_0<='\u0C61')||(LA2_0>='\u0C66' && LA2_0<='\u0C6F')||(LA2_0>='\u0C85' && LA2_0<='\u0C8C')||(LA2_0>='\u0C8E' && LA2_0<='\u0C90')||(LA2_0>='\u0C92' && LA2_0<='\u0CA8')||(LA2_0>='\u0CAA' && LA2_0<='\u0CB3')||(LA2_0>='\u0CB5' && LA2_0<='\u0CB9')||LA2_0=='\u0CDE'||(LA2_0>='\u0CE0' && LA2_0<='\u0CE1')||(LA2_0>='\u0CE6' && LA2_0<='\u0CEF')||(LA2_0>='\u0D05' && LA2_0<='\u0D0C')||(LA2_0>='\u0D0E' && LA2_0<='\u0D10')||(LA2_0>='\u0D12' && LA2_0<='\u0D28')||(LA2_0>='\u0D2A' && LA2_0<='\u0D39')||(LA2_0>='\u0D60' && LA2_0<='\u0D61')||(LA2_0>='\u0D66' && LA2_0<='\u0D6F')||(LA2_0>='\u0D85' && LA2_0<='\u0D96')||(LA2_0>='\u0D9A' && LA2_0<='\u0DB1')||(LA2_0>='\u0DB3' && LA2_0<='\u0DBB')||LA2_0=='\u0DBD'||(LA2_0>='\u0DC0' && LA2_0<='\u0DC6')||(LA2_0>='\u0E01' && LA2_0<='\u0E30')||(LA2_0>='\u0E32' && LA2_0<='\u0E33')||(LA2_0>='\u0E40' && LA2_0<='\u0E46')||(LA2_0>='\u0E50' && LA2_0<='\u0E59')||(LA2_0>='\u0E81' && LA2_0<='\u0E82')||LA2_0=='\u0E84'||(LA2_0>='\u0E87' && LA2_0<='\u0E88')||LA2_0=='\u0E8A'||LA2_0=='\u0E8D'||(LA2_0>='\u0E94' && LA2_0<='\u0E97')||(LA2_0>='\u0E99' && LA2_0<='\u0E9F')||(LA2_0>='\u0EA1' && LA2_0<='\u0EA3')||LA2_0=='\u0EA5'||LA2_0=='\u0EA7'||(LA2_0>='\u0EAA' && LA2_0<='\u0EAB')||(LA2_0>='\u0EAD' && LA2_0<='\u0EB0')||(LA2_0>='\u0EB2' && LA2_0<='\u0EB3')||(LA2_0>='\u0EBD' && LA2_0<='\u0EC4')||LA2_0=='\u0EC6'||(LA2_0>='\u0ED0' && LA2_0<='\u0ED9')||(LA2_0>='\u0EDC' && LA2_0<='\u0EDD')||LA2_0=='\u0F00'||(LA2_0>='\u0F20' && LA2_0<='\u0F29')||(LA2_0>='\u0F40' && LA2_0<='\u0F6A')||(LA2_0>='\u0F88' && LA2_0<='\u0F8B')||(LA2_0>='\u1000' && LA2_0<='\u1021')||(LA2_0>='\u1023' && LA2_0<='\u1027')||(LA2_0>='\u1029' && LA2_0<='\u102A')||(LA2_0>='\u1040' && LA2_0<='\u1049')||(LA2_0>='\u1050' && LA2_0<='\u1055')||(LA2_0>='\u10A0' && LA2_0<='\u10C5')||(LA2_0>='\u10D0' && LA2_0<='\u10F6')||(LA2_0>='\u1100' && LA2_0<='\u1159')||(LA2_0>='\u115F' && LA2_0<='\u11A2')||(LA2_0>='\u11A8' && LA2_0<='\u11F9')||(LA2_0>='\u1200' && LA2_0<='\u1206')||(LA2_0>='\u1208' && LA2_0<='\u1246')||LA2_0=='\u1248'||(LA2_0>='\u124A' && LA2_0<='\u124D')||(LA2_0>='\u1250' && LA2_0<='\u1256')||LA2_0=='\u1258'||(LA2_0>='\u125A' && LA2_0<='\u125D')||(LA2_0>='\u1260' && LA2_0<='\u1286')||LA2_0=='\u1288'||(LA2_0>='\u128A' && LA2_0<='\u128D')||(LA2_0>='\u1290' && LA2_0<='\u12AE')||LA2_0=='\u12B0'||(LA2_0>='\u12B2' && LA2_0<='\u12B5')||(LA2_0>='\u12B8' && LA2_0<='\u12BE')||LA2_0=='\u12C0'||(LA2_0>='\u12C2' && LA2_0<='\u12C5')||(LA2_0>='\u12C8' && LA2_0<='\u12CE')||(LA2_0>='\u12D0' && LA2_0<='\u12D6')||(LA2_0>='\u12D8' && LA2_0<='\u12EE')||(LA2_0>='\u12F0' && LA2_0<='\u130E')||LA2_0=='\u1310'||(LA2_0>='\u1312' && LA2_0<='\u1315')||(LA2_0>='\u1318' && LA2_0<='\u131E')||(LA2_0>='\u1320' && LA2_0<='\u1346')||(LA2_0>='\u1348' && LA2_0<='\u135A')||(LA2_0>='\u1369' && LA2_0<='\u1371')||(LA2_0>='\u13A0' && LA2_0<='\u13F4')||(LA2_0>='\u1401' && LA2_0<='\u1676')||(LA2_0>='\u1681' && LA2_0<='\u169A')||(LA2_0>='\u16A0' && LA2_0<='\u16EA')||(LA2_0>='\u1780' && LA2_0<='\u17B3')||(LA2_0>='\u17E0' && LA2_0<='\u17E9')||(LA2_0>='\u1810' && LA2_0<='\u1819')||(LA2_0>='\u1820' && LA2_0<='\u1877')||(LA2_0>='\u1880' && LA2_0<='\u18A8')||(LA2_0>='\u1E00' && LA2_0<='\u1E9B')||(LA2_0>='\u1EA0' && LA2_0<='\u1EF9')||(LA2_0>='\u1F00' && LA2_0<='\u1F15')||(LA2_0>='\u1F18' && LA2_0<='\u1F1D')||(LA2_0>='\u1F20' && LA2_0<='\u1F45')||(LA2_0>='\u1F48' && LA2_0<='\u1F4D')||(LA2_0>='\u1F50' && LA2_0<='\u1F57')||LA2_0=='\u1F59'||LA2_0=='\u1F5B'||LA2_0=='\u1F5D'||(LA2_0>='\u1F5F' && LA2_0<='\u1F7D')||(LA2_0>='\u1F80' && LA2_0<='\u1FB4')||(LA2_0>='\u1FB6' && LA2_0<='\u1FBC')||LA2_0=='\u1FBE'||(LA2_0>='\u1FC2' && LA2_0<='\u1FC4')||(LA2_0>='\u1FC6' && LA2_0<='\u1FCC')||(LA2_0>='\u1FD0' && LA2_0<='\u1FD3')||(LA2_0>='\u1FD6' && LA2_0<='\u1FDB')||(LA2_0>='\u1FE0' && LA2_0<='\u1FEC')||(LA2_0>='\u1FF2' && LA2_0<='\u1FF4')||(LA2_0>='\u1FF6' && LA2_0<='\u1FFC')||LA2_0=='\u207F'||LA2_0=='\u2102'||LA2_0=='\u2107'||(LA2_0>='\u210A' && LA2_0<='\u2113')||LA2_0=='\u2115'||(LA2_0>='\u2119' && LA2_0<='\u211D')||LA2_0=='\u2124'||LA2_0=='\u2126'||LA2_0=='\u2128'||(LA2_0>='\u212A' && LA2_0<='\u212D')||(LA2_0>='\u212F' && LA2_0<='\u2131')||(LA2_0>='\u2133' && LA2_0<='\u2139')||(LA2_0>='\u2160' && LA2_0<='\u2183')||(LA2_0>='\u3005' && LA2_0<='\u3007')||(LA2_0>='\u3021' && LA2_0<='\u3029')||(LA2_0>='\u3031' && LA2_0<='\u3035')||(LA2_0>='\u3038' && LA2_0<='\u303A')||(LA2_0>='\u3041' && LA2_0<='\u3094')||(LA2_0>='\u309D' && LA2_0<='\u309E')||(LA2_0>='\u30A1' && LA2_0<='\u30FA')||(LA2_0>='\u30FC' && LA2_0<='\u30FE')||(LA2_0>='\u3105' && LA2_0<='\u312C')||(LA2_0>='\u3131' && LA2_0<='\u318E')||(LA2_0>='\u31A0' && LA2_0<='\u31B7')||LA2_0=='\u3400'||LA2_0=='\u4DB5'||LA2_0=='\u4E00'||LA2_0=='\u9FA5'||(LA2_0>='\uA000' && LA2_0<='\uA48C')||LA2_0=='\uAC00'||LA2_0=='\uD7A3'||(LA2_0>='\uF900' && LA2_0<='\uFA2D')||(LA2_0>='\uFB00' && LA2_0<='\uFB06')||(LA2_0>='\uFB13' && LA2_0<='\uFB17')||LA2_0=='\uFB1D'||(LA2_0>='\uFB1F' && LA2_0<='\uFB28')||(LA2_0>='\uFB2A' && LA2_0<='\uFB36')||(LA2_0>='\uFB38' && LA2_0<='\uFB3C')||LA2_0=='\uFB3E'||(LA2_0>='\uFB40' && LA2_0<='\uFB41')||(LA2_0>='\uFB43' && LA2_0<='\uFB44')||(LA2_0>='\uFB46' && LA2_0<='\uFBB1')||(LA2_0>='\uFBD3' && LA2_0<='\uFD3D')||(LA2_0>='\uFD50' && LA2_0<='\uFD8F')||(LA2_0>='\uFD92' && LA2_0<='\uFDC7')||(LA2_0>='\uFDF0' && LA2_0<='\uFDFB')||(LA2_0>='\uFE70' && LA2_0<='\uFE72')||LA2_0=='\uFE74'||(LA2_0>='\uFE76' && LA2_0<='\uFEFC')||(LA2_0>='\uFF10' && LA2_0<='\uFF19')||(LA2_0>='\uFF21' && LA2_0<='\uFF3A')||(LA2_0>='\uFF41' && LA2_0<='\uFF5A')||(LA2_0>='\uFF66' && LA2_0<='\uFFBE')||(LA2_0>='\uFFC2' && LA2_0<='\uFFC7')||(LA2_0>='\uFFCA' && LA2_0<='\uFFCF')||(LA2_0>='\uFFD2' && LA2_0<='\uFFD7')||(LA2_0>='\uFFDA' && LA2_0<='\uFFDC')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u021F')||(input.LA(1)>='\u0222' && input.LA(1)<='\u0233')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02AD')||(input.LA(1)>='\u02B0' && input.LA(1)<='\u02B8')||(input.LA(1)>='\u02BB' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02D0' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03D7')||(input.LA(1)>='\u03DA' && input.LA(1)<='\u03F3')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u048C' && input.LA(1)<='\u04C4')||(input.LA(1)>='\u04C7' && input.LA(1)<='\u04C8')||(input.LA(1)>='\u04CB' && input.LA(1)<='\u04CC')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u064A')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u0671' && input.LA(1)<='\u06D3')||input.LA(1)=='\u06D5'||(input.LA(1)>='\u06E5' && input.LA(1)<='\u06E6')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06FC')||input.LA(1)=='\u0710'||(input.LA(1)>='\u0712' && input.LA(1)<='\u072C')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07A5')||(input.LA(1)>='\u0905' && input.LA(1)<='\u0939')||input.LA(1)=='\u093D'||input.LA(1)=='\u0950'||(input.LA(1)>='\u0958' && input.LA(1)<='\u0961')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E1')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09F1')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0A72' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8B')||input.LA(1)=='\u0A8D'||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||input.LA(1)=='\u0ABD'||input.LA(1)=='\u0AD0'||input.LA(1)=='\u0AE0'||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B36' && input.LA(1)<='\u0B39')||input.LA(1)=='\u0B3D'||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E30')||(input.LA(1)>='\u0E32' && input.LA(1)<='\u0E33')||(input.LA(1)>='\u0E40' && input.LA(1)<='\u0E46')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB0')||(input.LA(1)>='\u0EB2' && input.LA(1)<='\u0EB3')||(input.LA(1)>='\u0EBD' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||(input.LA(1)>='\u0F40' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F88' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1055')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F6')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u1369' && input.LA(1)<='\u1371')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17B3')||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A8')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||input.LA(1)=='\u207F'||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u3029')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303A')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3094')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309E')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FA')||(input.LA(1)>='\u30FC' && input.LA(1)<='\u30FE')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||input.LA(1)=='\u3400'||input.LA(1)=='\u4DB5'||input.LA(1)=='\u4E00'||input.LA(1)=='\u9FA5'||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||input.LA(1)=='\uAC00'||input.LA(1)=='\uD7A3'||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||input.LA(1)=='\uFB1D'||(input.LA(1)>='\uFB1F' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFB')||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE72')||input.LA(1)=='\uFE74'||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF66' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:77:21: ( ( '\\t' | '\\r' | '\\n' | ' ' | '\\u000C' ) )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:77:23: ( '\\t' | '\\r' | '\\n' | ' ' | '\\u000C' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:78:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:78:19: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:79:16: ( '0' .. '9' )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:79:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "UNICODE_LETTER"
    public final void mUNICODE_LETTER() throws RecognitionException {
        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:81:2: ( '\\u0041' .. '\\u005A' | '\\u0061' .. '\\u007A' | '\\u00AA' | '\\u00B5' | '\\u00BA' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u021F' | '\\u0222' .. '\\u0233' | '\\u0250' .. '\\u02AD' | '\\u02B0' .. '\\u02B8' | '\\u02BB' .. '\\u02C1' | '\\u02D0' .. '\\u02D1' | '\\u02E0' .. '\\u02E4' | '\\u02EE' | '\\u037A' | '\\u0386' | '\\u0388' .. '\\u038A' | '\\u038C' | '\\u038E' .. '\\u03A1' | '\\u03A3' .. '\\u03CE' | '\\u03D0' .. '\\u03D7' | '\\u03DA' .. '\\u03F3' | '\\u0400' .. '\\u0481' | '\\u048C' .. '\\u04C4' | '\\u04C7' .. '\\u04C8' | '\\u04CB' .. '\\u04CC' | '\\u04D0' .. '\\u04F5' | '\\u04F8' .. '\\u04F9' | '\\u0531' .. '\\u0556' | '\\u0559' | '\\u0561' .. '\\u0587' | '\\u05D0' .. '\\u05EA' | '\\u05F0' .. '\\u05F2' | '\\u0621' .. '\\u063A' | '\\u0640' .. '\\u064A' | '\\u0671' .. '\\u06D3' | '\\u06D5' | '\\u06E5' .. '\\u06E6' | '\\u06FA' .. '\\u06FC' | '\\u0710' | '\\u0712' .. '\\u072C' | '\\u0780' .. '\\u07A5' | '\\u0905' .. '\\u0939' | '\\u093D' | '\\u0950' | '\\u0958' .. '\\u0961' | '\\u0985' .. '\\u098C' | '\\u098F' .. '\\u0990' | '\\u0993' .. '\\u09A8' | '\\u09AA' .. '\\u09B0' | '\\u09B2' | '\\u09B6' .. '\\u09B9' | '\\u09DC' .. '\\u09DD' | '\\u09DF' .. '\\u09E1' | '\\u09F0' .. '\\u09F1' | '\\u0A05' .. '\\u0A0A' | '\\u0A0F' .. '\\u0A10' | '\\u0A13' .. '\\u0A28' | '\\u0A2A' .. '\\u0A30' | '\\u0A32' .. '\\u0A33' | '\\u0A35' .. '\\u0A36' | '\\u0A38' .. '\\u0A39' | '\\u0A59' .. '\\u0A5C' | '\\u0A5E' | '\\u0A72' .. '\\u0A74' | '\\u0A85' .. '\\u0A8B' | '\\u0A8D' | '\\u0A8F' .. '\\u0A91' | '\\u0A93' .. '\\u0AA8' | '\\u0AAA' .. '\\u0AB0' | '\\u0AB2' .. '\\u0AB3' | '\\u0AB5' .. '\\u0AB9' | '\\u0ABD' | '\\u0AD0' | '\\u0AE0' | '\\u0B05' .. '\\u0B0C' | '\\u0B0F' .. '\\u0B10' | '\\u0B13' .. '\\u0B28' | '\\u0B2A' .. '\\u0B30' | '\\u0B32' .. '\\u0B33' | '\\u0B36' .. '\\u0B39' | '\\u0B3D' | '\\u0B5C' .. '\\u0B5D' | '\\u0B5F' .. '\\u0B61' | '\\u0B85' .. '\\u0B8A' | '\\u0B8E' .. '\\u0B90' | '\\u0B92' .. '\\u0B95' | '\\u0B99' .. '\\u0B9A' | '\\u0B9C' | '\\u0B9E' .. '\\u0B9F' | '\\u0BA3' .. '\\u0BA4' | '\\u0BA8' .. '\\u0BAA' | '\\u0BAE' .. '\\u0BB5' | '\\u0BB7' .. '\\u0BB9' | '\\u0C05' .. '\\u0C0C' | '\\u0C0E' .. '\\u0C10' | '\\u0C12' .. '\\u0C28' | '\\u0C2A' .. '\\u0C33' | '\\u0C35' .. '\\u0C39' | '\\u0C60' .. '\\u0C61' | '\\u0C85' .. '\\u0C8C' | '\\u0C8E' .. '\\u0C90' | '\\u0C92' .. '\\u0CA8' | '\\u0CAA' .. '\\u0CB3' | '\\u0CB5' .. '\\u0CB9' | '\\u0CDE' | '\\u0CE0' .. '\\u0CE1' | '\\u0D05' .. '\\u0D0C' | '\\u0D0E' .. '\\u0D10' | '\\u0D12' .. '\\u0D28' | '\\u0D2A' .. '\\u0D39' | '\\u0D60' .. '\\u0D61' | '\\u0D85' .. '\\u0D96' | '\\u0D9A' .. '\\u0DB1' | '\\u0DB3' .. '\\u0DBB' | '\\u0DBD' | '\\u0DC0' .. '\\u0DC6' | '\\u0E01' .. '\\u0E30' | '\\u0E32' .. '\\u0E33' | '\\u0E40' .. '\\u0E46' | '\\u0E81' .. '\\u0E82' | '\\u0E84' | '\\u0E87' .. '\\u0E88' | '\\u0E8A' | '\\u0E8D' | '\\u0E94' .. '\\u0E97' | '\\u0E99' .. '\\u0E9F' | '\\u0EA1' .. '\\u0EA3' | '\\u0EA5' | '\\u0EA7' | '\\u0EAA' .. '\\u0EAB' | '\\u0EAD' .. '\\u0EB0' | '\\u0EB2' .. '\\u0EB3' | '\\u0EBD' .. '\\u0EC4' | '\\u0EC6' | '\\u0EDC' .. '\\u0EDD' | '\\u0F00' | '\\u0F40' .. '\\u0F6A' | '\\u0F88' .. '\\u0F8B' | '\\u1000' .. '\\u1021' | '\\u1023' .. '\\u1027' | '\\u1029' .. '\\u102A' | '\\u1050' .. '\\u1055' | '\\u10A0' .. '\\u10C5' | '\\u10D0' .. '\\u10F6' | '\\u1100' .. '\\u1159' | '\\u115F' .. '\\u11A2' | '\\u11A8' .. '\\u11F9' | '\\u1200' .. '\\u1206' | '\\u1208' .. '\\u1246' | '\\u1248' | '\\u124A' .. '\\u124D' | '\\u1250' .. '\\u1256' | '\\u1258' | '\\u125A' .. '\\u125D' | '\\u1260' .. '\\u1286' | '\\u1288' | '\\u128A' .. '\\u128D' | '\\u1290' .. '\\u12AE' | '\\u12B0' | '\\u12B2' .. '\\u12B5' | '\\u12B8' .. '\\u12BE' | '\\u12C0' | '\\u12C2' .. '\\u12C5' | '\\u12C8' .. '\\u12CE' | '\\u12D0' .. '\\u12D6' | '\\u12D8' .. '\\u12EE' | '\\u12F0' .. '\\u130E' | '\\u1310' | '\\u1312' .. '\\u1315' | '\\u1318' .. '\\u131E' | '\\u1320' .. '\\u1346' | '\\u1348' .. '\\u135A' | '\\u13A0' .. '\\u13B0' | '\\u13B1' .. '\\u13F4' | '\\u1401' .. '\\u1676' | '\\u1681' .. '\\u169A' | '\\u16A0' .. '\\u16EA' | '\\u1780' .. '\\u17B3' | '\\u1820' .. '\\u1877' | '\\u1880' .. '\\u18A8' | '\\u1E00' .. '\\u1E9B' | '\\u1EA0' .. '\\u1EE0' | '\\u1EE1' .. '\\u1EF9' | '\\u1F00' .. '\\u1F15' | '\\u1F18' .. '\\u1F1D' | '\\u1F20' .. '\\u1F39' | '\\u1F3A' .. '\\u1F45' | '\\u1F48' .. '\\u1F4D' | '\\u1F50' .. '\\u1F57' | '\\u1F59' | '\\u1F5B' | '\\u1F5D' | '\\u1F5F' .. '\\u1F7D' | '\\u1F80' .. '\\u1FB4' | '\\u1FB6' .. '\\u1FBC' | '\\u1FBE' | '\\u1FC2' .. '\\u1FC4' | '\\u1FC6' .. '\\u1FCC' | '\\u1FD0' .. '\\u1FD3' | '\\u1FD6' .. '\\u1FDB' | '\\u1FE0' .. '\\u1FEC' | '\\u1FF2' .. '\\u1FF4' | '\\u1FF6' .. '\\u1FFC' | '\\u207F' | '\\u2102' | '\\u2107' | '\\u210A' .. '\\u2113' | '\\u2115' | '\\u2119' .. '\\u211D' | '\\u2124' | '\\u2126' | '\\u2128' | '\\u212A' .. '\\u212D' | '\\u212F' .. '\\u2131' | '\\u2133' .. '\\u2139' | '\\u2160' .. '\\u2183' | '\\u3005' .. '\\u3007' | '\\u3021' .. '\\u3029' | '\\u3031' .. '\\u3035' | '\\u3038' .. '\\u303A' | '\\u3041' .. '\\u3094' | '\\u309D' .. '\\u309E' | '\\u30A1' .. '\\u30FA' | '\\u30FC' .. '\\u30FE' | '\\u3105' .. '\\u312C' | '\\u3131' .. '\\u318E' | '\\u31A0' .. '\\u31B7' | '\\u3400' | '\\u4DB5' | '\\u4E00' | '\\u9FA5' | '\\uA000' .. '\\uA48C' | '\\uAC00' | '\\uD7A3' | '\\uF900' .. '\\uFA2D' | '\\uFB00' .. '\\uFB06' | '\\uFB13' .. '\\uFB17' | '\\uFB1D' | '\\uFB1F' .. '\\uFB28' | '\\uFB2A' .. '\\uFB36' | '\\uFB38' .. '\\uFB3C' | '\\uFB3E' | '\\uFB40' .. '\\uFB41' | '\\uFB43' .. '\\uFB44' | '\\uFB46' .. '\\uFBB1' | '\\uFBD3' .. '\\uFD3D' | '\\uFD50' .. '\\uFD8F' | '\\uFD92' .. '\\uFDC7' | '\\uFDF0' .. '\\uFDFB' | '\\uFE70' .. '\\uFE72' | '\\uFE74' | '\\uFE76' .. '\\uFEFC' | '\\uFF21' .. '\\uFF3A' | '\\uFF41' .. '\\uFF5A' | '\\uFF66' .. '\\uFFBE' | '\\uFFC2' .. '\\uFFC7' | '\\uFFCA' .. '\\uFFCF' | '\\uFFD2' .. '\\uFFD7' | '\\uFFDA' .. '\\uFFDC' )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='\u00AA'||input.LA(1)=='\u00B5'||input.LA(1)=='\u00BA'||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u021F')||(input.LA(1)>='\u0222' && input.LA(1)<='\u0233')||(input.LA(1)>='\u0250' && input.LA(1)<='\u02AD')||(input.LA(1)>='\u02B0' && input.LA(1)<='\u02B8')||(input.LA(1)>='\u02BB' && input.LA(1)<='\u02C1')||(input.LA(1)>='\u02D0' && input.LA(1)<='\u02D1')||(input.LA(1)>='\u02E0' && input.LA(1)<='\u02E4')||input.LA(1)=='\u02EE'||input.LA(1)=='\u037A'||input.LA(1)=='\u0386'||(input.LA(1)>='\u0388' && input.LA(1)<='\u038A')||input.LA(1)=='\u038C'||(input.LA(1)>='\u038E' && input.LA(1)<='\u03A1')||(input.LA(1)>='\u03A3' && input.LA(1)<='\u03CE')||(input.LA(1)>='\u03D0' && input.LA(1)<='\u03D7')||(input.LA(1)>='\u03DA' && input.LA(1)<='\u03F3')||(input.LA(1)>='\u0400' && input.LA(1)<='\u0481')||(input.LA(1)>='\u048C' && input.LA(1)<='\u04C4')||(input.LA(1)>='\u04C7' && input.LA(1)<='\u04C8')||(input.LA(1)>='\u04CB' && input.LA(1)<='\u04CC')||(input.LA(1)>='\u04D0' && input.LA(1)<='\u04F5')||(input.LA(1)>='\u04F8' && input.LA(1)<='\u04F9')||(input.LA(1)>='\u0531' && input.LA(1)<='\u0556')||input.LA(1)=='\u0559'||(input.LA(1)>='\u0561' && input.LA(1)<='\u0587')||(input.LA(1)>='\u05D0' && input.LA(1)<='\u05EA')||(input.LA(1)>='\u05F0' && input.LA(1)<='\u05F2')||(input.LA(1)>='\u0621' && input.LA(1)<='\u063A')||(input.LA(1)>='\u0640' && input.LA(1)<='\u064A')||(input.LA(1)>='\u0671' && input.LA(1)<='\u06D3')||input.LA(1)=='\u06D5'||(input.LA(1)>='\u06E5' && input.LA(1)<='\u06E6')||(input.LA(1)>='\u06FA' && input.LA(1)<='\u06FC')||input.LA(1)=='\u0710'||(input.LA(1)>='\u0712' && input.LA(1)<='\u072C')||(input.LA(1)>='\u0780' && input.LA(1)<='\u07A5')||(input.LA(1)>='\u0905' && input.LA(1)<='\u0939')||input.LA(1)=='\u093D'||input.LA(1)=='\u0950'||(input.LA(1)>='\u0958' && input.LA(1)<='\u0961')||(input.LA(1)>='\u0985' && input.LA(1)<='\u098C')||(input.LA(1)>='\u098F' && input.LA(1)<='\u0990')||(input.LA(1)>='\u0993' && input.LA(1)<='\u09A8')||(input.LA(1)>='\u09AA' && input.LA(1)<='\u09B0')||input.LA(1)=='\u09B2'||(input.LA(1)>='\u09B6' && input.LA(1)<='\u09B9')||(input.LA(1)>='\u09DC' && input.LA(1)<='\u09DD')||(input.LA(1)>='\u09DF' && input.LA(1)<='\u09E1')||(input.LA(1)>='\u09F0' && input.LA(1)<='\u09F1')||(input.LA(1)>='\u0A05' && input.LA(1)<='\u0A0A')||(input.LA(1)>='\u0A0F' && input.LA(1)<='\u0A10')||(input.LA(1)>='\u0A13' && input.LA(1)<='\u0A28')||(input.LA(1)>='\u0A2A' && input.LA(1)<='\u0A30')||(input.LA(1)>='\u0A32' && input.LA(1)<='\u0A33')||(input.LA(1)>='\u0A35' && input.LA(1)<='\u0A36')||(input.LA(1)>='\u0A38' && input.LA(1)<='\u0A39')||(input.LA(1)>='\u0A59' && input.LA(1)<='\u0A5C')||input.LA(1)=='\u0A5E'||(input.LA(1)>='\u0A72' && input.LA(1)<='\u0A74')||(input.LA(1)>='\u0A85' && input.LA(1)<='\u0A8B')||input.LA(1)=='\u0A8D'||(input.LA(1)>='\u0A8F' && input.LA(1)<='\u0A91')||(input.LA(1)>='\u0A93' && input.LA(1)<='\u0AA8')||(input.LA(1)>='\u0AAA' && input.LA(1)<='\u0AB0')||(input.LA(1)>='\u0AB2' && input.LA(1)<='\u0AB3')||(input.LA(1)>='\u0AB5' && input.LA(1)<='\u0AB9')||input.LA(1)=='\u0ABD'||input.LA(1)=='\u0AD0'||input.LA(1)=='\u0AE0'||(input.LA(1)>='\u0B05' && input.LA(1)<='\u0B0C')||(input.LA(1)>='\u0B0F' && input.LA(1)<='\u0B10')||(input.LA(1)>='\u0B13' && input.LA(1)<='\u0B28')||(input.LA(1)>='\u0B2A' && input.LA(1)<='\u0B30')||(input.LA(1)>='\u0B32' && input.LA(1)<='\u0B33')||(input.LA(1)>='\u0B36' && input.LA(1)<='\u0B39')||input.LA(1)=='\u0B3D'||(input.LA(1)>='\u0B5C' && input.LA(1)<='\u0B5D')||(input.LA(1)>='\u0B5F' && input.LA(1)<='\u0B61')||(input.LA(1)>='\u0B85' && input.LA(1)<='\u0B8A')||(input.LA(1)>='\u0B8E' && input.LA(1)<='\u0B90')||(input.LA(1)>='\u0B92' && input.LA(1)<='\u0B95')||(input.LA(1)>='\u0B99' && input.LA(1)<='\u0B9A')||input.LA(1)=='\u0B9C'||(input.LA(1)>='\u0B9E' && input.LA(1)<='\u0B9F')||(input.LA(1)>='\u0BA3' && input.LA(1)<='\u0BA4')||(input.LA(1)>='\u0BA8' && input.LA(1)<='\u0BAA')||(input.LA(1)>='\u0BAE' && input.LA(1)<='\u0BB5')||(input.LA(1)>='\u0BB7' && input.LA(1)<='\u0BB9')||(input.LA(1)>='\u0C05' && input.LA(1)<='\u0C0C')||(input.LA(1)>='\u0C0E' && input.LA(1)<='\u0C10')||(input.LA(1)>='\u0C12' && input.LA(1)<='\u0C28')||(input.LA(1)>='\u0C2A' && input.LA(1)<='\u0C33')||(input.LA(1)>='\u0C35' && input.LA(1)<='\u0C39')||(input.LA(1)>='\u0C60' && input.LA(1)<='\u0C61')||(input.LA(1)>='\u0C85' && input.LA(1)<='\u0C8C')||(input.LA(1)>='\u0C8E' && input.LA(1)<='\u0C90')||(input.LA(1)>='\u0C92' && input.LA(1)<='\u0CA8')||(input.LA(1)>='\u0CAA' && input.LA(1)<='\u0CB3')||(input.LA(1)>='\u0CB5' && input.LA(1)<='\u0CB9')||input.LA(1)=='\u0CDE'||(input.LA(1)>='\u0CE0' && input.LA(1)<='\u0CE1')||(input.LA(1)>='\u0D05' && input.LA(1)<='\u0D0C')||(input.LA(1)>='\u0D0E' && input.LA(1)<='\u0D10')||(input.LA(1)>='\u0D12' && input.LA(1)<='\u0D28')||(input.LA(1)>='\u0D2A' && input.LA(1)<='\u0D39')||(input.LA(1)>='\u0D60' && input.LA(1)<='\u0D61')||(input.LA(1)>='\u0D85' && input.LA(1)<='\u0D96')||(input.LA(1)>='\u0D9A' && input.LA(1)<='\u0DB1')||(input.LA(1)>='\u0DB3' && input.LA(1)<='\u0DBB')||input.LA(1)=='\u0DBD'||(input.LA(1)>='\u0DC0' && input.LA(1)<='\u0DC6')||(input.LA(1)>='\u0E01' && input.LA(1)<='\u0E30')||(input.LA(1)>='\u0E32' && input.LA(1)<='\u0E33')||(input.LA(1)>='\u0E40' && input.LA(1)<='\u0E46')||(input.LA(1)>='\u0E81' && input.LA(1)<='\u0E82')||input.LA(1)=='\u0E84'||(input.LA(1)>='\u0E87' && input.LA(1)<='\u0E88')||input.LA(1)=='\u0E8A'||input.LA(1)=='\u0E8D'||(input.LA(1)>='\u0E94' && input.LA(1)<='\u0E97')||(input.LA(1)>='\u0E99' && input.LA(1)<='\u0E9F')||(input.LA(1)>='\u0EA1' && input.LA(1)<='\u0EA3')||input.LA(1)=='\u0EA5'||input.LA(1)=='\u0EA7'||(input.LA(1)>='\u0EAA' && input.LA(1)<='\u0EAB')||(input.LA(1)>='\u0EAD' && input.LA(1)<='\u0EB0')||(input.LA(1)>='\u0EB2' && input.LA(1)<='\u0EB3')||(input.LA(1)>='\u0EBD' && input.LA(1)<='\u0EC4')||input.LA(1)=='\u0EC6'||(input.LA(1)>='\u0EDC' && input.LA(1)<='\u0EDD')||input.LA(1)=='\u0F00'||(input.LA(1)>='\u0F40' && input.LA(1)<='\u0F6A')||(input.LA(1)>='\u0F88' && input.LA(1)<='\u0F8B')||(input.LA(1)>='\u1000' && input.LA(1)<='\u1021')||(input.LA(1)>='\u1023' && input.LA(1)<='\u1027')||(input.LA(1)>='\u1029' && input.LA(1)<='\u102A')||(input.LA(1)>='\u1050' && input.LA(1)<='\u1055')||(input.LA(1)>='\u10A0' && input.LA(1)<='\u10C5')||(input.LA(1)>='\u10D0' && input.LA(1)<='\u10F6')||(input.LA(1)>='\u1100' && input.LA(1)<='\u1159')||(input.LA(1)>='\u115F' && input.LA(1)<='\u11A2')||(input.LA(1)>='\u11A8' && input.LA(1)<='\u11F9')||(input.LA(1)>='\u1200' && input.LA(1)<='\u1206')||(input.LA(1)>='\u1208' && input.LA(1)<='\u1246')||input.LA(1)=='\u1248'||(input.LA(1)>='\u124A' && input.LA(1)<='\u124D')||(input.LA(1)>='\u1250' && input.LA(1)<='\u1256')||input.LA(1)=='\u1258'||(input.LA(1)>='\u125A' && input.LA(1)<='\u125D')||(input.LA(1)>='\u1260' && input.LA(1)<='\u1286')||input.LA(1)=='\u1288'||(input.LA(1)>='\u128A' && input.LA(1)<='\u128D')||(input.LA(1)>='\u1290' && input.LA(1)<='\u12AE')||input.LA(1)=='\u12B0'||(input.LA(1)>='\u12B2' && input.LA(1)<='\u12B5')||(input.LA(1)>='\u12B8' && input.LA(1)<='\u12BE')||input.LA(1)=='\u12C0'||(input.LA(1)>='\u12C2' && input.LA(1)<='\u12C5')||(input.LA(1)>='\u12C8' && input.LA(1)<='\u12CE')||(input.LA(1)>='\u12D0' && input.LA(1)<='\u12D6')||(input.LA(1)>='\u12D8' && input.LA(1)<='\u12EE')||(input.LA(1)>='\u12F0' && input.LA(1)<='\u130E')||input.LA(1)=='\u1310'||(input.LA(1)>='\u1312' && input.LA(1)<='\u1315')||(input.LA(1)>='\u1318' && input.LA(1)<='\u131E')||(input.LA(1)>='\u1320' && input.LA(1)<='\u1346')||(input.LA(1)>='\u1348' && input.LA(1)<='\u135A')||(input.LA(1)>='\u13A0' && input.LA(1)<='\u13F4')||(input.LA(1)>='\u1401' && input.LA(1)<='\u1676')||(input.LA(1)>='\u1681' && input.LA(1)<='\u169A')||(input.LA(1)>='\u16A0' && input.LA(1)<='\u16EA')||(input.LA(1)>='\u1780' && input.LA(1)<='\u17B3')||(input.LA(1)>='\u1820' && input.LA(1)<='\u1877')||(input.LA(1)>='\u1880' && input.LA(1)<='\u18A8')||(input.LA(1)>='\u1E00' && input.LA(1)<='\u1E9B')||(input.LA(1)>='\u1EA0' && input.LA(1)<='\u1EF9')||(input.LA(1)>='\u1F00' && input.LA(1)<='\u1F15')||(input.LA(1)>='\u1F18' && input.LA(1)<='\u1F1D')||(input.LA(1)>='\u1F20' && input.LA(1)<='\u1F45')||(input.LA(1)>='\u1F48' && input.LA(1)<='\u1F4D')||(input.LA(1)>='\u1F50' && input.LA(1)<='\u1F57')||input.LA(1)=='\u1F59'||input.LA(1)=='\u1F5B'||input.LA(1)=='\u1F5D'||(input.LA(1)>='\u1F5F' && input.LA(1)<='\u1F7D')||(input.LA(1)>='\u1F80' && input.LA(1)<='\u1FB4')||(input.LA(1)>='\u1FB6' && input.LA(1)<='\u1FBC')||input.LA(1)=='\u1FBE'||(input.LA(1)>='\u1FC2' && input.LA(1)<='\u1FC4')||(input.LA(1)>='\u1FC6' && input.LA(1)<='\u1FCC')||(input.LA(1)>='\u1FD0' && input.LA(1)<='\u1FD3')||(input.LA(1)>='\u1FD6' && input.LA(1)<='\u1FDB')||(input.LA(1)>='\u1FE0' && input.LA(1)<='\u1FEC')||(input.LA(1)>='\u1FF2' && input.LA(1)<='\u1FF4')||(input.LA(1)>='\u1FF6' && input.LA(1)<='\u1FFC')||input.LA(1)=='\u207F'||input.LA(1)=='\u2102'||input.LA(1)=='\u2107'||(input.LA(1)>='\u210A' && input.LA(1)<='\u2113')||input.LA(1)=='\u2115'||(input.LA(1)>='\u2119' && input.LA(1)<='\u211D')||input.LA(1)=='\u2124'||input.LA(1)=='\u2126'||input.LA(1)=='\u2128'||(input.LA(1)>='\u212A' && input.LA(1)<='\u212D')||(input.LA(1)>='\u212F' && input.LA(1)<='\u2131')||(input.LA(1)>='\u2133' && input.LA(1)<='\u2139')||(input.LA(1)>='\u2160' && input.LA(1)<='\u2183')||(input.LA(1)>='\u3005' && input.LA(1)<='\u3007')||(input.LA(1)>='\u3021' && input.LA(1)<='\u3029')||(input.LA(1)>='\u3031' && input.LA(1)<='\u3035')||(input.LA(1)>='\u3038' && input.LA(1)<='\u303A')||(input.LA(1)>='\u3041' && input.LA(1)<='\u3094')||(input.LA(1)>='\u309D' && input.LA(1)<='\u309E')||(input.LA(1)>='\u30A1' && input.LA(1)<='\u30FA')||(input.LA(1)>='\u30FC' && input.LA(1)<='\u30FE')||(input.LA(1)>='\u3105' && input.LA(1)<='\u312C')||(input.LA(1)>='\u3131' && input.LA(1)<='\u318E')||(input.LA(1)>='\u31A0' && input.LA(1)<='\u31B7')||input.LA(1)=='\u3400'||input.LA(1)=='\u4DB5'||input.LA(1)=='\u4E00'||input.LA(1)=='\u9FA5'||(input.LA(1)>='\uA000' && input.LA(1)<='\uA48C')||input.LA(1)=='\uAC00'||input.LA(1)=='\uD7A3'||(input.LA(1)>='\uF900' && input.LA(1)<='\uFA2D')||(input.LA(1)>='\uFB00' && input.LA(1)<='\uFB06')||(input.LA(1)>='\uFB13' && input.LA(1)<='\uFB17')||input.LA(1)=='\uFB1D'||(input.LA(1)>='\uFB1F' && input.LA(1)<='\uFB28')||(input.LA(1)>='\uFB2A' && input.LA(1)<='\uFB36')||(input.LA(1)>='\uFB38' && input.LA(1)<='\uFB3C')||input.LA(1)=='\uFB3E'||(input.LA(1)>='\uFB40' && input.LA(1)<='\uFB41')||(input.LA(1)>='\uFB43' && input.LA(1)<='\uFB44')||(input.LA(1)>='\uFB46' && input.LA(1)<='\uFBB1')||(input.LA(1)>='\uFBD3' && input.LA(1)<='\uFD3D')||(input.LA(1)>='\uFD50' && input.LA(1)<='\uFD8F')||(input.LA(1)>='\uFD92' && input.LA(1)<='\uFDC7')||(input.LA(1)>='\uFDF0' && input.LA(1)<='\uFDFB')||(input.LA(1)>='\uFE70' && input.LA(1)<='\uFE72')||input.LA(1)=='\uFE74'||(input.LA(1)>='\uFE76' && input.LA(1)<='\uFEFC')||(input.LA(1)>='\uFF21' && input.LA(1)<='\uFF3A')||(input.LA(1)>='\uFF41' && input.LA(1)<='\uFF5A')||(input.LA(1)>='\uFF66' && input.LA(1)<='\uFFBE')||(input.LA(1)>='\uFFC2' && input.LA(1)<='\uFFC7')||(input.LA(1)>='\uFFCA' && input.LA(1)<='\uFFCF')||(input.LA(1)>='\uFFD2' && input.LA(1)<='\uFFD7')||(input.LA(1)>='\uFFDA' && input.LA(1)<='\uFFDC') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_LETTER"

    // $ANTLR start "UNICODE_DIGIT"
    public final void mUNICODE_DIGIT() throws RecognitionException {
        try {
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:345:2: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06F0' .. '\\u06F9' | '\\u0966' .. '\\u096F' | '\\u09E6' .. '\\u09EF' | '\\u0A66' .. '\\u0A6F' | '\\u0AE6' .. '\\u0AEF' | '\\u0B66' .. '\\u0B6F' | '\\u0BE7' .. '\\u0BEF' | '\\u0C66' .. '\\u0C6F' | '\\u0CE6' .. '\\u0CEF' | '\\u0D66' .. '\\u0D6F' | '\\u0E50' .. '\\u0E59' | '\\u0ED0' .. '\\u0ED9' | '\\u0F20' .. '\\u0F29' | '\\u1040' .. '\\u1049' | '\\u1369' .. '\\u1371' | '\\u17E0' .. '\\u17E9' | '\\u1810' .. '\\u1819' | '\\uFF10' .. '\\uFF19' )
            // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u0F20' && input.LA(1)<='\u0F29')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049')||(input.LA(1)>='\u1369' && input.LA(1)<='\u1371')||(input.LA(1)>='\u17E0' && input.LA(1)<='\u17E9')||(input.LA(1)>='\u1810' && input.LA(1)<='\u1819')||(input.LA(1)>='\uFF10' && input.LA(1)<='\uFF19') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_DIGIT"

    public void mTokens() throws RecognitionException {
        // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:1:8: ( GET | BY | AND | UNDERLINE | WS | NAME )
        int alt3=6;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:1:10: GET
                {
                mGET(); 

                }
                break;
            case 2 :
                // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:1:14: BY
                {
                mBY(); 

                }
                break;
            case 3 :
                // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:1:17: AND
                {
                mAND(); 

                }
                break;
            case 4 :
                // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:1:21: UNDERLINE
                {
                mUNDERLINE(); 

                }
                break;
            case 5 :
                // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:1:31: WS
                {
                mWS(); 

                }
                break;
            case 6 :
                // org/tommy/stationery/ink/api/parser/DYNAMIC_API_SQL.g:1:34: NAME
                {
                mNAME(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\1\uffff\3\6\1\12\2\uffff\1\6\1\14\1\6\1\uffff\1\16\1\uffff\1\17"+
        "\2\uffff";
    static final String DFA3_eofS =
        "\20\uffff";
    static final String DFA3_minS =
        "\1\11\1\145\1\171\1\156\1\60\2\uffff\1\164\1\60\1\144\1\uffff\1"+
        "\60\1\uffff\1\60\2\uffff";
    static final String DFA3_maxS =
        "\1\uffdc\1\145\1\171\1\156\1\uffdc\2\uffff\1\164\1\uffdc\1\144\1"+
        "\uffff\1\uffdc\1\uffff\1\uffdc\2\uffff";
    static final String DFA3_acceptS =
        "\5\uffff\1\5\1\6\3\uffff\1\4\1\uffff\1\2\1\uffff\1\1\1\3";
    static final String DFA3_specialS =
        "\20\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\5\1\uffff\2\5\22\uffff\1\5\17\uffff\12\6\7\uffff\1\3\1\2"+
            "\30\6\4\uffff\1\4\1\uffff\6\6\1\1\23\6\57\uffff\1\6\12\uffff"+
            "\1\6\4\uffff\1\6\5\uffff\27\6\1\uffff\37\6\1\uffff\u0128\6\2"+
            "\uffff\22\6\34\uffff\136\6\2\uffff\11\6\2\uffff\7\6\16\uffff"+
            "\2\6\16\uffff\5\6\11\uffff\1\6\u008b\uffff\1\6\13\uffff\1\6"+
            "\1\uffff\3\6\1\uffff\1\6\1\uffff\24\6\1\uffff\54\6\1\uffff\10"+
            "\6\2\uffff\32\6\14\uffff\u0082\6\12\uffff\71\6\2\uffff\2\6\2"+
            "\uffff\2\6\3\uffff\46\6\2\uffff\2\6\67\uffff\46\6\2\uffff\1"+
            "\6\7\uffff\47\6\110\uffff\33\6\5\uffff\3\6\56\uffff\32\6\5\uffff"+
            "\13\6\25\uffff\12\6\7\uffff\143\6\1\uffff\1\6\17\uffff\2\6\11"+
            "\uffff\15\6\23\uffff\1\6\1\uffff\33\6\123\uffff\46\6\u015f\uffff"+
            "\65\6\3\uffff\1\6\22\uffff\1\6\7\uffff\12\6\4\uffff\12\6\25"+
            "\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\1\6"+
            "\3\uffff\4\6\42\uffff\2\6\1\uffff\3\6\4\uffff\14\6\23\uffff"+
            "\6\6\4\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\2\6\1\uffff"+
            "\2\6\1\uffff\2\6\37\uffff\4\6\1\uffff\1\6\7\uffff\12\6\2\uffff"+
            "\3\6\20\uffff\7\6\1\uffff\1\6\1\uffff\3\6\1\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\1\uffff\5\6\3\uffff\1\6\22\uffff\1\6\17\uffff"+
            "\1\6\5\uffff\12\6\25\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\2\uffff\4\6\3\uffff\1\6\36\uffff\2\6\1\uffff"+
            "\3\6\4\uffff\12\6\25\uffff\6\6\3\uffff\3\6\1\uffff\4\6\3\uffff"+
            "\2\6\1\uffff\1\6\1\uffff\2\6\3\uffff\2\6\3\uffff\3\6\3\uffff"+
            "\10\6\1\uffff\3\6\55\uffff\11\6\25\uffff\10\6\1\uffff\3\6\1"+
            "\uffff\27\6\1\uffff\12\6\1\uffff\5\6\46\uffff\2\6\4\uffff\12"+
            "\6\25\uffff\10\6\1\uffff\3\6\1\uffff\27\6\1\uffff\12\6\1\uffff"+
            "\5\6\44\uffff\1\6\1\uffff\2\6\4\uffff\12\6\25\uffff\10\6\1\uffff"+
            "\3\6\1\uffff\27\6\1\uffff\20\6\46\uffff\2\6\4\uffff\12\6\25"+
            "\uffff\22\6\3\uffff\30\6\1\uffff\11\6\1\uffff\1\6\2\uffff\7"+
            "\6\72\uffff\60\6\1\uffff\2\6\14\uffff\7\6\11\uffff\12\6\47\uffff"+
            "\2\6\1\uffff\1\6\2\uffff\2\6\1\uffff\1\6\2\uffff\1\6\6\uffff"+
            "\4\6\1\uffff\7\6\1\uffff\3\6\1\uffff\1\6\1\uffff\1\6\2\uffff"+
            "\2\6\1\uffff\4\6\1\uffff\2\6\11\uffff\10\6\1\uffff\1\6\11\uffff"+
            "\12\6\2\uffff\2\6\42\uffff\1\6\37\uffff\12\6\26\uffff\53\6\35"+
            "\uffff\4\6\164\uffff\42\6\1\uffff\5\6\1\uffff\2\6\25\uffff\12"+
            "\6\6\uffff\6\6\112\uffff\46\6\12\uffff\47\6\11\uffff\132\6\5"+
            "\uffff\104\6\5\uffff\122\6\6\uffff\7\6\1\uffff\77\6\1\uffff"+
            "\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\47\6\1\uffff\1\6\1\uffff\4\6\2\uffff\37\6\1\uffff\1\6\1\uffff"+
            "\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff"+
            "\7\6\1\uffff\27\6\1\uffff\37\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\7\6\1\uffff\47\6\1\uffff\23\6\16\uffff\11\6\56\uffff\125\6"+
            "\14\uffff\u0276\6\12\uffff\32\6\5\uffff\113\6\u0095\uffff\64"+
            "\6\54\uffff\12\6\46\uffff\12\6\6\uffff\130\6\10\uffff\51\6\u0557"+
            "\uffff\u009c\6\4\uffff\132\6\6\uffff\26\6\2\uffff\6\6\2\uffff"+
            "\46\6\2\uffff\6\6\2\uffff\10\6\1\uffff\1\6\1\uffff\1\6\1\uffff"+
            "\1\6\1\uffff\37\6\2\uffff\65\6\1\uffff\7\6\1\uffff\1\6\3\uffff"+
            "\3\6\1\uffff\7\6\3\uffff\4\6\2\uffff\6\6\4\uffff\15\6\5\uffff"+
            "\3\6\1\uffff\7\6\u0082\uffff\1\6\u0082\uffff\1\6\4\uffff\1\6"+
            "\2\uffff\12\6\1\uffff\1\6\3\uffff\5\6\6\uffff\1\6\1\uffff\1"+
            "\6\1\uffff\1\6\1\uffff\4\6\1\uffff\3\6\1\uffff\7\6\46\uffff"+
            "\44\6\u0e81\uffff\3\6\31\uffff\11\6\7\uffff\5\6\2\uffff\3\6"+
            "\6\uffff\124\6\10\uffff\2\6\2\uffff\132\6\1\uffff\3\6\6\uffff"+
            "\50\6\4\uffff\136\6\21\uffff\30\6\u0248\uffff\1\6\u19b4\uffff"+
            "\1\6\112\uffff\1\6\u51a4\uffff\1\6\132\uffff\u048d\6\u0773\uffff"+
            "\1\6\u2ba2\uffff\1\6\u215c\uffff\u012e\6\u00d2\uffff\7\6\14"+
            "\uffff\5\6\5\uffff\1\6\1\uffff\12\6\1\uffff\15\6\1\uffff\5\6"+
            "\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\154\6\41\uffff"+
            "\u016b\6\22\uffff\100\6\2\uffff\66\6\50\uffff\14\6\164\uffff"+
            "\3\6\1\uffff\1\6\1\uffff\u0087\6\23\uffff\12\6\7\uffff\32\6"+
            "\6\uffff\32\6\13\uffff\131\6\3\uffff\6\6\2\uffff\6\6\2\uffff"+
            "\6\6\2\uffff\3\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\12\6\7\uffff\32\6\4\uffff\1\6\1\uffff\32\6\57\uffff\1\6\12"+
            "\uffff\1\6\4\uffff\1\6\5\uffff\27\6\1\uffff\37\6\1\uffff\u0128"+
            "\6\2\uffff\22\6\34\uffff\136\6\2\uffff\11\6\2\uffff\7\6\16\uffff"+
            "\2\6\16\uffff\5\6\11\uffff\1\6\u008b\uffff\1\6\13\uffff\1\6"+
            "\1\uffff\3\6\1\uffff\1\6\1\uffff\24\6\1\uffff\54\6\1\uffff\10"+
            "\6\2\uffff\32\6\14\uffff\u0082\6\12\uffff\71\6\2\uffff\2\6\2"+
            "\uffff\2\6\3\uffff\46\6\2\uffff\2\6\67\uffff\46\6\2\uffff\1"+
            "\6\7\uffff\47\6\110\uffff\33\6\5\uffff\3\6\56\uffff\32\6\5\uffff"+
            "\13\6\25\uffff\12\6\7\uffff\143\6\1\uffff\1\6\17\uffff\2\6\11"+
            "\uffff\15\6\23\uffff\1\6\1\uffff\33\6\123\uffff\46\6\u015f\uffff"+
            "\65\6\3\uffff\1\6\22\uffff\1\6\7\uffff\12\6\4\uffff\12\6\25"+
            "\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\1\6"+
            "\3\uffff\4\6\42\uffff\2\6\1\uffff\3\6\4\uffff\14\6\23\uffff"+
            "\6\6\4\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\2\6\1\uffff"+
            "\2\6\1\uffff\2\6\37\uffff\4\6\1\uffff\1\6\7\uffff\12\6\2\uffff"+
            "\3\6\20\uffff\7\6\1\uffff\1\6\1\uffff\3\6\1\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\1\uffff\5\6\3\uffff\1\6\22\uffff\1\6\17\uffff"+
            "\1\6\5\uffff\12\6\25\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\2\uffff\4\6\3\uffff\1\6\36\uffff\2\6\1\uffff"+
            "\3\6\4\uffff\12\6\25\uffff\6\6\3\uffff\3\6\1\uffff\4\6\3\uffff"+
            "\2\6\1\uffff\1\6\1\uffff\2\6\3\uffff\2\6\3\uffff\3\6\3\uffff"+
            "\10\6\1\uffff\3\6\55\uffff\11\6\25\uffff\10\6\1\uffff\3\6\1"+
            "\uffff\27\6\1\uffff\12\6\1\uffff\5\6\46\uffff\2\6\4\uffff\12"+
            "\6\25\uffff\10\6\1\uffff\3\6\1\uffff\27\6\1\uffff\12\6\1\uffff"+
            "\5\6\44\uffff\1\6\1\uffff\2\6\4\uffff\12\6\25\uffff\10\6\1\uffff"+
            "\3\6\1\uffff\27\6\1\uffff\20\6\46\uffff\2\6\4\uffff\12\6\25"+
            "\uffff\22\6\3\uffff\30\6\1\uffff\11\6\1\uffff\1\6\2\uffff\7"+
            "\6\72\uffff\60\6\1\uffff\2\6\14\uffff\7\6\11\uffff\12\6\47\uffff"+
            "\2\6\1\uffff\1\6\2\uffff\2\6\1\uffff\1\6\2\uffff\1\6\6\uffff"+
            "\4\6\1\uffff\7\6\1\uffff\3\6\1\uffff\1\6\1\uffff\1\6\2\uffff"+
            "\2\6\1\uffff\4\6\1\uffff\2\6\11\uffff\10\6\1\uffff\1\6\11\uffff"+
            "\12\6\2\uffff\2\6\42\uffff\1\6\37\uffff\12\6\26\uffff\53\6\35"+
            "\uffff\4\6\164\uffff\42\6\1\uffff\5\6\1\uffff\2\6\25\uffff\12"+
            "\6\6\uffff\6\6\112\uffff\46\6\12\uffff\47\6\11\uffff\132\6\5"+
            "\uffff\104\6\5\uffff\122\6\6\uffff\7\6\1\uffff\77\6\1\uffff"+
            "\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\47\6\1\uffff\1\6\1\uffff\4\6\2\uffff\37\6\1\uffff\1\6\1\uffff"+
            "\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff"+
            "\7\6\1\uffff\27\6\1\uffff\37\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\7\6\1\uffff\47\6\1\uffff\23\6\16\uffff\11\6\56\uffff\125\6"+
            "\14\uffff\u0276\6\12\uffff\32\6\5\uffff\113\6\u0095\uffff\64"+
            "\6\54\uffff\12\6\46\uffff\12\6\6\uffff\130\6\10\uffff\51\6\u0557"+
            "\uffff\u009c\6\4\uffff\132\6\6\uffff\26\6\2\uffff\6\6\2\uffff"+
            "\46\6\2\uffff\6\6\2\uffff\10\6\1\uffff\1\6\1\uffff\1\6\1\uffff"+
            "\1\6\1\uffff\37\6\2\uffff\65\6\1\uffff\7\6\1\uffff\1\6\3\uffff"+
            "\3\6\1\uffff\7\6\3\uffff\4\6\2\uffff\6\6\4\uffff\15\6\5\uffff"+
            "\3\6\1\uffff\7\6\u0082\uffff\1\6\u0082\uffff\1\6\4\uffff\1\6"+
            "\2\uffff\12\6\1\uffff\1\6\3\uffff\5\6\6\uffff\1\6\1\uffff\1"+
            "\6\1\uffff\1\6\1\uffff\4\6\1\uffff\3\6\1\uffff\7\6\46\uffff"+
            "\44\6\u0e81\uffff\3\6\31\uffff\11\6\7\uffff\5\6\2\uffff\3\6"+
            "\6\uffff\124\6\10\uffff\2\6\2\uffff\132\6\1\uffff\3\6\6\uffff"+
            "\50\6\4\uffff\136\6\21\uffff\30\6\u0248\uffff\1\6\u19b4\uffff"+
            "\1\6\112\uffff\1\6\u51a4\uffff\1\6\132\uffff\u048d\6\u0773\uffff"+
            "\1\6\u2ba2\uffff\1\6\u215c\uffff\u012e\6\u00d2\uffff\7\6\14"+
            "\uffff\5\6\5\uffff\1\6\1\uffff\12\6\1\uffff\15\6\1\uffff\5\6"+
            "\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\154\6\41\uffff"+
            "\u016b\6\22\uffff\100\6\2\uffff\66\6\50\uffff\14\6\164\uffff"+
            "\3\6\1\uffff\1\6\1\uffff\u0087\6\23\uffff\12\6\7\uffff\32\6"+
            "\6\uffff\32\6\13\uffff\131\6\3\uffff\6\6\2\uffff\6\6\2\uffff"+
            "\6\6\2\uffff\3\6",
            "",
            "",
            "\1\13",
            "\12\6\7\uffff\32\6\4\uffff\1\6\1\uffff\32\6\57\uffff\1\6\12"+
            "\uffff\1\6\4\uffff\1\6\5\uffff\27\6\1\uffff\37\6\1\uffff\u0128"+
            "\6\2\uffff\22\6\34\uffff\136\6\2\uffff\11\6\2\uffff\7\6\16\uffff"+
            "\2\6\16\uffff\5\6\11\uffff\1\6\u008b\uffff\1\6\13\uffff\1\6"+
            "\1\uffff\3\6\1\uffff\1\6\1\uffff\24\6\1\uffff\54\6\1\uffff\10"+
            "\6\2\uffff\32\6\14\uffff\u0082\6\12\uffff\71\6\2\uffff\2\6\2"+
            "\uffff\2\6\3\uffff\46\6\2\uffff\2\6\67\uffff\46\6\2\uffff\1"+
            "\6\7\uffff\47\6\110\uffff\33\6\5\uffff\3\6\56\uffff\32\6\5\uffff"+
            "\13\6\25\uffff\12\6\7\uffff\143\6\1\uffff\1\6\17\uffff\2\6\11"+
            "\uffff\15\6\23\uffff\1\6\1\uffff\33\6\123\uffff\46\6\u015f\uffff"+
            "\65\6\3\uffff\1\6\22\uffff\1\6\7\uffff\12\6\4\uffff\12\6\25"+
            "\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\1\6"+
            "\3\uffff\4\6\42\uffff\2\6\1\uffff\3\6\4\uffff\14\6\23\uffff"+
            "\6\6\4\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\2\6\1\uffff"+
            "\2\6\1\uffff\2\6\37\uffff\4\6\1\uffff\1\6\7\uffff\12\6\2\uffff"+
            "\3\6\20\uffff\7\6\1\uffff\1\6\1\uffff\3\6\1\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\1\uffff\5\6\3\uffff\1\6\22\uffff\1\6\17\uffff"+
            "\1\6\5\uffff\12\6\25\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\2\uffff\4\6\3\uffff\1\6\36\uffff\2\6\1\uffff"+
            "\3\6\4\uffff\12\6\25\uffff\6\6\3\uffff\3\6\1\uffff\4\6\3\uffff"+
            "\2\6\1\uffff\1\6\1\uffff\2\6\3\uffff\2\6\3\uffff\3\6\3\uffff"+
            "\10\6\1\uffff\3\6\55\uffff\11\6\25\uffff\10\6\1\uffff\3\6\1"+
            "\uffff\27\6\1\uffff\12\6\1\uffff\5\6\46\uffff\2\6\4\uffff\12"+
            "\6\25\uffff\10\6\1\uffff\3\6\1\uffff\27\6\1\uffff\12\6\1\uffff"+
            "\5\6\44\uffff\1\6\1\uffff\2\6\4\uffff\12\6\25\uffff\10\6\1\uffff"+
            "\3\6\1\uffff\27\6\1\uffff\20\6\46\uffff\2\6\4\uffff\12\6\25"+
            "\uffff\22\6\3\uffff\30\6\1\uffff\11\6\1\uffff\1\6\2\uffff\7"+
            "\6\72\uffff\60\6\1\uffff\2\6\14\uffff\7\6\11\uffff\12\6\47\uffff"+
            "\2\6\1\uffff\1\6\2\uffff\2\6\1\uffff\1\6\2\uffff\1\6\6\uffff"+
            "\4\6\1\uffff\7\6\1\uffff\3\6\1\uffff\1\6\1\uffff\1\6\2\uffff"+
            "\2\6\1\uffff\4\6\1\uffff\2\6\11\uffff\10\6\1\uffff\1\6\11\uffff"+
            "\12\6\2\uffff\2\6\42\uffff\1\6\37\uffff\12\6\26\uffff\53\6\35"+
            "\uffff\4\6\164\uffff\42\6\1\uffff\5\6\1\uffff\2\6\25\uffff\12"+
            "\6\6\uffff\6\6\112\uffff\46\6\12\uffff\47\6\11\uffff\132\6\5"+
            "\uffff\104\6\5\uffff\122\6\6\uffff\7\6\1\uffff\77\6\1\uffff"+
            "\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\47\6\1\uffff\1\6\1\uffff\4\6\2\uffff\37\6\1\uffff\1\6\1\uffff"+
            "\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff"+
            "\7\6\1\uffff\27\6\1\uffff\37\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\7\6\1\uffff\47\6\1\uffff\23\6\16\uffff\11\6\56\uffff\125\6"+
            "\14\uffff\u0276\6\12\uffff\32\6\5\uffff\113\6\u0095\uffff\64"+
            "\6\54\uffff\12\6\46\uffff\12\6\6\uffff\130\6\10\uffff\51\6\u0557"+
            "\uffff\u009c\6\4\uffff\132\6\6\uffff\26\6\2\uffff\6\6\2\uffff"+
            "\46\6\2\uffff\6\6\2\uffff\10\6\1\uffff\1\6\1\uffff\1\6\1\uffff"+
            "\1\6\1\uffff\37\6\2\uffff\65\6\1\uffff\7\6\1\uffff\1\6\3\uffff"+
            "\3\6\1\uffff\7\6\3\uffff\4\6\2\uffff\6\6\4\uffff\15\6\5\uffff"+
            "\3\6\1\uffff\7\6\u0082\uffff\1\6\u0082\uffff\1\6\4\uffff\1\6"+
            "\2\uffff\12\6\1\uffff\1\6\3\uffff\5\6\6\uffff\1\6\1\uffff\1"+
            "\6\1\uffff\1\6\1\uffff\4\6\1\uffff\3\6\1\uffff\7\6\46\uffff"+
            "\44\6\u0e81\uffff\3\6\31\uffff\11\6\7\uffff\5\6\2\uffff\3\6"+
            "\6\uffff\124\6\10\uffff\2\6\2\uffff\132\6\1\uffff\3\6\6\uffff"+
            "\50\6\4\uffff\136\6\21\uffff\30\6\u0248\uffff\1\6\u19b4\uffff"+
            "\1\6\112\uffff\1\6\u51a4\uffff\1\6\132\uffff\u048d\6\u0773\uffff"+
            "\1\6\u2ba2\uffff\1\6\u215c\uffff\u012e\6\u00d2\uffff\7\6\14"+
            "\uffff\5\6\5\uffff\1\6\1\uffff\12\6\1\uffff\15\6\1\uffff\5\6"+
            "\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\154\6\41\uffff"+
            "\u016b\6\22\uffff\100\6\2\uffff\66\6\50\uffff\14\6\164\uffff"+
            "\3\6\1\uffff\1\6\1\uffff\u0087\6\23\uffff\12\6\7\uffff\32\6"+
            "\6\uffff\32\6\13\uffff\131\6\3\uffff\6\6\2\uffff\6\6\2\uffff"+
            "\6\6\2\uffff\3\6",
            "\1\15",
            "",
            "\12\6\7\uffff\32\6\4\uffff\1\6\1\uffff\32\6\57\uffff\1\6\12"+
            "\uffff\1\6\4\uffff\1\6\5\uffff\27\6\1\uffff\37\6\1\uffff\u0128"+
            "\6\2\uffff\22\6\34\uffff\136\6\2\uffff\11\6\2\uffff\7\6\16\uffff"+
            "\2\6\16\uffff\5\6\11\uffff\1\6\u008b\uffff\1\6\13\uffff\1\6"+
            "\1\uffff\3\6\1\uffff\1\6\1\uffff\24\6\1\uffff\54\6\1\uffff\10"+
            "\6\2\uffff\32\6\14\uffff\u0082\6\12\uffff\71\6\2\uffff\2\6\2"+
            "\uffff\2\6\3\uffff\46\6\2\uffff\2\6\67\uffff\46\6\2\uffff\1"+
            "\6\7\uffff\47\6\110\uffff\33\6\5\uffff\3\6\56\uffff\32\6\5\uffff"+
            "\13\6\25\uffff\12\6\7\uffff\143\6\1\uffff\1\6\17\uffff\2\6\11"+
            "\uffff\15\6\23\uffff\1\6\1\uffff\33\6\123\uffff\46\6\u015f\uffff"+
            "\65\6\3\uffff\1\6\22\uffff\1\6\7\uffff\12\6\4\uffff\12\6\25"+
            "\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\1\6"+
            "\3\uffff\4\6\42\uffff\2\6\1\uffff\3\6\4\uffff\14\6\23\uffff"+
            "\6\6\4\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\2\6\1\uffff"+
            "\2\6\1\uffff\2\6\37\uffff\4\6\1\uffff\1\6\7\uffff\12\6\2\uffff"+
            "\3\6\20\uffff\7\6\1\uffff\1\6\1\uffff\3\6\1\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\1\uffff\5\6\3\uffff\1\6\22\uffff\1\6\17\uffff"+
            "\1\6\5\uffff\12\6\25\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\2\uffff\4\6\3\uffff\1\6\36\uffff\2\6\1\uffff"+
            "\3\6\4\uffff\12\6\25\uffff\6\6\3\uffff\3\6\1\uffff\4\6\3\uffff"+
            "\2\6\1\uffff\1\6\1\uffff\2\6\3\uffff\2\6\3\uffff\3\6\3\uffff"+
            "\10\6\1\uffff\3\6\55\uffff\11\6\25\uffff\10\6\1\uffff\3\6\1"+
            "\uffff\27\6\1\uffff\12\6\1\uffff\5\6\46\uffff\2\6\4\uffff\12"+
            "\6\25\uffff\10\6\1\uffff\3\6\1\uffff\27\6\1\uffff\12\6\1\uffff"+
            "\5\6\44\uffff\1\6\1\uffff\2\6\4\uffff\12\6\25\uffff\10\6\1\uffff"+
            "\3\6\1\uffff\27\6\1\uffff\20\6\46\uffff\2\6\4\uffff\12\6\25"+
            "\uffff\22\6\3\uffff\30\6\1\uffff\11\6\1\uffff\1\6\2\uffff\7"+
            "\6\72\uffff\60\6\1\uffff\2\6\14\uffff\7\6\11\uffff\12\6\47\uffff"+
            "\2\6\1\uffff\1\6\2\uffff\2\6\1\uffff\1\6\2\uffff\1\6\6\uffff"+
            "\4\6\1\uffff\7\6\1\uffff\3\6\1\uffff\1\6\1\uffff\1\6\2\uffff"+
            "\2\6\1\uffff\4\6\1\uffff\2\6\11\uffff\10\6\1\uffff\1\6\11\uffff"+
            "\12\6\2\uffff\2\6\42\uffff\1\6\37\uffff\12\6\26\uffff\53\6\35"+
            "\uffff\4\6\164\uffff\42\6\1\uffff\5\6\1\uffff\2\6\25\uffff\12"+
            "\6\6\uffff\6\6\112\uffff\46\6\12\uffff\47\6\11\uffff\132\6\5"+
            "\uffff\104\6\5\uffff\122\6\6\uffff\7\6\1\uffff\77\6\1\uffff"+
            "\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\47\6\1\uffff\1\6\1\uffff\4\6\2\uffff\37\6\1\uffff\1\6\1\uffff"+
            "\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff"+
            "\7\6\1\uffff\27\6\1\uffff\37\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\7\6\1\uffff\47\6\1\uffff\23\6\16\uffff\11\6\56\uffff\125\6"+
            "\14\uffff\u0276\6\12\uffff\32\6\5\uffff\113\6\u0095\uffff\64"+
            "\6\54\uffff\12\6\46\uffff\12\6\6\uffff\130\6\10\uffff\51\6\u0557"+
            "\uffff\u009c\6\4\uffff\132\6\6\uffff\26\6\2\uffff\6\6\2\uffff"+
            "\46\6\2\uffff\6\6\2\uffff\10\6\1\uffff\1\6\1\uffff\1\6\1\uffff"+
            "\1\6\1\uffff\37\6\2\uffff\65\6\1\uffff\7\6\1\uffff\1\6\3\uffff"+
            "\3\6\1\uffff\7\6\3\uffff\4\6\2\uffff\6\6\4\uffff\15\6\5\uffff"+
            "\3\6\1\uffff\7\6\u0082\uffff\1\6\u0082\uffff\1\6\4\uffff\1\6"+
            "\2\uffff\12\6\1\uffff\1\6\3\uffff\5\6\6\uffff\1\6\1\uffff\1"+
            "\6\1\uffff\1\6\1\uffff\4\6\1\uffff\3\6\1\uffff\7\6\46\uffff"+
            "\44\6\u0e81\uffff\3\6\31\uffff\11\6\7\uffff\5\6\2\uffff\3\6"+
            "\6\uffff\124\6\10\uffff\2\6\2\uffff\132\6\1\uffff\3\6\6\uffff"+
            "\50\6\4\uffff\136\6\21\uffff\30\6\u0248\uffff\1\6\u19b4\uffff"+
            "\1\6\112\uffff\1\6\u51a4\uffff\1\6\132\uffff\u048d\6\u0773\uffff"+
            "\1\6\u2ba2\uffff\1\6\u215c\uffff\u012e\6\u00d2\uffff\7\6\14"+
            "\uffff\5\6\5\uffff\1\6\1\uffff\12\6\1\uffff\15\6\1\uffff\5\6"+
            "\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\154\6\41\uffff"+
            "\u016b\6\22\uffff\100\6\2\uffff\66\6\50\uffff\14\6\164\uffff"+
            "\3\6\1\uffff\1\6\1\uffff\u0087\6\23\uffff\12\6\7\uffff\32\6"+
            "\6\uffff\32\6\13\uffff\131\6\3\uffff\6\6\2\uffff\6\6\2\uffff"+
            "\6\6\2\uffff\3\6",
            "",
            "\12\6\7\uffff\32\6\4\uffff\1\6\1\uffff\32\6\57\uffff\1\6\12"+
            "\uffff\1\6\4\uffff\1\6\5\uffff\27\6\1\uffff\37\6\1\uffff\u0128"+
            "\6\2\uffff\22\6\34\uffff\136\6\2\uffff\11\6\2\uffff\7\6\16\uffff"+
            "\2\6\16\uffff\5\6\11\uffff\1\6\u008b\uffff\1\6\13\uffff\1\6"+
            "\1\uffff\3\6\1\uffff\1\6\1\uffff\24\6\1\uffff\54\6\1\uffff\10"+
            "\6\2\uffff\32\6\14\uffff\u0082\6\12\uffff\71\6\2\uffff\2\6\2"+
            "\uffff\2\6\3\uffff\46\6\2\uffff\2\6\67\uffff\46\6\2\uffff\1"+
            "\6\7\uffff\47\6\110\uffff\33\6\5\uffff\3\6\56\uffff\32\6\5\uffff"+
            "\13\6\25\uffff\12\6\7\uffff\143\6\1\uffff\1\6\17\uffff\2\6\11"+
            "\uffff\15\6\23\uffff\1\6\1\uffff\33\6\123\uffff\46\6\u015f\uffff"+
            "\65\6\3\uffff\1\6\22\uffff\1\6\7\uffff\12\6\4\uffff\12\6\25"+
            "\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\1\6"+
            "\3\uffff\4\6\42\uffff\2\6\1\uffff\3\6\4\uffff\14\6\23\uffff"+
            "\6\6\4\uffff\2\6\2\uffff\26\6\1\uffff\7\6\1\uffff\2\6\1\uffff"+
            "\2\6\1\uffff\2\6\37\uffff\4\6\1\uffff\1\6\7\uffff\12\6\2\uffff"+
            "\3\6\20\uffff\7\6\1\uffff\1\6\1\uffff\3\6\1\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\1\uffff\5\6\3\uffff\1\6\22\uffff\1\6\17\uffff"+
            "\1\6\5\uffff\12\6\25\uffff\10\6\2\uffff\2\6\2\uffff\26\6\1\uffff"+
            "\7\6\1\uffff\2\6\2\uffff\4\6\3\uffff\1\6\36\uffff\2\6\1\uffff"+
            "\3\6\4\uffff\12\6\25\uffff\6\6\3\uffff\3\6\1\uffff\4\6\3\uffff"+
            "\2\6\1\uffff\1\6\1\uffff\2\6\3\uffff\2\6\3\uffff\3\6\3\uffff"+
            "\10\6\1\uffff\3\6\55\uffff\11\6\25\uffff\10\6\1\uffff\3\6\1"+
            "\uffff\27\6\1\uffff\12\6\1\uffff\5\6\46\uffff\2\6\4\uffff\12"+
            "\6\25\uffff\10\6\1\uffff\3\6\1\uffff\27\6\1\uffff\12\6\1\uffff"+
            "\5\6\44\uffff\1\6\1\uffff\2\6\4\uffff\12\6\25\uffff\10\6\1\uffff"+
            "\3\6\1\uffff\27\6\1\uffff\20\6\46\uffff\2\6\4\uffff\12\6\25"+
            "\uffff\22\6\3\uffff\30\6\1\uffff\11\6\1\uffff\1\6\2\uffff\7"+
            "\6\72\uffff\60\6\1\uffff\2\6\14\uffff\7\6\11\uffff\12\6\47\uffff"+
            "\2\6\1\uffff\1\6\2\uffff\2\6\1\uffff\1\6\2\uffff\1\6\6\uffff"+
            "\4\6\1\uffff\7\6\1\uffff\3\6\1\uffff\1\6\1\uffff\1\6\2\uffff"+
            "\2\6\1\uffff\4\6\1\uffff\2\6\11\uffff\10\6\1\uffff\1\6\11\uffff"+
            "\12\6\2\uffff\2\6\42\uffff\1\6\37\uffff\12\6\26\uffff\53\6\35"+
            "\uffff\4\6\164\uffff\42\6\1\uffff\5\6\1\uffff\2\6\25\uffff\12"+
            "\6\6\uffff\6\6\112\uffff\46\6\12\uffff\47\6\11\uffff\132\6\5"+
            "\uffff\104\6\5\uffff\122\6\6\uffff\7\6\1\uffff\77\6\1\uffff"+
            "\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\47\6\1\uffff\1\6\1\uffff\4\6\2\uffff\37\6\1\uffff\1\6\1\uffff"+
            "\4\6\2\uffff\7\6\1\uffff\1\6\1\uffff\4\6\2\uffff\7\6\1\uffff"+
            "\7\6\1\uffff\27\6\1\uffff\37\6\1\uffff\1\6\1\uffff\4\6\2\uffff"+
            "\7\6\1\uffff\47\6\1\uffff\23\6\16\uffff\11\6\56\uffff\125\6"+
            "\14\uffff\u0276\6\12\uffff\32\6\5\uffff\113\6\u0095\uffff\64"+
            "\6\54\uffff\12\6\46\uffff\12\6\6\uffff\130\6\10\uffff\51\6\u0557"+
            "\uffff\u009c\6\4\uffff\132\6\6\uffff\26\6\2\uffff\6\6\2\uffff"+
            "\46\6\2\uffff\6\6\2\uffff\10\6\1\uffff\1\6\1\uffff\1\6\1\uffff"+
            "\1\6\1\uffff\37\6\2\uffff\65\6\1\uffff\7\6\1\uffff\1\6\3\uffff"+
            "\3\6\1\uffff\7\6\3\uffff\4\6\2\uffff\6\6\4\uffff\15\6\5\uffff"+
            "\3\6\1\uffff\7\6\u0082\uffff\1\6\u0082\uffff\1\6\4\uffff\1\6"+
            "\2\uffff\12\6\1\uffff\1\6\3\uffff\5\6\6\uffff\1\6\1\uffff\1"+
            "\6\1\uffff\1\6\1\uffff\4\6\1\uffff\3\6\1\uffff\7\6\46\uffff"+
            "\44\6\u0e81\uffff\3\6\31\uffff\11\6\7\uffff\5\6\2\uffff\3\6"+
            "\6\uffff\124\6\10\uffff\2\6\2\uffff\132\6\1\uffff\3\6\6\uffff"+
            "\50\6\4\uffff\136\6\21\uffff\30\6\u0248\uffff\1\6\u19b4\uffff"+
            "\1\6\112\uffff\1\6\u51a4\uffff\1\6\132\uffff\u048d\6\u0773\uffff"+
            "\1\6\u2ba2\uffff\1\6\u215c\uffff\u012e\6\u00d2\uffff\7\6\14"+
            "\uffff\5\6\5\uffff\1\6\1\uffff\12\6\1\uffff\15\6\1\uffff\5\6"+
            "\1\uffff\1\6\1\uffff\2\6\1\uffff\2\6\1\uffff\154\6\41\uffff"+
            "\u016b\6\22\uffff\100\6\2\uffff\66\6\50\uffff\14\6\164\uffff"+
            "\3\6\1\uffff\1\6\1\uffff\u0087\6\23\uffff\12\6\7\uffff\32\6"+
            "\6\uffff\32\6\13\uffff\131\6\3\uffff\6\6\2\uffff\6\6\2\uffff"+
            "\6\6\2\uffff\3\6",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( GET | BY | AND | UNDERLINE | WS | NAME );";
        }
    }
 

}