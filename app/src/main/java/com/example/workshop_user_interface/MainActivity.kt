package com.example.workshop_user_interface

import android.os.Bundle
import android.text.style.SuperscriptSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workshop_user_interface.ui.theme.Workshop_user_interfaceTheme



class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<CustomViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Workshop_user_interfaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Ui_workshop_test()
                }


            }
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ui_workshop_test() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "To Do Liste", fontWeight = FontWeight.Bold
                )
            }, colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }, bottomBar = {
        CenterAlignedTopAppBar(
            title = {
                Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                    Button(onClick = { /*TODO*/ }) {
                        Text("Pomodoro")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text("To-Do-Liste")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text("Einstellungen")
                    }
                }
            }, colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )


    }) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                color = MaterialTheme.colorScheme.background
            ) {
                val sampleItems = listOf(
                    ListItemProps("Erster Wurf"),
                    ListItemProps("Zweiter Wurf"),
                    ListItemProps("Erster Wurf"),
                    ListItemProps("Zweiter Wurf"),
                    ListItemProps("Erster Wurf"),
                    ListItemProps("Zweiter Wurf"),
                    ListItemProps("Erster Wurf"),
                    ListItemProps("Zweiter Wurf"),
                    ListItemProps("Erster Wurf"),
                    ListItemProps("Zweiter Wurf"),
                    )
                Column(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        items(sampleItems) { item ->
                            ListItem(item)
                        }
                    }
                    Spacer(modifier = Modifier.padding(15.dp))
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clickable { /*TODO*/ }
                            .align(Alignment.End)
                            .padding(15.dp)
                            .size(60.dp)
                           ) {
                        Text("+", style = MaterialTheme.typography.bodyLarge, fontSize = 30.sp,textAlign = TextAlign.Center )





                    }
                    Spacer(modifier = Modifier.padding(30.dp))
                    Button(onClick = { viewModel() },
                        modifier = Modifier
                            .clickable {}
                            .background(Color.Green)
                            .align(Alignment.End)
                            .padding(15.dp)
                            .size(60.dp)
                    ) {
                        Text("+", style = MaterialTheme.typography.bodyLarge, fontSize = 30.sp,textAlign = TextAlign.Center )





                    }
                }
            }
        }
    }
}




