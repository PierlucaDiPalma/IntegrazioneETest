package com.example.integrazioneetest;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Report;
import net.jqwik.api.Reporting;

import net.jqwik.api.statistics.Statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateTest {

    @Property
    @Report(Reporting.GENERATED)
    void calculateDistance(@ForAll double x1, @ForAll double y1, @ForAll double x2, @ForAll double y2) {
        double distance = Coordinate.calculateDistance(x1, y1, x2, y2);
        double expectedDistance = calculateExpectedDistance(x1, y1, x2, y2);
        assertEquals(expectedDistance, distance); // Tolleranza per errori di arrotondamento

        Statistics.collect(x1, y1, x2, y2);
    }

    private double calculateExpectedDistance(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}