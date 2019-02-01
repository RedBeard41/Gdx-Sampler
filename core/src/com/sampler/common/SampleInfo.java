package com.sampler.common;

public class SampleInfo {

    private final String name;
    private final Class<?> clazz;

    public SampleInfo(Class<? extends SampleBase> clazz) {
        this.clazz = clazz;
        name = clazz.getSimpleName();
    }

    public String getName() {
        return name;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
