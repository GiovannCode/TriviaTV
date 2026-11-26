package com.example.triviatv

object TriviaRepository {

    const val CAT_CULTURE = "Cultura General"
    const val CAT_SCIENCE = "Ciencia"
    const val CAT_TECH = "Tecnología"
    const val CAT_SPORTS = "Deportes"
    const val CAT_ENTERTAINMENT = "Entretenimiento"

    fun getQuestionsForCategory(category: String): List<Question> {
        return when (category) {
            CAT_CULTURE -> listOf(
                Question(1, CAT_CULTURE, "¿Cuál es el país más grande del mundo por superficie?", listOf("Canadá", "China", "Rusia", "Estados Unidos"), 2),
                Question(2, CAT_CULTURE, "¿En qué continente se encuentra Egipto?", listOf("África", "Asia", "Europa", "América"), 0),
                Question(3, CAT_CULTURE, "¿Cuál es la capital de Japón?", listOf("Seúl", "Tokio", "Pekín", "Kioto"), 1),
                Question(4, CAT_CULTURE, "¿Qué río es el más largo del mundo?", listOf("Amazonas", "Nilo", "Misisipi", "Yangtsé"), 1),
                Question(5, CAT_CULTURE, "¿Quién pintó la Mona Lisa?", listOf("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"), 2)
            )
            CAT_SCIENCE -> listOf(
                Question(1, CAT_SCIENCE, "¿Cuál es el elemento químico con símbolo H?", listOf("Helio", "Hidrógeno", "Hierro", "Hafnio"), 1),
                Question(2, CAT_SCIENCE, "¿Qué planeta es conocido como el planeta rojo?", listOf("Venus", "Júpiter", "Marte", "Saturno"), 2),
                Question(3, CAT_SCIENCE, "¿Cuál es la velocidad de la luz en el vacío?", listOf("300,000 km/s", "150,000 km/s", "1,000 km/s", "3,000,000 km/s"), 0),
                Question(4, CAT_SCIENCE, "¿Qué gas absorben las plantas durante la fotosíntesis?", listOf("Oxígeno", "Nitrógeno", "Dióxido de carbono", "Hidrógeno"), 2),
                Question(5, CAT_SCIENCE, "¿Cuál es el hueso más largo del cuerpo humano?", listOf("Húmero", "Fémur", "Tibia", "Radio"), 1)
            )
            CAT_TECH -> listOf(
                Question(1, CAT_TECH, "¿Qué significa la sigla 'CPU' en informática?", listOf("Central Process Unit", "Computer Personal Unit", "Central Processing Unit", "Control Program Utility"), 2),
                Question(2, CAT_TECH, "¿Quién cofundó Apple junto a Steve Wozniak?", listOf("Bill Gates", "Steve Jobs", "Mark Zuckerberg", "Jeff Bezos"), 1),
                Question(3, CAT_TECH, "¿Cuál fue el primer lenguaje de programación moderno ampliamente utilizado?", listOf("Python", "Fortran", "Java", "C++"), 1),
                Question(4, CAT_TECH, "¿Qué compañía desarrolla el sistema operativo Android?", listOf("Apple", "Microsoft", "Google", "IBM"), 2),
                Question(5, CAT_TECH, "¿Qué significan las siglas 'HTML' en la web?", listOf("HyperText Markup Language", "High Tech Modern Link", "HyperTransfer Machine Language", "Home Tool Markup Language"), 0)
            )
            CAT_SPORTS -> listOf(
                Question(1, CAT_SPORTS, "¿Cada cuántos años se celebran los Juegos Olímpicos?", listOf("2 años", "3 años", "4 años", "5 años"), 2),
                Question(2, CAT_SPORTS, "¿Cuántos jugadores forman un equipo de fútbol en el campo?", listOf("9", "10", "11", "12"), 2),
                Question(3, CAT_SPORTS, "¿En qué deporte destacó Michael Jordan?", listOf("Fútbol americano", "Béisbol", "Baloncesto", "Tenis"), 2),
                Question(4, CAT_SPORTS, "¿Cuál es el país de origen del sumo?", listOf("China", "Japón", "Corea del Sur", "Tailandia"), 1),
                Question(5, CAT_SPORTS, "¿Qué Grand Slam de tenis se juega sobre superficie de arcilla (polvo de ladrillo)?", listOf("Abierto de Australia", "Wimbledon", "Roland Garros", "Abierto de EE. UU."), 2)
            )
            CAT_ENTERTAINMENT -> listOf(
                Question(1, CAT_ENTERTAINMENT, "¿Quién dirigió la trilogía de películas de 'El Señor de los Anillos'?", listOf("Steven Spielberg", "Christopher Nolan", "Peter Jackson", "James Cameron"), 2),
                Question(2, CAT_ENTERTAINMENT, "¿Cuál es la casa de Hogwarts a la que pertenece Harry Potter?", listOf("Slytherin", "Gryffindor", "Ravenclaw", "Hufflepuff"), 1),
                Question(3, CAT_ENTERTAINMENT, "¿Qué actor interpreta a Iron Man en el Universo Cinematográfico de Marvel?", listOf("Chris Evans", "Tom Holland", "Robert Downey Jr.", "Mark Ruffalo"), 2),
                Question(4, CAT_ENTERTAINMENT, "¿Cómo se llama el vaquero protagonista en Toy Story?", listOf("Buzz Lightyear", "Woody", "Andy", "Rex"), 1),
                Question(5, CAT_ENTERTAINMENT, "¿Qué serie de televisión popular presenta un tablero de luces navideñas y un mundo llamado 'El Otro Lado'?", listOf("Breaking Bad", "Stranger Things", "Game of Thrones", "The Walking Dead"), 1)
            )
            else -> emptyList()
        }
    }
}
