package com.example.d_dmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.d_dmaster.ui.theme.DDMasterTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DDMasterTheme {
                TelaCriacaoPersonagem()
            }
        }
    }
}

@Composable
fun TelaCriacaoPersonagem() {
    var nomePersonagem by remember { mutableStateOf("") }
    val personagem = remember { Personagem() }
    var classeSelecionada by remember { mutableStateOf<Classe?>(null) }
    var racaSelecionada by remember { mutableStateOf<Raca?>(null) }
    var pontosRestantes by remember { mutableStateOf(27) }
    var personagemCriado by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    val classes = listOf(
        Classe("Arqueiro", mapOf("Destreza" to 3)),
        Classe("Mago", mapOf("Inteligência" to 3)),
        Classe("Guerreiro", mapOf("Força" to 3))
    )

    val racas = listOf(
        Raca("Humano", bonusAtributos = mapOf("Forca" to 1, "Destreza" to 1, "Constituicao" to 1, "Inteligencia" to 1, "Sabedoria" to 1, "Carisma" to 1)),
        Raca("Elfo", bonusAtributos = mapOf("Destreza" to 2, "Inteligencia" to 1)),
        Raca("Anão", bonusAtributos = mapOf("Constituicao" to 2, "Forca" to 2))
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(text = "Criação de Personagem", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = nomePersonagem,
            onValueChange = { nomePersonagem = it },
            label = { Text(text = "Nome do Personagem") }
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Selecione a Classe:")
        classes.forEach { classe ->
            Row {
                RadioButton(
                    selected = classe == classeSelecionada,
                    onClick = { classeSelecionada = classe }
                )
                Text(text = classe.nome)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Selecione a Raça:")
        racas.forEach { raca ->
            Row {
                RadioButton(
                    selected = raca == racaSelecionada,
                    onClick = { racaSelecionada = raca }
                )
                Text(text = raca.nome)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Pontos restantes: $pontosRestantes")


        AtributoField("Força", personagem.forca, pontosRestantes, onIncrement = {
            val novoValor = personagem.forca + 1
            val custoAtual = calcularCustoPontos(personagem.forca)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoNovo - custoAtual
            if (pontosRestantes >= custoTotal && novoValor <= 15) {
                personagem.forca = novoValor
                pontosRestantes -= custoTotal
            }
        }, onDecrement = {
            val novoValor = personagem.forca - 1
            val custoAtual = calcularCustoPontos(personagem.forca)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoAtual - custoNovo
            if (novoValor >= 8) {
                personagem.forca = novoValor
                pontosRestantes += custoTotal
            }
        })


        AtributoField("Destreza", personagem.destreza, pontosRestantes, onIncrement = {
            val novoValor = personagem.destreza + 1
            val custoAtual = calcularCustoPontos(personagem.destreza)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoNovo - custoAtual
            if (pontosRestantes >= custoTotal && novoValor <= 15) {
                personagem.destreza = novoValor
                pontosRestantes -= custoTotal
            }
        }, onDecrement = {
            val novoValor = personagem.destreza - 1
            val custoAtual = calcularCustoPontos(personagem.destreza)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoAtual - custoNovo
            if (novoValor >= 8) {
                personagem.destreza = novoValor
                pontosRestantes += custoTotal
            }
        })


        AtributoField("Constituição", personagem.constituicao, pontosRestantes, onIncrement = {
            val novoValor = personagem.constituicao + 1
            val custoAtual = calcularCustoPontos(personagem.constituicao)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoNovo - custoAtual
            if (pontosRestantes >= custoTotal && novoValor <= 15) {
                personagem.constituicao = novoValor
                pontosRestantes -= custoTotal
            }
        }, onDecrement = {
            val novoValor = personagem.constituicao - 1
            val custoAtual = calcularCustoPontos(personagem.constituicao)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoAtual - custoNovo
            if (novoValor >= 8) {
                personagem.constituicao = novoValor
                pontosRestantes += custoTotal
            }
        })


        AtributoField("Inteligência", personagem.inteligencia, pontosRestantes, onIncrement = {
            val novoValor = personagem.inteligencia + 1
            val custoAtual = calcularCustoPontos(personagem.inteligencia)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoNovo - custoAtual
            if (pontosRestantes >= custoTotal && novoValor <= 15) {
                personagem.inteligencia = novoValor
                pontosRestantes -= custoTotal
            }
        }, onDecrement = {
            val novoValor = personagem.inteligencia - 1
            val custoAtual = calcularCustoPontos(personagem.inteligencia)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoAtual - custoNovo
            if (novoValor >= 8) {
                personagem.inteligencia = novoValor
                pontosRestantes += custoTotal
            }
        })


        AtributoField("Sabedoria", personagem.sabedoria, pontosRestantes, onIncrement = {
            val novoValor = personagem.sabedoria + 1
            val custoAtual = calcularCustoPontos(personagem.sabedoria)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoNovo - custoAtual
            if (pontosRestantes >= custoTotal && novoValor <= 15) {
                personagem.sabedoria = novoValor
                pontosRestantes -= custoTotal
            }
        }, onDecrement = {
            val novoValor = personagem.sabedoria - 1
            val custoAtual = calcularCustoPontos(personagem.sabedoria)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoAtual - custoNovo
            if (novoValor >= 8) {
                personagem.sabedoria = novoValor
                pontosRestantes += custoTotal
            }
        })


        AtributoField("Carisma", personagem.carisma, pontosRestantes, onIncrement = {
            val novoValor = personagem.carisma + 1
            val custoAtual = calcularCustoPontos(personagem.carisma)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoNovo - custoAtual
            if (pontosRestantes >= custoTotal && novoValor <= 15) {
                personagem.carisma = novoValor
                pontosRestantes -= custoTotal
            }
        }, onDecrement = {
            val novoValor = personagem.carisma - 1
            val custoAtual = calcularCustoPontos(personagem.carisma)
            val custoNovo = calcularCustoPontos(novoValor)
            val custoTotal = custoAtual - custoNovo
            if (novoValor >= 8) {
                personagem.carisma = novoValor
                pontosRestantes += custoTotal
            }
        })

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            personagem.nome = nomePersonagem
            personagem.classe = classeSelecionada
            personagem.raca = racaSelecionada
            personagem.aplicarBonusClasse()
            personagem.aplicarBonusRaca()
            personagem.calcularPontosDeVida()
            personagemCriado = true
        }) {
            Text(text = "Criar Personagem")
        }


        if (personagemCriado && personagem.nome.isNotEmpty() && personagem.classe != null && personagem.raca != null) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Personagem Criado com Sucesso!")
            Text(text = "Nome: ${personagem.nome}")
            Text(text = "Classe: ${personagem.classe?.nome}")
            Text(text = "Raça: ${personagem.raca?.nome}")
            Text(text = "Força: ${personagem.forca}")
            Text(text = "Destreza: ${personagem.destreza}")
            Text(text = "Constituição: ${personagem.constituicao}")
            Text(text = "Inteligência: ${personagem.inteligencia}")
            Text(text = "Sabedoria: ${personagem.sabedoria}")
            Text(text = "Carisma: ${personagem.carisma}")
            Text(text = "Pontos de Vida: ${personagem.pontosDeVida}")
        }
    }
}


fun calcularCustoPontos(pontos: Int): Int {
    return when (pontos) {
        8 -> 0
        9 -> 1
        10 -> 2
        11 -> 3
        12 -> 4
        13 -> 5
        14 -> 7
        15 -> 9
        else -> 0 // Para qualquer valor fora do intervalo (deve estar entre 8 e 15)
    }
}

@Composable
fun AtributoField(
    nomeAtributo: String,
    valorAtributo: Int,
    pontosRestantes: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Row {
        Text(text = "$nomeAtributo: $valorAtributo")
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { onDecrement() }, enabled = valorAtributo > 8) {
            Text(text = "-")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { onIncrement() }, enabled = valorAtributo < 15 && pontosRestantes > 0) {
            Text(text = "+")
        }
    }
}
