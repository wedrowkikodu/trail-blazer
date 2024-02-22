INSERT INTO travelers (id, name, email) VALUES (NEXTVAL('TRAVELER_SEQ'), 'John Doe', 'john.doe@example.com');

INSERT INTO trails (id, name, distance, difficulty) VALUES (NEXTVAL('TRAIL_SEQ'), 'Appalachian Trail', 2189, 'Difficult');
INSERT INTO trails (id, name, distance, difficulty) VALUES (NEXTVAL('TRAIL_SEQ'), 'Blue Ridge Mountains', 469, 'Moderate');

INSERT INTO travel_logs (id, date, notes, trail_id, traveler_id) VALUES (NEXTVAL('travel_log_SEQ'), '2024-02-21 10:00:00', 'Visited Blue Ridge Mountains.', 1, 1);
INSERT INTO travel_logs (id, date, notes, trail_id, traveler_id) VALUES (NEXTVAL('travel_log_SEQ'), '2024-02-22 10:00:00', 'Visited Grand Canyon.', 1, 1);