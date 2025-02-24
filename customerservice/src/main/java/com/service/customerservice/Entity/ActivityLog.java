package com.service.customerservice.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Random;

@Table(name = "ActivityLog",schema = "customer")
@Entity
public class ActivityLog {

    @Id
    private String activityLogID;



    private String customerID;


    private String activityType; // e.g., "login", "profile update"
    private LocalDateTime activityTimestamp;
    private String activityDetails;


    public ActivityLog(String activityLogID, String customerID, String activityType,
                       LocalDateTime activityTimestamp, String activityDetails) {
        this.activityLogID = activityLogID;
        this.customerID = customerID;
        this.activityType = activityType;
        this.activityTimestamp = activityTimestamp;
        this.activityDetails = activityDetails;
    }


    public String getActivityLogID() {
        return activityLogID;
    }

    private int generateFiveDigitId() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); // Generates number between 10000-99999
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public LocalDateTime getActivityTimestamp() {
        return activityTimestamp;
    }

    public void setActivityTimestamp(LocalDateTime activityTimestamp) {
        this.activityTimestamp = activityTimestamp;
    }

    public String getActivityDetails() {
        return activityDetails;
    }

    public void setActivityDetails(String activityDetails) {
        this.activityDetails = activityDetails;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "activityLogID='" + activityLogID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", activityType='" + activityType + '\'' +
                ", activityTimestamp=" + activityTimestamp +
                ", activityDetails='" + activityDetails + '\'' +
                '}';
    }
}
