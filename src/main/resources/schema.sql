-- Archivo schema.sql para crear la estructura de la base de datos

-- Tabla para almacenar los resultados de los juegos
CREATE TABLE IF NOT EXISTS resultados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_juego VARCHAR(50) NOT NULL,
    parametros VARCHAR(255) NOT NULL,
    movimientos INTEGER,
    resuelto BOOLEAN,
    fecha TIMESTAMP
);

-- Índices para optimizar las consultas
CREATE INDEX IF NOT EXISTS idx_tipo_juego ON resultados(tipo_juego);
CREATE INDEX IF NOT EXISTS idx_fecha ON resultados(fecha);

-- Comentarios sobre la estructura
COMMENT ON TABLE resultados IS 'Almacena los resultados de las partidas de los tres juegos';
COMMENT ON COLUMN resultados.tipo_juego IS 'Tipo de juego: NReinas, RecorridoCaballo o TorresHanoi';
COMMENT ON COLUMN resultados.parametros IS 'Parámetros usados en el juego (N, posición inicial, etc.)';
COMMENT ON COLUMN resultados.movimientos IS 'Número de movimientos o iteraciones realizadas';
COMMENT ON COLUMN resultados.resuelto IS 'Indica si el juego se resolvió correctamente';
COMMENT ON COLUMN resultados.fecha IS 'Fecha y hora en que se jugó la partida';