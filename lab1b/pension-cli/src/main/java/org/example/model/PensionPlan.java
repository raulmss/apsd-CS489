package org.example.model;



import java.util.Date;

public class PensionPlan {
    private long planReferenceNumber;
    private Date enrollmentDate;
    private double monthlyContribution;

    public PensionPlan() {
    }

    public PensionPlan(long planReferenceNumber, Date enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public long getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(long planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}
