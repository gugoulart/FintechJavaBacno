package br.com.fiap.br.model;

import java.time.LocalDate;

public class Ganho {
    private int idGanho;
    private int idUsuarios;
    private String descricao;
    private double valorGanho;
    private LocalDate dataGanho;

    // Construtor padrão
    public Ganho() {
    }

    // Construtor completo
    public Ganho(int idUsuarios, String descricao, double valorGanho, LocalDate dataGanho) {
        this.idUsuarios = idUsuarios;
        this.descricao = descricao;
        this.valorGanho = valorGanho;
        this.dataGanho = dataGanho;
    }

    // Getters e setters
    public int getIdGanho() {
        return idGanho;
    }

    public void setIdGanho(int idGanho) {
        this.idGanho = idGanho;
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

    public double getValorGanho() {
        return valorGanho;
    }

    public void setValorGanho(double valorGanho) {
        this.valorGanho = valorGanho;
    }

    public LocalDate getDataGanho() {
        return dataGanho;
    }

    public void setDataGanho(LocalDate dataGanho) {
        this.dataGanho = dataGanho;
    }
}