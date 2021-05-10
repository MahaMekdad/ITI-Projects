package org.example.apis.exceptions;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

    private String errorMessage;
    private int errorCode;
    private String errorDescription;

    public String getErrorMessage(){
        return errorMessage;
    }

    public int getErrorCode(){
        return errorCode;
    }

    public String getErrorDescription(){
        return errorDescription;
    }

    public void setErrorMessage(String em){
        this.errorMessage = em;
    }

    public void setErrorCode(int ec){
        this.errorCode = ec;
    }

    public void setErrorDescription(String ed){
        this.errorDescription = ed;
    }
    
}
