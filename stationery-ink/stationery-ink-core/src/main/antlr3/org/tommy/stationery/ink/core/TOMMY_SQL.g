grammar TOMMY_SQL;

options {
    language = Java;
    output = AST;
    backtrack=true;
}

tokens
{
    PLUGINS='plugins';
    REST='rest';
    SYSTEM='system';
    DELETE='delete';
    SELECT='select';
    FROM='from';
    WHERE='where';
    LOOKUP='lookup';
    INSERT='insert';
    UPSERT='upsert';
    CREATE='create';
    STREAM='stream';
    STREAMS='streams';
    BSTREAM='STREAM';
    BUCKET='bucket';
    SOURCE='source';
    SOURCES='sources';
    DROP='drop';
    SHOW='show';
    JOB='job';
    LPAREN='(';
    RPAREN=')';
    LSQUARE='[';
    RSQUARE=']';
    LCURLY='{';
    RCURLY='}';
    LBLE='>';
    RBLE='<';
    QUESTION='?';
    EXCLAMATION='!';
    SINGLE_QUOTE='\'';
    DOUBLE_QUOTE='"';
    UNDERLINE='_';
    SEMICOLON=';';
    COMMA=',';
    COMM='.';
    COLON=':';
    META='meta';
    AND='and';
    OR='or';
    PLUS='+';
    MINUS='-';
    MULTI='*';
    DIV='/';
    MOD='%';
    ANDMARK='&';
    EQUAL='=';
    INCREASE='increase';
    VALUES='values';
    INTO='into';
    UPDATE='update';
    SET='set';
    CLUSTER='cluster';
    JOBS='jobs';
    KILL='kill';
    SNAPSHOT='snapshot';
    USE='use';
    COMMIT='commit';
}

@parser::header {
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
}

@lexer::header {
    package org.tommy.stationery.ink.core;
}

@parser::members {
    private List<BaseStatement> statements = new ArrayList<BaseStatement>();

    public List<BaseStatement> getStatements() {
        return this.statements;
    }
}

@lexer::members {

}


create_statement
    : (rest_statement|show_system_statement|commit_statement|use_statement|snapshot_job_statement|kill_job_statement|set_statement|show_sources_statement|show_streams_statement|show_cluster_statement|show_jobs_statement|insert_statement|update_statement|upsert_statement|lookup_statement|select_statement|create_stream_statement|create_source_statement|show_stream_statement|show_source_statement|drop_stream_statement|drop_source_statement|drop_job_statement|show_job_statement|delete_statement)+
    {

    }
    ;

//USE///////////////////////////////////////////////////////////////////////////////////
use_name_def returns [String ret]
    :   n=NAME { $ret = n.getText(); }
    ;

use_statement
    : USE column=set_name_def SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("USE"));
        BaseUseDef useDef = new BaseUseDef();
        useDef.setName(column.ret);
        statement.setUseDef(useDef);
        statements.add(statement);
    }
    ;

//SET///////////////////////////////////////////////////////////////////////////////////
set_name_def returns [String ret]
    :   n=NAME { $ret = n.getText(); }
    ;

set_value_def returns [String ret]
     :   n=NAME { $ret = n.getText(); }
     ;

set_statement
    : SET column=set_name_def EQUAL SINGLE_QUOTE value=set_value_def SINGLE_QUOTE SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SET"));
        BaseSetDef settingDef = new BaseSetDef();
        settingDef.setName(column.ret);
        settingDef.setValue(value.ret);
        statement.setSettingDef(settingDef);
        statements.add(statement);
    }
    ;

//DML///////////////////////////////////////////////////////////////////////////////////
dml_table_name returns [BaseTableDef ret]
    :   LSQUARE n=NAME COLON b=NAME RSQUARE {
                BaseTableDef tableDef = new BaseTableDef();
                tableDef.setName(n.getText());
                tableDef.setSource(b.getText());
                $ret = tableDef;
        }
    ;

dml_bind_column_name returns [String ret]
    :   n=LSQUARE COLON NAME RSQUARE{ $ret = n.getText(); }
    ;


dml_lookup_where returns [String ret]
    :  n=(NAME (NAME)*) {$ret = $text;}
    ;

dml_select_body returns [String ret]
    :  n=(NAME (NAME)*) {$ret = $text;}
    ;

dml_lookup_select_where_body returns [String ret]
    :  n=~('\r' | '\n'|';')+ {$ret = $text;}
    ;

