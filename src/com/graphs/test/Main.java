package com.graphs.test;

import com.graphs.lib.graph.HorizontalColumnChart;
import com.graphs.lib.graph.PointGraph;
import com.graphs.lib.graph.VerticalColumnChart;
import com.graphs.lib.graph.element.Color;
import com.graphs.lib.graph.element.GraphTitle;

public class Main {
    public static void main(String[] args) {
        VerticalColumnChart verticalGraph = new VerticalColumnChart(1600,900);
        verticalGraph.setHorizontalAxisRatio(1);
        verticalGraph.setVerticalAxisRatio(1);
        verticalGraph.setSeparatorsAmount(11);
        verticalGraph.setMinDataValues(0);
        verticalGraph.setMaxDataValues(1000);
        verticalGraph.run();
        verticalGraph.setTitle("Wykres xD", 30, "Center", new Color(0,0,0));


        //HorizontalColumnChart horizontalGraph = new HorizontalColumnChart(1280,720);
        //horizontalGraph.setHorizontalAxisRatio(0.49834718974);
        //horizontalGraph.setVerticalAxisRatio(0.3);
        //horizontalGraph.setSeparatorsAmount(5);
        //horizontalGraph.run();
    }
}