-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-08-2025 a las 20:22:20
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_cinemania_grupo3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asientos`
--

CREATE TABLE `asientos` (
  `id` int(20) NOT NULL,
  `asiento` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asientos`
--

INSERT INTO `asientos` (`id`, `asiento`, `estado`) VALUES
(1, 'AA1', 'desocupado'),
(2, 'AA2', 'desocupado'),
(3, 'AA3', 'desocupado'),
(4, 'AB1', 'desocupado'),
(5, 'AB2', 'desocupado'),
(6, 'AB3', 'desocupado'),
(7, 'AC1', 'desocupado'),
(8, 'AC2', 'desocupado'),
(9, 'AC3', 'desocupado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `id` int(11) NOT NULL,
  `id_venta` int(11) DEFAULT NULL,
  `nombre_producto` varchar(100) DEFAULT NULL,
  `tipo_producto` varchar(50) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_unitario` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`id`, `id_venta`, `nombre_producto`, `tipo_producto`, `cantidad`, `precio_unitario`) VALUES
(13, 38, '2D', 'BOLETO ADULTO', 1, 110.00),
(14, 38, '2D', 'BOLETO ADULTO', 1, 110.00),
(15, 38, 'comida', 'Palomita', 1, 28.00),
(16, 39, '2D', 'BOLETO ADULTO', 1, 110.00),
(17, 39, '2D', 'BOLETO ADULTO', 1, 110.00),
(18, 39, 'comida', 'Hot Dogs', 1, 70.00),
(19, 40, '2D', 'BOLETO ADULTO', 1, 110.00),
(20, 40, 'comida', 'Palomita', 1, 28.00),
(21, 41, '2D', 'BOLETO ADULTO', 1, 110.00),
(22, 41, '2D', 'BOLETO ADULTO', 1, 110.00),
(23, 41, 'comida', 'Palomita', 1, 28.00),
(24, 41, 'comida', 'Palomita', 1, 28.00),
(25, 42, '2D', 'BOLETO ADULTO', 1, 110.00),
(26, 42, 'comida', 'Palomita', 1, 28.00),
(27, 43, 'BOLETO ADULTO', '2D', 1, 110.00),
(28, 43, 'BOLETO ADULTO', '2D', 1, 110.00),
(29, 43, 'Palomita', 'comida', 1, 28.00),
(30, 43, 'Palomita', 'comida', 1, 28.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id_horario` int(11) NOT NULL,
  `pelicula` varchar(100) NOT NULL,
  `sala` varchar(50) NOT NULL,
  `dia` varchar(20) NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`id_horario`, `pelicula`, `sala`, `dia`, `hora_inicio`, `hora_fin`, `estado`) VALUES
