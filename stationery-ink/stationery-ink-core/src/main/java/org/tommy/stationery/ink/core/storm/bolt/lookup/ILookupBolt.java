package org.tommy.stationery.ink.core.storm.bolt.lookup;

import backtype.storm.tuple.Tuple;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;

import java.beans.PropertyVetoException;
import java.util.List;

public interface ILookupBolt {
    public void setting(String streamId, InkConfig inkConfig, List<String> previousEmitFileds, BaseStatement statement, Stream inkStream, Source inkSource);
    public String generateQuery(Tuple input);
    public Object settingCommunicator() throws PropertyVetoException;
}
