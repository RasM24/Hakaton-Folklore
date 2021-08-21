package ru.endroad.hakaton.shared.spot.remote

import ru.endroad.hakaton.shared.spot.entity.Position

//class RemoteDataSource(private val remoteSpotApi: RemoteSpotApi) {
class RemoteDataSource() {

	//	suspend fun getSpotList(): List<RemoteSpot> =
//		runCatching { requireNotNull(remoteSpotApi.getSpot()?.map(::convert)) }
//			.getOrDefault(mockData)
	fun getSpotList(): List<RemoteSpot> =
		mockData
}

fun convert(model: RemoteSpotModel): RemoteSpot =
	RemoteSpot(
		id = model.id,
		name = model.name,
		type = SpotType.valueOf(model.type),
		position = Position(model.lat, model.long),
	)

private val spot1 = RemoteSpot(0, "Боровичи", SpotType.Audio, Position(58.678106, 30.163324))
private val spot2 = RemoteSpot(0, "Мелковичи, источник", SpotType.Audio, Position(58.43797661369379, 30.19380509330799))
private val spot3 = RemoteSpot(0, "Ильмень, озеро", SpotType.Audio, Position(58.264326275652564, 31.27352891498032))
private val spot4 = RemoteSpot(0, "Трубчино, легендарная деревня", SpotType.Audio, Position(58.592011793046815, 31.30148636220892))
private val spot5 = RemoteSpot(0, "Легендарная деревня Гостцы", SpotType.Audio, Position(58.32101348206005, 31.70428619094406))
private val spot6 = RemoteSpot(0, "Камень Щеглец", SpotType.Audio, Position(58.69877768818958, 31.775990611820877))
private val spot7 = RemoteSpot(0, "Камень", SpotType.Comic, Position(58.05001548109481, 30.85162481388599))
private val spot8 = RemoteSpot(0, "Святые Колодцы в д. Пятница", SpotType.Comic, Position(58.56715209916098, 31.7232210174779))
private val spot9 = RemoteSpot(0, "Пороги на реке Мста", SpotType.Comic, Position(58.273684767715494, 34.07944541326673))
private val spot10 = RemoteSpot(0, "Легендарное село Любница", SpotType.Comic, Position(57.97461890365179, 32.69586114574689))
private val spot11 = RemoteSpot(0, "Пещеры реки Понеретка", SpotType.Comic, Position(58.27722563333236, 34.04288036256842))
private val spot12 = RemoteSpot(0, "Легендарное село Брызгово", SpotType.Comic, Position(58.36158319398794, 34.28461787033467))
private val spot13 = RemoteSpot(0, "Культовые камни Приильменья", SpotType.Meal, Position(58.47893442163523, 31.26666457877599))
private val spot14 = RemoteSpot(0, "Гора Ореховная", SpotType.Meal, Position(58.30935628804089, 35.03612103624113))
private val spot15 = RemoteSpot(0, "Источник Иверской Божией матери, д. Липицы,", SpotType.Meal, Position(57.648499, 32.593088))
private val spot16 = RemoteSpot(0, "Деревня Зеленый Бор и ее окрестности", SpotType.Meal, Position(58.03640756014445, 32.609396357042456))
private val spot17 = RemoteSpot(0, "Раменские луга – Крестецкий район,", SpotType.Meal, Position(58.35735298885231, 32.600952821030425))
private val spot18 = RemoteSpot(0, "Озеро Городно", SpotType.Meal, Position(58.83495756620116, 33.91988061383172))
private val spot19 = RemoteSpot(0, "Святой ключик у деревни Ямская Слобода", SpotType.Parking, Position(58.257592804855726, 32.51770560366006))
private val spot20 = RemoteSpot(0, "Рёконьский монастырь", SpotType.Parking, Position(59.344470864466736, 33.14936690073684))
private val spot21 = RemoteSpot(0, "Княжский камень", SpotType.Parking, Position(58.582672713971675, 31.27574500073684))
private val spot22 = RemoteSpot(0, "озеро Коробожа (Карабожа)", SpotType.Parking, Position(58.666838897927356, 34.45496491688757))
private val spot23 = RemoteSpot(0, "Каплино, древнее поселение", SpotType.Parking, Position(58.55705315874014, 34.596418789770006))
private val spot24 = RemoteSpot(0, "Легенда о реке Китьма и г Пестово", SpotType.Parking, Position(58.60417048305641, 35.79886375979986))
private val spot25 = RemoteSpot(0, "Деревня сказочницы Агафьи", SpotType.Photo, Position(58.401343575280535, 32.85284962565737))
private val spot26 = RemoteSpot(0, "Святой источник Андрея Первозванного", SpotType.Photo, Position(57.44716472666878, 31.39868864171612))
private val spot27 = RemoteSpot(0, "Морильницкое озеро", SpotType.Photo, Position(58.15413067355802, 30.783962678368006))
private val spot28 = RemoteSpot(0, "Змеиный камень, Игоревские мхи", SpotType.Photo, Position(58.76026156544781, 34.699744071711365))
private val spot29 = RemoteSpot(0, "Карстовый провал «Провалучая яма»", SpotType.Photo, Position(58.80364222652329, 34.143733269856895))
private val spot30 = RemoteSpot(0, "Церковь Святого Великомученика Мины", SpotType.Photo, Position(58.01764585855115, 31.338844326812545))
private val spot31 = RemoteSpot(0, "Путевой дворец Екатерины II", SpotType.Photo, Position(58.21639203727211, 30.995521555097906))
private val spot32 = RemoteSpot(0, "Фонтан 'Садко и царевна Волхова'", SpotType.Photo, Position(58.526422319010344, 31.27498629279624))
private val spot33 = RemoteSpot(0, "Легенда о могиле Богатыря", SpotType.Photo, Position(58.660552815069636, 31.744331326163906))
private val spot34 = RemoteSpot(0, "Культовый Камень медведица", SpotType.Photo, Position(58.371811456939724, 31.171403320958834))
private val spot35 = RemoteSpot(0, "Валун у деревни войцы", SpotType.Photo, Position(58.3489001165251, 31.615828754693602))

val mockData: List<RemoteSpot> = listOf(
	spot1,
	spot2,
	spot3,
	spot4,
	spot5,
	spot6,
	spot7,
	spot8,
	spot9,
	spot10,
	spot11,
	spot12,
	spot13,
	spot14,
	spot15,
	spot16,
	spot17,
	spot18,
	spot19,
	spot20,
	spot21,
	spot22,
	spot23,
	spot24,
	spot25,
	spot26,
	spot27,
	spot28,
	spot29,
	spot30,
	spot31,
	spot32,
	spot33,
	spot34,
	spot35,
)