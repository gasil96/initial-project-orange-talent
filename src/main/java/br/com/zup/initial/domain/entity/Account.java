package br.com.zup.initial.domain.entity;

import br.com.zup.initial.domain.Audit;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT")
public class Account extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ACCOUNT")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;

    @CPF
    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "PREMIUM_ACCOUNT")
    private Boolean premiumAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getPremiumAccount() {
        return premiumAccount;
    }

    public void setPremiumAccount(Boolean premiumAccount) {
        this.premiumAccount = premiumAccount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", premiumAccount=" + premiumAccount +
                '}';
    }
}
