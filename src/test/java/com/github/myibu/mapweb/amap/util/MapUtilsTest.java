package com.github.myibu.mapweb.amap.util;

import com.github.myibu.mapweb.common.entity.GpsLocation;
import com.github.myibu.mapweb.util.MapUtils;
import org.junit.Assert;
import org.junit.Test;

public class MapUtilsTest {
    @Test
    public void testCalculateKMDistanceBetweenTwoGps() {
        double kmDistance = MapUtils.calculateKMDistanceBetweenTwoGps(new GpsLocation(22.530079, 113.950564), new GpsLocation(22.530948,  113.947707));
        Assert.assertEquals(kmDistance, 0.3093, 0);
    }
}
