package com.graphs.lib.graph;

import com.graphs.lib.graph.data.Data;
import com.graphs.lib.graph.element.*;
import com.graphs.lib.graph.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.List;

abstract class ColumnChart extends Graph
{
    protected double verticalAxisRatio = 0.9;
    protected double horizontalAxisRatio = 0.9;
    protected double maxAxisHeight = height-(verticalAxisRatio*0.85*height + 0.05*height);
    protected double maxAxisWidth = horizontalAxisRatio*0.85*width + 0.05*width;
    protected int separatorsAmount = 5;
    protected double minVerticalSeparatorsLength = 0.94*height;
    protected double maxVerticalSeparatorsLength = 0.96*height;
    protected double minHorizontalSeparatorsLength = 0.04*width;
    protected double maxHorizontalSeparatorsLength = 0.06*width;
    protected double minDataValues = 0;
    protected double maxDataValues = 1000;
    protected double valuesSpike = (maxDataValues-minDataValues) / (separatorsAmount-1);
    protected double valueFontSizeVertical = 20;
    protected double valueFontSizeHorizontal = 20;
    protected int roundValue = 2;
    protected boolean enableLongSeparators = false;
    protected List<Data> data = new ArrayList();

    public ColumnChart(int width, int height)
    {
        super(width, height);
    }

    public ColumnChart()
    {
        this.width = 1600;
        this.height = 900;
    }

    public void setVerticalAxisRatio(double verticalAxisRatio)
    {
        if(verticalAxisRatio > 1 || verticalAxisRatio < 0)
            throw new InvalidValueException("Vertical ratio must be between 0 and 1.");
        this.verticalAxisRatio = verticalAxisRatio;
        this.maxAxisHeight = height-(verticalAxisRatio*0.85*height + 0.05*height);
        this.minHorizontalSeparatorsLength = ((0.01-(verticalAxisRatio/100))+0.04)*width;
        this.maxHorizontalSeparatorsLength = (0.06-(0.01-(verticalAxisRatio/100)))*width;
        this.valueFontSizeVertical = valueFontSizeVertical * verticalAxisRatio + 10*(1.0-verticalAxisRatio);
    }

    public void setHorizontalAxisRatio(double horizontalAxisRatio)
    {
        if(horizontalAxisRatio > 1 || horizontalAxisRatio < 0)
            throw new InvalidValueException("Horizontal ratio must be between 0 and 1.");
        this.horizontalAxisRatio = horizontalAxisRatio;
        this.maxAxisWidth = horizontalAxisRatio*0.85*width + 0.05*width;
        this.minVerticalSeparatorsLength = ((0.01-(horizontalAxisRatio/100))+0.94)*height;
        this.maxVerticalSeparatorsLength = (0.96-(0.01-(horizontalAxisRatio/100)))*height;
        this.valueFontSizeHorizontal = (valueFontSizeHorizontal * horizontalAxisRatio + 10*(1.0-horizontalAxisRatio)) / (1920.0/width);
    }

    public void setSeparatorsAmount(int separatorsAmount)
    {
        if(separatorsAmount < 2)
            throw new InvalidValueException("Separators amount can not be less than 2.");
        this.separatorsAmount = separatorsAmount;
    }

    public void setMinDataValues(double minDataValues) { this.minDataValues = minDataValues; }

    public void setMaxDataValues(double maxDataValues)
    {
        this.maxDataValues = maxDataValues;
        this.valuesSpike = (maxDataValues-minDataValues) / (separatorsAmount-1);
    }

    public void setRoundValue(int roundValue)
    {
        if(roundValue < 0)
            throw new InvalidValueException("Round value can not be less than 0.");
        this.roundValue = roundValue;
    }

    public void enableLongSeparators(boolean enableLongSeparators) { this.enableLongSeparators = enableLongSeparators; }

    public void insertData(String label, double data, Color color)
    {
        Data barData = new Data(label, data, color);
        this.data.add(barData);
    }

    public void drawEmptyChart()
    {
        drawVerticalGraphLine();
        drawHorizontalGraphLine();
        drawLegend();
        drawTitle();
    }

    private void drawVerticalGraphLine()
    {
        Line line = new Line(this, new Point(0.05*width, 0.95*height),
                new Point(0.05*width, maxAxisHeight));
        line.draw();
    }

    private void drawHorizontalGraphLine()
    {
        Line line = new Line(this, new Point(0.05*width, 0.95*height),
                new Point(maxAxisWidth, 0.95*height));
        line.draw();
    }

    private void drawLegend()
    {
        Rectangle legendRectangle;
        Text numberOfItem;
        Text legendLabel;

        for(int i = 0; i < data.size(); i++)
        {
            double legendRectangleHeight = (maxAxisHeight + ((((0.95*height)-maxAxisHeight) / data.size()) * i));
            double legendRectangleWidth = maxAxisWidth + 0.01*width*horizontalAxisRatio;

            legendRectangle = new Rectangle(this,
                    new Point(legendRectangleWidth, legendRectangleHeight),
                    new Point(legendRectangleWidth + 0.03*width*horizontalAxisRatio, legendRectangleHeight + 0.03*height*verticalAxisRatio),
                    data.get(i).getColor());
            legendRectangle.draw();

            numberOfItem = new Text(this,
                    Integer.toString(i+1),
                    new Point(legendRectangleWidth, legendRectangleHeight-0.01*height*verticalAxisRatio),
                    new Point(legendRectangleWidth + 0.04*width*horizontalAxisRatio, legendRectangleHeight + 0.04*height*verticalAxisRatio),
                    (int)(20*verticalAxisRatio),
                    ColorsPalette.Black);
            numberOfItem.draw();

            legendLabel = new Text(this,
                    data.get(i).getLabel(),
                    new Point(legendRectangleWidth + 0.03*width*horizontalAxisRatio +0.01*width*horizontalAxisRatio, legendRectangleHeight-0.01*height*verticalAxisRatio),
                    new Point(width, legendRectangleHeight + 0.04*height*verticalAxisRatio),
                    (int)(20*verticalAxisRatio),
                    ColorsPalette.Black);
            legendLabel.draw();
        }
    }
}
