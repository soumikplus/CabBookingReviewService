-- Insert sample drivers
INSERT INTO driver (created_at, update_at, license_number, name)
VALUES (NOW(), NOW(), 'DL1234', 'John Doe'),
       (NOW(), NOW(), 'DL5678', 'Jane Smith');

-- Insert sample passengers
INSERT INTO passenger (created_at, update_at, name)
VALUES (NOW(), NOW(), 'Alice'),
       (NOW(), NOW(), 'Bob');

-- Insert sample booking
INSERT INTO booking (id, created_at, update_at, booking_status, start_time, end_time, total_distance, driver_id, passenger_id)
VALUES
  (1, NOW(), NOW(), 'CONFIRMED', NOW(), NULL, 15, 1, 1),
  (2, NOW(), NOW(), 'CONFIRMED', NOW(), NULL, 25, 2, 2);

-- Insert sample review
INSERT INTO reviews (created_at, update_at, content, rating, booking_id)
VALUES (NOW(), NOW(), 'Great ride', 4.5, 1);
