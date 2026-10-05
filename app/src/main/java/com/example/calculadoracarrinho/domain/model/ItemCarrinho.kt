package com.example.calculadoracarrinho.domain.model

import com.example.calculadoracarrinho.domain.contract.Pagavel

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {

    override fun calcularTotal(): Double {
        return produto.preco * quantidade
    }
}