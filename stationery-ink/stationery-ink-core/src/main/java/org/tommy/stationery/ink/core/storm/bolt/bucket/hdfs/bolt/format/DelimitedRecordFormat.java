package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.format;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class DelimitedRecordFormat implements RecordFormat {
    public static final String DEFAULT_FIELD_DELIMITER = ",";
    public static final String DEFAULT_RECORD_DELIMITER = "\n";
    private String fieldDelimiter = DEFAULT_FIELD_DELIMITER;
    private String recordDelimiter = DEFAULT_RECORD_DELIMITER;
    private Fields fields = null;

    public DelimitedRecordFormat withFields(Fields fields){
        this.fields = fields;
        return this;
    }

    public DelimitedRecordFormat withFieldDelimiter(String delimiter){
        this.fieldDelimiter = delimiter;
        return this;
    }

    public DelimitedRecordFormat withRecordDelimiter(String delimiter){
        this.recordDelimiter = delimiter;
        return this;
    }

    @Override
    public byte[] format(Tuple tuple) {
        StringBuilder sb = new StringBuilder();
        Fields fields = this.fields == null ? tuple.getFields() : this.fields;
        int size = fields.size();
        for(int i = 0; i < size; i++){
            sb.append(tuple.getValueByField(fields.get(i)));
            if(i != size - 1){
                sb.append(this.fieldDelimiter);
            }
        }
        sb.append(this.recordDelimiter);
        return sb.toString().getBytes();
    }
}
