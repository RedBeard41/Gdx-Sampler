package com.sampler.common;

import com.sampler.ApplicationListenerSample;
import com.sampler.AssetManagerSample;
import com.sampler.BitmapFontSample;
import com.sampler.GdxGeneratedSample;
import com.sampler.GdxModuleInfoSample;
import com.sampler.GdxReflectionSample;
import com.sampler.InputListeningSample;
import com.sampler.InputPollingSample;
import com.sampler.OrthographicCameraSample;
import com.sampler.PoolingSample;
import com.sampler.ShapeRendererSample;
import com.sampler.SpriteBatchSample;
import com.sampler.TextureAtlasSample;
import com.sampler.ViewportSample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SampleInfos {

    public static final List<SampleInfo> ALL = Arrays.asList(
            ApplicationListenerSample.SAMPLE_INFO,
            GdxGeneratedSample.SAMPLE_INFO,
            GdxModuleInfoSample.SAMPLE_INFO,
            GdxReflectionSample.SAMPLE_INFO,
            InputListeningSample.SAMPLE_INFO,
            InputPollingSample.SAMPLE_INFO,
            OrthographicCameraSample.SAMPLE_INFO,
            ViewportSample.SAMPLE_INFO,
            SpriteBatchSample.SAMPLE_INFO,
            ShapeRendererSample.SAMPLE_INFO,
            BitmapFontSample.SAMPLE_INFO,
            PoolingSample.SAMPLE_INFO,
            AssetManagerSample.SAMPLE_INFO,
            TextureAtlasSample.SAMPLE_INFO

    );

    public static List<String> getSampleNames(){
        List<String> returnedList = new ArrayList();

        for(SampleInfo infor: ALL){
            returnedList.add(infor.getName());
        }

        Collections.sort(returnedList);
        return returnedList;
    }

    public static SampleInfo find(String name){

        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("name argument is required.");
        }

        SampleInfo tempSampleInfo = null;

        for(SampleInfo info: ALL){

            //IMPORTANT
            // == operator compares references not string content
            // equals method compares objects for equality in case of strings that are content
            if(info.getName().equals(name)){
                tempSampleInfo = info;
                break;
            }
        }

        if(tempSampleInfo == null){
            throw new IllegalArgumentException("Could not find sample with name: "+ name);
        }

        return tempSampleInfo;
    }

    private SampleInfos() {
    }
}
