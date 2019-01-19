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
        HorizontalColumnChart verticalGraph = new HorizontalColumnChart(1600, 900);
        verticalGraph.setTitle("Wykres kolumnowy", 40, Text.Align.RIGHT, Text.Align.CENTER, ColorsPalette.Pink);
        verticalGraph.setHorizontalAxisRatio(0.9);
        verticalGraph.setVerticalAxisRatio(0.9);
        verticalGraph.setSeparatorsAmount(6);
        verticalGraph.enableLongSeparators(true);
        verticalGraph.setMinDataValues(0);
        verticalGraph.setMaxDataValues(1000);
        verticalGraph.setRoundValue(3);
        verticalGraph.insertData("Styczeń", 400, ColorsPalette.Red);
        verticalGraph.insertData("Luty", 153, ColorsPalette.Blue);
        verticalGraph.insertData("Marzec", 800, ColorsPalette.Orange);
        verticalGraph.insertData("Kwiecień", 190, ColorsPalette.DarkYellow);
        verticalGraph.insertData("Maj", 1000, ColorsPalette.DarkGreen);
        verticalGraph.insertData("Czerwiec", 456, ColorsPalette.DarkBrown);
        verticalGraph.insertData("Lipiec", 133, ColorsPalette.DarkPink);
        verticalGraph.insertData("Sierpień", 783, ColorsPalette.LightGreen);
        verticalGraph.insertData("Wrzesień", 967, ColorsPalette.LightRed);
        verticalGraph.insertData("Październik", 650, ColorsPalette.Black);
        verticalGraph.insertData("Listopad", 602, ColorsPalette.DefaultBackground);
        verticalGraph.insertData("Grudzień", 912, ColorsPalette.Green);
        verticalGraph.run();
    }
}