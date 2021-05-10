package org.example.models;

public class CompoundClass {
    TestClass testClass;

    public void setTestClass(TestClass tc){
        System.out.println("inside the setter of the setTestClass() of CompoundClass");
        testClass = tc;
    }

    public TestClass getTestClass(){
        System.out.println("inside the getter of the setTestClass() of CompoundClass");
        return this.testClass;
    }
}
