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
        drawTitle();
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

            if(value != (int)value)
            {
                lengthOfValue = Double.toString(value).length();

                if(lengthOfValue <= 4)
                {
                    text = new Text(this, Double.toString(value), new Point((0.03+((1-lengthOfValue)*0.01))*width,
                            i-0.02*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Double.toString(value), new Point(0.0*width,
                            i-0.02*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
            }
            else
            {
                int intValue = (int)value;

                lengthOfValue = Integer.toString(intValue).length();

                if(lengthOfValue <= 4)
                {
                    text = new Text(this, Integer.toString(intValue), new Point((0.03+((1-lengthOfValue)*0.01))*width,
                            i-0.06*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Integer.toString(intValue), new Point(0.0*width,
                            i-0.06*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSize, new Color(0,0,0));
                    text.draw();
                }
            }

            value += valuesSpike;

//            Text helpText = new Text(this, Double.toString((0.03+((1-lengthOfValue)*0.01))), new Point(300, 300+i),
//                    new Point(500, 500),
//                    (int)valueFontSize, new Color(0,0,0));
//            helpText.draw();

//            Line helpLine = new Line(this, new Point((0.03+((1-lengthOfValue)*0.01))*width ,i-0.06*height),
//                    new Point(0.039*width,i+0.06*height));
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
