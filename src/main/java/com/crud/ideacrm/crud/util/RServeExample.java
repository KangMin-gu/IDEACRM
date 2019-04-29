package com.crud.ideacrm.crud.util;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Component;


public class RServeExample {
/*
    private RConnection c = null;

    public RServeExample() throws RserveException {
        c = new RConnection();
    }

    public REXP getRVersion() throws RserveException, REXPMismatchException {
        REXP x = c.eval("R.version.string");
        System.out.println("R version : " + x.asString());
        return x;
    }

    private double[] getDoubles() throws RserveException, REXPMismatchException {
        REXP x = c.eval("rnorm(100)");
        double[] d = x.asDoubles();

        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
        return d;
    }

    public double[] assignJ2R() throws REngineException, REXPMismatchException {
        double[] dataX = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        double[] dataY = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        c.assign("x", dataX);
        c.assign("y", dataY);

        double[] d = c.eval("x+y").asDoubles();

        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }

        return d;
    }

    public static void main(String[] args) throws REXPMismatchException, REngineException {

        RServeExample RServeExample = new RServeExample();

        System.out.println("------------버젼 가져오기--------------");
        RServeExample.getRVersion();
        System.out.println("------------난수 100개 가져오기-------------");
        RServeExample.getDoubles();
        System.out.println("------------데이터 할당 및 결과 출력-------------");
        RServeExample.assignJ2R();

    }
*/
}
