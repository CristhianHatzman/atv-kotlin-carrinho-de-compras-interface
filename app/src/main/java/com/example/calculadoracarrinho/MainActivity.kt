package com.example.calculadoracarrinho

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculadoracarrinho.domain.CalculadoraCarrinho
import com.example.calculadoracarrinho.ui.theme.CalculadoraCarrinhoTheme
import com.example.calculadoracarrinho.ui.theme.screen.CarrinhoScreen
import com.example.calculadoracarrinho.utils.formatarMoeda

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val carrinho = CalculadoraCarrinho.criarCarrinhoExemplo()

        val subtotal = CalculadoraCarrinho.calcularSubtotal(carrinho)
        val descontos = CalculadoraCarrinho.calcularDescontoTotal(carrinho)
        val totalFinal = CalculadoraCarrinho.calcularTotalFinal(carrinho)

        val relatorio = CalculadoraCarrinho.gerarLinhasRelatorio(carrinho)

        Log.d("CARRINHO", "===== RELATÓRIO DE DESCONTOS =====")

        relatorio.forEach { linha ->
            Log.d("CARRINHO", linha)
        }

        Log.d("CARRINHO", "Subtotal: ${formatarMoeda(subtotal)}")
        Log.d("CARRINHO", "Descontos: ${formatarMoeda(descontos)}")
        Log.d("CARRINHO", "Total Final: ${formatarMoeda(totalFinal)}")

        setContent {
            CalculadoraCarrinhoTheme {
                CarrinhoScreen(
                    itens = carrinho,
                    subtotal = subtotal,
                    descontos = descontos,
                    totalFinal = totalFinal
                )
            }
        }
    }
}