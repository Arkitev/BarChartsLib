package com.graphs.lib.graph;

import com.graphs.lib.graph.element.*;
import com.graphs.lib.graph.exceptions.InvalidWindowSizeException;
import com.graphs.lib.graph.exceptions.WindowException;
import processing.core.PApplet;

import java.io.File;

abstract class Graph extends PApplet {

    private GraphTitle title = new GraphTitle(this, "no title", 24, Text.Align.TOP, Text.Align.CENTER, ColorsPalette.Black);
    private Boolean isDrawingStarted = false;
    private Boolean isSaveEnabled = false;
    private Boolean isSaveWithoutDrawingEnabled = false;
    private String fileName = "";
    private FileExtension fileExtension;


    Graph()
    {
        this.width = 1600;
        this.height = 900;
    }
    Graph(int width, int height) throws InvalidWindowSizeException
    {
        if(width < 800 || height < 600)
            throw new InvalidWindowSizeException();
        this.width = width;
        this.height = height;
    }

//    public void run() {
//        PApplet.runSketch(new String[] {Graph.class.getName()},this);
//    }

    protected abstract void createChart();

    public void settings(){}

    public void setup()
    {
        surface.setResizable(false);

        if(isSaveEnabled && fileExtension == fileExtension.PDF)
        {
            String file = this.fileName + ".pdf";
            beginRecord(PDF, file);
        }
    }

    public void show()
    {
        if(isDrawingStarted)
            throw new WindowException("Only one window can be showed.");
        else
        {
            isDrawingStarted = true;
            PApplet.runSketch(new String[] {Graph.class.getName()},this);
        }
    }

    public void draw()
    {
        try
        {
            createChart();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if(isSaveEnabled && fileExtension != FileExtension.PDF)
        {
            String file = fileName + "." + fileExtension.getValue();
            save(file);
        }
        else if(isSaveEnabled)
            endRecord();
        if(isSaveWithoutDrawingEnabled)
            exit();
    }

    public void setSaving(String fileName, FileExtension fileExtension)
    {
        if(isDrawingStarted)
            throw new WindowException("Cannot save after show method. Call this method before method show().");

        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.isSaveEnabled = true;
    }

    public void setSavingWithoutDrawing(String fileName, FileExtension fileExtension)
    {
        setSaving(fileName, fileExtension);
        isSaveWithoutDrawingEnabled = true;
        show();
    }

    public void setTitle(String title, float fontsize, Text.Align vAlign, Text.Align hAlign, Color color){
        setTitle(title);
        setTitleFontSize(fontsize);
        setTitleVAlign(vAlign);
        setTitleHAlign(hAlign);
        setTitleColor(color);
    }

    public void setTitle(String title){ this.title.setTitle(title); }
    public void setTitleColor(Color color){
        this.title.setColor(color);
    }
    public void setTitleFontSize(float fontSize){
        this.title.setFontsize(fontSize);
    }
    public void setTitleVAlign(Text.Align vAlign){
        this.title.setvAlign(vAlign);
    }
    public void setTitleHAlign(Text.Align hAlign){
        this.title.sethAlign(hAlign);
    }

    void drawTitle() { title.draw(); }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
