-- password => Aeiou123-

insert into app_user (full_name, email, password) values
('MABEL ZÁRATE', 'mzarate@gmail.com', '$2a$10$rFiZHSbHkwEeeitPkfFv3OyvomcySxYCnKdV0VNMriIAx2vDU/Q56'),

insert into meal (name) values
('POLLO A LA BRASA'), --1
('CEVICHE'), --2
('LOMO SALTADO'), --3
('ARROZ CHAUFA'), --4
('PACHAMANCA'); --5

insert into ingredient (name) values
('POLLO'), --1
('PATATA'), --2
('PESCADO'), --3
('CEBOLLA'), --4
('ROCOTO'), --5
('BATATA'), --6
('LIMA'), --7
('BISTECK'), --8
('TOMATE'), --9
('ARROZ'), --10
('CEBOLLA CHINA'), --11
('GENJIBRE'), --12
('HABAS'), --13
('MAIZ'), --14
('MAYONESA'), --15
('ZANAHORIA'), --16
('ALBERJAS'), --17
('AJI AMARILLO'), --18
('CABRITO'), --19
('YUCA'); --20

insert into measurement_unit (name, symbol, is_measurable) values
('kilo(s)', 'kg', true),
('litro(s)', 'l', true),
('unidad(es)', 'unid', true);

insert into measured_ingredient (ingredient_id, measurement_unit_id) values
(1, 1), -- pollo kg
(2, 1), -- patata kg
(3, 1), -- pescado kg
(4, 1), -- cebolla kg
(5, 1), -- rocoto kg
(6, 1), -- batata kg
(7, 3), -- lima kg
(8, 1), -- bisteck kg
(9, 1), -- tomate kg
(10, 1), -- arroz kg
(11, 1), -- cebolla china kg
(12, 1), -- genjibre kg
(13, 1), -- habas kg
(14, 3), -- maiz kg
(15, 2), -- mayonesa kg
(16, 1), -- zanahoria kg
(17, 1), -- alberjas kg
(18, 1), -- aji amarillo kg
(19, 1), -- cabrito kg
(20, 1); -- yuca kg

insert into meal_detail (meal_id, measured_ingredient_id, quantity) values
(1, 1, 0.35),(1, 2, 0.2),
(2, 3, 0.3),(2, 4, 0.1),(2, 5, 0.01),(2, 6, 0.25),(2, 7, 3),
(3, 2, 0.2),(3, 4, 0.1),(3, 8, 0.35),(3, 9, 0.25),(3, 10, 0.25),
(4, 1, 0.2),(4, 10, 0.25),(4, 11, 0.02),(4, 12, 0.01),
(5, 1, 0.25),(5, 2, 0.2),(5, 5, 0.01),(5, 6, 0.1),(5, 13, 0.05),(5, 14, 1);
