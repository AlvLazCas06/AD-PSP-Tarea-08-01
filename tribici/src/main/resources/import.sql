-- Insert Stations
INSERT INTO station (number, name, coordinates, capacity) VALUES (1, 'Plaza de Cuba', '37.37, -6.00', 10);
INSERT INTO station (number, name, coordinates, capacity) VALUES (2, 'Puerta Jerez', '37.38, -5.99', 15);
INSERT INTO station (number, name, coordinates, capacity) VALUES (3, 'Alameda de Hércules', '37.40, -5.99', 20);
INSERT INTO station (number, name, coordinates, capacity) VALUES (4, 'Santa Justa', '37.39, -5.97', 25);

-- Insert Users
INSERT INTO user_tribici (name, num_card, pin, balance) VALUES ('Usuario 1', '1234567890123456', '1234', 50.00);
INSERT INTO user_tribici (name, num_card, pin, balance) VALUES ('Usuario 2', '9876543210987654', '5678', 25.50);
INSERT INTO user_tribici (name, num_card, pin, balance) VALUES ('Usuario 3', '1122334455667788', '0000', 10.00);

-- Insert Bicycles
INSERT INTO bicycle (brand, model, status, station_id) VALUES ('Marca A', 'Modelo X', 'NEW', 1);
INSERT INTO bicycle (brand, model, status, station_id) VALUES ('Marca B', 'Modelo Y', 'OLD', 1);
INSERT INTO bicycle (brand, model, status, station_id) VALUES ('Marca C', 'Modelo Z', 'NEW', 2);
INSERT INTO bicycle (brand, model, status, station_id) VALUES ('Marca A', 'Modelo X', 'OLD', 3);
INSERT INTO bicycle (brand, model, status, station_id) VALUES ('Marca B', 'Modelo Y', 'NEW', 4);

-- Insert Uses
-- Note: 'Use' is a reserved keyword in many SQL dialects.
-- If the table is indeed named 'Use', it might need quoting like "Use" or `Use` depending on the DB.
-- Here assuming standard behavior or H2 compatibility mode.
INSERT INTO use (start_date, finish_date, cost, bicycle_id, user_id, station_id) VALUES ('2024-01-01 10:00:00', '2024-01-01 10:30:00', 5.00, 1, 1, 1);
INSERT INTO use (start_date, finish_date, cost, bicycle_id, user_id, station_id) VALUES ('2024-01-02 11:00:00', '2024-01-02 11:45:00', 7.50, 3, 2, 2);
INSERT INTO use (start_date, finish_date, cost, bicycle_id, user_id, station_id) VALUES ('2024-01-03 09:00:00', '2024-01-03 09:15:00', 2.50, 5, 3, 4);