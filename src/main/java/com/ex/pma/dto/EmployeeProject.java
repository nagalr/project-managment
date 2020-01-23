package com.ex.pma.dto; // data transfer object

public interface EmployeeProject {

    // Need to have the property name begin with 'get'
    public String getFirstName(); // 'get' added since Spring data will look for 'get'
    public String getLastName();
    public int getProjectCount();
}
