package com.makeinfo.flowerpi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by keechengheng on 19/7/15.
 */

public class lumimodel {

    @Expose
    private Integer ID;
    @Expose
    private String UserID;
    @Expose
    private String Password;

    /**
     *
     * @return
     * The ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     *
     * @param ID
     * The ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     * The UserID
     */
    public String getUserID() {
        return UserID;
    }

    /**
     *
     * @param UserID
     * The UserID
     */
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    /**
     *
     * @return
     * The Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     *
     * @param Password
     * The Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
