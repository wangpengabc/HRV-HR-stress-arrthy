import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import hrv.calc.parameter.HRVParameter;
import hrv.calc.parameter.HRVParameterEnum;
//import units.TimeUnit;
import hrv.RRData;
import hrv.HRVLibFacade;

public class test {

    public static void main(String[] args) throws Exception {
        String data_save_dir = "/home/wangpeng/TSC/fundmental_calc/data";
        String ecg_data_name = "RR1_Cleaned";

        // calculate parameters and save to $(ecg_data_name).properties file
        List<HRVParameter> result = HRHRVStressArrhy.calcParames(data_save_dir, ecg_data_name);

        Iterator result_iterator = result.iterator();

        while(result_iterator.hasNext()){
            HRVParameter param_temp = (HRVParameter)result_iterator.next();
            System.out.println("name:" + param_temp.getName());
            System.out.println("value:" + param_temp.getValue());
            System.out.println("unit:" + param_temp.getUnit());
        }

        // load parameters file, example
        String parameters_save_name = data_save_dir + "/" + ecg_data_name + "_paramters.properties";
        Map<String, Double> parameters_map = HRHRVStressArrhy.loadFromFile(parameters_save_name);
        for (String key : parameters_map.keySet()) {
            Double value = parameters_map.get(key);
            System.out.println(key + " = " + value);
        }



    }
}


////package model;
//
//import org.junit.Test;
//
//import hrv.RRData;
////import HRVCalculatorFacade;
//import hrv.calc.psd.PowerSpectrum;
//import hrv.calc.psd.StandardPowerSpectralDensityEstimator;
//import units.TimeUnit;
//
//import static junit.framework.Assert.assertEquals;
//import static junit.framework.Assert.assertNotNull;
//
///**
// * Copyright (c) 2017
// * Created by Julian on 22.02.2017.
// */
//public class HRVCalculatorFacadeTest {
//
//    @Test
//    public void testCalculation() {
//        double sinHz = 1; //Frequency of the sin function
//        int sampleFrequency = 8; //Sample Frequency in Hz
//        double xLength = 2; //Length of the data.
//        double[] sinY = generateSinArray(xLength, sampleFrequency, sinHz);
//
//        //Generate X-Axis
//        double[] sinX = new double[sinY.length];
//        for(int i = 0; i < sinX.length; i++) {
//            sinX[i] = i * (1.0 / sampleFrequency);
//        }
//
//        RRData rr = new RRData(sinX, TimeUnit.SECOND, sinY, TimeUnit.SECOND);
//
//        HRVCalculatorFacade controller = new HRVCalculatorFacade(rr);
//        assertNotNull(controller.getBaevsky());
//        assertNotNull(controller.getHF());
//        assertNotNull(controller.getLF());
//        assertNotNull(controller.getMean());
//        assertNotNull(controller.getNN50());
//        assertNotNull(controller.getPNN50());
//        assertNotNull(controller.getRMSSD());
//        assertNotNull(controller.getSD1());
//        assertNotNull(controller.getSD2());
//        assertNotNull(controller.getSD1SD2());
//        assertNotNull(controller.getSDNN());
//        assertNotNull(controller.getSDSD());
//
//        StandardPowerSpectralDensityEstimator estimator = new StandardPowerSpectralDensityEstimator();
//        PowerSpectrum ps = estimator.calculateEstimate(rr);
//        assertNotNull(ps);
//
//        double[] freqResult = ps.getFrequency();
//        double[] powerResult = ps.getPower();
//
//        assertEquals(16, freqResult.length);
//        assertEquals(0.0, freqResult[0], 0.0001);
//        assertEquals(1.0, freqResult[2], 0.0001);
//
//        assertEquals(16, powerResult.length);
//        assertEquals(0.0, powerResult[0], 0.001);
//        assertEquals(1.0, powerResult[2], 0.001);
//        assertEquals(1.0, powerResult[14], 0.001);
//    }
//
//    private double[] generateSinArray(double xMax, int sampleFrequency, double sinHz) {
//        double[] sin = new double[(int)xMax * sampleFrequency];
//
//        for(int i = 0; i < sin.length; i++) {
//            sin[i] = Math.sin(2 * Math.PI * sinHz * i * (1.0 / sampleFrequency));
//        }
//
//        return sin;
//    }
//}
