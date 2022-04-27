package api.constants;

public class EndpointsPath {
    private EndpointsPath() {
        throw new IllegalStateException("Constants class");
    }


    public static final String GET_USER_BY_USERNAME= "/user/%s";
    public static final String CREATE_USER = "/user/createWithArray";
    public static final String ALL_USERS = "/api/users";


}
