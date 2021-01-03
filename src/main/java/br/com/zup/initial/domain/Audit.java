package br.com.zup.initial.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Audit {

    private LocalDate createdDate;

    private LocalDate modifyDate;

    private String userCreated;

    private String userModify;

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public String getUserModify() {
        return userModify;
    }

    public void setUserModify(String userModify) {
        this.userModify = userModify;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "createdDate=" + createdDate +
                ", modifyDate=" + modifyDate +
                ", userCreated='" + userCreated + '\'' +
                ", userModify='" + userModify + '\'' +
                '}';
    }

    @PrePersist
    private void prePersist() throws UnknownHostException {
        this.createdDate = LocalDate.now();
        this.userCreated = Inet4Address.getLocalHost().getHostAddress();
    }

    @PreUpdate
    private void preUpdate() throws UnknownHostException {
        this.modifyDate = LocalDate.now();
        this.userModify = Inet4Address.getLocalHost().getHostAddress();
    }

}
