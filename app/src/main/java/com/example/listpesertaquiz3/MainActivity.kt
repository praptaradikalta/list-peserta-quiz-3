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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ArtTrack
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ViewList
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 25.dp)
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
        modifier = Modifier.padding(top=25.dp),
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            BwhAppBar()
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
            Spacer(Modifier.width(10.dp))
            PesertaIcon(
                nama = peserta.nama,
                color = MaterialTheme.colorScheme.primary,

                )
            Spacer(Modifier.width(10.dp))
            InfoPeserta(peserta.nama, peserta.umur,peserta.domisili)
            Spacer(modifier = Modifier.weight(1f))
            DetailButton(
                onClick = { /*TODO*/ })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    Box(modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.pencarian),
                    style = MaterialTheme.typography.displayLarge
                )
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Rounded.ArtTrack,
                    contentDescription = null )
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.profile_profile),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun BwhAppBar(){
    BottomAppBar()
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home"
                )
                Text(
                    text = stringResource(R.string.home),
                    style = MaterialTheme.typography.displayMedium
                )

            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Cari"
                )
                Text(
                    text = stringResource(R.string.cari),
                    style = MaterialTheme.typography.displayMedium
                )

            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Home"
                )
                Text(
                    text = stringResource(R.string.profil),
                    style = MaterialTheme.typography.displayMedium
                )

            }
        }
    }
}

@Composable
fun PesertaIcon(
    @StringRes nama: Int,
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
@Composable
private fun DetailButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowForwardIos,
            contentDescription = "Arrow Detail"
        )
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
