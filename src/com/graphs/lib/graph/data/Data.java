package com.graphs.lib.graph.data;

import com.graphs.lib.graph.element.Color;

public class Data
{
    private double data;
    private String label;
    private Color color;

    public Data() {}

    public Data(String label, double data, Color color)
    {
        this.data = data;
        this.label = label;
        this.color = color;
    }

    public String getLabel() { return label; }

    public void setLabel(String Label) { this.label = label; }

    public double getData() { return data; }

    public void setData(double data) { this.data = data; }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }
}
