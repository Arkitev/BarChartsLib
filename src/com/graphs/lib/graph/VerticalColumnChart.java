package com.graphs.lib.graph;

import com.graphs.lib.graph.element.*;

import java.util.ArrayList;
import java.util.List;

public class VerticalColumnChart extends ColumnChart
{
    public VerticalColumnChart(int width, int height)
    {
        super(width, height);
    }

    public VerticalColumnChart()
    {
        this.width = 900;
        this.height = 600;
    }

    @Override
    public void draw()
    {
        drawEmptyChart();
        drawVerticalColumns();
        drawVerticalColumnsLabels();
        drawHorizontalSeparatorsWithLabels();
    }

    private void drawHorizontalSeparatorsWithLabels()
    {
        Line line;
        Text text;
        double value = minDataValues;
        int lengthOfValue;

        for(double i = (0.95*height); i >= maxAxisHeight-0.0001;
            i=i-(((0.95*height)-maxAxisHeight) / (separatorsAmount-1)))
        {
            line = new Line(this, new Point(minHorizontalSeparatorsLength, i), new Point(maxHorizontalSeparatorsLength, i));
            line.draw();

            //lengthOfValue = Double.toString(value).length();

            if(value != (int)value)
            {
                text = new Text(this, Double.toString(value), new Point(0.001*width,i-0.02*height), //(669, 12.8)
                        new Point(0.039*width,i+0.02*height), (int)valueFontSize, new Color(0,0,0));
                text.draw();
            }
            else
            {
                int intValue = (int)value;

                text = new Text(this, Integer.toString(intValue), new Point(0.001*width,i-0.02*height), //(669, 12.8)
                        new Point(0.039*width,i+0.02*height), (int)valueFontSize, new Color(0,0,0));
                text.draw();
            }

            value += valuesSpike;

//            Line helpLine = new Line(this, new Point(0.001*width,i-0.02*height),
//                    new Point(0.039*width,i+0.02*height));
//            helpLine.draw();
        }
    }

    private void drawVerticalColumns()
    {

    }

    private void drawVerticalColumnsLabels()
    {

    }
}
