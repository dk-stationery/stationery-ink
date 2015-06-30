package org.tommy.stationery.ink.core.engine.storm.build.storm;

import backtype.storm.generated.StormTopology;
import backtype.storm.topology.*;
import backtype.storm.tuple.Fields;
import org.tommy.stationery.ink.core.engine.storm.bolt.stream.Connection;
import org.tommy.stationery.ink.domain.BaseColumnDef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kun7788 on 15. 1. 28..
 */
public class StormTopologyBuilder {
    private final Map<String, IRichSpout> spoutMap = new HashMap<String, IRichSpout>();
    private final Map<String, IRichBolt> boltMap = new HashMap<String, IRichBolt>();
    private final Map<String, Map> configurate = new HashMap<String, Map>();
    private final Map<String, Integer> paramism = new HashMap<String, Integer>();

    private final Map<String, List<Connection>> connections = new HashMap<String, List<Connection>>();
    private final Map<String, List<BaseColumnDef>> groupingFields = new HashMap<String, List<BaseColumnDef>>();
    private String previousComponentId = null;

    public StormTopologyBuilder addConfigurations(String name, Map configuration)
    {
        configurate.put(name, configuration);
        return this;
    }

    public boolean isRegistAlready(String name) {
        if (spoutMap.containsKey(name) == true) {
            return true;
        }
        return false;
    }

    public StormTopologyBuilder addSpout(String name, IRichSpout spout, int parallelism)
    {
        spoutMap.put(name, spout);
        paramism.put(name, parallelism);
        previousComponentId = name;
        return this;
    }

    public StormTopologyBuilder addBolt(String name, IRichBolt bolt, int parallelism)
    {
        boltMap.put(name, bolt);
        paramism.put(name, parallelism);
        previousComponentId = name;
        return this;
    }

    public IRichBolt getBolt(String name)
    {
        return boltMap.get(name);
    }

    public StormTopologyBuilder connect(String sourceComponent, String targetComponent, List<BaseColumnDef> columns)
    {
        return connect(sourceComponent, "default", targetComponent, columns);
    }

    public StormTopologyBuilder connect(String sourceComponent, String sourceStream, String targetComponent, List<BaseColumnDef> columns)
    {
        List<Connection> connectionsForTarget = connections.get(targetComponent);
        if (connectionsForTarget == null) {
            connectionsForTarget = new ArrayList<Connection>();
            connections.put(targetComponent, connectionsForTarget);
            if (columns != null) {
                groupingFields.put(targetComponent, columns);
            }
        }
        connectionsForTarget.add(new Connection(sourceComponent, sourceStream, targetComponent));
        return this;
    }

    public StormTopology build()
    {
        final TopologyBuilder builder = new TopologyBuilder();

        for (Map.Entry<String, IRichSpout> spoutEntry : spoutMap.entrySet()) {

            int parallelism = paramism.get(spoutEntry.getKey());
            if (parallelism < 0) {
                parallelism = 1;
            }
            SpoutDeclarer spoutDeclarer = builder.setSpout(spoutEntry.getKey(), spoutEntry.getValue(), parallelism);

            if (configurate.containsKey(spoutEntry.getKey()) == true) {
                spoutDeclarer.addConfigurations(configurate.get(spoutEntry.getKey()));
            }
        }
        for (Map.Entry<String, IRichBolt> boltEntry : boltMap.entrySet()) {

            int parallelism = paramism.get(boltEntry.getKey());
            if (parallelism < 0) {
                parallelism = 1;
            }

            InputDeclarer declarer = builder.setBolt(boltEntry.getKey(), boltEntry.getValue(), parallelism);
            List<Connection> connectionsForTarget = connections.get(boltEntry.getKey());
            if (connectionsForTarget != null) {
                for (Connection connection : connectionsForTarget) {
                    if (groupingFields.containsKey(boltEntry.getKey()) == false) {
                        List<String> columns = new ArrayList<String>();

                        List<BaseColumnDef> _columns = groupingFields.get(boltEntry.getKey());
                        if (_columns != null && _columns.size() > 0) {
                            for (BaseColumnDef columnDef : _columns) {
                                columns.add(columnDef.getName());
                            }
                            declarer = declarer.fieldsGrouping(connection.getSourceComponent(), new Fields(columns.toArray(new String[0])));
                        } else {
                            declarer = declarer.shuffleGrouping(connection.getSourceComponent(), connection.getSourceStream());
                        }

                    } else {
                        declarer = declarer.shuffleGrouping(connection.getSourceComponent(), connection.getSourceStream());
                    }
                }
            }
        }

        return builder.createTopology();
    }
}
