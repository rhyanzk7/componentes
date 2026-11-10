package com.example.a20262semermelindads3ncomponentesestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ComponentsStateScreen()
            }
        }
    }
}

@Composable
fun ComponentsStateScreen() {
    var nome by rememberSaveable { mutableStateOf("") }
    var contador by rememberSaveable { mutableStateOf(0) }
    var tarefaConcluida by rememberSaveable { mutableStateOf(false) }
    var notificacoesAtivas by rememberSaveable { mutableStateOf(true) }
    var nivel by rememberSaveable { mutableStateOf(50f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Componentes e Estado",
            fontSize = 26.sp,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Exemplos de componentes interativos com Jetpack Compose.",
            style = MaterialTheme.typography.bodyMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("1. Campo de texto", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Digite seu nome") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (nome.isBlank()) "A saudação aparecerá aqui."
                    else "Olá, $nome!",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text("2. Contador", style = MaterialTheme.typography.titleMedium)
                Text("Valor atual: $contador", style = MaterialTheme.typography.headlineMedium)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { contador-- }) {
                        Text("Diminuir")
                    }
                    Button(onClick = { contador++ }) {
                        Text("Adicionar")
                    }
                    Button(onClick = { contador = 0 }) {
                        Text("Zerar")
                    }
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("3. Checkbox", style = MaterialTheme.typography.titleMedium)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = tarefaConcluida,
                        onCheckedChange = { tarefaConcluida = it }
                    )
                    Text(if (tarefaConcluida) "Tarefa concluída" else "Marcar tarefa como concluída")
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("4. Switch", style = MaterialTheme.typography.titleMedium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(if (notificacoesAtivas) "Notificações ativadas" else "Notificações desativadas")
                    Switch(
                        checked = notificacoesAtivas,
                        onCheckedChange = { notificacoesAtivas = it }
                    )
                }
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("5. Slider", style = MaterialTheme.typography.titleMedium)
                Text("Nível selecionado: ${nivel.toInt()}%")
                Slider(
                    value = nivel,
                    onValueChange = { nivel = it },
                    valueRange = 0f..100f
                )
            }
        }

        Text(
            text = "Os componentes acima atualizam seus valores por meio de estados do Compose.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
