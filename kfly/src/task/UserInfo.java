package task;

/**
 * Created by Administrator on 2021/1/13 14:56.
 */
public class UserInfo {
    public String access_token;
    public String token_type;
    public String refresh_token;
    public int expires_in;
    public String scope;
    public String userName;
    public String pwd;

    @Override
    public String toString() {
        return "UserInfo{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", expires_in=" + expires_in +
                ", scope='" + scope + '\'' +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