dml_lookup_select_where_body2 returns [String ret]
    :  n=~('\r' | '\n'|';')+ SEMICOLON {$ret = $text;}
    ;

lookup_statement
    : LOOKUP body1 = dml_lookup_select_where_body (WHERE body2 = dml_lookup_select_where_body2|SEMICOLON)
    {
        if (body1 != null) {
            QueryParser lookupParser = new QueryParser();
            BaseStatement statement = lookupParser.parseWithoutEPL($text);
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("LOOKUP"));
            statements.add(statement);
        }
    }
    ;

select_statement
    : SELECT body1 = dml_lookup_select_where_body (WHERE body2 = dml_lookup_select_where_body2|SEMICOLON)
    {
        if (body1 != null) {
            QueryParser esperParser = new QueryParser();
            BaseStatement statement = esperParser.parse($text);
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("SELECT"));
            statements.add(statement);
        }

    }
    ;

rest_statement
    : REST INTO body1 = dml_lookup_select_where_body (VALUES body2 = dml_lookup_select_where_body2|SEMICOLON)
    {
        if (body1 != null) {

            QueryParser esperParser = new QueryParser();
            BaseStatement statement = esperParser.parseWithoutInsertEPL($text);
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("REST"));
            statements.add(statement);
        }

    }
    ;

insert_statement
    : INSERT INTO body1 = dml_lookup_select_where_body (VALUES body2 = dml_lookup_select_where_body2|VALUES body2 = dml_lookup_select_where_body2 PLUGINS body3 = dml_lookup_select_where_body2|SEMICOLON)
    {
        if (body1 != null) {

            QueryParser esperParser = new QueryParser();
            BaseStatement statement = esperParser.parseWithoutInsertEPL($text);
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("INSERT"));
            statements.add(statement);
        }

    }
    ;

upsert_statement
    : UPSERT INTO body1 = dml_lookup_select_where_body (VALUES body2 = dml_lookup_select_where_body2|INCREASE VALUES body2 = dml_lookup_select_where_body2|VALUES body2 = dml_lookup_select_where_body2 PLUGINS body3 = dml_lookup_select_where_body2|SEMICOLON)
    {
        if (body1 != null) {

            QueryParser esperParser = new QueryParser();
            BaseStatement statement = esperParser.parseWithoutInsertEPL($text);
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("UPSERT"));
            statements.add(statement);
        }

    }
    ;

update_statement
    : UPDATE body1 = dml_lookup_select_where_body (SET body2 = dml_lookup_select_where_body2 | SET body3 = dml_lookup_select_where_body2 WHERE body4=dml_lookup_select_where_body2|SET body2 = dml_lookup_select_where_body2 PLUGINS body3 = dml_lookup_select_where_body2|SET body3 = dml_lookup_select_where_body2 WHERE body4=dml_lookup_select_where_body2 PLUGINS body5 = dml_lookup_select_where_body2|SEMICOLON)
    {
        if (body1 != null) {

            QueryParser esperParser = new QueryParser();
            BaseStatement statement = esperParser.parseWithoutEPL($text);
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("UPDATE"));
            statements.add(statement);
        }

    }
    ;

delete_statement
    : DELETE FROM body1 = dml_lookup_select_where_body (WHERE body2 = dml_lookup_select_where_body2|WHERE body2 = dml_lookup_select_where_body2 PLUGINS body3 = dml_lookup_select_where_body2|SEMICOLON)
    {
        if (body1 != null) {
            QueryParser esperParser = new QueryParser();
            BaseStatement statement = esperParser.parseWithoutEPL($text);
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("DELETE"));
            statements.add(statement);
        }

    }
    ;
//DDL///////////////////////////////////////////////////////////////////////////////////
ddl_table_name returns [BaseTableDef ret]
    :   n=NAME {
            BaseTableDef tableDef = new BaseTableDef();
            tableDef.setName(n.getText());
            $ret = tableDef;
        }
    ;

ddl_column_pk returns [boolean ret]
    :
        n='PARTITION_KEY' {$ret = true;}
    ;

ddl_column_comment returns [String ret]
    :   SINGLE_QUOTE n=NAME SINGLE_QUOTE { $ret = n.getText();}
    ;

ddl_column_name returns [String ret]
    :   n=NAME { $ret = n.getText(); }
    ;

ddl_column_type returns [ColumnDataTypeEnum ret]
    :   n=('STRING'|'INTEGER'|'FLOAT'|'DOUBLE') {
        $ret = ColumnDataTypeEnum.valueOf(n.getText()); }
    ;

