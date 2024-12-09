package br.com.fiap.br.model;

import java.time.LocalDate;

public class Conta {
    private int id;
    private int idUsuarios;
    private String tpContaUsuarios;
    private double saldoConta;
    private LocalDate dtAbertura;

    public Conta(int idUsuarios, String tpContaUsuarios, double saldoConta, LocalDate dtAbertura) {
        this.idUsuarios = idUsuarios;
        this.tpContaUsuarios = tpContaUsuarios;
        this.saldoConta = saldoConta;
        this.dtAbertura = dtAbertura;
    }

    public Conta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getTpContaUsuarios() {
        return tpContaUsuarios;
    }

    public void setTpContaUsuarios(String tpContaUsuarios) {
        this.tpContaUsuarios = tpContaUsuarios;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public LocalDate getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(LocalDate dtAbertura) {
        this.dtAbertura = dtAbertura;
    }
}