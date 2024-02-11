package com.example.listpesertaquiz3.data

import androidx.annotation.StringRes
import com.example.listpesertaquiz3.R

data class Peserta (
    @StringRes val nama: Int,
    val umur: Int,
    @StringRes val domisili: Int
)
val Pesertas = listOf(
    Peserta(R.string.aisyah, 18, R.string.pekalongan),
    Peserta(R.string.adinda, 21, R.string.jakarta),
    Peserta(R.string.indriani, 19, R.string.gorontalo),
    Peserta(R.string.chandra, 25, R.string.jambi),
    Peserta(R.string.ummu_sualim, 27, R.string.pekalongan),
    Peserta(R.string.adinda06, 21, R.string.jakarta),
    Peserta(R.string.windriani, 19, R.string.gorontalo),
    Peserta(R.string.zainab, 25, R.string.jambi),
)