ddl_column_defs returns [List<BaseColumnDef> ret]
    :
        v = column_def {
            $ret = new ArrayList<BaseColumnDef>();
            $ret.add(v.ret);
        } (COMMA v = column_def {$ret.add(v.ret);} )*
    ;

column_def returns [BaseColumnDef ret]
    :   c=ddl_column_name dt=ddl_column_type (pk=ddl_column_pk)* (cmt=ddl_column_comment)*
        {
            $ret = new BaseColumnDef(c.ret.toString(), dt.ret, (pk == null ? false : pk.ret), (cmt == null ? "" : cmt.ret.toString()));
        }
    ;

//////////////////////////////////////////////////////////////////////////////
stream_meta_name returns [String ret]
    :   n=('TOPIC'|'COMMENT'|'TICKSEC') { $ret = n.getText(); }
    ;

stream_meta_value returns [String ret]
    :   SINGLE_QUOTE n=NAME SINGLE_QUOTE { $ret = n.getText(); }
    ;

stream_meta_def returns [BaseMetaDef ret]
    :   c=stream_meta_name dt=stream_meta_value
        { $ret = new BaseMetaDef(c.ret.toString(), dt.ret.toString()); }
    ;

ddl_stream_meta_defs returns [List<BaseMetaDef> ret]
         :
             v = stream_meta_def {
                 $ret = new ArrayList<BaseMetaDef>();
                 $ret.add(v.ret);
             } (COMMA v = stream_meta_def {$ret.add(v.ret);} )*
         ;

create_stream_statement
    : CREATE STREAM table_name=ddl_table_name
        LPAREN columns=ddl_column_defs RPAREN META LPAREN metas=ddl_stream_meta_defs RPAREN SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("CREATE_STREAM"));
        statement.setTable(table_name.ret);
        statement.setColumns(columns.ret);
        statement.setMetas(metas.ret);

        statements.add(statement);
    }
    ;

drop_stream_statement
    : DROP STREAM table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("DROP_STREAM"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;

show_stream_statement
    : SHOW STREAM table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_STREAM"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;

show_streams_statement
    : SHOW STREAMS SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_STREAMS"));

        statements.add(statement);
    }
    ;

kill_job_statement
    : KILL JOB table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("KILL_JOB"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;

commit_statement
    : COMMIT SEMICOLON {

    }
    ;

///////////////////////////////////////////////////////////////////////////////////////
source_meta_name returns [String ret]
    :   n=('CATALOG'|'URL'|'DRIVER'|'ID'|'PW'|'VHOST'|'PORT'|'TOPIC'|'CLUSTER'|'INITIALPOOLSIZE'|'MAXPOOLSIZE'|'MINPOOLSIZE') { $ret = n.getText(); }
    ;

source_meta_value returns [String ret]
    :   SINGLE_QUOTE n=NAME (NAME|COMMA)* SINGLE_QUOTE { $ret = n.getText(); }
    ;

source_meta_def returns [BaseMetaDef ret]
    :   c=source_meta_name dt=source_meta_value
        { $ret = new BaseMetaDef(c.ret.toString(), dt.ret.toString()); }
    ;

ddl_source_meta_defs returns [List<BaseMetaDef> ret]
         :
             v = source_meta_def {
                 $ret = new ArrayList<BaseMetaDef>();
                 $ret.add(v.ret);
             } (COMMA v = source_meta_def {$ret.add(v.ret);} )*
         ;

create_source_statement
    : CREATE SOURCE table_name=ddl_table_name META LPAREN metas=ddl_source_meta_defs RPAREN SEMICOLON
    {

            BaseStatement statement = new BaseStatement();
            statement.setQuery($text);
            statement.setType(StatementTypeEnum.valueOf("CREATE_SOURCE"));
            statement.setTable(table_name.ret);
            statement.setMetas(metas.ret);

            statements.add(statement);
    }
    ;

drop_source_statement
    : DROP SOURCE table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("DROP_SOURCE"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;

show_source_statement
    : SHOW SOURCE table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_SOURCE"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;

show_sources_statement
    : SHOW SOURCES SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_SOURCES"));

        statements.add(statement);
    }
    ;
//////////////////////////////////////////////////////////////////////////////////////////
drop_job_statement
    : DROP JOB table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("DROP_JOB"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;

show_job_statement
    : SHOW JOB table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_JOB"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;

show_jobs_statement
    : SHOW JOBS SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_JOBS"));

        statements.add(statement);
    }
    ;

show_cluster_statement
    : SHOW CLUSTER SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_CLUSTER"));

        statements.add(statement);
    }
    ;

