package com.example.listpesertaquiz3

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listpesertaquiz3.ui.theme.ListPesertaQuiz3Theme

import com.example.listpesertaquiz3.data.Peserta
import com.example.listpesertaquiz3.data.pesertas


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListPesertaQuiz3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    PesertaApp()
                }
            }
        }
    }
}
@Composable
fun PesertaApp() {
    Scaffold(
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(
                        onClick = { /* Handle navigation icon click */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home")
                    }
                    IconButton(
                        onClick = { /* Handle navigation icon click */ }
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }

                    IconButton(
                        onClick = { /* Handle navigation icon click */ }
                    ) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile")
                    }
                }


            }

        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(pesertas) {
                PesertaItem(
                    peserta = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun PesertaItem(
    peserta: Peserta,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            PesertaIcon(
                nama = peserta.nama,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                )
            Spacer(Modifier.width(10.dp))
            InfoPeserta(peserta.nama, peserta.umur,peserta.domisili)

//                DogItemButton(
//                    expanded = expanded,
//                    onClick = { expanded = !expanded },
//                )
        }
//            if (expanded) {
//                DogHobby(
//                    dog.hobbies, modifier = Modifier.padding(
//                        start = dimensionResource(R.dimen.padding_medium),
//                        top = dimensionResource(R.dimen.padding_small),
//                        bottom = dimensionResource(R.dimen.padding_medium),
//                        end = dimensionResource(R.dimen.padding_medium)
//                    )
//                )
//            }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Column {
            Text(
                text = stringResource(R.string.pencarian),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(R.string.profile_profile),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }


}



@Composable
fun PesertaIcon(
    @StringRes nama: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.White,

) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(color)
            .padding(dimensionResource(R.dimen.padding_small))
            .size(dimensionResource(R.dimen.image_size))

    ) {
        Text(
            text = stringResource(nama).trim().substring(0,1),
            fontSize = 17.sp,
            color = Color.White
        )
    }

}

@Composable
fun InfoPeserta(
    @StringRes namaPeserta: Int,
    umurPeserta: Int,
    domisiliPeserta: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(namaPeserta),
            style = MaterialTheme.typography.displayMedium,
        )
        Row {
            Text(
                text = stringResource(R.string.tahun, umurPeserta),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = " - ",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(domisiliPeserta),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun PesertaPreview() {
    ListPesertaQuiz3Theme(darkTheme = false) {
        PesertaApp()
    }
}

/**
 * Composable that displays what the UI of the app looks like in dark theme in the design tab.
 */
@Preview
@Composable
fun PesertaDarkThemePreview() {
    ListPesertaQuiz3Theme(darkTheme = true) {
        PesertaApp()
    }
}

//https://github.com/philipplackner/CalculatorPrep/blob/master/app/src/main/java/com/plcoding/calculatorprep/MainActivity.kt
