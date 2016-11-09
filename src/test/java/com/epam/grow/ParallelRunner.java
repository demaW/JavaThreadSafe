package com.epam.grow;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

import static com.epam.grow.AppTest.countries;

public class ParallelRunner {



    @Test
    public void runTestsInParalel(){
        Class<?>[] classes = {AppTest.class};
        JUnitCore.runClasses(ParallelComputer.methods(), classes);
    }

    @After
    public void tearDown(){
        System.out.println("Size of collection is " + countries.size());
    }
}
