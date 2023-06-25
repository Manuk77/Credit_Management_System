package com.example.acra.customer.entity;

import com.example.acra.customer.bank.Banks;
import com.example.acra.customer.bank.CreditType;
import com.example.acra.customer.dto.CreditModel;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "credits")
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;
    @Column(name = "bank_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Banks bankName;
    @Column(name = "loan_amount", nullable = false, length = 15)
    private String loanAmount;
    @Column(name = "credit_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditType creditType;
    @Column(name = "payment_per_month", nullable = false, length = 30)
    private String paymentPerMonth;
    @Column(name = "start_credit_date", nullable = false)
    private Date startCreditDate;
    @Column(name = "end_credit_date", nullable = false)
    private Date endCreditDate;
    @Column(name = "credit_state")
    private Boolean creditState;
    @Column(name = "is_accepted")
    private Boolean isAccepted;
    @Column(name = "percent", nullable = false)
    private byte percent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_id", nullable = false)
    private CustomerHistoryEntity customerHistoryEntity;


    public CreditEntity(final Banks bankName, final String loanAmount, final String paymentPerMonth,
                        final Date startCreditDate, final Date endCreditDate, final byte percent,
                        final CustomerHistoryEntity customerHistoryEntity, final CreditType creditType,
                        final Boolean creditState, final Boolean isAccepted) {

        this.bankName = Banks.valueOf(bankName.toString());
        this.loanAmount = loanAmount;
        this.paymentPerMonth = paymentPerMonth;
        this.startCreditDate = startCreditDate;
        this.endCreditDate = endCreditDate;
        this.percent = percent;
        this.creditState = creditState;
        this.isAccepted = isAccepted;
        this.customerHistoryEntity = customerHistoryEntity;
        this.creditType = CreditType.valueOf(creditType.toString());

    }

    public CreditEntity(final CreditModel creditModel) {

        this.creditType = CreditType.valueOf(creditModel.getCreditType().toString());
        this.bankName = Banks.valueOf(creditModel.getBankName().toString());
        this.loanAmount = creditModel.getLoanAmount();
        this.startCreditDate = creditModel.getStartCreditDate();
        this.endCreditDate = creditModel.getEndCreditDate();
        this.percent = creditModel.getPercent();
        this.creditState = creditModel.getCreditState();
        this.paymentPerMonth = creditModel.getPaymentPerMonth();
        this.isAccepted = creditModel.getAccepted();
    }

    public CreditEntity() {
    }


    public String getBankName() {
        return bankName.toString();
    }

    public void setBankName(final Banks bankName) {
        this.bankName = Banks.valueOf(bankName.toString());
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(final String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPaymentPerMonth() {
        return paymentPerMonth;
    }

    public void setPaymentPerMonth(final String paymentPerMonth) {
        this.paymentPerMonth = paymentPerMonth;
    }

    public Date getStartCreditDate() {
        return startCreditDate;
    }

    public void setStartCreditDate(final Date startCreditDate) {
        this.startCreditDate = startCreditDate;
    }

    public Date getEndCreditDate() {
        return endCreditDate;
    }

    public String getCreditType() {
        return creditType.toString();
    }

    public void setCreditType(Banks creditType) {
        this.creditType = CreditType.valueOf(creditType.toString());
    }

    public void setEndCreditDate(final Date endCreditDate) {
        this.endCreditDate = endCreditDate;
    }

    public byte getPercent() {
        return percent;
    }

    public void setPercent(final byte percent) {
        this.percent = percent;
    }

    public CustomerHistoryEntity getCustomerHistoryEntity() {
        return customerHistoryEntity;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public Boolean getCreditState() {
        return creditState;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public void setCreditState(Boolean creditState) {
        this.creditState = creditState;
    }

    public void setCustomerHistoryEntity(final CustomerHistoryEntity customerHistoryEntity) {
        this.customerHistoryEntity = customerHistoryEntity;
    }
}
