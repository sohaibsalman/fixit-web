package com.fixit.fixer;

public class WorkInfo 
{
	//Work Info
	private String serviceCategory;
	private String serviceName;
	private String city;
    private String workArea;
	private String workAddress;

    public WorkInfo(String serviceCategory, String serviceName, String city, String workArea, String workAddress)
    {
        this.serviceCategory = serviceCategory;
        this.serviceName = serviceName;
        this.city = city;
        this.workArea = workArea;
        this.workAddress = workAddress;
    }

    public String getServiceCategory()
    {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory)
    {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getWorkArea()
    {
        return workArea;
    }

    public void setWorkArea(String workArea)
    {
        this.workArea = workArea;
    }

    public String getWorkAddress()
    {
        return workAddress;
    }

    public void setWorkAddress(String workAddress)
    {
        this.workAddress = workAddress;
    }
}
