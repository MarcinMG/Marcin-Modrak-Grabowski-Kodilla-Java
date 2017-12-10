package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
   // private Shape shape;
    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        figures.add(shape);
    }
    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figures.contains(shape)) {
            figures.remove(shape);
            result = true;
        }
        return result;
    }
    public Shape getFigure(int n){
        Shape theFigure = null;
        if( n>=0 && n<figures.size() ) {
            theFigure = figures.get(n);
        }
        return theFigure;
    }
    public ArrayList<Shape> showFigures() {
        ArrayList<Shape> theFigures = new ArrayList<Shape>();
        for(Shape tempFigures : figures) {
            theFigures.add(tempFigures);
        }
        return theFigures;
    }
    public int getFiguresQuantity(){
        return figures.size();
    }
}
