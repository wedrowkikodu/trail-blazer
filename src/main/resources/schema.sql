CREATE SEQUENCE traveler_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE trail_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE travel_log_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE landmark_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE travelers (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS trails (
  id INT PRIMARY KEY,
  name VARCHAR(64),
  distance INT NOT NULL,
  difficulty VARCHAR(16)
);

CREATE TABLE travel_logs (
  id INT PRIMARY KEY,
  date TIMESTAMP NOT NULL,
  notes VARCHAR(255),
  trail_id INT NOT NULL,
  traveler_id INT NOT NULL,
  FOREIGN KEY (trail_id) REFERENCES trails(id),
  FOREIGN KEY (traveler_id) REFERENCES travelers(id)
);

CREATE TABLE IF NOT EXISTS Landmarks (
    id INT PRIMARY KEY,
    name VARCHAR(64),
    description VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE,
    trail_id INT,
    FOREIGN KEY (trail_id) REFERENCES trails(id)
);

