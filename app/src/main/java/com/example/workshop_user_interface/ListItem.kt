package com.example.workshop_user_interface

import android.widget.CheckBox
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class ListItemProps(val name: String)

//@Preview(showBackground = true)
@Composable
fun PreviewSpaceList() {
    val sampleItems = listOf(
        ListItemProps("Erster Wurf"),
        ListItemProps("Zweiter Wurf"),
        ListItemProps("Dritter Wurf")
    )
    SpacedVerticalList(listItems = sampleItems, modifier = Modifier.padding(10.dp))
}

@Composable
fun SpacedVerticalList(
    modifier: Modifier = Modifier,
    listItems: List<ListItemProps>
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        listItems.forEachIndexed { index, item ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(16.dp))
            }
            ListItem(item)
        }
    }
}


@Composable
fun ListItemPreview() {

        ListItem(singleListItem = ListItemProps("Erster Wurf"))

}


@Composable
fun ListItem(singleListItem: ListItemProps) {
    var checkedBox by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
            .clickable { // Hier wird der Klick-Effekt auf das Listenelement angewendet
                checkedBox = !checkedBox // Den Wert der Checkbox umkehren
            }
    ) {
        // Anzeige des Namens des Listenelements
        Text(
            text = singleListItem.name,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        )

        // Abstand zwischen dem Namen und der Checkbox
        Spacer(modifier = Modifier.width(6.dp))

        // Checkbox zur Auswahl des Elements
        Checkbox(
            checked = checkedBox,
            onCheckedChange = { isChecked ->
                checkedBox = isChecked
            }
        )
    }

}


@Composable
fun YourScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        val sampleItems = listOf(
            ListItemProps("Erster Wurf"),
            ListItemProps("Zweiter Wurf"),
            ListItemProps("Dritter Wurf")
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(sampleItems) { item ->
                ListItem(item)
            }
        }
    }
}

@Composable
fun ListItemNew(singleListItem: ListItemProps) {
    //var checkedBox by remember {
      //  mutableStateOf(false)

    var checkedBox by mutableStateOf(false)


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
            .clickable { // Hier wird der Klick-Effekt auf das Listenelement angewendet
               checkedBox = !checkedBox // Den Wert der Checkbox umkehren
            }
    ) {
        // Anzeige des Namens des Listenelements
        Text(
            text = singleListItem.name,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        )

        // Abstand zwischen dem Namen und der Checkbox
        Spacer(modifier = Modifier.width(6.dp))

        // Checkbox zur Auswahl des Elements
        Checkbox(
            checked = checkedBox,
            onCheckedChange = { isChecked ->
               checkedBox = isChecked
            }
        )
    }
}
