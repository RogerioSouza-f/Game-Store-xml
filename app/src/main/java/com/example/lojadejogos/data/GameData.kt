package com.example.lojadejogos.data

import com.example.lojadejogos.R
import com.example.lojadejogos.model.Game

object GameData {
    val games = listOf(
        Game(
            id = 1,
            title = "God of War",
            developer = "Santa Monica Studio",
            category = "Ação, Aventura",
            price = 199.90,
            rating = 4.9,
            description = "Embarque em uma jornada épica e emocionante na pele de Kratos, um guerreiro espartano que se tornou pai novamente. No mundo nórdico selvagem, ele deve lutar para cumprir uma promessa pessoal.",
            bannerRes = R.drawable.banner_god_of_war,
            thumbnailRes = R.drawable.banner_god_of_war,
            isPurchased = false,
            isInstalled = false,
            isFavorite = false,
            playTime = "25 horas jogadas"
        ),
        Game(
            id = 2,
            title = "Red Dead Redemption 2",
            developer = "Rockstar Games",
            category = "Ação, Aventura",
            price = 149.90,
            rating = 4.8,
            description = "Arthur Morgan e a gangue Van der Linde são foras da lei em fuga. Com agentes federais e os melhores caçadores de recompensas do país se unindo em sua perseguição, a gangue deve roubar, assaltar e lutar para sobreviver.",
            bannerRes = R.drawable.banner_red_dead,
            thumbnailRes = R.drawable.banner_red_dead,
            isPurchased = false,
            isInstalled = false,
            isFavorite = false,
            playTime = null
        ),
        Game(
            id = 3,
            title = "Horizon Forbidden West",
            developer = "Guerrilla Games",
            category = "Ação, RPG",
            price = 199.90,
            rating = 4.7,
            description = "Junte-se a Aloy enquanto ela enfrenta a fronteira proibida - uma fronteira majestosa, mas perigosa, que esconde novas ameaças misteriosas.",
            bannerRes = R.drawable.banner_horizon,
            thumbnailRes = R.drawable.banner_horizon,
            isPurchased = false,
            isInstalled = false,
            isFavorite = false,
            playTime = "40 horas jogadas"
        ),
        Game(
            id = 4,
            title = "The Witcher 3: Wild Hunt",
            developer = "CD PROJEKT RED",
            category = "RPG, Aventura",
            price = 89.90,
            rating = 4.9,
            description = "Torne-se um caçador de monstros profissional e embarque em uma aventura de proporções épicas! Após o seu lançamento, The Witcher 3: Wild Hunt tornou-se um clássico instantâneo, recebendo mais de 250 prêmios de Jogo do Ano.",
            bannerRes = R.drawable.banner_witcher,
            thumbnailRes = R.drawable.banner_witcher,
            isPurchased = false,
            isInstalled = false,
            isFavorite = false,
            playTime = "120 horas jogadas"
        ),
        Game(
            id = 5,
            title = "Elden Ring",
            developer = "FromSoftware",
            category = "RPG, Ação",
            price = 249.90,
            rating = 4.9,
            description = "Levante-se, Maculado, e seja guiado pela graça para portar o poder do Anel Prínscipe e se tornar um Lorde Prínscipe nas Terras Intermédias.",
            bannerRes = R.drawable.banner_elden_ring,
            thumbnailRes = R.drawable.banner_elden_ring,
            isPurchased = false,
            isInstalled = false,
            isFavorite = false,
            playTime = null
        )
    )
}
