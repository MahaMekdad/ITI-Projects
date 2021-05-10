package org.example.web.services;

import org.example.entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;


//gave me the exception cus the updateEmp method takes 2 parameters
// @SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.BARE)

//exception parameterStyle can only be WRAPPED with RPC
//Incorrect usage of Annotation @jakarta.jws.soap.SOAPBinding(parameterStyle=BARE, use=LITERAL, style=RPC) 
//on interface org.example.web.services.EmployeeService, ParameterStyle can only be WRAPPED with RPC Style Web service.
// @SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.BARE)


// @SOAPBinding(style = Style.RPC, use = Use.ENCODED)

@WebService(name = "EmpServicePortType", portName = "LOLPortInServiceElement", 
            serviceName = "MahaInTheServiceNameInServiceTag")
//RPC and going to change the web service name (EmployeeService Class) to MahaEmpService in portType tag
//doesn't work untill specified in the implementation class itself
@SOAPBinding(style = Style.RPC)
public interface EmployeeService {

    @WebMethod
    Employee addEmp(@WebParam(name = "name of Part As No WebParam.partName specified")Employee emp);

    @WebMethod(exclude = true)
    Employee updateEmp(Employee emp, int id);

    @WebMethod
    @WebResult(name = "THE RESULT?", partName = "is specified so the WebResult is ignored")
    Employee deleteEmp(@WebParam(partName = "part name is specified: delete emp")int id);
    
    @WebMethod
    @WebResult(header = true)
    Employee getEmp(int id);
}
