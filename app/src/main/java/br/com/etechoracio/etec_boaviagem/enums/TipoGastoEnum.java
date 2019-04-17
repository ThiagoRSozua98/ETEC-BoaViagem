package br.com.etechoracio.etec_boaviagem.enums;

public enum TipoGastoEnum {
    SELECIONE("--Selecione--"),
    ALIMENTACAO("Alimentação"),
    COMBUSTIVEL("Combustivel"),
    TRANSPORTE("Transporte"),
    HOSPEDAGEM("Hospedagem"),
    OUTROS("Outros");

    private String descricao;

    TipoGastoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        return descricao;
    }

}

