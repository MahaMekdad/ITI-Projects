
package org.example.services.employeeService;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.services.employeeService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddEmp_QNAME = new QName("http://services.web.example.org/", "addEmp");
    private final static QName _AddEmpResponse_QNAME = new QName("http://services.web.example.org/", "addEmpResponse");
    private final static QName _DeleteEmp_QNAME = new QName("http://services.web.example.org/", "deleteEmp");
    private final static QName _DeleteEmpResponse_QNAME = new QName("http://services.web.example.org/", "deleteEmpResponse");
    private final static QName _GetEmp_QNAME = new QName("http://services.web.example.org/", "getEmp");
    private final static QName _GetEmpResponse_QNAME = new QName("http://services.web.example.org/", "getEmpResponse");
    private final static QName _UpdateEmp_QNAME = new QName("http://services.web.example.org/", "updateEmp");
    private final static QName _UpdateEmpResponse_QNAME = new QName("http://services.web.example.org/", "updateEmpResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.services.employeeService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddEmp }
     * 
     */
    public AddEmp createAddEmp() {
        return new AddEmp();
    }

    /**
     * Create an instance of {@link AddEmpResponse }
     * 
     */
    public AddEmpResponse createAddEmpResponse() {
        return new AddEmpResponse();
    }

    /**
     * Create an instance of {@link DeleteEmp }
     * 
     */
    public DeleteEmp createDeleteEmp() {
        return new DeleteEmp();
    }

    /**
     * Create an instance of {@link DeleteEmpResponse }
     * 
     */
    public DeleteEmpResponse createDeleteEmpResponse() {
        return new DeleteEmpResponse();
    }

    /**
     * Create an instance of {@link GetEmp }
     * 
     */
    public GetEmp createGetEmp() {
        return new GetEmp();
    }

    /**
     * Create an instance of {@link GetEmpResponse }
     * 
     */
    public GetEmpResponse createGetEmpResponse() {
        return new GetEmpResponse();
    }

    /**
     * Create an instance of {@link UpdateEmp }
     * 
     */
    public UpdateEmp createUpdateEmp() {
        return new UpdateEmp();
    }

    /**
     * Create an instance of {@link UpdateEmpResponse }
     * 
     */
    public UpdateEmpResponse createUpdateEmpResponse() {
        return new UpdateEmpResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddEmp }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "addEmp")
    public JAXBElement<AddEmp> createAddEmp(AddEmp value) {
        return new JAXBElement<AddEmp>(_AddEmp_QNAME, AddEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmpResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddEmpResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "addEmpResponse")
    public JAXBElement<AddEmpResponse> createAddEmpResponse(AddEmpResponse value) {
        return new JAXBElement<AddEmpResponse>(_AddEmpResponse_QNAME, AddEmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmp }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "deleteEmp")
    public JAXBElement<DeleteEmp> createDeleteEmp(DeleteEmp value) {
        return new JAXBElement<DeleteEmp>(_DeleteEmp_QNAME, DeleteEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmpResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteEmpResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "deleteEmpResponse")
    public JAXBElement<DeleteEmpResponse> createDeleteEmpResponse(DeleteEmpResponse value) {
        return new JAXBElement<DeleteEmpResponse>(_DeleteEmpResponse_QNAME, DeleteEmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmp }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "getEmp")
    public JAXBElement<GetEmp> createGetEmp(GetEmp value) {
        return new JAXBElement<GetEmp>(_GetEmp_QNAME, GetEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmpResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "getEmpResponse")
    public JAXBElement<GetEmpResponse> createGetEmpResponse(GetEmpResponse value) {
        return new JAXBElement<GetEmpResponse>(_GetEmpResponse_QNAME, GetEmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEmp }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "updateEmp")
    public JAXBElement<UpdateEmp> createUpdateEmp(UpdateEmp value) {
        return new JAXBElement<UpdateEmp>(_UpdateEmp_QNAME, UpdateEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmpResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateEmpResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://services.web.example.org/", name = "updateEmpResponse")
    public JAXBElement<UpdateEmpResponse> createUpdateEmpResponse(UpdateEmpResponse value) {
        return new JAXBElement<UpdateEmpResponse>(_UpdateEmpResponse_QNAME, UpdateEmpResponse.class, null, value);
    }

}
