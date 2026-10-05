package com.example.calculadoracarrinho.domain.model

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String?,
    val descontoPercentual: Double = 0.0
)