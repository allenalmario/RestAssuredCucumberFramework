package endpoints;

/*
This enum class holds methods that return the resources in string format
*/
public enum APIResources {

    // this method returns the add user api resource
    AddUserAPI("/user"),
    // this method returns the api resource for Get, Update, and Delete
    UserAPI("/user/{username}");

    private String resource;

    /*
    This constructor takes a string
    of what API Resource is desired to be used,
    it then takes the value of whatever is passed to it and
    stores it in the resource variable
    i.e. call the APIResources constructor with method valueOf(AddUserAPI),
    takes the string value "/user" and sets it to the variable resource
    */
    APIResources(String resource) {
        this.resource = resource;
    }

    // this method returns the resource value
    public String getResource() {
        return resource;
    }

}