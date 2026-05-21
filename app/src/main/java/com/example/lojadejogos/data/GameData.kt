package com.example.lojadejogos.data

import com.example.lojadejogos.R
import com.example.lojadejogos.model.Game

object GameData {
    val games = listOf(
        Game(
            1, "God of War", "Santa Monica Studio", "Ação, Aventura", 199.90, 4.9,
            "Embarque em uma jornada épica e emocionante na pele de Kratos, um guerreiro espartano que se tornou pai novamente. No mundo nórdico selvagem, ele deve lutar para cumprir uma promessa pessoal.",
            R.drawable.banner_god_of_war, R.drawable.banner_god_of_war, true, "25 horas jogadas"
        ),
        Game(
            2, "Red Dead Redemption 2", "Rockstar Games", "Ação, Aventura", 149.90, 4.8,
            "Arthur Morgan e a gangue Van der Linde são foras da lei em fuga. Com agentes federais e os melhores caçadores de recompensas do país se unindo em sua perseguição, a gangue deve roubar, assaltar e lutar para sobreviver.",
            R.drawable.banner_red_dead, R.drawable.banner_red_dead, false
        ),
        Game(
            3, "Horizon Forbidden West", "Guerrilla Games", "Ação, RPG", 199.90, 4.7,
            "Junte-se a Aloy enquanto ela enfrenta a fronteira proibida - uma fronteira majestosa, mas perigosa, que esconde novas ameaças misteriosas.",
            R.drawable.banner_horizon, R.drawable.banner_horizon, true, "40 horas jogadas"
        ),
        Game(
            4, "The Witcher 3: Wild Hunt", "CD PROJEKT RED", "RPG, Aventura", 89.90, 4.9,
            "Torne-se um caçador de monstros profissional e embarque em uma aventura de proporções épicas! Após o seu lançamento, The Witcher 3: Wild Hunt tornou-se um clássico instantâneo, recebendo mais de 250 prêmios de Jogo do Ano.",
            R.drawable.banner_witcher, R.drawable.banner_witcher, true, "120 horas jogadas"
        ),
        Game(
            5, "Elden Ring", "FromSoftware", "RPG, Ação", 249.90, 4.9,
            "Levante-se, Maculado, e seja guiado pela graça para portar o poder do Anel Prínscipe e se tornar um Lorde Prínscipe nas Terras Intermédias.",
            R.drawable.banner_elden_ring, R.drawable.banner_elden_ring, false
        )
    )
}
