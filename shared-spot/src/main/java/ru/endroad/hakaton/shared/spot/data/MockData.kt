package ru.endroad.hakaton.shared.spot.data

import ru.endroad.hakaton.shared.spot.R
import ru.endroad.hakaton.shared.spot.entity.AudioSpot
import ru.endroad.hakaton.shared.spot.entity.ComicsSpot
import ru.endroad.hakaton.shared.spot.entity.Image
import ru.endroad.hakaton.shared.spot.entity.PanoramaPhotoSpot
import ru.endroad.hakaton.shared.spot.entity.Position
import ru.endroad.hakaton.shared.spot.entity.Text

internal val audiogidSpot = AudioSpot(0, Position(58.536558, 31.273916), Text(R.string.audio_novgorod), Image(R.drawable.photo_sight_opera))

internal val panoramaSpot1 = PanoramaPhotoSpot(0, Position(58.559221, 31.260249), Text(R.string.panorama_winter), "point/1/")
internal val panoramaSpot2 = PanoramaPhotoSpot(0, Position(58.555281, 31.300761), Text(R.string.panorama_ped), "point/2/")
internal val panoramaSpot3 = PanoramaPhotoSpot(0, Position(58.528764, 31.307970), Text(R.string.panorama_street), "point/3/")
internal val panoramaSpot4 = PanoramaPhotoSpot(0, Position(58.504558, 31.269862), Text(R.string.panorama_sight), "point/4/")
internal val panoramaSpot5 = PanoramaPhotoSpot(0, Position(58.515497, 31.232439), Text(R.string.panorama_lenin), "point/5/")
internal val panoramaSpot6 = PanoramaPhotoSpot(0, Position(58.543637, 31.212527), Text(R.string.panorama_gymnasium), "point/6/")

internal val comics1 = ComicsSpot(91, Position(58.535036, 31.081721), Text(R.string.comics_ermolaevo), Image(R.drawable.comics_ivan))
internal val comics2 = ComicsSpot(92, Position(58.447475, 31.338183), Text(R.string.comics_cerkov_nikoly), Image(R.drawable.comics_ivan))
internal val comics3 = ComicsSpot(93, Position(58.696130, 31.397921), Text(R.string.comics_podberezie), Image(R.drawable.comics_icona))
internal val comics4 = ComicsSpot(94, Position(58.727722, 29.812267), Text(R.string.comics_luga), Image(R.drawable.comics_icona))
internal val comics5 = ComicsSpot(95, Position(58.194729, 30.721386), Text(R.string.comics_shimskii), Image(R.drawable.comics_icona))