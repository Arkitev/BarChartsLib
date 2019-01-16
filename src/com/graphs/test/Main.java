package com.graphs.test;

import com.graphs.lib.graph.HorizontalColumnChart;
import com.graphs.lib.graph.PointGraph;
import com.graphs.lib.graph.VerticalColumnChart;
import com.graphs.lib.graph.element.Color;
import com.graphs.lib.graph.element.GraphTitle;
import com.graphs.lib.graph.element.Text;

import static com.graphs.lib.graph.element.Text.Align.BOTTOM;
import static com.graphs.lib.graph.element.Text.Align.CENTER;
import static com.graphs.lib.graph.element.Text.Align.RIGHT;

public class Main {
    public static void main(String[] args) {
        HorizontalColumnChart verticalGraph = new HorizontalColumnChart(1920, 1080);
        verticalGraph.setTitle("Wykres kolumnowy", 40, Text.Align.RIGHT, Text.Align.CENTER, new Color(50,100,150));
        verticalGraph.setHorizontalAxisRatio(1);
        verticalGraph.setVerticalAxisRatio(1);
        verticalGraph.setSeparatorsAmount(11);
        verticalGraph.setMinDataValues(0);
        verticalGraph.setMaxDataValues(1000);
        verticalGraph.setRoundValue(3);
        verticalGraph.run();

        //HorizontalColumnChart horizontalGraph = new HorizontalColumnChart(1280,720);
        //horizontalGraph.setHorizontalAxisRatio(0.49834718974);
        //horizontalGraph.setVerticalAxisRatio(0.3);
        //horizontalGraph.setSeparatorsAmount(5);
        //horizontalGraph.run();
    }
}