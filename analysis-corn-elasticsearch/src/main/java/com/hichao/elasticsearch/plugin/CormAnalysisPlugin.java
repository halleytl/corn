package com.hichao.elasticsearch.plugin;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.rest.RestModule;

import com.hichao.elasticsearch.index.analysis.CornAnalysisBinderProcessor;
import com.hichao.elasticsearch.rest.CornAnalyzerRestAction;


public class CormAnalysisPlugin extends AbstractPlugin {

    @Override public String name() {
        return "analysis-corn";
    }


    @Override public String description() {
        return "corn analysis";
    }


    @Override public void processModule(Module module) {
        if (module instanceof AnalysisModule) {
            AnalysisModule analysisModule = (AnalysisModule) module;
            analysisModule.addProcessor(new CornAnalysisBinderProcessor());
        }
        
        if (module instanceof RestModule) {
            ((RestModule) module).addRestAction(CornAnalyzerRestAction.class);
        }
    }
}
