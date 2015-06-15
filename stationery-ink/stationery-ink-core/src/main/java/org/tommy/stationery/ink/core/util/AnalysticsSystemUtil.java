package org.tommy.stationery.ink.core.util;

import org.tommy.stationery.ink.core.util.analystics.analyzer.VmstatAnalyzer;
import org.tommy.stationery.ink.core.util.analystics.analyzer.simpleanalyzer.SimpleAnalyzer;
import org.tommy.stationery.ink.core.util.analystics.loader.DefaultVmstatDataLoader;
import org.tommy.stationery.ink.core.util.analystics.loader.VmstatDataFormatException;
import org.tommy.stationery.ink.core.util.analystics.loader.VmstatDataLoader;
import org.tommy.stationery.ink.core.util.analystics.model.VmstatData;

import java.io.File;

/**
 * Created by kun7788 on 15. 6. 15..
 */
public class AnalysticsSystemUtil {

    public static String getAnalysticReportData(String vmstatFilePath) throws VmstatDataFormatException {
        File vmstatFile = new File(vmstatFilePath);
        if (!(vmstatFile.exists() && vmstatFile.canRead())) {
            throw new VmstatDataFormatException("Unable to find or read [AnalysticsSystemUtil] error");
        }

        VmstatDataLoader loader = new DefaultVmstatDataLoader(vmstatFilePath);
        VmstatData data;
        try {
            data = loader.getData();
            VmstatAnalyzer analyzer = new SimpleAnalyzer(data);
            return analyzer.getReport();
        } catch (VmstatDataFormatException e) {
            throw new VmstatDataFormatException("Given vmstat format not supported");
        }
    }
}
