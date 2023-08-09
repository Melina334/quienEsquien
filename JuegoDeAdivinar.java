package QuienEsQuien;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class JuegoDeAdivinar {

	public static void main(String[] args) {

		boolean jugarDeNuevo;

		do {
			String[] personajes = { "Laura", "Francisco", "Tomas", "Bea", "Gloria", "Ignacio", "Marina", "Rocio",
					"Belen", "Carlos", "Antonio", "Alejandra" };
			String[] preguntas = { "¿Es mujer?", "¿Es rubio/castaño?", "¿Es moreno de piel?",
					"¿Tiene pelo corto o atado?", "¿Tiene accesorios en su pelo?", "¿Tiene anteojos?", "Es colorado?",
					"¿Su remera es color violeta o verde?" };
			String[][] respuestas = { { "Si", "No", "No", "Si", "No", "No", "No", "No" },
					{ "No", "No", "No", "Si", "No", "No", "Si", "Si" },
					{ "No", "No", "Si", "Si", "No", "No", "No", "No" },
					{ "Si", "No", "Si", "Si", "No", "No", "No", "Si" },
					{ "Si", "Si", "No", "Si", "Si", "Si", "No", "No" },
					{ "No", "No", "Si", "Si", "No", "No", "No", "No" },
					{ "Si", "No", "No", "No", "No", "No", "No", "No" },
					{ "Si", "No", "No", "Si", "Si", "No", "Si", "No" },
					{ "Si", "Si", "No", "No", "Si", "No", "No", "Si" },
					{ "No", "Si", "No", "Si", "No", "No", "No", "Si" },
					{ "No", "Si", "Si", "No", "No", "No", "No", "Si" },
					{ "Si", "No", "No", "Si", "Si", "Si", "No", "Si" } };

			int indicePersonaje = (int) (Math.random() * personajes.length);
			String personajeAdivinar = personajes[indicePersonaje];

			JOptionPane.showMessageDialog(null,
					"¡Bienvenido/a al juego de adivinar personajes!\n" + "Toca OK para ver las instruciones",
					"Juego de Adivinar Personaje", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(JuegoDeAdivinar.class.getResource("adivinapersonaje.png")));

			JOptionPane.showMessageDialog(null, "¡Bienvenido/a al juego de adivinar personajes!\n"
					+ "Te tocara uno de estos personajes y tendras que acordarte de sus caracteristicas para responder\n"
					+ "las siguientes preguntas y que la maquina pueda adivinar o no", "Juego de Adivinar Personaje",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(JuegoDeAdivinar.class.getResource("quienesquien0.0.jpg")));

			JOptionPane.showMessageDialog(null, "tu personaje es " + personajeAdivinar);

			boolean personajeEncontrado = false;
			int preguntaActual = 0;

			do {
				String respuesta = JOptionPane.showInputDialog(null, preguntas[preguntaActual], "Pregunta",
						JOptionPane.QUESTION_MESSAGE);

				if (respuesta != null) {
					respuesta = respuesta.toLowerCase();

					switch (preguntaActual) {
					case 0:
						if (respuesta.equals("si")) {
							for (int i = 0; i < personajes.length; i++) {
								if (personajes[i] != null && !respuestas[i][preguntaActual].equalsIgnoreCase("Si")) {
									personajes[i] = null;
								}
							}
						} else if (respuesta.equals("no")) {
							for (int i = 0; i < personajes.length; i++) {
								if (personajes[i] != null && !respuestas[i][preguntaActual].equalsIgnoreCase("No")) {
									personajes[i] = null;
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Por favor, ingresa una respuesta válida (Si o No).",
									"Respuesta Inválida", JOptionPane.WARNING_MESSAGE);
							preguntaActual--;
						}
						break;
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
						if (respuesta.equals("si")) {
							for (int i = 0; i < personajes.length; i++) {
								if (personajes[i] != null && !respuestas[i][preguntaActual].equalsIgnoreCase("Si")) {
									personajes[i] = null;
								}
							}
						} else if (respuesta.equals("no")) {
							for (int i = 0; i < personajes.length; i++) {
								if (personajes[i] != null && !respuestas[i][preguntaActual].equalsIgnoreCase("No")) {
									personajes[i] = null;
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Por favor, ingresa una respuesta válida (Si o No).",
									"Respuesta Inválida", JOptionPane.WARNING_MESSAGE);
							preguntaActual--;
						}
						break;
					default:
						JOptionPane.showMessageDialog(null, "Pregunta inválida.", "Pregunta Inválida",
								JOptionPane.WARNING_MESSAGE);
						preguntaActual--;
						break;
					}

					preguntaActual++;

					// Verificar si se encontró el personaje
					personajeEncontrado = false;
					int cantidadPersonajesValidos = 0;
					for (int i = 0; i < personajes.length; i++) {
						if (personajes[i] != null) {
							cantidadPersonajesValidos++;
							if (cantidadPersonajesValidos > 1) {

							} else {
								personajeEncontrado = true;
								indicePersonaje = i;
							}
						}
					}

				}

			} while (preguntaActual < preguntas.length);

			if (personajeEncontrado) {
				String esONo = JOptionPane.showInputDialog(null,
						"Ya se! te toco el personaje: " + personajes[indicePersonaje] + " es ella/el? (s/n)", "Resultado",
						JOptionPane.QUESTION_MESSAGE);
				   if (esONo.toLowerCase().equals("no")) 
				  JOptionPane.showMessageDialog(null, "Que mal! Entonces no se quien te toco!",
							"Resultado", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(JuegoDeAdivinar.class.getResource("llorando.gif")));
				      if (esONo.toLowerCase().equals("si")) 
					  JOptionPane.showMessageDialog(null, "Que emocion, pude adivinar!!!",
								"Resultado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(JuegoDeAdivinar.class.getResource("festejo.gif")));
				
			} else {
				JOptionPane.showMessageDialog(null, "No pude adivinar el personaje en el que estabas pensando.",
						"Resultado", JOptionPane.INFORMATION_MESSAGE,  new ImageIcon(JuegoDeAdivinar.class.getResource("pensando1.gif")));
			}

			String respuestaJugarDeNuevo = JOptionPane.showInputDialog(null, "¿Deseas jugar de nuevo? (s/n)",
					"Jugar de Nuevo", JOptionPane.QUESTION_MESSAGE);
			jugarDeNuevo = respuestaJugarDeNuevo != null && respuestaJugarDeNuevo.toLowerCase().equals("si");

		} while (jugarDeNuevo);

		JOptionPane.showMessageDialog(null, "Gracias por jugar, hasta la proxima!", "Despedida",
				JOptionPane.INFORMATION_MESSAGE,
				 new ImageIcon(JuegoDeAdivinar.class.getResource("hastapronto.gif")));
	}

}