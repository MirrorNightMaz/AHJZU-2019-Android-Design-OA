package com.example.oa10.Beans;

/**
 * Created by asus on 2018/12/28.
 */

public class PhoneEntity {
    private String phoneNumber;//手机号
    private String phoneName;//手机联系人

    public PhoneEntity() {

    }

    public  PhoneEntity(String phoneNumber, String phoneName){
        this.phoneName=phoneName;
        this.phoneNumber = phoneNumber;
    }
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * @return the phoneName
     */
    public String getPhoneName() {
        return phoneName;
    }
    /**
     * @param phoneName the phoneName to set
     */
    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", phoneName='" + phoneName + '\'' +
                '}';
    }
}
