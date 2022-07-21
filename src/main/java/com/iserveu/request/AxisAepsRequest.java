package com.iserveu.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AxisAepsRequest {

    private Long amount;
    @Size(max=1,min=25,message="txnId must be between of 1 and 25")
    private Long txnId;
    @Size(max=10,min=10,message="mobileNo must be of 10 digit")
    private String mobileNo;
    @Size(max=16,min=16,message="aadhaar must be of 16 digit")
    private String aadhaar;
    @Size(max=50,min=1,message="bankName must be equal or less than 50")
    private String bankName;
    @NotBlank(message = "pidData cannot be blank")
    private String pidData;
    @Size(max=6,min=6,message="iin must be of length 6")
    private String iin;
    @Size(max=12,min=1,message="terminal id length must be between 12")
    private String terminalId;
    @Size(max=50,min=6,message="ipAddress length must be between 6 and 50")
    private String ipAddress = "10.10.15.100";
    @Size(max=50,min=1,message="latitude length must be between 6 and 50")
    private String latitude;
    @Size(max=50,min=1,message="longitude length must be between 6 and 50")
    private String longitude;
    @NotBlank(message = "Merchant id can not be blank")
    private Long merchnatId;

    @Size(max=50,min=1,message="imeiMac length must be between 6 and 50")
    private String imeiMac;
    @Size(max=50,min=1,message="deviceNo length must be between 6 and 50")
    private String deviceNo;

    @Size(max=13,min=1, message= "City length must be within 13 character")
    @NotBlank(message = "city can not be blank")
    private String city;
    @Size(max=2,min=1, message= "State length must be within 2 character ")
    @NotBlank(message= "State can not be blank")
    private String state;
    @Size(max=2,min=1, message= "Country length must be within 2 character")
    @NotBlank(message = "Country can not be blank")
    private String country;
    @NotBlank(message = "Bank rrn can not be blank")
    private String BcRrn;
    @NotBlank(message = "Stan can not be blank")
    private int stan;

    @NotBlank(message = "User can not be blank ")
    @Size(max=23,min=1,message = "Max lenght  of user can be 23 only")
    private String userName;
    @NotBlank(message = "UserId can not be blank")
    private Long userId;

    @NotBlank(message = "txn date and time can not be blank")
    private String txnDateTime;

    @NotBlank(message = "Vendor id can not be blank")
    @Size(max=3,min=3,message = "Enter valid vendor id size, it can only be 3 digits")
    private String tspVendorId;


//    @NotBlank(message = "dpId cannot be blank")
//    private String dpId;
//    @NotBlank(message = "rdsId cannot be blank")
//    private String rdsId;
//    @NotBlank(message = "rdsVer cannot be blank")
//    private String rdsVer;
//    @NotBlank(message = "dc cannot be blank")
//    private String dc;
//    @NotBlank(message = "mi cannot be blank")
//    private String mi;
//    @NotBlank(message = "mc cannot be blank")
//    private String mc;
}
