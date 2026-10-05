package com.example.calculadoracarrinho.utils

import java.text.NumberFormat
import java.util.Locale

fun formatarMoeda(valor: Double): String {
    val formato = NumberFormat.getCurrencyInstance(
        Locale("pt", "BR")
    )

    return formato.format(valor)
}