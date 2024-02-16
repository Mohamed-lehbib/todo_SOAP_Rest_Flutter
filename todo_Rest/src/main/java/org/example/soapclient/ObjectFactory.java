
package org.example.soapclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.soapclient package. 
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

    private final static QName _GetTodoByIdResponse_QNAME = new QName("http://service.example.org/", "getTodoByIdResponse");
    private final static QName _UpdateTodoStatusResponse_QNAME = new QName("http://service.example.org/", "updateTodoStatusResponse");
    private final static QName _UpdateTodo_QNAME = new QName("http://service.example.org/", "updateTodo");
    private final static QName _GetAllTodosResponse_QNAME = new QName("http://service.example.org/", "getAllTodosResponse");
    private final static QName _DeleteTodoResponse_QNAME = new QName("http://service.example.org/", "deleteTodoResponse");
    private final static QName _AddTodoResponse_QNAME = new QName("http://service.example.org/", "addTodoResponse");
    private final static QName _GetAllTodos_QNAME = new QName("http://service.example.org/", "getAllTodos");
    private final static QName _AddTodo_QNAME = new QName("http://service.example.org/", "addTodo");
    private final static QName _UpdateTodoResponse_QNAME = new QName("http://service.example.org/", "updateTodoResponse");
    private final static QName _DeleteTodo_QNAME = new QName("http://service.example.org/", "deleteTodo");
    private final static QName _UpdateTodoStatus_QNAME = new QName("http://service.example.org/", "updateTodoStatus");
    private final static QName _GetTodoById_QNAME = new QName("http://service.example.org/", "getTodoById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.soapclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllTodosResponse }
     * 
     */
    public GetAllTodosResponse createGetAllTodosResponse() {
        return new GetAllTodosResponse();
    }

    /**
     * Create an instance of {@link UpdateTodo }
     * 
     */
    public UpdateTodo createUpdateTodo() {
        return new UpdateTodo();
    }

    /**
     * Create an instance of {@link GetTodoByIdResponse }
     * 
     */
    public GetTodoByIdResponse createGetTodoByIdResponse() {
        return new GetTodoByIdResponse();
    }

    /**
     * Create an instance of {@link UpdateTodoStatusResponse }
     * 
     */
    public UpdateTodoStatusResponse createUpdateTodoStatusResponse() {
        return new UpdateTodoStatusResponse();
    }

    /**
     * Create an instance of {@link GetTodoById }
     * 
     */
    public GetTodoById createGetTodoById() {
        return new GetTodoById();
    }

    /**
     * Create an instance of {@link UpdateTodoStatus }
     * 
     */
    public UpdateTodoStatus createUpdateTodoStatus() {
        return new UpdateTodoStatus();
    }

    /**
     * Create an instance of {@link DeleteTodo }
     * 
     */
    public DeleteTodo createDeleteTodo() {
        return new DeleteTodo();
    }

    /**
     * Create an instance of {@link AddTodo }
     * 
     */
    public AddTodo createAddTodo() {
        return new AddTodo();
    }

    /**
     * Create an instance of {@link UpdateTodoResponse }
     * 
     */
    public UpdateTodoResponse createUpdateTodoResponse() {
        return new UpdateTodoResponse();
    }

    /**
     * Create an instance of {@link AddTodoResponse }
     * 
     */
    public AddTodoResponse createAddTodoResponse() {
        return new AddTodoResponse();
    }

    /**
     * Create an instance of {@link GetAllTodos }
     * 
     */
    public GetAllTodos createGetAllTodos() {
        return new GetAllTodos();
    }

    /**
     * Create an instance of {@link DeleteTodoResponse }
     * 
     */
    public DeleteTodoResponse createDeleteTodoResponse() {
        return new DeleteTodoResponse();
    }

    /**
     * Create an instance of {@link Todo }
     * 
     */
    public Todo createTodo() {
        return new Todo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTodoByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "getTodoByIdResponse")
    public JAXBElement<GetTodoByIdResponse> createGetTodoByIdResponse(GetTodoByIdResponse value) {
        return new JAXBElement<GetTodoByIdResponse>(_GetTodoByIdResponse_QNAME, GetTodoByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTodoStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "updateTodoStatusResponse")
    public JAXBElement<UpdateTodoStatusResponse> createUpdateTodoStatusResponse(UpdateTodoStatusResponse value) {
        return new JAXBElement<UpdateTodoStatusResponse>(_UpdateTodoStatusResponse_QNAME, UpdateTodoStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "updateTodo")
    public JAXBElement<UpdateTodo> createUpdateTodo(UpdateTodo value) {
        return new JAXBElement<UpdateTodo>(_UpdateTodo_QNAME, UpdateTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTodosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "getAllTodosResponse")
    public JAXBElement<GetAllTodosResponse> createGetAllTodosResponse(GetAllTodosResponse value) {
        return new JAXBElement<GetAllTodosResponse>(_GetAllTodosResponse_QNAME, GetAllTodosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTodoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "deleteTodoResponse")
    public JAXBElement<DeleteTodoResponse> createDeleteTodoResponse(DeleteTodoResponse value) {
        return new JAXBElement<DeleteTodoResponse>(_DeleteTodoResponse_QNAME, DeleteTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTodoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "addTodoResponse")
    public JAXBElement<AddTodoResponse> createAddTodoResponse(AddTodoResponse value) {
        return new JAXBElement<AddTodoResponse>(_AddTodoResponse_QNAME, AddTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTodos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "getAllTodos")
    public JAXBElement<GetAllTodos> createGetAllTodos(GetAllTodos value) {
        return new JAXBElement<GetAllTodos>(_GetAllTodos_QNAME, GetAllTodos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "addTodo")
    public JAXBElement<AddTodo> createAddTodo(AddTodo value) {
        return new JAXBElement<AddTodo>(_AddTodo_QNAME, AddTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTodoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "updateTodoResponse")
    public JAXBElement<UpdateTodoResponse> createUpdateTodoResponse(UpdateTodoResponse value) {
        return new JAXBElement<UpdateTodoResponse>(_UpdateTodoResponse_QNAME, UpdateTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "deleteTodo")
    public JAXBElement<DeleteTodo> createDeleteTodo(DeleteTodo value) {
        return new JAXBElement<DeleteTodo>(_DeleteTodo_QNAME, DeleteTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTodoStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "updateTodoStatus")
    public JAXBElement<UpdateTodoStatus> createUpdateTodoStatus(UpdateTodoStatus value) {
        return new JAXBElement<UpdateTodoStatus>(_UpdateTodoStatus_QNAME, UpdateTodoStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTodoById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.org/", name = "getTodoById")
    public JAXBElement<GetTodoById> createGetTodoById(GetTodoById value) {
        return new JAXBElement<GetTodoById>(_GetTodoById_QNAME, GetTodoById.class, null, value);
    }

}
