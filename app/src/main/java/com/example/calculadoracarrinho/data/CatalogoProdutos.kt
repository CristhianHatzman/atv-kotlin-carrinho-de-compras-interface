package com.example.calculadoracarrinho.data

import com.example.calculadoracarrinho.domain.model.Produto

object CatalogoProdutos {

    val produtos = listOf(

        // Produtos obrigatórios do cenário de validação
        Produto(
            nome = "Notebook Dell Inspiron",
            preco = 3499.00,
            descricao = "Notebook rápido para estudos e trabalho",
            descontoPercentual = 5.0
        ),

        Produto(
            nome = "Mouse sem fio",
            preco = 89.90,
            descricao = null,
            descontoPercentual = 0.0
        ),

        Produto(
            nome = "Teclado mecânico RGB",
            preco = 349.90,
            descricao = "Teclado mecânico com iluminação RGB",
            descontoPercentual = 0.0
        ),

        // Produtos adicionais necessários para completar o catálogo
        Produto(
            nome = "Monitor LED 24 polegadas com resolução Full HD",
            preco = 899.90,
            descricao = "Monitor Full HD com conexão HDMI",
            descontoPercentual = 10.0
        ),

        Produto(
            nome = "Headset Gamer",
            preco = 249.90,
            descricao = "Headset com microfone e som estéreo",
            descontoPercentual = 0.0
        ),

        Produto(
            nome = "Webcam Full HD",
            preco = 199.90,
            descricao = "Webcam para chamadas e reuniões online",
            descontoPercentual = 8.0
        )
    )
}