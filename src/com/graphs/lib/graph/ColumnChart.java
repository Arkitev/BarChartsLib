package com.graphs.lib.graph;

import com.graphs.lib.graph.data.Data;
import com.graphs.lib.graph.element.*;

import java.util.ArrayList;
import java.util.List;

abstract class ColumnChart extends Graph
{
    protected double verticalAxisRatio = 1; // can not be bigger than 1
    protected double horizontalAxisRatio = 1; // can not be bigger than 1
    protected double maxAxisHeight = height-(verticalAxisRatio*0.85*height + 0.05*height); //72 dla 720 height
    protected double maxAxisWidth = horizontalAxisRatio*0.85*width + 0.05*width; //1152 dla 1280 width

    protected int separatorsAmount = 5;
    protected double minVerticalSeparatorsLength = horizontalAxisRatio*0.94*height;
    protected double maxVerticalSeparatorsLength = horizontalAxisRatio*0.96*height;
    protected double minHorizontalSeparatorsLength = verticalAxisRatio*0.04*width;
    protected double maxHorizontalSeparatorsLength = verticalAxisRatio*0.06*width;
    protected double minDataValues = 0; // can not be less than the smallest value of columnsValues List
    protected double maxDataValues = 1000; // can not be bigger than the biggest value of columnsValues List
    protected double valuesSpike = (maxDataValues-minDataValues) / (separatorsAmount-1);
    protected double valueFontSize = 20;
    protected int roundValue = 2;
    protected boolean enableLongSeparators = false;

    protected List<Data> data = new ArrayList();

    public ColumnChart(int width, int height)
    {
        super(width, height);
    }

    public ColumnChart()
    {
        this.width = 800;
        this.height = 600;
    }

    public void setVerticalAxisRatio(double verticalAxisRatio)
    {
        this.verticalAxisRatio = verticalAxisRatio;
        this.maxAxisHeight = height-(verticalAxisRatio*0.85*height + 0.05*height);
        this.minHorizontalSeparatorsLength = ((0.01-(verticalAxisRatio/100))+0.04)*width;
        this.maxHorizontalSeparatorsLength = (0.06-(0.01-(verticalAxisRatio/100)))*width;
        this.valueFontSize = valueFontSize * verticalAxisRatio + 10*(1.0-verticalAxisRatio);
    }

    public void setHorizontalAxisRatio(double horizontalAxisRatio )
    {
        this.horizontalAxisRatio = horizontalAxisRatio;
        this.maxAxisWidth = horizontalAxisRatio*0.85*width + 0.05*width;
        this.minVerticalSeparatorsLength = ((0.01-(horizontalAxisRatio/100))+0.94)*height;
        this.maxVerticalSeparatorsLength = (0.96-(0.01-(horizontalAxisRatio/100)))*height;
        this.valueFontSize = (valueFontSize * horizontalAxisRatio + 10*(1.0-horizontalAxisRatio)) / (1920.0/width);
    }

    public void setSeparatorsAmount(int separatorsAmount)
    {
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
        this.roundValue = roundValue;
    }

    public void enableLongSeparators(boolean enableLongSeparators) { this.enableLongSeparators = enableLongSeparators; }

    public void insertData(String label, double data, Color color)
    {
        Data barData = new Data(label, data, color);
        this.data.add(barData);
    }

    @Override
    public void draw() {}

    public void drawEmptyChart()
    {
        drawVerticalGraphLine();
        drawHorizontalGraphLine();
        drawTitle();
    }

    private void drawVerticalGraphLine()
    {
        Line line = new Line(this, new Point(0.05*width, 0.95*height), //(36,684)
                new Point(0.05*width, maxAxisHeight)); //(36,72)
        line.draw();
    }

    private void drawHorizontalGraphLine()
    {
        Line line = new Line(this, new Point(0.05*width, 0.95*height), //(36,684)
                new Point(maxAxisWidth, 0.95*height)); //(1152,684)
        line.draw();
    }
}