show_system_statement
    : SHOW SYSTEM SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SHOW_SYSTEM"));

        statements.add(statement);
    }
    ;

snapshot_job_statement
    : SNAPSHOT JOB table_name=ddl_table_name SEMICOLON
    {
        BaseStatement statement = new BaseStatement();
        statement.setQuery($text);
        statement.setType(StatementTypeEnum.valueOf("SNAPSHOT_JOB"));
        statement.setTable(table_name.ret);

        statements.add(statement);
    }
    ;
/////////////////////////////////////////////////////////////////////////////////////////////

WS : WHITESPACE+ { $channel = HIDDEN;};
NAME : (DIV|UNICODE_LETTER|UNICODE_DIGIT|LETTER|DIGIT|LSQUARE|RSQUARE|ANDMARK|COLON|COMM|UNDERLINE|MINUS|LBLE|RBLE|QUESTION|EXCLAMATION) (DIV|UNICODE_LETTER|UNICODE_DIGIT|LETTER|DIGIT|LSQUARE|RSQUARE|ANDMARK|COLON|COMM|UNDERLINE|MINUS|LBLE|RBLE|QUESTION|EXCLAMATION)*;

fragment WHITESPACE : ( '\t' | '\r' | '\n'| ' ' |'\u000C' );
fragment LETTER : ('a'..'z'|'A'..'Z');
fragment DIGIT : '0'..'9';
fragment UNICODE_LETTER		// Any character in the Unicode categories "Uppercase letter (Lu)",
	: '\u0041'..'\u005A'	// "Lowercase letter (Ll)", "Titlecase letter (Lt)",
	| '\u0061'..'\u007A'	// "Modifier letter (Lm)", "Other letter (Lo)", or "Letter number (Nl)".
	| '\u00AA'
	| '\u00B5'
	| '\u00BA'
	| '\u00C0'..'\u00D6'
	| '\u00D8'..'\u00F6'
	| '\u00F8'..'\u021F'
	| '\u0222'..'\u0233'
	| '\u0250'..'\u02AD'
	| '\u02B0'..'\u02B8'
	| '\u02BB'..'\u02C1'
	| '\u02D0'..'\u02D1'
	| '\u02E0'..'\u02E4'
	| '\u02EE'
	| '\u037A'
	| '\u0386'
	| '\u0388'..'\u038A'
	| '\u038C'
	| '\u038E'..'\u03A1'
	| '\u03A3'..'\u03CE'
	| '\u03D0'..'\u03D7'
	| '\u03DA'..'\u03F3'
	| '\u0400'..'\u0481'
	| '\u048C'..'\u04C4'
	| '\u04C7'..'\u04C8'
	| '\u04CB'..'\u04CC'
	| '\u04D0'..'\u04F5'
	| '\u04F8'..'\u04F9'
	| '\u0531'..'\u0556'
	| '\u0559'
	| '\u0561'..'\u0587'
	| '\u05D0'..'\u05EA'
	| '\u05F0'..'\u05F2'
	| '\u0621'..'\u063A'
	| '\u0640'..'\u064A'
	| '\u0671'..'\u06D3'
	| '\u06D5'
	| '\u06E5'..'\u06E6'
	| '\u06FA'..'\u06FC'
	| '\u0710'
	| '\u0712'..'\u072C'
	| '\u0780'..'\u07A5'
	| '\u0905'..'\u0939'
	| '\u093D'
	| '\u0950'
	| '\u0958'..'\u0961'
	| '\u0985'..'\u098C'
	| '\u098F'..'\u0990'
	| '\u0993'..'\u09A8'
	| '\u09AA'..'\u09B0'
	| '\u09B2'
	| '\u09B6'..'\u09B9'
	| '\u09DC'..'\u09DD'
	| '\u09DF'..'\u09E1'
	| '\u09F0'..'\u09F1'
	| '\u0A05'..'\u0A0A'
	| '\u0A0F'..'\u0A10'
	| '\u0A13'..'\u0A28'
	| '\u0A2A'..'\u0A30'
	| '\u0A32'..'\u0A33'
	| '\u0A35'..'\u0A36'
	| '\u0A38'..'\u0A39'
	| '\u0A59'..'\u0A5C'
	| '\u0A5E'
	| '\u0A72'..'\u0A74'
	| '\u0A85'..'\u0A8B'
	| '\u0A8D'
	| '\u0A8F'..'\u0A91'
	| '\u0A93'..'\u0AA8'
	| '\u0AAA'..'\u0AB0'
	| '\u0AB2'..'\u0AB3'
	| '\u0AB5'..'\u0AB9'
	| '\u0ABD'
	| '\u0AD0'
	| '\u0AE0'
	| '\u0B05'..'\u0B0C'
	| '\u0B0F'..'\u0B10'
	| '\u0B13'..'\u0B28'
	| '\u0B2A'..'\u0B30'
	| '\u0B32'..'\u0B33'
	| '\u0B36'..'\u0B39'
	| '\u0B3D'
	| '\u0B5C'..'\u0B5D'
	| '\u0B5F'..'\u0B61'
	| '\u0B85'..'\u0B8A'
	| '\u0B8E'..'\u0B90'
	| '\u0B92'..'\u0B95'
	| '\u0B99'..'\u0B9A'
	| '\u0B9C'
	| '\u0B9E'..'\u0B9F'
	| '\u0BA3'..'\u0BA4'
	| '\u0BA8'..'\u0BAA'
	| '\u0BAE'..'\u0BB5'
	| '\u0BB7'..'\u0BB9'
	| '\u0C05'..'\u0C0C'
	| '\u0C0E'..'\u0C10'
	| '\u0C12'..'\u0C28'
	| '\u0C2A'..'\u0C33'
	| '\u0C35'..'\u0C39'
	| '\u0C60'..'\u0C61'
	| '\u0C85'..'\u0C8C'
	| '\u0C8E'..'\u0C90'
	| '\u0C92'..'\u0CA8'
	| '\u0CAA'..'\u0CB3'
	| '\u0CB5'..'\u0CB9'
	| '\u0CDE'
	| '\u0CE0'..'\u0CE1'
	| '\u0D05'..'\u0D0C'
	| '\u0D0E'..'\u0D10'
	| '\u0D12'..'\u0D28'
	| '\u0D2A'..'\u0D39'
	| '\u0D60'..'\u0D61'
	| '\u0D85'..'\u0D96'
	| '\u0D9A'..'\u0DB1'
	| '\u0DB3'..'\u0DBB'
	| '\u0DBD'
	| '\u0DC0'..'\u0DC6'
	| '\u0E01'..'\u0E30'
	| '\u0E32'..'\u0E33'
	| '\u0E40'..'\u0E46'
	| '\u0E81'..'\u0E82'
	| '\u0E84'
	| '\u0E87'..'\u0E88'
	| '\u0E8A'
	| '\u0E8D'
	| '\u0E94'..'\u0E97'
	| '\u0E99'..'\u0E9F'
	| '\u0EA1'..'\u0EA3'
	| '\u0EA5'
	| '\u0EA7'
	| '\u0EAA'..'\u0EAB'
	| '\u0EAD'..'\u0EB0'
	| '\u0EB2'..'\u0EB3'
	| '\u0EBD'..'\u0EC4'
	| '\u0EC6'
	| '\u0EDC'..'\u0EDD'
	| '\u0F00'
	| '\u0F40'..'\u0F6A'
	| '\u0F88'..'\u0F8B'
	| '\u1000'..'\u1021'
	| '\u1023'..'\u1027'
	| '\u1029'..'\u102A'
	| '\u1050'..'\u1055'
	| '\u10A0'..'\u10C5'
	| '\u10D0'..'\u10F6'
	| '\u1100'..'\u1159'
	| '\u115F'..'\u11A2'
	| '\u11A8'..'\u11F9'
	| '\u1200'..'\u1206'
	| '\u1208'..'\u1246'
	| '\u1248'
	| '\u124A'..'\u124D'
	| '\u1250'..'\u1256'
	| '\u1258'
	| '\u125A'..'\u125D'
	| '\u1260'..'\u1286'
	| '\u1288'
	| '\u128A'..'\u128D'
	| '\u1290'..'\u12AE'
	| '\u12B0'
	| '\u12B2'..'\u12B5'
	| '\u12B8'..'\u12BE'
	| '\u12C0'
	| '\u12C2'..'\u12C5'
	| '\u12C8'..'\u12CE'
	| '\u12D0'..'\u12D6'
	| '\u12D8'..'\u12EE'
	| '\u12F0'..'\u130E'
	| '\u1310'
	| '\u1312'..'\u1315'
	| '\u1318'..'\u131E'
	| '\u1320'..'\u1346'
	| '\u1348'..'\u135A'
	| '\u13A0'..'\u13B0'
	| '\u13B1'..'\u13F4'
	| '\u1401'..'\u1676'
	| '\u1681'..'\u169A'
	| '\u16A0'..'\u16EA'
	| '\u1780'..'\u17B3'
	| '\u1820'..'\u1877'
	| '\u1880'..'\u18A8'
	| '\u1E00'..'\u1E9B'
	| '\u1EA0'..'\u1EE0'
	| '\u1EE1'..'\u1EF9'
	| '\u1F00'..'\u1F15'
	| '\u1F18'..'\u1F1D'
	| '\u1F20'..'\u1F39'
	| '\u1F3A'..'\u1F45'
	| '\u1F48'..'\u1F4D'
	| '\u1F50'..'\u1F57'
	| '\u1F59'
	| '\u1F5B'
	| '\u1F5D'
	| '\u1F5F'..'\u1F7D'
	| '\u1F80'..'\u1FB4'
	| '\u1FB6'..'\u1FBC'
	| '\u1FBE'
	| '\u1FC2'..'\u1FC4'
	| '\u1FC6'..'\u1FCC'
	| '\u1FD0'..'\u1FD3'
	| '\u1FD6'..'\u1FDB'
	| '\u1FE0'..'\u1FEC'
	| '\u1FF2'..'\u1FF4'
	| '\u1FF6'..'\u1FFC'
	| '\u207F'
	| '\u2102'
	| '\u2107'
	| '\u210A'..'\u2113'
	| '\u2115'
	| '\u2119'..'\u211D'
	| '\u2124'
	| '\u2126'
	| '\u2128'
	| '\u212A'..'\u212D'
	| '\u212F'..'\u2131'
	| '\u2133'..'\u2139'
	| '\u2160'..'\u2183'
	| '\u3005'..'\u3007'
	| '\u3021'..'\u3029'
	| '\u3031'..'\u3035'
	| '\u3038'..'\u303A'
	| '\u3041'..'\u3094'
	| '\u309D'..'\u309E'
	| '\u30A1'..'\u30FA'
	| '\u30FC'..'\u30FE'
	| '\u3105'..'\u312C'
	| '\u3131'..'\u318E'
	| '\u31A0'..'\u31B7'
	| '\u3400'
	| '\u4DB5'
	| '\u4E00'
	| '\u9FA5'
	| '\uA000'..'\uA48C'
	| '\uAC00'
	| '\uD7A3'
	| '\uF900'..'\uFA2D'
	| '\uFB00'..'\uFB06'
	| '\uFB13'..'\uFB17'
	| '\uFB1D'
	| '\uFB1F'..'\uFB28'
	| '\uFB2A'..'\uFB36'
	| '\uFB38'..'\uFB3C'
	| '\uFB3E'
	| '\uFB40'..'\uFB41'
	| '\uFB43'..'\uFB44'
	| '\uFB46'..'\uFBB1'
	| '\uFBD3'..'\uFD3D'
	| '\uFD50'..'\uFD8F'
	| '\uFD92'..'\uFDC7'
	| '\uFDF0'..'\uFDFB'
	| '\uFE70'..'\uFE72'
	| '\uFE74'
	| '\uFE76'..'\uFEFC'
	| '\uFF21'..'\uFF3A'
	| '\uFF41'..'\uFF5A'
	| '\uFF66'..'\uFFBE'
	| '\uFFC2'..'\uFFC7'
	| '\uFFCA'..'\uFFCF'
	| '\uFFD2'..'\uFFD7'
	| '\uFFDA'..'\uFFDC'
	;

fragment UNICODE_DIGIT		// Any character in the Unicode category "Decimal number (Nd)".
	: '\u0030'..'\u0039'
	| '\u0660'..'\u0669'
	| '\u06F0'..'\u06F9'
	| '\u0966'..'\u096F'
	| '\u09E6'..'\u09EF'
	| '\u0A66'..'\u0A6F'
	| '\u0AE6'..'\u0AEF'
	| '\u0B66'..'\u0B6F'
	| '\u0BE7'..'\u0BEF'
	| '\u0C66'..'\u0C6F'
	| '\u0CE6'..'\u0CEF'
	| '\u0D66'..'\u0D6F'
	| '\u0E50'..'\u0E59'
	| '\u0ED0'..'\u0ED9'
	| '\u0F20'..'\u0F29'
	| '\u1040'..'\u1049'
	| '\u1369'..'\u1371'
	| '\u17E0'..'\u17E9'
	| '\u1810'..'\u1819'
	| '\uFF10'..'\uFF19'
	;