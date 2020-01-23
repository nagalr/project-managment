package com.ex.pma.dto;

public interface ChartData {

    // 'get' added since Spring data will look for 'get'
    public String getLabel();
    public Long getValue();
}
