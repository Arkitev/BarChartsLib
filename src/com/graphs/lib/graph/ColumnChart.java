package com.graphs.lib.graph;

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

    protected double columnsWidth = 25; //TODO: think about proper axis scalling
    protected double columnsGapsWidth = 3; //TODO: think about proper axis scalling
    //numbers of items from every list must be the same
    protected List<Rectangle> columns = new ArrayList<>();
    protected List<Text> columnsLabels = new ArrayList<>();
    protected List<Text> columnsValues = new ArrayList<>();

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
        this.valueFontSize = valueFontSize * horizontalAxisRatio + 10*(1.0-horizontalAxisRatio);
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

    public ColumnChart(int width, int height)
    {
        super(width, height);
    }

    public ColumnChart()
    {
        this.width = 900;
        this.height = 600;
    }

    @Override
    public void draw()
    {
        drawEmptyChart();
        drawTitle();
    }

    public void drawEmptyChart()
    {
        drawVerticalGraphLine();
        drawHorizontalGraphLine();
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
