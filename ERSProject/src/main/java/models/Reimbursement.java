package models;

import java.util.Date;

public class Reimbursement {
    private Integer id;
    private Integer amount;
    private Date submitted;
    private Date resolved;
    private String description;
    private Integer usersAuthor;
    private Integer usersResolver;
    private Integer reimbStatus;
    private Integer reimbType;

    public Reimbursement() {
    }

    public Reimbursement(Integer id, Integer amount, Date submitted, Date resolved, String description, Integer usersAuthor, Integer usersResolver, Integer reimbStatus, Integer reimbType) {
        this.id = id;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.usersAuthor = usersAuthor;
        this.usersResolver = usersResolver;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
    }

    public Reimbursement(Integer amount, String description, Integer usersAuthor, Integer reimbType) {
        this.amount = amount;
        this.description = description;
        this.usersAuthor = usersAuthor;
        this.reimbType = reimbType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUsersAuthor() {
        return usersAuthor;
    }

    public void setUsersAuthor(Integer usersAuthor) {
        this.usersAuthor = usersAuthor;
    }

    public Integer getUsersResolver() {
        return usersResolver;
    }

    public void setUsersResolver(Integer usersResolver) {
        this.usersResolver = usersResolver;
    }

    public Integer getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(Integer reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    public Integer getReimbType() {
        return reimbType;
    }

    public void setReimbType(Integer reimbType) {
        this.reimbType = reimbType;
    }

    @Override
    public String toString() {
        return "\n" + "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", usersAuthor=" + usersAuthor +
                ", usersResolver=" + usersResolver +
                ", reimbStatus=" + reimbStatus +
                ", reimbType=" + reimbType +
                '}';
    }
}
