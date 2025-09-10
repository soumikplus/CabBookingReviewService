CREATE TABLE driver (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_at datetime(6) NOT NULL,
    update_at datetime(6) NOT NULL,
    license_number VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id),
    CONSTRAINT UK_driver_license UNIQUE (license_number)
);

CREATE TABLE passenger (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_at datetime(6) NOT NULL,
    update_at datetime(6) NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE booking (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_at datetime(6) NOT NULL,
    update_at datetime(6) NOT NULL,
    start_time datetime(6),
    end_time datetime(6),
    total_distance BIGINT,
    booking_status VARCHAR(50),
    driver_id BIGINT,
    passenger_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_booking_driver FOREIGN KEY (driver_id) REFERENCES driver (id),
    CONSTRAINT fk_booking_passenger FOREIGN KEY (passenger_id) REFERENCES passenger (id)
);

CREATE TABLE reviews (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_at datetime(6) NOT NULL,
    update_at datetime(6) NOT NULL,
    content VARCHAR(1000),
    rating DOUBLE NOT NULL,
    booking_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT UK_reviews_booking UNIQUE (booking_id),
    CONSTRAINT fk_reviews_booking FOREIGN KEY (booking_id) REFERENCES booking (id)
);

CREATE TABLE passenger_review (
    id BIGINT NOT NULL,
    passenger_review_content TEXT NOT NULL,
    passenger_rating VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_passenger_review_review FOREIGN KEY (id) REFERENCES reviews (id)
);
