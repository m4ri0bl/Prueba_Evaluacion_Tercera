# 🎮 Arcade de Puzzles Lógicos 🧩

## Un proyecto para la asignatura de Patrones de Diseño y Arquitectura de Software

![Badge Java](https://img.shields.io/badge/Java-11%2B-orange)
![Badge JavaFX](https://img.shields.io/badge/JavaFX-17.0.2-blue)
![Badge Hibernate](https://img.shields.io/badge/Hibernate-5.6.5-green)

## 📝 Descripción

¡Hola! Aquí te presento mi proyecto de arcade de puzzles lógicos. He implementado tres juegos clásicos relacionados con problemas de lógica y álgebra:

- 👑 **Problema de las N Reinas** - Colocar N reinas en un tablero sin que se amenacen
- 🐴 **Recorrido del Caballo** - Encontrar un camino para que el caballo recorra todo el tablero
- 🗼 **Torres de Hanoi** - Mover todos los discos de una torre a otra siguiendo las reglas

Este proyecto integra varios patrones de diseño (Singleton, Factory Method, Facade, Adapter) dentro de una arquitectura MVC clara, usando JavaFX para la interfaz gráfica y Hibernate con H2 para la persistencia de datos.

## 🚀 Tecnologías utilizadas

- **Java 11** - Lenguaje base
- **JavaFX** - Para la interfaz gráfica (en lugar de Swing)
- **Hibernate** - ORM para persistencia
- **H2 Database** - Base de datos embebida
- **Maven** - Gestión de dependencias y build

## 🛠️ Cómo compilar y ejecutar

### Opción 1: Descargar el JAR ejecutable
1. Descarga el archivo `arcade-puzzles-1.0-SNAPSHOT.jar`
2. Ejecuta con doble clic o mediante terminal:
java -jar arcade-puzzles-1.0-SNAPSHOT.jar

### Opción 2: Compilar desde código fuente
1. Clona este repositorio
2. Asegúrate de tener Java 11+ y Maven instalados
3. Compila el proyecto:
mvn clean package
4. El JAR ejecutable se generará en la carpeta `target/`
5. Ejecuta el JAR:
java -jar target/arcade-puzzles-1.0-SNAPSHOT.jar

## 🎲 Cómo jugar

### Menú Principal
Al iniciar, verás el menú principal donde puedes elegir entre los tres juegos.

### 👑 N Reinas
- Ajusta el número de reinas con el slider
- Haz clic en "Resolver" para encontrar una solución
- Observa cómo las reinas se colocan sin amenazarse

### 🐴 Recorrido del Caballo
- Configura el tamaño del tablero
- Establece la posición inicial
- Haz clic en "Encontrar Recorrido"
- Verás el camino numerado que sigue el caballo

### 🗼 Torres de Hanoi
- Selecciona el número de discos
- Resuelve automáticamente o mueve los discos manualmente
- Intenta completarlo en el mínimo número de movimientos (2^n - 1)

## 🔍 Detalles de implementación

He aplicado varios patrones de diseño:

- **Singleton** para la configuración de Hibernate
- **Factory Method** para la creación de los juegos
- **Facade** para simplificar la interacción con cada juego
- **Adapter** para convertir los modelos en representaciones visuales

La arquitectura sigue el patrón MVC, separando claramente la lógica de juego (modelo), la visualización (vista) y la interacción del usuario (controlador).

## 📋 Notas

Este proyecto ha sido una excelente oportunidad para aplicar los conceptos teóricos vistos en clase en un caso práctico y entretenido. Me ha permitido profundizar en el diseño orientado a objetos y en la implementación de patrones.

---

⭐ Si te gusta este proyecto o tienes sugerencias, ¡házmelo saber en los comentarios! ⭐

---

*Desarrollado para la asignatura de Técnicas de Programación*