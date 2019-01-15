package com.graphs.lib.graph;

import com.graphs.lib.graph.element.*;

import java.util.ArrayList;
import java.util.List;

public class HorizontalColumnChart extends ColumnChart
{
    public HorizontalColumnChart(int width, int height)
    {
        super(width, height);
    }

    public HorizontalColumnChart()
    {
        this.width = 800;
        this.height = 600;
    }

    @Override
    public void draw()
    {
        drawEmptyChart();
        drawTitle();
        drawVerticalSeparatorsWithLabels();
        drawHorizontalColumns();
        drawHorizontalColumnsLabels();
    }

    private void drawVerticalSeparatorsWithLabels()
    {
        Line line;
        Text text;

        for(double i = (0.05*width); i <= maxAxisWidth;
            i=i+((maxAxisWidth-(0.05*width)) / (separatorsAmount-1)))
        {
            line = new Line(this, new Point(i, minVerticalSeparatorsLength), new Point(i, maxVerticalSeparatorsLength));
            line.draw();

            for(double j = minDataValues; j <= maxDataValues; j=j+(maxDataValues / (separatorsAmount-1)))
            {
                text = new Text(this, "123", new Point(200,200),
                        new Point(300,500), 20, new Color(0,0,0));
                text.draw();
            }
        }
    }

    private void drawHorizontalColumns()
    {

    }

    private void drawHorizontalColumnsLabels()
    {

    }
}
