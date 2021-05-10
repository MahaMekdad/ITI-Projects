package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestClass {

    private String st;
    private List<String> stList;
    private List list;
    private Set addressSet;
    private Map addressMap;
    private Properties addressProp;

    // public TestClass(){
    // System.out.println("hello from the TestClass constructor");
    // System.out.println("***");
    // }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
     }
     
     public Properties getAddressProp() {
        System.out.println("Property Elements :"  + addressProp);
        return addressProp;
     }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
     }
     
     public Map getAddressMap() {
        System.out.println("Map Elements :"  + addressMap);
        return addressMap;
     }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public Set getAddressSet() {
        System.out.println("Set Elements :" + addressSet);
        return addressSet;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getSt() {
        System.out.println("String Property :"  + st);
        return this.st;
    }

    public List<String> getStList() {
        System.out.println("List<String> Elements :"  + stList);
        return this.stList;
    }

    public void setStList(List<String> stList) {
        this.stList = stList;
    }

    public List getList() {
        System.out.println("List<> Elements :"  + list);
        return this.list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void testMethod() {
        System.out.println("hey from the test method that does nothing");
    }
}
