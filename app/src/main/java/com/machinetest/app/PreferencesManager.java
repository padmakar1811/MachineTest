package com.machinetest.app;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesManager {

    //app login variables
    private static final String PREF_NAME = "com.machinetest.PREF";
    private static final String Full_Name = "Full_Name";
    private static final String UniqueId = "UniqueId";
    private static final String UserType = "UserType";
    private static final String ProfilePic = "ProfilePic";
    private static final String Contact = "Contact";
    private static final String AltContact = "AltContact";
    private static final String Token = "Token";
    private static final String LoginId = "LoginId";
    private static final String Gender = "Gender";
    private static final String Email = "Email";
    private static final String BusinessProfile = "BusinessProfile";
    private static final String EmployeeId = "EmployeeId";
    private static final String CompanyName = "CompanyName";
    private static final String CompanyId = "CompanyId";
    private static final String CityName = "CityName";
    private static final String CityId = "CityId";
    private static final String StateName = "StateName";
    private static final String StateId = "StateId";
    private static final String ManagerName = "ManagerName";
    private static final String ManagerMobile = "ManagerMobile";
    private static final String ManagerId = "ManagerId";
    private static final String CityData = "CityData";
    private static final String CityCount = "CityCount";
    private static final String CareMobile = "CareMobile";
    private static final String CareWhatsapp = "CareWhatsapp";
    private static final String TripPackage = "TripPackage";

    private static final String CabReportingTime = "CabReportingTime";
    private static final String vendorId = "vendorId";

    private static final String Tripaction = "Tripaction";
    private static final String TripDetailsData = "TripDetailsData";

    public static PreferencesManager sInstance;
    private final SharedPreferences mPref;

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_FIRST_INTRO = "IS_FIRST_INTRO";

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    //for fragment
    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    //for getting instance
    public static synchronized PreferencesManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
        return sInstance;
    }

    public boolean clear() {
        return mPref.edit().clear().commit();
    }

    //CabReportingTime
    public void setCabReportingTime(String value) {
        mPref.edit().putString(CabReportingTime, value).apply();
    }

    public String getCabReportingTime() {
        return mPref.getString(CabReportingTime, "");
    }

    //Tripaction
    public void setTripaction(String value) {
        mPref.edit().putString(Tripaction, value).apply();
    }

    public String getTripaction() {
        return mPref.getString(Tripaction, "");
    }

    //TripDetailsData
    public void setTripDetailsData(String value) {
        mPref.edit().putString(TripDetailsData, value).apply();
    }

    public String getTripDetailsData() {
        return mPref.getString(TripDetailsData, "");
    }

    //Email
    public void setEmail(String value) {
        mPref.edit().putString(Email, value).apply();
    }

    public String getEmail() {
        return mPref.getString(Email, "");
    }

    //UserId
    public void setVendorId(String value) {
        mPref.edit().putString(vendorId, value).apply();
    }

    public String getVendorId() {
        return mPref.getString(vendorId, "");
    }

    //Full_Name
    public void setFull_Name(String value) {
        mPref.edit().putString(Full_Name, value).apply();
    }

    public String getFull_Name() {
        return mPref.getString(Full_Name, "");
    }

    //UniqueId
    public void setUniqueId(String value) {
        mPref.edit().putString(UniqueId, value).apply();
    }

    public String getUniqueId() {
        return mPref.getString(UniqueId, "");
    }

    //UserType
    public void setUserType(String value) {
        mPref.edit().putString(UserType, value).apply();
    }

    public String getUserType() {
        return mPref.getString(UserType, "");
    }

    //ProfilePic
    public void setProfilePic(String value) {
        mPref.edit().putString(ProfilePic, value).apply();
    }

    public String getProfilePic() {
        return mPref.getString(ProfilePic, "");
    }

    //Contact
    public void setContact(String value) {
        mPref.edit().putString(Contact, value).apply();
    }

    public String getContact() {
        return mPref.getString(Contact, "");
    }

    //Token
    public void setToken(String value) {
        mPref.edit().putString(Token, value).apply();
    }

    public String getToken() {
        return mPref.getString(Token, "");
    }

    //LoginId
    public void setLoginId(String value) {
        mPref.edit().putString(LoginId, value).apply();
    }

    public String getLoginId() {
        return mPref.getString(LoginId, "");
    }

    //BusinessProfile
    public void setBusinessProfile(String value) {
        mPref.edit().putString(BusinessProfile, value).apply();
    }

    public String getBusinessProfile() {
        return mPref.getString(BusinessProfile, "");
    }

    //IS_FIRST_TIME_LAUNCH
    public void setIsFirstTimeLaunch(boolean value) {
        mPref.edit().putBoolean(IS_FIRST_TIME_LAUNCH, value).apply();
    }

    public boolean getIsFirstTimeLaunch() {
        return mPref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    //setIsFirstIntro
    public void setIsFirstIntro(boolean value) {
        mPref.edit().putBoolean(IS_FIRST_INTRO, value).apply();
    }

    public boolean getIsFirstIntro() {
        return mPref.getBoolean(IS_FIRST_INTRO, true);
    }


    //EmployeeId
    public void setEmployeeId(String value) {
        mPref.edit().putString(EmployeeId, value).apply();
    }

    public String getEmployeeId() {
        return mPref.getString(EmployeeId, "");
    }

    //AltContact
    public void setAltContact(String value) {
        mPref.edit().putString(AltContact, value).apply();
    }

    public String getAltContact() {
        return mPref.getString(AltContact, "");
    }

    //Gender
    public void setGender(String value) {
        mPref.edit().putString(Gender, value).apply();
    }

    public String getGender() {
        return mPref.getString(Gender, "");
    }


    //CompanyName
    public void setCompanyName(String value) {
        mPref.edit().putString(CompanyName, value).apply();
    }

    public String getCompanyName() {
        return mPref.getString(CompanyName, "");
    }

    //CityName
    public void setCityName(String value) {
        mPref.edit().putString(CityName, value).apply();
    }

    public String getCityName() {
        return mPref.getString(CityName, "");
    }

    //CompanyId
    public void setCompanyId(String value) {
        mPref.edit().putString(CompanyId, value).apply();
    }

    public String getCompanyId() {
        return mPref.getString(CompanyId, "");
    }

    //CityId
    public void setCityId(String value) {
        mPref.edit().putString(CityId, value).apply();
    }

    public String getCityId() {
        return mPref.getString(CityId, "");
    }

    //StateId
    public void setStateId(String value) {
        mPref.edit().putString(StateId, value).apply();
    }

    public String getStateId() {
        return mPref.getString(StateId, "");
    }

    //StateName
    public void setStateName(String value) {
        mPref.edit().putString(StateName, value).apply();
    }

    public String getStateName() {
        return mPref.getString(StateName, "");
    }

    //ManagerName
    public void setManagerName(String value) {
        mPref.edit().putString(ManagerName, value).apply();
    }

    public String getManagerName() {
        return mPref.getString(ManagerName, "");
    }

    //ManagerMobile
    public void setManagerMobile(String value) {
        mPref.edit().putString(ManagerMobile, value).apply();
    }

    public String getManagerMobile() {
        return mPref.getString(ManagerMobile, "");
    }

    //ManagerId
    public void setManagerId(String value) {
        mPref.edit().putString(ManagerId, value).apply();
    }

    public String getManagerId() {
        return mPref.getString(ManagerId, "");
    }

    //BankName
    public void setCityData(String value) {
        mPref.edit().putString(CityData, value).apply();
    }

    public String getCityData() {
        return mPref.getString(CityData, "");
    }

    //AccountNo
    public void setCityCount(String value) {
        mPref.edit().putString(CityCount, value).apply();
    }

    public String getCityCount() {
        return mPref.getString(CityCount, "");
    }

    //CareMobile
    public void setCareMobile(String value) {
        mPref.edit().putString(CareMobile, value).apply();
    }

    public String getCareMobile() {
        return mPref.getString(CareMobile, "");
    }

    //CareWhatsapp
    public void setCareWhatsapp(String value) {
        mPref.edit().putString(CareWhatsapp, value).apply();
    }

    public String getCareWhatsapp() {
        return mPref.getString(CareWhatsapp, "");
    }

    //TripPackage
    public void setTripPackage(String value) {
        mPref.edit().putString(TripPackage, value).apply();
    }

    public String getTripPackage() {
        return mPref.getString(TripPackage, "");
    }
}
