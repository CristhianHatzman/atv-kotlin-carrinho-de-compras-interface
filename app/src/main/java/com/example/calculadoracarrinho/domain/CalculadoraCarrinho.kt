package com.example.calculadoracarrinho.domain

import com.example.calculadoracarrinho.data.CatalogoProdutos
import com.example.calculadoracarrinho.domain.model.ItemCarrinho
import com.example.calculadoracarrinho.utils.formatarMoeda

object CalculadoraCarrinho {

    fun criarCarrinhoExemplo(): List<ItemCarrinho> {
        val produtos = CatalogoProdutos.produtos

        return listOf(
            ItemCarrinho(
                produto = produtos[0],
                quantidade = 2
            ),
            ItemCarrinho(
                produto = produtos[1],
                quantidade = 1
            ),
            ItemCarrinho(
                produto = produtos[2],
                quantidade = 1
            )
        )
    }

    fun calcularSubtotal(itens: List<ItemCarrinho>): Double {
        return itens.sumOf { item ->
            item.calcularTotal()
        }
    }

    fun calcularDescontoItem(item: ItemCarrinho): Double {
        val percentual = item.produto.descontoPercentual

        return item.calcularTotal() * percentual / 100
    }

    fun calcularDescontoTotal(itens: List<ItemCarrinho>): Double {
        return itens.sumOf { item ->
            calcularDescontoItem(item)
        }
    }

    fun calcularTotalFinal(itens: List<ItemCarrinho>): Double {
        val subtotal = calcularSubtotal(itens)
        val descontos = calcularDescontoTotal(itens)

        return subtotal - descontos
    }

    fun produtosComDesconto(
        itens: List<ItemCarrinho>
    ): List<ItemCarrinho> {
        return itens
            .filter { item ->
                item.produto.descontoPercentual > 0
            }
            .sortedByDescending { item ->
                item.calcularTotal()
            }
    }

    fun gerarLinhasRelatorio(
        itens: List<ItemCarrinho>
    ): List<String> {
        return produtosComDesconto(itens)
            .map { item ->

                val desconto = calcularDescontoItem(item)
                val valorFinal = item.calcularTotal() - desconto

                "${item.produto.nome} - " +
                        "Valor final: ${formatarMoeda(valorFinal)}"
            }
    }
}