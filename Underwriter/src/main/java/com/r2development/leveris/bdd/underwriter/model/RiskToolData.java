package com.r2development.leveris.bdd.underwriter.model;

import java.util.List;
import java.util.Map;

public class RiskToolData extends DataModel {

    public RiskToolData(Map<String, String> accountData) {
        super(accountData);
    }

    public RiskToolData(List<String> accountData) {
        super(accountData);
    }

    public String getFICO() {
        return data.get("FICO");
    }

    public void setFICO(String fico){
        data.replace("FICO", fico);
    }

    public String getTicketId() {
        return data.get("TicketId");
    }

    public void setTicketId(String ticketId){
        data.replace("TicketId", ticketId);
    }

    public String getComment() {
        return data.get("Comment");
    }

    public void setComment(String comment){
        data.replace("Comment", comment);
    }

    public String getAML() {
        return data.get("AML");
    }

    public void setAML(String aml){
        data.replace("AML", aml);
    }

    public String getFraud() {
        return data.get("Fraud");
    }

    public void setFraud(String fraud){
        data.replace("Fraud", fraud);
    }

    public String getRepeatCustomer() {
        return data.get("RepeatCustomer");
    }

    public void setRepeatCustomer(String repeatCustomer){
        data.replace("RepeatCustomer", repeatCustomer);
    }

    public String getScore() {
        return data.get("Score");
    }

    public void setScore(String score){
        data.replace("Score", score);
    }

    public String getNote() {
        return data.get("Note");
    }

    public void setNote(String note){
        data.replace("Note", note);
    }
}