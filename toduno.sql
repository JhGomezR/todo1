-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-04-2023 a las 19:07:34
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `toduno`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `categoria_id` int(11) NOT NULL,
  `c_nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`categoria_id`, `c_nombre`) VALUES
(3, 'Alternativos'),
(2, 'DC Comics'),
(1, 'Marvel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cliente_id` int(11) NOT NULL,
  `c_nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `c_apellido` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `c_direccion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `c_documento_tipo` int(1) NOT NULL COMMENT '1 CEDULA, 2 PASAPORTE, T EXTRANGERIA',
  `c_num_documento` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cliente_id`, `c_nombre`, `c_apellido`, `c_direccion`, `c_documento_tipo`, `c_num_documento`) VALUES
(1, 'Cliente 1', 'Cliente 2', 'Call 1 # 1-1', 1, '098761234'),
(2, 'Cliente 2', 'Cliente 2', 'Call 2 # 2-2', 2, '123EDS234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE `detalle_factura` (
  `df_id` int(11) NOT NULL,
  `df_factura_fk` int(11) NOT NULL,
  `df_producto_id` int(11) NOT NULL,
  `df_producto_cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `entrada_id` int(11) NOT NULL,
  `e_fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `e_proveedor` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `e_factura` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `e_usuario_fk` int(11) NOT NULL,
  `e_producto_fk` int(11) NOT NULL,
  `e_cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`entrada_id`, `e_fecha`, `e_proveedor`, `e_factura`, `e_usuario_fk`, `e_producto_fk`, `e_cantidad`) VALUES
(1, '2023-04-18 09:14:58', 'Marvel Comics', 'FACT1234', 1, 1, 15),
(2, '2023-04-18 09:14:58', 'Alternativos', 'FACT567', 2, 2, 120);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `factura_id` int(11) NOT NULL,
  `f_vendedor_fk` int(11) NOT NULL,
  `f_cliente_fk` int(11) NOT NULL,
  `f_fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `f_otp` varchar(6) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `producto_id` int(11) NOT NULL,
  `p_nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL COMMENT 'alfa numerico que determina nombre producto',
  `p_tipo` varchar(20) COLLATE utf8_spanish_ci NOT NULL COMMENT 'alfa numerico que determina nombre tipo producto',
  `p_categoria_fk` int(11) NOT NULL,
  `p_precio_compra` double(9,2) NOT NULL COMMENT 'numerico que determina valor en numeros de producto',
  `p_precio_venta` double(9,2) NOT NULL,
  `p_cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`producto_id`, `p_nombre`, `p_tipo`, `p_categoria_fk`, `p_precio_compra`, `p_precio_venta`, `p_cantidad`) VALUES
(1, 'Avenger', 'Camiseta', 1, 12000.00, 21000.00, 12),
(2, 'Muñeco plastilina', 'Juguete', 3, 3400.00, 7000.00, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE `salida` (
  `salida_id` int(11) NOT NULL,
  `s_fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `s_usuario_fk` int(11) NOT NULL,
  `s_producto_fk` int(11) NOT NULL,
  `s_cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL,
  `u_nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `u_apellido` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `u_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario_id`, `u_nombre`, `u_apellido`, `u_documento`) VALUES
(1, 'Usuario 1', 'Usuario 1', 12345677),
(2, 'Usuario 2', 'Usuario 2', 9876);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoria_id`),
  ADD UNIQUE KEY `categoria` (`c_nombre`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cliente_id`);

--
-- Indices de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD PRIMARY KEY (`df_id`),
  ADD KEY `df_factura_fk` (`df_factura_fk`),
  ADD KEY `df_producto_id` (`df_producto_id`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`entrada_id`),
  ADD KEY `e_usuario_fk` (`e_usuario_fk`),
  ADD KEY `e_producto_fk` (`e_producto_fk`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`factura_id`),
  ADD KEY `f_vendedor_fk` (`f_vendedor_fk`),
  ADD KEY `f_cliente_fk` (`f_cliente_fk`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`producto_id`),
  ADD UNIQUE KEY `p_categoria_fk` (`p_categoria_fk`);

--
-- Indices de la tabla `salida`
--
ALTER TABLE `salida`
  ADD PRIMARY KEY (`salida_id`),
  ADD KEY `s_producto_fk` (`s_producto_fk`),
  ADD KEY `s_usuario_fk` (`s_usuario_fk`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `categoria_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cliente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  MODIFY `df_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `entrada_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `factura_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `producto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `salida`
--
ALTER TABLE `salida`
  MODIFY `salida_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `detalle_factura_ibfk_1` FOREIGN KEY (`df_factura_fk`) REFERENCES `factura` (`factura_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_factura_ibfk_2` FOREIGN KEY (`df_producto_id`) REFERENCES `producto` (`producto_id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`e_usuario_fk`) REFERENCES `usuario` (`usuario_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `entrada_ibfk_2` FOREIGN KEY (`e_producto_fk`) REFERENCES `producto` (`producto_id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`f_cliente_fk`) REFERENCES `cliente` (`cliente_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`f_vendedor_fk`) REFERENCES `usuario` (`usuario_id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`p_categoria_fk`) REFERENCES `categoria` (`categoria_id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `salida_ibfk_1` FOREIGN KEY (`s_usuario_fk`) REFERENCES `usuario` (`usuario_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `salida_ibfk_2` FOREIGN KEY (`s_producto_fk`) REFERENCES `producto` (`producto_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
