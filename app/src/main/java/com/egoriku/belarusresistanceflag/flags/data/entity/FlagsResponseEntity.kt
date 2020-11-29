package com.egoriku.belarusresistanceflag.flags.data.entity

import com.google.gson.annotations.SerializedName

class FlagsResponseEntity(

    @SerializedName("collection")
    val collection: Collection
)

class Collection(

    @SerializedName("Мінск")
    val minsk: List<FlagEntity>,

    @SerializedName("Брэст")
    val brest: List<FlagEntity>,

    @SerializedName("Віцебск")
    val vitebsk: List<FlagEntity>,

    @SerializedName("Гомель")
    val gomel: List<FlagEntity>,

    @SerializedName("Гродна")
    val grodno: List<FlagEntity>,

    @SerializedName("Магілёў")
    val mogilev: List<FlagEntity>,

    @SerializedName("Рэгіёны")
    val region: List<FlagEntity>,

    @SerializedName("Дыяспара")
    val diaspora: List<FlagEntity>,

    @SerializedName("Iншае")
    val others: List<FlagEntity>,
)