package gs.oauth2.models;

import leap.orm.annotation.Column;
import leap.orm.annotation.Id;
import leap.orm.annotation.Table;
import leap.orm.annotation.Unique;
import leap.orm.model.Model;

@Table(name="users", autoCreate = true)
public class User extends Model {

    @Id(generator = "shortid")
    protected String id;

    @Column
    protected String name;

    @Unique
    @Column
    protected String loginName;

    @Column
    protected String  password;

    @Column
    protected boolean enabled = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}