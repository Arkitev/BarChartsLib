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
        double value = minDataValues;
        int lengthOfValue;

        for(double i = (0.05*width); i <= maxAxisWidth+0.0001;
            i=i+((maxAxisWidth-(0.05*width)) / (separatorsAmount-1)))
        {
            line = new Line(this, new Point(i, minVerticalSeparatorsLength), new Point(i, maxVerticalSeparatorsLength));
            line.draw();

            if(value != (int)value)
            {
                lengthOfValue = Double.toString(value).length();

                if(lengthOfValue <= 6)
                {
                    text = new Text(this, Double.toString(round(value, roundValue)), new Point(i-0.00125*width+(1-lengthOfValue)*0.0033*width,
                            0.9394*height),
                            new Point(i+0.0075*width-(1-lengthOfValue)*0.004*width,0.99*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Double.toString(round(value, roundValue)), new Point(i-0.02*width,
                            0.9394*height),
                            new Point(i+0.02*width,0.99*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
            }
            else
            {
                int intValue = (int)value;

                lengthOfValue = Integer.toString(intValue).length();

                if(lengthOfValue <= 6)
                {
                    text = new Text(this, Integer.toString(intValue), new Point(i-0.00125*width+(1-lengthOfValue)*0.0033*width,
                            0.9394*height),
                            new Point(i+0.0075*width-(1-lengthOfValue)*0.004*width,0.99*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Integer.toString(intValue), new Point(i-0.02*width,
                            0.9394*height),
                            new Point(i+0.02*width,0.99*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
            }

            value += valuesSpike;

//            Line helpLine = new Line(this, new Point(i-0.00125*width+(1-lengthOfValue)*0.0033*width, 0.9394*height),
//                    new Point(i+0.0075*width-(1-lengthOfValue)*0.004*width,0.99*height));
//            helpLine.draw();
        }
    }

    private void drawHorizontalColumns()
    {

    }

    private void drawHorizontalColumnsLabels()
    {

    }
}
