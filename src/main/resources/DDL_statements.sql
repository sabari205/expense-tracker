CREATE TABLE IF NOT EXIST expenses (
	id SERIAL PRIMARY KEY,
	description VARCHAR(50),
	spenton DATE NOT NULL,
	amount NUMERIC(10,3) NOT NULL,
	username VARCHAR(20) NOT NULL
);

INSERT INTO expenses (description, spenton, amount, username) VALUES ('Tea', TO_DATE('2023-05-31', 'YYYY-MM-DD'), 36, 'Sabari');
INSERT INTO expenses (description, spenton, amount, username) VALUES ('Soap', TO_DATE('2023-05-31', 'YYYY-MM-DD'), 67, 'Sabari');
INSERT INTO expenses (description, spenton, amount, username) VALUES ('Tea', TO_DATE('2023-05-31', 'YYYY-MM-DD'), 54, 'Sabari');
INSERT INTO expenses (description, spenton, amount, username) VALUES ('Groceries', TO_DATE('2023-05-31', 'YYYY-MM-DD'), 103, 'Sabari');
INSERT INTO expenses (description, spenton, amount, username) VALUES ('Tea', TO_DATE('2023-06-07', 'YYYY-MM-DD'), 78.16, 'Sabari');
INSERT INTO expenses (description, spenton, amount, username) VALUES ('Lunch', TO_DATE('2023-06-09', 'YYYY-MM-DD'), 300, 'Sabari');
INSERT INTO expenses (description, spenton, amount, username) VALUES ('Dinner', TO_DATE('2023-05-14', 'YYYY-MM-DD'), 55, 'Sabari');