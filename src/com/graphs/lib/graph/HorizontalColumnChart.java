package com.graphs.lib.graph;

import com.graphs.lib.graph.element.*;
import com.graphs.lib.graph.exceptions.InvalidWindowSizeException;

import java.util.ArrayList;
import java.util.List;

public class HorizontalColumnChart extends ColumnChart
{
    public HorizontalColumnChart(int width, int height) throws InvalidWindowSizeException
    {
        super(width, height);
    }

    public HorizontalColumnChart()
    {
        this.width = 1600;
        this.height = 900;
    }

    @Override
    public void createChart()
    {
        drawEmptyChart();
        drawVerticalSeparatorsWithLabels();
        drawHorizontalColumns();
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
            if(enableLongSeparators)
            {
                line = new Line(this, new Point(i, maxAxisHeight),
                        new Point(i, maxVerticalSeparatorsLength));
                line.draw();
            }
            else
            {
                line = new Line(this, new Point(i, minVerticalSeparatorsLength),
                        new Point(i, maxVerticalSeparatorsLength));
                line.draw();
            }

            if(value != (int)value)
            {
                lengthOfValue = Double.toString(value).length();

                if(lengthOfValue <= 6)
                {
                    text = new Text(this, Double.toString(round(value, roundValue)),
                            new Point(i-0.00125*width+(1-lengthOfValue)*0.0033*width, 0.9394*height),
                            new Point(i+0.0075*width-(1-lengthOfValue)*0.004*width,0.99*height), (int)valueFontSizeHorizontal, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Double.toString(round(value, roundValue)),
                            new Point(i-0.02*width, 0.9394*height),
                            new Point(i+0.02*width,0.99*height), (int)valueFontSizeHorizontal, new Color(0,0,0));
                    text.draw();
                }
            }
            else
            {
                int intValue = (int)value;

                lengthOfValue = Integer.toString(intValue).length();

                if(lengthOfValue <= 6)
                {
                    text = new Text(this, Integer.toString(intValue),
                            new Point(i-0.00125*width+(1-lengthOfValue)*0.0033*width, 0.9394*height),
                            new Point(i+0.0075*width-(1-lengthOfValue)*0.004*width,0.99*height), (int)valueFontSizeHorizontal, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Integer.toString(intValue),
                            new Point(i-0.02*width, 0.9394*height),
                            new Point(i+0.02*width,0.99*height), (int)valueFontSizeHorizontal, new Color(0,0,0));
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
        Rectangle column;
        Text text;
        double intervalHeightUp = 0;
        double intervalHeightDown = 0;
        double columnLength = 0;

        for(int i = 0; i < data.size(); i++)
        {
            columnLength = (data.get(i).getData()-minDataValues)/(maxDataValues-minDataValues) * (maxAxisWidth-0.05*width);
            intervalHeightUp = 0.95*height - ((((0.95*height)-maxAxisHeight) / data.size()) * i);
            intervalHeightDown = 0.95*height - ((((0.95*height)-maxAxisHeight) / data.size()) * (i+1));

            column = new Rectangle(this,
                    new Point(0.05*width, intervalHeightUp - 0.01*height*verticalAxisRatio),
                    new Point(0.05*width + columnLength,intervalHeightDown + 0.01*height*verticalAxisRatio),
                    data.get(i).getColor());
            column.draw();

            text = new Text(this, Integer.toString(i+1),
                    new Point(0.03*width,intervalHeightUp - 0.01*height),
                    new Point(0.049*width,intervalHeightDown + 0.01*height),
                    (int)valueFontSizeHorizontal,
                    ColorsPalette.Black);
            text.draw();
        }
    }
}
