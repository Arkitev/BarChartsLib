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
        this.width = 800;
        this.height = 600;
    }

    @Override
    public void draw()
    {
        drawEmptyChart();
        drawHorizontalSeparatorsWithLabels();
        drawVerticalColumns();
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
            if(enableLongSeparators)
            {
                line = new Line(this, new Point(minHorizontalSeparatorsLength, i),
                        new Point(maxAxisWidth, i));
                line.draw();
            }
            else
            {
                line = new Line(this, new Point(minHorizontalSeparatorsLength, i),
                        new Point(maxHorizontalSeparatorsLength, i));
                line.draw();
            }

            if(value != (int)value)
            {
                lengthOfValue = Double.toString(value).length();

                if(lengthOfValue <= 4)
                {
                    text = new Text(this, Double.toString(round(value, roundValue)),
                            new Point((0.03+((1-lengthOfValue)*0.01))*width, i-0.02*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSizeVertical, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Double.toString(round(value, roundValue)),
                            new Point(0.0*width, i-0.02*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSizeVertical, new Color(0,0,0));
                    text.draw();
                }
            }
            else
            {
                int intValue = (int)value;

                lengthOfValue = Integer.toString(intValue).length();

                if(lengthOfValue <= 4)
                {
                    text = new Text(this, Integer.toString(intValue),
                            new Point((0.03+((1-lengthOfValue)*0.01))*width, i-0.06*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSizeVertical, new Color(0,0,0));
                    text.draw();
                }
                else
                {
                    text = new Text(this, Integer.toString(intValue),
                            new Point(0.0*width, i-0.06*height),
                            new Point(0.039*width,i+0.06*height), (int)valueFontSizeVertical, new Color(0,0,0));
                    text.draw();
                }
            }

            value += valuesSpike;

//            Line helpLine = new Line(this, new Point((0.03+((1-lengthOfValue)*0.01))*width ,i-0.06*height),
//                    new Point(0.039*width,i+0.06*height));
//            helpLine.draw();
        }
    }

    private void drawVerticalColumns()
    {
        Rectangle column;
        Text text;
        double intervalWidthUp = 0;
        double intervalWidthDown = 0;
        double columnLength = 0;

        for(int i = 0; i < data.size(); i++)
        {
            columnLength = (data.get(i).getData()-minDataValues)/(maxDataValues-minDataValues) * ((0.95*height)-maxAxisHeight);
            intervalWidthUp = 0.05*width + (((maxAxisWidth-0.05*width) / data.size()) * i);
            intervalWidthDown = 0.05*width + (((maxAxisWidth-0.05*width) / data.size()) * (i+1));

            column = new Rectangle(this,
                    new Point(intervalWidthUp + 0.01*width*horizontalAxisRatio, 0.95*height - columnLength),
                    new Point(intervalWidthDown - 0.01*width*horizontalAxisRatio ,0.95*height),
                    data.get(i).getColor());
            column.draw();

            text = new Text(this, Integer.toString(i+1),
                    new Point(intervalWidthUp + 0.01*width + ((((maxAxisWidth-0.05*width) / data.size())-0.02*width) / 2 - 0.005*width),0.951*height),
                    new Point(intervalWidthDown - 0.01*width - ((((maxAxisWidth-0.05*width) / data.size())-0.02*width) / 2 - 0.015*width),0.99*height),
                    (int)valueFontSizeVertical,
                    ColorsPalette.Black);
            text.draw();

//            Rectangle rectangle = new Rectangle(this,
//                    new Point(intervalWidthUp + 0.01*width + ((((maxAxisWidth-0.05*width) / data.size())-0.02*width) / 2 - 0.005*width),0.951*height),
//                    new Point(intervalWidthDown - 0.01*width - ((((maxAxisWidth-0.05*width) / data.size())-0.02*width) / 2 - 0.015*width),0.99*height));
//            rectangle.draw();
        }
    }
}