(1, 'CLUELESS', 'SALA VIP', 'Lunes', '21:30:22', '22:30:22', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos_inventario`
--

CREATE TABLE `movimientos_inventario` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  `movimiento` enum('entrada','salida') DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `motivo` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `vencimiento` date DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimientos_inventario`
--

INSERT INTO `movimientos_inventario` (`id`, `descripcion`, `movimiento`, `cantidad`, `motivo`, `fecha`, `vencimiento`, `estado`) VALUES
(1, 'PALOMITAS', 'entrada', 10, 'COMPRA', '2025-08-01', '2025-08-08', 'Activo'),
(2, 'SNICKER ALMOND', 'entrada', 5, 'COMPRA', '2025-08-01', NULL, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `duracion` TIME DEFAULT NULL,
  `clasificacion` varchar(50) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `titulo`, `duracion`, `clasificacion`, `imagen`, `estado`) VALUES
(1, 'LADY BIRD', '02:00:00', 'ADOLESCENTE', 'C:\\imagenes\\LadyBird.jpg', 'Inactivo'),
(2, 'CLUELESS', '01:00:00', 'ADOLESCENTE', 'C:\\imagenes\\clueless.jpg', 'Activo'),
(3, '', '  :  :  ', '', 'C:\\imagenes\\clueless.jpg', 'Inactivo'),
(4, '13 GOING 30', '01:59:20', 'ADULTOS', 'C:\\imagenes\\13going30.jpg', 'Activo'),
(5, 'WICKED', '02:00:30', 'FAMILIAR', 'C:\\imagenes\\Wicked.jpg', 'Activo'),
(6, 'ABOUT TIME', '02:00:50', 'ROMANCE', 'C:\\imagenes\\AboutTime.jpg', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `costo` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `utilidad` decimal(10,2) NOT NULL,
  `proveedor` varchar(50) DEFAULT NULL,
  `stockMin` int(20) DEFAULT NULL,
  `stockMax` int(20) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `foto` varchar(250) NOT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `descripcion`, `costo`, `precio`, `utilidad`, `proveedor`, `stockMin`, `stockMax`, `tipo`, `foto`, `estado`) VALUES
(1, 'PALOMITAS', 20.00, 28.00, 8.00, 'COCA COLA', 10, 20, 'COMIDA', 'C:\\imagenesProductos\\popcorn.jpg', 'Activo'),
(2, 'SNICKER ALMOND', 10.00, 14.00, 4.00, 'DULCE', 5, 10, 'DULCE', 'C:\\imagenesProductos\\snicker.jpg', 'Activo'),
(3, 'GUM', 5.00, 7.00, 2.00, 'PEPSI', 0, 0, 'DULCE', 'C:\\imagenesProductos\\hubbaubba.jpg', 'Inactivo'),
(4, 'COCA COLA ', 20.00, 28.00, 8.00, 'BEBIDA ', 0, 0, 'BEBIDA ', 'C:\\imagenesProductos\\popcorn.jpg', 'Inactivo'),
(5, 'NACHOS', 10.00, 14.00, 4.00, 'PEPSI', 3, 9, 'COMIDA', 'C:\\imagenesProductos\\twix.jpg', 'Activo'),
(6, 'COCACOLA', 20.00, 28.00, 8.00, 'COCA COLA', 5, 20, 'BEBIDA ', 'C:\\imagenesProductos\\CocacolaLata.jpg', 'Activo'),
(7, '2 CHILIDOGS', 130.00, 182.00, 52.00, 'CINEMANIA', 2, 10, 'COMBO', 'C:\\imagenesProductos\\chilidos.png', 'Activo'),
(8, '2 NACHOS COMPLETOS', 150.00, 210.00, 60.00, 'COMBO', 2, 10, 'COMBO', 'C:\\imagenesProductos\\2nachos.png', 'Activo'),
(9, '1 NACHO 1 REFRESO', 120.00, 168.00, 48.00, 'CINEMANIA', 2, 10, 'COMBO', 'C:\\imagenesProductos\\NachoRefresco.png', 'Activo'),
(10, '1 PALOMITA 1 NACHO', 160.00, 224.00, 64.00, 'CINEMANIA', 2, 10, 'COMBO', 'C:\\imagenesProductos\\PalomitaNachos.png', 'Activo'),
(11, '1 PALOMITA 1 SNICKER', 120.00, 168.00, 48.00, 'CINEMANIA', 2, 10, 'COMBO', 'C:\\imagenesProductos\\PalomitaSnicker.png', 'Activo'),
(12, '2 REFRESCOS 1 HOTDOG', 125.00, 175.00, 50.00, 'CINEMANIA', 2, 10, 'COMBO', 'C:\\imagenesProductos\\2RefrescosHotdgo.png', 'Activo'),
(13, 'HOTDOG', 50.00, 70.00, 20.00, 'CINEMANIA', 2, 20, 'COMIDA', 'C:\\imagenesProductos\\hotdog.png', 'Activo'),
(14, 'NACHOS ', 55.00, 77.00, 22.00, 'CINEMANIA', 5, 15, 'COMIDA', 'C:\\imagenesProductos\\nachos.png', 'Activo'),
(15, 'HAMBURGUESA', 35.00, 49.00, 14.00, 'CINEMANIA', 5, 15, 'COMIDA', 'C:\\imagenesProductos\\hamburguesa.png', 'Activo'),
(16, 'PORCION DE PIZZA', 35.00, 49.00, 14.00, 'CINEMANIA', 5, 15, 'COMIDA', 'C:\\imagenesProductos\\pizza.png', 'Activo'),
(17, 'ENSALDA ', 60.00, 84.00, 24.00, 'CINEMANIA', 5, 15, 'COMIDA', 'C:\\imagenesProductos\\ensalada.png', 'Activo'),
(18, 'PEPSI', 18.00, 25.20, 7.20, 'PEPSI', 5, 20, 'BEBIDA ', 'C:\\imagenesProductos\\pepsiLata.jpg', 'Activo'),
(19, 'AGUA', 15.00, 21.00, 6.00, 'CERVECERIA HONDURENA', 5, 20, 'BEBIDA ', 'C:\\imagenesProductos\\agua.png', 'Activo'),
(20, 'MILKSHAKE DE FRESA', 70.00, 98.00, 28.00, 'CINEMANIA', 5, 20, 'BEBIDA ', 'C:\\imagenesProductos\\milkshake.png', 'Activo'),
(21, 'GATORADE ', 30.00, 42.00, 12.00, 'PEPSI', 5, 20, 'BEBIDA ', 'C:\\imagenesProductos\\gatorade.png', 'Activo'),
(22, 'GRANITA', 35.00, 49.00, 14.00, 'CINEMANIA', 5, 20, 'BEBIDA ', 'C:\\imagenesProductos\\granita.png', 'Activo'),
(23, 'OREO', 10.00, 14.00, 4.00, 'MONDELEZ INTERNATIONAL', 2, 15, 'DULCE', 'C:\\imagenesProductos\\galletaOreo.png', 'Activo'),
(24, 'DONA', 15.00, 21.00, 6.00, 'DUNKIN DONUTS', 2, 15, 'DULCE', 'C:\\imagenesProductos\\Donut.jpg', 'Activo'),
(25, 'TWIX', 12.00, 16.80, 4.80, 'MONDELEZ INTERNATIONAL', 2, 15, 'DULCE', 'C:\\imagenesProductos\\twix.png', 'Activo'),
(26, 'ROL DE CANELA', 12.00, 16.80, 4.80, 'BIMBO', 2, 15, 'DULCE', 'C:\\imagenesProductos\\rolcanela.png', 'Activo'),
(27, 'PRETZEL', 15.00, 21.00, 6.00, 'CINEMANIA', 5, 15, 'DULCE', 'C:\\imagenesProductos\\pretzel.png', 'Activo'),
(28, 'CARAMELO', 3.00, 4.20, 1.20, 'PEPSI', 2, 4, 'DULCE', 'C:\\imagenesProductos\\granita.png', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `contacto` varchar(50) NOT NULL,
  `foto` varchar(250) NOT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `nombre`, `contacto`, `foto`, `estado`) VALUES
(1, 'COCA COLA', '240-103-2013', 'C:\\imagenesProveedores\\cocacola2.jpg', 'Activo'),
(2, 'NESTLE', '131-331-1311', 'C:\\imagenesProveedores\\nestle.jpg', 'Inactivo'),
(3, 'PEPSI', '213-145-2646', 'C:\\imagenesProveedores\\pepsi.jpg', 'Activo'),
(4, 'CERVECERIA HONDURENA', '213-125-2463', 'C:\\imagenesProveedores\\CeverceriaH', 'Activo'),
(5, 'MONDELEZ INTERNATIONAL', '213-125-2463', 'C:\\imagenesProveedores\\MOndelez.jpg', 'Activo'),
(6, 'DUNKIN DONUTS', '232-435-6537', 'C:\\imagenesProveedores\\dunking.jpg', 'Activo'),
(7, 'MILKSHAKES ', '233-424-5337', 'C:\\imagenesProveedores\\milkshake.jpg', 'Activo'),
(8, 'STARBUCKS', '222-122-3141', 'C:\\imagenesProveedores\\starbucks.jpg', 'Activo'),
(9, 'CINEMANIA', '122-124-3151', 'C:\\imagenesProveedores\\LogoCinem.png', 'Activo'),
(10, 'BIMBO', '132-132-1413', 'C:\\imagenesProveedores\\bimbo.jpg', 'Activo'),
(11, 'BURGUER KING', '   -   -    ', 'C:\\imagenesProveedores\\BK.jpg', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`id`, `nombre`, `capacidad`, `tipo`, `estado`) VALUES
(1, 'SALA VIP', 30, '3D', 'inactivo'),
(2, 'SALA VISIONX', 9, '3D', 'activo'),
(3, 'SALA VALLEY', 9, '2D', 'activo'),
(4, '98', 9, '3D', 'activo'),
(5, 'Cnagoora', 10, '2d', 'activo'),
(6, 'VIS', 10, '3D', 'activo'),
(7, 'guaro', 9, '3D', 'activo'),
(8, 'HELLO', 9, '3D', 'activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `usuario` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `contrasena` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `rol` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `usuario`, `contrasena`, `rol`, `estado`) VALUES
(1, '0', 'Lopez', 'admin', '12345', 'Administrador ', 'Inactivo'),
(2, 'Samuel', 'Lopez', 'admin', '12345', 'Administrador ', 'Activo'),
(3, 'Sebastian', 'Vasquez', 'cajero', '12345', 'Cajero', 'Inactivo'),
(4, 'Carmen', 'Sanchez', 'cajera', '12345', 'Cajero', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `cliente` varchar(100) DEFAULT NULL,
  `pelicula` varchar(100) DEFAULT NULL,
  `sala` varchar(50) DEFAULT NULL,
  `asiento` varchar(100) NOT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `isv` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `metodo_pago` varchar(20) DEFAULT NULL,
  `cantidad_pagar` decimal(10,2) DEFAULT NULL,
  `cambio` decimal(10,2) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `estado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `cliente`, `pelicula`, `sala`, `asiento`, `subtotal`, `isv`, `total`, `metodo_pago`, `cantidad_pagar`, `cambio`, `fecha`, `estado`) VALUES
(5, 'ANTONIA PEREZ', 'CLUELESS', 'SALA VALLEY', 'AB2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '07/08/25', 'Activo'),
(6, 'CATALINA', '13 GOING 30', 'SALA VALLEY', 'AB2', 138.00, 20.70, 158.70, 'EFECTIVO', 200.00, 41.30, '07/08/25', 'Activo'),
(7, 'CARMEN MOLINA', 'CLUELESS', 'SALA VALLEY', 'AC3', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '07/08/25', 'Activo'),
(8, 'MARCELA', '13 GOING 30', 'SALA VALLEY', 'AC2', 248.00, 37.20, 285.20, 'TARJETA', 285.20, 0.00, '07/08/25', 'Activo'),
(9, 'CAROLINA', '13 GOING 30', 'SALA VISIONX', 'AA3, AB3', 318.00, 47.70, 365.70, 'TARJETA', 365.70, 0.00, '08/08/25', 'Activo'),
(24, 'qreqr', 'WICKED', 'SALA VISIONX', 'AB2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '34/23/42', 'Activo'),
(25, 'WTWT', '13 GOING 30', 'SALA VALLEY', 'AA2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '32/13/13', 'Activo'),
(26, 'QWRQWRQ', '13 GOING 30', 'SALA VALLEY', 'AA1', 248.00, 37.20, 285.20, 'TARJETA', 285.20, 0.00, '24/24/42', 'Activo'),
(27, 'WEQEQWE', '13 GOING 30', 'SALA VISIONX', 'AB2', 688.00, 103.20, 791.20, 'TARJETA', 791.20, 0.00, '32/13/13', 'Activo'),
(28, 'rewrqe', 'CLUELESS', 'SALA VISIONX', 'AA2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '24/14/13', 'Activo'),
(29, 'EWEQW', '13 GOING 30', 'SALA VISIONX', 'AB2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '23/12/31', 'Activo'),
(30, 'weqwr', '13 GOING 30', 'SALA VALLEY', 'AB2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '24/21/41', 'Activo'),
(31, 'weewe', 'CLUELESS', 'SALA VALLEY', 'AB2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '23/21/34', 'Activo'),
(32, 'adasd', 'WICKED', 'SALA VALLEY', 'AB2', 166.00, 24.90, 190.90, 'TARJETA', 190.90, 0.00, '23/24/32', 'Activo'),
(33, 'r3qre', '13 GOING 30', 'SALA VISIONX', 'AB2', 166.00, 24.90, 190.90, 'TARJETA', 190.90, 0.00, '24/14/14', 'Activo'),
(34, 'WQR', '13 GOING 30', 'SALA VISIONX', 'AC2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '24/14/31', 'Activo'),
(35, 'EQWRQ', '13 GOING 30', 'SALA VISIONX', 'AC2, AC3', 276.00, 41.40, 317.40, 'TARJETA', 317.40, 0.00, '24/14/31', 'Activo'),
(36, 'QEQWE', '13 GOING 30', 'SALA VISIONX', 'AB2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '24/14/12', 'Activo'),
(37, 'RWQ', 'CLUELESS', 'SALA VALLEY', 'AA2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '42/14/31', 'Activo'),
(38, 'SFAF', '13 GOING 30', 'SALA VISIONX', 'AB2', 248.00, 37.20, 285.20, 'TARJETA', 285.20, 0.00, '24/24/22', 'Activo'),
(39, 'jose', '13 GOING 30', 'SALA VISIONX', 'AA1, AB2', 290.00, 43.50, 333.50, 'TARJETA', 333.50, 0.00, '93/93/99', 'Activo'),
(40, 'BELKIS BOBADILLA', 'WICKED', 'SALA VALLEY', 'AB2', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '29/18/92', 'Activo'),
(41, 'AMANDA ', 'WICKED', 'SALA VALLEY', 'AA1, AB1', 276.00, 41.40, 317.40, 'TARJETA', 317.40, 0.00, '21/32/13', 'Activo'),
(42, 'CAMERLA', 'WICKED', 'SALA VISIONX', 'AA1', 138.00, 20.70, 158.70, 'TARJETA', 158.70, 0.00, '32/13/13', 'Activo'),
(43, 'DAVID VEGA ', '13 GOING 30', 'SALA VALLEY', 'AA1', 276.00, 41.40, 317.40, 'TARJETA', 317.40, 0.00, '32/13/21', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asientos`
--
ALTER TABLE `asientos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_venta` (`id_venta`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id_horario`);

--
-- Indices de la tabla `movimientos_inventario`
--
ALTER TABLE `movimientos_inventario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asientos`
--
ALTER TABLE `asientos`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id_horario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `movimientos_inventario`
--
ALTER TABLE `movimientos_inventario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `salas`
--
ALTER TABLE `salas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
