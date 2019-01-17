package com.graphs.test;

import com.graphs.lib.graph.HorizontalColumnChart;
import com.graphs.lib.graph.PointGraph;
import com.graphs.lib.graph.VerticalColumnChart;
import com.graphs.lib.graph.element.Color;
import com.graphs.lib.graph.element.ColorsPalette;
import com.graphs.lib.graph.element.GraphTitle;
import com.graphs.lib.graph.element.Text;
import com.sun.javafx.scene.control.skin.ColorPalette;

import static com.graphs.lib.graph.element.Text.Align.BOTTOM;
import static com.graphs.lib.graph.element.Text.Align.CENTER;
import static com.graphs.lib.graph.element.Text.Align.RIGHT;

public class Main {
    public static void main(String[] args) {
        VerticalColumnChart verticalGraph = new VerticalColumnChart(1920, 1080);
        verticalGraph.setTitle("Wykres kolumnowy", 40, Text.Align.RIGHT, Text.Align.CENTER, ColorsPalette.Pink);
        verticalGraph.setHorizontalAxisRatio(1);
        verticalGraph.setVerticalAxisRatio(0.5);
        verticalGraph.setSeparatorsAmount(11);
        verticalGraph.setMinDataValues(200);
        verticalGraph.setMaxDataValues(800);
        verticalGraph.setRoundValue(3);
        verticalGraph.insertData("Styczeń", 50, ColorsPalette.Red);
        verticalGraph.insertData("Luty", 500, ColorsPalette.Blue);
        verticalGraph.insertData("Marzec", 700, ColorsPalette.Orange);
        verticalGraph.insertData("Kwiecień", 800, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Maj", 1000, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Czerwiec", 1000, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Lipiec", 1000, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Sierpień", 1000, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Wrzesień", 1000, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Październik", 1000, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Listopad", 1000, ColorsPalette.DarkYellow);
//        verticalGraph.insertData("Grudzień", 1000, ColorsPalette.DarkYellow);
        verticalGraph.run();

        //HorizontalColumnChart horizontalGraph = new HorizontalColumnChart(1280,720);
        //horizontalGraph.setHorizontalAxisRatio(0.49834718974);
        //horizontalGraph.setVerticalAxisRatio(0.3);
        //horizontalGraph.setSeparatorsAmount(5);
        //horizontalGraph.run();
    }
}