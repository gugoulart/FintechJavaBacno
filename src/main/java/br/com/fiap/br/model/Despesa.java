package br.com.fiap.br.model;

import java.time.LocalDate;

public class Despesa {
    private int idDespesa;
    private int idUsuarios;
    private String descricao;
    private double valorTotal;
    private String frequencia;
    private LocalDate dataDespesa;

    public Despesa() {
    }

    public Despesa(int idUsuarios, String descricao, double valorTotal, String frequencia, LocalDate dataDespesa) {
        this.idUsuarios = idUsuarios;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.frequencia = frequencia;
        this.dataDespesa = dataDespesa;
    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public LocalDate getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(LocalDate dataDespesa) {
        this.dataDespesa = dataDespesa;
    }
}
